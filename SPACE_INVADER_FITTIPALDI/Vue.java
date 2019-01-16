// CLASSE DONNEE AUX ETUDIANTS
// NE PAS MODIFIER
// Vous n'avez pas à comprendre ni à modifier cette classe

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class Vue extends Application {
    private Pane root;
    private Group caracteres;
    private GestionJeu gestionnaire;
    private int hauteurTexte;
    private int largeurCaractere;
    private Timeline timeline;
    
    /*
     * On ne peut pas écrire de constructeur pour une Application
     */

    protected void majAffichage(){
        caracteres.getChildren().clear();
        int hauteur = (int) root.getHeight();
        
        for( ChainePositionnee cp : gestionnaire.getDessin().getChaines())
        {	
			
            Text t = new Text (cp.getx()*largeurCaractere,hauteur-cp.gety()*hauteurTexte, cp.getChaine());
        	 
            t.setFont(Font.font ("Monospaced", 10));
            caracteres.getChildren().add(t);
        }
    }

    private void lancerAnimation() {
		
		System.out.println("Lancer animation");
		// On ajoute le Controleur de Temps
         timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                    new GestionnaireTemps(gestionnaire, this)),
                new KeyFrame(Duration.seconds(0.025))
                );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


     void arreterAnimation() {	
        timeline.stop(); 
    }
    
    
	/*
	 * This method is called immediately after the Application class is loaded and constructed. 
	 * An application may override this method to perform initialization prior to the actual starting of the application.
	 * NOTE: This method is not called on the JavaFX Application Thread. 
	 * An application must not construct a Scene or a Stage in this method. 
	 * An application may construct other JavaFX objects in this method. 
	 */
	@Override 
	public void init(){    
		  gestionnaire = new GestionJeu();
		  //System.out.println("Init");		      
	}

	/*
	 * The main entry point for all JavaFX applications. 
	 * The start method is called after the init method has returned, 
	 * and after the system is ready for the application to begin running.
	 * NOTE: This method is called on the JavaFX Application Thread. 
	 */
    @Override
        public void start(Stage primaryStage) {
			//System.out.println("start ");
            primaryStage.setTitle("IUTO Space Invader");
            
            caracteres = new Group();
            root= new AnchorPane(caracteres);
 
            Text t=new Text("█");            
            // Text t=new Text("X");
            t.setFont(Font.font("Monospaced",10));
            hauteurTexte =(int) t.getLayoutBounds().getHeight();
            largeurCaractere = (int) t.getLayoutBounds().getWidth();

            Scene scene = new Scene(root,gestionnaire.getLargeur()*largeurCaractere,gestionnaire.getHauteur()*hauteurTexte);

			// On ajoute le Controleur de Clavier
            scene.addEventHandler(KeyEvent.KEY_PRESSED, new GestionnaireClavier(gestionnaire,this));
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            lancerAnimation();

        }
        
        public static void main(String[] args) {
			/*
			 * C'est la méthode statique launch() de la classe Application qui servira en fait à initialiser une instance de notre classe. 
			 * Celle-ci se doit d'avoir un constructeur par défaut (pas de constructeur défini) ou un constructeur sans argument public
			 *  pour pouvoir être chargée ; tout autre constructeur sera ignoré. Si aucun constructeur compatible n'est trouvé, une exception sera levée.
			 */
        	Application.launch(args);
    }
}
