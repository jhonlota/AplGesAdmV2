<?php

header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$fktercero = $_POST['fktercero'];

unset($divtercero);
unset($tabla1);
unset($tabla2);
unset($tabla3);
unset($sVer);
unset($sSoporte);
unset($sPago);

if ($fktercero == "") {
    $divtercero = "<script type=\"text/javascript\">
                    funMensaje(\"Favor diligencie la informacion COMPLETAMENTE\");
            </script>";
} else {
    try {
        $resultTercero = pg_query($gbd, "SELECT ID, NOMBRE FROM TERCEROS WHERE ID LIKE '$fktercero%'");
        $rowTercero = pg_fetch_array($resultTercero, NULL, PGSQL_ASSOC);
        if (pg_num_rows($resultTercero) == 0) {
            $divtercero .= "<script type=\"text/javascript\">
                            funMensaje(\"La consulta NO arrojo resultados\");
                    </script>";
        }

        $divtercero .= "<div class=\"well\"><strong>NUMERO DOCUMENTO IDENTIDAD : </strong>" . $rowTercero["id"] . "<br/>";
        $divtercero .= "<strong>NOMBRE COMPLETO : </strong>" . $rowTercero["nombre"] . "</div>";
        $tercero = $rowTercero["id"] . " - " . $rowTercero["nombre"];
        $divtercero .= "<input id=\"tercero\" type=\"hidden\" value=\"$tercero\">";

        $tabla1 = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline\" id=\"DataTables_Table_0\" aria-describedby=\"DataTables_Table_0_info\" role=\"grid\">
                        <thead>
                            <tr role=\"row\">
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Nro.</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Contrato</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Objeto del Contrato</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Valor</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Acci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultContratos = pg_query($gbd, "SELECT * FROM CONTRATOS WHERE FKTERCERO LIKE '$fktercero%' ORDER BY FECHASUSCRIPCION DESC");
        if (pg_num_rows($resultContratos) === 0) {
            $tabla1 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <strong>$fktercero</strong>, NO tiene Contratos Registrados.
                        </div>";
        }
        while ($rowContratos = pg_fetch_array($resultContratos, NULL, PGSQL_ASSOC)) {
            $i++;
            $sVer = "";
            $sVer .= (empty($rowContratos["secopnumeroconstancia"])) ? "<span class=\"label label-danger\"> - </span>" : "<button id=\"ver$i\" type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"window.open('https://www.contratos.gov.co/consultas/detalleProceso.do?numConstancia=" . $rowContratos["secopnumeroconstancia"] . "')\" formtarget=\"_blank\">VER EN SECOP</button>";

            $tabla1 .= "<tr class=\"gradeA odd\" role=\"row\">";
            $tabla1 .= "<td class=\"sorting_1\" tabindex=\"0\" >" . $i . "</td>";
            $tabla1 .= "<td class=\"sorting_1\" tabindex=\"0\" >" . $rowContratos["contrato"] . "</td>";
            $tabla1 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $rowContratos["objeto"] . "</td>";
            $tabla1 .= "<td class=\"sorting_1\" tabindex=\"0\" style=\"text-align: right\">" . number_format($rowContratos["valor"], 0, ',', '.') . "</td>";
            $tabla1 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $sVer . "</td>";
            $tabla1 .= "</tr>";
        }

        $tabla2 = "<div class=\"table-responsiv\">
                    <table table class=\"table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline\" id=\"DataTables_Table_0\" aria-describedby=\"DataTables_Table_0_info\" role=\"grid\">
                        <thead>
                            <tr role=\"row\">
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Nro.</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Cuenta</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Descripci&oacute;n del Pago</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Ingreso</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Egreso</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultCuentas = pg_query($gbd, "SELECT * FROM CUENTAS WHERE FKTERCERO LIKE '$fktercero%' ORDER BY FECHADIGITACION DESC");
        if (pg_num_rows($resultCuentas) === 0) {
            $tabla2 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <strong>$fktercero</strong>, NO tiene Cuentas Registradas.
                        </div>";
        }
        while ($rowCuentas = pg_fetch_array($resultCuentas, NULL, PGSQL_ASSOC)) {
            $i++;
            $sSoporte = "";
            $sSoporte .= $rowCuentas["soporte"] === "0" ? "<span class=\"label label-danger\"> NO PAGO </span>" : "" . $rowCuentas["soporte"];

            $tabla2 .= "<tr class=\"gradeA odd\" role=\"row\">";
            $tabla2 .= "<td class=\"sorting_1\" tabindex=\"0\" >" . $i . "</td>";
            $tabla2 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $sSoporte . "</td>";
            $tabla2 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $rowCuentas["descripcion"] . "</td>";
            $tabla2 .= "<td class=\"sorting_1\" tabindex=\"0\" style=\"text-align: right\">" . number_format($rowCuentas["ingreso"], 0, ',', '.') . "</td>";
            $tabla2 .= "<td class=\"sorting_1\" tabindex=\"0\" style=\"text-align: right\">" . number_format($rowCuentas["egreso"], 0, ',', '.') . "</td>";
            $tabla2 .= "</tr>";
        }

        $tabla3 = "<div class=\"table-responsiv\">
                    <table table class=\"table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline\" id=\"DataTables_Table_0\" aria-describedby=\"DataTables_Table_0_info\" role=\"grid\">
                        <thead>
                            <tr>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Nro.</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">A&ntilde;o</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Comprobante</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Observaci&oacute;n al pago</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">Valor</th>
                            </tr>
                        </thead>
                        <tbody>";

        $i = 0;
        $resultComprobantes = pg_query($gbd, "SELECT * FROM COMPROBANTES WHERE FKTERCERO LIKE '$fktercero%' ORDER BY ANO DESC, COMPROBANTE DESC");
        if (pg_num_rows($resultComprobantes) === 0) {
            $tabla3 = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            El Tercero <strong>$fktercero</strong>, NO tiene Comprobantes Registrados.
                        </div>";
        }
        while ($rowComprobantes = pg_fetch_array($resultComprobantes, NULL, PGSQL_ASSOC)) {
            $i++;
            $sPago = "";
            $sPago .= $rowComprobantes["comprobante"] === "0" ? "<span class=\"label label-danger\"> NO PAGO </span>" : "" . $rowComprobantes["comprobante"];

            $tabla3 .= "<td class=\"sorting_1\" tabindex=\"0\" >" . $i . "</td>";
            $tabla3 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $rowComprobantes["ano"] . "</td>";
            $tabla3 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $sPago . "</td>";
            $tabla3 .= "<td class=\"sorting_1\" tabindex=\"0\">" . $rowComprobantes["observacion"] . "</td>";
            $tabla3 .= "<td class=\"sorting_1\" tabindex=\"0\"  style=\"text-align: right\">" . number_format($rowComprobantes["valor"], 0, ',', '.') . "</td>";
            $tabla3 .= "</tr>";
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