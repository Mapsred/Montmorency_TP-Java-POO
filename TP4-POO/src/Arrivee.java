/**
 * Auteurs : François Mathieu et Soti
 * Fichier : Arrivee.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Arrivee permet de gérer les arrivées des clients à l'hôtel. Les
 * clients réservent des chambres de l'hôtel.
 */
public class Arrivee {

	/**
	 * Le constructeur permet de faire la gestion des arrivées des clients à
	 * l'hôtel. Les clients réservent des chambres de l'hôtel, tant qu'ils le
	 * désirent.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel pour consulter et mettre à jour la
	 *            disponibilité des chambres.
	 */

	public Arrivee(Hotel hotel) {
		// Constantes.
		final String TITRE_ARRIVEE = "\nArrivée d'un client.";
		final String MESS_PLEIN = "\nDésolé, il n'y a aucune chambre de libre"
				+ " à l'hôtel Montmotel.";
		final String MESS_DEVENU_PLEIN = "\nIl ne reste plus de chambres"
				+ " de disponibles à l'hôtel Montmotel.";
		final String MESS_BEAU_SEJOUR = "\nPassez un beau séjour à"
				+ " l'hôtel Montmotel.";
		final String QUEST_AUTRE_ARRIVEE = "\nVoulez-vous "
				+ "réserver une autre chambre (O ou N) ? ";

		char recommencer = 'N';

		if (hotel.estPlein()) {
			System.out.println(MESS_PLEIN);
		} else {
			do {
				System.out.println(TITRE_ARRIVEE);

				/*
				 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
				 */
				int type = Hotel.lireTypeChambre();

				if (hotel.typePlein(type)) {
					System.out.println("Il n'y a aucune chambre de libre"
							+ " pour le type " + Hotel.TAB_TYPES[type]);
				} else {
					hotel.afficherDisponibilite(type);

					int noChambre = Hotel.lireNoChambre();

					if (!hotel.chambreDisponible(type, noChambre)) {
						System.out.println("\n Désolé, La chambre numéro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " n'est pas disponible.");
					} else {
						hotel.reserverChambre(type, noChambre);

						System.out.println("\nLa chambre numéro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " est maintenant réservée.");

						System.out.println(MESS_BEAU_SEJOUR);
					}
				}

				// Les chambres de l'hôtel ont-elles été toutes réservées ?
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