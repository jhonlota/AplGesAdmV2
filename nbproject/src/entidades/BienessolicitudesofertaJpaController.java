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
public class BienessolicitudesofertaJpaController {
    
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public BienessolicitudesofertaJpaController() {
    }
    
    public void create(Bienessolicitudesoferta bienessolicitudesoferta) {
        
        try {
            datos.update("INSERT INTO "+ bienessolicitudesoferta.tabla +"VALUES ("
                    + bienessolicitudesoferta.getBienessolicitudesofertaPK().getFksolicitudoferta() + ", "
                    //+ soportescomprobantes.getSoportescomprobantesPK().getId() + ", "
                    + "'" + bienessolicitudesoferta.getNombre() + "', "
                    + "'" + bienessolicitudesoferta.getDescripcion() + "', "
                    + "'" + bienessolicitudesoferta.getCaracteristicas()+ "', "
                    + "" + bienessolicitudesoferta.getCantidad()+ ", "
                    + bienessolicitudesoferta.getBienessolicitudesofertaPK().getAno() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Bienes Solicitud Oferta");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Bienessolicitudesoferta bienessolicitudesoferta, Bienessolicitudesoferta id) {
        
        try {
            datos.update("UPDATE BIENESSOLICITUDESOFERTA SET "
                    + "NOMBRE = '" + bienessolicitudesoferta.getNombre() + "', "
                    + "DESCRIPCION = '" + bienessolicitudesoferta.getDescripcion() + "', "
                    + "CARACTERISTICAS = '" + bienessolicitudesoferta.getCaracteristicas() + "', "
                    + "CANTIDAD = " + bienessolicitudesoferta.getCantidad() + " "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + id.getBienessolicitudesofertaPK().getFksolicitudoferta() + "' AND "
                    + "ID = " + id.getBienessolicitudesofertaPK().getId() + " AND "
                    + "ANO = " + id.getBienessolicitudesofertaPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Bienes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(BienessolicitudesofertaPK id) {
        try {
            datos.update("DELETE FROM BIENESSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + id.getFksolicitudoferta() + "' AND "
                    + "ID = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Bienes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFksolicitudofertaAno(Solicitudesoferta id) {
        try {
            datos.update("DELETE FROM BIENESSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + id.getId() + "' AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Bienes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Bienessolicitudesoferta bienessolicitudesoferta) {   
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(bienessolicitudesoferta.getNombre(), "NOMBRE")
                    && ClaseInformacion.ValidarSeleccione(bienessolicitudesoferta.getDescripcion(), "DESCRIPCION")
                    && ClaseInformacion.ValidarSeleccione(bienessolicitudesoferta.getCaracteristicas(), "CARACTERISTICAS")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }
    
    public List<Bienessolicitudesoferta> findAllInBienessolicitudesofertaByFksolicitudofertaAno(String fksolicitudoferta, int ano) {
        List<Bienessolicitudesoferta> listBienessolicitudesoferta = new ArrayList<Bienessolicitudesoferta>();
        Bienessolicitudesoferta bienessolicitudesoferta;
        BienessolicitudesofertaPK bienessolicitudesofertaPK;

        try {
            datos.query("SELECT * FROM BIENESSOLICITUDESOFERTA WHERE FKSOLICITUDOFERTA = '" + fksolicitudoferta + "' AND ANO = " + ano + " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                bienessolicitudesoferta = new Bienessolicitudesoferta();
                bienessolicitudesofertaPK = new BienessolicitudesofertaPK();
                bienessolicitudesofertaPK.setFksolicitudoferta(ClaseBaseDatos.resultado.getString("FKSOLICITUDOFERTA"));
                bienessolicitudesofertaPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                bienessolicitudesofertaPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                bienessolicitudesoferta.setBienessolicitudesofertaPK(bienessolicitudesofertaPK);
                bienessolicitudesoferta.setNombre(ClaseBaseDatos.resultado.getString("NOMBRE"));
                bienessolicitudesoferta.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                bienessolicitudesoferta.setCaracteristicas(ClaseBaseDatos.resultado.getString("CARACTERISTICAS"));
                bienessolicitudesoferta.setCantidad(ClaseBaseDatos.resultado.getInt("CANTIDAD"));

                listBienessolicitudesoferta.add(bienessolicitudesoferta);
            }
            return listBienessolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
