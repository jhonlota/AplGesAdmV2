<!DOCTYPE html>
<html>
    <head>
        <!--<meta charset="utf-8">-->
        <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Universidad del Valle</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
        <link href="css/plugins/dataTables/datatables.min.css" rel="stylesheet">
        <link href="css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
        <link href="css/plugins/iCheck/custom.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

<!--<script src="js/jquery-2.1.1.js"></script>-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <!--<script src="js/plugins/jeditable/jquery.jeditable.js"></script>-->

        <script src="js/plugins/sweetalert/sweetalert.min.js"></script>
        <script src="js/plugins/dataTables/datatables.min.js"></script>
        <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>
        <script src="js/plugins/iCheck/icheck.min.js"></script>


        <script src="js/inspinia.js"></script>
        <script src="js/plugins/pace/pace.min.js"></script>

        <script type="text/javascript">
            function funMensaje(texto) {
                swal({
                    title: "Aplicacion de Gestion Administrativa - AGA",
                    text: texto
                });
            }
        </script>

        <script>
            $(document).ready(function() {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
            });
        </script>
        <script>
            function funcion() {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
            }
        </script>
    </head>
    <body class="top-navigation">

        <div id="wrapper">
            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom white-bg">

                </div>
                <div class="wrapper wrapper-content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>CheckBoxes</h5>
                                    </div>
                                    <div id="contenido" class="ibox-content">
                                        <button id="enviar" name="enviar" type="button">Enviar</button>
                                        <script type="text/javascript">
                                            $(document).ready(function() {
                                                $('#enviar').click(function(event) {
                                                    event.preventDefault();
                                                    var parametro = "";
                                                    var parametros = {
                                                        'parametro': parametro
                                                    };
                                                    jQuery.ajax({
                                                        data: parametros,
                                                        url: 'RecibeCheckBox.php',
                                                        type: 'POST',
                                                        dataType: 'html',
                                                        beforeSend: function() {
                                                            console.log('Enviando... ... ...');
                                                        },
                                                        success: function(response) {
                                                            $('#contenido').html(response);
                                                            console.log('Resultado = ' + response);
                                                            funcion();
                                                        }
                                                    });
                                                });
                                            });</script>

<!--                                        <script type="text/javascript">
                                                $('#revisar').click(function(event) {
                                                    if ($("#documento").is(':checked')) {
                                                        alert("Está activado");
                                                    } else {
                                                        alert("No está activado");
                                                    }
                                                });</script>-->

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
    </body>
</html>
