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
public class Modificaciones {
    protected ModificacionesPK modificacionesPK = new ModificacionesPK();
    private String tipomodifprorr;
    private BigDecimal valortotalmodifprorr;
    public String tabla = "modificaciones(fechamodifprorr, fkcontrato, tipomodifprorr, valortotalmodifprorr)";

    public Modificaciones() {
    }

    public Modificaciones(ModificacionesPK modificacionesPK) {
        this.modificacionesPK = modificacionesPK;
    }

    public Modificaciones(String fkcontrato, Date fechamodifprorr) {
        this.modificacionesPK = new ModificacionesPK(fkcontrato, fechamodifprorr);
    }

    public ModificacionesPK getModificacionesPK() {
        return modificacionesPK;
    }

    public void setModificacionesPK(ModificacionesPK modificacionesPK) {
        this.modificacionesPK = modificacionesPK;
    }

    public String getTipomodifprorr() {
        return tipomodifprorr;
    }

    public void setTipomodifprorr(String tipomodifprorr) {
        this.tipomodifprorr = tipomodifprorr;
    }

    public BigDecimal getValortotalmodifprorr() {
        return valortotalmodifprorr;
    }

    public void setValortotalmodifprorr(BigDecimal valortotalmodifprorr) {
        this.valortotalmodifprorr = valortotalmodifprorr;
    }
}
