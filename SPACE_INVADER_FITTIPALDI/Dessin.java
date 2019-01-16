// CLASSE DONNEE AUX ETUDIANTS
// NE PAS MODIFIER

import java.util.ArrayList;
/**
 * Dessin est une classe qui permet de représenter un dessin
 * Un dessin contient un attribut qui est une liste de ChainePositionnee
 */

class Dessin {
	/* ======== Attributs ======== */
    ArrayList<ChainePositionnee> listeChaines;

    /* ======== Constructeur ======== */
    Dessin(){
		this.listeChaines= new ArrayList<ChainePositionnee>();
	}

	/* ======== Getteurs ======== */
	ArrayList<ChainePositionnee> getChaines(){
		return this.listeChaines;
	}

	/* ======== Autres méthodes ======== */

    public void ajouteChaine(double x, double y, String chaine){
        this.listeChaines.add(new ChainePositionnee(x,y,chaine));
    }


    public void ajouteDessin(Dessin autreDessin){
        for(ChainePositionnee cp : autreDessin.getChaines())
            this.listeChaines.add(cp);
    }

	/**
	 * indique si une position (x,y) coincide avec l'un des caractères
	 * de l'ensemble des chaines de caractères
	 */
    public boolean contient(double posx, double posy){
        for(ChainePositionnee cp: listeChaines){
            if (cp.contient(posx, posy))
                return true;
        }
        return false;
    }

    /**
	 * permet de vider le dessin
	 */
    public void vider(){ this.listeChaines.clear();}




}
