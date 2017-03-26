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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class AnexostercerosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public AnexostercerosJpaController() {
    }

    public void create(Anexosterceros anexosterceros) {
        try {
            datos.update("INSERT INTO " + anexosterceros.tabla + " VALUES ("
                    + "'" + anexosterceros.getAnexostercerosPK().getDocumento() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(anexosterceros.getAnexostercerosPK().getFecha()) + "', "
                    + "'" + anexosterceros.getAnexostercerosPK().getFktercero() + "', "
                    + "'" + anexosterceros.getArchivo() + "', "
                    + "'" + anexosterceros.getDescripcion() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Anexosterceros anexosterceros, Anexosterceros id) {
        try {
            datos.update("UPDATE ANEXOSTERCEROS SET "
                    + "ARCHIVO = '" + anexosterceros.getArchivo() + "', "
                    + "DESCRIPCION = '" + anexosterceros.getDescripcion() + "' "
                    + "WHERE "
                    + "DOCUMENTO = '" + id.getAnexostercerosPK().getDocumento() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getAnexostercerosPK().getFecha()) + "' AND "
                    + "FKTERCERO = '" + id.getAnexostercerosPK().getFktercero() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE ANEXOSTERCEROS SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");

        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(AnexostercerosPK id) {
        try {
            datos.update("DELETE FROM ANEXOSTERCEROS "
                    + "WHERE "
                    + "DOCUMENTO = '" + id.getDocumento() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFecha()) + "' AND "
                    + "FKTERCERO = '" + id.getFktercero() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFktercero(String id) {
        try {
            datos.update("DELETE FROM ANEXOSTERCEROS "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Anexo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Anexosterceros> findAllInAnexostercerosByFktercero(String fktercero) {
        List<Anexosterceros> listAnexosterceros = new ArrayList<Anexosterceros>();
        Anexosterceros anexosterceros;
        AnexostercerosPK anexostercerosPK;

        try {
            datos.query("SELECT * FROM ANEXOSTERCEROS WHERE FKTERCERO = '" + fktercero + "' ORDER BY DOCUMENTO, FECHA");
            while (ClaseBaseDatos.resultado.next()) {
                anexosterceros = new Anexosterceros();
                anexostercerosPK = new AnexostercerosPK();
                anexostercerosPK.setDocumento(ClaseBaseDatos.resultado.getString("DOCUMENTO"));
                anexostercerosPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                anexostercerosPK.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                anexosterceros.setAnexostercerosPK(anexostercerosPK);
                anexosterceros.setArchivo(ClaseBaseDatos.resultado.getString("ARCHIVO"));
                anexosterceros.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));

                listAnexosterceros.add(anexosterceros);
            }
            return listAnexosterceros;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public String findDocumentoDiasTotalInAnexostercerosByFkterceroPersonaFecha(String fktercero, String persona, Date fecha) {
        String text = new String();
        
        try {
            datos.query("SELECT *, ('" + ClaseInformacion.ConvertirFecha(fecha) + "' - FECHA) AS TOTAL FROM "
                    + "(SELECT * FROM VERIFICAANEXOSTERCEROS WHERE " + persona + " = TRUE) AS A LEFT JOIN "
                    + "(SELECT DOCUMENTO, MAX(FECHA) AS FECHA FROM ANEXOSTERCEROS WHERE FKTERCERO = '" + fktercero + "' GROUP BY DOCUMENTO) AS B "
                    + "ON A.VERIFICA = B.DOCUMENTO ORDER BY VERIFICA");
            while (ClaseBaseDatos.resultado.next()) {
                try {
                    String estado;

                    if (ClaseBaseDatos.resultado.getString("DOCUMENTO") == null) {
                        estado = "NO ADJUNTO";
                    } else if (ClaseBaseDatos.resultado.getInt("DIAS") == 0) {
                        estado = "ACTIVO";
                    } else if (ClaseBaseDatos.resultado.getInt("TOTAL") > ClaseBaseDatos.resultado.getInt("DIAS")) {
                        estado = "VENCIDO";
                    } else {
                        estado = "ACTIVO";
                    }

                    text += "<dt>" + ClaseBaseDatos.resultado.getString("VERIFICA") + "</dt><dd>"
                            + (ClaseBaseDatos.resultado.getDate("FECHA") == null ? "" : ClaseBaseDatos.resultado.getDate("FECHA"))
                            + (ClaseBaseDatos.resultado.getDate("FECHA") == null ? "" : " // " + ClaseBaseDatos.resultado.getInt("TOTAL") + " dias // ")
                            + estado + "</dd>";
                } catch (SQLException ex) {
                    ClaseMensaje.errorFind(this.toString(), ex.toString());
                }
            }
            
            return text;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
