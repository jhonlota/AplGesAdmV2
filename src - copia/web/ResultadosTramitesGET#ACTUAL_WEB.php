<?php
$fktercero = $_POST['fktercero'];
/*$fktercero = $_GET['fktercero'];   */
?>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/template_table.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function openPDF(file) {
                windows.open(file, 'resizable,scrollbars');
            }
        </script>
    </head>
    <body>
            <?php @session_start(); ?> 
            <?php
            include ("conexionAGA.php");

            try {
                if (empty($fktercero)) {
                    echo "<div class=\"titulo_medio\"><strong>El campo de cedula es vacio</strong></div>";
                } else {
                    try {
                        $gbd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                        $gbd->beginTransaction();

                        $bEstado = true;
                        $i = 0;

                        foreach ($gbd->query("SELECT * FROM CONTRATOS "
                                . "WHERE "
                                . "FKTERCERO LIKE '" . $fktercero . " - %'")as $row) {

                            if ($i == 0) {
                                echo "<br /><div class=\"datagrid\"> \n";
                                echo "<table> \n";
                                echo "<thead> \n";
                                echo "<tr> \n";
                                echo "<th>CONTRATO</th> \n";
                                echo "<th>OBJETO DEL CONTRATO</th> \n";
                                echo "<th>VALOR</th> \n";
                                echo "</tr> \n";
                                echo "</thead>";
                                echo "<tbody>";
                            }

                            if (($i % 2) == 0) {
                                $class_tr = " class=\"alt\"";
                            } else {
                                $class_tr = "";
                            }

                            echo "<tr$class_tr> \n";
                            echo "<td>" . $row["contrato"] . "</td> \n";
                            echo "<td>" . $row["objeto"] . "</td> \n";
                            echo "<td style=\"text-align: right;\">" . number_format($row["valor"]) . "</td> \n";
                            echo "</tr> \n";

                            $bEstado = false;
                            $i++;
                        }

                        echo "</tbody>";
                        echo "</table> \n";
                        echo "</div> \n";

                        if ($bEstado) {
                            
                        } else {

                            echo "</tbody>";
                            echo "</table> \n";
                        }
                    } catch (Exception $e) {
                        $gbd->rollBack();
                        $codigomensaje = "" . $e->getCode();

                        echo "<div class=\"titulo_medio\"><strong>Error al visualizar la informaci&oacute;n</strong></div><br/>" .
                        "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                    }
                    
                    try {
                        $bEstado = true;
                        $i = 0;

                        foreach ($gbd->query("SELECT * FROM COMPROBANTES "
                                . "WHERE "
                                . "FKTERCERO LIKE '" . $fktercero . " - %' ORDER BY FECHAELABORACION DESC, ID DESC")as $row) {

                            if ($i == 0) {
                                echo "<br /><div class=\"datagrid\"> \n";
                                echo "<table> \n";
                                echo "<thead> \n";
                                echo "<tr> \n";
                                echo "<th>COMPROBANTE</th> \n";
                                echo "<th>A&Ntilde;O</th> \n";
                                echo "<th>OBSERVACI&Oacute;N AL PAGO</th> \n";
                                echo "<th>VALOR</th> \n";
                                echo "</tr> \n";
                                echo "</thead>";
                                echo "<tbody>";
                            }

                            if (($i % 2) == 0) {
                                $class_tr = " class=\"alt\"";
                            } else {
                                $class_tr = "";
                            }

                            echo "<tr$class_tr> \n";
                            echo "<td>" . $row["id"] . "</td> \n";
                            echo "<td style=\"text-align: center;\">" . $row["ano"] . "</td> \n";
                            echo "<td>" . $row["observacion"] . "</td> \n";
                            echo "<td style=\"text-align: right;\">" . number_format($row["valor"]) . "</td> \n";
                            echo "</tr> \n";

                            $bEstado = false;
                            $i++;
                        }

                        if ($bEstado) {
                            
                        } else {

                            echo "</tbody>";
                            echo "</table> \n";
                            echo "</div> \n";
                        }
                    } catch (Exception $e) {
                        $gbd->rollBack();
                        $codigomensaje = "" . $e->getCode();

                        echo "<div class=\"titulo_medio\"><strong>Error al visualizar la informaci&oacute;n</strong></div><br/>" .
                        "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                    }

                    

                    try {
                        $bEstado = true;
                        $i = 0;

                        foreach ($gbd->query("SELECT * FROM TERCEROSRESOLUCION "
                                . "WHERE "
                                . "FKTERCERO LIKE '" . $fktercero . " - %' ORDER BY ano, fkresolucion DESC")as $row) {

                            if ($i == 0) {
                                echo "<br /><div class=\"datagrid\"> \n";
                                echo "<table> \n";
                                echo "<thead> \n";
                                echo "<tr> \n";
                                echo "<th>RESOLUCION</th> \n";
                                echo "<th>A&Ntilde;O</th> \n";
                                echo "<th>OBJETIVO</th> \n";
                                echo "<th>VALOR</th> \n";
                                echo "</tr> \n";
                                echo "</thead>";
                                echo "<tbody>";
                            }

                            if (($i % 2) == 0) {
                                $class_tr = " class=\"alt\"";
                            } else {
                                $class_tr = "";
                            }

                            echo "<tr$class_tr> \n";
                            echo "<td>" . $row["fkresolucion"] . "</td> \n";
                            echo "<td style=\"text-align: center;\">" . $row["ano"] . "</td> \n";
                            echo "<td>" . $row["objetivo"] . "</td> \n";
                            echo "<td style=\"text-align: right;\">" . number_format($row["valor"]) . "</td> \n";
                            echo "</tr> \n";

                            $bEstado = false;
                            $i++;
                        }

                        echo "</tbody>";
                        echo "</table> \n";
                        echo "</div> \n";

                        if ($bEstado) {
                            
                        } else {

                            echo "</tbody>";
                            echo "</table> \n";
                        }
                    } catch (Exception $e) {
                        $gbd->rollBack();
                        $codigomensaje = "" . $e->getCode();

                        echo "<div class=\"titulo_medio\"><strong>Error al visualizar la informaci&oacute;n</strong></div><br/>" .
                        "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                    }
                    
                    try {
                        $bEstado = true;
                        $i = 0;

                        foreach ($gbd->query("SELECT * FROM CUENTAS "
                    . "WHERE "
                    . "FKTERCERO LIKE '" . $fktercero . " - %'")as $row) {

                            if ($i == 0) {
                                echo "<br /><div class=\"datagrid\"> \n";
                                echo "<table> \n";
                                echo "<thead> \n";
                                echo "<tr> \n";
                                echo "<th>CUENTA</th> \n";
                                echo "<th>DESCRIPCION DEL PAGO</th> \n";
                                echo "<th>INGRESO</th> \n";
                                echo "<th>EGRESO</th> \n";
                                echo "</tr> \n";
                                echo "</thead>";
                                echo "<tbody>";
                            }

                            if (($i % 2) == 0) {
                                $class_tr = " class=\"alt\"";
                            } else {
                                $class_tr = "";
                            }

                            echo "<tr$class_tr> \n";
                            echo "<td>" . $row["soporte"] . "</td> \n";
                            echo "<td>" . $row["descripcion"] . "</td> \n";
                            echo "<td style=\"text-align: right;\">" . number_format($row["ingreso"]) . "</td> \n";
                            echo "<td style=\"text-align: right;\">" . number_format($row["egreso"]) . "</td> \n";
                            echo "</tr> \n";

                            $bEstado = false;
                            $i++;
                        }

                        echo "</tbody>";
                        echo "</table> \n";
                        echo "</div> \n";

                        if ($bEstado) {
                            
                        } else {

                            echo "</tbody>";
                            echo "</table> \n";
                        }
                    } catch (Exception $e) {
                        $gbd->rollBack();
                        $codigomensaje = "" . $e->getCode();

                        echo "<div class=\"titulo_medio\"><strong>Error al visualizar la informaci&oacute;n</strong></div><br/>" .
                        "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                    }
                }
            } catch (Exception $e) {
                $codigomensaje = "" . $e->getCode();

                echo "<div class=\"titulo_medio\"><strong>Error ingresar</strong></div><br/>" .
                "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                die();
            }
            ?>
        </div>
        <br/>
        <div class="datagrid">
            <?php
            include ("conexionAGA.php");

            if (empty($fktercero)) {
                
            } else {
                try {
                    $gbd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                    $gbd->beginTransaction();

                    foreach ($gbd->query("SELECT ID, NOMBRE FROM TERCEROS WHERE ID LIKE '$fktercero%'")as $row) {
                        echo "<span><strong>NUMERO DOCUMENTO IDENTIDAD : </strong>" . $row["id"] . "</b><span><br/> \n";
                        echo "<span><strong>NOMBRE COMPLETO : </strong>" . $row["nombre"] . "</b><span><br/> \n";
                    }
                } catch (Exception $e) {
                    $codigomensaje = "" . $e->getCode();

                    echo "<div class=\"titulo_medio\"><strong>Error ingresar</strong></div><br/>" .
                    "<div class=\"titulo_pequeno\"><strong>" . $e->getCode() . "</strong> " . $e->getMessage() . "</div><br/>";
                    die();
                }
            }

            die();
            $gbd = null;
            unset($_SESSION);
            session_destroy();
            ?>
        </div>
    </body>
</html>