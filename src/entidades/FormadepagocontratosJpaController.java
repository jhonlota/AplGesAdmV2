package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class FormadepagocontratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public FormadepagocontratosJpaController() {
    }

    public void create(Formadepagocontratos formadepagocontratos) {
        try {
            datos.update("INSERT INTO " + formadepagocontratos.tabla + " VALUES ("
                    + "'" + formadepagocontratos.getFormadepagocontratosPK().getFkcontrato() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(formadepagocontratos.getFormadepagocontratosPK().getFecha()) + "', "
                    + formadepagocontratos.getValor() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Formadepagocontratos formadepagocontratos, Formadepagocontratos id) {
        try {
            datos.update("UPDATE FORMADEPAGOCONTRATOS SET "
                    //+ "FKCONTRATO = '" + formadepagocontratos.getFormadepagocontratosPK().getFkcontrato() + "', "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(formadepagocontratos.getFormadepagocontratosPK().getFecha()) + "', "
                    + "VALOR = " + formadepagocontratos.getValor() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFormadepagocontratosPK().getFkcontrato() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFormadepagocontratosPK().getFecha()) + "'");
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

    public void destroy(Formadepagocontratos id) {
        try {
            datos.update("DELETE FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFormadepagocontratosPK().getFkcontrato() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFormadepagocontratosPK().getFecha()) + "'");
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

    public boolean verify(Formadepagocontratos formadepagocontratos) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.contratos.getFechainicio(), formadepagocontratos.getFormadepagocontratosPK().getFecha()) >= 0, "FECHA ANTERIOR A LA DE INICIO")
                    && ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.contratos.getFechaterminacion(), formadepagocontratos.getFormadepagocontratosPK().getFecha()) <= 0, "FECHA POSTERIOR A LA DE TERMINACION")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Formadepagocontratos> findAllInFormadepagocontratosBy() {
        List<Formadepagocontratos> listFormadepagocontratos = new ArrayList<Formadepagocontratos>();
        Formadepagocontratos formadepagocontratos = new Formadepagocontratos();
        FormadepagocontratosPK formadepagocontratosPK = new FormadepagocontratosPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%'");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formadepagocontratos = new Formadepagocontratos();
                formadepagocontratosPK = new FormadepagocontratosPK();
                formadepagocontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                formadepagocontratosPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                formadepagocontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formadepagocontratos.setFormadepagocontratosPK(formadepagocontratosPK);
                listFormadepagocontratos.add(formadepagocontratos);
            }
            return listFormadepagocontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Formadepagocontratos> findAllInFormadepagocontratosByFkcontrato(String fkcontrato) {
        List<Formadepagocontratos> listFormadepagocontratos = new ArrayList<Formadepagocontratos>();
        Formadepagocontratos formadepagocontratos = new Formadepagocontratos();
        FormadepagocontratosPK formadepagocontratosPK = new FormadepagocontratosPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + fkcontrato + "' ORDER BY FECHA");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formadepagocontratos = new Formadepagocontratos();
                formadepagocontratosPK = new FormadepagocontratosPK();
                formadepagocontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                formadepagocontratosPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                formadepagocontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formadepagocontratos.setFormadepagocontratosPK(formadepagocontratosPK);
                listFormadepagocontratos.add(formadepagocontratos);
            }
            return listFormadepagocontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

//    public DefaultComboBoxModel COMBOIdNombreInFormadepagocontratosBy() {
//        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();
//        try {
//            modeloCombo.addElement("Seleccione - ");
//            datos.query("SELECT DISTINCT(ID), NOMBRE FROM FORMADEPAGOCONTRATOS");// ORDER BY id
//            while (ClaseBaseDatos.resultado.next()) {
//                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("ID") + " - " + ClaseBaseDatos.resultado.getString("NOMBRE"));
//            }
//            return modeloCombo;
//        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
//            return modeloCombo;
//        }
//    }
}
