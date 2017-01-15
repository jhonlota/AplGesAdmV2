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
public class Polizas {

    protected PolizasPK polizasPK = new PolizasPK();
    private String aseguradora;
    private Date fechaexpedicionpoliza;
    private Date fechaaprobacionpoliza;
    private Date fechainicialamparo;
    private Date fechafinalamparo;
    private String resolucionpoliza;
    private BigDecimal valorasegurado;
    public String tabla = "polizas(fkcontrato, numeropoliza, aseguradora, fechaaprobacionpoliza,"
            + "fechaexpedicionpoliza, fechafinalamparo, fechainicialamparo,"
            + "resolucionpoliza, tipopoliza, valorasegurado)";

    public Polizas() {
    }

    public Polizas(PolizasPK polizasPK) {
        this.polizasPK = polizasPK;
    }

    public Polizas(String fkcontrato, String numeropoliza, String tipopoliza) {
        this.polizasPK = new PolizasPK(fkcontrato, numeropoliza, tipopoliza);
    }

    public PolizasPK getPolizasPK() {
        return polizasPK;
    }

    public void setPolizasPK(PolizasPK polizasPK) {
        this.polizasPK = polizasPK;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public Date getFechaexpedicionpoliza() {
        return fechaexpedicionpoliza;
    }

    public void setFechaexpedicionpoliza(Date fechaexpedicionpoliza) {
        this.fechaexpedicionpoliza = fechaexpedicionpoliza;
    }

    public String getResolucionpoliza() {
        return resolucionpoliza;
    }

    public void setResolucionpoliza(String resolucionpoliza) {
        this.resolucionpoliza = resolucionpoliza;
    }

    public Date getFechaaprobacionpoliza() {
        return fechaaprobacionpoliza;
    }

    public void setFechaaprobacionpoliza(Date fechaaprobacionpoliza) {
        this.fechaaprobacionpoliza = fechaaprobacionpoliza;
    }

    public BigDecimal getValorasegurado() {
        return valorasegurado;
    }

    public void setValorasegurado(BigDecimal valorasegurado) {
        this.valorasegurado = valorasegurado;
    }

    public Date getFechainicialamparo() {
        return fechainicialamparo;
    }

    public void setFechainicialamparo(Date fechainicialamparo) {
        this.fechainicialamparo = fechainicialamparo;
    }

    public Date getFechafinalamparo() {
        return fechafinalamparo;
    }

    public void setFechafinalamparo(Date fechafinalamparo) {
        this.fechafinalamparo = fechafinalamparo;
    }
}
