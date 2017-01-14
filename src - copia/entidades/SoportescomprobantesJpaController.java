/*
 * To change this template, choose Tools | Templates
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
 * @author Jhon Lopez
 */
public class SoportescomprobantesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public SoportescomprobantesJpaController() {
    }

    public void create(Soportescomprobantes soportescomprobantes) {
        try {
            datos.update("INSERT INTO " + soportescomprobantes.tabla + " VALUES ("
                    + soportescomprobantes.getSoportescomprobantesPK().getFkcomprobante() + ", "
                    //+ soportescomprobantes.getSoportescomprobantesPK().getId() + ", "
                    + "'" + soportescomprobantes.getActividad() + "', "
                    + "'" + soportescomprobantes.getCcostos() + "', "
                    + "'" + soportescomprobantes.getCinfo() + "', "
                    + "'" + soportescomprobantes.getCuenta() + "', "
                    + "'" + soportescomprobantes.getCuentainterna() + "', "
                    + "'" + soportescomprobantes.getSubgrupo() + "', "
                    + soportescomprobantes.getValor() + ", "
                    + soportescomprobantes.getSoportescomprobantesPK().getAno() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Soportescomprobantes soportescomprobantes, Soportescomprobantes id) {
        try {
            datos.update("UPDATE SOPORTESCOMPROBANTES SET "
                    + "ACTIVIDAD = '" + soportescomprobantes.getActividad() + "', "
                    + "CCOSTOS = '" + soportescomprobantes.getCcostos() + "', "
                    + "CINFO = '" + soportescomprobantes.getCinfo() + "', "
                    + "CUENTA = '" + soportescomprobantes.getCuenta() + "', "
                    + "CUENTAINTERNA = '" + soportescomprobantes.getCuentainterna() + "', "
                    + "SUBGRUPO = '" + soportescomprobantes.getSubgrupo() + "', "
                    + "VALOR = " + soportescomprobantes.getValor() + " "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getSoportescomprobantesPK().getFkcomprobante() + " AND "
                    + "ID = " + id.getSoportescomprobantesPK().getId() + " AND "
                    + "ANO = " + id.getSoportescomprobantesPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(SoportescomprobantesPK id) {
        try {
            datos.update("DELETE FROM SOPORTESCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getFkcomprobante() + " AND "
                    + "ID = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcomprobanteAno(Comprobantes id) {
        try {
            datos.update("DELETE FROM SOPORTESCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Soportescomprobantes soportescomprobantes) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(soportescomprobantes.getCcostos(), "C. COSTOS")
                    && ClaseInformacion.ValidarSeleccione(soportescomprobantes.getCinfo(), "C. INFO")
                    && ClaseInformacion.ValidarSeleccione(soportescomprobantes.getCuenta(), "CUENTA")
                    && ClaseInformacion.ValidarSeleccione(soportescomprobantes.getCuentainterna(), "CUENTA INTERNA")
                    && ClaseInformacion.ValidarSeleccione("" + soportescomprobantes.getValor(), "VALOR")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Soportescomprobantes> findAllInSoportescomprobantesByFkcomprobanteAno(int fkcomprobante, int ano) {
        List<Soportescomprobantes> listSoportescomprobantes = new ArrayList<Soportescomprobantes>();
        Soportescomprobantes soportescomprobantes;
        SoportescomprobantesPK soportescomprobantesPK;

        try {
            datos.query("SELECT * FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + " ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                soportescomprobantes = new Soportescomprobantes();
                soportescomprobantesPK = new SoportescomprobantesPK();
                soportescomprobantesPK.setFkcomprobante(ClaseBaseDatos.resultado.getInt("FKCOMPROBANTE"));
                soportescomprobantesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportescomprobantesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportescomprobantes.setSoportescomprobantesPK(soportescomprobantesPK);
                soportescomprobantes.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportescomprobantes.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportescomprobantes.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportescomprobantes.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportescomprobantes.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportescomprobantes.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportescomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportescomprobantes.add(soportescomprobantes);
            }
            return listSoportescomprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public boolean findCALCInSoportescomprobantesByFkcomprobanteAno(int fkcomprobante, int ano) {
        try {
            datos.query("SELECT * FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " "
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

    public List<Soportescomprobantes> findCALCInSoportescomprobantesByFkcomprobanteAnoFechaAplicacion(int fkcomprobante, int ano, Date fechaAplicacion) {
        List<Soportescomprobantes> listSoportescomprobantes = new ArrayList<Soportescomprobantes>();
        Soportescomprobantes soportescomprobantes;
        SoportescomprobantesPK soportescomprobantesPK;

        try {
            datos.query("SELECT SOPORTESCOMPROBANTES.* "
                    + "FROM COMPROBANTES, SOPORTESCOMPROBANTES "
                    + "WHERE COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE "
                    + "AND COMPROBANTES.FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaAplicacion) + "' "
                    + "AND COMPROBANTES.ANO = " + ano + " "
                    + "AND SOPORTESCOMPROBANTES.ANO = " + ano + " "
                    + "AND SOPORTESCOMPROBANTES.ACTIVIDAD IN (SELECT ACTIVIDAD FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + ") "
                    + "AND SOPORTESCOMPROBANTES.CCOSTOS IN (SELECT CCOSTOS FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + ") "
                    + "AND SOPORTESCOMPROBANTES.CINFO IN (SELECT CINFO FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + ") "
                    + "AND SOPORTESCOMPROBANTES.CUENTA IN (SELECT CUENTA FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + ") "
                    + "AND SOPORTESCOMPROBANTES.SUBGRUPO IN (SELECT SUBGRUPO FROM SOPORTESCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + ") "
                    + "ORDER BY COMPROBANTES.COMPROBANTE, SOPORTESCOMPROBANTES.CUENTA, SOPORTESCOMPROBANTES.ACTIVIDAD, SOPORTESCOMPROBANTES.SUBGRUPO, SOPORTESCOMPROBANTES.CCOSTOS, SOPORTESCOMPROBANTES.CINFO, SOPORTESCOMPROBANTES.CUENTAINTERNA");
            while (ClaseBaseDatos.resultado.next()) {
                soportescomprobantes = new Soportescomprobantes();
                soportescomprobantesPK = new SoportescomprobantesPK();
                soportescomprobantesPK.setFkcomprobante(ClaseBaseDatos.resultado.getInt("FKCOMPROBANTE"));
                soportescomprobantesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportescomprobantesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                soportescomprobantes.setSoportescomprobantesPK(soportescomprobantesPK);
                soportescomprobantes.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportescomprobantes.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportescomprobantes.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportescomprobantes.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportescomprobantes.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportescomprobantes.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportescomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportescomprobantes.add(soportescomprobantes);
            }
            return listSoportescomprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Soportescomprobantes> findCALCInSoportescomprobantesByAnoFechaAplicacion(int ano, Date fechaAplicacion) {
        List<Soportescomprobantes> listSoportescomprobantes = new ArrayList<Soportescomprobantes>();
        Soportescomprobantes soportescomprobantes;
        SoportescomprobantesPK soportescomprobantesPK;

        try {
            datos.query("SELECT SOPORTESCOMPROBANTES.CUENTA, SOPORTESCOMPROBANTES.ACTIVIDAD, SOPORTESCOMPROBANTES.SUBGRUPO, SOPORTESCOMPROBANTES.CCOSTOS, SOPORTESCOMPROBANTES.CINFO, SOPORTESCOMPROBANTES.CUENTAINTERNA, SUM(SOPORTESCOMPROBANTES.VALOR) AS VALOR "
                    + "FROM COMPROBANTES, SOPORTESCOMPROBANTES "
                    + "WHERE COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE "
                    + "AND COMPROBANTES.FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaAplicacion) + "' "
                    + "AND COMPROBANTES.ANO = " + ano + " "
                    + "AND SOPORTESCOMPROBANTES.ANO = " + ano + " "
                    + "GROUP BY SOPORTESCOMPROBANTES.CUENTA, SOPORTESCOMPROBANTES.ACTIVIDAD, SOPORTESCOMPROBANTES.SUBGRUPO, SOPORTESCOMPROBANTES.CCOSTOS, SOPORTESCOMPROBANTES.CINFO, SOPORTESCOMPROBANTES.CUENTAINTERNA "
                    + "ORDER BY SOPORTESCOMPROBANTES.CUENTA, SOPORTESCOMPROBANTES.ACTIVIDAD, SOPORTESCOMPROBANTES.SUBGRUPO, SOPORTESCOMPROBANTES.CCOSTOS, SOPORTESCOMPROBANTES.CINFO, SOPORTESCOMPROBANTES.CUENTAINTERNA");
            while (ClaseBaseDatos.resultado.next()) {
                soportescomprobantes = new Soportescomprobantes();
                soportescomprobantesPK = new SoportescomprobantesPK();
                soportescomprobantes.setSoportescomprobantesPK(soportescomprobantesPK);
                soportescomprobantes.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportescomprobantes.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportescomprobantes.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportescomprobantes.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportescomprobantes.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportescomprobantes.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportescomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportescomprobantes.add(soportescomprobantes);
            }
            return listSoportescomprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
