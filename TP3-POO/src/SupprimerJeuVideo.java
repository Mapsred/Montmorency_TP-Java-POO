// Auteurs : Fran�ois Mathieu et Soti
// Fichier : SupprimerJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

import javax.swing.text.TabExpander;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerJeuVideo permet de supprimer des jeux vid�o.
 */

public class SupprimerJeuVideo {

	/**
	 * Constructeur qui permet de supprimer un jeu vid�o tant que l'utilisateur
	 * le d�sire.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public SupprimerJeuVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String TITRE_SUPPRIMER = "\nSupprimer un jeu vid�o.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vid�o � supprimer.";
		final String MESS_DEVENU_VIDE = "\nSuppression termin�e. "
				+ "Il ne reste plus de jeux vid�o � supprimer.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous vraiment "
				+ "supprimer ce jeu vid�o (O ou N) ? ";
		final String QUEST_AUTRE_SUPP = "\nVoulez-vous supprimer "
				+ "un autre jeu vid�o (O ou N) ? ";

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
					// Le jeu video n'est pas pr�sent
					System.out.println("Le jeu vid�o avec le num�ro "
							+ jeuVideo.getNoJeuVideo() + " n'est pas pr�sent");
				} else {
					// Le jeu vid�o est pr�sent

					// obtenir et afficher le jeu video et demander �galement
					// une confirmation avant de le supprimer

					jeuVideo = tabJeuxVideo.obtenirJeuVideo(indTrouve);
					jeuVideo.afficherJeuVideo();

					rep = OutilsLecture.lireOuiNon(QUEST_CONF_SUPP);

					if (rep == 'O') {
						tabJeuxVideo.supprimer(indTrouve);

						System.out.println("\nLe jeu vid�o avec le num�ro "
								+ jeuVideo.getNoJeuVideo() + " a �t� supprim�");
					} else {
						System.out
								.println("\nLa suppression du jeu vid�o num�ro"
										+ jeuVideo.getNoJeuVideo()
										+ " a �t� annul�e");
					}
				}

				// Reste t'il des jeux vid�os � supprimer ?

				if (tabJeuxVideo.estVide()) {
					System.out.println(MESS_DEVENU_VIDE);
					rep = 'N'; // ne pas supprimer d'autres jeux vid�os
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_SUPP);
				}

			} while (rep == 'O');
		}
		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3.
		 */

	}
}