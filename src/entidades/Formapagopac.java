package entidades;

import java.math.BigDecimal;

public class Formapagopac {

    public String tabla = "formapagopac(fkcontrato, mes, valor)";
    protected FormapagopacPK formapagopacPK = new FormapagopacPK();
    private BigDecimal valor;

    public Formapagopac() {
    }

    public void setFormapagopacPK(FormapagopacPK formapagopacPK) {
        this.formapagopacPK = formapagopacPK;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public FormapagopacPK getFormapagopacPK() {
        return formapagopacPK;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
