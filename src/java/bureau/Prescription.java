/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aboura
 */

@Entity
@XmlRootElement
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_pres;

    @Column
    Date date_press;
    Avancement avancement;
    int cout_total;

    List<Compose> liste;


    public Prescription( Date date_press, Avancement avancement, int cout_total) {
        this.date_press = date_press;
        this.avancement = avancement;
        this.cout_total = cout_total;

        liste = new ArrayList<Compose>();

    }

    public int getId_pres() {
        return id_pres;
    }

    public Date getDate_press() {
        return date_press;
    }

    public Avancement getAvancement() {
        return avancement;
    }

    public int getCout_total() {
        return cout_total;
    }

    public void setId_pres(int id_pres) {
        this.id_pres = id_pres;
    }

    public void setDate_press(Date date_press) {
        this.date_press = date_press;
    }

    public void setAvancement(Avancement avancement) {
        this.avancement = avancement;
    }

    public void setCout_total(int cout_total) {
        this.cout_total = cout_total;
    }
    
    public void ajouterMedicamentPrescription (Medicament med, int quantite, Administration administration, Preparateur preparateur) {
        
    }

    public int coutTotal() {
        int res = 0;
        for (Compose co : liste) {
            res = res + co.getMed().getCout() * co.getQuantite();
        }
        return res;
    }
    public void ajouterComposition(Compose comp){
        liste.add(comp);
    }

}
