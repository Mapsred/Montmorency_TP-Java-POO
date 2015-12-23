/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : SupprimerDocument.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerDocument permet de faire des suppressions de documents
 * dans la biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class SupprimerDocument implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerDocument() permet de g�rer les suppressions de
	 * documents dans la biblioth�que. On ne peut pas supprimer un document qui
	 * qui est pr�sentement pr�t�.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public SupprimerDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer un document."
				+ " Il n'y a aucun document dans la biblioth�que.";
		final String TITRE = "\nSuppression d'un document.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous "
				+ "supprimer ce document (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression termin�e. Il ne reste "
				+ "plus de documents dans la biblioth�que.";
		final String QUEST_AUTRE_DOCUMENT = "\nVoulez-vous supprimer "
				+ "un autre document (O ou N) ? ";

		// Variables locales.
		char rep = NON;

		if (bibliotheque.getTabDocuments().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 13 de l'�nonc� du TP5.
				 */
				Document document = Document.creerDocument();

				document.lireCote();

				int indiceDoc = bibliotheque.getTabDocuments().chercher(
						document);

				if (indiceDoc == -1) {
					System.out.println("Le document avec le numero de cote "
							+ document.getCote() + " n'existe pas");
				} else {
					Pret pret = new Pret(document.getCote());

					int indicePret = bibliotheque.getTabPrets().chercher(pret);

					if (indicePret != -1) {
						System.out
								.println("Le document avec le numero de cote "
										+ document.getCote()
										+ " est pr�sentement pr�t�");
					} else {
						document = (Document) bibliotheque.getTabDocuments()
								.obtenirObjet(indiceDoc);

						document.afficher();

						char confirmation = OutilsLecture
								.lireOuiNon(QUEST_CONF_SUPP);

						if (confirmation == 'O') {
							bibliotheque.getTabDocuments().supprimer(document);

							System.out
									.println("Le document avec le numero de cote "
											+ document.getCote()
											+ " a �t� supprim�");
						} else {
							System.out
									.println("Le document avec le numero de cote "
											+ document.getCote()
											+ " n'a pas pu �tre supprim�");
						}
					}
				}

				// Reste-t-il des documents dans la biblioth�que ?

				if (bibliotheque.getTabDocuments().estVide()) {

					System.out.println(MESS_DEVENU_VIDE);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_DOCUMENT);
				}
			} while (rep == OUI);
		}
	}
}