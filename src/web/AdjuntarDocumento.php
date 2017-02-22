<?php

header("Content-Type: text/html;charset=utf-8");
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
if ($opcion == "documentoindividual") {
    $archivo = "archivo";
} elseif ($opcion == "documentogeneral") {
    $archivo = "archivogeneral";
}
if (!empty($_FILES['' . $archivo]['name'])) {
    try {
        $cedulaTercero = sanear_string(substr($fktercero, 0, strpos($fktercero, " - ")));
        $nombreDocumento = strtoupper(sanear_string(utf8_encode($documento)));
        $fechaDocumento = sanear_string($fecha);

        $status = "";
        $upload = new Upload();
        $upload->setPath("../../../../UmVbZxut/archivos");
        $upload->setFile("$archivo", $cedulaTercero, $nombreDocumento, $fechaDocumento);
        $upload->save();
        $status = $upload->message;
//        $htmlError .= "[STATUS = ->$status ]\n";
//        $htmlError .= "[IS UPLOAD = ->$upload->isupload ]\n";
//        $htmlError .= "[NOMBRE = ->$upload->newfile ]\n";
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
        } else {
            $htmlError .= "$status";
        }
    } catch (Exception $ex) {
        $htmlError .= "Error Subiendo Archivo: " . $ex->getCode() . " - " . $ex->getMessage();
    }
} else {
    $htmlError .= "No ha Seleccionado ning&uacute;n Archivo Correspondiente a: " . $documento;
}
$arr = array("htmlError" => utf8_encode($htmlError), "htmlOk" => utf8_encode($htmlOk), "indice" => $indice);
echo json_encode($arr);

function sanear_string($string) {
    $string = trim($string);
    $string = str_replace(
            array("á", "é", "í", "ó", "ú", "ñ", " ", "(", ")", "-"), array("a", "e", "i", "o", "u", "n", "", "", "", ""), $string
    );
    $string = str_replace(
            array('é', 'è', 'ë', 'ê', 'É', 'È', 'Ê', 'Ë'), array('e', 'e', 'e', 'e', 'E', 'E', 'E', 'E'), $string
    );
    $string = str_replace(
            array('í', 'ì', 'ï', 'î', 'Í', 'Ì', 'Ï', 'Î'), array('i', 'i', 'i', 'i', 'I', 'I', 'I', 'I'), $string
    );
    $string = str_replace(
            array('ó', 'ò', 'ö', 'ô', 'Ó', 'Ò', 'Ö', 'Ô'), array('o', 'o', 'o', 'o', 'O', 'O', 'O', 'O'), $string
    );
    $string = str_replace(
            array('ú', 'ù', 'ü', 'û', 'Ú', 'Ù', 'Û', 'Ü'), array('u', 'u', 'u', 'u', 'U', 'U', 'U', 'U'), $string
    );
    $string = str_replace(
            array('ñ', 'Ñ', 'ç', 'Ç'), array('n', 'N', 'c', 'C',), $string
    );
    $string = str_replace(
            array(' ', '(', ')'), array('', '', ''), $string
    );
    return $string;
}
