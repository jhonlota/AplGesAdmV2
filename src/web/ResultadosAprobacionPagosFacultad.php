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
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">OBSERVACI&Oacute;N</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">FORMA DE PAGO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">COMENTARIO</th>
                                <th class=\"sorting_asc\" tabindex=\"0\" aria-controls=\"DataTables_Table_0\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"Rendering engine: activate to sort column descending\">ACCI&Oacute;N</th>
                            </tr>
                        </thead>
                        <tbody>";

    $i = 0;
    $result = pg_query($gbd, "SELECT * FROM COMPROBANTES WHERE tipopago LIKE '%Aprobacion%' AND ano = '2017'");
    if (pg_num_rows($result) === 0) {
        $tabla = "<div class=\"alert alert-info alert-dismissable\">
                            <button aria-hidden=\"true\" data-dismiss=\"alert\" class=\"close\" type=\"button\">&#215;</button>
                            No EXISTE informaci&oacute;n.
                        </div>";
    }

    while ($row = pg_fetch_array($result, NULL, PGSQL_ASSOC)) {
        $tabla .= "<tr class=\"gradeA odd\" role=\"row\" id=\"fila$i\">";
        $tabla .= "<td rowspan=\"$rowspan\" class=\"sorting_1\" tabindex=\"0\"><strong>" . $row["id"] . "</strong></td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["fktercero"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["valor"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">" . $row["fktercerofuncionario"] . "</td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\"><small><span id=\"observacion$i\" name=\"observacion$i\">" . $row["observacion"] . "</span></small></td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">
                    <select class=\"form-control input-sm\" id=\"formadepago$i\" name=\"formadepago$i\">
                        <option value=\"Seleccione\">SELECCIONE...</option>
                        <option value=\"Aprobacion\">APROBACI&Oacute;N</option>
                        <option value=\"Fondo Renovable\">FONDO RENOVABLE</option>
                        <option value=\"Caja Menor\">CAJA MENOR</option>
                        <option value=\"Anulado\">ANULADO</option>
                    </select>
                </td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">
                        <textarea id=\"comentario$i\" class=\"form-control\" rows=\"2\"></textarea>
                    </td>";
        $tabla .= "<td class=\"sorting_1\" tabindex=\"0\">
                        <button id=\"actualizar$i\" name=\"actualizar$i\" class=\"btn btn-primary btn-xs\" type=\"submit\">Actualizar</button>
                        <div id=\"informacion$i\" class=\"alert alert-success\" role=\"alert\" style=\"display: none\"></div>
                        <div id=\"error$i\" class=\"alert alert-success\" role=\"alert\" style=\"display: none\"></div>
                    </td>";
        $tabla .= "</tr>";

        $tabla .= " <script type=\"text/javascript\">
                        $('#actualizar$i').click(function() {
                            console.log('Clic en Actualizar'+$('#actualizar$i').attr('name'));
                            event.preventDefault();
                                
                            if($('#comentario$i').val() == '') {
                                var comentario = '';
                                var observacion = $('#observacion$i').html();
                            } else {
                                var comentario = ' [' + $('#comentario$i').val().toUpperCase() + ']';
                                var observacion = $('#observacion$i').html();
                            }
                            
                            var id = '" . $row["id"] . "';
                            var ano = '" . $row["ano"] . "';
                            var formadepago = $('#formadepago$i').val();                            
                            var parametros = {
                                'comentario': comentario,
                                'observacion': observacion,
                                'id': id,
                                'ano': ano,
                                'formadepago': formadepago
                            };
                            jQuery.ajax({
                                url: 'AprobarPago.php',
                                type: 'POST',
                                data: parametros,
                                dataType: 'html',
                                beforeSend: function() {
                                    $('#informacion$i').html('');
                                    $('#informacion$i').hide();
                                    $('#error$i').html('');
                                    $('#actualizar$i').hide();
                                },
                                success: function(response) {
                                    var json_obj = $.parseJSON(response);
                                    var error = json_obj.htmlError;
                                    var ok = json_obj.htmlOk;
                                    if(error === ''){
                                        $('#informacion$i').html(ok);
                                        $('#informacion$i').fadeIn(3000);
                                        $('#fila$i').fadeOut(6000);
                                    }else{
                                        $('#error$i').html(error);
                                        $('#actualizar$i').show();
                                    }
                                }    
                            });
                        });
                        </script>";
        $i++;
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