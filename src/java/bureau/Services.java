/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author Nicolas Singer <Nicolas.Singer@gmail.com>
 */
public class Services {
    
    EntityManagerFactory fact;
    EntityManager em;

    public Services(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
    
    
    public void close() {
        em.close();
    }
    public void newCrayon(Crayon cr) {
	em.getTransaction( ).begin( );
        em.persist(cr);
        em.getTransaction().commit();
    }

    public Crayon newCrayon(String couleur) {
        Crayon p = new Crayon();
        p.setCouleur(couleur);
     
	em.getTransaction( ).begin( );
        em.persist(p);
        em.getTransaction().commit();
      
        return p;
    }
    
    public void removeCrayon(int id) {
       
        Crayon cr = em.find( Crayon.class, id );
	em.getTransaction( ).begin( );
        em.remove(cr);
        em.getTransaction().commit();
       
    }
    
    public void deleteBoite(int id) {
       
        Boite b = em.find( Boite.class, id );
	em.getTransaction( ).begin( );
        em.remove(b);
        em.getTransaction().commit();
       
    }
  
    public void editCrayon(Crayon cr) {
      
	em.getTransaction( ).begin( );
        em.merge(cr);
        em.getTransaction().commit();
     
    }
    
    public Crayon getCrayonsById(int id) {
       
	Crayon res = em.find( Crayon.class, id );
      
        return res;
    }
    
    public List<Crayon> getAllCrayons() {
	TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c", Crayon.class);
        List<Crayon> res = query.getResultList();
        return res;
    }
    
     public List<Crayon> getAllCrayonsSansBoite() {
        // va chercher la liste des crayons qui ne sont pas affectés à une boite, cad les crayons pour lesquels
        // il n'existe pas de boite les contenant. D'où la requête.
	TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE  NOT EXISTS (SELECT b FROM Boite b, IN (b.crayons) cr WHERE cr = c)", Crayon.class);
        List<Crayon> res = query.getResultList();
        return res;
    }
    
    public List<Boite> getAllBoites() {
      
	TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b", Boite.class);
        List<Boite> res = query.getResultList();
      
        return res;
    }
    
    public List<Crayon> getCrayonsByCouleurId(String couleur) {
     
        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE c.couleur = :couleur", Crayon.class)
                .setParameter("couleur",couleur);
        List<Crayon> res = query.getResultList();
     
        return res;
    }
    
    public Boite newBoite(List<Crayon> crayons) {
        Boite b = new Boite();
	em.getTransaction( ).begin( );
        b.setCrayons(crayons);
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }
    
    public Boite newBoite(Boite b) {
	em.getTransaction( ).begin( );
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }
    
    public void updateBoite(Boite b) {
        em.getTransaction( ).begin( );
        em.merge(b);
        em.getTransaction().commit();
    }
    
    public Boite getBoiteById(int id) {
        
	Boite res = em.find( Boite.class, id );
       
        return res;
    }
    
    public List<Boite> getBoitesByCouleurDeCrayon(String couleur) {
       
        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b JOIN b.crayons c WHERE c.couleur = :couleur", Boite.class)
                .setParameter("couleur",couleur);
        List<Boite> res =  query.getResultList();
       
        return res;
    }
    
    public void deleteAllBoites() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Boite").executeUpdate();
        em.getTransaction().commit();
        
    }
    
