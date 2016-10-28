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
public class EstadosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public EstadosJpaController() {
    }

    public void create(Estados estados) {
        try {
            datos.update("INSERT INTO " + estados.tabla + " VALUES ("
                    //+ estados.getId() + ", "
                    + "'" + estados.getVentana() + "', "
                    + "'" + estados.getUsuario() + "', "
                    + "'" + estados.getEstado() + "', "
                    + "'" + estados.getNuevo() + "', "
                    + "'" + estados.getGuardar() + "', "
                    + "'" + estados.getConsultar() + "', "
                    + "'" + estados.getActualizar() + "', "
                    + "'" + estados.getEliminar() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Estado");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Estados estados) {
        try {
            datos.update("UPDATE ESTADO SET "
                    + "VENTANA = '" + estados.getVentana() + "', "
                    + "USUARIO = '" + estados.getUsuario() + "', "
                    + "ESTADO = '" + estados.getEstado() + "', "
                    + "NUEVO = '" + estados.getNuevo() + "', "
                    + "GUARDAR = '" + estados.getGuardar() + "', "
                    + "CONSULTAR = '" + estados.getConsultar() + "', "
                    + "ACTUALIZAR = '" + estados.getActualizar() + "', "
                    + "ELIMINAR = '" + estados.getEliminar() + "' "
                    + "WHERE "
                    + "ID = '" + estados.getId() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Estado");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM ESTADO "
                    + "WHERE "
                    + "ID = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Estado");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Estados> findAllInEstadosBy() {
        List<Estados> listEstados = new ArrayList<Estados>();
        Estados estados;
        try {
            datos.query("SELECT * FROM ESTADO "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                    + "ORDER BY USUARIO, VENTANA");
            while (ClaseBaseDatos.resultado.next()) {
                estados = new Estados();
                estados.setId(ClaseBaseDatos.resultado.getInt("ID"));
                estados.setVentana(ClaseBaseDatos.resultado.getString("VENTANA"));
                estados.setUsuario(ClaseBaseDatos.resultado.getString("USUARIO"));
                estados.setEstado(ClaseBaseDatos.resultado.getString("ESTADO"));
                estados.setNuevo(ClaseBaseDatos.resultado.getString("NUEVO"));
                estados.setGuardar(ClaseBaseDatos.resultado.getString("GUARDAR"));
                estados.setConsultar(ClaseBaseDatos.resultado.getString("CONSULTAR"));
                estados.setActualizar(ClaseBaseDatos.resultado.getString("ACTUALIZAR"));
                estados.setEliminar(ClaseBaseDatos.resultado.getString("ELIMINAR"));

                listEstados.add(estados);
            }
            return listEstados;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
