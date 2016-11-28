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
 * @author aboura
 */

@Entity
@XmlRootElement
public class Admission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IEP;
    
    @Column
    int IPP;
        @Column
String nom;

    public Admission(int IEP, int IPP, String nom) {
        this.IEP = IEP;
        this.IPP = IPP;
        this.nom = nom;
    }

    public int getIEP() {
        return IEP;
    }

    public int getIPP() {
        return IPP;
    }

    public String getNom() {
        return nom;
    }

    public void setIEP(int IEP) {
        this.IEP = IEP;
    }

    public void setIPP(int IPP) {
        this.IPP = IPP;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
