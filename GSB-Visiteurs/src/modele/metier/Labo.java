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
public class Labo {

    @Override
    public String toString() {
        return "Labo{" + "codeLabo=" + codeLabo + ", nomLabo=" + nomLabo + ", chefLabo=" + chefLabo + '}';
    }

    public String getCodeLabo() {
        return codeLabo;
    }

    public void setCodeLabo(String codeLabo) {
        this.codeLabo = codeLabo;
    }

    public String getNomLabo() {
        return nomLabo;
    }

    public void setNomLabo(String nomLabo) {
        this.nomLabo = nomLabo;
    }

    public String getChefLabo() {
        return chefLabo;
    }

    public void setChefLabo(String chefLabo) {
        this.chefLabo = chefLabo;
    }

    public Labo(String codeLabo, String nomLabo, String chefLabo) {
        this.codeLabo = codeLabo;
        this.nomLabo = nomLabo;
        this.chefLabo = chefLabo;
    }
    String codeLabo;
    String nomLabo;
    String chefLabo;
    
    
    
}
