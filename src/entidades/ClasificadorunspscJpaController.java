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

    public List<Clasificadorunspsc> findAllInClasificadorunspscBy() {
        List<Clasificadorunspsc> listClasificadorunspsc = new ArrayList<Clasificadorunspsc>();
        Clasificadorunspsc clasificadorunspsc;

        try {
            datos.query("SELECT * FROM CLASIFICADORUNSPSC "
                    + "WHERE "
                    + "TO_ASCII(" + ClaseGeneral.parametro + ") ILIKE TO_ASCII('%" + ClaseGeneral.valor + "%') "
                    + "ORDER BY CODIGOGRUPO, CODIGOSEGMENTO, CODIGOFAMILIA, CODIGOCLASE, CODIGOPRODUCTO");
            while (ClaseBaseDatos.resultado.next()) {
                clasificadorunspsc = new Clasificadorunspsc();
                clasificadorunspsc.setCodigosegmento(ClaseBaseDatos.resultado.getString("CODIGOSEGMENTO"));
                clasificadorunspsc.setNombresegmento(ClaseBaseDatos.resultado.getString("NOMBRESEGMENTO"));
                clasificadorunspsc.setCodigofamilia(ClaseBaseDatos.resultado.getString("CODIGOFAMILIA"));
                clasificadorunspsc.setNombrefamilia(ClaseBaseDatos.resultado.getString("NOMBREFAMILIA"));
                clasificadorunspsc.setCodigoclase(ClaseBaseDatos.resultado.getString("CODIGOCLASE"));
                clasificadorunspsc.setNombreclase(ClaseBaseDatos.resultado.getString("NOMBRECLASE"));
                clasificadorunspsc.setCodigoproducto(ClaseBaseDatos.resultado.getString("CODIGOPRODUCTO"));
                clasificadorunspsc.setNombreproducto(ClaseBaseDatos.resultado.getString("NOMBREPRODUCTO"));
                clasificadorunspsc.setCodigogrupo(ClaseBaseDatos.resultado.getString("CODIGOGRUPO"));
                clasificadorunspsc.setNombregrupo(ClaseBaseDatos.resultado.getString("NOMBREGRUPO"));
                
                listClasificadorunspsc.add(clasificadorunspsc);
            }
            
            return listClasificadorunspsc;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
