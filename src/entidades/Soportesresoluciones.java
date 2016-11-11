/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import clases.ClaseBaseDatos;
import java.math.BigDecimal;

/**
 *
 * @author User
 */

public class Soportesresoluciones {
    protected SoportesresolucionesPK soportesresolucionesPK = new SoportesresolucionesPK();
    private String fkcuenta;
    private int fkcomprobante;
    private String actividad;
    private String ccostos;
    private String cinfo;
    private String cuenta;
    private String cuentainterna;
    private String subgrupo;
    private BigDecimal valor; 
    
    public String tabla = "soportesresoluciones(fkresolucion, fkcuenta, fkcomprobante, actividad, ccostos, cinfo, cuenta, cuentainterna,"
            + "subgrupo, valor, ano)";

    public Soportesresoluciones() {
    }

    public SoportesresolucionesPK getSoportesresolucionesPK() {
        return soportesresolucionesPK;
    }

    public String getFkcuenta() {
        return fkcuenta;
    }

    public int getFkcomprobante() {
        return fkcomprobante;
    }

    public String getActividad() {
        return actividad;
    }

    public String getCcostos() {
        return ccostos;
    }

    public String getCinfo() {
        return cinfo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getCuentainterna() {
        return cuentainterna;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getTabla() {
        return tabla;
    }

    public void setSoportesresolucionesPK(SoportesresolucionesPK soportesresolucionesPK) {
        this.soportesresolucionesPK = soportesresolucionesPK;
    }

    public void setFkcuenta(String fkcuenta) {
        this.fkcuenta = fkcuenta;
    }

    public void setFkcomprobante(int fkcomprobante) {
        this.fkcomprobante = fkcomprobante;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setCcostos(String ccostos) {
        this.ccostos = ccostos;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setCuentainterna(String cuentainterna) {
        this.cuentainterna = cuentainterna;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
    
}
