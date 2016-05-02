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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.*;

/**
 *
 * @author Admin
 */
public class visiteursDAO {
    
    
    public static Visiteur getOneById(Connection cnx, String id) throws IOException, SQLException{
        ResultSet result = null;
        Visiteur unVisiteur = null;
        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE='"+id+"'";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result.next()) {
            unVisiteur = visiteurFromResultSet(result);
        }
        return unVisiteur;
        
    }
    
    public static Visiteur visiteurFromResultSet(ResultSet rs) throws SQLException {
        Visiteur unVisiteur = null;
        String matricule = rs.getString("VIS_MATRICULE");
        String nom = rs.getString("VIS_NOM");
        String prenom = rs.getString("VIS_PRENOM");
        String adresse = rs.getString("VIS_ADRESSE");
        String cp = rs.getString("VIS_CP");
        String ville = rs.getString("VIS_VILLE");
        java.sql.Date embauche = rs.getDate("VIS_DATEEMBAUCHE");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateEmbauche = dateFormat.format(embauche); 
        String codeSecteur = rs.getString("SEC_CODE");
        String codeLabo = rs.getString("LAB_CODE");
        unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSecteur, codeLabo);
        return unVisiteur;
    }
    
    public static ArrayList<Visiteur> getAll (Connection cnx) throws SQLException{
        ResultSet result = null;
        String requete = "SELECT * FROM VISITEUR";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(visiteursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        while (result.next()){
            Visiteur unVisiteur = visiteurFromResultSet(result);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
}
