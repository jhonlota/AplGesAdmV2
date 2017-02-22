/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class Estados {

    private int id;
    private String ventana;
    private String usuario;
    private String estado;
    private String nuevo;
    private String guardar;
    private String consultar;
    private String actualizar;
    private String eliminar;
    public String tabla = "estados(ventana, usuario, estado, nuevo, guardar, consultar, actualizar, "
            + "eliminar, reiniciar)";

    public Estados() {
    }

    public Estados(int id, String ventana, String usuario, String estado, String nuevo, String guardar, String consultar, String actualizar, String eliminar) {
        this.id = id;
        this.ventana = ventana;
        this.usuario = usuario;
        this.estado = estado;
        this.nuevo = nuevo;
        this.guardar = guardar;
        this.consultar = consultar;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
    }

    public String getActualizar() {
        return actualizar;
    }

    public void setActualizar(String actualizar) {
        this.actualizar = actualizar;
    }

    public String getConsultar() {
        return consultar;
    }

    public void setConsultar(String consultar) {
        this.consultar = consultar;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }
}
