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
public class TipocontratoJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public TipocontratoJpaController() {
    }

    public void create(Tipocontrato tipocontrato) {
        try {
            datos.update("INSERT INTO " + tipocontrato.tabla + " VALUES ("
                    + "'" + tipocontrato.getCodigo() + "', "
                    + "'" + tipocontrato.getNombre() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Tipo Contrato");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Tipocontrato tipocontrato, Tipocontrato id) {
        try {
            datos.update("UPDATE TIPOCONTRATO SET "
                    + "NOMBRE = '" + tipocontrato.getNombre() + "' "
                    + "WHERE "
                    + "CODIGO = '" + id.getCodigo() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Tipo Contrato");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM TIPOCONTRATO "
                    + "WHERE "
                    + "CODIGO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Tipo Contrato");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findCodigoInTipocontratoBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT * FROM TIPOCONTRATO");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("CODIGO"));
            }
            return array;
        } catch (SQLException ex) {
            return array;
        }
    }

    public DefaultComboBoxModel COMBOCodigoInTipocontratoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(CODIGO), NOMBRE FROM TIPOCONTRATO ORDER BY CODIGO");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("NOMBRE") + " [" + ClaseBaseDatos.resultado.getString("CODIGO") + "]");
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
