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
public class Preparateur {
    int id_prepa;
    String nom;
    String prenom;

    public Preparateur( String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId_prepa() {
        return id_prepa;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId_prepa(int id_prepa) {
        this.id_prepa = id_prepa;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
