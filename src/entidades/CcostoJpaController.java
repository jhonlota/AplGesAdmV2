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
public class CcostoJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CcostoJpaController() {
    }

    public void create(Ccosto ccosto) {
        try {
            datos.update("INSERT INTO " + ccosto.tabla + " VALUES ("
                    + "'" + ccosto.getCodigo() + "', "
                    + "'" + ccosto.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Centro de Costos");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Ccosto ccosto, Ccosto id) {
        try {
            datos.update("UPDATE CCOSTO SET "
                    + "NOMBRE = '" + ccosto.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Centro de Costos");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM CCOSTO "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Centro de Costos");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInCcostoBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM CCOSTO");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInCcostoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO) FROM CCOSTO ORDER BY CODIGO");
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
