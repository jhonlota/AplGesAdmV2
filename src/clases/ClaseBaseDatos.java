/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseBaseDatos {

    public static Connection conexion;
    public static Statement estamento;
    public static ResultSet resultado;
    public boolean isError = false;
    public String error;

    public static void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ClaseMensaje.error("ALERTA\n" + ex);
        }
        try {
//            IMPORTANTE cargar archivo de configuracion            
//            File archivo = new File("C:/config.con");
//            ArrayList<String> array = ClaseGeneral.leer.MetodoLeer(archivo);
//
//            String url = array.get(1).substring(array.get(1).indexOf("='") + 2, array.get(1).indexOf("';"));
//            String dbname = array.get(2).substring(array.get(2).indexOf("='") + 2, array.get(2).indexOf("';"));
//            String user = array.get(3).substring(array.get(3).indexOf("='") + 2, array.get(3).indexOf("';"));
//            String pass = array.get(4).substring(array.get(4).indexOf("='") + 2, array.get(4).indexOf("';"));
//            ClaseGeneral.servidor =  array.get(5).substring(array.get(5).indexOf("='") + 2, array.get(5).indexOf("';"));

/**///IMPORTANTE
            String url = "192.168.131.52";
            String dbname = "gest_ciencias";
            String user = "aga_ciencias";
            String pass = "AgA_CnS.hmcx36874";
            ClaseGeneral.servidor = "http://ingenieria.univalle.edu.co/facultadweb2/aga_ciencias/datos";
            ClaseGeneral.urlFTP = "192.168.131.52";
            ClaseGeneral.login = "aga_ciencias";
            ClaseGeneral.pwd = "AgA.hmcx36874";
            
/**///IMPORTANTE
//            String url = "192.168.131.52";
//            String dbname = "gest_ingenieria";
//            String user = "aga_ingenieria";
//            String pass = "AgA_InG.Ktec871";
//            ClaseGeneral.servidor = "http://ingenieria.univalle.edu.co/facultadweb2/aga_ingenieria/datos";
//            ClaseGeneral.urlFTP = "192.168.131.52";
//            ClaseGeneral.login = "aga_ingenieria";
//            ClaseGeneral.pwd = "AgA_InG.Ktec871";

            conexion = DriverManager.getConnection("jdbc:postgresql://" + url + ":5432/" + dbname, user, pass);
//            System.out.println("jdbc:postgresql://" + url + ":5432/" + dbname + "," + user + "," + pass);

            estamento = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            ClaseMensaje.error("ERROR PARA CONECTARSE A LA BASE DE DATOS\n" + ex);
        }
    }

    public void update(String sentencia) {
        try {
            isError = false;
//            System.out.println(sentencia);
            estamento.executeUpdate(sentencia);
            estamento.clearBatch();
        } catch (SQLException ex) {
            if (ex.toString().contains("duplicate key value violates unique constraint")) {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\nEl registro ya existe en la base de datos");
            } else {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
            }
            isError = true;
            error = ex.toString();
//            System.out.println("ERROR == " + error);
        }
    }

    public void updateImportar(String sentencia) {
        try {
            isError = false;
//            System.out.println(sentencia);
            estamento.executeUpdate(sentencia);
            estamento.clearBatch();
        } catch (SQLException ex) {
            isError = true;
            error = ex.toString();
        }
    }

    public void query(String sentencia) {
        try {
            isError = false;
//            System.out.println(sentencia);
            resultado = estamento.executeQuery(sentencia);
            estamento.clearBatch();
        } catch (SQLException ex) {
            if (ex.toString().contains("duplicate key value violates unique constraint")) {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\nEl registro ya existe en la base de datos");
            } else {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
            }
            isError = true;
            error = ex.toString();
        }
    }
}