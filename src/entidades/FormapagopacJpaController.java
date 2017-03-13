package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormapagopacJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public FormapagopacJpaController() {
    }

    public void create(Formapagopac formapagopac) {
        try {
            datos.update("INSERT INTO " + formapagopac.tabla + " VALUES ("
                    + "'" + formapagopac.getFormapagopacPK().getFkcontrato() + "', "
                    + "'" + formapagopac.getFormapagopacPK().getMes() + "', "
                    + formapagopac.getValor() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Formapagopac formapagopac, Formapagopac id) {
        try {
            datos.update("UPDATE FORMADEPAGOCONTRATOS SET "
                    //+ "FKCONTRATO = '" + formapagopac.getFormapagopacPK().getFkcontrato() + "', "
                    + "FECHA = '" + formapagopac.getFormapagopacPK().getMes() + "', "
                    + "VALOR = " + formapagopac.getValor() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFormapagopacPK().getFkcontrato() + "' AND "
                    + "FECHA = '" + id.getFormapagopacPK().getMes() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE FORMADEPAGOCONTRATOS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Formapagopac id) {
        try {
            datos.update("DELETE FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFormapagopacPK().getFkcontrato() + "' AND "
                    + "FECHA = '" + id.getFormapagopacPK().getMes() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Formapagopac formapagopac) {
        try {
            ClaseGeneral.errorValidacion = "";
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Formapagopac> findAllInFormapagopacBy() {
        List<Formapagopac> listFormapagopac = new ArrayList<Formapagopac>();
        Formapagopac formapagopac = new Formapagopac();
        FormapagopacPK formapagopacPK = new FormapagopacPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%'");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formapagopac = new Formapagopac();
                formapagopacPK = new FormapagopacPK();
                formapagopacPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                formapagopacPK.setMes(ClaseBaseDatos.resultado.getString("FECHA"));
                formapagopac.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formapagopac.setFormapagopacPK(formapagopacPK);
                listFormapagopac.add(formapagopac);
            }
            return listFormapagopac;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Formapagopac> findAllInFormapagopacByFkcontrato(String fkcontrato) {
        List<Formapagopac> listFormapagopac = new ArrayList<Formapagopac>();
        Formapagopac formapagopac = new Formapagopac();
        FormapagopacPK formapagopacPK = new FormapagopacPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + fkcontrato + "' ORDER BY FECHA");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formapagopac = new Formapagopac();
                formapagopacPK = new FormapagopacPK();
                formapagopacPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                formapagopacPK.setMes(ClaseBaseDatos.resultado.getString("FECHA"));
                formapagopac.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formapagopac.setFormapagopacPK(formapagopacPK);
                listFormapagopac.add(formapagopac);
            }
            return listFormapagopac;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
