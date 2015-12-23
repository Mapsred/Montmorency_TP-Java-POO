/**
 * Auteurs : François Mathieu et Soti
 * Fichier : ConsulterTousDocuments.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousDocuments permet de faire la consultation de tous les
 * documents de la bibliothèque. Cette classe implémente l'interface
 * OutilsConstantes.
 */

public class ConsulterTousDocuments implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousDocuments() permet de consulter tous les
	 * documents de la bibliothèque. On peut consulter tous les documents, tous
	 * les livres, tous les périodiques ou tous les DVD.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public ConsulterTousDocuments(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous"
				+ " les documents. Il n'y a aucun document dans"
				+ " la bibliothèque.";
		final String TITRE = "\nVoici les informations de tous les "
				+ "documents demandés.";

		/**
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP5.
		 */
		if (bibliotheque.getTabDocuments().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			char type = OutilsLecture
					.lireCaractereDisparate(Document.QUEST_TYPE_CONSULTER,
							Document.TYPES_DOC_CONSULTER);

			System.out.println(TITRE);

			int doc = 0;

			for (int i = 0; i < bibliotheque.getTabDocuments().taille(); i++) {

				Document docCourant = (Document) bibliotheque.getTabDocuments()
						.obtenirObjet(i);

				if (type == Document.TOUS || type == docCourant.obtenirType()) {
					doc++;

					docCourant.afficher();

					OutilsLecture.lireEntree(QUEST_CONTINUER);
				}

			}
			System.out.println("\nNombre de documents consultés : " + doc);
		}

	}
}