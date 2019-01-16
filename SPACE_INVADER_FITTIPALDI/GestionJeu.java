// CLASSE DONNEE AUX ETUDIANTS
// A COMPLETER
import java.util.ArrayList;

class GestionJeu{
	/* ======== Attributs ======== */
	Dessin princ;
	double positionX;
	double positionY;
	Vaisseau vaisseau;
	Projectile projectile;
	ArrayList<Projectile> malistedeprojectile;
	Double nbPoints;
	Score score;
	ArrayList<Alien> malistealien;
	Alien alien;
	boolean allerAdroite=true;
	double vitesseXalien;
	double vitesseYalien;
	boolean perdu;

	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	GestionJeu(){
		perdu = false;
		vitesseXalien = 1;
		vitesseYalien = 3;
		princ = new Dessin();
		positionX=0;
		positionY=10;
		vaisseau = new Vaisseau();
		malistedeprojectile = new ArrayList<Projectile>();
		score = new Score();
		malistealien = new ArrayList<Alien>();
}

	/* ======== Getteurs ======== */
	int getLargeur(){ return 200; }
	int getHauteur(){ return 70; }


	// ATTENTION - la méthode getDessin() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette
	// méthode au risque de saturer rapidement la mémoire
	Dessin getDessin(){
		if(!perdu){
			this.princ.vider();
			this.princ.ajouteDessin(vaisseau.getDessin());
			for( Projectile projectile : malistedeprojectile){
				this.princ.ajouteDessin(projectile.getDessin());
				this.princ.ajouteDessin(score.getDessin());
			}
			for( Alien alien : malistealien ){
				this.princ.ajouteDessin(alien.getDessin());
			}
			return princ;
		}
		else{
			this.positionX=38.5;
			this.positionY=35;
			this.princ.vider();
			this.princ.ajouteChaine(positionX, positionY+5, "         _              _                  _   _         _                   _      _          _       _            _      ");
			this.princ.ajouteChaine(positionX, positionY+4, "        /\\ \\           / /\\               /\\_\\/\\_\\ _    /\\ \\                /\\ \\   /\\ \\    _ / /\\     /\\ \\         /\\ \\    ");
			this.princ.ajouteChaine(positionX, positionY+3, "       /  \\ \\         / /  \\             / / / / //\\_\\ /  \\ \\              /  \\ \\  \\ \\ \\  /_/ / /    /  \\ \\       /  \\ \\   ");
			this.princ.ajouteChaine(positionX, positionY+2, "      / /\\ \\_\\       / / /\\ \\           /\\ \\/ \\ \\/ / // /\\ \\ \\            / /\\ \\ \\  \\ \\ \\ \\___\\/    / /\\ \\ \\     / /\\ \\ \\  ");
			this.princ.ajouteChaine(positionX, positionY+1, "     / / /\\/_/      / / /\\ \\ \\         /  \\____\\__/ // / /\\ \\_\\  ____    / / /\\ \\ \\ / / /  \\ \\ \\   / / /\\ \\_\\   / / /\\ \\_\\ ");
			this.princ.ajouteChaine(positionX, positionY, "    / / / ______   / / /  \\ \\ \\       / /\\/________// /_/_ \\/_//\\____/\\ / / /  \\ \\_\\\\ \\ \\   \\_\\ \\ / /_/_ \\/_/  / / /_/ / / ");
			this.princ.ajouteChaine(positionX, positionY-1, "   / / / /\\_____\\ / / /___/ /\\ \\     / / /\\/_// / // /____/\\   \\/____\\// / /   / / / \\ \\ \\  / / // /____/\\    / / /__\\/ /  ");
			this.princ.ajouteChaine(positionX, positionY-2, "  / / /  \\/____ // / /_____/ /\\ \\   / / /    / / // /\\____\\/          / / /   / / /   \\ \\ \\/ / // /\\____\\/   / / /_____/   ");
			this.princ.ajouteChaine(positionX, positionY-3, " / / /_____/ / // /_________/\\ \\ \\ / / /    / / // / /______         / / /___/ / /     \\ \\ \\/ // / /______  / / /\\ \\ \\     ");
			this.princ.ajouteChaine(positionX, positionY-4, "/ / /______\\/ // / /_       __\\ \\_\\\\/_/    / / // / /_______\\       / / /____\\/ /       \\ \\  // / /_______\\/ / /  \\ \\ \\    ");
			this.princ.ajouteChaine(positionX, positionY-5, "\\/___________/ \\_\\___\\     /____/_/        \\/_/ \\/__________/       \\/_________/         \\_\\/ \\/__________/\\/_/    \\_\\/    ");
			this.princ.ajouteChaine(positionX+51.5, positionY-7,"Ton score : " + this.score.retourne());
			return this.princ;
	   }
	}

