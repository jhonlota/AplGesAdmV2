<?php
include_once("../clases/config.con");

try{
    $gbd = pg_connect("host=$host dbname=$dbname user=$user password=$pass")
    or die('No se ha podido conectar: '. ($dbname) . '' . pg_last_error());
} catch (Exception $ex) {
    echo "<div>No se puede conectar al servidor</div><br/>
        <div>Favor intente mas adelante</div><br/>
        <div>ERROR = $ex</div>";
}

?>
