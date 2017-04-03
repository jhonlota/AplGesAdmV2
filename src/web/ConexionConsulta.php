<?php

/**///IMPORTANTE
$host = "192.168.131.52";
$dbname = "gest_ciencias";
$user = "aga_ciencias";
$pass = "AgA_CnS.hmcx36874";
$servidor = "//ingenieria.univalle.edu.co/facultadweb2/aga_ciencias/datos";

/**///IMPORTANTE
//$host = "192.168.131.52";
//$dbname = "gest_ingenieria";
//$user = "aga_ingenieria";
//$pass = "AgA_InG.Ktec871";
//$servidor = "//ingenieria.univalle.edu.co/facultadweb2/aga_ingenieria/datos";

try {
    $gbd = pg_connect("host=$host dbname=$dbname user=$user password=$pass")
            or die('No se ha podido conectar: ' . ($dbname) . '' . pg_last_error());
} catch (Exception $ex) {
    echo "<div>No se puede conectar al servidor</div><br/>
        <div>Favor intente mas adelante</div><br/>
        <div>ERROR = $ex</div>";
}
?>