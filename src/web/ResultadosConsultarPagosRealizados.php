<?php

header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$fktercero = $_POST['fktercero'];

unset($divtercero);
unset($tabla1);
unset($tabla2);
unset($tabla3);
unset($sVer);

if ($fktercero == "") {
    $divtercero = "<script type=\"text/javascript\">
                    funMensaje(\"Favor diligencie la informacion COMPLETAMENTE\");
            </script>";
} else {
    try {
        $resultTercero = pg_query($gbd, "SELECT ID, NOMBRE FROM TERCEROS WHERE ID LIKE '$fktercero%'");
        $rowTercero = pg_fetch_array($resultTercero, NULL, PGSQL_ASSOC);
        if(pg_num_rows($resultTercero) == 0){
            $divtercero .= "<script type=\"text/javascript\">
                            funMensaje(\"La consulta NO arrojo resultados\");
                    </script>";
        }
        
        $divtercero .= "<div class=\"well\"><strong>NUMERO DOCUMENTO IDENTIDAD : </strong>" . $rowTercero["id"] . "<br/>";
        $divtercero .= "<strong>NOMBRE COMPLETO : </strong>" . $rowTercero["nombre"] . "</div>";
        $tercero = $rowTercero["id"] . " - " . $rowTercero["nombre"];
        $divtercero .= "<input id=\"tercero\" type=\"hidden\" value=\"$tercero\">";

        $tabla1 = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Contrato</th>
                                <th>Objeto del Contrato</th>
                                <th>Valor</th>
                                <th>Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultContratos = pg_query($gbd, "SELECT * FROM CONTRATOS WHERE FKTERCERO LIKE '$fktercero%'");
        if(pg_num_rows($resultContratos) === 0){
            $tabla1 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <a class=\"alert-link\" href=\"#\">$tercero</a> , NO tiene Contratos Registrados.
                        </div>";
        }
        while ($rowContratos = pg_fetch_array($resultContratos, NULL, PGSQL_ASSOC)) {
            $sVer = "";
            $sVer .= (empty($rowContratos["secopnumeroconstancia"])) ? "<span class=\"label label-danger\"> - </span>" : "<button id=\"ver$i\" type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"window.open('https://www.contratos.gov.co/consultas/detalleProceso.do?numConstancia=" . $rowContratos["secopnumeroconstancia"] . "')\" formtarget=\"_blank\">VER EN SECOP</button>";
            $tabla1 .= "<tr>";
            $tabla1 .= "<td>" . $rowContratos["contrato"] . "</td>";
            $tabla1 .= "<td>" . $rowContratos["objeto"] . "</td>";
            $tabla1 .= "<td>" . $rowContratos["valor"] . "</td>";
            $tabla1 .= "<td>" . $sVer . "</td>";
            $tabla1 .= "</tr>";   
            $i++;
        }

        $tabla2 = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Cuenta</th>
                                <th>Descripci&oacute;n del Pago</th>
                                <th>Ingreso</th>
                                <th>Egreso</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultCuentas = pg_query($gbd, "SELECT * FROM CUENTAS WHERE FKTERCERO LIKE '$fktercero%'");
        if(pg_num_rows($resultCuentas) === 0){
            $tabla2 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <a class=\"alert-link\" href=\"#\">$tercero</a> , NO tiene Cuentas Registradas.
                        </div>";
            
        }
        while ($rowCuentas = pg_fetch_array($resultCuentas, NULL, PGSQL_ASSOC)) {
            $tabla2 .= "<tr>";
            $tabla2 .= "<td>" . $rowCuentas["cuenta"] . "</td>";
            $tabla2 .= "<td>" . $rowCuentas["descripcion"] . "</td>";
            $tabla2 .= "<td>" . $rowCuentas["ingreso"] . "</td>";
            $tabla2 .= "<td>" . $rowCuentas["egreso"] . "</td>";
            $tabla2 .= "</tr>";
            $i++;
        }

        $tabla3 = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Comprobante</th>
                                <th>Año</th>
                                <th>Observaci&oacute;n al pago</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultComprobantes = pg_query($gbd, "SELECT * FROM COMPROBANTES WHERE FKTERCERO LIKE '$fktercero%' ORDER BY FECHAELABORACION DESC, ID DESC");
        if(pg_num_rows($resultCuentas) === 0){
            $tabla3 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <a class=\"alert-link\" href=\"#\">$tercero</a> , NO tiene Comprobantes Registrados.
                        </div>";
            
        }
        while ($rowComprobantes = pg_fetch_array($resultComprobantes, NULL, PGSQL_ASSOC)) {
            $tabla3 .= "<tr>";
            $tabla3 .= "<td>" . $rowComprobantes["comprobante"] . "</td>";
            $tabla3 .= "<td>" . $rowComprobantes["ano"] . "</td>";
            $tabla3 .= "<td>" . $rowComprobantes["observacion"] . "</td>";
            $tabla3 .= "<td>" . $rowComprobantes["valor"] . "</td>";
            $tabla3 .= "</tr>";
            $i++;
        }
        $tabla1 .= "</tbody>
                        </table>
                            </div>";
        $tabla2 .= "</tbody>
                        </table>
                            </div>";
        $tabla3 .= "</tbody>
                        </table>
                            </div>";
    } catch (Exception $ex) {
        pg_query("ROLLBACK");
        $tabla1 = "<script type=\"text/javascript\">
                    funMensaje(\"Error al visualizar la infromaci&oacute;n : " . $e->getCode() . "</strong> " . $e->getMessage() . "\");
            </script>";
        $arr = array("tabla1" => utf8_encode($tabla1));
        echo json_encode($arr);
    }
}

$arr = array("tabla1" => utf8_encode($tabla1),
    "tabla2" => utf8_encode($tabla2),
    "tabla3" => utf8_encode($tabla3),
    "divtercero" => utf8_encode($divtercero));
echo json_encode($arr);
?>