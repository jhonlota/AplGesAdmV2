package entidades;

import java.util.Date;

public class FormadepagosolicitudesofertaPK {

    private String fksolicitudoferta;
    private Date fecha;

    public FormadepagosolicitudesofertaPK() {
    }

    public String getFksolicitudoferta() {
        return fksolicitudoferta;
    }

    public void setFksolicitudoferta(String fksolicitudoferta) {
        this.fksolicitudoferta = fksolicitudoferta;
    }    

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
