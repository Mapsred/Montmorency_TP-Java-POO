// Auteurs : François Mathieu et Soti
// Fichier : ConsulterJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterJeuVideo permet de consulter des jeux vidéo.
 */

public class ConsulterJeuVideo {

	/**
	 * Constructeur qui permet de consulter un jeu vidéo tant que l'utilisateur
	 * le désire.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public ConsulterJeuVideo( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String TITRE_CONSULTER = "\nConsulter un jeu vidéo.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à consulter.";
		final String QUEST_AUTRE_CONSULTATION =	"\nVoulez-vous consulter " 
				+ "un autre jeu vidéo (O ou N) ? ";


		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3. 
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
					//Le jeu Video n'est pas présent
					System.out.println("\nLe jeu video avec le numero " 
					+ jeuVideo.getNoJeuVideo() + " n'est pas présent");
				}else {
					//le jeu video est présent
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