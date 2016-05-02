/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import modele.dao.connectDAO;
import modele.dao.visiteursDAO;
import modele.metier.Visiteur;
import vue.vueGSB_Connexion;
import vue.vueGSB_MenuPrincipal;

/**
 *
 * @author Admin
 */
public class CtrlConnexion implements ActionListener {

    private vueGSB_Connexion vue;
    
    public CtrlConnexion(vueGSB_Connexion vue) {
        this.vue = vue;
        vue.getjButtonOk().addActionListener(this);
        vue.getjButtonQuit().addActionListener(this);
        vue.getjTextFieldLogin().addActionListener(this);
        vue.getjTextFieldPwd().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vue.getjButtonOk() || source == vue.getjTextFieldLogin() || source == vue.getjTextFieldPwd()) {
            String login1 = vue.getjTextFieldLogin().getText();
            String mdp1 = vue.getjTextFieldPwd().getText();
            try {
                Connection cnx = connectDAO.connectOdb();
                Visiteur unVisiteur = visiteursDAO.getOneById(cnx, login1);
                String id = unVisiteur.getMatricule();
                String nom = unVisiteur.getNom();
                String prenom = unVisiteur.getPrenom();
                prenom = prenom.toLowerCase();
                nom = nom.toLowerCase();
                prenom = prenom.substring(0, 1);
                String login2 = id;
                String mdp2 = prenom + nom;
                if (login1.equals(login2) && mdp1.equals(mdp2)) {
                    vueGSB_MenuPrincipal mf = new vueGSB_MenuPrincipal();
                    CtrlMenu controleur = new CtrlMenu(mf);
                    mf.setVisible(true);
                    vue.setVisible(false);
                } else {
                    JLabel jLabel2 = null;
                    jLabel2.setText("Erreur de connexion !");
                    vue.setjLabel2(jLabel2);
                }
            } catch (IOException ex) {
                Logger.getLogger(vueGSB_Connexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(vueGSB_Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == vue.getjButtonQuit()) {
            exit(0);
        }
    }

}
