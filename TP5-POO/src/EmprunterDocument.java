/**
 * Auteurs : François Mathieu et Soti
 * Fichier : EmprunterDocument.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe EmprunterDocument permet d'emprunter des documents de la
 * bibliothèque. Cette classe implémente l'interface OutilsConstantes.
 */

public class EmprunterDocument implements OutilsConstantes {

	/**
	 * Le constructeur EmprunterDocument() permet d'emprunter des documents de
	 * la bibliothèque. On emprunte un document qui n'a pas déjà été prêté.
	 * 
	 * @param bibliotheque
	 *            L'objet qui gère la bibliothèque.
	 */

	public EmprunterDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_DOC_VIDE = "\nImpossible d'emprunter un document."
				+ " Il n'y a aucun document dans la bibliothèque.";
		final String MESS_TOUS_PRETES = "\nImpossible d'emprunter un document."
				+ " Tous les documents sont prêtés.";
		final String MESS_ABONNE_VIDE = "\nImpossible d'emprunter un document."
				+ " Il n'y a aucun abonné dans la bibliothèque.";
		final String TITRE = "\nPrêt d'un document.";
		final String MESS_FIN_PRET = "\nIl ne reste plus de documents"
				+ " à prêter.";
		final String QUEST_AUTRE_PRET = "\nVoulez-vous emprunter"
				+ " un autre document (O ou N) ? ";

		// Variables locales.
		char rep = NON;

		if (bibliotheque.getTabDocuments().estVide()) {

			System.out.println(MESS_DOC_VIDE);

		} else if (bibliotheque.getTabPrets().taille() == bibliotheque
				.getTabDocuments().taille()) {

			System.out.println(MESS_TOUS_PRETES);

		} else if (bibliotheque.getTabAbonnes().estVide()) {

			System.out.println(MESS_ABONNE_VIDE);

		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (À COMPLÉTER). Voir pages 15 et 16 de l'énoncé du TP5.
				 */
				Document document = Document.creerDocument();

				document.lireCote();

				int indiceDoc = bibliotheque.getTabDocuments().chercher(
						document);

				if (indiceDoc == -1) {
					System.out.println("Le document " + document.getCote()
							+ " n'existe pas");
				} else {
					// À vérifier comme ailleurs -- P14
					Pret pret = new Pret(document.getCote());

					int indicePret = bibliotheque.getTabPrets().chercher(pret);

					if (indicePret != -1) {
						System.out.println("le document " + document.getCote()
								+ " est déjà prêté");
					} else {
						Abonne abonne = new Abonne();

						abonne.lireNoAbonne();

						int indiceAb = bibliotheque.getTabAbonnes().chercher(
								abonne);

						if (indiceAb == -1) {
							System.out.println("L'abonné "
									+ abonne.getNoAbonne() + " n'existe pas");
						} else {
							abonne = (Abonne) bibliotheque.getTabAbonnes()
									.obtenirObjet(indiceAb);
							if (abonne.getTabDocsAb().estPlein()) {
								System.out.println("L'abonné "
										+ abonne.getNoAbonne()
										+ " a atteint le maximum de prêts");
							} else {
								pret.setNoAbonne(abonne.getNoAbonne());

								bibliotheque.getTabPrets().ajouter(pret);
								document = (Document) bibliotheque
										.getTabDocuments().obtenirObjet(
												indiceDoc);

								document.setDisponible(false);
								abonne.getTabDocsAb().ajouter(document);

								System.out.println("\nle document "
										+ document.getCote()
										+ " a été prêté à l'abonné "
										+ abonne.getNoAbonne());
							}
						}
					}
				}

				// Reste-t-il des documents qui ne sont pas prêtés ?

				if (bibliotheque.getTabPrets().taille() == bibliotheque
						.getTabDocuments().taille()) {

					System.out.println(MESS_FIN_PRET);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_PRET);
				}
			} while (rep == OUI);
		}
	}
}