/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class Clasificadorunspsc {

    private String codigosegmento;
    private String nombresegmento;
    private String codigofamilia;
    private String nombrefamilia;
    private String codigoclase;
    private String nombreclase;
    private String codigoproducto;
    private String nombreproducto;
    private String codigogrupo;
    private String nombregrupo;
    public String tabla = "clasificadorunspsc("
            + "codigosegmento, nombresegmento, codigofamilia, nombrefamilia, "
            + "codigoclase, nombreclase, codigoproducto, nombreproducto, codigogrupo, "
            + "nombregrupo)";

    public Clasificadorunspsc() {
    }

    public Clasificadorunspsc(String codigosegmento, String nombresegmento, String codigofamilia, String nombrefamilia, String codigoclase, String nombreclase, String codigoproducto, String nombreproducto, String codigogrupo, String nombregrupo) {
        this.codigosegmento = codigosegmento;
        this.nombresegmento = nombresegmento;
        this.codigofamilia = codigofamilia;
        this.nombrefamilia = nombrefamilia;
        this.codigoclase = codigoclase;
        this.nombreclase = nombreclase;
        this.codigoproducto = codigoproducto;
        this.nombreproducto = nombreproducto;
        this.codigogrupo = codigogrupo;
        this.nombregrupo = nombregrupo;
    }

    public String getCodigosegmento() {
        return codigosegmento;
    }

    public void setCodigosegmento(String codigosegmento) {
        this.codigosegmento = codigosegmento;
    }

    public String getNombresegmento() {
        return nombresegmento;
    }

    public void setNombresegmento(String nombresegmento) {
        this.nombresegmento = nombresegmento;
    }

    public String getCodigofamilia() {
        return codigofamilia;
    }

    public void setCodigofamilia(String codigofamilia) {
        this.codigofamilia = codigofamilia;
    }

    public String getNombrefamilia() {
        return nombrefamilia;
    }

    public void setNombrefamilia(String nombrefamilia) {
        this.nombrefamilia = nombrefamilia;
    }

    public String getCodigoclase() {
        return codigoclase;
    }

    public void setCodigoclase(String codigoclase) {
        this.codigoclase = codigoclase;
    }

    public String getNombreclase() {
        return nombreclase;
    }

    public void setNombreclase(String nombreclase) {
        this.nombreclase = nombreclase;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getCodigogrupo() {
        return codigogrupo;
    }

    public void setCodigogrupo(String codigogrupo) {
        this.codigogrupo = codigogrupo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

}
