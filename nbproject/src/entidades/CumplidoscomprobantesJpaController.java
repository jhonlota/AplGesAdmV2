/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class CumplidoscomprobantesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CumplidoscomprobantesJpaController() {
    }

    public void create(Cumplidoscomprobantes cumplidoscomprobantes) {
        try {
            datos.update("INSERT INTO " + cumplidoscomprobantes.tabla + " VALUES ("
                    + cumplidoscomprobantes.getCumplidoscomprobantesPK().getFkcomprobante() + ", "
                    + cumplidoscomprobantes.getCumplidoscomprobantesPK().getAno() + ", "
                    + "'" + cumplidoscomprobantes.getContenido() + "', "
                    + "'" + cumplidoscomprobantes.getFktercerofuncionario() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Cumplido");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Cumplidoscomprobantes cumplidoscomprobantes, Cumplidoscomprobantes id) {
        try {
            datos.update("UPDATE CUMPLIDOSCOMPROBANTES SET "
                    + "CONTENIDO = '" + cumplidoscomprobantes.getContenido() + "', "
                    + "FKTERCEROFUNCIONARIO = '" + cumplidoscomprobantes.getFktercerofuncionario() + "' "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getCumplidoscomprobantesPK().getFkcomprobante() + " AND "
                    + "ANO = " + id.getCumplidoscomprobantesPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Cumplido");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE CUMPLIDOSCOMPROBANTES SET "
                    + "FKTERCEROFUNCIONARIO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROFUNCIONARIO LIKE '" + id + " - %'");

        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(CumplidoscomprobantesPK id) {
        try {
            datos.update("DELETE FROM CUMPLIDOSCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getFkcomprobante() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Cumplido");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcomprobanteAno(Comprobantes id) {
        try {
            datos.update("DELETE FROM CUMPLIDOSCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Cumplido");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Cumplidoscomprobantes> findAllInCumplidoscomprobantesByFkcomprobante(int fkcomprobante, int ano) {
        List<Cumplidoscomprobantes> listCumplidoscomprobantes = new ArrayList<Cumplidoscomprobantes>();
        Cumplidoscomprobantes cumplidoscomprobantes;
        CumplidoscomprobantesPK cumplidoscomprobantesPK;

        try {
            datos.query("SELECT * FROM CUMPLIDOSCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano );
            while (ClaseBaseDatos.resultado.next()) {
                cumplidoscomprobantes = new Cumplidoscomprobantes();
                cumplidoscomprobantesPK = new CumplidoscomprobantesPK();
                cumplidoscomprobantesPK.setFkcomprobante(ClaseBaseDatos.resultado.getInt("FKCOMPROBANTE"));
                cumplidoscomprobantesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                cumplidoscomprobantes.setCumplidoscomprobantesPK(cumplidoscomprobantesPK);
                cumplidoscomprobantes.setContenido(ClaseBaseDatos.resultado.getString("CONTENIDO"));
                cumplidoscomprobantes.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));

                listCumplidoscomprobantes.add(cumplidoscomprobantes);
            }
            return listCumplidoscomprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
