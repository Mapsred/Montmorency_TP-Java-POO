// Auteurs : Fran�ois Mathieu et Soti
// Fichier : ConsulterTousJeuxVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousJeuxVideo permet d'afficher tous les jeux vid�o.
 */

public class ConsulterTousJeuxVideo {

	/**
	 * Constructeur qui permet d'afficher tous les jeux vid�o en ordre des
	 * num�ros de jeux vid�o.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public ConsulterTousJeuxVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vid�o � afficher.";
		final String TITRE = "\nVoici la liste des jeux vid�o en ordre "
				+ "croissant des num�ros de jeux vid�o.";
		final String QUEST_CONTINUER = "\nAppuyez sur Entr�e pour continuer.";

		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3.
		 */

		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		} else {
			JeuVideo jeuVideo;

			System.out.println(TITRE);

			for (int indJeu1 = 0; indJeu1 < tabJeuxVideo.taille(); ++indJeu1) {
				jeuVideo = tabJeuxVideo.obtenirJeuVideo(indJeu1);
				jeuVideo.afficherJeuVideo();

				// Aussi
				// tabJeuxVideo.obtenirJeuVideo( indJeu1).afficherJeuVideo();

				OutilsLecture.lireEntree(QUEST_CONTINUER);
			}

			System.out.println("\nIl y a " + tabJeuxVideo.taille()
					+ " jeu(x) dans la liste. ");
		}

	}
}