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
public class Fournisseur {

    int id_four;
    String nom;

    public Fournisseur(int id_four, String nom) {
        this.id_four = id_four;
        this.nom = nom;
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

}
