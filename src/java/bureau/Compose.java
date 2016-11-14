/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;


public class Compose {

    Medicament med;
    int quantite;
    Administration administration;
    Preparateur preparateur;
    Pharmacie pharmacie;

    public Compose(Medicament med, int quantite, Administration administration, Preparateur preparateur, Pharmacie pharmacie) {
        
            this.med = med;
            this.administration = administration;
            this.preparateur = preparateur;
            this.quantite=quantite;
            this.pharmacie=pharmacie;

        
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPreparateur(Preparateur preparateur) {
        this.preparateur = preparateur;
    }

    public Preparateur getPreparateur() {
        return preparateur;

    }

    public Medicament getMed() {
        return med;
    }

    public int getQuantite() {
        return quantite;
    }

    public Administration getAdministration() {
        return administration;
    }

    public void setMed(Medicament med) {
        this.med = med;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

}
