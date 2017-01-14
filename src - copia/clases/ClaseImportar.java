/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import frame.ExternoPanelCuentainterna;
import frame.ExternoPanelImportar;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import neuranas.Leer;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseImportar {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();
    //private int consecutivoNM = 1;
    private int consecutivoCPN = 1;
    private Leer leer = new Leer();
    private String actividad;
    private String ccostos;
    private String cinfo;
    private String cingreso;
    private String cuenta;
    private String cuentainterna;
    private String descripcion;
    private String documento;
    private String egreso;
    private String fechadigitacion;
    private String fechapresupuestal;
    private String fechatransaccion;
    private String fktercero;
    private String ingreso;
    private String soporte;//LLAVE PRINCIPAL
    private String soporteAnterior;
    private String subgrupo;
    public int correctosCuentas = 0;
    public int correctosSoportescuentas = 0;
    public int erroresCuentas = 0;
    public int erroresSoportescuentas = 0;
    public String lineaDescartada = "";
    long aleatorio = ClaseInformacion.LongAletario();
    String archivoERROR = "archivoERROR_" + aleatorio + ".txt";
    List<String> arregloERROR = new ArrayList<String>();

    public void metodoImportar(File file) {
        soporteAnterior = "";
        ArrayList lista = leer.MetodoLeer(file);
        for (int i = 0; i < lista.size(); i++) {
            try {
                metodoImputacion((String) lista.get(i));
            } catch (Exception e) {
                System.err.println("ERROR -> " + lista.get(i));
                Logger.getLogger(ClaseImportar.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        ClaseGeneral.escribir.MetodoEscribir(arregloERROR, archivoERROR);

        file = new File(archivoERROR);
        if (file.getAbsoluteFile().exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(ClaseImportar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

        System.out.println("************************\nLINEAS DESCARTADAS\n" + lineaDescartada);
    }

    public void metodoImputacion(String linea) {
        /**
         * UNICO QUE SE UTILIZA A PARTIR DE OCT/2014 *
         */
        if (linea.contains("CB")
                || linea.contains("CP")
                || linea.contains("CPN")
                || linea.contains("EJ")
                || linea.contains("MCB")
                || linea.contains("NA")
                || linea.contains("NCB")
                || linea.contains("NDB")
                || linea.contains("NP")
                || linea.contains("RC")
                || linea.contains("RP")
                || linea.contains("RS")) {
            int i = 0;
            String auxTipodocumento = linea.substring(i, linea.indexOf(";", i)).trim();//Tipo Dcto
            i = linea.indexOf(";", i) + 1;//Tipo Dcto -> Numero
            String auxNumero = linea.substring(i, linea.indexOf(";", i)).trim();//Numero
            i = linea.indexOf(";", i) + 1;//Numero -> Fecha
            documento = auxTipodocumento + "-" + auxNumero;
            fechatransaccion = linea.substring(i, linea.indexOf(";", i)).trim();//Fecha
            /**/
            if (fechatransaccion.substring(2, 3).equals("/")
                    || fechatransaccion.substring(2, 3).equals("-")) {
                fechatransaccion = ClaseInformacion.ConvertirStringAFecha(fechatransaccion);
            }
            fechadigitacion = fechatransaccion;
            fechapresupuestal = fechatransaccion;
            /**/
            i = linea.indexOf(";", i) + 1;//Fecha -> Cuenta Movimiento
            String auxCuentamovimiento = linea.substring(i, linea.indexOf(";", i)).trim();//Cuenta Movimiento

            //CONTAMOS CUANTOS PUNTOS TIENE auxCuentamovimiento
            int j = 0;//Numero de veces que aparece el punto '.' en auxCuentamovimiento

            for (int k = 0; k < auxCuentamovimiento.length(); k++) {
                if (auxCuentamovimiento.charAt(k) == '.') {
                    j++;
                }
            }

            int l = 0;
            ArrayList<String> arrayMovimiento = new ArrayList<String>();//Convierto en array Cuenta Movimiento            
            arrayMovimiento.add(auxCuentamovimiento.substring(l, auxCuentamovimiento.indexOf(".", l)).trim());
            l = auxCuentamovimiento.indexOf(".", l) + 1;
            /**/
            arrayMovimiento.add(auxCuentamovimiento.substring(l, auxCuentamovimiento.indexOf(".", l)).trim());
            l = auxCuentamovimiento.indexOf(".", l) + 1;

            if (j > 2) {//Significa que auxCuentamovimiento tiene 3 puntos (GASTOS)
                arrayMovimiento.add(auxCuentamovimiento.substring(l, auxCuentamovimiento.indexOf(".", l)).trim());
                l = auxCuentamovimiento.indexOf(".", l) + 1;
                /**/
                arrayMovimiento.add(auxCuentamovimiento.substring(l, auxCuentamovimiento.length()).trim());
            } else {//Significa que auxCuentamovimiento tiene 2 puntos (INGRESOS)
                arrayMovimiento.add(auxCuentamovimiento.substring(l, auxCuentamovimiento.length()).trim());
            }

            cuenta = "0";
            cingreso = "0";
            actividad = "0";
            subgrupo = "0";
            if (arrayMovimiento.size() == 4) {//GASTOS
                //arrayMovimiento[0]//Dependencia
                cuenta = arrayMovimiento.get(1).substring(arrayMovimiento.get(1).length() - 3);
                actividad = arrayMovimiento.get(2).substring(arrayMovimiento.get(2).length() - 3);
                subgrupo = arrayMovimiento.get(3).substring(arrayMovimiento.get(3).length() - 3);
            } else if (arrayMovimiento.size() == 3) {//INGRESOS
                //arrayMovimiento[0]//Dependencia
                cuenta = arrayMovimiento.get(1).substring(arrayMovimiento.get(1).length() - 3);
                cingreso = arrayMovimiento.get(2).substring(arrayMovimiento.get(2).length() - 3);
            }

            i = linea.indexOf(";", i) + 1;//Cuenta Movimiento -> Centro Costos
            ccostos = linea.substring(i, linea.indexOf(";", i)).trim();//Centro Costos
            i = linea.indexOf(";", i) + 1;//Centro Costos -> Centro Informacion
            cinfo = linea.substring(i, linea.indexOf(";", i)).trim();//Centro Costos
            i = linea.indexOf(";", i) + 1;//Centro Informacion -> Tercero
            String auxTercero = linea.substring(i, linea.indexOf(";", i)).trim();//Tercero
            i = linea.indexOf(";", i) + 1;//Tercero -> Nombre Tercero
            String auxNombretercero = linea.substring(i, linea.indexOf(";", i));//Nombre Tercero

            String auxNombre = ClaseGeneral.controlTerceros.findNombreInTercerosById(auxTercero);
            if (!auxNombre.equals("")) {
                fktercero = auxTercero + " - " + auxNombre;
            } else {
                fktercero = auxTercero + " - " + auxNombretercero;
            }

            i = linea.indexOf(";", i) + 1;//Nombre Tercero -> Concepto
            String auxConcepto = linea.substring(i, linea.indexOf(";", i));
            i = linea.indexOf(";", i) + 1;//Concepto -> Observacion
            String auxObservacion = linea.substring(i, linea.indexOf(";", i));
            descripcion = auxConcepto + " " + auxObservacion;
            i = linea.indexOf(";", i) + 1;//Observacion -> Valor Ejecutado

            egreso = "0";
            ingreso = "0";
            if (arrayMovimiento.size() == 4) {//GASTOS
                egreso = linea.substring(i, linea.length()).trim().replace(",00", "").replace(".", "");
            } else if (arrayMovimiento.size() == 3) {//INGRESOS
                ingreso = linea.substring(i, linea.length()).trim().replace(",00", "").replace(".", "");
            }
            /**/
            soporte = documento;

            metodoCuentaInterna();

            if (cuentainterna.length() == 4) {
                cuentainterna = "00" + cuentainterna;
            }

            if (soporte.contains("CPN-")) {
                consecutivoCPN++;
                soporteAnterior = soporte;
                soporte = soporte + "-" + consecutivoCPN;
            }

            if (metodoInsertarCuentas()) {
                metodoInsertarSoportescuentas();
            } else {
                arregloERROR.add("ERROR insert cuentas : " + linea);

                if (metodoInsertarSoportescuentas()) {
                } else {
                    arregloERROR.add("ERROR insert soportescuentas : " + linea);
                }
            }
        } else {
            lineaDescartada += linea + "\n";
        }
    }

    public boolean metodoInsertarCuentas() {
        try {

            if (ingreso.trim().equals("")) {
                ingreso = "0";
            }

            if (egreso.trim().equals("")) {
                egreso = "0";
            }

            if (soporte.trim().equals("")) {
                soporte = documento;
            }

            if (metodoTipoSoportes()) {
                descripcion = ClaseInformacion.EliminarAcentos(descripcion);

//                System.out.println("INSERT INTO CUENTAS (DOCUMENTO, DESCRIPCION, EGRESO, FECHADIGITACION, FECHAPRESUPUESTAL, FECHATRANSACCION, FKTERCERO, INGRESO, SOPORTE) VALUES ("
//                        + "'" + documento + "', "
//                        + "'" + descripcion + "', "
//                        + egreso + ", "
//                        + "'" + fechadigitacion + "', "
//                        + "'" + fechapresupuestal + "', "
//                        + "'" + fechatransaccion + "', "
//                        + "'" + fktercero + "', "
//                        + ingreso + ", "
//                        + "'" + soporte + "')");

                String sql = "SELECT SOPORTE FROM CUENTAS "
                        + "WHERE DOCUMENTO = '" + documento + "';";

                byte[] utf8 = sql.getBytes("UTF-8");
                sql = new String(utf8, "UTF-8");;
                sql = ClaseInformacion.CambiarAcentos(sql);

                datos.query(sql);
                boolean isIngresada = false;
                while (ClaseBaseDatos.resultado.next()) {
                    soporte = ClaseBaseDatos.resultado.getString("SOPORTE");
                    isIngresada = true;
                }

                if (!isIngresada) {
                    sql = "INSERT INTO CUENTAS (DOCUMENTO, DESCRIPCION, EGRESO, FECHADIGITACION, FECHAPRESUPUESTAL, FECHATRANSACCION, FKTERCERO, INGRESO, SOPORTE) VALUES ("
                            + "'" + documento + "', "
                            + "'" + descripcion + "', "
                            + egreso + ", "
                            + "'" + fechadigitacion + "', "
                            + "'" + fechapresupuestal + "', "
                            + "'" + fechatransaccion + "', "
                            + "'" + fktercero + "', "
                            + ingreso + ", "
                            + "'" + soporte + "')";

                    utf8 = sql.getBytes("UTF-8");
                    sql = new String(utf8, "UTF-8");;
                    sql = ClaseInformacion.CambiarAcentos(sql);

                    datos.updateImportar(sql);
                    if (!datos.isError) {
                        correctosCuentas++;
                        return true;
                    } else {
                        erroresCuentas++;
                        System.out.println(sql + ", ERROR: " + datos.error);
                        return false;
                    }
                } else {
                    correctosCuentas++;
                    System.out.println("Ya ingresado el DOCUMENTO : " + documento + ", SOPORTE : " + soporte);
                    return true;
                }

            } else {
                return false;
            }
        } catch (Exception ex) {
            erroresCuentas++;
            Logger.getLogger(ClaseImportar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean metodoInsertarSoportescuentas() {
        try {
            String valor;

            if (ingreso.trim().equals("")) {
                ingreso = "0";
            }

            if (egreso.trim().equals("")) {
                egreso = "0";
            }

            if (!ingreso.trim().equals("0")) {
                valor = ingreso;
            } else {
                valor = egreso;
            }

            if (soporte.trim().equals("")) {
                soporte = documento;
            }

            if (metodoTipoSoportes()) {
//                System.out.println("INSERT INTO SOPORTESCUENTAS (FKCUENTA, ACTIVIDAD, CCOSTOS, CINFO, CINGRESO, CUENTA, CUENTAINTERNA, SUBGRUPO, VALOR) VALUES ("
//                        + "'" + soporte + "', "
//                        + "'" + actividad + "', "
//                        + "'" + ccostos + "', "
//                        + "'" + cinfo + "', "
//                        + "'" + cingreso + "', "
//                        + "'" + cuenta + "', "
//                        + "'" + cuentainterna + "', "
//                        + "'" + subgrupo + "', "
//                        + valor + ")");
                String sql = "INSERT INTO SOPORTESCUENTAS (FKCUENTA, ACTIVIDAD, CCOSTOS, CINFO, CINGRESO, CUENTA, CUENTAINTERNA, SUBGRUPO, VALOR) VALUES ("
                        + "'" + soporte + "', "
                        + "'" + actividad + "', "
                        + "'" + ccostos + "', "
                        + "'" + cinfo + "', "
                        + "'" + cingreso + "', "
                        + "'" + cuenta + "', "
                        + "'" + cuentainterna + "', "
                        + "'" + subgrupo + "', "
                        + valor + ")";

                byte[] utf8 = sql.getBytes("UTF-8");
                sql = new String(utf8, "UTF-8");;
                sql = ClaseInformacion.CambiarAcentos(sql);

                datos.updateImportar(sql);
                if (!datos.isError) {
                    correctosSoportescuentas++;
                    return true;
                } else {
                    System.out.println(sql + ", ERROR: " + datos.error);
                    erroresSoportescuentas++;
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            erroresSoportescuentas++;
            Logger.getLogger(ClaseImportar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    public boolean metodoTipoReportes(String tipo) {
//        if (tipo.equals("<=2013") && ExternoPanelImportar.reportes2013.isSelected()) {
//            return true;
//        } else if (tipo.equals(">2014") && ExternoPanelImportar.reportes2014.isSelected()) {
//            return true;
//        } else if (tipo.equals("especial") && ExternoPanelImportar.especial.isSelected()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public boolean metodoTipoSoportes() {
        if (soporte.contains("BANCO") && ExternoPanelImportar.BANCO.isSelected()) {
            return true;
        } else if (soporte.contains("CB") && ExternoPanelImportar.CB.isSelected()) {
            return true;
        } else if (soporte.contains("CONCIL") && ExternoPanelImportar.CONCIL.isSelected()) {
            return true;
        } else if (soporte.contains("CONSIGNACION") && ExternoPanelImportar.CONSIGNACION.isSelected()) {
            return true;
        } else if (soporte.contains("CP") && ExternoPanelImportar.CP.isSelected()) {
            return true;
        } else if (soporte.contains("CPN") && ExternoPanelImportar.CPN.isSelected()) {
            return true;
        } else if (soporte.contains("DB") && ExternoPanelImportar.DB.isSelected()) {
            return true;
        } else if (soporte.contains("DIVISAS") && ExternoPanelImportar.DIVISAS.isSelected()) {
            return true;
        } else if (soporte.contains("EJ") && ExternoPanelImportar.EJ.isSelected()) {
            return true;
        } else if (soporte.contains("EXTRACTO") && ExternoPanelImportar.EXTRACTO.isSelected()) {
            return true;
        } else if (soporte.contains("FR") && ExternoPanelImportar.FR.isSelected()) {
            return true;
        } else if (soporte.contains("LISTADO") && ExternoPanelImportar.LISTADO.isSelected()) {
            return true;
        } else if (soporte.contains("MCB") && ExternoPanelImportar.MCB.isSelected()) {
            return true;
        } else if (soporte.contains("NA") && ExternoPanelImportar.NA.isSelected()) {
            return true;
        } else if (soporte.contains("NCB") && ExternoPanelImportar.NCB.isSelected()) {
            return true;
        } else if (soporte.contains("NDB") && ExternoPanelImportar.NDB.isSelected()) {
            return true;
        } else if (soporte.contains("NM") && ExternoPanelImportar.NM.isSelected()) {
            return true;
        } else if (soporte.contains("NP") && ExternoPanelImportar.NP.isSelected()) {
            return true;
        } else if (soporte.contains("OG") && ExternoPanelImportar.OG.isSelected()) {
            return true;
        } else if (soporte.contains("RC") && ExternoPanelImportar.RC.isSelected()) {
            return true;
        } else if (soporte.contains("RD") && ExternoPanelImportar.RD.isSelected()) {
            return true;
        } else if (soporte.contains("RP") && ExternoPanelImportar.RP.isSelected()) {
            return true;
        } else if (soporte.contains("RS") && ExternoPanelImportar.RS.isSelected()) {
            return true;
        } else if (soporte.contains("Soporte") && ExternoPanelImportar.Soporte.isSelected()) {
            return true;
        } else if (soporte.contains("VRAD") && ExternoPanelImportar.VRAD.isSelected()) {
            return true;
        } else if (soporte.trim().equals("") && ExternoPanelImportar.Vacio.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void metodoCuentaInterna() {
        if ("002131".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = "003148";
            }
        } else if ("002132".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = "003148";
            }
        } else if ("003140".equals(cinfo)
                || "003141".equals(cinfo)
                || "003142".equals(cinfo)
                || "003143".equals(cinfo)
                || "003144".equals(cinfo)
                || "003145".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = "003140";
            }
        } else if ("003146".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = cinfo;
            }
        } else if ("003147".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = cinfo;
            }
        } else if ("003148".equals(cinfo)) {
            if (cingreso.equals("021")) {
                cuentainterna = "459706";
            } else {
                cuentainterna = cinfo;
            }
        } else if ("003149".equals(cinfo)) {
            cuentainterna = "003148";
        } else if ("007173".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("007178".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("007179".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("007180".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("009190".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("009193".equals(cinfo)) {
            cuentainterna = "007173";
        } else if ("009194".equals(cinfo)) {
            cuentainterna = "007180";
        } else if ("009195".equals(cinfo)) {
            cuentainterna = "007178";
        } else if ("009196".equals(cinfo)) {
            cuentainterna = "007179";
        } else if ("009197".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("453002".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("453003".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("453004".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("453005".equals(cinfo)) {
            cuentainterna = "003148";
        } else if ("454701".equals(cinfo)) {
            cuentainterna = "003148";
        } else if ("454702".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454703".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454704".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454705".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454706".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454707".equals(cinfo)) {
            cuentainterna = "003140";
        } else if ("454708".equals(cinfo)) {
            cuentainterna = "003146";
        } else if ("454709".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("454710".equals(cinfo)) {
            cuentainterna = "459706";
        } else if ("454711".equals(cinfo)) {
            cuentainterna = "003148";
        } else if ("454712".equals(cinfo)
                || "454713".equals(cinfo)
                || "454714".equals(cinfo)) {
            cuentainterna = "454706";
        } else if ("454715".equals(cinfo)) {
            cuentainterna = "003140";
        } else if ("454716".equals(cinfo)
                || "454717".equals(cinfo)
                || "454718".equals(cinfo)
                || "454719".equals(cinfo)
                || "454720".equals(cinfo)
                || "454721".equals(cinfo)
                || "454722".equals(cinfo)) {
            cuentainterna = "454706";
        } else if ("454723".equals(cinfo)) {
            cuentainterna = "003140";
        } else if ("454724".equals(cinfo)) {
            cuentainterna = "454706";
        } else if ("454725".equals(cinfo)) {
            cuentainterna = "003146";
        } else if ("454726".equals(cinfo)
                || "454727".equals(cinfo)
                || "454728".equals(cinfo)) {
            cuentainterna = "454706";
        } else if ("454729".equals(cinfo)) {
            cuentainterna = "003147";
        } else if ("454730".equals(cinfo)) {
            cuentainterna = "459706";
        } else if ("454732".equals(cinfo)) {
            cuentainterna = "454706";
        } else if ("455000".equals(cinfo)
                || "455001".equals(cinfo)
                || "455002".equals(cinfo)
                || "455003".equals(cinfo)
                || "455004".equals(cinfo)
                || "455005".equals(cinfo)) {
            if (actividad.equals("001")
                    || actividad.equals("003")) {
                if (ccostos.equals("47011")) {
                    cuentainterna = "459706";
                } else if (ccostos.equals("47021")) {
                    cuentainterna = "003146";
                } else if (ccostos.equals("47031")) {
                    cuentainterna = "003148";
                } else if (ccostos.equals("47041")) {
                    cuentainterna = "003140";
                } else if (ccostos.equals("47051")) {
                    cuentainterna = "003147";
                } else {
                    cuentainterna = "459706";
                }
            } else if (actividad.equals("004")) {
                if (ccostos.equals("47021")) {
                    cuentainterna = "007178";
                } else if (ccostos.equals("47031")) {
                    cuentainterna = "007173";
                } else if (ccostos.equals("47041")) {
                    cuentainterna = "007180";
                } else if (ccostos.equals("47051")) {
                    cuentainterna = "007179";
                } else {
                    cuentainterna = "459706";
                }
            } else if (actividad.equals("024")) {
                if (ccostos.equals("47012")) {
                    cuentainterna = "454703";
                } else if (ccostos.equals("47015")) {
                    cuentainterna = "454706";
                } else {
                    cuentainterna = "459706";
                }
            } else {
                cuentainterna = "459706";
            }
        } else if ("459000".equals(cinfo)) {
            cuentainterna = cinfo;
        } else if ("459700".equals(cinfo)
                || "459701".equals(cinfo)
                || "459702".equals(cinfo)
                || "459703".equals(cinfo)
                || "459704".equals(cinfo)
                || "459705".equals(cinfo)
                || "459706".equals(cinfo)
                || "459707".equals(cinfo)
                || "459708".equals(cinfo)
                || "459709".equals(cinfo)
                || "459710".equals(cinfo)
                || "459713".equals(cinfo)
                || "459714".equals(cinfo)) {
            cuentainterna = "459706";
        } else if ("809009".equals(cinfo)) {
            cuentainterna = "459706";
        } else {
            ExternoPanelCuentainterna panelCuentainterna = new ExternoPanelCuentainterna();
            panelCuentainterna.labeltexto.setText("<html><p align = center><strong>SOPORTE : </strong>" + soporte + "<br/>"
                    + "<strong>DESCRIPCION: </strong>" + descripcion + "<br/>"
                    + "<strong>IMPUTACION: </strong>" + cuenta + " | " + actividad + " | " + subgrupo + " | " + cingreso + " | " + ccostos + " | " + cinfo + "<br/>"
                    + "<strong>INGRESO: </strong>" + ingreso + "<br/>"
                    + "<strong>EGRESO: </strong>" + egreso + "</p></html>");
            ClaseMensaje.panel(panelCuentainterna);
            cuentainterna = "" + panelCuentainterna.cuentainterna.getSelectedItem();
//            cuentainterna = cinfo;
        }
    }
}