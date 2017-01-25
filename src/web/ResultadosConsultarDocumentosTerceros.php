<?php
header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$fktercero = $_POST['fktercero'];
$persona = $_POST['persona'];

unset($divtercero);
unset($tabla1);
unset($tabla2);
unset($tabla3);
unset($sVer);
unset($sDias);
unset($isConsulta);

$hoy = date("d-m-Y");

if (empty($fktercero) || empty($persona)) {
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
        
        $tabla1 .= "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Documento</th>
                                <th>Fecha</th>
                                <th>Dias</th>
                            </tr>
                        </thead>
                        <tbody>";
        $tabla2 = "<div class=\"table-responsiv\">
                            <table class=\"table table-striped\" >
                                <tbody>";
        $tabla3 = "<form id=\"formdocumentogeneral\" class=\"form-horizontal\" enctype=\"multipart/form-data\">";
        $tabla3 .= "<div class=\"table-responsiv\">
                    <table class=\"table table-striped\" >
                        <thead>
                            <tr>
                                <th>Documento</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tbody>";
        $i = 0;
        $result = pg_query($gbd, "SELECT *, (CURRENT_DATE - FECHA) AS total FROM "
                . "(SELECT * FROM VERIFICAANEXOSTERCEROS WHERE $persona = TRUE) AS A LEFT JOIN "
                . "(SELECT DOCUMENTO, MAX(FECHA) AS FECHA FROM ANEXOSTERCEROS WHERE FKTERCERO LIKE '$fktercero%' GROUP BY DOCUMENTO) AS B "
                . "ON A.VERIFICA = B.DOCUMENTO ORDER BY VERIFICA");

        while ($row = pg_fetch_array($result, NULL, PGSQL_ASSOC)) {
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
                $resultContratos = pg_query($gbd, "SELECT ARCHIVO "
                        . "FROM ANEXOSTERCEROS "
                        . "WHERE FKTERCERO LIKE '$fktercero%' AND "
                        . "DOCUMENTO = '" . $row["verifica"] . "' AND "
                        . "FECHA = CAST('$fecha' AS DATE)");

                while ($rowAux = pg_fetch_array($resultContratos, NULL, PGSQL_ASSOC)) {
                    $sVer = "<button id=\"ver$i\" type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"window.open('http:$servidor/UmVbZxut/archivos/" . $rowAux["archivo"] . "')\" formtarget=\"_blank\">VER</button>";
                }
            }
            $tabla1 .= "<tr>";
            $tabla1 .= "<td id=\"documento$i\">" . $row["verifica"] . " " . $sVer . "</td>";
            $tabla1 .= (empty($fecha)) ? "<td id=\"fecha$i\" style=\"text-align: center;\"><span class=\"label label-danger\">NO ADJUNTO</span></td>" : "<td id=\"fecha$i\" style=\"text-align: center;\">" . $fecha . "</td>";
            $tabla1 .= (empty($fecha)) ? "<td id=\"dias$i\" style=\"text-align: center;\"><span class=\"badge badge-danger\">0</span></td>" : "<td id=\"dias$i\" style=\"text-align: center;\">" . $sDias . "</td>";
            $tabla1 .= "</tr>";


            $tabla2 .= "<tr>";
            $tabla2 .= "<td><label>" . $row["verifica"] . "</label></td>";

            $tabla2 .= "<td>";
            $tabla2 .= "<form class = \"form-horizontal\" id=\"form$i\" enctype=\"multipart/form-data\">";
            $tabla2 .= "<table>
                            <tr>
                                <td>
                                    <div class=\"input-group date datepicker\">
                                        <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span><input id=\"fechadoc$i\" name=\"fechadoc$i\" type=\"text\" class=\"form-control\" value=\"$hoy\">
                                    </div>
                                </td>
                                <td>
                                    <div class=\"fileinput fileinput-new\" data-provides=\"fileinput\">
                                        <span class=\"btn btn-default btn-file btn-sm\"><span class=\"fileinput-new\">Selecionar Archivo</span>
                                        <span class=\"fileinput-exists input-sm\">Cambiar Archivo</span><input class=\"input-sm\" type=\"file\" name=\"archivo\" id=\"archivo\"/></span>
                                        <span class=\"fileinput-filename input-sm\"></span>
                                        <a href=\"#\" class=\"close fileinput-exists input-sm\" data-dismiss=\"fileinput\" style=\"float: none\">&#215;</a>
                                    </div>
                                </td>
                                <td><button id=\"subir$i\" class=\"btn btn-primary btn-xs\" type=\"submit\" style=\"max-width:40px\">Subir</button></td>
                            </tr>
                       </table>";
            $tabla2 .= "</form>";
            $tabla2 .= "</td>";
            $tabla2 .= "</tr>";
            $tabla2 .= " <script type=\"text/javascript\">
                            $('#form$i').submit(function(event) {
                                event.preventDefault();
                                var fechadoc = $('#fechadoc$i').val();
                                if(fechadoc === ''){
                                    funMensaje('Debe Seleccionar una Fecha de Expedición Válida para el Documento: ".$row["verifica"]."');
                                }else{
                                    var opcion = 'documentoindividual';
                                    var fktercero = $('#tercero').val();
                                    var documento = '" . $row["verifica"] . "';
                                    var fecha = fechadoc;
                                    var formElement = document.getElementById('form$i');
                                    var formData = new FormData(formElement); 
                                    formData.append(\"opcion\", opcion);
                                    formData.append(\"fktercero\", fktercero);
                                    formData.append(\"documento\", documento);
                                    formData.append(\"fecha\", fecha);
                                    jQuery.ajax({
                                        url: 'AdjuntarDocumento.php',
                                        type: 'POST',
                                        data: formData,
                                        mimeType: \"multipart/form-data\",
                                        contentType: false,
                                        dataType: 'html',
                                        cache: false,
                                        processData: false, 
                                        beforeSend: function() {
                                            $('#informacion').hide();
                                            $('#informacion').html('');
                                            $('#error').hide();
                                            $('#error').html('');
                                            $('#subir$i').hide();
                                        },
                                        success: function(response) {
                                            var json_obj = $.parseJSON(response);
                                            var error = json_obj.htmlError;
                                            var ok = json_obj.htmlOk;
                                            if(error === ''){
                                                $('#subir$i').show();
                                                $('#informacion').append(\"Documento subido con &Eacute;xito\").show().fadeOut(5000);
                                                $('#ver$i').attr(\"onClick\", \"window.open('http:$servidor/UmVbZxut/archivos/\"+ok+\"')\");
                                                $('#fecha$i').html('<span class=\"label label-primary\">EN PROCESO</span>');
                                                $('#dias$i').html('<span class=\"badge badge-primary\"> - </span>');
                                            }else{
                                                $('#error').html(''+error).show().fadeOut(5000);
                                                $('#subir$i').show();
                                            }

                                        }
                                    });
                                }
                                
                            });
                            </script>";

            $tabla3 .= "<tr>
                <td>
                    <div class=\"i-checks\">
                        <label>
                            <div class=\"icheckbox_square-green\" style=\"position: relative;\">
                                <input id=\"checkdocumento$i\" name=\"checkdocumento$i\" type=\"checkbox\" value=\"" . $row["verifica"] . "\" style=\"position: absolute; opacity: 0;\">
                                <ins class=\"iCheck-helper\" style=\"position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;\"></ins>
                            </div> 
                            <i></i>" . $row["verifica"] . "
                        </label>
                    </div>
                </td>
                <td>
                    <div class=\"input-group date datepicker\">
                        <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span><input id=\"fechadocumento$i\" name=\"fechadocumento$i\" type=\"text\" class=\"form-control\" value=\"$hoy\">
                    </div>
                </td>
            </tr>
            ";
            $isConsulta = false;
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

        $tabla3 .= "<div class=\"row\">
                            <div class=\"col-sm-12\">
                                <div class=\"fileinput fileinput-new\" data-provides=\"fileinput\">
                                    <span class=\"btn btn-default btn-file btn-sm\"><span class=\"fileinput-new\">Selecionar Archivo</span>
                                        <span class=\"fileinput-exists input-sm\">Cambiar Archivo</span><input class=\"input-sm\" type=\"file\" name=\"archivogeneral\" id=\"archivogeneral\"/></span>
                                    <span class=\"fileinput-filename input-sm\"></span>
                                    <a href=\"#\" class=\"close fileinput-exists input-sm\" data-dismiss=\"fileinput\" style=\"float: none\">&#215;</a>
                                </div>
                                <button id=\"subirdocumentogeneral\" class=\"btn btn-primary btn-sm\" type=\"submit\">Subir</button>
                            </div>
                        </div>
                        <input id=\"cantidad\" name=\"cantidad\" type=\"hidden\" value=\"$i\">
                    </form>";

        $tabla3 .= "<script type=\"text/javascript\">
                            $(\"#formdocumentogeneral\").submit(function(event) {
                                event.preventDefault();
                                var cantidad = $('#cantidad').val();
                                var archivogeneral = $('#archivogeneral').val();
                                var mensaje = '';
                                if (archivogeneral === '') {
                                    funMensaje('Por favor Seleccione el Archivo Correspondiente');
                                } else {
                                    var arreglo = new Array();
                                    for (i = 0; i < cantidad; i++) {
                                        if ($('#checkdocumento' + i).prop('checked')) {
                                            if ($('#fechadocumento' + i).val() !== '') {   
                                                var objeto = new Object();
                                                objeto.documento = $('#checkdocumento' + i).val();
                                                objeto.fecha =  $('#fechadocumento' + i).val();
                                                objeto.indice = i;
                                                arreglo.push(objeto);
                                            } else {
                                                mensaje = mensaje + $('#checkdocumento' + i).val() + ' \\n';
                                            }
                                        }
                                    }
                                    if(mensaje !== ''){
                                        var encabezado = 'Por favor Indique la Fecha de Expedición de los Documentos: \\n';
                                        funMensaje(''+decodeURIComponent(escape(encabezado))+mensaje);
                                    }
                                    
                                    for (arr in arreglo) {
                                        var opcion = 'documentogeneral';
                                        var fktercero = $('#tercero').val();
                                        var documento = arreglo[arr].documento;
                                        var fecha = arreglo[arr].fecha;
                                        var indice = arreglo[arr].indice;
                                        var formElement = document.getElementById('formdocumentogeneral');
                                        var formData = new FormData(formElement);
                                        formData.append(\"opcion\", opcion);
                                        formData.append(\"fktercero\", fktercero);
                                        formData.append(\"documento\", documento);
                                        formData.append(\"fecha\", fecha);
                                        formData.append(\"indice\", indice);
                                        jQuery.ajax({
                                            url: 'AdjuntarDocumento.php',
                                            type: 'POST',
                                            data: formData,
                                            mimeType: \"multipart/form-data\",
                                            contentType: false,
                                            dataType: 'html',
                                            cache: false,
                                            processData: false, 
                                            beforeSend: function() {
                                                $('#subirdocumentogeneral').hide();
                                            },
                                            success: function(response) {
                                                var json_obj = $.parseJSON(response);
                                                var error = json_obj.htmlError;
                                                var ok = json_obj.htmlOk;
                                                var indice = json_obj.indice;
                                                if(error === ''){
                                                    $('#subirdocumentogeneral').show();
                                                    $('#informaciondocumentogeneral').html(\"Documento subido con &Eacute;xito\").show().fadeOut(5000);
                                                    $('#ver'+indice).attr(\"onClick\", \"window.open('http:$servidor/UmVbZxut/archivos/\"+ok+\"')\");
                                                    $('#fecha'+indice).html('<span class=\"label label-primary\">EN PROCESO</span>');
                                                    $('#dias'+indice).html('<span class=\"badge badge-primary\"> - </span>');
                                                }else{
                                                    $('#errordocumentogeneral').html(''+error).show().fadeOut(5000);
                                                    $('#subirdocumentogeneral').show();
                                                }
                                            }
                                        });
                                    } 
                                }
                            });
                        </script>";

        if ($isConsulta) {
            $tabla1 .= "<script type=\"text/javascript\">
                            funMensaje(\"La consulta NO arrojo resultados\");
                    </script>";
        }
    } catch (Exception $ex) {
        pg_query("ROLLBACK");
        $tabla1 .= "<script type=\"text/javascript\">
                    funMensaje(\"Error al visualizar la infromaci&oacute;n : " . $e->getCode() . "</strong> " . $e->getMessage() . "\");
            </script>";
        $arr = array("tabla1" => utf8_encode($tabla1),
            "tabla2" => utf8_encode($tabla2),
            "tabla3" => utf8_encode($tabla3),);
        echo json_encode($arr);
    }
}

$arr = array("tabla1" => utf8_encode($tabla1),
    "tabla2" => utf8_encode($tabla2),
    "tabla3" => utf8_encode($tabla3),
    "divtercero" => utf8_encode($divtercero));
echo json_encode($arr);
?>