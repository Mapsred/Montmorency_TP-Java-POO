/**
 * Auteurs : François Mathieu et Soti
 * Fichier : SupprimerAbonne.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerAbonne permet de faire des suppressions d'abonnés dans la
 * bibliothèque. Cette classe implémente l'interface OutilsConstantes.
 */

public class SupprimerAbonne implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerAbonne() permet de gérer les suppressions
	 * d'abonnés dans la bibliothèque. On ne peut pas supprimer un abonné qui
	 * est en possession de documents.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public SupprimerAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer un abonné."
				+ " Il n'y a aucun abonné dans la bibliothèque.";
		final String TITRE = "\nSuppression d'un abonné.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous "
				+ "supprimer cet abonné (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression terminée. Il ne reste"
				+ " plus d'abonnés dans la bibliothèque.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous supprimer "
				+ "un autre abonné (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);

				if (indiceAb == -1) {
					System.out.println("L'abonné " + abonne.getNoAbonne()
							+ " n'existe pas");

				} else {
					// À vérifier comme dans ConsulterAbonné
					abonne = (Abonne) bibliotheque.getTabAbonnes()
							.obtenirObjet(indiceAb);

					if (!abonne.getTabDocsAb().estVide()) {
						System.out.println("L'abonné" + abonne.getNoAbonne()
								+ " est en possession de documents");
					} else {
						abonne.afficher();

						char confirmation = OutilsLecture
								.lireOuiNon(QUEST_AUTRE_ABONNE);

						if (confirmation == 'O') {
							bibliotheque.getTabAbonnes().supprimer(abonne);

							System.out.println("L'abonné "
									+ abonne.getNoAbonne() + " a été supprimé");
						} else {
							System.out.println("L'abonné "
									+ abonne.getNoAbonne()
									+ " n'a pas été supprimé");
						}
					}
				}

				// Reste-t-il des abonnés dans la bibliothèque ?

				if (bibliotheque.getTabAbonnes().estVide()) {

					System.out.println(MESS_DEVENU_VIDE);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);
				}

			} while (rep == OUI);
		}
	}
}