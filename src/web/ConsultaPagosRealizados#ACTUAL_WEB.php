<?php @session_start(); ?>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/template_css.css" rel="stylesheet" type="text/css"/>
        <link href="css/template_form.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="js/script.js"></script>  
    </head>
    <body>
        <br />
        <div class="content-module">

            <div class="content-module-heading cf">
                <h3 class="fl">Consulte los pagos realizados</h3>
            </div> <!-- end content-module-heading -->


            <div class="content-module-main cf">
                <form method="post" action="ConsultaPagosRealizados.php" name="consulta" enctype="multipart/form-data" >
                    <table class="gray" width="100%">
                        <tbody>
                            <tr>
                                <td>
                                    <label><strong>Digite su N&uacute;mero documento identidad : </strong></label><br />
                                    <input name="fktercero" id="fktercero" type="text" placeholder="Documento identidad"  size="38" value="<?php if (isset($_GET['fktercero'])) { echo $_GET['fktercero'];} ?>" required /><br /><br />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <div class="fr"><input name="enviar" type="submit" value="Consultar"  /></div>
                    <br />
                </form>
            </div> <!-- end content-module-main -->
        </div> <!-- end content-module -->
        <?php
        if ($_POST['enviar'] != "") {
            //include("CopiaResultados.php");
            
            include("ResultadosTramitesGET.php");
        }
        ?>
    </body>
</html>
