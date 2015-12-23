/**
 * Auteurs : François Mathieu et Soti
 * Fichier : AjouterDocument.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterDocument permet de faire des ajouts de documents dans la
 * bibliothèque. Cette classe implémente l'interface OutilsConstantes.
 */

public class AjouterDocument implements OutilsConstantes {

	/**
	 * Le constructeur AjouterDocument() permet de gérer les ajouts de documents
	 * dans la bibliothèque.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public AjouterDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter un document."
				+ " Le nombre maximum de documents est atteint.";
		final String TITRE = "\nAjout d'un document.";
		final String MESS_DEVENU_PLEIN = "\nAjout terminé. Le nombre maximum "
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
				 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP5.
				 */
				Document docTemporaire = Document.creerDocument();

				docTemporaire.lireCote();

				int indiceDocTemp = bibliotheque.getTabDocuments().chercher(
						docTemporaire);
				if (indiceDocTemp != -1) {
					System.out.println("\nle document "
							+ docTemporaire.getCote() + " existe déjà");
				} else {
					char type = OutilsLecture.lireCaractereDisparate(
							docTemporaire.QUEST_TYPE_BASE,
							docTemporaire.TYPES_BASE_DOCUMENT);

					Document document = Document.creerDocument(type);
					document.setCote(docTemporaire.getCote());

					document.lireAutresRenseignements();

					bibliotheque.getTabDocuments().ajouter(document);
					System.out.println("\nle document avec le numéro de cote "
							+ document.getCote() + " a été ajouté");
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