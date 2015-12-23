/**
 * Auteurs : François Mathieu et Soti
 * Fichier : ConsulterAbonne.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterAbonne permet de faire des consultations d'abonnés dans la
 * bibliothèque. Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterAbonne implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterAbonne() permet de gérer les consultations
	 * d'abonnés dans la bibliothèque.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public ConsulterAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter un abonné."
				+ " Il n'y a aucun abonné dans la bibliothèque.";
		final String TITRE = "\nConsultation d'un abonné.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous consulter "
				+ "un autre abonné (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);
				if (indiceAb == -1) {
					System.out.println("L'abonné " + abonne.getNoAbonne()
							+ " n'existe pas\n");
				} else {
					// À vérifier
					abonne = (Abonne) bibliotheque.getTabAbonnes()
							.obtenirObjet(indiceAb);

					abonne.afficher();
				}

				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);

			} while (rep == OUI);
		}
	}
}