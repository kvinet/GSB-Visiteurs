/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.*;
import modele.metier.*;


/**
 *
 * @author Admin
 */
public class testJavaAppGsb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Test de la connexion");
            Connection cnx = connectDAO.connectOdb();
            System.out.println("Test des classes Visiteur et visiteurDAO");
            System.out.println("Sélection d'un secteur en fonction de son matricule : a131");
            Visiteur unVisiteur = visiteursDAO.getOneById(cnx, "a131");
            System.out.println(unVisiteur);
            System.out.println("Sélection de tous les visiteurs");
            ArrayList<Visiteur> desVisiteurs = new ArrayList<Visiteur>();
            desVisiteurs = visiteursDAO.getAll(cnx);
            for (int i=0; i<desVisiteurs.size(); i++){
                Visiteur unAutreVisiteur = desVisiteurs.get(i);
                System.out.println(unAutreVisiteur);
            }
            System.out.println("Test des classes Labo et laboDAO");
            System.out.println("Sélection d'un labo en fonction de son code : BC");
            Labo unLabo = laboDAO.getOneById(cnx, "BC");
            System.out.println(unLabo);
            System.out.println("Sélection de tous les labos");
            ArrayList<Labo> desLabos = new ArrayList<Labo>();
            desLabos = laboDAO.getAll(cnx);
            for (int i = 0; i < desLabos.size(); i++) {
                Labo unAutreLabo = desLabos.get(i);
                System.out.println(unAutreLabo);
            }
            System.out.println("Test des classes Labo et laboDAO");
            System.out.println("Sélection d'un secteur en fonction de son code : P");
            Secteur unSecteur = secteurDAO.getOneById(cnx, "P");
            System.out.println(unSecteur);
            System.out.println("Sélection de tous les secteurs");
            ArrayList<Secteur> desSecteurs = new ArrayList<Secteur>();
            desSecteurs = secteurDAO.getAll(cnx);
            for (int i = 0; i < desSecteurs.size(); i++) {
                Secteur unAutreSecteur = desSecteurs.get(i);
                System.out.println(unAutreSecteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(testJavaAppGsb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
