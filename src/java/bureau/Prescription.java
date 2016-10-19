/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aboura
 */
public class Prescription {

    int id_pres;
    Date date_press;
    Avancement avancement;
    int cout_total;
    
    List<Compose> composition;

    public Prescription(int id_pres, Date date_press, Avancement avancement, int cout_total) {
        this.id_pres = id_pres;
        this.date_press = date_press;
        this.avancement = avancement;
        this.cout_total = cout_total;
        composition = new ArrayList<Compose>();
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

    /*
    public int calculCout() {

        return cout_total;
    }
     */
}
