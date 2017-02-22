package entidades;

import java.math.BigDecimal;

public class Formadepagocontratos {

    public String tabla = "formadepagocontratos(fkcontrato, fecha, valor)";
    protected FormadepagocontratosPK formadepagocontratosPK = new FormadepagocontratosPK();
    private BigDecimal valor;

    public Formadepagocontratos() {
    }

    public void setFormadepagocontratosPK(FormadepagocontratosPK formadepagocontratosPK) {
        this.formadepagocontratosPK = formadepagocontratosPK;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public FormadepagocontratosPK getFormadepagocontratosPK() {
        return formadepagocontratosPK;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
