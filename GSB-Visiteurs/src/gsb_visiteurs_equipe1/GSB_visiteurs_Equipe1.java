/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb_visiteurs_equipe1;

import controleur.CtrlConnexion;
import vue.vueGSB_Connexion;

/**
 *
 * @author Admin
 */
public class GSB_visiteurs_Equipe1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vueGSB_Connexion mf = new vueGSB_Connexion();
        CtrlConnexion controleur = new CtrlConnexion(mf);
                mf.setVisible(true);
    }
    
}
