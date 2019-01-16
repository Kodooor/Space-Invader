// CLASSE DONNEE AUX ETUDIANTS
// NE PAS MODIFIER
// Vous n'avez pas à comprendre ni à modifier cette classe
// Sauf si vous implémentez des fonctionnalités avancées avec d'autres touches du clavier

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


class GestionnaireClavier implements EventHandler<KeyEvent>{
	/* ======== Attributs ======== */
	GestionJeu gestionnaire;
	Vue vue;

	/* ======== Constructeur ======== */
	GestionnaireClavier(GestionJeu gestionnaire, Vue vue){
		super();
		this.gestionnaire = gestionnaire;
		this.vue=vue;
	}

	@Override
	public void handle(KeyEvent keyEvent) {
              if(keyEvent.getCode()==KeyCode.LEFT)
                    gestionnaire.toucheGauche();
              if(keyEvent.getCode()==KeyCode.RIGHT)
                    gestionnaire.toucheDroite();
              if(keyEvent.getCode()==KeyCode.SPACE)
                    gestionnaire.toucheEspace();
							if(keyEvent.getCode()==KeyCode.P)
										gestionnaire.pause();
	}
}
