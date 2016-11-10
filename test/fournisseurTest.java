
import bureau.Fournisseur;
import bureau.Medicament;
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
public class fournisseurTest {
    @Test
    public void testAcheterMedicament() {
        Fournisseur four = new Fournisseur(1, "Pierre Fabre");
        Medicament med = new Medicament("nom", "molecule", 20);
        int quantite = 1;
        assert (four.getProposition().isEmpty());
        four.ajouterMedicament(med, quantite);
        assert (four.getProposition().size() == 1);
        assert (four.getProposition().get(0).getMed().equals(med));
        assert (four.getProposition().get(0).getQuantite() == quantite);
        
        quantite = 4;
        four.ajouterMedicament(med, quantite);
        assert (four.getProposition().size() == 1);
        assert (four.getProposition().get(0).getMed().equals(med));
        assert (four.getProposition().get(0).getQuantite() == quantite+1);
        
        Medicament med2 = new Medicament("Boura", "Alex", 200);
        four.ajouterMedicament(med2, quantite);
        assert (four.getProposition().size() == 2);
        assert (four.getProposition().get(1).getMed().equals(med2));
        assert (four.getProposition().get(1).getQuantite() == quantite);


    }
}
