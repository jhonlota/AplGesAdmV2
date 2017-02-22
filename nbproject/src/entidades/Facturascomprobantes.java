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
public class Facturascomprobantes {

    protected FacturascomprobantesPK facturascomprobantesPK = new FacturascomprobantesPK();
    private BigDecimal valor;
    private Date fecha;
    public String tabla = "facturascomprobantes("
            + "fkcomprobante, numero, valor, ano, fecha)";

    public Facturascomprobantes() {
    }

    public Facturascomprobantes(FacturascomprobantesPK facturascomprobantesPK) {
        this.facturascomprobantesPK = facturascomprobantesPK;
    }

    public Facturascomprobantes(int fkcomprobante, String numero, int ano) {
        this.facturascomprobantesPK = new FacturascomprobantesPK(fkcomprobante, numero, ano);
    }

    public FacturascomprobantesPK getFacturascomprobantesPK() {
        return facturascomprobantesPK;
    }

    public void setFacturascomprobantesPK(FacturascomprobantesPK facturascomprobantesPK) {
        this.facturascomprobantesPK = facturascomprobantesPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
