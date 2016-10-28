/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jhon Lopez
 */
public class Soportescontratos {

    protected SoportescontratosPK soportescontratosPK = new SoportescontratosPK();
    private Date fecha;
    private String numero;
    private String cuenta;
    private String actividad;
    private String subgrupo;
    private String ccostos;
    private String cinfo;
    private String tipo;
    private BigDecimal valor;
    public String tabla = "soportescontratos(fkcontrato, numero, tipo, actividad, ccostos, cinfo, cuenta, "
            + "fecha, subgrupo, valor)";

    public Soportescontratos() {
    }

    public Soportescontratos(SoportescontratosPK soportescontratosPK) {
        this.soportescontratosPK = soportescontratosPK;
    }

    public Soportescontratos(String fkcontrato, int id) {
        this.soportescontratosPK = new SoportescontratosPK(fkcontrato, id);
    }

    public SoportescontratosPK getSoportescontratosPK() {
        return soportescontratosPK;
    }

    public void setSoportescontratosPK(SoportescontratosPK soportescontratosPK) {
        this.soportescontratosPK = soportescontratosPK;
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

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
