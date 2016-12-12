/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mgros
 */
@Entity
@XmlRootElement
public class Preparateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_prepa;

    @Column

    String nom;
        @Column
String prenom;

    public Preparateur(String nom, String prenom) {
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

    public void creerPrescription(Admission patient) {
        Prescription pres = new Prescription("12/12/2016", Avancement.prepare,patient);

    }

    public void ajouterLigne(Medicament med, int quantite, Administration admin, Pharmacie pharmacie,Prescription pres) throws Exception {
        for (Stock pharmastock : pharmacie.stock) {
            if (pharmastock.getMed().equals(med)) {
                //Vérification des stocks
                if (pharmastock.getQuantite() - quantite >= 0) {
                    pharmastock.setQuantite(pharmastock.getQuantite() - quantite);
                } else {
                    throw new Exception("il n'y a plus de médicament en stock");
                }
            }
        }
        Compose comp = new Compose(med, quantite, admin, this, pharmacie);
        pres.ajouterMedicamentPrescription(comp);
    }

}
