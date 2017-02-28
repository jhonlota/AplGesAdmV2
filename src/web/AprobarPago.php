<?php

header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$id = $_POST['id'];
$comentario = $_POST['comentario'];
$formadepago = $_POST['formadepago'];
unset($htmlError);
unset($htmlOk);

if ($formadepago == "Seleccione" || $formadepago == "Aprobacion") {
    $htmlError .= "<script type=\"text/javascript\">
                        funMensaje(\"Debe Seleccionar una Forma de Pago V&aacute;lida (Fondo Renovable, Caja Menor, Anulado)\");
                   </script>";
} else {
    try {
        pg_query($gbd, "UPDATE comprobantes SET tipopago = '$formadepago', observacion = '$comentario' WHERE id = $id");
        $htmlOk = "<p>Registro Actualizado <strong>Exitosamente</strong></p>";
    } catch (Exception $ex) {
        pg_query("ROLLBACK");
        $htmlError .= "<script type=\"text/javascript\">
                    funMensaje(\"Error al realizar la Acci&oacute;n : " . $ex->getCode() . "</strong> " . $ex->getMessage() . "\");
            </script>";

        $arr = array("htmlError" => utf8_encode($htmlError), "htmlOk" => utf8_encode($htmlOk));
        echo json_encode($arr);
    }
}



$arr = array("htmlError" => utf8_encode($htmlError), "htmlOk" => utf8_encode($htmlOk));
echo json_encode($arr);
