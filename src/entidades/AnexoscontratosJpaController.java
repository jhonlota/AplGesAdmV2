/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class AnexoscontratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public AnexoscontratosJpaController() {
    }

    public void create(Anexoscontratos anexoscontratos) {
        try {
            datos.update("INSERT INTO " + anexoscontratos.tabla + " VALUES ("
                    + "'" + anexoscontratos.getAnexoscontratosPK().getDocumento() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(anexoscontratos.getAnexoscontratosPK().getFecha()) + "', "
                    + "'" + anexoscontratos.getAnexoscontratosPK().getFkcontrato() + "', "
                    + "'" + anexoscontratos.getArchivo() + "', "
                    + "'" + anexoscontratos.getDescripcion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Anexoscontratos anexoscontratos, Anexoscontratos id) {
        try {
            datos.update("UPDATE ANEXOSCONTRATOS SET "
                    + "ARCHIVO = '" + anexoscontratos.getArchivo() + "', "
                    + "DESCRIPCION = '" + anexoscontratos.getDescripcion() + "' "
                    + "WHERE "
                    + "DOCUMENTO = '" + id.getAnexoscontratosPK().getDocumento() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getAnexoscontratosPK().getFecha()) + "' AND "
                    + "FKCONTRATO = '" + id.getAnexoscontratosPK().getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE ANEXOSCONTRATOS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(AnexoscontratosPK id) {
        try {
            datos.update("DELETE FROM ANEXOSCONTRATOS "
                    + "WHERE "
                    + "DOCUMENTO = '" + id.getDocumento() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFecha()) + "' AND "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkContrato(String id) {
        try {
            datos.update("DELETE FROM ANEXOSCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Anexoscontratos> findAllInAnexoscontratosByFkcontrato(String fkcontrato) {
        List<Anexoscontratos> listAnexoscontratos = new ArrayList<Anexoscontratos>();
        Anexoscontratos anexoscontratos;
        AnexoscontratosPK anexoscontratosPK;

        try {
            datos.query("SELECT * FROM ANEXOSCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY DOCUMENTO, FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                anexoscontratos = new Anexoscontratos();
                anexoscontratosPK = new AnexoscontratosPK();
                anexoscontratosPK.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                anexoscontratosPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                anexoscontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                anexoscontratos.setAnexoscontratosPK(anexoscontratosPK);
                anexoscontratos.setArchivo(ClaseBaseDatos.resultado.getString("ARCHIVO"));
                anexoscontratos.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));

                listAnexoscontratos.add(anexoscontratos);
            }
            return listAnexoscontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
    
    public boolean EXISTSAnexoscontratosByFkcontrato(String fkcontrato) {
        boolean exists = false;

        try {
            datos.query("SELECT * FROM ANEXOSCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "'");
            while (ClaseBaseDatos.resultado.next()) {
                exists = true;
            }
            return exists;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return exists;
        }
    }
}
