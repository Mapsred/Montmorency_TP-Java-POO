// Auteurs : François Mathieu et Soti
// Fichier : ConsulterTousJeuxVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousJeuxVideo permet d'afficher tous les jeux vidéo.
 */

public class ConsulterTousJeuxVideo {

	/**
	 * Constructeur qui permet d'afficher tous les jeux vidéo en ordre des
	 * numéros de jeux vidéo.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public ConsulterTousJeuxVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à afficher.";
		final String TITRE = "\nVoici la liste des jeux vidéo en ordre "
				+ "croissant des numéros de jeux vidéo.";
		final String QUEST_CONTINUER = "\nAppuyez sur Entrée pour continuer.";

		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3.
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