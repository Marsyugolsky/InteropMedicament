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
        HashMap <Medicament , Integer > stock;

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
    
    
}
