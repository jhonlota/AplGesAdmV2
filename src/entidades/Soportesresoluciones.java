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
    private String fksoportecuenta;
    private int fksoportecuentaid;
    private int fksoportecomprobante;
    private int fksoportecomprobanteid;
    private int fksoportecomprobanteano;
    private int fktercerosresolucion;
    private String actividad;
    private String ccostos;
    private String cinfo;
    private String cuenta;
    private String cuentainterna;
    private String subgrupo;
    private BigDecimal valor; 
    
    public String tabla = "soportesresoluciones(fkresolucion, fksoportecuenta, fksoportecuentaid, fksoportecomprobante, fksoportecomprobanteid, fksoportecomprobanteano, fktercerosresolucion, actividad, ccostos, cinfo, cuenta, cuentainterna,"
            + "subgrupo, valor, ano)";

    public Soportesresoluciones() {
    }

    public SoportesresolucionesPK getSoportesresolucionesPK() {
        return soportesresolucionesPK;
    }

    public String getFksoportecuenta() {
        return fksoportecuenta;
    }

    public int getFksoportecomprobante() {
        return fksoportecomprobante;
    }

    public int getFksoportecomprobanteid() {
        return fksoportecomprobanteid;
    }

    public int getFksoportecomprobanteano() {
        return fksoportecomprobanteano;
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

    public void setFksoportecuenta(String fksoportecuenta) {
        this.fksoportecuenta = fksoportecuenta;
    }

    public void setFksoportecomprobante(int fksoportecomprobante) {
        this.fksoportecomprobante = fksoportecomprobante;
    }

    public void setFksoportecomprobanteid(int fksoportecomprobanteid) {
        this.fksoportecomprobanteid = fksoportecomprobanteid;
    }

    public void setFksoportecomprobanteano(int fksoportecomprobanteano) {
        this.fksoportecomprobanteano = fksoportecomprobanteano;
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

    public int getFksoportecuentaid() {
        return fksoportecuentaid;
    }

    public void setFksoportecuentaid(int fksoportecuentaid) {
        this.fksoportecuentaid = fksoportecuentaid;
    }

    public int getFktercerosresolucion() {
        return fktercerosresolucion;
    }

    public void setFktercerosresolucion(int fktercerosresolucion) {
        this.fktercerosresolucion = fktercerosresolucion;
    }
   
    
}
