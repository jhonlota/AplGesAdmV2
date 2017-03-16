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
        <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

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
        <script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>


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
            function checkbox() {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
            }
        </script>

        <script type="text/javascript">
            function datepicker() {
                $('.datepicker').datepicker({
                    format: "dd-mm-yyyy",
                    startDate: "01-01-2000",
                    clearBtn: true,
                    autoclose: true,
                    todayHighlight: true
                });
            }

        </script>

        <script type="text/javascript">
            function tabla() {
                $(document).ready(function () {
                    $('.dataTables-example').DataTable({
                        pageLength: 25,
                        responsive: true,
                        dom: '<"html5buttons"B>lTfgitp',
                        buttons: [
                            {extend: 'copy'},
                            {extend: 'excel', title: 'Reporte'},
                            {extend: 'pdf', title: 'Reporte'},
                            {extend: 'print',
                                customize: function (win) {
                                    $(win.document.body).addClass('white-bg');
                                    $(win.document.body).css('font-size', '10px');
                                    $(win.document.body).find('table')
                                            .addClass('compact')
                                            .css('font-size', 'inherit');
                                }
                            }
                        ]

                    });
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
                        <!--                        <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="ibox float-e-margins">
                                                            <div class="ibox-title">
                                                                <h5>Datos</h5>
                                                            </div>
                                                            <div class="ibox-content">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>-->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <script type="text/javascript">
                                            $(document).ready(function () {
                                                jQuery.ajax({
                                                    url: 'ResultadosVerificacinfocuentainterna.php',
                                                    type: 'POST',
                                                    mimeType: 'multipart/form-data',
                                                    contentType: false,
                                                    cache: false,
                                                    processData: false,
                                                    beforeSend: function () {
                                                        $('#tabla').html('');
                                                    },
                                                    success: function (response) {
                                                        var json_obj = $.parseJSON(response);
                                                        $('#tabla').html(json_obj.tabla);
                                                        checkbox();
                                                        datepicker();
                                                        tabla();
                                                    }
                                                });
                                            });
                                        </script>
                                        <h5>Listado de Verificacion de Centro Informacion >>> Cuenta Interna</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
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