    public void deleteAllCrayons() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Crayon").executeUpdate();
        em.getTransaction().commit();
        
    }
    
    //////////////////// M E D I C A M E N T ////////////////////
    
     public void newMedicament(Medicament med) {
	em.getTransaction( ).begin( );
        em.persist(med);
        em.getTransaction().commit();
    }
    
    public void removeMedicament(int idMed) {
       
        Medicament med = em.find( Medicament.class, idMed );
	em.getTransaction( ).begin( );
        em.remove(med);
        em.getTransaction().commit();
       
    }
     public void deleteAllMedicament() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Medicament").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editMedicament(Medicament med) {
      
	em.getTransaction( ).begin( );
        em.merge(med);
        em.getTransaction().commit();
     
    }
    
    public Medicament getMedicamentsById(int idMed) {
       
	Medicament res = em.find( Medicament.class, idMed );
      
        return res;
    }
     public List<Medicament> getAllMedicaments() {
	TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m", Medicament.class);
        List<Medicament> res = query.getResultList();
        return res;
    }
    
     public List<Medicament> getAllMedicamentsSansBoite() {
        // va chercher la liste des crayons qui ne sont pas affectés à une boite, cad les crayons pour lesquels
        // il n'existe pas de boite les contenant. D'où la requête.
	TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m WHERE  NOT EXISTS (SELECT b FROM Pharmacie b, IN (b.medicaments) med WHERE med = m)", Medicament.class);
        List<Medicament> res = query.getResultList();
        return res;
    }
     public List<Medicament> getMedicamentsByNomId(String nom) {
     
        TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m WHERE m.nom = :nom", Medicament.class)
                .setParameter("nom",nom);
        List<Medicament> res = query.getResultList();
     
        return res;
    }
     public Medicament newMedicament(String nom,String molecule, int cout) {
        Medicament m = new Medicament(nom, molecule, cout);
        m.setNom(nom);
        m.setMolecule(molecule);
	em.getTransaction( ).begin( );
        em.persist(m);
        em.getTransaction().commit();
      
        return m;
    }
     public List<Medicament> getMedicamentsByMoleculeId(String molecule) {
     
        TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m WHERE m.molecule = :molecule", Medicament.class)
                .setParameter("molecule",molecule);
        List<Medicament> res = query.getResultList();
     
        return res;
    }
     
     //////////////////// F O U R N I S S E U R ////////////////////
    
     public void newFournisseur(Fournisseur four) {
	em.getTransaction( ).begin( );
        em.persist(four);
        em.getTransaction().commit();
    }
    
    public void removeFournisseur(int idFour) {
       
        Medicament four = em.find( Medicament.class, idFour );
	em.getTransaction( ).begin( );
        em.remove(four);
        em.getTransaction().commit();
       
    }
     public void deleteAllFournisseur() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Fournisseur").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editFournisseur(Fournisseur four) {
      
	em.getTransaction( ).begin( );
        em.merge(four);
        em.getTransaction().commit();
     
    }
    
    public Fournisseur getFournisseursById(int idFour) {
       
	Fournisseur res = em.find( Fournisseur.class, idFour );
      
        return res;
    }
     public List<Fournisseur> getAllFournisseurs() {
	TypedQuery<Fournisseur> query = em.createQuery("SELECT f FROM Fournisseur f", Fournisseur.class);
        List<Fournisseur> res = query.getResultList();
        return res;
    }
     public List<Fournisseur> getFournisseursByNomId(String nom) {
     
        TypedQuery<Fournisseur> query = em.createQuery("SELECT f FROM Fournisseur f WHERE f.nom = :nom", Fournisseur.class)
                .setParameter("nom",nom);
        List<Fournisseur> res = query.getResultList();
     
        return res;
    }
     
         //////////////////// P R E S C R I P T I O N ////////////////////
    
