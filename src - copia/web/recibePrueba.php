<?php
header("Content-Type: text/html;charset=ISO-8859-1");
include("./ConexionConsulta.php");

$datos = $_POST['datos'];
unset($respuesta);
foreach ($datos as $dato){
 $respuesta .= "Documento seleccionado:".utf8_decode($dato['documento'])." Fecha: ".$dato['fecha'];
}
echo $respuesta;
?>