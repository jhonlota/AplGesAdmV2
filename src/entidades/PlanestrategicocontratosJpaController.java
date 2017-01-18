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

public class PlanestrategicocontratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public PlanestrategicocontratosJpaController() {
    }

    public void create(Planestrategicocontratos planestrategicocontratos) {
        try {
            datos.update("INSERT INTO " + planestrategicocontratos.tabla + " VALUES ("
                    + "'" + planestrategicocontratos.getFkcontrato() + "', "
//                    + planestrategicocontratos.getId() + ", "
                    + "'" + planestrategicocontratos.getEje() + "', "
                    + "'" + planestrategicocontratos.getEstrategia() + "', "
                    + "'" + planestrategicocontratos.getPrograma() + "', "
                    + "'" + planestrategicocontratos.getProyecto() + "', "
                    + "'" + planestrategicocontratos.getSubgrupo() + "', "
                    + "'" + planestrategicocontratos.getCinfo() + "')");
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
            datos.update("UPDATE PLANESTRATEGICOCONTRATOS SET "
                    //+ "FKCONTRATO = '" + planestrategicocontratos.getFkcontrato() + "', "
                    //+ ID = '" + planestrategicocontratos.getId() + "', "
                    + "EJE = '" + planestrategicocontratos.getEje() + "', "
                    + "ESTRATEGIA = '" + planestrategicocontratos.getEstrategia() + "', "
                    + "PROGRAMA = '" + planestrategicocontratos.getPrograma() + "', "
                    + "PROYECTO = '" + planestrategicocontratos.getProyecto() + "', "
                    + "SUBGRUPO = '" + planestrategicocontratos.getSubgrupo() + "', "
                    + "CINFO = '" + planestrategicocontratos.getCinfo() + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "' AND "
                    + "ID = " + id.getId() + "");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Plan Estrategico");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE PLANESTRATEGICOCONTRATOS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Planestrategicocontratos id) {
        try {
            datos.update("DELETE FROM PLANESTRATEGICOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "' AND "
                    + "ID = " + id.getId() + "");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Plan Estrategico");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM PLANESTRATEGICOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
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
            datos.query("SELECT * FROM PLANESTRATEGICOCONTRATOS "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%'");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                planestrategicocontratos = new Planestrategicocontratos();
                planestrategicocontratos.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                planestrategicocontratos.setId(ClaseBaseDatos.resultado.getInt("ID"));
                planestrategicocontratos.setEje(ClaseBaseDatos.resultado.getString("EJE"));
                planestrategicocontratos.setEstrategia(ClaseBaseDatos.resultado.getString("ESTRATEGIA"));
                planestrategicocontratos.setPrograma(ClaseBaseDatos.resultado.getString("PROGRAMA"));
                planestrategicocontratos.setProyecto(ClaseBaseDatos.resultado.getString("PROYECTO"));
                planestrategicocontratos.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                planestrategicocontratos.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));                
                listPlanestrategicocontratos.add(planestrategicocontratos);
            }
            return listPlanestrategicocontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Planestrategicocontratos> findAllInPlanestrategicocontratosByFkcontrato(String fkcontrato) {
        List<Planestrategicocontratos> listPlanestrategicocontratos = new ArrayList<Planestrategicocontratos>();
        Planestrategicocontratos planestrategicocontratos = new Planestrategicocontratos();
        try {
            datos.query("SELECT * FROM PLANESTRATEGICOCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + fkcontrato + "' ORDER BY ID");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                planestrategicocontratos = new Planestrategicocontratos();
                planestrategicocontratos.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                planestrategicocontratos.setId(ClaseBaseDatos.resultado.getInt("ID"));
                planestrategicocontratos.setEje(ClaseBaseDatos.resultado.getString("EJE"));
                planestrategicocontratos.setEstrategia(ClaseBaseDatos.resultado.getString("ESTRATEGIA"));
                planestrategicocontratos.setPrograma(ClaseBaseDatos.resultado.getString("PROGRAMA"));
                planestrategicocontratos.setProyecto(ClaseBaseDatos.resultado.getString("PROYECTO"));
                planestrategicocontratos.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                planestrategicocontratos.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));    
                listPlanestrategicocontratos.add(planestrategicocontratos);
            }
            return listPlanestrategicocontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
