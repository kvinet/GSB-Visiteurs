/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Secteur;

/**
 *
 * @author Admin
 */
public class secteurDAO {
    public static Secteur getOneById(Connection cnx, String id) throws IOException, SQLException{
        ResultSet result = null;
        Secteur unSecteur = null;
        String requete = "SELECT * FROM SECTEUR WHERE SEC_CODE='"+id+"'";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result.next()) {
            unSecteur = secteurFromResultSet(result);
        }
        
        return unSecteur;
    }
    
    public static Secteur secteurFromResultSet (ResultSet rs) throws SQLException {
        Secteur unSecteur = null;
        String codeSecteur = rs.getString("SEC_CODE");
        String libelleSecteur = rs.getString("SEC_LIBELLE");
        unSecteur = new Secteur(codeSecteur, libelleSecteur);
        return unSecteur;
    }
    
    public static ArrayList<Secteur> getAll (Connection cnx) throws SQLException{
        ResultSet result = null;
        String requete = "SELECT * FROM SECTEUR";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(visiteursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Secteur> lesSecteurs = new ArrayList<Secteur>();
        while (result.next()){
            Secteur unSecteur = secteurFromResultSet(result);
            lesSecteurs.add(unSecteur);
        }
        return lesSecteurs;
    }
    
}
