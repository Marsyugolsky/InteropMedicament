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
public class Admission {
    
    int IEP;
    int IPP;
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
