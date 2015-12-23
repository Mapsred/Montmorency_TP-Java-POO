/**
 * Auteurs : François Mathieu et Soti
 * Fichier : AjouterAbonne.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterAbonne permet de faire des ajouts d'abonnés dans la
 * bibliothèque. Cette classe implémente l'interface OutilsConstantes.
 */

public class AjouterAbonne implements OutilsConstantes {

	/**
	 * Le constructeur AjouterAbonne() permet de gérer les ajouts d'abonnés dans
	 * la bibliothèque.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public AjouterAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter un abonné."
				+ " Le nombre maximum d'abonnés est atteint.";
		final String TITRE = "\nAjout d'un abonné.";
		final String MESS_DEVENU_PLEIN = "\nAjout terminé. Le nombre maximum "
				+ "d'abonnés est atteint.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous ajouter "
				+ "un autre abonné (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estPlein()) {
			System.out.println(MESS_PLEIN);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);
				// si l'abonné est présent
				if (indiceAb != -1) {
					System.out.println("\nImpossible, l'abonné avec le numero "
							+ abonne.getNoAbonne() + " existe déjà\n");
				} else {
					abonne.lireAutresRenseignements();

					// Ajouter l'objet abonne dans le tableau des abonnes
					bibliotheque.getTabAbonnes().ajouter(abonne);

					System.out.println("\nL'abonné " + abonne.getNoAbonne()
							+ " a été ajouté");
				}

				// Avons-nous atteint le maximum des abonnés ?

				if (bibliotheque.getTabAbonnes().estPlein()) {
					System.out.println(MESS_DEVENU_PLEIN);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);
				}
			} while (rep == OUI);
		}
	}
}