// Auteurs : Fran�ois Mathieu et Soti
// Fichier : ConsulterJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterJeuVideo permet de consulter des jeux vid�o.
 */

public class ConsulterJeuVideo {

	/**
	 * Constructeur qui permet de consulter un jeu vid�o tant que l'utilisateur
	 * le d�sire.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public ConsulterJeuVideo( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String TITRE_CONSULTER = "\nConsulter un jeu vid�o.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vid�o � consulter.";
		final String QUEST_AUTRE_CONSULTATION =	"\nVoulez-vous consulter " 
				+ "un autre jeu vid�o (O ou N) ? ";


		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3. 
		 */
		
		JeuVideo jeuVideo;
		int indTrouve;
		char rep = 'N';
		
		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		}else {
			do {
				System.out.println(TITRE_CONSULTER);
				
				jeuVideo = new JeuVideo(); // Un objet JeuVideo de base
				
				jeuVideo.lireNoJeuVideo();
				
				indTrouve = tabJeuxVideo.chercher(jeuVideo);
				
				if (indTrouve == -1) {
					//Le jeu Video n'est pas pr�sent
					System.out.println("\nLe jeu video avec le numero " 
					+ jeuVideo.getNoJeuVideo() + " n'est pas pr�sent");
				}else {
					//le jeu video est pr�sent
					//Obtenir et afficher le jeu video
					jeuVideo = tabJeuxVideo.obtenirJeuVideo(indTrouve);
					jeuVideo.afficherJeuVideo();
					
					//Aussi
					//tabJeuxVideo.obtenirJeuVideo(indTrouve).afficherJeuVideo();
				}
				
				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_CONSULTATION);
			}while(rep == 'O');
		}
		
		
	}
}