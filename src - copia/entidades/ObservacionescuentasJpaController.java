/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class ObservacionescuentasJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ObservacionescuentasJpaController() {
    }

    public void create(Observacionescuentas observacionescuentas) {
        try {
            datos.update("INSERT INTO " + observacionescuentas.tabla + " VALUES ("
                    + "'" + observacionescuentas.getObservacionescuentasPK().getFecha() + "', "
                    + "'" + observacionescuentas.getObservacionescuentasPK().getFkcuenta() + "', "
                    + "'" + observacionescuentas.getDependencia() + "', "
                    + "'" + observacionescuentas.getObservacion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void createTimestamp(Observacionescuentas observacionescuentas) {
        try {
            datos.update("INSERT INTO " + observacionescuentas.tabla + " VALUES ("
                    + "'" + ClaseGeneral.controlUtilidades.horaServidor() + "', "
                    + "'" + observacionescuentas.getObservacionescuentasPK().getFkcuenta() + "', "
                    + "'" + observacionescuentas.getDependencia() + "', "
                    + "'" + observacionescuentas.getObservacion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Observacionescuentas observacionescuentas, Observacionescuentas id) {
        try {
            datos.update("UPDATE OBSERVACIONESCUENTAS SET "
                    + "DEPENDENCIA = '" + observacionescuentas.getDependencia() + "', "
                    + "OBSERVACION = '" + observacionescuentas.getObservacion() + "' "
                    + "WHERE "
                    + "FECHA = '" + id.getObservacionescuentasPK().getFecha() + "' AND "
                    + "FKCUENTA = '" + id.getObservacionescuentasPK().getFkcuenta() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcuenta(String fkcuenta, String id) {
        try {
            datos.update("UPDATE OBSERVACIONESCUENTAS SET "
                    + "FKCUENTA = '" + fkcuenta + "' "
                    + "WHERE "
                    + "FKCUENTA = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ObservacionescuentasPK id) {
        try {
            datos.update("DELETE FROM OBSERVACIONESCUENTAS "
                    + "WHERE "
                    + "FECHA = '" + id.getFecha() + "' AND "
                    + "FKCUENTA = '" + id.getFkcuenta() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcuenta(String id) {
        try {
            datos.update("DELETE FROM OBSERVACIONESCUENTAS "
                    + "WHERE "
                    + "FKCUENTA = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Observacionescuentas> findAllInObservacionescuentasByFkcuenta(String fkcuenta) {
        List<Observacionescuentas> listObservacionescuentas = new ArrayList<Observacionescuentas>();
        Observacionescuentas observacionescuentas;
        ObservacionescuentasPK observacionescuentasPK;

        try {
            datos.query("SELECT * FROM OBSERVACIONESCUENTAS WHERE FKCUENTA = '" + fkcuenta + "' ORDER BY FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                observacionescuentas = new Observacionescuentas();
                observacionescuentasPK = new ObservacionescuentasPK();
                observacionescuentasPK.setFecha(ClaseBaseDatos.resultado.getTimestamp("FECHA"));
                observacionescuentasPK.setFkcuenta(ClaseBaseDatos.resultado.getString("FKCUENTA"));
                observacionescuentas.setObservacionescuentasPK(observacionescuentasPK);
                observacionescuentas.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                observacionescuentas.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));

                listObservacionescuentas.add(observacionescuentas);
            }
            return listObservacionescuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public Observacionescuentas findAllInObservacionescuentasByFkcuentaMAXfecha(String fkcuenta) {
        Observacionescuentas observacionescuentas = new Observacionescuentas();
        ObservacionescuentasPK observacionescuentasPK;

        try {
            datos.query("SELECT MAX(FECHA) AS FECHA, FKCUENTA, DEPENDENCIA, OBSERVACION "
                    + "FROM OBSERVACIONESCUENTAS "
                    + "WHERE FKCUENTA = '" + fkcuenta + "' "
                    + "GROUP BY FECHA, FKCUENTA, DEPENDENCIA, OBSERVACION "
                    + "ORDER BY FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                observacionescuentas = new Observacionescuentas();
                observacionescuentasPK = new ObservacionescuentasPK();
                observacionescuentasPK.setFecha(ClaseBaseDatos.resultado.getTimestamp("FECHA"));
                observacionescuentasPK.setFkcuenta(ClaseBaseDatos.resultado.getString("FKCUENTA"));
                observacionescuentas.setObservacionescuentasPK(observacionescuentasPK);
                observacionescuentas.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                observacionescuentas.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
            }
            return observacionescuentas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<String> findTiempoFkcuentaObservacionInObservacionescuentasBy() {//PENDIENTES
        List<String> lista = new ArrayList<String>();

        try {
            datos.query("SELECT *, EXTRACT(DAY FROM (CURRENT_TIMESTAMP - A.FECHA)) TIEMPO "
                    + "FROM OBSERVACIONESCUENTAS  AS A INNER JOIN "
                    + "(SELECT MAX(FECHA) FECHAMAYOR, FKCUENTA "
                    + "FROM OBSERVACIONESCUENTAS "
                    + "GROUP BY FKCUENTA "
                    + "ORDER BY FKCUENTA) AS B ON A.FECHA = B.FECHAMAYOR AND A.FKCUENTA = B.FKCUENTA "
                    + "ORDER BY TIEMPO DESC");
            while (ClaseBaseDatos.resultado.next()) {
                String dependencia = ClaseBaseDatos.resultado.getString("DEPENDENCIA");
                if (dependencia.equals(ClaseGeneral.dependencia)) {
                    try {
                        String tiempo = ClaseBaseDatos.resultado.getString("TIEMPO");
                        String observacion = ClaseBaseDatos.resultado.getString("OBSERVACION");
                        String fkcuenta = ClaseBaseDatos.resultado.getString("FKCUENTA");
                        if (Integer.parseInt(tiempo) < 3
                                || !observacion.contains("ENTREGA PRESUPUESTO")) {
                            lista.add(" (" + tiempo
                                    + ") - " + fkcuenta
                                    + "*-*" + observacion);
                        }
                    } catch (Exception ex) {
                        System.out.println("Observacionescuentas - " + ex);
                    }
                }
            }
            return lista;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<String> findTiempoFkcuentaObservacionInObservacionescuentasByCalificacion() {//PENDIENTES
        List<String> lista = new ArrayList<String>();

        try {
            datos.query("SELECT *, EXTRACT(DAY FROM (CURRENT_TIMESTAMP - A.FECHA)) TIEMPO "
                    + "FROM OBSERVACIONESCUENTAS AS A INNER JOIN "
                    + "(SELECT MAX(FECHA) FECHAMAYOR, FKCUENTA "
                    + "FROM OBSERVACIONESCUENTAS "
                    + "GROUP BY FKCUENTA "
                    + "ORDER BY FKCUENTA) AS B ON A.FECHA = B.FECHAMAYOR AND A.FKCUENTA = B.FKCUENTA "
                    + "WHERE NOT EXISTS "
                    + "(SELECT * "
                    + "FROM CALIFICACION "
                    + "WHERE A.FKCUENTA = CALIFICACION.TRAMITE ) "
                    + "ORDER BY TIEMPO DESC");
            while (ClaseBaseDatos.resultado.next()) {
                String dependencia = ClaseBaseDatos.resultado.getString("DEPENDENCIA");
                if (dependencia.equals(ClaseGeneral.dependencia)) {
                    try {
                        String tiempo = ClaseBaseDatos.resultado.getString("TIEMPO");
                        String observacion = ClaseBaseDatos.resultado.getString("OBSERVACION");
                        String fkcuenta = ClaseBaseDatos.resultado.getString("FKCUENTA");
                        if (Integer.parseInt(tiempo) < 30
                                && observacion.contains("ENTREGA PRESUPUESTO")) {
                            lista.add(" (" + tiempo
                                    + ") - " + fkcuenta
                                    + "*-*" + observacion);
                        }
                    } catch (Exception ex) {
                        System.out.println("Observacionescuentas - " + ex);
                    }
                }
            }
            return lista;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
