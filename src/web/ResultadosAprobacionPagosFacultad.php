<?php

header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$key = $_POST['key'];

unset($tabla);

if ($key == "1krTnVYOGe-uFKJFG0i_xyts9Vdcaj_sEmqUOGQ_j0h0") {
    
} else {
    $tabla = "<script type=\"text/javascript\">
                    funMensaje(\"NO posee privilegios para visualizar la informaci&oacute;n\");
            </script>";
    $arr = array("tabla" => utf8_encode($tabla));
    echo json_encode($arr);
}

try {
    $tabla = "<div class=\"table-responsiv\">
                    <table class=\"table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline\" id=\"DataTables_Table_0\" aria-describedby=\"DataTables_Table_0_info\" role=\"grid\">
                        <thead>
                            <tr role=\"row\">
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">ID</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">TERCERO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">VALOR</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">FUNCIONARIO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">OBSERVACION</th>
                            </tr>
                        </thead>
                        <tbody>";

    $result = pg_query($gbd, "SELECT * FROM COMPROBANTES WHERE tipopago = 'Aprobacion'");
    if (pg_num_rows($result) === 0) {
        $tabla = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            No EXISTE informacion.
                        </div>";
    }

    while ($row = pg_fetch_array($result, NULL, PGSQL_ASSOC)) {
        $tabla .= "<tr class=\"gradeA odd\" role=\"row\">";
        $tabla .= "<td rowspan=\"$rowspan\" class=\"sorting_1\" tabindex=\"0\"><strong>" . $row["id"] . "</strong></td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["fktercero"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["valor"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["fktercerofuncionario"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\"><small>" . $row["observacion"] . "</small></td>";
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