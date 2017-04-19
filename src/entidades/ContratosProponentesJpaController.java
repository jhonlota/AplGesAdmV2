/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andres
 */
public class ContratosProponentesJpaController {
    
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ContratosProponentesJpaController() {
    }
    
    public void create(ContratosProponentes contratosProponentes) {
        
        try {
            datos.update("INSERT INTO "+ contratosProponentes.tabla +"VALUES ("
                    + "'"+contratosProponentes.getContratosProponentesPK().getFkcontrato() + "', "
                    + "'" + contratosProponentes.getContratosProponentesPK().getFktercero() + "', "
                    + "" + contratosProponentes.getNumerofolios()+ ", "
                    + "" + contratosProponentes.getValorsiniva()+ ", "
                    + contratosProponentes.getValortotal()+ ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Contratos Proponentes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(ContratosProponentes contratosProponentes, ContratosProponentes id) {
        
        try {
            datos.update("UPDATE CONTRATOSPROPONENTES SET "
                    + "FKTERCERO = '" + contratosProponentes.getContratosProponentesPK().getFktercero() + "', "
                    + "NUMEROFOLIOS = " + contratosProponentes.getNumerofolios() + ", "
                    + "VALORSINIVA = " + contratosProponentes.getValorsiniva() + ", "
                    + "VALORTOTAL = " + contratosProponentes.getValortotal() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getContratosProponentesPK().getFkcontrato() + "' AND "
                    + "FKTERCERO = '" + id.getContratosProponentesPK().getFktercero() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Contratos Proponentes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ContratosProponentesPK id) {
        try {
            datos.update("DELETE FROM CONTRATOSPROPONENTES "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "' AND "
                    + "FKTERCERO = '" + id.getFktercero()+ "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Contratos Proponentes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(ContratosProponentes contratosProponentes) {   
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(contratosProponentes.getContratosProponentesPK().getFkcontrato(), "FKCONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratosProponentes.getContratosProponentesPK().getFktercero(), "FKTERCERO")){
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }
    
    public List<ContratosProponentes> findAllInContratosProponentesByFkcontrato(String fkcontrato) {
        List<ContratosProponentes> listContratosProponentes = new ArrayList<ContratosProponentes>();
        ContratosProponentes contratosProponentes;
        ContratosProponentesPK contratosProponentesPK;

        try {
            datos.query("SELECT * FROM CONTRATOSPROPONENTES WHERE FKCONTRATO = '" + fkcontrato + "'");
            while (ClaseBaseDatos.resultado.next()) {
                contratosProponentes = new ContratosProponentes();
                contratosProponentesPK = new ContratosProponentesPK();
                contratosProponentesPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                contratosProponentesPK.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                contratosProponentes.setContratosProponentesPK(contratosProponentesPK);
                contratosProponentes.setNumerofolios(ClaseBaseDatos.resultado.getInt("NUMEROFOLIOS"));
                contratosProponentes.setValorsiniva(ClaseBaseDatos.resultado.getInt("VALORSINIVA"));
                contratosProponentes.setValortotal(ClaseBaseDatos.resultado.getInt("VALORTOTAL"));

                listContratosProponentes.add(contratosProponentes);
            }
            return listContratosProponentes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
