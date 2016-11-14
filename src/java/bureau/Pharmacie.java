/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class Pharmacie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_pharma;

    @Column

    String nom;
    List<Stock> stock;

    public Pharmacie(String nom) {
        this.nom = nom;
        stock = new ArrayList<Stock>();
    }

    public List<Stock> getStock() {
        return stock;
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
        //récupération de la liste du fournisseur
        boolean existe = false;
        //On regarde si le fournisseur à le médicament
        for (Propose pro : four.proposition) {
            if (pro.getMed().equals(med)) {
                //On regarde si le fournisseur peut fournir la quantité demandée
                if (pro.getQuantite() - quantite < 0) {
                    throw new Exception("il n'y a plus de médicament en stock");
                }
                for (Stock stockMed : stock) {
                    //On regarde si la pharmacie a le médicament sinon on en créé un nouveau
                    if (stockMed.getMed().equals(med)) {
                        stockMed.setQuantite(stockMed.getQuantite() + quantite);
                        pro.setQuantite(pro.getQuantite() - quantite);
                        existe = true;
                    }
                }
                if (!existe) {
                    Stock newStock = new Stock(med, quantite);
                    stock.add(newStock);
                    pro.setQuantite(pro.getQuantite() - quantite);

                }

            }
        }
    }

}
