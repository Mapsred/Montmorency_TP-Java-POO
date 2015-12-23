// Auteurs : Fran�ois Mathieu et Soti
// Fichier : ModifierJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ModifierJeuVideo permet de modifier des jeux vid�o.
 */

public class ModifierJeuVideo {

	/**
	 * Constructeur qui permet de modifier un jeu vid�o tant que l'utilisateur
	 * le d�sire.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public ModifierJeuVideo(TabJeuxVideo tabJeuxVideo) {
		// Constantes.
		final String TITRE_MODIFIER = "\nModifier un jeu vid�o.";
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vid�o � modifier.";
		final String QUEST_CONF_MODIF = "\nVoulez-vous vraiment "
				+ "modifier ce jeu vid�o (O ou N) ? ";
		final String QUEST_AUTRE_MODIFICATION = "\nVoulez-vous modifier "
				+ "un autre jeu vid�o (O ou N) ? ";

		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3.
		 * 
		 * N'oubliez-pas d'�galement compl�ter la m�thode menuModifierJeuVideo()
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
					// le jeu video n'est pas pr�sent
					System.out.println("Le jeu vid�o avec le num�ro "
							+ jeuVideo.getNoJeuVideo() + " n'est pas pr�sent");

				} else {
					// Le jeu vid�o est pr�sent

					// Obtenir et afficher le jeu vid�o et demander �galement
					// Une confirmation avant de le modifier

					jeuVideo = tabJeuxVideo.obtenirJeuVideo(indTrouve);

					jeuVideo.afficherJeuVideo();

					rep = OutilsLecture.lireOuiNon(QUEST_CONF_MODIF);

					if (rep == 'O') {
						this.menuModifierJeuVideo(jeuVideo);
					} else {
						System.out
								.println("\nLa modification du jeu video num�ro "
										+ jeuVideo.getNoJeuVideo()
										+ " a �t� annul�e");
					}
				}
				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_MODIFICATION);
			} while (rep == 'O');
		}

	}

	/**
	 * La m�thode priv�e menuModifierJeuVideo() permet de modifier les
	 * renseignements du jeu vid�o re�u en param�tre avec l'aide d'un menu. Il
	 * n'est pas possible de modifier le num�ro du jeu vid�o.
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
			// Le texte du menu est donc fabriqu� � chaque fois.

			texteMenuModifier = "\nMenu pour la modification d'un "
					+ "jeu vid�o\n\nNum�ro du jeu vid�o : "
					+ jeuVideo.getNoJeuVideo() + "\n\n"
					+ "1. Modifier le titre :\t" + jeuVideo.getTitre() + "\n"
					+ "2. Modifier le prix :\t"
					+ OutilsAffichage.formaterMonetaire(jeuVideo.getPrix(), 2)
					+ "\n" + "3. Quitter ce menu";

			/*
			 * TODO (� COMPL�TER). Voir en bas de la page 5 de l'�nonc� du TP3.
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
						.println("\nFin de la modification de l'employ� num�ro"
								+ jeuVideo.getNoJeuVideo() + ".\n");
			}

		} while (choix != QUITTER_MENU_MODIF);
	}
}