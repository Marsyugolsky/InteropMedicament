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

/**
 *
 * @author mgros
 */
@Entity
@XmlRootElement
public class Compose implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    Medicament med;
        @Column
int quantite;
        @Column
Administration administration;
        @Column
Preparateur preparateur;
        @Column
Pharmacie pharmacie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compose(Medicament med, int quantite, Administration administration, Preparateur preparateur, Pharmacie pharmacie) {

        this.med = med;
        this.administration = administration;
        this.preparateur = preparateur;
        this.quantite = quantite;
        this.pharmacie = pharmacie;

    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPreparateur(Preparateur preparateur) {
        this.preparateur = preparateur;
    }

    public Preparateur getPreparateur() {
        return preparateur;

    }

    public Medicament getMed() {
        return med;
    }

    public int getQuantite() {
        return quantite;
    }

    public Administration getAdministration() {
        return administration;
    }

    public void setMed(Medicament med) {
        this.med = med;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compose)) {
            return false;
        }
        Compose other = (Compose) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Compose[ id=" + id + " ]";
    }

}
