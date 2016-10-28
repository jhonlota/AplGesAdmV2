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
public class Soportescuentas {

    protected SoportescuentasPK soportescuentasPK = new SoportescuentasPK();
    private String actividad;
    private String ccostos;
    private String cinfo;
    private String cingreso;
    private String cuenta;
    private String cuentainterna;
    private String subgrupo;
    private BigDecimal valor;
    public String tabla = "soportescuentas(fkcuenta, actividad, ccostos, cinfo, cingreso, cuenta, cuentainterna, "
            + "subgrupo, valor)";

    public Soportescuentas() {
    }

    public Soportescuentas(SoportescuentasPK soportescuentasPK) {
        this.soportescuentasPK = soportescuentasPK;
    }

    public Soportescuentas(String fkcuenta, int id) {
        this.soportescuentasPK = new SoportescuentasPK(fkcuenta, id);
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
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

    public String getCingreso() {
        return cingreso;
    }

    public void setCingreso(String cingreso) {
        this.cingreso = cingreso;
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

    public SoportescuentasPK getSoportescuentasPK() {
        return soportescuentasPK;
    }

    public void setSoportescuentasPK(SoportescuentasPK soportescuentasPK) {
        this.soportescuentasPK = soportescuentasPK;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
