/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

/**
 *
 * @author mgros
 */
public class Fournis {
    Medicament med;
    int quantite;

    public Fournis(Medicament med, int quantite) {
        this.med = med;
        this.quantite = quantite;
    }

    public Medicament getMed() {
        return med;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setMed(Medicament med) {
        this.med = med;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
}
