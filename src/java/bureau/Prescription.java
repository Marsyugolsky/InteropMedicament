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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    int IEP;
    @Column
    Date date_press;
        @Column
Avancement avancement;
        @Column
int cout_total;
    @Column
@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Compose> compose;

    public List<Compose> getCompose() {
        return compose;
    }

    public void setCompose(List<Compose> compose) {
        this.compose = compose;
    }


    public Prescription( Date date_press, Avancement avancement) {
        this.date_press = date_press;
        this.avancement = avancement;
        this.cout_total = 0;

        compose = new ArrayList<Compose>();

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
    
    public void ajouterMedicamentPrescription (Compose comp) {
        compose.add(comp);
        setCout_total(this.coutTotal());
    }

    public int coutTotal() {
        int res = 0;
        for (Compose co : compose) {
            res = res + co.getMed().getCout() * co.getQuantite();
        }
        return res;
    }
    

}
