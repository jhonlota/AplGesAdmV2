<?php

try {
    $gbd = new PDO('pgsql:host=192.168.248.206;port=5432;dbname=gestciencias', 'ciencias', 'C64Ng4ZO', array(PDO::ATTR_PERSISTENT => true));
} catch (Exception $e) {
    echo "<div>No se puede conectar al servidor</div><br/>
        <div>Favor intente mas adelante</div><br/>";
}
?>
