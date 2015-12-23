/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : ConsulterTousPrets.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousPrets permet de consulter tous les pr�ts de documents.
 * Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterTousPrets implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousPrets() permet de consulter tous les pr�ts
	 * de documents.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	public ConsulterTousPrets(Bibliotheque bibliotheque) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous les pr�ts."
				+ " Il n'y a aucun pr�t d'effectu�.";
		final String TITRE = "\nVoici les informations de tous les pr�ts.";

		/**
		 * TODO (� COMPL�TER). Voir page 14 de l'�nonc� du TP5.
		 */
		int i = 0;
		if (bibliotheque.getTabPrets().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			System.out.println(TITRE);

			for (i = 0; i < bibliotheque.getTabPrets().taille(); i++) {
				// � v�rifier comme ailleurs
				Pret pret = (Pret) bibliotheque.getTabPrets().obtenirObjet(i);

				pret.afficher();

				OutilsLecture.lireEntree(QUEST_CONTINUER);

			}

			System.out.println("\nNombre de pr�ts consult�s : " + i);
		}

	}
}