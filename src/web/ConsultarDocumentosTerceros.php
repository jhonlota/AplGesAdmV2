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
            $.fn.datepicker.dates['es'] = {
                days: ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
                daysShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
                daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
                months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
                today: "Hoy",
                clear: "Limpiar",
                format: "mm/dd/yyyy",
                titleFormat: "MM yyyy", /* Leverages same syntax as 'format' */
                weekStart: 0
            };
            
            function datepicker() {
                $('.datepicker').datepicker({
                    format: "dd-mm-yyyy",
                    startDate: "01-01-2000",
                    firstDay: 1,
                    todayBtn: "linked",
                    clearBtn: true,
                    autoclose: true,
                    todayHighlight: true,
                    language: "es",
                    setDate: new Date()
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
                                            <button class="btn btn-danger" type="submit">Consultar</button>
                                        </form>
                                        <div id="divtercero">

                                        </div>
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
                                                            $('#tabla1').html('');
                                                            $('#tabla2').html('');
                                                            $('#tabla3').html('');
                                                        },
                                                        success: function(response) {
                                                            var json_obj = $.parseJSON(response);
                                                            $('#divtercero').html(json_obj.divtercero);
                                                            $('#tabla1').html(json_obj.tabla1);
                                                            $('#tabla2').html(json_obj.tabla2);
                                                            $('#tabla3').html(json_obj.tabla3);
                                                            $('#filaresultados').show();
                                                            $('#filaadjuntarindividual').show();
                                                            $('#filaadjuntargeneral').show();
                                                            checkbox();
                                                            datepicker();
                                                        }
                                                    });
                                                });
                                            });</script>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" id="filaresultados" style="display: none">
                            <div class="col-lg-12">
                                <div class="ibox">
                                    <div class="ibox-title">
                                        <h5>Resultados - Documentos del Tercero</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div  id="tabla1" name="tabla1" class="ibox-content">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" id="filaadjuntarindividual" style="display: none">
                            <div class="col-lg-12">
                                <div class="ibox collapsed">
                                    <div class="ibox-title">
                                        <h5>Adjuntar Documentos del Tercero</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div id="informacion" class="alert alert-success" role="alert" style="display: none"></div>
                                    <div id="error" class="alert alert-danger" role="alert" style="display: none"></div>
                                    <div id="tabla2" name="tabla2" class="ibox-content" style="display: none;">

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" id="filaadjuntargeneral" style="display: none">
                            <div class="col-lg-12">
                                <div class="ibox collapsed">
                                    <div class="ibox-title">
                                        <h5>Adjuntar Documento General (Usar esta opci&oacute;n si el Tercero tiene todos los Documentos en un s&oacute;lo Archivo)</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div id="informaciondocumentogeneral" class="alert alert-success" role="alert" style="display: none"></div>
                                    <div id="tabla3" name="tabla3" class="ibox-content" style="display: none;">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
