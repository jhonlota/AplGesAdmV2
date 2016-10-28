<?php

header("Content-Type: text/html;charset=ISO-8859-1");
$fktercero = $_POST['fktercero'];
$persona = $_POST['persona'];
include ("ConexionConsulta.php");

unset($html);
unset($sVer);
unset($sDias);
unset($isConsulta);

try {
    if (empty($fktercero) || empty($persona)) {
        $html .= "<script type=\"text/javascript\">
                    funMensaje(\"Favor diligencie la informacion COMPLETAMENTE\");
            </script>";
    } else {
        
        try {
            $gbd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $gbd->beginTransaction();
            $html = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Documento</th>
                                <th>Fecha</th>
                                <th>Dias</th>
                            </tr>
                        </thead>
                        <tbody>";

            foreach ($gbd->query("SELECT *, (CURRENT_DATE - FECHA) AS total FROM "
                    . "(SELECT * FROM VERIFICAANEXOSTERCEROS WHERE $persona = TRUE) AS A LEFT JOIN "
                    . "(SELECT DOCUMENTO, MAX(FECHA) AS FECHA FROM ANEXOSTERCEROS WHERE FKTERCERO LIKE '$fktercero%' GROUP BY DOCUMENTO) AS B "
                    . "ON A.VERIFICA = B.DOCUMENTO ORDER BY VERIFICA")as $row) {
                
                if (empty($row["documento"])) {
                    $sDias = "<span class=\"badge badge-danger\"> - </span>";
                } else if (empty($row["dias"])) {
                    $sDias = "<span class=\"badge badge-primary\">" . $row["total"] . "</span>";
                } else if ($row["total"] > $row["dias"]) {
                    $sDias = "<span class=\"badge badge-danger\">" . $row["total"] . "</span>";
                } else {
                    $sDias = "<span class=\"badge badge-primary\">" . $row["total"] . "</span>";
                }
                
                $fecha = $row["fecha"];
                $sVer = "";
                
                if (!empty($row["documento"])) {
                    foreach ($gbd->query("SELECT ARCHIVO "
                            . "FROM ANEXOSTERCEROS "
                            . "WHERE FKTERCERO LIKE '$fktercero%' AND "
                            . "DOCUMENTO = '" . $row["verifica"] . "' AND "
                            . "FECHA = CAST('$fecha' AS DATE)")as $rowAux) {
                        $sVer = "<button type=\"button\" class=\"btn btn-success btn-xs\" onclick=\"window.open('http://" + ClaseGeneral.servidor + "/UmVbZxut/archivos/" . $rowAux["archivo"] . "')\" formtarget=\"_blank\">VER</button>";
                    }
                }
                
                $html .= "<tr>";
                $html .= "<td>" . $row["verifica"] . " " . $sVer . "</td>";
                $html .=  (empty($fecha)) ? "<td style=\"text-align: center;\"><span class=\"label label-danger\">NO ADJUNTO</span></td>" : "<td style=\"text-align: center;\">" . $fecha . "</td>";
                $html .=  (empty($fecha)) ? "<td style=\"text-align: center;\"><span class=\"badge badge-danger\">0</span></td>" : "<td style=\"text-align: center;\">" . $sDias . "</td>";
                $html .= "</tr>";

                $isConsulta = false;
            }

            $html .= "</tbody>
                        </table>
                            </div>";

            foreach ($gbd->query("SELECT ID, NOMBRE FROM TERCEROS WHERE ID LIKE '$fktercero%'")as $row) {
                $html .= "<div class=\"well\"><strong>NUMERO DOCUMENTO IDENTIDAD : </strong>" . $row["id"] . "<br/>";
                $html .= "<strong>NOMBRE COMPLETO : </strong>" . $row["nombre"] . "</div>";
            }

            if ($isConsulta) {
                $html .= "<script type=\"text/javascript\">
                            funMensaje(\"La consulta NO arrojo resultados\");
                    </script>";
            }
        } catch (Exception $e) {
            $gbd->rollBack();
            $codigomensaje = "" . $e->getCode();
            
            $html .= "<script type=\"text/javascript\">
                    funMensaje(\"Error al visualizar la infromaci&oacute;n : " . $e->getCode() . "</strong> " . $e->getMessage() . "\");
            </script>";
            echo $html;
        }
        
//        die();
        $gbd = null;
    }
} catch (Exception $e) {
    $codigomensaje = "" . $e->getCode();

    $html .= "<script type=\"text/javascript\">
                    funMensaje(\"Error ingresar : " . $e->getCode() . "</strong> " . $e->getMessage() . "\");
            </script>";
    echo $html;
//    die();
}

echo $html;
?>