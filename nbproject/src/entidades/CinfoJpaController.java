/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jhon Lopez
 */
public class CinfoJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CinfoJpaController() {
    }

    public void create(Cinfo cinfo) {
        try {
            datos.update("INSERT INTO " + cinfo.tabla + " VALUES ("
                    + "'" + cinfo.getCodigo() + "', "
                    + "'" + cinfo.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Centro de Informacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Cinfo cinfo, Cinfo id) {
        try {
            datos.update("UPDATE CINFO SET "
                    + "NOMBRE = '" + cinfo.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Centro de Informacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM CINFO "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Centro de Informacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInCinfoBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM CINFO");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInCinfoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO) FROM CINFO ORDER BY CODIGO");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
