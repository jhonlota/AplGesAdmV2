/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseInformacion {

    public static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat formatoFechaExportar = new SimpleDateFormat("MM/yy");
    public static DecimalFormat formatoDecimal = new DecimalFormat("#,###,###");
    public static DecimalFormat formatoEntero = new DecimalFormat("#######");
    public DefaultTableCellRenderer modeloDerecha = new DefaultTableCellRenderer();
    public static Calendar calendario;

    public static SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    public ClaseInformacion() {
        calendario = Calendar.getInstance();
        modeloDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    public static String ConvertirHora(Date hora) {
        String cadena = formatoHora.format(hora);
        return cadena;
    }

    public static Date ConvertirHora(String cadena) {

        try {
            Date hora = (Date) formatoHora.parse(cadena);
            return hora;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String ConvertirFecha(Date fecha) {
        String cadena = formatoFecha.format(fecha);
        return cadena;
    }

    public static Date ConvertirFecha(String cadena) {
        try {
            Date fecha = formatoFecha.parse(cadena);
            return fecha;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String ConvertirFechaExportar(Date fecha) {
        String cadena = formatoFechaExportar.format(fecha);
        return cadena;
    }

    public static String ConvertirStringAFecha(String fecha) {
        String texto;
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(3, 5);
        String anho = fecha.substring(6, 10);

        texto = anho + "-" + mes + "-" + dia;
        return texto;
    }

    public static long LongAletario() {
        return (long) (Math.random() * 999999 + 111111);
    }

    public static String ObtenerIP() throws UnknownHostException {
        String IP = "";
        @SuppressWarnings("UnusedAssignment")
        InetAddress address = InetAddress.getByName("localhost");

        address = InetAddress.getLocalHost();
        byte[] bytes = address.getAddress();
        for (int cnt = 0; cnt < bytes.length; cnt++) {
            int uByte = bytes[cnt] < 0 ? bytes[cnt] + 256 : bytes[cnt];
            IP += uByte;
        }

        return IP;
    }

    public static long calcularDiasEntreFechas(Date fecha1, Date fecha2) {
        Calendar calendario1 = Calendar.getInstance();
        Calendar calendario2 = Calendar.getInstance();

        calendario1.setTime(fecha1);
        calendario2.setTime(fecha2);

        long milisegundos1 = calendario1.getTimeInMillis();
        long milisegundos2 = calendario2.getTimeInMillis();
        long diferencia = milisegundos2 - milisegundos1;
        long diasDiferencia = diferencia / (24 * 60 * 60 * 1000);
        return diasDiferencia;
    }

    public static String CambiarAcentos(String texto) {
        texto = texto.replace("Ã¡", "á");
        texto = texto.replace("Ã©", "é");
        texto = texto.replace("Ã*", "í");
        texto = texto.replace("Ã³", "ó");
        texto = texto.replace("Ãº", "ú");
        texto = texto.replace("Ã?", "Á");
        texto = texto.replace("Ã‰", "É");
        texto = texto.replace("Ã?", "Í");
        texto = texto.replace("Ã“", "Ó");
        texto = texto.replace("Ãš", "Ú");
        texto = texto.replace("Ã±", "ñ");
        texto = texto.replace("Ã‘", "Ñ");
        texto = texto.replace("Â¨", "\"");
        texto = texto.replace("Ã¼", "ü");
        texto = texto.replace("Ãœ", "Ü");
        return texto;
    }

    public static String EliminarAcentosYDemas(String texto) {
        texto = texto.replace("á", "a");
        texto = texto.replace("é", "a");
        texto = texto.replace("í", "i");
        texto = texto.replace("ó", "o");
        texto = texto.replace("ú", "u");
        texto = texto.replace("Á", "A");
        texto = texto.replace("É", "E");
        texto = texto.replace("Í", "I");
        texto = texto.replace("Ó", "O");
        texto = texto.replace("Ú", "U");
        texto = texto.replace("ñ", "n");
        texto = texto.replace("Ñ", "N");
        texto = texto.replace("(", "");
        texto = texto.replace(")", "");
        texto = texto.replace("-", "");
        return texto;
    }

    public static String EliminarAcentos(String texto) {
        texto = texto.replace("á", "a");
        texto = texto.replace("é", "a");
        texto = texto.replace("í", "i");
        texto = texto.replace("ó", "o");
        texto = texto.replace("ú", "u");
        texto = texto.replace("Á", "A");
        texto = texto.replace("É", "E");
        texto = texto.replace("Í", "I");
        texto = texto.replace("Ó", "O");
        texto = texto.replace("Ú", "U");
        texto = texto.replace("ñ", "n");
        texto = texto.replace("Ñ", "N");
        texto = texto.replace("\"", "");
        texto = texto.replace("'", "");
        texto = texto.replace("ü", "u");
        texto = texto.replace("Ü", "U");
        return texto;
    }

    public static String CrearCodigoVerificacion(String texto) {
        texto = texto.replace("A", "Z");
        texto = texto.replace("B", "y");
        texto = texto.replace("C", "X");
        texto = texto.replace("D", "w");
        texto = texto.replace("E", "V");
        texto = texto.replace("F", "u");
        texto = texto.replace("G", "T");
        texto = texto.replace("H", "s");
        texto = texto.replace("I", "R");
        texto = texto.replace("J", "q");
        texto = texto.replace("K", "P");
        texto = texto.replace("L", "o");
        texto = texto.replace("M", "N");
        texto = texto.replace("N", "m");
        texto = texto.replace("O", "L");
        texto = texto.replace("P", "k");
        texto = texto.replace("Q", "J");
        texto = texto.replace("R", "i");
        texto = texto.replace("S", "H");
        texto = texto.replace("T", "g");
        texto = texto.replace("U", "F");
        texto = texto.replace("V", "e");
        texto = texto.replace("W", "D");
        texto = texto.replace("X", "c");
        texto = texto.replace("Y", "B");
        texto = texto.replace("Z", "a");
        texto = texto.replace("0", "8");
        texto = texto.replace("1", "6");
        texto = texto.replace("2", "4");
        texto = texto.replace("3", "2");
        texto = texto.replace("4", "0");
        texto = texto.replace("5", "9");
        texto = texto.replace("6", "7");
        texto = texto.replace("7", "5");
        texto = texto.replace("8", "3");
        texto = texto.replace("9", "1");
        return texto;
    }

    public static boolean ValidarCondicion(boolean condicion, String componente) {
        if (!condicion) {
            ClaseGeneral.errorValidacion += " - " + componente + "\n";
            return false;
        } else {
            return true;
        }
    }

    public static boolean ValidarSeleccione(String texto, String componente) {
        if (componente.equals("C. INGRESO*")
                || componente.equals("ACTIVIDAD*")
                || componente.equals("SUBGRUPO*")
                || componente.equals("C. COSTOS*")) {
            return true;
        } else if (texto.contains("Seleccione")
                || texto.equals("0")
                || texto.equals("")) {
            ClaseGeneral.errorValidacion += " - " + componente + "\n";
            return false;
        } else {
            return true;
        }
    }

    public static boolean ValidarContiene(String texto, String contiene, String componente) {
        if (texto.contains(contiene)) {
            ClaseGeneral.errorValidacion += " - " + componente + "\n";
            return false;
        } else {
            return true;
        }
    }

    public static boolean ValidarContratos(String contrato) {
        if (contrato.length() > 0) {
            String patron = "[A-Z]{4}-[A-Z]{1,3}-\\d{3}-\\d{2}||"
                    + "ADICION-[A-Z]{4}-[A-Z]{1,3}-\\d{3}-\\d{2}||"
                    + "\\d{4}.\\d{4}_\\d{3}.\\d{3}-\\d{3}-\\d{2}||"
                    + "ADICION-\\d{4}.\\d{4}_\\d{3}.\\d{3}-\\d{3}-\\d{2}||"
                    + "\\d{3}-\\d{4}||"//CORPORATIVO ABIERTO
                    + "033-2012||"//PISTATOURS LTDA
                    + "034-2012||"//AVIATUR S.A
                    + "035-2012||"//EXPRESO VIAJES Y TURISMO
                    + "039-2012||"//DATECSA S.A
                    + "025-2014||"//PAPELERÍA CATI LTDA
                    + "026-2014||"//REDOX COLOMBIA S.A.S
                    + "027-2014||"//DISTRIBUIDORA DE PAPELES S.A. - DISPAPLES S.A.
                    + "028-2014||"//GUILLERMO ALBERTO SANDOVAL PIÑEROS - TECNOMUNDO Y SUMINISTROS
                    + "029-2014";//COMERCIAL MCL S.A.S
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(contrato);

            if (matcher.matches()) {
                return true;
            } else {
                ClaseGeneral.errorValidacion += " - Contrato\n";
                return false;
            }
        } else {
            ClaseGeneral.errorValidacion += " - Contrato\n";
            return false;
        }

    }

    public static boolean ValidarCuentas(String cuenta) {
        if (cuenta.length() > 0) {
            String patron = "OG-\\d{7}||"
                    + "FR-\\d{7}";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(cuenta);

            if (matcher.matches()) {
                return true;
            } else {
                ClaseGeneral.errorValidacion += " - Cuenta\n";
                return false;
            }
        } else {
            ClaseGeneral.errorValidacion += " - Cuenta\n";
            return false;
        }
    }

    public static boolean ValidarCuentaSALDO(String cuenta) {
        if (cuenta.length() > 0) {
            String patron = "#SALDO\\d{6}";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(cuenta);

            if (matcher.matches()) {
                return true;
            } else {
                if (!ClaseGeneral.errorValidacion.contains(" - Cuenta")) {
                    ClaseGeneral.errorValidacion += " - Cuenta\n";
                }
                return false;
            }
        } else {
            ClaseGeneral.errorValidacion += " - Cuenta\n";
            return false;
        }
    }

    public static boolean ValidarCUENTA(String cuenta) {
        if (cuenta.length() > 0) {
            String patron = "002||"
                    + "009||"
                    + "01||"
                    + "02||"
                    + "03||"
                    + "04||"
                    + "05||"
                    + "06||"
                    + "07||"
                    + "08||"
                    + "09||"
                    + "10";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(cuenta);
            
            if(!matcher.matches()) {
                ClaseGeneral.errorCUENTA = "Error (CUENTA) : " + cuenta + "\n";
            }
            return matcher.matches();
        } else {
            return false;
        }
    }

    public static boolean ValidarACTIVIDAD(String actividad) {
        boolean is = false;
        for (int i = 0; i < ClaseGeneral.controlActividad.findCodigoInActividadBy().size(); i++) {
            if (actividad.equals(ClaseGeneral.controlActividad.findCodigoInActividadBy().get(i))) {
                is = true;
            }
        }

        if(!is) {
            ClaseGeneral.errorACTIVIDAD = "Error (ACTIVIDAD) : " + actividad + "\n";
        }
        
        return is;
    }

    public static boolean ValidarSUBGRUPO(String subgrupo) {
        boolean is = false;
        for (int i = 0; i < ClaseGeneral.controlSubgrupo.findCodigoInSubgrupoBy().size(); i++) {
            if (subgrupo.equals(ClaseGeneral.controlSubgrupo.findCodigoInSubgrupoBy().get(i))) {
                is = true;
            }
        }
        
        if(!is) {
            ClaseGeneral.errorSUBGRUPO = "Error (SUBGRUPO) : " + subgrupo + "\n";
        }

        return is;
    }

    public static boolean ValidarCCOSTOS(String ccostos) {
        if (ccostos.length() > 0) {
            String patron = "470+\\d{2}||"
                    + "\\S";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(ccostos);
            
             if(!matcher.matches()) {
                ClaseGeneral.errorCCOSTOS = "Error (CCOSTOS) : " + ccostos + "\n";
            }
            return matcher.matches();
        } else {
            return false;
        }
    }

    public static boolean ValidarCINFO(String cinfo) {
        boolean is = false;
        for (int i = 0; i < ClaseGeneral.controlCinfo.findCodigoInCinfoBy().size(); i++) {
            if (cinfo.equals(ClaseGeneral.controlCinfo.findCodigoInCinfoBy().get(i))) {
                is = true;
            }
        }
        
        if(!is) {
            ClaseGeneral.errorCINFO = "Error (CINFO) : " + cinfo + "\n";
        }        

        return is;
    }

    public static boolean ValidarCUENTAINTERNA(String cuentainterna) {
        boolean is = false;
        for (int i = 0; i < ClaseGeneral.controlCuentainterna.findCondigoInCuentainternaBy().size(); i++) {
            if (cuentainterna.equals(ClaseGeneral.controlCuentainterna.findCondigoInCuentainternaBy().get(i))) {
                is = true;
            }
        }
        
        if(!is) {
            ClaseGeneral.errorCUENTAINTERNA = "Error (CUENTAINTERNA) : " + cuentainterna + "\n";
        }  

        return is;
    }

    public static boolean ValidarCALIFICACION(String tramite) {
        return ClaseGeneral.controlCalificacion.findSoporteInCalificacionByTramite(tramite);
    }

    public static String ValidarIngresoCUENTAINTERNA(String cinfo,
            String cingreso,
            String actividad,
            String ccostos,
            String cuentainterna) {

//        String cuentainterna = "";
//
//        if ("002131".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = "003148";
//            }
//        } else if ("002132".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = "003148";
//            }
//        } else if ("003140".equals(cinfo)
//                || "003141".equals(cinfo)
//                || "003142".equals(cinfo)
//                || "003143".equals(cinfo)
//                || "003144".equals(cinfo)
//                || "003145".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = "003140";
//            }
//        } else if ("003146".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = cinfo;
//            }
//        } else if ("003147".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = cinfo;
//            }
//        } else if ("003148".equals(cinfo)) {
//            if (cingreso.equals("021")) {
//                cuentainterna = "459706";
//            } else {
//                cuentainterna = cinfo;
//            }
//        } else if ("003149".equals(cinfo)) {
//            cuentainterna = "003148";
//        } else if ("007173".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("007178".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("007179".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("007180".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("009190".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("009193".equals(cinfo)) {
//            cuentainterna = "007173";
//        } else if ("009194".equals(cinfo)) {
//            cuentainterna = "007180";
//        } else if ("009195".equals(cinfo)) {
//            cuentainterna = "007178";
//        } else if ("009196".equals(cinfo)) {
//            cuentainterna = "007179";
//        } else if ("009197".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("453002".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("453003".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("453004".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("453005".equals(cinfo)) {
//            cuentainterna = "003148";
//        } else if ("454701".equals(cinfo)) {
//            cuentainterna = "003148";
//        } else if ("454702".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454703".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454704".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454705".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454706".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454707".equals(cinfo)) {
//            cuentainterna = "003140";
//        } else if ("454708".equals(cinfo)) {
//            cuentainterna = "003146";
//        } else if ("454709".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("454710".equals(cinfo)) {
//            cuentainterna = "459706";
//        } else if ("454711".equals(cinfo)) {
//            cuentainterna = "003148";
//        } else if ("454712".equals(cinfo)
//                || "454713".equals(cinfo)
//                || "454714".equals(cinfo)) {
//            cuentainterna = "454706";
//        } else if ("454715".equals(cinfo)) {
//            cuentainterna = "003140";
//        } else if ("454716".equals(cinfo)
//                || "454717".equals(cinfo)
//                || "454718".equals(cinfo)
//                || "454719".equals(cinfo)
//                || "454720".equals(cinfo)
//                || "454721".equals(cinfo)
//                || "454722".equals(cinfo)) {
//            cuentainterna = "454706";
//        } else if ("454723".equals(cinfo)) {
//            cuentainterna = "003140";
//        } else if ("454724".equals(cinfo)) {
//            cuentainterna = "454706";
//        } else if ("454725".equals(cinfo)) {
//            cuentainterna = "003146";
//        } else if ("454726".equals(cinfo)
//                || "454727".equals(cinfo)
//                || "454728".equals(cinfo)) {
//            cuentainterna = "454706";
//        } else if ("454729".equals(cinfo)) {
//            cuentainterna = "003147";
//        } else if ("454730".equals(cinfo)) {
//            cuentainterna = "459706";
//        } else if ("454731".equals(cinfo)) {
//            cuentainterna = "003140";
//        } else if ("454732".equals(cinfo)
//                || "454733".equals(cinfo)
//                || "454737".equals(cinfo)) {
//            cuentainterna = "454706";
//        } else if ("455000".equals(cinfo)
//                || "455001".equals(cinfo)
//                || "455002".equals(cinfo)
//                || "455003".equals(cinfo)
//                || "455004".equals(cinfo)
//                || "455005".equals(cinfo)) {
//            if (actividad.equals("001")
//                    || actividad.equals("003")) {
//                if (ccostos.equals("47011")) {
//                    cuentainterna = "459706";
//                } else if (ccostos.equals("47021")) {
//                    cuentainterna = "003146";
//                } else if (ccostos.equals("47031")) {
//                    cuentainterna = "003148";
//                } else if (ccostos.equals("47041")) {
//                    cuentainterna = "003140";
//                } else if (ccostos.equals("47051")) {
//                    cuentainterna = "003147";
//                } else {
//                    cuentainterna = "459706";
//                }
//            } else if (actividad.equals("004")) {
//                if (ccostos.equals("47021")) {
//                    cuentainterna = "007178";
//                } else if (ccostos.equals("47031")) {
//                    cuentainterna = "007173";
//                } else if (ccostos.equals("47041")) {
//                    cuentainterna = "007180";
//                } else if (ccostos.equals("47051")) {
//                    cuentainterna = "007179";
//                } else {
//                    cuentainterna = "459706";
//                }
//            } else if (actividad.equals("024")) {
//                if (ccostos.equals("47012")) {
//                    cuentainterna = "454703";
//                } else if (ccostos.equals("47015")) {
//                    cuentainterna = "454706";
//                } else {
//                    cuentainterna = "459706";
//                }
//            } else {
//                cuentainterna = "459706";
//            }
//        } else if ("459000".equals(cinfo)) {
//            cuentainterna = cinfo;
//        } else if ("459700".equals(cinfo)
//                || "459701".equals(cinfo)
//                || "459702".equals(cinfo)
//                || "459703".equals(cinfo)
//                || "459704".equals(cinfo)
//                || "459705".equals(cinfo)
//                || "459706".equals(cinfo)
//                || "459707".equals(cinfo)
//                || "459708".equals(cinfo)
//                || "459709".equals(cinfo)
//                || "459710".equals(cinfo)
//                || "459713".equals(cinfo)
//                || "459714".equals(cinfo)) {
//            cuentainterna = "459706";
//        } else if ("809009".equals(cinfo)) {
//            cuentainterna = "459706";
//        } else {
//            cuentainterna = "-1";
//        }
//
//        return cuentainterna;
        return ClaseGeneral.controlUtilidades.verficacionCuentaInterna(cinfo, cingreso, actividad, ccostos, cuentainterna);
    }

    public static void LimpiarPrincipales() {
        ClaseGeneral.comprobantes = null;
        ClaseGeneral.contratos = null;
        ClaseGeneral.cuentas = null;
        ClaseGeneral.resoluciones = null;
        ClaseGeneral.solicitudesoferta = null;
        ClaseGeneral.terceros = null;        
    }

    public static void LimpiarSecundarios() {
        ClaseGeneral.anexoscontratos = null;
        ClaseGeneral.anexosterceros = null;
        ClaseGeneral.bienessolicitudesoferta = null;
        ClaseGeneral.comprobantesnoreembolsados = null;
        ClaseGeneral.comprobantespendientes = null;
        ClaseGeneral.cubs = null;
        ClaseGeneral.cumplidoscomprobantes = null;
        ClaseGeneral.facturascomprobantes = null;
        ClaseGeneral.formadepagocontratos = null;
        ClaseGeneral.modificaciones = null;
        ClaseGeneral.observacionescontratos = null;
        ClaseGeneral.observacionescuentas = null;
        ClaseGeneral.polizas = null;
        ClaseGeneral.serviciossolicitudesoferta = null;
        ClaseGeneral.soportescomprobantes = null;
        ClaseGeneral.soportescontratos = null;
        ClaseGeneral.soportescuentas = null;
        ClaseGeneral.soportesresoluciones = null;
        ClaseGeneral.tercerosresoluciones = null;        
        
    }

    public static String ConvertirNombre(String texto) {
        String[] arreglo = texto.split(" ");
        if (arreglo.length == 2) {
            return arreglo[1] + " " + arreglo[0];
        } else if (arreglo.length == 3) {
            return arreglo[2] + " " + arreglo[0] + " " + arreglo[1];
        } else if (arreglo.length == 4 && arreglo[1].equals("DE")) {
            return arreglo[3] + " " + arreglo[0] + " " + arreglo[1] + " " + arreglo[2];
        } else if (arreglo.length == 4) {
            return arreglo[2] + " " + arreglo[3] + " " + arreglo[0] + " " + arreglo[1];
        } else {
            return texto;
        }
    }
//    public static void SetTreeState(JTree tree, boolean expanded) {
//        Object root = tree.getModel().getRoot();
//        SetTreeState(tree, new TreePath(root), expanded);
//    }
//
//    public static void SetTreeState(JTree tree, TreePath path, boolean expanded) {
//        Object lastNode = path.getLastPathComponent();
//        for (int i = 0; i < tree.getModel().getChildCount(lastNode); i++) {
//            Object child = tree.getModel().getChild(lastNode, i);
//            TreePath pathToChild = path.pathByAddingChild(child);
//            SetTreeState(tree, pathToChild, expanded);
//        }
//        if (expanded) {
//            tree.expandPath(path);
//        } else {
//            tree.collapsePath(path);
//        }
//    }
}
