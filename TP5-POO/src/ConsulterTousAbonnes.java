/**
 * Auteurs : François Mathieu et Soti
 * Fichier : ConsulterTousAbonnes.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousAbonnes permet de faire la consultation de tous les
 * abonnés de la bibliothèque. Cette classe implémente l'interface
 * OutilsConstantes.
 */

public class ConsulterTousAbonnes implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousAbonnes() permet de consulter tous les
	 * abonnés de la bibliothèque.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public ConsulterTousAbonnes(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous les abonnés."
				+ " Il n'y a aucun abonné dans la bibliothèque.";
		final String TITRE = "\nVoici les informations de tous les abonnés"
				+ " de la bibliothèque.";

		/**
		 * TODO (À COMPLÉTER). Voir page 9 de l'énoncé du TP5.
		 */
		Abonne abonne = new Abonne();
		int i;
		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			System.out.println(TITRE);

			for (i = 0; i < bibliotheque.getTabAbonnes().taille(); i++) {
				// À vérifier comme pour ConsulterAbonné
				abonne = (Abonne) bibliotheque.getTabAbonnes().obtenirObjet(i);

				abonne.afficher();

				OutilsLecture.lireEntree(QUEST_CONTINUER);
			}

			System.out.println("Nombre d'abonnés ont été consultés : " + i);

		}

	}
}