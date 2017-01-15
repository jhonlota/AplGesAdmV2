/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
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
public class PolizasJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public PolizasJpaController() {
    }

    public void create(Polizas polizas) {
        try {
            datos.update("INSERT INTO " + polizas.tabla + " VALUES ("
                    + "'" + polizas.getPolizasPK().getFkcontrato() + "', "
                    + "'" + polizas.getPolizasPK().getNumeropoliza() + "', "
                    + "'" + polizas.getAseguradora() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(polizas.getFechaaprobacionpoliza()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(polizas.getFechaexpedicionpoliza()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(polizas.getFechafinalamparo()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(polizas.getFechainicialamparo()) + "', "
                    + "'" + polizas.getResolucionpoliza() + "', "
                    + "'" + polizas.getPolizasPK().getTipopoliza() + "', "
                    + polizas.getValorasegurado() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Poliza");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Polizas polizas, Polizas id) {
        try {
            datos.update("UPDATE POLIZAS SET "
                    + "ASEGURADORA = '" + polizas.getAseguradora() + "', "
                    + "FECHAAPROBACIONPOLIZA = '" + ClaseInformacion.ConvertirFecha(polizas.getFechaaprobacionpoliza()) + "', "
                    + "FECHAEXPEDICIONPOLIZA = '" + ClaseInformacion.ConvertirFecha(polizas.getFechaexpedicionpoliza()) + "', "
                    + "FECHAFINALAMPARO = '" + ClaseInformacion.ConvertirFecha(polizas.getFechafinalamparo()) + "', "
                    + "FECHAINICIALAMPARO = '" + ClaseInformacion.ConvertirFecha(polizas.getFechainicialamparo()) + "', "
                    + "RESOLUCIONPOLIZA = '" + polizas.getResolucionpoliza() + "', "
                    + "TIPOPOLIZA = '" + polizas.getPolizasPK().getTipopoliza() + "', "
                    + "VALORASEGURADO = " + polizas.getValorasegurado() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getPolizasPK().getFkcontrato() + "' AND "
                    + "NUMEROPOLIZA = '" + id.getPolizasPK().getNumeropoliza() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Poliza");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE POLIZAS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(PolizasPK id) {
        try {
            datos.update("DELETE FROM POLIZAS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFkcontrato() + " AND "
                    + "NUMEROPOLIZA = '" + id.getNumeropoliza() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Poliza");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM POLIZAS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Poliza");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Polizas> findAllInPolizasByFkcontrato(String fkcontrato) {
        List<Polizas> listPolizas = new ArrayList<Polizas>();
        Polizas polizas;
        PolizasPK polizasPK;

        try {
            datos.query("SELECT * FROM POLIZAS WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY ASEGURADORA");
            while (ClaseBaseDatos.resultado.next()) {
                polizas = new Polizas();
                polizasPK = new PolizasPK();
                polizasPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                polizasPK.setNumeropoliza(ClaseBaseDatos.resultado.getString("NUMEROPOLIZA"));
                polizasPK.setTipopoliza(ClaseBaseDatos.resultado.getString("TIPOPOLIZA"));
                polizas.setPolizasPK(polizasPK);
                polizas.setAseguradora(ClaseBaseDatos.resultado.getString("ASEGURADORA"));
                polizas.setFechaaprobacionpoliza(ClaseBaseDatos.resultado.getDate("FECHAAPROBACIONPOLIZA"));
                polizas.setFechaexpedicionpoliza(ClaseBaseDatos.resultado.getDate("FECHAEXPEDICIONPOLIZA"));
                polizas.setFechafinalamparo(ClaseBaseDatos.resultado.getDate("FECHAFINALAMPARO"));
                polizas.setFechainicialamparo(ClaseBaseDatos.resultado.getDate("FECHAINICIALAMPARO"));
                polizas.setResolucionpoliza(ClaseBaseDatos.resultado.getString("RESOLUCIONPOLIZA"));
                
                polizas.setValorasegurado(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORASEGURADO"))));

                listPolizas.add(polizas);
            }
            return listPolizas;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
