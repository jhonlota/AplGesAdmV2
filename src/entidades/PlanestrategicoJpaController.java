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

public class PlanestrategicoJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public PlanestrategicoJpaController() {
    }

    public void create(Planestrategicocontratos planestrategicocontratos) {
        try {
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Plan Estrategico");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Planestrategicocontratos planestrategicocontratos, Planestrategicocontratos id) {
        try {
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Plan Estrategico");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Planestrategicocontratos id) {
        try {
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Plan Estrategico");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Planestrategicocontratos> findAllInPlanestrategicocontratosBy() {
        List<Planestrategicocontratos> listPlanestrategicocontratos = new ArrayList<Planestrategicocontratos>();
        Planestrategicocontratos planestrategicocontratos = new Planestrategicocontratos();     
        try {
            return listPlanestrategicocontratos;
        } catch (Exception ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public DefaultComboBoxModel COMBOEjeInPlanestrategicoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(EJE) FROM PLANESTRATEGICO ORDER BY EJE");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("EJE"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
    
    public DefaultComboBoxModel COMBOEstrategiaInPlanestrategicoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(ESTRATEGIA) FROM PLANESTRATEGICO ORDER BY ESTRATEGIA");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("ESTRATEGIA"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
    
    public DefaultComboBoxModel COMBOProgramaInPlanestrategicoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(PROGRAMA) FROM PLANESTRATEGICO ORDER BY PROGRAMA");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("PROGRAMA"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
    
    public DefaultComboBoxModel COMBOProyectoInPlanestrategicoBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();

        try {
            datos.query("SELECT DISTINCT(PROGRAMA) FROM PLANESTRATEGICO ORDER BY PROGRAMA");
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("PROGRAMA"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
