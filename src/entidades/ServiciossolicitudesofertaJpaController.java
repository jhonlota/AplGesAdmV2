/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andres
 */
public class ServiciossolicitudesofertaJpaController {
    
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ServiciossolicitudesofertaJpaController() {
    }
    
    public void create(Serviciossolicitudesoferta serviciossolicitudesoferta) {
        
        try {
            datos.update("INSERT INTO "+ serviciossolicitudesoferta.tabla +"VALUES ("
                    + serviciossolicitudesoferta.getServiciossolicitudesofertaPK().getFksolicitudoferta() + ", "
                    //+ soportescomprobantes.getSoportescomprobantesPK().getId() + ", "
                    + "'" + serviciossolicitudesoferta.getNombre() + "', "
                    + "'" + serviciossolicitudesoferta.getDescripcion() + "', "
                    + "'" + serviciossolicitudesoferta.getCaracteristicas()+ "', "
                    + "" + serviciossolicitudesoferta.getCantidad()+ ", "
                    + serviciossolicitudesoferta.getServiciossolicitudesofertaPK().getAno() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Servicios Solicitud Oferta");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Serviciossolicitudesoferta serviciossolicitudesoferta, Serviciossolicitudesoferta id) {
        
        try {
            datos.update("UPDATE SERVICIOSSOLICITUDESOFERTA SET "
                    + "NOMBRE = '" + serviciossolicitudesoferta.getNombre() + "', "
                    + "DESCRIPCION = '" + serviciossolicitudesoferta.getDescripcion() + "', "
                    + "CARACTERISTICAS = '" + serviciossolicitudesoferta.getCaracteristicas() + "', "
                    + "CANTIDAD = " + serviciossolicitudesoferta.getCantidad() + " "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = " + id.getServiciossolicitudesofertaPK().getFksolicitudoferta() + " AND "
                    + "ID = " + id.getServiciossolicitudesofertaPK().getId() + " AND "
                    + "ANO = " + id.getServiciossolicitudesofertaPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Servicios");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ServiciossolicitudesofertaPK id) {
        try {
            datos.update("DELETE FROM SERVICIOSSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = " + id.getFksolicitudoferta() + " AND "
                    + "ID = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Servicios");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFksolicitudofertaAno(Solicitudesoferta id) {
        try {
            datos.update("DELETE FROM SERVICIOSSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Servicios");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Serviciossolicitudesoferta serviciossolicitudesoferta) {   
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(serviciossolicitudesoferta.getNombre(), "NOMBRE")
                    && ClaseInformacion.ValidarSeleccione(serviciossolicitudesoferta.getDescripcion(), "DESCRIPCION")
                    && ClaseInformacion.ValidarSeleccione(serviciossolicitudesoferta.getCaracteristicas(), "CARACTERISTICAS")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Serviciossolicitudesoferta> findAllInServiciossolicitudesofertaByFksolicitudofertaAno(String fksolicitudoferta, int ano) {
        List<Serviciossolicitudesoferta> listServiciossolicitudesoferta = new ArrayList<Serviciossolicitudesoferta>();
        Serviciossolicitudesoferta serviciossolicitudesoferta;
        ServiciossolicitudesofertaPK serviciossolicitudesofertaPK;

        try {
            datos.query("SELECT * FROM SERVICIOSSOLICITUDESOFERTA WHERE FKSOLICITUDOFERTA = " + fksolicitudoferta + " AND ANO = " + ano + " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                serviciossolicitudesoferta = new Serviciossolicitudesoferta();
                serviciossolicitudesofertaPK = new ServiciossolicitudesofertaPK();
                serviciossolicitudesofertaPK.setFksolicitudoferta(ClaseBaseDatos.resultado.getString("FKSOLICITUDOFERTA"));
                serviciossolicitudesofertaPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                serviciossolicitudesofertaPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                serviciossolicitudesoferta.setServiciossolicitudesofertaPK(serviciossolicitudesofertaPK);
                serviciossolicitudesoferta.setNombre(ClaseBaseDatos.resultado.getString("NOMBRE"));
                serviciossolicitudesoferta.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                serviciossolicitudesoferta.setCaracteristicas(ClaseBaseDatos.resultado.getString("CARACTERISTICAS"));
                serviciossolicitudesoferta.setCantidad(ClaseBaseDatos.resultado.getInt("CANTIDAD"));

                listServiciossolicitudesoferta.add(serviciossolicitudesoferta);
            }
            return listServiciossolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
