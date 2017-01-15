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

        <script src="js/inspinia.js"></script>
        <script src="js/plugins/pace/pace.min.js"></script>
        <script type="text/javascript">
//            $(document).ready(function() {
                function funMensaje(texto) {
                    swal({
                        title: "Aplicacion de Gestion Administrativa - AGA",
                        text: texto
                    });
                }
//            });
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
                                        <h5>Datos del Tercero</h5>
                                    </div>
                                    <div class="ibox-content">
                                        <form class="form-horizontal" id="form">
                                            <div class="form-group">
                                                <label class="col-lg-2 control-label">Documento de Identidad</label>
                                                <div class="col-lg-10">
                                                    <input name="fktercero" id="fktercero" type="text"  class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-2 control-label">Tipo de Regimen</label>
                                                <div class="col-lg-10">
                                                    <select name="persona" id="persona" class="form-control m-b" >
                                                        <option value="" >Seleccione</option>
                                                        <option value="personanatural" >R&eacute;gimen Simplificado</option>
                                                        <option value="personajuridica" >R&eacute;gimen Com&uacute;n</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <button class="btn btn-white" type="submit">Consultar</button>
                                        </form>
                                        <script type="text/javascript">
                                            $(document).ready(function() {
                                                $('#form').submit(function(event) {
                                                    event.preventDefault();
                                                    var fktercero = $('#fktercero').val();
                                                    var persona = $('#persona').val();
                                                    var parametros = {
                                                        'fktercero': fktercero,
                                                        'persona': persona
                                                    };
                                                    jQuery.ajax({
                                                        data: parametros,
                                                        url: 'ResultadosConsultarDocumentosTerceros.php',
                                                        type: 'POST',
                                                        dataType: 'html',
                                                        beforeSend: function() {
                                                            $('#tabla').html('');
                                                        },
                                                        success: function(response) {
                                                            $('#tabla').html(response);
                                                        }
                                                    });
                                                });
                                            });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox">
                                    <div class="ibox-title">
                                        <h5>Resultados - Documentos del Tercero</h5>
                                    </div>
                                    <div  id="tabla" name="tabla" class="ibox-content">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
