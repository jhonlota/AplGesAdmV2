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
public class ActividadJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ActividadJpaController() {
    }

    public void create(Actividad actividad) {
        try {
            datos.update("INSERT INTO ACTIVIDAD VALUES ("
                    + "'" + actividad.getCodigo() + "', "
                    + "'" + actividad.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Actividad");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Actividad actividad, Actividad id) {
        try {
            datos.update("UPDATE ACTIVIDAD SET "
                    + "NOMBRE = '" + actividad.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Actividad");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM ACTIVIDAD "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Actividad");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInActividadBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM ACTIVIDAD");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInActividadBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO) FROM ACTIVIDAD ORDER BY CODIGO");
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
