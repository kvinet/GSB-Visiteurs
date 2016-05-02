/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modele.dao.connectDAO;
import modele.dao.laboDAO;
import modele.dao.secteurDAO;
import modele.dao.visiteursDAO;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;
import vue.vueGSB_MenuPrincipal;
import vue.vueGSB_Visiteurs;

/**
 *
 * @author Admin
 */
public class CtrlVisiteurs implements ActionListener {

    private vueGSB_Visiteurs vue;

    CtrlVisiteurs(vueGSB_Visiteurs vue) throws IOException, SQLException {
        this.vue = vue;
        vue.getjButtonNext().addActionListener(this);
        vue.getjButtonOkListe().addActionListener(this);
        vue.getjButtonPrev().addActionListener(this);
        vue.getjButtonQuit().addActionListener(this);
        vue.getjMenuItemRapportVisite().addActionListener(this);
        Connection cnx = connectDAO.connectOdb();
        ArrayList<Visiteur> desVisiteurs = new ArrayList<Visiteur>();
        desVisiteurs = visiteursDAO.getAll(cnx);
        Visiteur unVisiteur;
        unVisiteur = desVisiteurs.get(0);
        vue.getjTextFieldNom().setText(unVisiteur.getNom());
        vue.getjTextFieldPrenom().setText(unVisiteur.getPrenom());
        int i = 0;
        DefaultComboBoxModel dcbmVisit = new DefaultComboBoxModel();
        while (i < desVisiteurs.size()) {
            Visiteur nomVisiteur;
            nomVisiteur = desVisiteurs.get(i);
            String nom = nomVisiteur.getNom() + " " + nomVisiteur.getPrenom();
            dcbmVisit.addElement(nom);
            i++;
        }
        vue.getjComboBoxListeVisiteur().setModel(dcbmVisit);
        vue.getjTextFieldAdresse().setText(unVisiteur.getAdresse());
        vue.getjTextFieldCp().setText(unVisiteur.getCp());
        vue.getjTextFieldVille().setText(unVisiteur.getVille());
        String codeSec = unVisiteur.getCodeSecteur();
        if (codeSec != null) {
            String secteur;
            Secteur unSecteur;
            unSecteur = secteurDAO.getOneById(cnx, codeSec);
            secteur = unSecteur.getLibelleSecteur();
            vue.getjTextFieldSecteur().setText(secteur);
        } else {
            String secteur = "NA";
            vue.getjTextFieldSecteur().setText(secteur);
        }
        String codeLab = unVisiteur.getCodeLabo();
        if (codeLab != null) {
            String labo;
            Labo unLabo;
            unLabo = laboDAO.getOneById(cnx, codeLab);
            labo = unLabo.getNomLabo();
            vue.getjTextFieldLabo().setText(labo);
        } else {
            String labo = "NA";
            vue.getjTextFieldLabo().setText(labo);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vue.getjButtonNext()) {
            try {
                JComboBox jcbLVisit = vue.getjComboBoxListeVisiteur();
                int i = jcbLVisit.getSelectedIndex();
                Connection cnx = connectDAO.connectOdb();
                ArrayList<Visiteur> desVisiteurs = new ArrayList<Visiteur>();
                desVisiteurs = visiteursDAO.getAll(cnx);
                i = i + 1;
                Visiteur unVisiteur;
                if (i >= desVisiteurs.size()) {
                    i = 0;
                }
                unVisiteur = desVisiteurs.get(i);
                jcbLVisit.setSelectedIndex(i);
                vue.getjLabelNumVisiteur().setText(String.valueOf(i+1));
                vue.getjTextFieldNom().setText(unVisiteur.getNom());
                vue.getjTextFieldPrenom().setText(unVisiteur.getPrenom());
                vue.getjTextFieldAdresse().setText(unVisiteur.getAdresse());
                vue.getjTextFieldCp().setText(unVisiteur.getCp());
                vue.getjTextFieldVille().setText(unVisiteur.getVille());
                String codeSec = unVisiteur.getCodeSecteur();
                if (codeSec != null) {
                    String secteur;
                    Secteur unSecteur;
                    unSecteur = secteurDAO.getOneById(cnx, codeSec);
                    secteur = unSecteur.getLibelleSecteur();
                    vue.getjTextFieldSecteur().setText(secteur);
                } else {
                    String secteur = "NA";
                    vue.getjTextFieldSecteur().setText(secteur);
                }
                String codeLab = unVisiteur.getCodeLabo();
                if (codeLab != null) {
                    String labo;
                    Labo unLabo;
                    unLabo = laboDAO.getOneById(cnx, codeLab);
                    labo = unLabo.getNomLabo();
                    vue.getjTextFieldLabo().setText(labo);
                } else {
                    String labo = "NA";
                    vue.getjTextFieldLabo().setText(labo);
                }
            } catch (IOException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == vue.getjButtonPrev()) {
            try {
                JComboBox jcbLVisit = vue.getjComboBoxListeVisiteur();
                int i = jcbLVisit.getSelectedIndex();
                Connection cnx = connectDAO.connectOdb();
                ArrayList<Visiteur> desVisiteurs = new ArrayList<Visiteur>();
                desVisiteurs = visiteursDAO.getAll(cnx);
                i = i - 1;
                Visiteur unVisiteur;
                if (i < 0) {
                    i = 67;
                }
                unVisiteur = desVisiteurs.get(i);
                jcbLVisit.setSelectedIndex(i);
                vue.getjLabelNumVisiteur().setText(String.valueOf(i+1));
                vue.getjTextFieldNom().setText(unVisiteur.getNom());
                vue.getjTextFieldPrenom().setText(unVisiteur.getPrenom());
                vue.getjTextFieldAdresse().setText(unVisiteur.getAdresse());
                vue.getjTextFieldCp().setText(unVisiteur.getCp());
                vue.getjTextFieldVille().setText(unVisiteur.getVille());
                String codeSec = unVisiteur.getCodeSecteur();
                if (codeSec != null) {
                    String secteur;
                    Secteur unSecteur;
                    unSecteur = secteurDAO.getOneById(cnx, codeSec);
                    secteur = unSecteur.getLibelleSecteur();
                    vue.getjTextFieldSecteur().setText(secteur);
                } else {
                    String secteur = "NA";
                    vue.getjTextFieldSecteur().setText(secteur);
                }
                String codeLab = unVisiteur.getCodeLabo();
                if (codeLab != null) {
                    String labo;
                    Labo unLabo;
                    unLabo = laboDAO.getOneById(cnx, codeLab);
                    labo = unLabo.getNomLabo();
                    vue.getjTextFieldLabo().setText(labo);
                } else {
                    String labo = "NA";
                    vue.getjTextFieldLabo().setText(labo);
                }
            } catch (IOException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == vue.getjButtonOkListe()) {
            try {
                JComboBox jcbLVisit = vue.getjComboBoxListeVisiteur();
                int i = jcbLVisit.getSelectedIndex();
                Connection cnx = connectDAO.connectOdb();
                ArrayList<Visiteur> desVisiteurs = new ArrayList<Visiteur>();
                desVisiteurs = visiteursDAO.getAll(cnx);
                Visiteur unVisiteur;
                unVisiteur = desVisiteurs.get(i);
                jcbLVisit.setSelectedIndex(i);
                vue.getjLabelNumVisiteur().setText(String.valueOf(i+1));
                vue.getjTextFieldNom().setText(unVisiteur.getNom());
                vue.getjTextFieldPrenom().setText(unVisiteur.getPrenom());
                vue.getjTextFieldAdresse().setText(unVisiteur.getAdresse());
                vue.getjTextFieldCp().setText(unVisiteur.getCp());
                vue.getjTextFieldVille().setText(unVisiteur.getVille());
                String codeSec = unVisiteur.getCodeSecteur();
                if (codeSec != null) {
                    String secteur;
                    Secteur unSecteur;
                    unSecteur = secteurDAO.getOneById(cnx, codeSec);
                    secteur = unSecteur.getLibelleSecteur();
                    vue.getjTextFieldSecteur().setText(secteur);
                } else {
                    String secteur = "NA";
                    vue.getjTextFieldSecteur().setText(secteur);
                }
                String codeLab = unVisiteur.getCodeLabo();
                if (codeLab != null) {
                    String labo;
                    Labo unLabo;
                    unLabo = laboDAO.getOneById(cnx, codeLab);
                    labo = unLabo.getNomLabo();
                    vue.getjTextFieldLabo().setText(labo);
                } else {
                    String labo = "NA";
                    vue.getjTextFieldLabo().setText(labo);
                }
            } catch (IOException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == vue.getjButtonQuit()) {
            vueGSB_MenuPrincipal mf = new vueGSB_MenuPrincipal();
            CtrlMenu controleur = new CtrlMenu(mf);
            mf.setVisible(true);
            vue.setVisible(false);
        }

    }

}
