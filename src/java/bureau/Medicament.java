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
public class Medicament implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMed;

   
    
    @Column
    private String nom;
    
    private String molecule;
    
    private int cout;

    public String getNom() {
        return nom;
    }

    public String getMolecule() {
        return molecule;
    }

    public int getCout() {
        return cout;
    }
    
    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }
     public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMolecule(String molecule) {
        this.molecule = molecule;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMed;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if (this.idMed != other.idMed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Medicament[ idMed=" + idMed + " ]";
    }
    
}
