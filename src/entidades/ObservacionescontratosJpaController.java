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
public class ObservacionescontratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ObservacionescontratosJpaController() {
    }

    public void create(Observacionescontratos observacionescontratos) {
        try {
            datos.update("INSERT INTO " + observacionescontratos.tabla + " VALUES ("
                    + "'" + observacionescontratos.getObservacionescontratosPK().getFecha() + "', "
                    + "'" + observacionescontratos.getObservacionescontratosPK().getFkcontrato() + "', "
                    + "'" + observacionescontratos.getDependencia() + "', "
                    + "'" + observacionescontratos.getObservacion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void createTimestamp(Observacionescontratos observacionescontratos) {
        try {
            datos.update("INSERT INTO " + observacionescontratos.tabla + " VALUES ("
                    + "'" + ClaseGeneral.controlUtilidades.horaServidor() + "', "
                    + "'" + observacionescontratos.getObservacionescontratosPK().getFkcontrato() + "', "
                    + "'" + observacionescontratos.getDependencia() + "', "
                    + "'" + observacionescontratos.getObservacion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Observacionescontratos observacionescontratos, Observacionescontratos id) {
        try {
            datos.update("UPDATE OBSERVACIONESCONTRATOS SET "
                    + "DEPENDENCIA = '" + observacionescontratos.getDependencia() + "', "
                    + "OBSERVACION = '" + observacionescontratos.getObservacion() + "' "
                    + "WHERE "
                    + "FECHA = '" + id.getObservacionescontratosPK().getFecha() + "' AND "
                    + "FKCONTRATO = '" + id.getObservacionescontratosPK().getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE OBSERVACIONESCONTRATOS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ObservacionescontratosPK id) {
        try {
            datos.update("DELETE FROM OBSERVACIONESCONTRATOS "
                    + "WHERE "
                    + "FECHA = '" + id.getFecha() + "' AND "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM OBSERVACIONESCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Observaciones");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Observacionescontratos> findAllInObservacionescontratosByFkcontrato(String fkcontrato) {
        List<Observacionescontratos> listObservacionescontratos = new ArrayList<Observacionescontratos>();
        Observacionescontratos observacionescontratos;
        ObservacionescontratosPK observacionescontratosPK;

        try {
            datos.query("SELECT * FROM OBSERVACIONESCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                observacionescontratos = new Observacionescontratos();
                observacionescontratosPK = new ObservacionescontratosPK();
                observacionescontratosPK.setFecha(ClaseBaseDatos.resultado.getTimestamp("FECHA"));
                observacionescontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                observacionescontratos.setObservacionescontratosPK(observacionescontratosPK);
                observacionescontratos.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                observacionescontratos.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));

                listObservacionescontratos.add(observacionescontratos);
            }
            return listObservacionescontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public Observacionescontratos findAllInObservacionescontratosByFkcontratoMAXfecha(String fkcontrato) {
        Observacionescontratos observacionescontratos = new Observacionescontratos();
        ObservacionescontratosPK observacionescontratosPK;

        try {
            datos.query("SELECT MAX(FECHA) AS FECHA, FKCONTRATO, DEPENDENCIA, OBSERVACION "
                    + "FROM OBSERVACIONESCONTRATOS "
                    + "WHERE FKCONTRATO = '" + fkcontrato + "' "
                    + "GROUP BY FECHA, FKCONTRATO, DEPENDENCIA, OBSERVACION "
                    + "ORDER BY FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                observacionescontratos = new Observacionescontratos();
                observacionescontratosPK = new ObservacionescontratosPK();
                observacionescontratosPK.setFecha(ClaseBaseDatos.resultado.getTimestamp("FECHA"));
                observacionescontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                observacionescontratos.setObservacionescontratosPK(observacionescontratosPK);
                observacionescontratos.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                observacionescontratos.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
            }
            return observacionescontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<String> findTiempoFkcontratoObservacionInObservacionescontratosBy() {//PENDIENTES
        List<String> lista = new ArrayList<String>();

        try {
            datos.query("SELECT *, EXTRACT(DAY FROM (CURRENT_TIMESTAMP - A.FECHA)) TIEMPO "
                    + "FROM OBSERVACIONESCONTRATOS AS A INNER JOIN "
                    + "(SELECT MAX(FECHA) FECHAMAYOR, FKCONTRATO "
                    + "FROM OBSERVACIONESCONTRATOS "
                    + "GROUP BY FKCONTRATO "
                    + "ORDER BY FKCONTRATO) AS B ON A.FECHA = B.FECHAMAYOR AND A.FKCONTRATO = B.FKCONTRATO "
                    + "ORDER BY TIEMPO DESC");
            while (ClaseBaseDatos.resultado.next()) {
                String dependencia = ClaseBaseDatos.resultado.getString("DEPENDENCIA");
                if (dependencia.equals(ClaseGeneral.dependencia)) {
                    try {
                        String tiempo = ClaseBaseDatos.resultado.getString("TIEMPO");
                        String observacion = ClaseBaseDatos.resultado.getString("OBSERVACION");
                        String fkcontrato = ClaseBaseDatos.resultado.getString("FKCONTRATO");
                        if (Integer.parseInt(tiempo) < 3
                                || !observacion.contains("DOCUMENTO DIGITALIZADO")) {
                            lista.add(" (" + tiempo
                                    + ") - " + fkcontrato
                                    + "*-*" + observacion);
                        }
                    } catch (Exception ex) {
//                        System.out.println("Observacionescontratos - " + ex);
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
