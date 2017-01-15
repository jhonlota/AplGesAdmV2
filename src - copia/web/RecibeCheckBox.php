<?php
header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$documentos = $_POST['listaValoresCheckboxes'];
unset($respuesta);
foreach ($documentos as $documento){
 $respuesta .= "Documento seleccionado:".$documento;
}
echo $respuesta;
//echo $tabla2;

$parametro = $_POST['parametro'];
unset($html);

$html = "<div class=\"i-checks\">
                        <label>
                            <div class=\"icheckbox_square-green\" style=\"position: relative;\">
                                <input id=\"documento\" name=\"documento\" type=\"checkbox\" value=\"documento\" style=\"position: absolute; opacity: 0;\">
                                <ins class=\"iCheck-helper\" style=\"position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;\"></ins>
                            </div> 
                            <i></i>Documento
                        </label>
                    </div>
        <button id=\"revisar\" name=\"revisar\" type=\"button\">Revisar</button>
                    ";

$html .= " <script type=\"text/javascript\">
                                                $('#revisar').click(function(event) {
                                                    if ($(\"#documento\").is(':checked')) {
                                                        alert(\"Está activado\");
                                                    } else {
                                                        alert(\"No está activado\");
                                                    }
                                                });</script>";
echo $html;
?>