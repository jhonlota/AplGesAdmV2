/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
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
                    + soportesresoluciones.getFksoportecuentaid()+ ", "
                    + soportesresoluciones.getFksoportecomprobante()+ ", "
                    + soportesresoluciones.getFksoportecomprobanteid()+ ", "
                    + soportesresoluciones.getFksoportecomprobanteano()+ ", "
                    + soportesresoluciones.getFktercerosresolucion()+ ", "
                    + "'" + soportesresoluciones.getActividad() + "', "
                    + "'" + soportesresoluciones.getCcostos() + "', "
                    + "'" + soportesresoluciones.getCinfo() + "', "
                    + "'" + soportesresoluciones.getCuenta() + "', "
                    + "'" + soportesresoluciones.getCuentainterna() + "', "
                    + "'" + soportesresoluciones.getSubgrupo() + "', "
                    + soportesresoluciones.getValor() + ", "
                    + soportesresoluciones.getSoportesresolucionesPK().getAno() +")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Soporte - Resolucion");
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
                    + "FKSOPORTECUENTA = '" + id.getSoportescuentasPK().getFkcuenta() + "' AND "
                    + "FKSOPORTECUENTAID = " +id.getSoportescuentasPK().getId());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte - Resolucion");
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
                    + "FKSOPORTECOMPROBANTE = " + id.getSoportescomprobantesPK().getFkcomprobante() + " AND "
                    + "FKSOPORTECOMPROBANTEID = " + id.getSoportescomprobantesPK().getId() + " AND "
                    + "FKSOPORTECOMPROBANTEANO = " +id.getSoportescomprobantesPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(int fkresolucion, int id, int ano) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKRESOLUCION = " + fkresolucion + " AND "
                    + "ID = " + id+ " AND "
                    + "ANO = " + ano);
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte - Resolucion");
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
                    + "FKSOPORTECUENTA = '" + id.getFkcuenta() + "' AND "
                    + "FKSOPORTECUENTAID = " +id.getId());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte - Resolucion");
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
                    + "FKSOPORTECOMPROBANTE = " + id.getFkcomprobante() + " AND "
                    + "FKSOPORTECOMPROBANTEID = " + id.getId() + " AND "
                    + "FKSOPORTECOMPROBANTEANO = " +id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte - Resolucion");
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
                ClaseMensaje.informacionEliminarBD("Soporte - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFktercerosresolucion(Tercerosresoluciones id) {
        try {
            datos.update("DELETE FROM SOPORTESRESOLUCIONES "
                    + "WHERE "
                    + "FKTERCEROSRESOLUCION = " + id.getId());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public List<Soportesresoluciones> findAllInSoportesresolucionesByFkresolucionAnoFktercerosresolucion(int fkresolucion, int ano, int fkterceroresolucion) {
        List<Soportesresoluciones> listSoportesresoluciones = new ArrayList<Soportesresoluciones>();
        Soportesresoluciones soportesresoluciones;
        SoportesresolucionesPK soportesresolucionesPK;

        try {
            datos.query("SELECT * FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + " AND FKTERCEROSRESOLUCION = " +fkterceroresolucion+ " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                soportesresoluciones = new Soportesresoluciones();
                soportesresolucionesPK = new SoportesresolucionesPK();
                soportesresolucionesPK.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                soportesresolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportesresolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportesresoluciones.setSoportesresolucionesPK(soportesresolucionesPK);
                soportesresoluciones.setFksoportecuenta(ClaseBaseDatos.resultado.getString("FKSOPORTECUENTA"));
                soportesresoluciones.setFksoportecuentaid(ClaseBaseDatos.resultado.getInt("FKSOPORTECUENTAID"));
                soportesresoluciones.setFksoportecomprobante(ClaseBaseDatos.resultado.getInt("FKSOPORTECOMPROBANTE"));
                soportesresoluciones.setFksoportecomprobanteid(ClaseBaseDatos.resultado.getInt("FKSOPORTECOMPROBANTEID"));
                soportesresoluciones.setFksoportecomprobanteano(ClaseBaseDatos.resultado.getInt("FKSOPORTECOMPROBANTEANO"));
                soportesresoluciones.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportesresoluciones.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportesresoluciones.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportesresoluciones.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportesresoluciones.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportesresoluciones.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportesresoluciones.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportesresoluciones.add(soportesresoluciones);
            }
            return listSoportesresoluciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
