/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author Admin
 */
public class Secteur {

    @Override
    public String toString() {
        return "Secteur{" + "codeSecteur=" + codeSecteur + ", libelleSecteur=" + libelleSecteur + '}';
    }

    public String getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(String codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    public String getLibelleSecteur() {
        return libelleSecteur;
    }

    public void setLibelleSecteur(String libelleSecteur) {
        this.libelleSecteur = libelleSecteur;
    }

    public Secteur(String codeSecteur, String libelleSecteur) {
        this.codeSecteur = codeSecteur;
        this.libelleSecteur = libelleSecteur;
    }
    String codeSecteur;
    String libelleSecteur;
}
