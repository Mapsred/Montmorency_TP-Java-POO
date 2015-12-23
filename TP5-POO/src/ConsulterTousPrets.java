/**
 * Auteurs : François Mathieu et Soti
 * Fichier : ConsulterTousPrets.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousPrets permet de consulter tous les prêts de documents.
 * Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterTousPrets implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousPrets() permet de consulter tous les prêts
	 * de documents.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public ConsulterTousPrets(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous les prêts."
				+ " Il n'y a aucun prêt d'effectué.";
		final String TITRE = "\nVoici les informations de tous les prêts.";

		/**
		 * TODO (À COMPLÉTER). Voir page 14 de l'énoncé du TP5.
		 */
		int i = 0;
		if (bibliotheque.getTabPrets().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			System.out.println(TITRE);

			for (i = 0; i < bibliotheque.getTabPrets().taille(); i++) {
				// À vérifier comme ailleurs
				Pret pret = (Pret) bibliotheque.getTabPrets().obtenirObjet(i);

				pret.afficher();

				OutilsLecture.lireEntree(QUEST_CONTINUER);

			}

			System.out.println("\nNombre de prêts consultés : " + i);
		}

	}
}