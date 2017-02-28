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
public class DependenciaJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public DependenciaJpaController() {
    }

    public void create(Dependencia dependencia) {
        try {
            datos.update("INSERT INTO " + dependencia.tabla + " VALUES ("
                    + "'" + dependencia.getCodigo() + "', "
                    + "'" + dependencia.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Dependencia");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Dependencia dependencia, Dependencia id) {
        try {
            datos.update("UPDATE DEPENDENCIA SET "
                    + "NOMBRE = '" + dependencia.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Dependencia");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM DEPENDENCIA "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Dependencia");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInDependenciaBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM DEPENDENCIA");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInDependenciaBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO), NOMBRE FROM DEPENDENCIA ORDER BY CODIGO");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("NOMBRE") + " [" + ClaseBaseDatos.resultado.getString("CODIGO") + "]");
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
    
    public DefaultComboBoxModel COMBONombreInDependenciaBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            modeloCombo.addElement("Seleccione");
            datos.query("SELECT DISTINCT(NOMBRE) FROM DEPENDENCIA ORDER BY NOMBRE");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("NOMBRE"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
