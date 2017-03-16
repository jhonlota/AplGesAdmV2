<?php

header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

unset($tabla);

try {
    $tabla = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline\" id=\"DataTables_Table_0\" aria-describedby=\"DataTables_Table_0_info\" role=\"grid\">
                        <thead>
                            <tr role=\"row\">
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">C. INFO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">C. INGRESO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">ACTIVIDAD</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">C. COSTOS</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">CUENTA INTERNA</th>
                            </tr>
                        </thead>
                        <tbody>";

    $result = pg_query($gbd, "SELECT verificacinfocuentainterna.*, cinfo.nombre AS cinfo_nombre, cuentainterna.nombre AS cuentainterna_nombre "
            . "FROM verificacinfocuentainterna "
            . "LEFT JOIN cinfo ON verificacinfocuentainterna.cinfo = cinfo.codigo "
            . "LEFT JOIN cuentainterna ON verificacinfocuentainterna.cuentainterna = cuentainterna.codigo "
            . "ORDER BY verificacinfocuentainterna.cinfo");
    if (pg_num_rows($result) === 0) {
        $tabla = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            No EXISTE informacion.
                        </div>";
    }

//    $cinfoAuxInicial = "";
    while ($row = pg_fetch_array($result, NULL, PGSQL_ASSOC)) {
//        $cinfoAux = $row["cinfo"];
//
//        $result2 = pg_query($gbd, "SELECT COUNT(cinfo) AS cinfo "
//                . "FROM verificacinfocuentainterna "
//                . "WHERE cinfo = '$cinfoAux'");
//
//        while ($row2 = pg_fetch_array($result2, NULL, PGSQL_ASSOC)) {
//            $rowspan = $row2["cinfo"];
//        }
//        if ($cinfoAuxInicial == $cinfoAux) {
//            $tabla .= "<tr class=\"gradeA odd\" role=\"row\">";
//            $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["cingreso"] . "</td>";
//            $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["actividad"] . "</td>";
//            $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["ccostos"] . "</td>";
//            $tabla .= "<td class=\"sorting_1\" tabindex=\"0\"><strong>" . $row["cuentainterna"] . "</strong> <br/><small>" . $row["cuentainterna_nombre"] . "</small></td>";
//        } else {
        $tabla .= "<tr class=\"gradeA odd\" role=\"row\">";
        $tabla .= "<td rowspan=\"$rowspan\" class=\"sorting_1\" tabindex=\"0\"><strong>" . $row["cinfo"] . "</strong> - " . $row["cinfo_nombre"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["cingreso"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["actividad"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["ccostos"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\"><strong>" . $row["cuentainterna"] . "</strong> <br/><small>" . $row["cuentainterna_nombre"] . "</small></td>";

//            $cinfoAuxInicial = $cinfoAux;
//        }
    }

    $tabla .= "</tbody>
                        </table>
                            </div>";
} catch (Exception $ex) {
    pg_query("ROLLBACK");
    $tabla = "<script type=\"text/javascript\">
                    funMensaje(\"Error al visualizar la informaci&oacute;n : " . $e->getCode() . "</strong> " . $e->getMessage() . "\");
            </script>";
    $arr = array("tabla" => utf8_encode($tabla));
    echo json_encode($arr);
}


$arr = array("tabla" => utf8_encode($tabla));
echo json_encode($arr);
?>