	/* ======== Autres méthodes ======== */


	// ATTENTION - la méthode jouerUnTour() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette
	// méthode au risque de saturer rapidement la mémoire
	void jouerUnTour(){
		for (int i = 0; i<malistedeprojectile.size(); ++i){
			malistedeprojectile.get(i).evolue();
			if (malistedeprojectile.get(i).getPosY()>80){
				malistedeprojectile.remove(malistedeprojectile.get(i));
				score.ajoute(-20);
			}
		}
		if(malistealien.isEmpty()){
			for(int i = 0; i< 12; ++i){
				malistealien.add(new Alien(20 + 13 * i , 70));
			}
			for(int j = 0; j< 12; ++j){
				malistealien.add(new Alien(20 + 13 * j , 63));
			}
	  }
		if(!malistealien.isEmpty()){
			for (int i=0; i < malistealien.size(); ++i){
				for(int j=0; j < malistedeprojectile.size(); ++j){
					if(malistealien.get(i).contient(malistedeprojectile.get(j).positionX,malistedeprojectile.get(j).positionY)){
						malistealien.remove(malistealien.get(i));
						malistedeprojectile.remove(malistedeprojectile.get(j));
						score.ajoute(50);

					}
				}
			}


			if(adroite()>=getLargeur() - 9){
				for (int i =0; i<malistealien.size(); ++i){
					malistealien.get(i).evolueY(vitesseYalien);
				}
				allerAdroite=false;
			}

			if(agauche() <= 1){
				for (int i =0; i<malistealien.size(); ++i){
					malistealien.get(i).evolueY(vitesseYalien);
				}
				allerAdroite=true;
			}

			for (int i =0; i<malistealien.size(); ++i){
				if(allerAdroite){
					malistealien.get(i).evolueX(vitesseXalien);
				}
				else{
					malistealien.get(i).evolueX(-vitesseXalien);
				}
			}
			for (int i=0; i<malistealien.size(); ++i){
				if (malistealien.get(i).positionY<8){
					perdu=true;
				}
			}
		}
	}

	void toucheEspace(){
		malistedeprojectile.add(new Projectile(this.vaisseau.getPosCanon(),5));

}

	void toucheDroite(){
		if (this.vaisseau.positionX<=getLargeur()-25){
		this.vaisseau.deplacer(4);

	}



	}
	void toucheGauche(){
		if (this.vaisseau.positionX>5){
		this.vaisseau.deplacer(-4);}
	}

		double adroite(){
		double max = this.malistealien.get(0).positionX;
		for(int i=0; i<this.malistealien.size(); ++i){
			if(this.malistealien.get(i).positionX > max){max = this.malistealien.get(i).positionX;}
		}
	return max;
	}
		double agauche(){
		double min = this.malistealien.get(0).positionX;
		for(int i=0; i<this.malistealien.size(); ++i){
			if(this.malistealien.get(i).positionX < min){min = this.malistealien.get(i).positionX;}
		}
	return min;
	}
		void pause(){

			// this.princ.getDessin(100,40,"game over");
		}

}
