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
public class Serviciossolicitudesoferta {
    
    protected ServiciossolicitudesofertaPK serviciossolicitudesofertaPK = new ServiciossolicitudesofertaPK();
    private String nombre;
    private String descripcion;
    private String caracteristicas;
    private Integer cantidad;
    public String tabla = "serviciossolicitudesoferta (fksolicitudoferta, nombre, descripcion, caracteristicas, cantidad, ano)";

    public Serviciossolicitudesoferta() {
    }

    public Serviciossolicitudesoferta(ServiciossolicitudesofertaPK serviciossolicitudesofertaPK) {
        this.serviciossolicitudesofertaPK = serviciossolicitudesofertaPK;
    }

    public Serviciossolicitudesoferta(String fksolicitudoferta, int id, int ano) {
        this.serviciossolicitudesofertaPK = new ServiciossolicitudesofertaPK(fksolicitudoferta, id, ano);
    }

    public ServiciossolicitudesofertaPK getServiciossolicitudesofertaPK() {
        return serviciossolicitudesofertaPK;
    }

    public void setServiciossolicitudesofertaPK(ServiciossolicitudesofertaPK serviciossolicitudesofertaPK) {
        this.serviciossolicitudesofertaPK = serviciossolicitudesofertaPK;
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
