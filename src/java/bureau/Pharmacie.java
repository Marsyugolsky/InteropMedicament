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
public class Pharmacie {

    int id_pharma;
    String nom;
    HashMap<Medicament, Integer> stock;

    public Pharmacie(int id_pharma, String nom) {
        this.id_pharma = id_pharma;
        this.nom = nom;
        HashMap<Medicament, Integer> stock;

    }

    public int getId_pharma() {
        return id_pharma;
    }

    public String getNom() {
        return nom;
    }

    public void setId_pharma(int id_pharma) {
        this.id_pharma = id_pharma;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void acheterMedicament(Medicament med, int quantite, Fournisseur four) throws Exception {
        int fournis = four.propose.get(med).intValue() - quantite;
        //Un fournisseur ne peut pas avoir un stock négatif
        if (fournis < 0) {
            System.out.println("Le fournisseur ne peut pas avoir de stock négatif");
        } else {
            four.propose.replace(med, four.propose.get(med).intValue(), fournis);
        }
        if (stock.containsKey(med)) {
            //Le médicament est déjà créé, on ajoute alors la quantité
            int res = stock.get(med).intValue() + quantite;
            stock.replace(med, stock.get(med).intValue(), res);

        } else {
            //Création de la proposition d'un médicament dans leur liste
            stock.put(med, quantite);
        }
    }
}
