/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : ConsulterDocument.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterDocument permet de faire des consultations de documents de
 * la biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterDocument implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterDocument() permet de g�rer les consultations de
	 * documents de la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public ConsulterDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter un document."
				+ " Il n'y a aucun document dans la biblioth�que.";
		final String TITRE = "\nConsultation d'un document.";
		final String QUEST_AUTRE_DOCUMENT = "\nVoulez-vous consulter "
				+ "un autre document (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabDocuments().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP5.
				 */
				Document document = Document.creerDocument();

				document.lireCote();

				int indiceDoc = bibliotheque.getTabDocuments().chercher(
						document);

				if (indiceDoc == -1) {
					System.out.println("\nLe document " + document.getCote()
							+ " n'existe pas");
				} else {
					document = (Document) bibliotheque.getTabDocuments()
							.obtenirObjet(indiceDoc);

					document.afficher();
				}

				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_DOCUMENT);

			} while (rep == OUI);
		}
	}
}