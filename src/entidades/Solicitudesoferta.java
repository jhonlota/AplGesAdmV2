/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author andres
 */
public class Solicitudesoferta {
    private int id;
    private Date fechaelaboracion;
    private Date horaelaboracion;
    private String fktercero;
    private String fktercerofuncionario;
    private int numerocertificado;
    private BigDecimal valorcertificado;
    private Date fechaentrega;
    private String informacionservicio;
    private int ano;
    private String secopnumeroproceso;
    private String secopnumeroconstancia;
    private Date secopfechapublicacion;
    public String tabla = "solicitudesoferta(fechaelaboracion, horaelaboracion, "
            + "fktercero, fktercerofuncionario, numerocertificado, valorcertificado, "
            + "fechaentrega, informacionservicio, ano, secopnumeroproceso, "
            + "secopnumeroconstancia, secopfechapublicacion)";

    public Solicitudesoferta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(Date fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public Date getHoraelaboracion() {
        return horaelaboracion;
    }

    public void setHoraelaboracion(Date horaelaboracion) {
        this.horaelaboracion = horaelaboracion;
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

    public int getNumerocertificado() {
        return numerocertificado;
    }

    public void setNumerocertificado(int numerocertificado) {
        this.numerocertificado = numerocertificado;
    }

    public BigDecimal getValorcertificado() {
        return valorcertificado;
    }

    public void setValorcertificado(BigDecimal valorcertificado) {
        this.valorcertificado = valorcertificado;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getInformacionservicio() {
        return informacionservicio;
    }

    public void setInformacionservicio(String informacionservicio) {
        this.informacionservicio = informacionservicio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getSecopnumeroproceso() {
        return secopnumeroproceso;
    }

    public void setSecopnumeroproceso(String secopnumeroproceso) {
        this.secopnumeroproceso = secopnumeroproceso;
    }

    public String getSecopnumeroconstancia() {
        return secopnumeroconstancia;
    }

    public void setSecopnumeroconstancia(String secopnumeroconstancia) {
        this.secopnumeroconstancia = secopnumeroconstancia;
    }

    public Date getSecopfechapublicacion() {
        return secopfechapublicacion;
    }

    public void setSecopfechapublicacion(Date secopfechapublicacion) {
        this.secopfechapublicacion = secopfechapublicacion;
    }
}
