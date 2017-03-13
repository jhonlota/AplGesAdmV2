package entidades;

public class FormapagopacPK {

    private String fkcontrato;
    private String mes;

    public FormapagopacPK() {
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public String getMes() {
        return mes;
    }
}
