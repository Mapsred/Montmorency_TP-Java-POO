/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : Arrivee.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Arrivee permet de g�rer les arriv�es des clients � l'h�tel. Les
 * clients r�servent des chambres de l'h�tel.
 */
public class Arrivee {

	/**
	 * Le constructeur permet de faire la gestion des arriv�es des clients �
	 * l'h�tel. Les clients r�servent des chambres de l'h�tel, tant qu'ils le
	 * d�sirent.
	 * 
	 * @param hotel
	 *            Objet qui g�re l'h�tel pour consulter et mettre � jour la
	 *            disponibilit� des chambres.
	 */

	public Arrivee(Hotel hotel) {
		// Constantes.
		final String TITRE_ARRIVEE = "\nArriv�e d'un client.";
		final String MESS_PLEIN = "\nD�sol�, il n'y a aucune chambre de libre"
				+ " � l'h�tel Montmotel.";
		final String MESS_DEVENU_PLEIN = "\nIl ne reste plus de chambres"
				+ " de disponibles � l'h�tel Montmotel.";
		final String MESS_BEAU_SEJOUR = "\nPassez un beau s�jour �"
				+ " l'h�tel Montmotel.";
		final String QUEST_AUTRE_ARRIVEE = "\nVoulez-vous "
				+ "r�server une autre chambre (O ou N) ? ";

		char recommencer = 'N';

		if (hotel.estPlein()) {
			System.out.println(MESS_PLEIN);
		} else {
			do {
				System.out.println(TITRE_ARRIVEE);

				/*
				 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
				 */
				int type = Hotel.lireTypeChambre();

				if (hotel.typePlein(type)) {
					System.out.println("Il n'y a aucune chambre de libre"
							+ " pour le type " + Hotel.TAB_TYPES[type]);
				} else {
					hotel.afficherDisponibilite(type);

					int noChambre = Hotel.lireNoChambre();

					if (!hotel.chambreDisponible(type, noChambre)) {
						System.out.println("\n D�sol�, La chambre num�ro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " n'est pas disponible.");
					} else {
						hotel.reserverChambre(type, noChambre);

						System.out.println("\nLa chambre num�ro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " est maintenant r�serv�e.");

						System.out.println(MESS_BEAU_SEJOUR);
					}
				}

				// Les chambres de l'h�tel ont-elles �t� toutes r�serv�es ?
				if (hotel.estPlein()) {
					System.out.println(MESS_DEVENU_PLEIN);
					recommencer = 'N';
				} else {
					recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_ARRIVEE);
				}
			} while (recommencer == 'O');
		}
	}
}