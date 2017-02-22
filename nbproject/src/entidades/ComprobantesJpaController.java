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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jhon Lopez
 */
public class ComprobantesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ComprobantesJpaController() {
    }

    public void create(Comprobantes comprobantes) {
        try {
            datos.update("INSERT INTO " + comprobantes.tabla + " VALUES ("
                    //+ comprobantes.getId() + ", "
                    + comprobantes.getComprobante() + ", "
                    + "'" + ClaseInformacion.ConvertirFecha(comprobantes.getFechaaplicacion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(comprobantes.getFechaelaboracion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(comprobantes.getFechapago()) + "', "
                    + "'" + comprobantes.getFktercero() + "', "
                    + "'" + comprobantes.getFktercerofuncionario() + "', "
                    + "'" + comprobantes.getObservacion() + "', "
                    + "'" + comprobantes.getTipopago() + "', "
                    + comprobantes.getValor() + ", "
                    + comprobantes.getAno() + ")");
            if (!datos.isError) {
                try {
                    datos.query("SELECT * FROM COMPROBANTES WHERE "
                            + "FECHAELABORACION = '" + ClaseInformacion.ConvertirFecha(comprobantes.getFechaelaboracion()) + "' AND "
                            + "FKTERCERO = '" + comprobantes.getFktercero() + "' AND "
                            + "FKTERCEROFUNCIONARIO = '" + comprobantes.getFktercerofuncionario() + "' AND "
                            + "VALOR = " + comprobantes.getValor() + " AND "
                            + "ANO = " + comprobantes.getAno() + " ORDER BY ID DESC");
                    while (ClaseBaseDatos.resultado.next()) {
                        comprobantes = new Comprobantes();
                        comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
                        ClaseMensaje.informacionGuardarBD("Comprobante (" + comprobantes.getId() + ")");
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

    public void edit(Comprobantes comprobantes, Comprobantes id) {
        try {
            datos.update("UPDATE COMPROBANTES SET "
                    + "COMPROBANTE = " + comprobantes.getComprobante() + ", "
                    + "FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(comprobantes.getFechaaplicacion()) + "', "
                    + "FECHAELABORACION = '" + ClaseInformacion.ConvertirFecha(comprobantes.getFechaelaboracion()) + "', "
                    + "FECHAPAGO = '" + ClaseInformacion.ConvertirFecha(comprobantes.getFechapago()) + "', "
                    + "FKTERCERO = '" + comprobantes.getFktercero() + "', "
                    + "FKTERCEROFUNCIONARIO = '" + comprobantes.getFktercerofuncionario() + "', "
                    + "OBSERVACION = '" + comprobantes.getObservacion() + "', "
                    + "TIPOPAGO = '" + comprobantes.getTipopago() + "', "
                    + "VALOR = " + comprobantes.getValor() + " "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Comprobante (" + id.getId() + ")");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE COMPROBANTES SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }

        try {
            datos.update("UPDATE COMPROBANTES SET "
                    + "FKTERCEROFUNCIONARIO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROFUNCIONARIO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFechaaplicacion(Date fechaaplicacion, BigDecimal comprobante, String tipopago, int ano) {
        try {
            datos.update("UPDATE COMPROBANTES SET "
                    + "FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaaplicacion) + "' "
                    + "WHERE "
                    + "TIPOPAGO = '" + tipopago + "' AND "
                    + "ANO = " + ano + " AND  "
                    + "COMPROBANTE = " + comprobante );
            if (!datos.isError) {
                //ClaseMensaje.informacionActualizarBD("Desde el Comprobante (" + comprobanteInicio + ") al (" + comprobanteFin + ")");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Comprobantes id) {
        try {
            datos.update("DELETE FROM COMPROBANTES "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Comprobante (" + id + ")");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Comprobantes comprobantes) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(comprobantes.getFktercero(), "CÉDULA DEL PROVEEDOR")
                    && ClaseInformacion.ValidarSeleccione(comprobantes.getFktercerofuncionario(), "CEDULA DE QUIEN SOLICITA")
                    && ClaseInformacion.ValidarSeleccione(comprobantes.getTipopago(), "FORMA DE PAGO")
                    && ClaseInformacion.ValidarSeleccione("" + comprobantes.getValor(), "VALOR")
                    && ClaseInformacion.ValidarSeleccione(comprobantes.getObservacion(), "OBSERVACION")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public int findComprobanteInComprobantesByIdAno(int id, int ano) {
        int comprobante = 0;
        Comprobantes comprobantes;

        try {
            datos.query("SELECT comprobante FROM COMPROBANTES "
                    + "WHERE "
                    + "id = " + id + " "
                    + "AND ano = " + ano);
            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobante = ClaseBaseDatos.resultado.getInt("COMPROBANTE");
            }
            return comprobante;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return comprobante;
        }
    }

    public List<Comprobantes> findAllInComprobantesByORDERBYAno(int ano) {
        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
        Comprobantes comprobantes;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")
                        || ClaseGeneral.parametro.equals("CAST(comprobante AS TEXT)")) {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND ANO = " + ano + " "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND ANO = " + ano + " "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            } else {
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")
                        || ClaseGeneral.parametro.equals("CAST(comprobante AS TEXT)")) {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND ANO = " + ano + ""
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND ANO = " + ano + ""
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            }
            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
                comprobantes.setComprobante(ClaseBaseDatos.resultado.getInt("COMPROBANTE"));
                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
                comprobantes.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                comprobantes.setFechapago(ClaseBaseDatos.resultado.getDate("FECHAPAGO"));
                comprobantes.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                comprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                comprobantes.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
                comprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));

                listComprobantes.add(comprobantes);
            }
            return listComprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Comprobantes> findAllInComprobantesAndSoportescomprobantesoBy() {
        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
        Comprobantes comprobantes;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                if (ClaseGeneral.parametro.equals("CAST(comprobantes.id AS TEXT)")
                        || ClaseGeneral.parametro.equals("CAST(comprobante AS TEXT)")) {
                    datos.query("SELECT DISTINCT(TABLA.ID), COMPROBANTE, FECHAAPLICACION, FECHAELABORACION, FECHAPAGO, FKTERCERO, FKTERCEROFUNCIONARIO, OBSERVACION, TIPOPAGO, VALOR, ANO "
                            + "FROM (SELECT COMPROBANTES.*, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES LEFT JOIN SOPORTESCOMPROBANTES ON COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE AND COMPROBANTES.ANO = SOPORTESCOMPROBANTES.ANO "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT DISTINCT(TABLA.ID), COMPROBANTE, FECHAAPLICACION, FECHAELABORACION, FECHAPAGO, FKTERCERO, FKTERCEROFUNCIONARIO, OBSERVACION, TIPOPAGO, VALOR, ANO "
                            + "FROM (SELECT COMPROBANTES.*, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES LEFT JOIN SOPORTESCOMPROBANTES ON COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE AND COMPROBANTES.ANO = SOPORTESCOMPROBANTES.ANO "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            } else {
                if (ClaseGeneral.parametro.equals("CAST(comprobantes.id AS TEXT)")
                        || ClaseGeneral.parametro.equals("CAST(comprobante AS TEXT)")) {
                    datos.query("SELECT DISTINCT(TABLA.ID), COMPROBANTE, FECHAAPLICACION, FECHAELABORACION, FECHAPAGO, FKTERCERO, FKTERCEROFUNCIONARIO, OBSERVACION, TIPOPAGO, VALOR, ANO "
                            + "FROM (SELECT COMPROBANTES.*, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES LEFT JOIN SOPORTESCOMPROBANTES ON COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE AND COMPROBANTES.ANO = SOPORTESCOMPROBANTES.ANO "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT DISTINCT(TABLA.ID), COMPROBANTE, FECHAAPLICACION, FECHAELABORACION, FECHAPAGO, FKTERCERO, FKTERCEROFUNCIONARIO, OBSERVACION, TIPOPAGO, VALOR, ANO "
                            + "FROM (SELECT COMPROBANTES.*, ROW_NUMBER() OVER(ORDER BY COMPROBANTES.ID DESC, COMPROBANTES.ANO DESC) AS FILA "
                            + "FROM COMPROBANTES LEFT JOIN SOPORTESCOMPROBANTES ON COMPROBANTES.ID = SOPORTESCOMPROBANTES.FKCOMPROBANTE AND COMPROBANTES.ANO = SOPORTESCOMPROBANTES.ANO "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            }
            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
                comprobantes.setComprobante(ClaseBaseDatos.resultado.getInt("COMPROBANTE"));
                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
                comprobantes.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                comprobantes.setFechapago(ClaseBaseDatos.resultado.getDate("FECHAPAGO"));
                comprobantes.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                comprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                comprobantes.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
                comprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));

                listComprobantes.add(comprobantes);
            }
            return listComprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Comprobantes> findAllInComprobantesByAno(int ano) {//COMPROBANTES PENDIENTES POR ASIGNAR # DE COMPROBANTE
        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
        Comprobantes comprobantes;

        try {
            datos.query("SELECT * "
                    + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY FECHAELABORACION DESC, ID DESC) AS FILA "
                    + "FROM COMPROBANTES "
                    + "WHERE COMPROBANTE = 0 "
                    + "AND ANO = " + ano + ""
                    + ") AS TABLA "
                    + "WHERE FILA BETWEEN 1 AND 100 "
                    + "ORDER BY COMPROBANTE");
            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
                comprobantes.setComprobante(ClaseBaseDatos.resultado.getInt("COMPROBANTE"));
                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
                comprobantes.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                comprobantes.setFechapago(ClaseBaseDatos.resultado.getDate("FECHAPAGO"));
                comprobantes.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                comprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                comprobantes.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
                comprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));

                listComprobantes.add(comprobantes);
            }
            return listComprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Comprobantes> findAllInComprobantesnoreembolsadosByFechaaplicacion() {//COMPROBANTES PENDIENTES POR REEMBOLSAR AL COLOCAR UN CRITERIO EN BUSCAR
        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
        Comprobantes comprobantes;

        try {

            datos.query("SELECT FECHAAPLICACION, TIPOPAGO, ANO "
                    + "FROM COMPROBANTES "
                    + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                    + "GROUP BY FECHAAPLICACION, TIPOPAGO, ANO "
                    + "ORDER BY FECHAAPLICACION DESC, TIPOPAGO, ANO");

            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));

                listComprobantes.add(comprobantes);
            }
            return listComprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Comprobantes> findAllInComprobantesByFechaapliacion(Date fechaaplicacion, int ano, String tipopago) {//COMPROBANTES NO REEMBOLSADOS 2000-01-01
        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
        Comprobantes comprobantes;
        if (tipopago.equals("Seleccione")) {
            tipopago = "Fondo Renovable' OR TIPOPAGO = 'Caja Menor";
        }

        try {
            datos.query("SELECT * "
                    + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY FECHAELABORACION DESC, ID DESC) AS FILA "
                    + "FROM COMPROBANTES "
                    + "WHERE FECHAAPLICACION = '" + ClaseInformacion.ConvertirFecha(fechaaplicacion) + "' "
                    + "AND ANO = " + ano + " "
                    + "AND (TIPOPAGO = '" + tipopago + "')) AS TABLA "
                    // + "WHERE FILA BETWEEN 1 AND 100 "
                    + "ORDER BY COMPROBANTE");
            while (ClaseBaseDatos.resultado.next()) {
                comprobantes = new Comprobantes();
                comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
                comprobantes.setComprobante(ClaseBaseDatos.resultado.getInt("COMPROBANTE"));
                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
                comprobantes.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                comprobantes.setFechapago(ClaseBaseDatos.resultado.getDate("FECHAPAGO"));
                comprobantes.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                comprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                comprobantes.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
                comprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));

                listComprobantes.add(comprobantes);
            }
            return listComprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    //BORRAR
//    public List<Comprobantes> findAllInComprobantesByFktercero(String fktercero) { 
//        List<Comprobantes> listComprobantes = new ArrayList<Comprobantes>();
//        Comprobantes comprobantes;
//
//        try {
//            datos.query("SELECT * FROM COMPROBANTES "
//                    + "WHERE "
//                    + "FKTERCERO LIKE '" + fktercero + " - %' ORDER BY FECHAELABORACION DESC, ID DESC");
//            while (ClaseBaseDatos.resultado.next()) {
//                comprobantes = new Comprobantes();
//                comprobantes.setId(ClaseBaseDatos.resultado.getInt("ID"));
//                comprobantes.setComprobante(ClaseBaseDatos.resultado.getInt("COMPROBANTE"));
//                comprobantes.setFechaaplicacion(ClaseBaseDatos.resultado.getDate("FECHAAPLICACION"));
//                comprobantes.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
//                comprobantes.setFechapago(ClaseBaseDatos.resultado.getDate("FECHAPAGO"));
//                comprobantes.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
//                comprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
//                comprobantes.setObservacion(ClaseBaseDatos.resultado.getString("OBSERVACION"));
//                comprobantes.setTipopago(ClaseBaseDatos.resultado.getString("TIPOPAGO"));
//                comprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
//                comprobantes.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
//
//                listComprobantes.add(comprobantes);
//            }
//            return listComprobantes;
//        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
//            return null;
//        }
//    }

    public DefaultComboBoxModel COMBOFechaaplicacionInComprobantesBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();
        try {
            datos.query("SELECT DISTINCT(fechaaplicacion) FROM comprobantes ORDER BY fechaaplicacion");// ORDER BY id
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement("" + ClaseBaseDatos.resultado.getDate("fechaaplicacion"));
            }
            modeloCombo.addElement("Todo el AÑO - Reembolsados");
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
