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
public class ContratosproponentesJpaController {
    
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ContratosproponentesJpaController() {
    }
    
    public void create(Contratosproponentes contratosproponentes) {
        
        try {
            datos.update("INSERT INTO "+ contratosproponentes.tabla +"VALUES ("
                    + "'"+contratosproponentes.getContratosproponentesPK().getFkcontrato() + "', "
                    + "'" + contratosproponentes.getContratosproponentesPK().getFktercero() + "', "
                    + "" + contratosproponentes.getNumerofolios()+ ", "
                    + "" + contratosproponentes.getValorsiniva()+ ", "
                    + contratosproponentes.getValortotal()+ ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Contratos Proponentes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Contratosproponentes contratosproponentes, Contratosproponentes id) {
        
        try {
            datos.update("UPDATE CONTRATOSPROPONENTES SET "
                    + "FKTERCERO = '" + contratosproponentes.getContratosproponentesPK().getFktercero() + "', "
                    + "NUMEROFOLIOS = " + contratosproponentes.getNumerofolios() + ", "
                    + "VALORSINIVA = " + contratosproponentes.getValorsiniva() + ", "
                    + "VALORTOTAL = " + contratosproponentes.getValortotal() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getContratosproponentesPK().getFkcontrato() + "' AND "
                    + "FKTERCERO = '" + id.getContratosproponentesPK().getFktercero() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Contratos Proponentes");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(ContratosproponentesPK id) {
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

    public boolean verify(Contratosproponentes contratosproponentes) {   
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(contratosproponentes.getContratosproponentesPK().getFkcontrato(), "FKCONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratosproponentes.getContratosproponentesPK().getFktercero(), "FKTERCERO")){
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }
    
    public List<Contratosproponentes> findAllInContratosproponentesByFkcontrato(String fkcontrato) {
        List<Contratosproponentes> listContratosproponentes = new ArrayList<Contratosproponentes>();
        Contratosproponentes contratosproponentes;
        ContratosproponentesPK contratosproponentesPK;

        try {
            datos.query("SELECT * FROM CONTRATOSPROPONENTES WHERE FKCONTRATO = '" + fkcontrato + "'");
            while (ClaseBaseDatos.resultado.next()) {
                contratosproponentes = new Contratosproponentes();
                contratosproponentesPK = new ContratosproponentesPK();
                contratosproponentesPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                contratosproponentesPK.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                contratosproponentes.setContratosproponentesPK(contratosproponentesPK);
                contratosproponentes.setNumerofolios(ClaseBaseDatos.resultado.getBigDecimal("NUMEROFOLIOS"));
                contratosproponentes.setValorsiniva(ClaseBaseDatos.resultado.getBigDecimal("VALORSINIVA"));
                contratosproponentes.setValortotal(ClaseBaseDatos.resultado.getBigDecimal("VALORTOTAL"));

                listContratosproponentes.add(contratosproponentes);
            }
            return listContratosproponentes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
