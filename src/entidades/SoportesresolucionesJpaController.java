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

    public boolean verify(Soportesresoluciones soportesresoluciones) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(soportesresoluciones.getCcostos(), "C. COSTOS")
                    && ClaseInformacion.ValidarSeleccione(soportesresoluciones.getCinfo(), "C. INFO")
                    && ClaseInformacion.ValidarSeleccione(soportesresoluciones.getCuenta(), "CUENTA")
                    && ClaseInformacion.ValidarSeleccione(soportesresoluciones.getCuentainterna(), "CUENTA INTERNA")
                    && ClaseInformacion.ValidarSeleccione("" + soportesresoluciones.getValor(), "VALOR")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Soportesresoluciones> findAllInSoportesresolucionesByFkresolucionAno(int fkresolucion, int ano) {
        List<Soportesresoluciones> listSoportesresoluciones = new ArrayList<Soportesresoluciones>();
        Soportesresoluciones soportesresoluciones;
        SoportesresolucionesPK soportesresolucionesPK;

        try {
            datos.query("SELECT * FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                soportesresoluciones = new Soportesresoluciones();
                soportesresolucionesPK = new SoportesresolucionesPK();
                soportesresolucionesPK.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                soportesresolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportesresolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportesresoluciones.setSoportesresolucionesPK(soportesresolucionesPK);
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

        public List<Soportesresoluciones> findAllInSoportesresolucionesByFkresolucionAnoFktercerosresolucion(int fkresolucion, int ano, int fkterceroresolucion) {
        List<Soportesresoluciones> listSoportesresoluciones = new ArrayList<Soportesresoluciones>();
        Soportesresoluciones soportesresoluciones;
        SoportesresolucionesPK soportesresolucionesPK;

        try {
            datos.query("SELECT * FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + "AND FKTERCEROSRESOLUCION = " +fkterceroresolucion+ " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                soportesresoluciones = new Soportesresoluciones();
                soportesresolucionesPK = new SoportesresolucionesPK();
                soportesresolucionesPK.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                soportesresolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportesresolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportesresoluciones.setSoportesresolucionesPK(soportesresolucionesPK);
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
        
    public boolean findCALCInSoportesresolucionesByFkresolucionAno(int fkresolucion, int ano) {
        try {
            datos.query("SELECT * FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " "
                    + "AND ANO = " + ano + " "
                    + "AND (SUBGRUPO = '072' OR SUBGRUPO = '073' OR SUBGRUPO = '101')");
            while (ClaseBaseDatos.resultado.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return false;
        }
    }

    public List<Soportesresoluciones> findCALCInSoportesresolucionesByFkresolucionAnoFechaAplicacion(int fkresolucion, int ano, Date fechaAplicacion) {
        List<Soportesresoluciones> listSoportesresoluciones = new ArrayList<Soportesresoluciones>();
        Soportesresoluciones soportesresoluciones;
        SoportesresolucionesPK soportesresolucionesPK;

        try {
            datos.query("SELECT SOPORTESRESOLUCIONES.* "
                    + "FROM RESOLUCIONES, SOPORTESRESOLUCIONES "
                    + "WHERE RESOLUCIONES.ID = SOPORTESRESOLUCIONES.FKRESOLUCION "
                    + "AND RESOLUCIONES.FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaAplicacion) + "' "
                    + "AND RESOLUCIONES.ANO = " + ano + " "
                    + "AND SOPORTESRESOLUCIONES.ANO = " + ano + " "
                    + "AND SOPORTESRESOLUCIONES.ACTIVIDAD IN (SELECT ACTIVIDAD FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + ") "
                    + "AND SOPORTESRESOLUCIONES.CCOSTOS IN (SELECT CCOSTOS FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + ") "
                    + "AND SOPORTESRESOLUCIONES.CINFO IN (SELECT CINFO FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + ") "
                    + "AND SOPORTESRESOLUCIONES.CUENTA IN (SELECT CUENTA FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + ") "
                    + "AND SOPORTESRESOLUCIONES.SUBGRUPO IN (SELECT SUBGRUPO FROM SOPORTESRESOLUCIONES WHERE FKRESOLUCION = " + fkresolucion + " AND ANO = " + ano + ") "
                    + "ORDER BY RESOLUCIONES.RESOLUCION, SOPORTESRESOLUCIONES.CUENTA, SOPORTESRESOLUCIONES.ACTIVIDAD, SOPORTESRESOLUCIONES.SUBGRUPO, SOPORTESRESOLUCIONES.CCOSTOS, SOPORTESRESOLUCIONES.CINFO, SOPORTESRESOLUCIONES.CUENTAINTERNA");
            while (ClaseBaseDatos.resultado.next()) {
                soportesresoluciones = new Soportesresoluciones();
                soportesresolucionesPK = new SoportesresolucionesPK();
                soportesresolucionesPK.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                soportesresolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportesresolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportesresoluciones.setSoportesresolucionesPK(soportesresolucionesPK);
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

    public List<Soportesresoluciones> findCALCInSoportesresolucionesByAnoFechaAplicacion(int ano, Date fechaAplicacion) {
        List<Soportesresoluciones> listSoportesresolucioness = new ArrayList<Soportesresoluciones>();
        Soportesresoluciones soportesresoluciones;
        SoportesresolucionesPK soportesresolucionesPK;

        try {
            datos.query("SELECT SOPORTESRESOLUCIONES.CUENTA, SOPORTESRESOLUCIONES.ACTIVIDAD, SOPORTESRESOLUCIONES.SUBGRUPO, SOPORTESRESOLUCIONES.CCOSTOS, SOPORTESRESOLUCIONES.CINFO, SOPORTESRESOLUCIONES.CUENTAINTERNA, SUM(SOPORTESRESOLUCIONES.VALOR) AS VALOR "
                    + "FROM RESOLUCIONES, SOPORTESRESOLUCIONES "
                    + "WHERE RESOLUCIONES.ID = SOPORTESRESOLUCIONES.FKRESOLUCION "
                    + "AND RESOLUCIONES.FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaAplicacion) + "' "
                    + "AND RESOLUCIONES.ANO = " + ano + " "
                    + "AND SOPORTESRESOLUCIONES.ANO = " + ano + " "
                    + "GROUP BY SOPORTESRESOLUCIONES.CUENTA, SOPORTESRESOLUCIONES.ACTIVIDAD, SOPORTESRESOLUCIONES.SUBGRUPO, SOPORTESRESOLUCIONES.CCOSTOS, SOPORTESRESOLUCIONES.CINFO, SOPORTESRESOLUCIONES.CUENTAINTERNA "
                    + "ORDER BY SOPORTESRESOLUCIONES.CUENTA, SOPORTESRESOLUCIONES.ACTIVIDAD, SOPORTESRESOLUCIONES.SUBGRUPO, SOPORTESRESOLUCIONES.CCOSTOS, SOPORTESRESOLUCIONES.CINFO, SOPORTESRESOLUCIONES.CUENTAINTERNA");
            while (ClaseBaseDatos.resultado.next()) {
                soportesresoluciones = new Soportesresoluciones();
                soportesresolucionesPK = new SoportesresolucionesPK();
                soportesresoluciones.setSoportesresolucionesPK(soportesresolucionesPK);
                soportesresoluciones.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportesresoluciones.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportesresoluciones.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportesresoluciones.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportesresoluciones.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportesresoluciones.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportesresoluciones.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportesresolucioness.add(soportesresoluciones);
            }
            return listSoportesresolucioness;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
