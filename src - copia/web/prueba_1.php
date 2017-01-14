<?php
header('Content-type: text/html; charset=utf-8');
//$json ='{"0":{"documento":"Boletín de responsables fiscales (1 mes) ","fecha":"28/09/2016"},"1":{"documento":"Certificado de antecedentes disciplinarios (3 meses) ","fecha":"26/10/2016"}}';
//$array = json_decode($json);

$array = json_decode($_POST['datos']);
print_r($array);
$respuesta = "";
$i="0";
$j="1";
$respuesta .= $array[0]->documento;
$respuesta .= $array[1]->documento;
//$respuesta = "";
//$respuesta .= $datos->$i->documento;
////foreach($datos as $key=>$value) {
////    $respuesta .= "".$array->$key->documento;
////}
echo "$respuesta";


?>