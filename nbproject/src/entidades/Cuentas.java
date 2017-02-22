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
public class Cuentas {

    private String documento;
    private String cuentacontrol;
    private String descripcion;
    private BigDecimal egreso;
    private Date fechadigitacion;
    private Date fechapresupuestal;
    private Date fechatransaccion;
    private String fktercero;
    private BigDecimal ingreso;
    private String soporte;
    private String fkcontrato;
    private String numeroseguimiento;
    public String tabla = "cuentas(documento, cuentacontrol, descripcion, egreso, fechadigitacion,"
            + "fechapresupuestal, fechatransaccion, fktercero, ingreso, soporte, fkcontrato, numeroseguimiento)";

    public Cuentas() {
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setCuentacontrol(String cuentacontrol) {
        this.cuentacontrol = cuentacontrol;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEgreso(BigDecimal egreso) {
        this.egreso = egreso;
    }

    public void setFechadigitacion(Date fechadigitacion) {
        this.fechadigitacion = fechadigitacion;
    }

    public void setFechapresupuestal(Date fechapresupuestal) {
        this.fechapresupuestal = fechapresupuestal;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }

    public void setIngreso(BigDecimal ingreso) {
        this.ingreso = ingreso;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public void setNumeroseguimiento(String numeroseguimiento) {
        this.numeroseguimiento = numeroseguimiento;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCuentacontrol() {
        return cuentacontrol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getEgreso() {
        return egreso;
    }

    public Date getFechadigitacion() {
        return fechadigitacion;
    }

    public Date getFechapresupuestal() {
        return fechapresupuestal;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public String getFktercero() {
        return fktercero;
    }

    public BigDecimal getIngreso() {
        return ingreso;
    }

    public String getSoporte() {
        return soporte;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public String getNumeroseguimiento() {
        return numeroseguimiento;
    }
}
