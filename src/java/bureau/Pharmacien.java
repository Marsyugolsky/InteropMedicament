/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

/**
 *
 * @author aboura
 */
public class Pharmacien {

    int id_boss;
    String nom;
    String prenom;

    public Pharmacien( String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId_boss() {
        return id_boss;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId_boss(int id_boss) {
        this.id_boss = id_boss;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
