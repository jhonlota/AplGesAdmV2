<?php
header("Content-Type: text/html; charset=ISO-8859-1");
include("./ConexionConsulta.php");
require_once('./upload/upload.php');

$opcion = $_POST['opcion'];
$fktercero = $_POST['fktercero'];
$documento = utf8_decode($_POST['documento']);
$fecha = $_POST['fecha'];
$indice = $_POST['indice'];

unset($htmlError);
unset($htmlOk);

$tabla = "anexosterceros (documento,fecha, fktercero, archivo, descripcion)";
$archivo = "";
if($opcion == "documentoindividual"){
    $archivo = "archivo";
}elseif ($opcion == "documentogeneral") {
    $archivo = "archivogeneral";
}
//$htmlError .= "[ OPCION = $opcion - ";
//$htmlError .= "TERCERO = $fktercero - ";
//$htmlError .= "DOCUMENTO = $documento - ";
//$htmlError .= "FECHA = $fecha - ";
//$htmlError .= "ARCHIVO = $file ]";

if (!empty($_FILES[''.$archivo]['name'])) {
    try {
        $status = "";
        $upload = new Upload();
        $upload->setPath("upload/files");
        $upload->setFile("$archivo", $fktercero, $fecha);
        $upload->isImage(false);
        $upload->save();
        $status = $upload->message;
//        $htmlError .= "STATUS ? ->$status \n";
//        $htmlError .= "IS UPLOAD ? ->$upload->isupload \n";
        if ($upload->isupload) {
//            $htmlError .= "Dentro del IF \n";
            try {
                $nombreArchivo = $upload->getNewFile();

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
                    $htmlOk = $documento;
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
                    $htmlOk = $documento;
                }
            } catch (Exception $ex) {
                $gbd->rollBack();
                $htmlError .= "Error -> $ex -> Cod =" . $ex->getCode();
            }
        }
    } catch (Exception $ex) {
        $htmlError .= "Error Subiendo Archivo: " . $ex->getCode() . " - " . $ex->getMessage();
    }
} else {
    $htmlError .= "No ha Seleccionado ning&uacute;n Archivo Correspondiente a: " . $documento;
}
$arr = array("htmlError" => utf8_encode($htmlError), "htmlOk" => utf8_encode($htmlOk), "indice" => $indice);
echo json_encode($arr);
?>