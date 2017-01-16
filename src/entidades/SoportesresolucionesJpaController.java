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
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class SoportesresolucionesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public SoportesresolucionesJpaController() {
    }

    public void create(Soportesresoluciones soportesresoluciones) {
        try {
            datos.update("INSERT INTO " + soportesresoluciones.tabla + " VALUES ("
                    + soportesresoluciones.getSoportesresolucionesPK().getFkresolucion() + ", "
                    //+ soportescomprobantes.getSoportescomprobantesPK().getId() + ", "
                    + "'" + soportesresoluciones.getFksoportecuenta() + "', "
                    + "'" + soportesresoluciones.getFksoportecuentaid()+ "', "
                    + "'" + soportesresoluciones.getFksoportecomprobante()+ "', "
                    + "'" + soportesresoluciones.getFksoportecomprobanteid()+ "', "
                    + "'" + soportesresoluciones.getFksoportecomprobanteano()+ "', "
                    + "'" + soportesresoluciones.getFktercerosresolucion()+ "', "
                    + "'" + soportesresoluciones.getActividad() + "', "
                    + "'" + soportesresoluciones.getCcostos() + "', "
                    + "'" + soportesresoluciones.getCinfo() + "', "
                    + "'" + soportesresoluciones.getCuenta() + "', "
                    + "'" + soportesresoluciones.getCuentainterna() + "', "
                    + "'" + soportesresoluciones.getSubgrupo() + "', "
                    + soportesresoluciones.getValor() + ", "
                    + soportesresoluciones.getSoportesresolucionesPK().getAno() +")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void editFksoportecuenta(Soportescuentas soportescuentas, Soportescuentas id) {
        try {
            datos.update("UPDATE SOPORTESRESOLUCIONES SET "
                    + "ACTIVIDAD = '" + soportescuentas.getActividad() + "', "
                    + "CCOSTOS = '" + soportescuentas.getCcostos() + "', "
                    + "CINFO = '" + soportescuentas.getCinfo() + "', "
                    + "CUENTA = '" + soportescuentas.getCuenta() + "', "
                    + "CUENTAINTERNA = '" + soportescuentas.getCuentainterna() + "', "
                    + "SUBGRUPO = '" + soportescuentas.getSubgrupo() + "', "
                    + "VALOR = " + soportescuentas.getValor() + " "
                    + "WHERE "
                    + "FKSOPORTECUENTA = " + id.getSoportescuentasPK().getFkcuenta() + "AND "
                    + "FKSOPORTECUENTAID = " +id.getSoportescuentasPK().getId());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFksoportecomprobante(Soportescomprobantes soportescomprobantes, Soportescomprobantes id) {
        try {
            datos.update("UPDATE SOPORTESRESOLUCIONES SET "
                    + "ACTIVIDAD = '" + soportescomprobantes.getActividad() + "', "
                    + "CCOSTOS = '" + soportescomprobantes.getCcostos() + "', "
                    + "CINFO = '" + soportescomprobantes.getCinfo() + "', "
                    + "CUENTA = '" + soportescomprobantes.getCuenta() + "', "
                    + "CUENTAINTERNA = '" + soportescomprobantes.getCuentainterna() + "', "
                    + "SUBGRUPO = '" + soportescomprobantes.getSubgrupo() + "', "
                    + "VALOR = " + soportescomprobantes.getValor() + " "
                    + "WHERE "
                    + "FKSOPORTECOMPROBANTE = " + id.getSoportescomprobantesPK().getFkcomprobante() + "AND "
                    + "FKSOPORTECOMPROBANTEID = " + id.getSoportescomprobantesPK().getId() + "AND "
                    + "FKSOPORTECOMPROBANTEANO = " +id.getSoportescomprobantesPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(SoportesresolucionesPK id) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKRESOLUCION = " + id.getFkresolucion() + " AND "
                    + "ID = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFkcuenta(SoportescuentasPK id) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKSOPORTECUENTA = " + id.getFkcuenta() + "AND "
                    + "FKSOPORTECUENTAID = " +id.getId());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFkcomprobante(SoportescomprobantesPK id) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKSOPORTECOMPROBANTE = " + id.getFkcomprobante() + "AND "
                    + "FKSOPORTECOMPROBANTEID = " + id.getId() + "AND "
                    + "FKSOPORTECOMPROBANTEANO = " +id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
        
    public void destroyFkresolucionAno(Resoluciones id) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKRESOLUCION = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte Resolución");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
}
