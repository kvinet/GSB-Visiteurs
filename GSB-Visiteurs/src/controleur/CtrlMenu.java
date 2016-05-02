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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.vueGSB_MenuPrincipal;
import vue.vueGSB_Visiteurs;

/**
 *
 * @author Admin
 */
public class CtrlMenu implements ActionListener {

    private vueGSB_MenuPrincipal vue;

    CtrlMenu(vueGSB_MenuPrincipal vue) {
        this.vue = vue;
        vue.getjMenuVisiteurs().addActionListener(this);
        vue.getjButtonQuit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vue.getjMenuVisiteurs()) {
            vueGSB_Visiteurs mf;
            try {
                mf = new vueGSB_Visiteurs();
                CtrlVisiteurs controleur = new CtrlVisiteurs(mf);
                mf.setVisible(true);
                vue.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == vue.getjButtonQuit()) {
            exit(0);
        }
    }
    
}
