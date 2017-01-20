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

public class FormadepagosolicitudesofertaJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public FormadepagosolicitudesofertaJpaController() {
    }

    public void create(Formadepagosolicitudesoferta formadepagosolicitudesoferta) {
        try {
            datos.update("INSERT INTO " + formadepagosolicitudesoferta.tabla + " VALUES ("
                    + "'" + formadepagosolicitudesoferta.getFormadepagosolicitudesofertaPK().getFksolicitudoferta() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(formadepagosolicitudesoferta.getFormadepagosolicitudesofertaPK().getFecha()) + "', "
                    + formadepagosolicitudesoferta.getValor() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Formadepagosolicitudesoferta formadepagosolicitudesoferta, Formadepagosolicitudesoferta id) {
        try {
            datos.update("UPDATE FORMADEPAGOSOLICITUDESOFERTA SET "
                    //+ "FKCONTRATO = '" + formadepagocontratos.getFormadepagocontratosPK().getFkcontrato() + "', "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(formadepagosolicitudesoferta.getFormadepagosolicitudesofertaPK().getFecha()) + "', "
                    + "VALOR = " + formadepagosolicitudesoferta.getValor() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFormadepagosolicitudesofertaPK().getFksolicitudoferta() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFormadepagosolicitudesofertaPK().getFecha()) + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFksolicitudoferta(String fksolicitudoferta, String id) {
        try {
            datos.update("UPDATE FORMADEPAGOSOLICITUDESOFERTA SET "
                    + "FKSOLICITUDOFERTA = '" + fksolicitudoferta + "' "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Formadepagosolicitudesoferta id) {
        try {
            datos.update("DELETE FROM FORMADEPAGOSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA= '" + id.getFormadepagosolicitudesofertaPK().getFksolicitudoferta() + "' AND "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(id.getFormadepagosolicitudesofertaPK().getFecha()) + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFksolicitudoferta(String id) {
        try {
            datos.update("DELETE FROM FORMADEPAGOSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Forma de Pago");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Formadepagosolicitudesoferta formadepagosolicitudesoferta) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.contratos.getFechainicio(), formadepagosolicitudesoferta.getFormadepagosolicitudesofertaPK().getFecha()) >= 0, "FECHA ANTERIOR A LA DE INICIO")
                    && ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.contratos.getFechaterminacion(), formadepagosolicitudesoferta.getFormadepagosolicitudesofertaPK().getFecha()) <= 0, "FECHA POSTERIOR A LA DE TERMINACION")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Formadepagosolicitudesoferta> findAllInFormadepagosolicitudesofertaBy() {
        List<Formadepagosolicitudesoferta> listFormadepagosolicitudesoferta = new ArrayList<Formadepagosolicitudesoferta>();
        Formadepagosolicitudesoferta formadepagosolicitudesoferta = new Formadepagosolicitudesoferta();
        FormadepagosolicitudesofertaPK formadepagosolicitudesofertaPK = new FormadepagosolicitudesofertaPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOSOLICITUDESOFERTA "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%'");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formadepagosolicitudesoferta = new Formadepagosolicitudesoferta();
                formadepagosolicitudesofertaPK = new FormadepagosolicitudesofertaPK();
                formadepagosolicitudesofertaPK.setFksolicitudoferta(ClaseBaseDatos.resultado.getString("FKSOLICITUDOFERTA"));
                formadepagosolicitudesofertaPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                formadepagosolicitudesoferta.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formadepagosolicitudesoferta.setFormadepagosolicitudesofertaPK(formadepagosolicitudesofertaPK);
                listFormadepagosolicitudesoferta.add(formadepagosolicitudesoferta);
            }
            return listFormadepagosolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Formadepagosolicitudesoferta> findAllInFormadepagosolicitudesofertaByFksolicitudoferta(String fksolicitudoferta) {
        List<Formadepagosolicitudesoferta> listFormadepagosolicitudesoferta = new ArrayList<Formadepagosolicitudesoferta>();
        Formadepagosolicitudesoferta formadepagosolicitudesoferta = new Formadepagosolicitudesoferta();
        FormadepagosolicitudesofertaPK formadepagosolicitudesofertaPK = new FormadepagosolicitudesofertaPK();
        try {
            datos.query("SELECT * FROM FORMADEPAGOSOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKSOLICITUDOFERTA = '" + fksolicitudoferta + "' ORDER BY FECHA");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                formadepagosolicitudesoferta = new Formadepagosolicitudesoferta();
                formadepagosolicitudesofertaPK = new FormadepagosolicitudesofertaPK();
                formadepagosolicitudesofertaPK.setFksolicitudoferta(ClaseBaseDatos.resultado.getString("FKSOLICITUDOFERTA"));
                formadepagosolicitudesofertaPK.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                formadepagosolicitudesoferta.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                formadepagosolicitudesoferta.setFormadepagosolicitudesofertaPK(formadepagosolicitudesofertaPK);
                listFormadepagosolicitudesoferta.add(formadepagosolicitudesoferta);
            }
            return listFormadepagosolicitudesoferta;
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
