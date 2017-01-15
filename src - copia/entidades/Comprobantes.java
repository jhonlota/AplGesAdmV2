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
public class Comprobantes {

    private int id;
    private int comprobante;
    private Date fechaaplicacion;
    private Date fechaelaboracion;
    private Date fechapago;
    private String fktercerofuncionario;
    private String fktercero;
    private String observacion;
    private String tipopago;
    private BigDecimal valor;
    private int ano;
    public String tabla = "comprobantes(comprobante, fechaaplicacion, fechaelaboracion, "
            + "fechapago, fktercero, fktercerofuncionario, observacion, "
            + "tipopago, valor, ano)";

    public Comprobantes() {
    }

    public Comprobantes(int id) {
        this.id = id;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFechaaplicacion() {
        return fechaaplicacion;
    }

    public void setFechaaplicacion(Date fechaaplicacion) {
        this.fechaaplicacion = fechaaplicacion;
    }

    public Date getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(Date fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getFktercero() {
        return fktercero;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }

    public String getFktercerofuncionario() {
        return fktercerofuncionario;
    }

    public void setFktercerofuncionario(String fktercerofuncionario) {
        this.fktercerofuncionario = fktercerofuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
