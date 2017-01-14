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
public class CuentainternaJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CuentainternaJpaController() {
    }

    public void create(Subgrupo cuentainterna) {
        try {
            datos.update("INSERT INTO CUENTAINTERNA VALUES ("
                    + "'" + cuentainterna.getCodigo() + "', "
                    + "'" + cuentainterna.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Cuenta Interna");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Subgrupo cuentainterna, Subgrupo id) {
        try {
            datos.update("UPDATE CUENTAINTERNA SET "
                    + "NOMBRE = '" + cuentainterna.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Cuenta Interna");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM CUENTAINTERNA "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Cuenta Interna");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCondigoInCuentainternaBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM CUENTAINTERNA");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInCuentainternaBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO) FROM CUENTAINTERNA ORDER BY CODIGO");
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
