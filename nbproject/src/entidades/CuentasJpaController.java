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
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class CuentasJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CuentasJpaController() {
    }

    public void create(Cuentas cuentas) {
        try {
            datos.update("INSERT INTO CUENTAS VALUES ("
                    + "'" + cuentas.getDocumento() + "', "
                    + "'" + cuentas.getCuentacontrol() + "', "
                    + "'" + cuentas.getDescripcion() + "', "
                    + cuentas.getEgreso() + ", "
                    + "'" + ClaseInformacion.ConvertirFecha(cuentas.getFechadigitacion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(cuentas.getFechapresupuestal()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(cuentas.getFechatransaccion()) + "', "
                    + "'" + cuentas.getFktercero() + "', "
                    + cuentas.getIngreso() + ", "
                    + "'" + cuentas.getSoporte() + "', "
                    + "'" + cuentas.getFkcontrato() + "', "
                    + "'" + cuentas.getNumeroseguimiento()+ "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Cuenta " + cuentas.getSoporte());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Cuentas cuentas, Cuentas id) {
        try {
            datos.update("UPDATE CUENTAS SET "
                    + "SOPORTE = '" + cuentas.getSoporte() + "', "
                    + "CUENTACONTROL = '" + cuentas.getCuentacontrol() + "', "
                    + "DESCRIPCION = '" + cuentas.getDescripcion() + "', "
                    + "EGRESO = " + cuentas.getEgreso() + ", "
                    + "FECHADIGITACION = '" + ClaseInformacion.ConvertirFecha(cuentas.getFechadigitacion()) + "', "
                    + "FECHAPRESUPUESTAL = '" + ClaseInformacion.ConvertirFecha(cuentas.getFechapresupuestal()) + "', "
                    + "FECHATRANSACCION = '" + ClaseInformacion.ConvertirFecha(cuentas.getFechatransaccion()) + "', "
                    + "FKTERCERO = '" + cuentas.getFktercero() + "', "
                    + "INGRESO = " + cuentas.getIngreso() + ", "
                    + "DOCUMENTO = '" + cuentas.getDocumento() + "', "
                    + "FKCONTRATO = '" + cuentas.getFkcontrato() + "', "
                    + "NUMEROSEGUIMIENTO = '" + cuentas.getNumeroseguimiento() + "' "
                    + "WHERE "
                    + "SOPORTE = '" + id.getSoporte() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Cuenta " + cuentas.getSoporte());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE CUENTAS SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE CUENTAS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM CUENTAS "
                    + "WHERE "
                    + "SOPORTE = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Cuenta " + id);
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Cuentas cuentas) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (((ClaseGeneral.perfil.equals("root") ? true : ClaseInformacion.ValidarCuentas(cuentas.getSoporte()))
                    || ClaseInformacion.ValidarCuentaSALDO(cuentas.getSoporte()))
                    && ClaseInformacion.ValidarSeleccione(cuentas.getDescripcion(), "DESCRIPCION DEL PAGO")
                    && (ClaseGeneral.perfil.equals("root") ? true : ClaseInformacion.ValidarSeleccione("" + cuentas.getEgreso(), "VALOR EGRESO"))
                    && ClaseInformacion.ValidarSeleccione(cuentas.getFktercero(), "CÉDULA DEL PROVEEDOR")
                    && ClaseInformacion.ValidarSeleccione(cuentas.getSoporte(), "SOPORTE")
                    && (ClaseGeneral.perfil.equals("root") ? true : (cuentas.getFkcontrato().equals("N/A") ? true : ClaseInformacion.ValidarContratos(cuentas.getFkcontrato())))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Cuentas> findAllInCuentasByEntities() {
        List<Cuentas> listCuentas = new ArrayList<Cuentas>();
        Cuentas cuentas;

        try {
            datos.query("SELECT * FROM CUENTAS ORDER BY FECHADIGITACION DESC");
            while (ClaseBaseDatos.resultado.next()) {
                cuentas = new Cuentas();

                cuentas.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                cuentas.setCuentacontrol(ClaseBaseDatos.resultado.getString("CUENTACONTROL"));
                cuentas.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                cuentas.setEgreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("EGRESO"))));
                cuentas.setFechadigitacion(ClaseBaseDatos.resultado.getDate("FECHADIGITACION"));
                cuentas.setFechapresupuestal(ClaseBaseDatos.resultado.getDate("FECHAPRESUPUESTAL"));
                cuentas.setFechatransaccion(ClaseBaseDatos.resultado.getDate("FECHATRANSACCION"));
                cuentas.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                cuentas.setIngreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("INGRESO"))));
                cuentas.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                cuentas.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                cuentas.setNumeroseguimiento(ClaseBaseDatos.resultado.getString("NUMEROSEGUIMIENTO"));

                listCuentas.add(cuentas);
            }
            return listCuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Cuentas> findAllInCuentasBy() {
        List<Cuentas> listCuentas = new ArrayList<Cuentas>();
        Cuentas cuentas;

        try {
            datos.query("SELECT * FROM CUENTAS "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                    + "ORDER BY FECHADIGITACION DESC");
            while (ClaseBaseDatos.resultado.next()) {
                cuentas = new Cuentas();
                cuentas.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                cuentas.setCuentacontrol(ClaseBaseDatos.resultado.getString("CUENTACONTROL"));
                cuentas.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                cuentas.setEgreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("EGRESO"))));
                cuentas.setFechadigitacion(ClaseBaseDatos.resultado.getDate("FECHADIGITACION"));
                cuentas.setFechapresupuestal(ClaseBaseDatos.resultado.getDate("FECHAPRESUPUESTAL"));
                cuentas.setFechatransaccion(ClaseBaseDatos.resultado.getDate("FECHATRANSACCION"));
                cuentas.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                cuentas.setIngreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("INGRESO"))));
                cuentas.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                cuentas.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                cuentas.setNumeroseguimiento(ClaseBaseDatos.resultado.getString("NUMEROSEGUIMIENTO"));

                listCuentas.add(cuentas);
            }
            return listCuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
    
    public List<Cuentas> findAllInCuentasAndSoportescuentasBy() {
        
        List<Cuentas> listCuentas = new ArrayList<Cuentas>();
        Cuentas cuentas;

        try {
            datos.query("SELECT DISTINCT(CUENTAS.SOPORTE), CUENTAS.DOCUMENTO, CUENTAS.CUENTACONTROL, CUENTAS.DESCRIPCION, "
                    + "CUENTAS.EGRESO, CUENTAS.FECHADIGITACION, CUENTAS.FECHAPRESUPUESTAL, CUENTAS.FECHATRANSACCION, "
                    + "CUENTAS.FKTERCERO, CUENTAS.INGRESO, CUENTAS.SOPORTE, CUENTAS.FKCONTRATO, CUENTAS.NUMEROSEGUIMIENTO "
                    + "FROM CUENTAS LEFT JOIN SOPORTESCUENTAS ON CUENTAS.SOPORTE = SOPORTESCUENTAS.FKCUENTA "
                    + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                    + "ORDER BY FECHADIGITACION DESC");
            while (ClaseBaseDatos.resultado.next()) {
                cuentas = new Cuentas();
                cuentas.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                cuentas.setCuentacontrol(ClaseBaseDatos.resultado.getString("CUENTACONTROL"));
                cuentas.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                cuentas.setEgreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("EGRESO"))));
                cuentas.setFechadigitacion(ClaseBaseDatos.resultado.getDate("FECHADIGITACION"));
                cuentas.setFechapresupuestal(ClaseBaseDatos.resultado.getDate("FECHAPRESUPUESTAL"));
                cuentas.setFechatransaccion(ClaseBaseDatos.resultado.getDate("FECHATRANSACCION"));
                cuentas.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                cuentas.setIngreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("INGRESO"))));
                cuentas.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                cuentas.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                cuentas.setNumeroseguimiento(ClaseBaseDatos.resultado.getString("NUMEROSEGUIMIENTO"));

                listCuentas.add(cuentas);
            }
            return listCuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Cuentas> findAllInCuentasByFktercero(String fktercero) {
        List<Cuentas> listCuentas = new ArrayList<Cuentas>();
        Cuentas cuentas;

        try {
            datos.query("SELECT * FROM CUENTAS "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + fktercero + " - %'");
            while (ClaseBaseDatos.resultado.next()) {
                cuentas = new Cuentas();
                cuentas.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                cuentas.setCuentacontrol(ClaseBaseDatos.resultado.getString("CUENTACONTROL"));
                cuentas.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                cuentas.setEgreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("EGRESO"))));
                cuentas.setFechadigitacion(ClaseBaseDatos.resultado.getDate("FECHADIGITACION"));
                cuentas.setFechapresupuestal(ClaseBaseDatos.resultado.getDate("FECHAPRESUPUESTAL"));
                cuentas.setFechatransaccion(ClaseBaseDatos.resultado.getDate("FECHATRANSACCION"));
                cuentas.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                cuentas.setIngreso(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("INGRESO"))));
                cuentas.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                cuentas.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                cuentas.setNumeroseguimiento(ClaseBaseDatos.resultado.getString("NUMEROSEGUIMIENTO"));

                listCuentas.add(cuentas);
            }
            return listCuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
