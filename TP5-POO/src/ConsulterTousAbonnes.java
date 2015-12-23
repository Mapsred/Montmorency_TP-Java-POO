/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : ConsulterTousAbonnes.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousAbonnes permet de faire la consultation de tous les
 * abonn�s de la biblioth�que. Cette classe impl�mente l'interface
 * OutilsConstantes.
 */

public class ConsulterTousAbonnes implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousAbonnes() permet de consulter tous les
	 * abonn�s de la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public ConsulterTousAbonnes(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous les abonn�s."
				+ " Il n'y a aucun abonn� dans la biblioth�que.";
		final String TITRE = "\nVoici les informations de tous les abonn�s"
				+ " de la biblioth�que.";

		/**
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP5.
		 */
		Abonne abonne = new Abonne();
		int i;
		if (bibliotheque.getTabAbonnes().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			System.out.println(TITRE);

			for (i = 0; i < bibliotheque.getTabAbonnes().taille(); i++) {
				// � v�rifier comme pour ConsulterAbonn�
				abonne = (Abonne) bibliotheque.getTabAbonnes().obtenirObjet(i);

				abonne.afficher();

				OutilsLecture.lireEntree(QUEST_CONTINUER);
			}

			System.out.println("Nombre d'abonn�s ont �t� consult�s : " + i);

		}

	}
}