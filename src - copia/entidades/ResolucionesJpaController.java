package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class ResolucionesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public ResolucionesJpaController() {
    }

    public void create(Resoluciones resoluciones) {
        try {
            datos.update("INSERT INTO " + resoluciones.tabla + " VALUES ("
                    //+ resoluciones.getResolucionPK().getId() + ", "
                    + "'" + resoluciones.getAcuerdo() + "', "
                    + resoluciones.getResolucionPK().getAno() + ", "
                    + "'" + ClaseInformacion.ConvertirFecha(resoluciones.getFecha()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(resoluciones.getFechainicio()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(resoluciones.getFechaterminacion()) + "', "
                    + "'" + resoluciones.getFkterceroordenadorgasto() + "', "
                    + "'" + resoluciones.getObservacion() + "', "
                    + "'" + resoluciones.getTipo() + "', "
                    + "'" + resoluciones.getVehiculo() + "',"
                    + "'" + resoluciones.getIsfindesemana() + "')");
            if (!datos.isError) {
                ResolucionesPK resolucionesPK = new ResolucionesPK();
                try {
                    datos.query("SELECT * FROM RESOLUCION WHERE "
                            + "ACUERDO = '" + resoluciones.getAcuerdo() + "' AND "
                            + "ANO = " + resoluciones.getResolucionPK().getAno() + " AND "
                            + "FECHA = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFecha()) + "' AND "
                            + "FECHAINICIO = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFechainicio()) + "' AND "
                            + "FECHATERMINACION = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFechaterminacion()) + "' AND "
                            + "FKTERCEROORDENADORGASTO = '" + resoluciones.getFkterceroordenadorgasto() + "' AND "
                            + "OBSERVACION = '" + resoluciones.getObservacion() + "' AND "
                            + "TIPO = '" + resoluciones.getTipo() + "' AND "
                            + "VEHICULO = '" + resoluciones.getVehiculo() + "' AND "
                            + "ISFINDESEMANA = '" + resoluciones.getIsfindesemana() + "' ORDER BY ID DESC");
                    while (ClaseBaseDatos.resultado.next()) {
                        resolucionesPK = new ResolucionesPK();
                        resolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                        ClaseMensaje.informacionGuardarBD("Resolucion (" + resolucionesPK.getId() + ")");
                        break;
                    }
                } catch (SQLException ex) {
                    ClaseMensaje.errorGuardarBD();
                }
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Resoluciones resoluciones, Resoluciones id) {
        try {
            datos.update("UPDATE RESOLUCION SET "
                    //+ "ID = " + resoluciones.getResolucionPK().getId() + ", "
                    + "ACUERDO = '" + resoluciones.getAcuerdo() + "', "
                    //+ "ANO = " + resoluciones.getResolucionPK().getAno() + ", "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFecha()) + "', "
                    + "FECHAINICIO = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFechainicio()) + "', "
                    + "FECHATERMINACION = '" + ClaseInformacion.ConvertirFecha(resoluciones.getFechaterminacion()) + "', "
                    + "FKTERCEROORDENADORGASTO = '" + resoluciones.getFkterceroordenadorgasto() + "', "
                    + "OBSERVACION = '" + resoluciones.getObservacion() + "', "
                    + "TIPO = '" + resoluciones.getTipo() + "', "
                    + "VEHICULO = '" + resoluciones.getVehiculo() + "', "
                    + "ISFINDESEMANA = '" + resoluciones.getIsfindesemana() + "' "
                    + "WHERE "
                    + "ID = " + id.getResolucionPK().getId() + " AND "
                    + "ANO = " + id.getResolucionPK().getAno() + "");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Resolucion (" + id.getResolucionPK().getId() + ")");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE RESOLUCION SET "
                    + "FKTERCEROORDENADORGASTO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROORDENADORGASTO LIKE '" + id + " - %'");

        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Resoluciones id) {
        try {
            datos.update("DELETE FROM RESOLUCION "
                    + "WHERE "
                    + "ID = " + id.getResolucionPK().getId() + " AND "
                    + "ANO = " + id.getResolucionPK().getAno() + "");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Resoluciones resoluciones) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(resoluciones.getAcuerdo(), "ACUERDO")
                    && ClaseInformacion.ValidarSeleccione(resoluciones.getFkterceroordenadorgasto(), "CÉDULA DEL ORDENADOR DE GASTO")
                    && ClaseInformacion.ValidarSeleccione(resoluciones.getTipo(), "TIPO DE RESOLUCION")
                    && ClaseInformacion.ValidarSeleccione(resoluciones.getObservacion(), "OBSERVACIÓN")
                    && (ClaseGeneral.perfil.equals("root") ? true : ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(resoluciones.getFecha(), resoluciones.getFechainicio()) >= 0, "ERROR EN LA FECHA DE INICIO"))
                    && (ClaseGeneral.perfil.equals("root") ? true : ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(resoluciones.getFechainicio(), resoluciones.getFechaterminacion()) >= 0, "ERROR EN LA FECHA DE TERMINACIÓN"))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }
    
    public List<Resoluciones> findAllInResolucionByORDERBYAno(int ano) {
        List<Resoluciones> listResoluciones = new ArrayList<Resoluciones>();
        Resoluciones resoluciones = new Resoluciones();
        ResolucionesPK resolucionesPK = new ResolucionesPK();
        try {
            if (ClaseGeneral.parametro.equals("CAST(ID AS TEXT)")) {
                datos.query("SELECT * FROM RESOLUCION "
                        + "WHERE "
                        + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                        + "AND ano = " + ano + " ORDER BY ID DESC");
            } else {
                datos.query("SELECT * FROM RESOLUCION "
                        + "WHERE "
                        + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                        + "AND ano = " + ano + " ORDER BY ID DESC");
            }
            while (ClaseBaseDatos.resultado.next()) {
                resoluciones = new Resoluciones();
                resolucionesPK = new ResolucionesPK();
                resolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                resoluciones.setAcuerdo(ClaseBaseDatos.resultado.getString("ACUERDO"));
                resolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                resoluciones.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                resoluciones.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
                resoluciones.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
                resoluciones.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
                resoluciones.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                resoluciones.setTipo(ClaseBaseDatos.resultado.getString("TIPO"));
                resoluciones.setVehiculo(ClaseBaseDatos.resultado.getString("VEHICULO"));
                resoluciones.setIsfindesemana(ClaseBaseDatos.resultado.getBoolean("ISFINDESEMANA"));
                resoluciones.setResolucionPK(resolucionesPK);
                listResoluciones.add(resoluciones);
            }
            return listResoluciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
    
    public List<Resoluciones> findAllInResolucionAndTercerosresolucionesBy() {
        List<Resoluciones> listResoluciones = new ArrayList<Resoluciones>();
        Resoluciones resoluciones = new Resoluciones();
        ResolucionesPK resolucionesPK = new ResolucionesPK();
        try {
            datos.query("SELECT DISTINCT(RESOLUCION.ID), RESOLUCION.ACUERDO, RESOLUCION.ANO, RESOLUCION.FECHA, RESOLUCION.FECHAINICIO, RESOLUCION.FECHATERMINACION, RESOLUCION.FKTERCEROORDENADORGASTO, RESOLUCION.OBSERVACION, RESOLUCION.TIPO, RESOLUCION.VEHICULO, RESOLUCION.ISFINDESEMANA "
                    + "FROM RESOLUCION LEFT JOIN TERCEROSRESOLUCION ON RESOLUCION.ID = TERCEROSRESOLUCION.FKRESOLUCION AND RESOLUCION.ANO = TERCEROSRESOLUCION.ANO "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' ORDER BY RESOLUCION.ID DESC, RESOLUCION.ANO DESC");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                resoluciones = new Resoluciones();
                resolucionesPK = new ResolucionesPK();
                resolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                resoluciones.setAcuerdo(ClaseBaseDatos.resultado.getString("ACUERDO"));
                resolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                resoluciones.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                resoluciones.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
                resoluciones.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
                resoluciones.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
                resoluciones.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                resoluciones.setTipo(ClaseBaseDatos.resultado.getString("TIPO"));
                resoluciones.setVehiculo(ClaseBaseDatos.resultado.getString("VEHICULO"));
                resoluciones.setIsfindesemana(ClaseBaseDatos.resultado.getBoolean("ISFINDESEMANA"));
                resoluciones.setResolucionPK(resolucionesPK);
                listResoluciones.add(resoluciones);
            }
            return listResoluciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    //BORRAR
//    public List<Resoluciones> findAllInResolucionByFktercero(String fktercero) { 
//        List<Resoluciones> listResoluciones = new ArrayList<Resoluciones>();
//        Resoluciones resoluciones = new Resoluciones();
//        ResolucionesPK resolucionesPK = new ResolucionesPK();
//        try {
//            datos.query("SELECT RESOLUCION.* FROM RESOLUCION, TERCEROSRESOLUCION "
//                    + "WHERE "
//                    + "RESOLUCION.ID = TERCEROSRESOLUCION.FKRESOLUCION AND "
//                    + "FKTERCERO LIKE '" + fktercero + " - %' AND RESOLUCION.ANO = TERCEROSRESOLUCION.ANO ORDER BY RESOLUCION.ID DESC");//ORDER BY
//            while (ClaseBaseDatos.resultado.next()) {
//                resoluciones = new Resoluciones();
//                resolucionesPK = new ResolucionesPK();
//                resolucionesPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
//                resoluciones.setAcuerdo(ClaseBaseDatos.resultado.getString("ACUERDO"));
//                resolucionesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
//                resoluciones.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
//                resoluciones.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
//                resoluciones.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
//                resoluciones.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
//                resoluciones.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
//                resoluciones.setTipo(ClaseBaseDatos.resultado.getString("TIPO"));
//                resoluciones.setVehiculo(ClaseBaseDatos.resultado.getString("VEHICULO"));
//                resoluciones.setIsfindesemana(ClaseBaseDatos.resultado.getBoolean("ISFINDESEMANA"));
//                resoluciones.setResolucionPK(resolucionesPK);
//
//                listResoluciones.add(resoluciones);
//            }
//            return listResoluciones;
//        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
//            return null;
//        }
//    }

    public DefaultComboBoxModel COMBOIdNombreInResolucionBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();
        try {
            modeloCombo.addElement("Seleccione - ");
            datos.query("SELECT DISTINCT(ID), AÑO FROM RESOLUCION");// ORDER BY id
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getInt("ID") + " - " + ClaseBaseDatos.resultado.getInt("AÑO"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
