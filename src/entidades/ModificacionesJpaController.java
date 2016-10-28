/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class ModificacionesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ModificacionesJpaController() {
    }

    public void create(Modificaciones modificaciones) {
        try {
            datos.update("INSERT INTO " + modificaciones.tabla + " VALUES ("
                    + "'" + ClaseInformacion.ConvertirFecha(modificaciones.getModificacionesPK().getFechamodifprorr()) + "', "
                    + "'" + modificaciones.getModificacionesPK().getFkcontrato() + "', "
                    + "'" + modificaciones.getTipomodifprorr() + "', "
                    + modificaciones.getValortotalmodifprorr() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Modificacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Modificaciones modificaciones, Modificaciones id) {
        try {
            datos.update("UPDATE MODIFICACIONES SET "
                    + "TIPOMODIFPRORR = '" + modificaciones.getTipomodifprorr() + "', "
                    + "VALORTOTALMODIFPRORR = " + modificaciones.getValortotalmodifprorr() + " "
                    + "WHERE "
                    + "FECHAMODIFPRORR = '" + ClaseInformacion.ConvertirFecha(id.getModificacionesPK().getFechamodifprorr()) + "' AND "
                    + "FKCONTRATO = '" + id.getModificacionesPK().getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Modificacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE MODIFICACIONES SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ModificacionesPK id) {
        try {
            datos.update("DELETE FROM MODIFICACIONES "
                    + "WHERE "
                    + "FECHAMODIFPRORR = '" + ClaseInformacion.ConvertirFecha(id.getFechamodifprorr()) + "' AND "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Modificacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM MODIFICACIONES "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Modificacion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Modificaciones> findAllInModificacionesByFkcontrato(String fkcontrato) {
        List<Modificaciones> listModificaciones = new ArrayList<Modificaciones>();
        Modificaciones modificaciones;
        ModificacionesPK modificacionesPK;

        try {
            datos.query("SELECT * FROM MODIFICACIONES WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY FECHAMODIFPRORR, TIPOMODIFPRORR");
            while (ClaseBaseDatos.resultado.next()) {
                modificaciones = new Modificaciones();
                modificacionesPK = new ModificacionesPK();
                modificacionesPK.setFechamodifprorr(ClaseBaseDatos.resultado.getDate("FECHAMODIFPRORR"));
                modificacionesPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                modificaciones.setModificacionesPK(modificacionesPK);
                modificaciones.setTipomodifprorr(ClaseBaseDatos.resultado.getString("TIPOMODIFPRORR"));
                modificaciones.setValortotalmodifprorr(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORTOTALMODIFPRORR"))));

                listModificaciones.add(modificaciones);
            }
            return listModificaciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
