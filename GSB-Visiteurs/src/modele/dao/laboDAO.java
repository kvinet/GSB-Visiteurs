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
import modele.metier.Labo;

/**
 *
 * @author Admin
 */
public class laboDAO {
    public static Labo getOneById(Connection cnx, String id) throws IOException, SQLException{
        ResultSet result = null;
        Labo unLabo = null;
        String requete = "SELECT * FROM LABO WHERE LAB_CODE='"+id+"'";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(connectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result.next()) {
            unLabo = laboFromResultSet(result);
        }
        
        return unLabo;
    }
    
    public static Labo laboFromResultSet (ResultSet rs) throws SQLException {
        Labo unLabo = null;
        String codeLabo = rs.getString("LAB_CODE");
        String nomLabo = rs.getString("LAB_NOM");
        String chefLabo = rs.getString("LAB_CHEFVENTE");
        unLabo = new Labo(codeLabo, nomLabo, chefLabo);
        return unLabo;
    }
    
    public static ArrayList<Labo> getAll (Connection cnx) throws SQLException{
        ResultSet result = null;
        String requete = "SELECT * FROM LABO";
        try {
            Statement stmt = cnx.createStatement();
            result = stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(visiteursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Labo> lesLabos = new ArrayList<Labo>();
        while (result.next()){
            Labo unLabo = laboFromResultSet(result);
            lesLabos.add(unLabo);
        }
        return lesLabos;
    }
}
