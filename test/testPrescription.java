
import bureau.Administration;
import bureau.Admission;
import bureau.Avancement;
import bureau.Compose;
import bureau.DatabaseUtils;
import bureau.Fournisseur;
import bureau.Medicament;
import bureau.Pharmacie;
import bureau.Preparateur;
import bureau.Prescription;
import bureau.Services;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mgros
 */
public class testPrescription {
    Admission patient = new Admission(1,1,"bourra","alexandre");
    Prescription prescription = new Prescription(new Date().toString(), Avancement.prepare,patient);
    Fournisseur four = new Fournisseur("Pierre Fabre");
        Medicament med = new Medicament( "nom", "molecule", 20);
        Pharmacie pharma = new Pharmacie( "pharma");
        int quantite = 100;
        Preparateur preparateur = new Preparateur("Quentin", "Leroux");
        
    @Test
    public void testAjouterMedicament() throws Exception {
        //initialisation
        
        four.ajouterMedicament(med, quantite);

        pharma.acheterMedicament(med, 50, four);

        Medicament med2 = new Medicament( "Boura", "Alex", 200);
        quantite = 200;
        four.ajouterMedicament(med2, quantite);
        pharma.acheterMedicament(med2, 100, four);
        
        Compose comp = new Compose(med, 50, Administration.auriculaire, preparateur, pharma);
        
        Compose comp2 = new Compose(med2, 50, Administration.auriculaire, preparateur, pharma);

        Compose comp3 = new Compose(med, 500, Administration.auriculaire, preparateur, pharma);
        
        

    }
     @Test
    public void testpersistance() {
        Services serv = new Services(DatabaseUtils.fact());
    
        
        
        Admission patient = new Admission(1,1,"gros","marceli");
        Prescription pres = new Prescription(new Date().toString(), Avancement.prepare, patient);
        serv.newPrescription(pres);
       
        assert (prescription.getId_pres()!= 0);
        
       
    }
}
