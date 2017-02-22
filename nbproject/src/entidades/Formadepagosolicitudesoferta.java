package entidades;

import java.math.BigDecimal;

public class Formadepagosolicitudesoferta {

    public String tabla = "formadepagosolicitudesoferta(fksolicitudoferta, fecha, valor)";
    protected FormadepagosolicitudesofertaPK formadepagosolicitudesofertaPK = new FormadepagosolicitudesofertaPK();
    private BigDecimal valor;

    public Formadepagosolicitudesoferta() {
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public FormadepagosolicitudesofertaPK getFormadepagosolicitudesofertaPK() {
        return formadepagosolicitudesofertaPK;
    }

    public void setFormadepagosolicitudesofertaPK(FormadepagosolicitudesofertaPK formadepagosolicitudesofertaPK) {
        this.formadepagosolicitudesofertaPK = formadepagosolicitudesofertaPK;
    }
    
    
}
