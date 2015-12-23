// Auteurs : François Mathieu et Soti
// Fichier : ModifierJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ModifierJeuVideo permet de modifier des jeux vidéo.
 */

public class ModifierJeuVideo {

	/**
	 * Constructeur qui permet de modifier un jeu vidéo tant que l'utilisateur
	 * le désire.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public ModifierJeuVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String TITRE_MODIFIER = "\nModifier un jeu vidéo.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à modifier.";
		final String QUEST_CONF_MODIF = "\nVoulez-vous vraiment "
				+ "modifier ce jeu vidéo (O ou N) ? ";
		final String QUEST_AUTRE_MODIFICATION = "\nVoulez-vous modifier "
				+ "un autre jeu vidéo (O ou N) ? ";

		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3.
		 * 
		 * N'oubliez-pas d'également compléter la méthode menuModifierJeuVideo()
		 * plus loin dans ce fichier.
		 */

		char rep = 'N';
		JeuVideo jeuVideo;
		int indTrouve;

		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		} else {
			do {
				System.out.println(TITRE_MODIFIER);

				jeuVideo = new JeuVideo(); // un objet JeuVideo de base

				jeuVideo.lireNoJeuVideo();

				indTrouve = tabJeuxVideo.chercher(jeuVideo);

				if (indTrouve == -1) {
					// le jeu video n'est pas présent
					System.out.println("Le jeu vidéo avec le numéro "
							+ jeuVideo.getNoJeuVideo() + " n'est pas présent");

				} else {
					// Le jeu vidéo est présent

					// Obtenir et afficher le jeu vidéo et demander également
					// Une confirmation avant de le modifier

					jeuVideo = tabJeuxVideo.obtenirJeuVideo(indTrouve);

					jeuVideo.afficherJeuVideo();

					rep = OutilsLecture.lireOuiNon(QUEST_CONF_MODIF);

					if (rep == 'O') {
						this.menuModifierJeuVideo(jeuVideo);
					} else {
						System.out
								.println("\nLa modification du jeu video numéro "
										+ jeuVideo.getNoJeuVideo()
										+ " a été annulée");
					}
				}
				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_MODIFICATION);
			} while (rep == 'O');
		}

	}

	/**
	 * La méthode privée menuModifierJeuVideo() permet de modifier les
	 * renseignements du jeu vidéo reçu en paramètre avec l'aide d'un menu. Il
	 * n'est pas possible de modifier le numéro du jeu vidéo.
	 */

	private void menuModifierJeuVideo(JeuVideo jeuVideo) {
		// Choix du sous-menu pour modifier.
		final char MODIF_TITRE = '1';
		final char MODIF_PRIX = '2';
		final char QUITTER_MENU_MODIF = '3';

		String texteMenuModifier;

		char choix = '\0';

		do {
			// Les valeurs font partie du texte du menu.
			// Le texte du menu est donc fabriqué à chaque fois.

			texteMenuModifier = "\nMenu pour la modification d'un "
					+ "jeu vidéo\n\nNuméro du jeu vidéo : "
					+ jeuVideo.getNoJeuVideo() + "\n\n"
					+ "1. Modifier le titre :\t" + jeuVideo.getTitre() + "\n"
					+ "2. Modifier le prix :\t"
					+ OutilsAffichage.formaterMonetaire(jeuVideo.getPrix(), 2)
					+ "\n" + "3. Quitter ce menu";

			/*
			 * TODO (À COMPLÉTER). Voir en bas de la page 5 de l'énoncé du TP3.
			 */
			choix = OutilsAffichage.afficherChoisirMenu(texteMenuModifier,
					MODIF_TITRE, QUITTER_MENU_MODIF);

			switch (choix) {
			case MODIF_TITRE:
				jeuVideo.lireTitre();
				break;

			case MODIF_PRIX:
				jeuVideo.lirePrix();
				break;

			case QUITTER_MENU_MODIF:
				System.out
						.println("\nFin de la modification de l'employé numéro"
								+ jeuVideo.getNoJeuVideo() + ".\n");
			}

		} while (choix != QUITTER_MENU_MODIF);
	}
}