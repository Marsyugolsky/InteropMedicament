/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.HashMap;

/**
 *
 * @author mgros
 */
public class Fournisseur {

    int id_four;
    String nom;
    HashMap<Medicament, Integer> propose;

    public Fournisseur(int id_four, String nom) {
        this.id_four = id_four;
        this.nom = nom;
        propose = new HashMap<Medicament, Integer>();
    }

    public void setId_four(int id_four) {
        this.id_four = id_four;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_four() {
        return id_four;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterMedicament(Medicament med, int quantite) {
        if (propose.containsKey(med)) {
            //Le médicament est déjà créé, on ajoute alors la quantité
            int res = propose.get(med).intValue() + quantite;
            propose.replace(med, propose.get(med).intValue(), res);
        } else {
            //Création de la proposition d'un médicament dans leur liste
            propose.put(med, quantite);
        }
    }
}
