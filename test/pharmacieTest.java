
import bureau.Fournisseur;
import bureau.Medicament;
import static bureau.Medicament_.nom;
import bureau.Pharmacie;
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
public class pharmacieTest {

    @Test
    public void testAcheterMedicament() {
        Fournisseur four = new Fournisseur(1, "Pierre Fabre");
        Medicament med = new Medicament(1, "nom", "molecule", 20);
        Pharmacie pharma = new Pharmacie(1, "pharma");
        int quantite = 100;
        four.ajouterMedicament(med, quantite);
        assert (pharma.getStock().isEmpty());
        pharma.acheterMedicament(med, 50, four);
        assert (pharma.getStock().size() == 1);
        assert (pharma.getStock().get(0).getMed().equals(med));
        assert (pharma.getStock().get(0).getQuantite() == 50);
        assert (four.getProposition().get(0).getQuantite() == 50);
        pharma.acheterMedicament(med, 20, four);
        assert (pharma.getStock().size() == 1);
        assert (pharma.getStock().get(0).getQuantite() == 70);
        assert (four.getProposition().get(0).getQuantite() == 30);
        
        Medicament med2 = new Medicament(2, "Boura", "Alex", 200);

    }
}
