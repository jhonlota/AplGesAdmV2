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
public class EstandarJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public EstandarJpaController() {
    }

    public void create(Estandar estandar) {
        try {
            datos.update("INSERT INTO " + estandar.tabla + " VALUES ("
                    + "'" + estandar.getModulo() + "', "
                    + "'" + estandar.getCampo() + "', "
                    + "'" + estandar.getValor() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Estandar");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Estandar estandar, Estandar id) {
        try {
            datos.update("UPDATE ESTANDAR SET "
                    + "VALOR = '" + estandar.getValor() + "' "
                    + "WHERE "
                    + "MODULO = '" + id.getModulo() + "' "
                    + "AND CAMPO = '" + id.getValor() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Estandar");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Estandar id) {
        try {
            datos.update("DELETE FROM ESTANDAR "
                    + "WHERE "
                    + "MODULO = '" + id.getModulo() + "' "
                    + "AND CAMPO = '" + id.getValor() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Estandar");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public String findValorInEstandarByModuloCampo(String modulo, String campo) {
        String text = new String();

        try {
            datos.query("SELECT * FROM ESTANDAR "
                    + "WHERE "
                    + "MODULO = '" + modulo + "' "
                    + "AND CAMPO = '" + campo + "'");
            while (ClaseBaseDatos.resultado.next()) {
                text = ClaseBaseDatos.resultado.getString("VALOR");
            }
            return text;
        } catch (SQLException ex) {
            return text;
        }
    }
}
