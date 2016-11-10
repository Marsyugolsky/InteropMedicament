
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
public class medicamentTest {

    @Test
    public void testCompatible() {
        Medicament med = new Medicament(1, "nom", "molecule", 20);
        Medicament med2 = new Medicament(2, "nom2", "molecule2", 30);
        Medicament med3 = new Medicament(3, "nom3", "molecule", 20);
        boolean compatible = med.compatible(med2);
        assert (compatible == true);
        compatible = med.compatible(med3);
        assert (compatible == false);
    }
    
    
}
