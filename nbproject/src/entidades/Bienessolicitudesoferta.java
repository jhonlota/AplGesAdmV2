/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.math.BigDecimal;

/**
 *
 * @author andres
 */
public class Bienessolicitudesoferta {
    
    protected BienessolicitudesofertaPK bienessolicitudesofertaPK = new BienessolicitudesofertaPK();
    private String nombre;
    private String descripcion;
    private String caracteristicas;
    private Integer cantidad;
    public String tabla = "bienessolicitudesoferta (fksolicitudoferta, nombre, descripcion, caracteristicas, cantidad, ano)";

    public Bienessolicitudesoferta() {
    }

    public Bienessolicitudesoferta(BienessolicitudesofertaPK bienessolicitudesofertaPK) {
        this.bienessolicitudesofertaPK = bienessolicitudesofertaPK;
    }

    public Bienessolicitudesoferta(String fksolicitudoferta, int id, int ano) {
        this.bienessolicitudesofertaPK = new BienessolicitudesofertaPK(fksolicitudoferta, id, ano);
    }

    public BienessolicitudesofertaPK getBienessolicitudesofertaPK() {
        return bienessolicitudesofertaPK;
    }

    public void setBienessolicitudesofertaPK(BienessolicitudesofertaPK bienessolicitudesofertaPK) {
        this.bienessolicitudesofertaPK = bienessolicitudesofertaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }   
    
}
