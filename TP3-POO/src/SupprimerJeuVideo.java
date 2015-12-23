// Auteurs : François Mathieu et Soti
// Fichier : SupprimerJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

import javax.swing.text.TabExpander;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerJeuVideo permet de supprimer des jeux vidéo.
 */

public class SupprimerJeuVideo {

	/**
	 * Constructeur qui permet de supprimer un jeu vidéo tant que l'utilisateur
	 * le désire.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public SupprimerJeuVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String TITRE_SUPPRIMER = "\nSupprimer un jeu vidéo.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à supprimer.";
		final String MESS_DEVENU_VIDE = "\nSuppression terminée. "
				+ "Il ne reste plus de jeux vidéo à supprimer.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous vraiment "
				+ "supprimer ce jeu vidéo (O ou N) ? ";
		final String QUEST_AUTRE_SUPP = "\nVoulez-vous supprimer "
				+ "un autre jeu vidéo (O ou N) ? ";

		char rep = 'N';
		JeuVideo jeuVideo;
		int indTrouve;

		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		} else {
			do {
				System.out.println(TITRE_SUPPRIMER);

				jeuVideo = new JeuVideo();

				jeuVideo.lireNoJeuVideo();

				indTrouve = tabJeuxVideo.chercher(jeuVideo);

				if (indTrouve == -1) {
					// Le jeu video n'est pas présent
					System.out.println("Le jeu vidéo avec le numéro "
							+ jeuVideo.getNoJeuVideo() + " n'est pas présent");
				} else {
					// Le jeu vidéo est présent

					// obtenir et afficher le jeu video et demander également
					// une confirmation avant de le supprimer

					jeuVideo = tabJeuxVideo.obtenirJeuVideo(indTrouve);
					jeuVideo.afficherJeuVideo();

					rep = OutilsLecture.lireOuiNon(QUEST_CONF_SUPP);

					if (rep == 'O') {
						tabJeuxVideo.supprimer(indTrouve);

						System.out.println("\nLe jeu vidéo avec le numéro "
								+ jeuVideo.getNoJeuVideo() + " a été supprimé");
					} else {
						System.out
								.println("\nLa suppression du jeu vidéo numéro"
										+ jeuVideo.getNoJeuVideo()
										+ " a été annulée");
					}
				}

				// Reste t'il des jeux vidéos à supprimer ?

				if (tabJeuxVideo.estVide()) {
					System.out.println(MESS_DEVENU_VIDE);
					rep = 'N'; // ne pas supprimer d'autres jeux vidéos
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_SUPP);
				}

			} while (rep == 'O');
		}
		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3.
		 */

	}
}