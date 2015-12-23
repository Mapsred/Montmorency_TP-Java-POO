/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : RetournerDocument.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe RetournerDocument permet de retourner des documents � la
 * biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class RetournerDocument implements OutilsConstantes {

	/**
	 * Le constructeur RetournerDocument() permet de retourner des documents �
	 * la biblioth�que. On retourne un document qui a d�j� �t� pr�t�.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public RetournerDocument(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_DOC_VIDE = "\nImpossible de retourner un document."
				+ " Il n'y a aucun document dans la biblioth�que.";
		final String MESS_AUCUN_PRET = "\nImpossible de retourner un document."
				+ " Il n'y aucun document de pr�t�.";
		final String TITRE = "\nRetour d'un document.";
		final String MESS_FIN_RETOUR = "\nIl ne reste plus de documents de"
				+ " pr�t�s.";
		final String QUEST_AUTRE_RETOUR = "\nVoulez-vous retourner"
				+ " un autre document (O ou N) ? ";

		// Variables locales.
		char rep = NON;

		if (bibliotheque.getTabDocuments().estVide()) {

			System.out.println(MESS_DOC_VIDE);

		} else if (bibliotheque.getTabPrets().estVide()) {

			System.out.println(MESS_AUCUN_PRET);

		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir pages 16 et 17 de l'�nonc� du TP5.
				 */
				Document document = Document.creerDocument();

				document.lireCote();

				int indiceDoc = bibliotheque.getTabDocuments().chercher(
						document);

				if (indiceDoc == -1) {
					System.out.println("le document avec le num�ro de cote"
							+ document.getCote() + " n'existe pas");
				} else {
					Pret pret = new Pret(document.getCote());

					int indicePret = bibliotheque.getTabPrets().chercher(pret);

					if (indicePret == -1) {
						System.out.println("Le documentavec le num�ro de cote "
								+ document.getCote() + " n'est pas pr�t�");
					} else {
						document = (Document) bibliotheque.getTabDocuments()
								.obtenirObjet(indiceDoc);

						document.setDisponible(true);
						pret = (Pret) bibliotheque.getTabPrets().obtenirObjet(
								indicePret);

						bibliotheque.getTabPrets().supprimer(indicePret);

						Abonne abonne = new Abonne();
						// � v�rifier
						abonne.setNoAbonne(pret.getNoAbonne());

						int indiceAb = bibliotheque.getTabAbonnes().chercher(
								abonne);

						abonne = (Abonne) bibliotheque.getTabAbonnes()
								.obtenirObjet(indiceAb);

						abonne.getTabDocsAb().supprimer(document);

						System.out
								.println("Le document avec le num�ro de cote "
										+ document.getCote()
										+ " pr�t� � l'abonn� "
										+ abonne.getNoAbonne()
										+ " a �t� retourn�  ");

					}

				}

				// Reste-t-il des documents de pr�t�s ?

				if (bibliotheque.getTabPrets().estVide()) {

					System.out.println(MESS_FIN_RETOUR);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_RETOUR);
				}
			} while (rep == OUI);
		}
	}
}