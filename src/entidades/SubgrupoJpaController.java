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
public class SubgrupoJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public SubgrupoJpaController() {
    }

    public void create(Subgrupo subgrupo) {
        try {
            datos.update("INSERT INTO SUBGRUPO VALUES ("
                    + "'" + subgrupo.getCodigo() + "', "
                    + "'" + subgrupo.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Subgrupo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Subgrupo subgrupo, Subgrupo id) {
        try {
            datos.update("UPDATE SUBGRUPO SET "
                    + "NOMBRE = '" + subgrupo.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Subgrupo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM SUBGRUPO "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Subgrupo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInSubgrupoBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM SUBGRUPO");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInSubgrupoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO) FROM SUBGRUPO ORDER BY CODIGO");
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
