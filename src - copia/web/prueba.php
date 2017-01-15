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

        <script type="text/javascript">
            $(document).ready(function() {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('.datepicker').datepicker({
                    format: "dd/mm/yyyy",
                    startDate: "01/01/2000",
                    clearBtn: true,
                    autoclose: true,
                    todayHighlight: true
                });

            });
        </script>
    </head>
    <body>
        <form id="formdocumentogeneral" class="form-horizontal">
            <table>
                <thead>
                    <tr>
                        <th>Documento0</th>
                        <th>Documento1</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div class="i-checks">
                                <label>
                                    <div class="icheckbox_square-green" style="position: relative;">
                                        <input id="documento0" name="documento0" type="checkbox" value="Bolet&iacute;n de responsables fiscales (1 mes)" style="position: absolute; opacity: 0;">
                                        <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                    </div> 
                                    <i></i> Bolet&iacute;n de responsables fiscales (1 mes) 
                                </label>
                            </div>


                        </td>

                        <td>
                            <div class="i-checks">
                                <label>
                                    <div class="icheckbox_square-green" style="position: relative;">
                                        <input id="documento1" name="documento1" type="checkbox" value="Documento 1" style="position: absolute; opacity: 0;">
                                        <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                    </div> 
                                    <i></i>Documento 1
                                </label>
                            </div>
                        </td>

                        <td>
                            <div class="input-group date datepicker">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="fechadocumento0" name="fechadocumento0" type="text" class="form-control" value="<?php echo date('d-m-Y'); ?>">
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="row">
                <div class="col-sm-10">
                    <div class="fileinput fileinput-new" data-provides="fileinput">
                        <span class="btn btn-default btn-file btn-sm"><span class="fileinput-new">Selecionar</span>
                            <span class="fileinput-exists input-sm">Cambiar</span><input class="input-sm" type="file" name="archivogeneral" id="archivogeneral"/></span>
                        <span class="fileinput-filename input-sm"></span>
                        <a href="#" class="close fileinput-exists input-sm" data-dismiss="fileinput" style="float: none">&#215;</a>
                    </div>
                </div>
                <div class="col-sm-">
                    <button class="btn btn-danger btn-sm" type="submit">Adjuntar</button>
                </div>
            </div>

            <div class="ibox collapsed">
                <div class="ibox-title">
                    <h5>Example of initial collapsed panel</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#">Config option 1</a>
                            </li>
                            <li><a href="#">Config option 2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content" style="display: none;">

                    <p>
                        Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. </p>
                    <p>
                        Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi.
                    </p>
                </div>
            </div>


        </form>
        <div class="i-checks">
            <label>
                <div class="icheckbox_square-green" style="position: relative;">
                    <input id="documento2" name="documento2" type="checkbox" value="Constancia afiliación a seguridad social " style="position: absolute; opacity: 0;">
                    <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                </div> 
                <i></i>Constancia afiliación a seguridad social
            </label>
        </div>


        <div class="input-group date datepicker">
            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="fechadocumento2" name="fechadocumento2" type="text" class="form-control" value="2016-10-04">
        </div>

        <input type="checkbox" name="vehicle" value="Bike">



        <script type="text/javascript">
            $("#formdocumentogeneral").submit(function(event) {
                event.preventDefault();
                var cantidad = 2;
                var archivogeneral = $('#archivogeneral').val();
                console.log('archivo = ' + archivogeneral);
                if ($('#documento0').is(':checked')) {
                    alert('Está activado documento 0');
                } else {
                    alert('No está activado documento 0');
                }
                if ($('#documento1').is(':checked')) {
                    alert('Está activado documento 1');
                } else {
                    alert('No está activado documento 1');
                }
                if (archivogeneral === '') {
                    funMensaje('Por favor Seleccione el Archivo Correspondiente');
                } else {
                    var datos = {};

                    for (i = 0; i < cantidad; i++) {
                        if ($('#documento' + i).prop('checked')) {
                            if ($('#fechadocumento' + i).val() !== "") {
                                datos[i] = {documento: $('#documento' + i).val(), fecha: $('#fechadocumento' + i).val()};
                            } else {
                                console.log('Debe Indicar la Fecha de Expedición del Documento ' + $('#documento' + i).val());
                            }
                        }
                    }
                    for (dato in datos) {
                        var msg = 'Documento =  ' + datos[dato].documento + 'Fecha = ' + datos[dato].fecha;
                        console.log(msg);
                    }
                    var parametros = {
                        'datos': datos
                    };
                    jQuery.ajax({
                        data: parametros,
                        url: 'recibePrueba.php',
                        type: 'POST',
                        dataType: 'html',
                        beforeSend: function() {
                            console.log('enviando...');
                        },
                        success: function(response) {
                            console.log('Respuesta = ' + response);
                        }
                    });

                }
            });
        </script>

        <button id="button" class="btn btn-danger" type="button">Enviar</button>
        <div id="div">

        </div>
        <script type="text/javascript">
            $("#button").click(function(event) {
                event.preventDefault();
                var variable = "";
                var parametros = {
                    'variable': variable
                };
                jQuery.ajax({
                    data: parametros,
                    url: 'recibePrueba.php',
                    type: 'POST',
                    dataType: 'html',
                    beforeSend: function() {
                        console.log('enviando...');
                    },
                    success: function(response) {
                        $('#div').html(response);
                        console.log('Respuesta = ' + response);
                    }
                });
            });
        </script>

<!--<div class="datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom" style="display: block; top: 1808px; left: 265px; z-index: 10;"><div class="datepicker-days" style="display: block;"><table class=" table-condensed"><thead><tr><th class="cw">&nbsp;</th><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">March 2014</th><th class="next" style="visibility: visible;">»</th></tr><tr><th class="cw">&nbsp;</th><th class="dow">Su</th><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th></tr></thead><tbody><tr><td class="cw">9</td><td class="old day">23</td><td class="old day">24</td><td class="old day">25</td><td class="old day">26</td><td class="old day">27</td><td class="old day">28</td><td class="day">1</td></tr><tr><td class="cw">10</td><td class="day">2</td><td class="day">3</td><td class="active day">4</td><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td></tr><tr><td class="cw">11</td><td class="day">9</td><td class="day">10</td><td class="day">11</td><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td></tr><tr><td class="cw">12</td><td class="day">16</td><td class="day">17</td><td class="day">18</td><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td></tr><tr><td class="cw">13</td><td class="day">23</td><td class="day">24</td><td class="day">25</td><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td></tr><tr><td class="cw">14</td><td class="day">30</td><td class="day">31</td><td class="new day">1</td><td class="new day">2</td><td class="new day">3</td><td class="new day">4</td><td class="new day">5</td></tr></tbody><tfoot><tr><th colspan="8" class="today" style="display: table-cell;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datepicker-months" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">2014</th><th class="next" style="visibility: visible;">»</th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Feb</span><span class="month active">Mar</span><span class="month">Apr</span><span class="month">May</span><span class="month">Jun</span><span class="month">Jul</span><span class="month">Aug</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody><tfoot><tr><th colspan="8" class="today" style="display: table-cell;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datepicker-years" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">2010-2019</th><th class="next" style="visibility: visible;">»</th></tr></thead><tbody><tr><td colspan="7"><span class="year old">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year active">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year new">2020</span></td></tr></tbody><tfoot><tr><th colspan="8" class="today" style="display: table-cell;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div></div>-->
    </body>
</html>
