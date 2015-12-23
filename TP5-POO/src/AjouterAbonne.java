/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : AjouterAbonne.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterAbonne permet de faire des ajouts d'abonn�s dans la
 * biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class AjouterAbonne implements OutilsConstantes {

	/**
	 * Le constructeur AjouterAbonne() permet de g�rer les ajouts d'abonn�s dans
	 * la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public AjouterAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter un abonn�."
				+ " Le nombre maximum d'abonn�s est atteint.";
		final String TITRE = "\nAjout d'un abonn�.";
		final String MESS_DEVENU_PLEIN = "\nAjout termin�. Le nombre maximum "
				+ "d'abonn�s est atteint.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous ajouter "
				+ "un autre abonn� (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estPlein()) {
			System.out.println(MESS_PLEIN);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);
				// si l'abonn� est pr�sent
				if (indiceAb != -1) {
					System.out.println("\nImpossible, l'abonn� avec le numero "
							+ abonne.getNoAbonne() + " existe d�j�\n");
				} else {
					abonne.lireAutresRenseignements();

					// Ajouter l'objet abonne dans le tableau des abonnes
					bibliotheque.getTabAbonnes().ajouter(abonne);

					System.out.println("\nL'abonn� " + abonne.getNoAbonne()
							+ " a �t� ajout�");
				}

				// Avons-nous atteint le maximum des abonn�s ?

				if (bibliotheque.getTabAbonnes().estPlein()) {
					System.out.println(MESS_DEVENU_PLEIN);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);
				}
			} while (rep == OUI);
		}
	}
}