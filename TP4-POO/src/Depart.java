/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : Depart.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Depart permet de g�rer les d�parts des clients de l'h�tel
 * Montmotel.
 */

public class Depart {

	/**
	 * Le constructeur permet de faire la gestion des d�parts des clients de
	 * l'h�tel Montmotel. Les clients payent et lib�rent des chambres de
	 * l'h�tel, tant qu'ils le d�sirent.
	 * 
	 * @param hotel
	 *            Objet qui g�re l'h�tel pour consulter et mettre � jour la
	 *            disponibilit� des chambres.
	 */

	public Depart(Hotel hotel) {
		// Constantes.
		final String TITRE_DEPART = "\nD�part d'un client.";
		final String MESS_VIDE = "\nAucun d�part possible, toutes les "
				+ "chambres de l'h�tel Montmotel sont libres.";
		final String MESS_DEVENU_VIDE = "\nToutes les chambres de l'h�tel "
				+ "Montmotel ont �t� lib�r�es.";
		final String MESS_MERCI = "\nMerci d'avoir s�journ� �"
				+ " l'h�tel Montmotel.";
		final String QUEST_AUTRE_DEPART = "\nVoulez-vous "
				+ "lib�rer une autre chambre (O ou N) ? ";

		char recommencer = 'N';
		int type, noChambre;

		if (hotel.estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			do {
				System.out.println(TITRE_DEPART);

				/*
				 * TODO (� COMPL�TER). Voir page 13 de l'�nonc� du TP4.
				 */
				type = Hotel.lireTypeChambre();

				if (hotel.typeVide(type)) {
					System.out.println(" Toutes les chambres pour le type "
							+ Hotel.TAB_TYPES[type] + " sont d�j� libres");
				} else {
					hotel.afficherDisponibilite(type);

					noChambre = Hotel.lireNoChambre();

					if (hotel.chambreDisponible(type, noChambre)) {
						System.out.println("La chambre num�ro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type] + " est d�j� libre.");
					} else {
						hotel.libererChambre(type, noChambre);

						System.out.println("La chambre num�ro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " est maintenant libre.");

						System.out.println(MESS_MERCI);
					}
				}

				// Les chambres de l'h�tel ont-elles �t� toutes lib�r�es ?
				if (hotel.estVide()) {
					System.out.println(MESS_DEVENU_VIDE);
					recommencer = 'N';
				} else {
					recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_DEPART);
				}
			} while (recommencer == 'O');
		}
	}
}