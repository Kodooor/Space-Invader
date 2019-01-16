// CLASSE DONNEE AUX ETUDIANTS
// NE PAS MODIFIER
// Vous n'avez pas à comprendre ni à modifier cette classe
// Sauf si vous implémentez la finDuJeu()

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

class GestionnaireTemps implements EventHandler<ActionEvent>{
	/* ======== Attributs ======== */
	GestionJeu gestionnaire;
	Vue vue;
	
	/* ======== Constructeur ======== */
	GestionnaireTemps(GestionJeu gestionnaire, Vue vue){
		super();
		this.gestionnaire = gestionnaire;
		this.vue=vue;
	}

	@Override 
	public void handle(ActionEvent actionEvent) {
         gestionnaire.jouerUnTour();
         vue.majAffichage();
         //if (gestionnaire.finDuJeu())
         	//vue.arreterAnimation();
}
}
                    
                    	
