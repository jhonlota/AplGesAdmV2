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
public class Calificacion {

    private int id;
    private String fktercero;
    private String tramite;
    private Date fecha;
    private String descripcion;
    private BigDecimal valor;
    private String observacion;
    private int pregunta1;
    private int pregunta2;
    private int pregunta3;
    private int pregunta4;
    private int pregunta5;
    public String tabla = "calificacion(fktercero, tramite, fecha, descripcion, valor, observacion," 
            + "pregunta1, pregunta2, pregunta3, pregunta4, pregunta5)";

    public Calificacion() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setPregunta1(int pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public void setPregunta2(int pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public void setPregunta3(int pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public void setPregunta4(int pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public void setPregunta5(int pregunta5) {
        this.pregunta5 = pregunta5;
    }

    public int getId() {
        return id;
    }

    public String getFktercero() {
        return fktercero;
    }

    public String getTramite() {
        return tramite;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public int getPregunta1() {
        return pregunta1;
    }

    public int getPregunta2() {
        return pregunta2;
    }

    public int getPregunta3() {
        return pregunta3;
    }

    public int getPregunta4() {
        return pregunta4;
    }

    public int getPregunta5() {
        return pregunta5;
    }
}
