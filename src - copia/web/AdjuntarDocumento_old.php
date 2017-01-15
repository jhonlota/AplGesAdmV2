<?php
header("Content-Type: text/html;charset=ISO-8859-1");
include_once("./ConexionConsulta.php");
require_once('./upload/upload.php');

$fktercero = $_POST['fktercero'];
$documento = utf8_decode($_POST['documento']);
$fecha = $_POST['fechaexpedicion'];
$datos = json_decode($_POST['datos']);
$opcion = $_POST['opcion'];
$file = $_FILES['archivo']['name'];

global $htmlError, $htmlOk, $gbd, $tabla;
unset($htmlError);
unset($htmlOk);
$tabla = "anexosterceros (documento,fecha, fktercero, archivo, descripcion)";
//$htmlError = "OPCION = $opcion";
if ($opcion == "documentoindividual") {
    subirArchivo($documento, $fktercero, $fecha);
} else if ($opcion == "documentogeneral") {
    if (!empty($datos)) {
        foreach ($datos as $key=>$dato) {
            $htmlError .= "DOCUMENTO = ".utf8_decode($dato->documento);
            subirArchivo(utf8_decode($dato->documento), $fktercero, $dato->fecha);
        }
    }
}

function subirArchivo($documento, $fktercero, $fecha) {
    global $htmlError, $htmlOk;
    if (!empty($_FILES['archivo']['name'])) {
        try {
            $status = "";
            $upload = new Upload();
            $upload->setPath("upload/files");
            $upload->setFile("archivo", $fktercero, $fecha);
            $upload->isImage(false);
            $upload->save();
            $status = $upload->message;
            $txt = "[$fktercero - $fecha - " . $upload->getNewFile() . "]";
            if ($upload->isupload) {
                $htmlError .= "SUBIDO -STATUS =>$status $txt /// ";
                guardarAnexoBD($documento, $fktercero, $fecha, $upload->getNewFile());
            } else {
                $htmlError .= "NO SUBIDO -STATUS =>$status $txt /// ";
            }
        } catch (Exception $ex) {
            $htmlError .= "Error Subiendo Archivo: " . $ex->getCode() . " - " . $ex->getMessage();
        }
    } else {
        $htmlError .= "No ha Seleccionado ning&uacute;n Archivo Correspondiente a: " . $documento;
    }
}

function guardarAnexoBD($documento, $fktercero, $fecha, $nombreArchivo) {
    global $htmlError, $htmlOk, $gbd, $tabla;
    try {
        $consulta = "SELECT * FROM anexosterceros "
                . "WHERE documento = '$documento' "
                . "AND (SELECT ('$fecha'::timestamp::date - fecha::timestamp::date)) = 0 "
                . "AND fktercero = '$fktercero'";

        $result = pg_query($gbd, $consulta);

        if (pg_num_rows($result) == 0) {
            //insert
            $insert = "INSERT INTO $tabla VALUES ("
                    . "'$documento', "
                    . "'$fecha', "
                    . "'$fktercero', "
                    . "'$nombreArchivo', "
                    . "'')";
            
            $result = pg_query($gbd, $insert);
            if (!$result) {
                $htmlError .= "Error Guardando en la Base de Datos - " . pg_last_error();
            }
            $htmlOk = $nombreArchivo;
        } else {
            //update
            $update = "UPDATE anexosterceros SET "
                    . "fecha = '$fecha', "
                    . "archivo = '$nombreArchivo', "
                    . "descripcion = '' "
                    . "WHERE documento = '$documento' "
                    . "AND fktercero = '$fktercero' "
                    . "AND fecha = '$fecha'";
            $result = pg_query($gbd, $update);
            if (!$result) {
                $htmlError .= "Error Actualizando en la Base de Datos - " . pg_last_error();
            }
            $htmlOk = $nombreArchivo;
        }
    } catch (Exception $ex) {
        $gbd->rollBack();
        $htmlError .= "Error -> $ex -> Cod =" . $ex->getCode();
    }
}

$arr = array("htmlError" => utf8_encode($htmlError), "htmlOk" => utf8_encode($htmlOk));
echo json_encode($arr);
?>