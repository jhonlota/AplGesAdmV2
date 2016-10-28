/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jhon Lopez
 */
public class Soportescomprobantes {

    protected SoportescomprobantesPK soportescomprobantesPK = new SoportescomprobantesPK();
    private String cuenta;
    private String cuentainterna;
    private String actividad;
    private String subgrupo;
    private String ccostos;
    private String cinfo;
    private BigDecimal valor;
    public String tabla = "soportescomprobantes(fkcomprobante, actividad, ccostos, cinfo, cuenta, cuentainterna,"
            + "subgrupo, valor, ano)";

    public Soportescomprobantes() {
    }

    public Soportescomprobantes(SoportescomprobantesPK soportescomprobantesPK) {
        this.soportescomprobantesPK = soportescomprobantesPK;
    }

    public Soportescomprobantes(int fkcomprobante, int id, int ano) {
        this.soportescomprobantesPK = new SoportescomprobantesPK(fkcomprobante, id, ano);
    }

    public SoportescomprobantesPK getSoportescomprobantesPK() {
        return soportescomprobantesPK;
    }

    public void setSoportescomprobantesPK(SoportescomprobantesPK soportescomprobantesPK) {
        this.soportescomprobantesPK = soportescomprobantesPK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuentainterna() {
        return cuentainterna;
    }

    public void setCuentainterna(String cuentainterna) {
        this.cuentainterna = cuentainterna;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getCcostos() {
        return ccostos;
    }

    public void setCcostos(String ccostos) {
        this.ccostos = ccostos;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
