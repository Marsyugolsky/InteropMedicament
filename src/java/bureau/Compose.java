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

    public Compose(Medicament med, int quantite, Administration administration, Preparateur preparateur, Pharmacie pharmacie) throws Exception {
        try {
            this.med = med;
            for (Stock pharmastock : pharmacie.stock) {
                if (pharmastock.getMed().equals(med)) {
                    //Vérification des stocks
                    if (pharmastock.getQuantite() - quantite >= 0) {
                        pharmastock.setQuantite(pharmastock.getQuantite()-quantite);
                        this.quantite = quantite; 
                    } else {
                        throw new Exception("il n'y a plus de médicament en stock");
                    }
                }
            }
            this.administration = administration;
            this.preparateur = preparateur;

        } catch (Exception e) {
            System.out.println("quantité de médicament dans la pharmacie insufisant");
        }
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
