/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgros
 */

@Entity
@XmlRootElement
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_four;

    @Column
    String nom;
    List<Propose> proposition;

    public Fournisseur( String nom) {
        this.nom = nom;
        proposition = new ArrayList<Propose>();
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

    public List<Propose> getProposition() {
        return proposition;
    }

    public void ajouterMedicament(Medicament med, int quantite) {
        boolean existe = false;
        for (Propose pro : proposition) {
            if (pro.getMed().equals(med)) {
                //Le médicament est déjà créé, on ajoute alors la quantité
                pro.setQuantite(pro.getQuantite() + quantite);
                existe = true;
            }
        }
        //Création de la proposition d'un médicament dans leur liste
        if (!existe) {
            Propose newpro = new Propose(med, quantite);
            proposition.add(newpro);
        }
    }
}


