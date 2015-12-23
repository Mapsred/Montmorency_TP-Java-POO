/**
 * Auteurs : François Mathieu et Soti
 * Fichier : ConsulterPret.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterPret permet de consulter des prêts de documents. Cette
 * classe implémente l'interface OutilsConstantes.
 */

public class ConsulterPret implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterPret() permet de consulter des prêts de
	 * documents.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public ConsulterPret(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter un prêt."
				+ " Il n'y a aucun prêt d'effectué.";
		final String TITRE = "\nConsultation d'un prêt de document.";
		final String QUEST_AUTRE_PRET = "\nVoulez-vous consulter "
				+ "un autre prêt (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabPrets().estVide()) {

			System.out.println(MESS_VIDE);

		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (À COMPLÉTER). Voir page 14 de l'énoncé du TP5.
				 */
				Document document = Document.creerDocument();

				document.lireCote();

				int indiceDoc = bibliotheque.getTabDocuments().chercher(
						document);

				if (indiceDoc == -1) {
					System.out.println("\nLe document avec le numéro de cote"
							+ document.getCote() + " n'existe pas");
				} else {
					Pret pret = new Pret(document.getCote());

					int indicePret = bibliotheque.getTabPrets().chercher(pret);

					if (indicePret == -1) {
						System.out.println("Le document " + document.getCote()
								+ " n'est pas prêté");
					} else {
						pret = (Pret) bibliotheque.getTabPrets().obtenirObjet(
								indicePret);

						pret.afficher();
					}
				}

				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_PRET);

			} while (rep == OUI);
		}
	}
}