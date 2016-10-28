package entidades;

import java.util.Date;

public class Resoluciones {

    public String tabla = "resolucion(acuerdo, ano, fecha, fechainicio, fechaterminacion, fkterceroordenadorgasto, observacion, tipo, vehiculo, isfindesemana)";//id, 
    protected ResolucionesPK resolucionPK = new ResolucionesPK();
    private String acuerdo;
    private Date fecha;
    private Date fechainicio;
    private Date fechaterminacion;
    private String fkterceroordenadorgasto;
    private String observacion;
    private String tipo;
    private String vehiculo;
    private boolean isfindesemana;

    public Resoluciones() {
    }

    public void setResolucionPK(ResolucionesPK resolucionPK) {
        this.resolucionPK = resolucionPK;
    }

    public void setAcuerdo(String acuerdo) {
        this.acuerdo = acuerdo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechaterminacion(Date fechaterminacion) {
        this.fechaterminacion = fechaterminacion;
    }

    public void setFkterceroordenadorgasto(String fkterceroordenadorgasto) {
        this.fkterceroordenadorgasto = fkterceroordenadorgasto;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setIsfindesemana(boolean isfindesemana) {
        this.isfindesemana = isfindesemana;
    }

    public ResolucionesPK getResolucionPK() {
        return resolucionPK;
    }

    public String getAcuerdo() {
        return acuerdo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechaterminacion() {
        return fechaterminacion;
    }

    public String getFkterceroordenadorgasto() {
        return fkterceroordenadorgasto;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public boolean getIsfindesemana() {
        return isfindesemana;
    }
}
