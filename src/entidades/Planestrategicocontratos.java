package entidades;

import java.math.BigDecimal;

public class Planestrategicocontratos {

    private String fkcontrato;
    private int id;
    private String eje;
    private String estrategia;
    private String programa;
    private String proyecto;
    private String subgrupo;
    private String cinfo;
    private String verificacionestrategia;

    public String tabla = "planestrategicocontratos(fkcontrato, eje, estrategia, programa, proyecto, subgrupo, cinfo, verificacionestrategia)";

    public Planestrategicocontratos() {
    }

    public Planestrategicocontratos(String fkcontrato, int id, String eje, String estrategia, String programa, String proyecto, String subgrupo, String cinfo, String verificacionestrategia) {
        this.fkcontrato = fkcontrato;
        this.id = id;
        this.eje = eje;
        this.estrategia = estrategia;
        this.programa = programa;
        this.proyecto = proyecto;
        this.subgrupo = subgrupo;
        this.cinfo = cinfo;
        this.verificacionestrategia = verificacionestrategia;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getVerificacionestrategia() {
        return verificacionestrategia;
    }

    public void setVerificacionestrategia(String verificacionestrategia) {
        this.verificacionestrategia = verificacionestrategia;
    }
}
