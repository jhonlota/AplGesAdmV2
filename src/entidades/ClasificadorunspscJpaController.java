/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jhon Lopez
 */
public class ClasificadorunspscJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ClasificadorunspscJpaController() {
    }

    public void create(Actividad actividad) {
        try {
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Actividad actividad, Actividad id) {
        try {
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public ArrayList<String> findAllInClasificadorunspscBy() {
        ArrayList<String> array = new ArrayList<String>();

        try {
            datos.query("SELECT codigo" + ClaseGeneral.parametro + ", nombre" + ClaseGeneral.parametro + " FROM CLASIFICADORUNSPSC "
                    + "WHERE "
                    + "TO_ASCII(nombre" + ClaseGeneral.parametro + ") ILIKE TO_ASCII('%" + ClaseGeneral.valor + "%') "
                    + "GROUP BY codigo" + ClaseGeneral.parametro + ", nombre" + ClaseGeneral.parametro + " "
                    + "ORDER BY codigo" + ClaseGeneral.parametro + ", nombre" + ClaseGeneral.parametro + "");
            while (ClaseBaseDatos.resultado.next()) {
                array.add(ClaseBaseDatos.resultado.getString("nombre" + ClaseGeneral.parametro) + " [" + ClaseBaseDatos.resultado.getString("codigo" + ClaseGeneral.parametro) + "]");
            }

            return array;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
