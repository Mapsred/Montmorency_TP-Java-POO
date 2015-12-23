/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : SupprimerAbonne.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerAbonne permet de faire des suppressions d'abonn�s dans la
 * biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class SupprimerAbonne implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerAbonne() permet de g�rer les suppressions
	 * d'abonn�s dans la biblioth�que. On ne peut pas supprimer un abonn� qui
	 * est en possession de documents.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public SupprimerAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer un abonn�."
				+ " Il n'y a aucun abonn� dans la biblioth�que.";
		final String TITRE = "\nSuppression d'un abonn�.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous "
				+ "supprimer cet abonn� (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression termin�e. Il ne reste"
				+ " plus d'abonn�s dans la biblioth�que.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous supprimer "
				+ "un autre abonn� (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);

				if (indiceAb == -1) {
					System.out.println("L'abonn� " + abonne.getNoAbonne()
							+ " n'existe pas");

				} else {
					// � v�rifier comme dans ConsulterAbonn�
					abonne = (Abonne) bibliotheque.getTabAbonnes()
							.obtenirObjet(indiceAb);

					if (!abonne.getTabDocsAb().estVide()) {
						System.out.println("L'abonn�" + abonne.getNoAbonne()
								+ " est en possession de documents");
					} else {
						abonne.afficher();

						char confirmation = OutilsLecture
								.lireOuiNon(QUEST_AUTRE_ABONNE);

						if (confirmation == 'O') {
							bibliotheque.getTabAbonnes().supprimer(abonne);

							System.out.println("L'abonn� "
									+ abonne.getNoAbonne() + " a �t� supprim�");
						} else {
							System.out.println("L'abonn� "
									+ abonne.getNoAbonne()
									+ " n'a pas �t� supprim�");
						}
					}
				}

				// Reste-t-il des abonn�s dans la biblioth�que ?

				if (bibliotheque.getTabAbonnes().estVide()) {

					System.out.println(MESS_DEVENU_VIDE);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);
				}

			} while (rep == OUI);
		}
	}
}