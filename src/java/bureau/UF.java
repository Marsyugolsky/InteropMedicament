/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

/**
 *
 * @author aboura
 */
public class UF {

    int id_uf;
    String libelle;

    public UF(int id_uf, String libelle) {
        this.id_uf = id_uf;
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
