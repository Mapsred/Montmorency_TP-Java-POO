/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : ConsulterAbonne.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterAbonne permet de faire des consultations d'abonn�s dans la
 * biblioth�que. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterAbonne implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterAbonne() permet de g�rer les consultations
	 * d'abonn�s dans la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public ConsulterAbonne(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter un abonn�."
				+ " Il n'y a aucun abonn� dans la biblioth�que.";
		final String TITRE = "\nConsultation d'un abonn�.";
		final String QUEST_AUTRE_ABONNE = "\nVoulez-vous consulter "
				+ "un autre abonn� (O ou N) ? ";

		char rep = NON;

		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {

			do {
				System.out.println(TITRE);

				/**
				 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP5.
				 */
				Abonne abonne = new Abonne();
				abonne.lireNoAbonne();
				int indiceAb = bibliotheque.getTabAbonnes().chercher(abonne);
				if (indiceAb == -1) {
					System.out.println("L'abonn� " + abonne.getNoAbonne()
							+ " n'existe pas\n");
				} else {
					// � v�rifier
					abonne = (Abonne) bibliotheque.getTabAbonnes()
							.obtenirObjet(indiceAb);

					abonne.afficher();
				}

				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_ABONNE);

			} while (rep == OUI);
		}
	}
}