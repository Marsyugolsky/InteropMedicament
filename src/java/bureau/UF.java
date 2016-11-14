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
public class UF implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_uf;
    
    @Column
    String libelle;

    public UF( String libelle) {
        this.libelle = libelle;
    }

    public int getId_uf() {
        return id_uf;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId_uf(int id_uf) {
        this.id_uf = id_uf;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
