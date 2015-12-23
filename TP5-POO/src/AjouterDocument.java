/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : AjouterDocument.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterDocument permet de faire des ajouts de documents dans la
 * biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class AjouterDocument implements OutilsConstantes {

	/**
	 * Le constructeur AjouterDocument() permet de g�rer les ajouts de documents
	 * dans la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public AjouterDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter un document."
				+ " Le nombre maximum de documents est atteint.";
		final String TITRE = "\nAjout d'un document.";
		final String MESS_DEVENU_PLEIN = "\nAjout termin�. Le nombre maximum "
				+ "de documents est atteint.";
		final String QUEST_AUTRE_DOCUMENT = "\nVoulez-vous ajouter "
				+ "un autre document (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabDocuments().estPlein()) {
			System.out.println(MESS_PLEIN);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP5.
				 */
				Document docTemporaire = Document.creerDocument();

				docTemporaire.lireCote();

				int indiceDocTemp = bibliotheque.getTabDocuments().chercher(
						docTemporaire);
				if (indiceDocTemp != -1) {
					System.out.println("\nle document "
							+ docTemporaire.getCote() + " existe d�j�");
				} else {
					char type = OutilsLecture.lireCaractereDisparate(
							docTemporaire.QUEST_TYPE_BASE,
							docTemporaire.TYPES_BASE_DOCUMENT);

					Document document = Document.creerDocument(type);
					document.setCote(docTemporaire.getCote());

					document.lireAutresRenseignements();

					bibliotheque.getTabDocuments().ajouter(document);
					System.out.println("\nle document avec le num�ro de cote "
							+ document.getCote() + " a �t� ajout�");
				}

				// Avons-nous atteint le maximum de documents ?

				if (bibliotheque.getTabDocuments().estPlein()) {
					System.out.println(MESS_DEVENU_PLEIN);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_DOCUMENT);
				}
			} while (rep == OUI);
		}
	}
}