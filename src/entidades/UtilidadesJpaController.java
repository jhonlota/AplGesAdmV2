/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import java.util.Date;

/**
 *
 * @author Jhon Lopez
 */
public class UtilidadesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public UtilidadesJpaController() {
    }

    public String timeServidor() {
        try {
            String hora = "00:00:00";
            datos.query("SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH24:MI:SS')HORA");
            while (ClaseBaseDatos.resultado.next()) {
                hora = ClaseBaseDatos.resultado.getString("HORA");
            }
            return hora;
        } catch (Exception ex) {
            return "00:00:00";
        } finally {
        }
    }

    public String horaServidor() {
        try {
            String fecha = "12:00:00";
            datos.query("SELECT CURRENT_TIMESTAMP FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                fecha = ClaseBaseDatos.resultado.getString("FECHA");
            }
            return fecha;
        } catch (Exception ex) {
            return "12:00";
        } finally {
        }
    }

    public String anoServidor() {
        try {
            String fecha = "2000";
            datos.query("SELECT EXTRACT(YEAR FROM CURRENT_DATE) ANO");
            while (ClaseBaseDatos.resultado.next()) {
                fecha = ClaseBaseDatos.resultado.getString("ANO");
            }
            return fecha;
        } catch (Exception ex) {
            return "2000";
        } finally {
        }
    }

    public Date fechaServidor() {
        try {
            Date fecha = null;
            datos.query("SELECT CURRENT_DATE");
            while (ClaseBaseDatos.resultado.next()) {
                fecha = ClaseBaseDatos.resultado.getDate("DATE");
            }
            return fecha;
        } catch (Exception ex) {
            return null;
        } finally {
        }
    }

    public String verficacionCuentaInterna(String cinfo,
            String cingreso,
            String actividad,
            String ccostos,
            String cuentainterna) {
        try {
            String cuentainternaAux = "-1";
            boolean isPrimero = true;

            datos.query("SELECT * FROM " 
                    + "(SELECT CUENTAINTERNA, 60 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO LIKE '%" + cingreso + "%' AND ACTIVIDAD LIKE '%" + actividad + "%' AND CCOSTOS LIKE '%" + ccostos + "%' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 51 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO LIKE '%" + cingreso + "%' AND ACTIVIDAD LIKE '%" + actividad + "%' AND CCOSTOS = '*' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 41 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO LIKE '%" + cingreso + "%' AND ACTIVIDAD = '*' AND CCOSTOS LIKE '%" + ccostos + "%' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 32 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO LIKE '%" + cingreso + "%' AND ACTIVIDAD = '*' AND CCOSTOS = '*' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 31 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO = '*' AND ACTIVIDAD LIKE '%" + actividad + "%' AND CCOSTOS LIKE '%" + ccostos + "%' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 22 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO = '*' AND ACTIVIDAD LIKE '%" + actividad + "%' AND CCOSTOS = '*' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 12 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO = '*' AND ACTIVIDAD = '*' AND CCOSTOS LIKE '%" + ccostos + "%' "
                    + "UNION "
                    + "SELECT CUENTAINTERNA, 3 AS PESO "
                    + "FROM VERIFICACINFOCUENTAINTERNA "
                    + "WHERE "
                    + "CINFO = '" + cinfo + "' AND "
                    + "CINGRESO = '*' AND ACTIVIDAD = '*' AND CCOSTOS = '*') AS TABLA " 
                    + "ORDER BY PESO DESC");
            
            while (ClaseBaseDatos.resultado.next() && isPrimero) {
                cuentainternaAux = ClaseBaseDatos.resultado.getString("CUENTAINTERNA");
                isPrimero = false;
            }

            if (!cuentainternaAux.equals(cuentainterna)) {
                ClaseGeneral.errorValidarIngresoCUENTAINTERNA = "Error (CINFO) : " + cinfo + "\n   NO empareja con\n   C. INTERNA : " + cuentainterna + "\n";
            }

            return cuentainternaAux;
        } catch (Exception ex) {
            return "-1";
        } finally {
        }
    }
}