//     public void newPrescription(Prescription pres) {
//	em.getTransaction( ).begin( );
//        em.persist(pres);
//        em.getTransaction().commit();
//    }
     
    public Prescription newPrescription(Prescription pres) {
	em.getTransaction( ).begin( );
        em.persist(pres);
        em.getTransaction().commit();
        return pres;
    }
    public void removePrescription(int idPres) {
       
        Prescription pres = em.find( Prescription.class, idPres );
	em.getTransaction( ).begin( );
        em.remove(pres);
        em.getTransaction().commit();
       
    }
     public void deleteAllPrescription() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Prescription").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editPrescription(Prescription pres) {
      
	em.getTransaction( ).begin( );
        em.merge(pres);
        em.getTransaction().commit();
     
    }
         public List<Prescription> getPrescriptionsByNomPreparateur(String nom) {
     // a voir pour la requete SQL
        TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p WHERE p.no m = :nom", Prescription.class)
                .setParameter("nom",nom);
        List<Prescription> res = query.getResultList();
     
        return res;
    }
             public List<Prescription> getPrescriptionsByDate(Date date_press) {
     
        TypedQuery<Prescription> query = em.createQuery("SELECT d FROM Prescription d WHERE d.date_press = :date_press", Prescription.class)
                .setParameter("date_press",date_press);
        List<Prescription> res = query.getResultList();
     
        return res;
    } 
             
    public List<Prescription> getPrescriptionsByAvancement(Avancement avancement) {

        TypedQuery<Prescription> query = em.createQuery("SELECT a FROM Prescription a WHERE a.avancement = :avancement", Prescription.class)
                .setParameter("avancement", avancement);
        List<Prescription> res = query.getResultList();

        return res;
    }
         
    public Prescription getPrescriptionsById(int idPres) {
       
	Prescription res = em.find( Prescription.class, idPres );
      
        return res;
    }
     public List<Prescription> getAllPrescriptions() {
	TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p", Prescription.class);
        List<Prescription> res = query.getResultList();
        return res;
    }
     public List<Prescription> getPrescriptionsByIEP(int IEP) {
       
      TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p WHERE IEP ="+IEP, Prescription.class);
        List<Prescription> res = query.getResultList();
        return res;
    }
     
     
     //////////////////// P R E P A R A T E U R ////////////////////
     
     public void newPreparateur(Preparateur preparateur) {
	em.getTransaction( ).begin( );
        em.persist(preparateur);
        em.getTransaction().commit();
    }

    public Preparateur newPreparateur(String nom, String prenom) {
        Preparateur p = new Preparateur(nom, prenom);
        p.setNom(nom);
        p.setPrenom(prenom);
     
	em.getTransaction( ).begin( );
        em.persist(p);
        em.getTransaction().commit();
      
        return p;
    }
    
    public void removePreparateur(int idPrepa) {
       
        Preparateur prepa = em.find( Preparateur.class, idPrepa );
	em.getTransaction( ).begin( );
        em.remove(prepa);
        em.getTransaction().commit();
       
    }
    
    public void deletePreparateur(int idPrepa) {
       
        Preparateur p = em.find( Preparateur.class, idPrepa );
	em.getTransaction( ).begin( );
        em.remove(p);
        em.getTransaction().commit();
       
    }
  
    public void editPreparateur(Preparateur p) {
      
	em.getTransaction( ).begin( );
        em.merge(p);
        em.getTransaction().commit();
     
    }
    
    public Preparateur getPreparateursById(int idPrepa) {
       
	Preparateur res = em.find( Preparateur.class, idPrepa );
      
        return res;
    }
    
    public List<Preparateur> getAllPreparateurs() {
	TypedQuery<Preparateur> query = em.createQuery("SELECT p FROM Preparateur p", Preparateur.class);
        List<Preparateur> res = query.getResultList();
        return res;
    }
    
    //////////////////// P H A R M A C I E ////////////////////
    
     public void newPharmacie(Pharmacie ph) {
	em.getTransaction( ).begin( );
        em.persist(ph);
        em.getTransaction().commit();
    }
    
    public void removePharmacie(int idPh) {
       
        Pharmacie ph = em.find( Pharmacie.class, idPh );
	em.getTransaction( ).begin( );
        em.remove(ph);
        em.getTransaction().commit();
       
    }
     public void deleteAllPharmacie() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Pharmacie").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editPharmacie(Pharmacie ph) {
      
	em.getTransaction( ).begin( );
        em.merge(ph);
        em.getTransaction().commit();
     
    }
    
    public Pharmacie getPharmaciesById(int idPh) {
       
	Pharmacie ph = em.find( Pharmacie.class, idPh );
      
        return ph;
    }
    
         public List<Pharmacie> getPharmaciesByNom(String nom) {
     
        TypedQuery<Pharmacie> query = em.createQuery("SELECT p FROM Pharmacie p WHERE p.nom = :nom", Pharmacie.class)
                .setParameter("nom",nom);
        List<Pharmacie> res = query.getResultList();
     
        return res;
    }
    
     public List<Pharmacie> getAllPharmacies() {
	TypedQuery<Pharmacie> query = em.createQuery("SELECT p FROM Pharmacie p", Pharmacie.class);
        List<Pharmacie> res = query.getResultList();
        return res;
    }
    
     public Pharmacie newPharmacie(String nom) {
        Pharmacie ph = new Pharmacie(nom);
        ph.setNom(nom);
	em.getTransaction( ).begin( );
        em.persist(ph);
        em.getTransaction().commit();
      
        return ph;
    }
    
     //////////////////// U F ////////////////////
    
     public void newUF(UF uf) {
	em.getTransaction( ).begin( );
        em.persist(uf);
        em.getTransaction().commit();
    }
    
    public void removeUF(int idUF) {
       
        UF uf = em.find( UF.class, idUF );
	em.getTransaction( ).begin( );
        em.remove(uf);
        em.getTransaction().commit();
       
    }
     public void deleteAllUF() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM UF").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editUF(UF uf) {
      
	em.getTransaction( ).begin( );
        em.merge(uf);
        em.getTransaction().commit();
     
    }
    
    public UF getUFsById(int idUF) {
       
	UF uf = em.find( UF.class, idUF );
      
        return uf;
    }
     public List<UF> getAllUFs() {
	TypedQuery<UF> query = em.createQuery("SELECT u FROM UF u", UF.class);
        List<UF> uf = query.getResultList();
        return uf;
    }
    
     public List<UF> getMedicamentsByLibelle(String libelle) {
     
        TypedQuery<UF> query = em.createQuery("SELECT u FROM UF u WHERE u.libelle = :libelle", UF.class)
                .setParameter("libelle",libelle);
        List<UF> uf = query.getResultList();
     
        return uf;
    }
     public UF newUF(String libelle) {
        UF uf = new UF(libelle);
        uf.setLibelle(libelle);
	em.getTransaction( ).begin( );
        em.persist(uf);
        em.getTransaction().commit();
      
        return uf;
    }

     //////////////////// A D M I S S I O N ////////////////////
    
     public void newAdmission(Admission ad) {
	em.getTransaction( ).begin( );
        em.persist(ad);
        em.getTransaction().commit();
    }
    
    public void removeAdmission(int idAd) {
       
        Admission ad = em.find( Admission.class, idAd );
	em.getTransaction( ).begin( );
        em.remove(ad);
        em.getTransaction().commit();
       
    }
     public void deleteAllAdmission() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editAdmission(Admission ad) {
      
	em.getTransaction( ).begin( );
        em.merge(ad);
        em.getTransaction().commit();
     
    }
    
    public Admission getAdmissionsByIEP(int IEP) {
       
	Admission res = em.find( Admission.class, IEP );
      
        return res;
    }
     public List<Admission> getAllAdmissions() {
	TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }
    
     public List<Admission> getAdmissionsByIPP(int IPP) {
     
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a WHERE a.IPP = :IPP", Admission.class)
                .setParameter("IPP",IPP);
        List<Admission> res = query.getResultList();
     
        return res;
    }
     
    public List<Admission> getAdmissionsByNom(String nom) {
     
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a WHERE a.nom = :nom", Admission.class)
                .setParameter("nom",nom);
        List<Admission> res = query.getResultList();
     
        return res;
    }
     
     public Admission newAdmission(int IEP, int IPP, String nom, String prenom) {
        Admission m = new Admission(IEP, IPP, nom, prenom);
        m.setIEP(IEP);
        m.setIPP(IPP);
        m.setNom(nom);
	em.getTransaction( ).begin( );
        em.persist(m);
        em.getTransaction().commit();
      
        return m;
    }
     
     //////////////////// C O M P O S E ////////////////////
    
     public void newCompose(Compose comp) {
	em.getTransaction( ).begin( );
        em.persist(comp);
        em.getTransaction().commit();
    }
    
    public void removeCompose(int idComp) {
       
        Compose comp = em.find( Compose.class, idComp );
	em.getTransaction( ).begin( );
        em.remove(comp);
        em.getTransaction().commit();
       
    }
     public void deleteAllCompose() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Compose").executeUpdate();
        em.getTransaction().commit();
        
    }
     public void editCompose(Compose comp) {
      
	em.getTransaction( ).begin( );
        em.merge(comp);
        em.getTransaction().commit();
     
    }
    
    public Compose getComposesById(int idComp) {
       
	Compose comp = em.find( Compose.class, idComp );
      
        return comp;
    }
     public List<Compose> getAllComposes() {
	TypedQuery<Compose> query = em.createQuery("SELECT c FROM Compose c", Compose.class);
        List<Compose> comp = query.getResultList();
        return comp;
    }
//    
 }