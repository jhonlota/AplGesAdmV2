/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.sql.SQLException;

/**
 *
 * @author Jhon Lopez
 */
public class CalificacionJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CalificacionJpaController() {
    }

    public void create(Calificacion calificacion) {
        try {
            datos.update("INSERT INTO " + calificacion.tabla + " VALUES ("
//                    + "" + calificacion.getId() + ", "
                    + "'" + calificacion.getFktercero() + "', "
                    + "'" + calificacion.getTramite() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(calificacion.getFecha())  + "', "
                    + "'" + calificacion.getDescripcion() + "', "
                    + calificacion.getValor() + ", "
                    + "'" + calificacion.getObservacion() + "', "
                    + calificacion.getPregunta1() + ", "
                    + calificacion.getPregunta2() + ", "
                    + calificacion.getPregunta3() + ", "
                    + calificacion.getPregunta4() + ", "
                    + calificacion.getPregunta5() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Tramite " + calificacion.getTramite());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }
    
    public boolean findSoporteInCalificacionByTramite(String soporte) {
        boolean is = false;

        try {
            datos.query("SELECT * FROM CALIFICACION "
                    + "WHERE "
                    + "tramite = '" + soporte + "' ");
            while (ClaseBaseDatos.resultado.next()) {
                is = true;
            }
            return is;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return is;
        }
    }
}
