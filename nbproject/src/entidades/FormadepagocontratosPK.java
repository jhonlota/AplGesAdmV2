package entidades;

import java.util.Date;

public class FormadepagocontratosPK {

    private String fkcontrato;
    private Date fecha;

    public FormadepagocontratosPK() {
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public Date getFecha() {
        return fecha;
    }
}
