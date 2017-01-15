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
public class SoportescuentasJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public SoportescuentasJpaController() {
    }

    public void create(Soportescuentas soportescuentas) {
        try {
            datos.update("INSERT INTO " + soportescuentas.tabla + " VALUES ("
                    + "'" + soportescuentas.getSoportescuentasPK().getFkcuenta() + "', "
                    //+ soportescuentas.getSoportescuentasPK().getId() + ", "
                    + "'" + soportescuentas.getActividad() + "', "
                    + "'" + soportescuentas.getCcostos() + "', "
                    + "'" + soportescuentas.getCinfo() + "', "
                    + "'" + soportescuentas.getCingreso() + "', "
                    + "'" + soportescuentas.getCuenta() + "', "
                    + "'" + soportescuentas.getCuentainterna() + "', "
                    + "'" + soportescuentas.getSubgrupo() + "', "
                    + soportescuentas.getValor() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Soportescuentas soportescuentas, Soportescuentas id) {
        try {
            datos.update("UPDATE SOPORTESCUENTAS SET "
                    + "ACTIVIDAD = '" + soportescuentas.getActividad() + "', "
                    + "CCOSTOS = '" + soportescuentas.getCcostos() + "', "
                    + "CINFO = '" + soportescuentas.getCinfo() + "', "
                    + "CINGRESO = '" + soportescuentas.getCingreso() + "', "
                    + "CUENTA = '" + soportescuentas.getCuenta() + "', "
                    + "CUENTAINTERNA = '" + soportescuentas.getCuentainterna() + "', "
                    + "SUBGRUPO = '" + soportescuentas.getSubgrupo() + "', "
                    + "VALOR = " + soportescuentas.getValor() + " "
                    + "WHERE "
                    + "FKCUENTA = '" + id.getSoportescuentasPK().getFkcuenta() + "' AND "
                    + "ID = " + id.getSoportescuentasPK().getId());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcuenta(String fkcuenta, String id) {
        try {
            datos.update("UPDATE SOPORTESCUENTAS SET "
                    + "FKCUENTA = '" + fkcuenta + "' "
                    + "WHERE "
                    + "FKCUENTA = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(SoportescuentasPK id) {
        try {
            datos.update("DELETE FROM SOPORTESCUENTAS "
                    + "WHERE "
                    + "FKCUENTA = '" + id.getFkcuenta() + "' AND "
                    + "ID = " + id.getId());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcuenta(String id) {
        try {
            datos.update("DELETE FROM SOPORTESCUENTAS "
                    + "WHERE "
                    + "FKCUENTA = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
     public boolean verify(Soportescuentas soportescuentas) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(soportescuentas.getCuentainterna(), "CUENTA INTERNA")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getCingreso(), "C. INGRESO*")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getCuenta(), "CUENTA")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getActividad(), "ACTIVIDAD*")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getSubgrupo(), "SUBGRUPO*")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getCcostos(), "C. COSTOS*")
                    && ClaseInformacion.ValidarSeleccione(soportescuentas.getCinfo(), "C. INFO")
                    && ClaseInformacion.ValidarSeleccione("" + soportescuentas.getValor(), "VALOR")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Soportescuentas> findAllInSoportescuentasByFkcuenta(String fkcuenta) {
        List<Soportescuentas> listSoportescuentas = new ArrayList<Soportescuentas>();
        Soportescuentas soportescuentas;
        SoportescuentasPK soportescuentasPK;

        try {
            datos.query("SELECT * FROM SOPORTESCUENTAS WHERE FKCUENTA LIKE '" + fkcuenta + "%' ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                soportescuentas = new Soportescuentas();
                soportescuentasPK = new SoportescuentasPK();
                soportescuentasPK.setFkcuenta(ClaseBaseDatos.resultado.getString("FKCUENTA"));
                soportescuentasPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportescuentas.setSoportescuentasPK(soportescuentasPK);
                soportescuentas.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportescuentas.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportescuentas.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportescuentas.setCingreso(ClaseBaseDatos.resultado.getString("CINGRESO"));
                soportescuentas.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportescuentas.setCuentainterna(ClaseBaseDatos.resultado.getString("CUENTAINTERNA"));
                soportescuentas.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportescuentas.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportescuentas.add(soportescuentas);
            }
            return listSoportescuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
