/**
 * Auteurs : François Mathieu et Soti
 * Fichier : Depart.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Depart permet de gérer les départs des clients de l'hôtel
 * Montmotel.
 */

public class Depart {

	/**
	 * Le constructeur permet de faire la gestion des départs des clients de
	 * l'hôtel Montmotel. Les clients payent et libèrent des chambres de
	 * l'hôtel, tant qu'ils le désirent.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel pour consulter et mettre à jour la
	 *            disponibilité des chambres.
	 */

	public Depart(Hotel hotel) {
		// Constantes.
		final String TITRE_DEPART = "\nDépart d'un client.";
		final String MESS_VIDE = "\nAucun départ possible, toutes les "
				+ "chambres de l'hôtel Montmotel sont libres.";
		final String MESS_DEVENU_VIDE = "\nToutes les chambres de l'hôtel "
				+ "Montmotel ont été libérées.";
		final String MESS_MERCI = "\nMerci d'avoir séjourné à"
				+ " l'hôtel Montmotel.";
		final String QUEST_AUTRE_DEPART = "\nVoulez-vous "
				+ "libérer une autre chambre (O ou N) ? ";

		char recommencer = 'N';
		int type, noChambre;

		if (hotel.estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			do {
				System.out.println(TITRE_DEPART);

				/*
				 * TODO (À COMPLÉTER). Voir page 13 de l'énoncé du TP4.
				 */
				type = Hotel.lireTypeChambre();

				if (hotel.typeVide(type)) {
					System.out.println(" Toutes les chambres pour le type "
							+ Hotel.TAB_TYPES[type] + " sont déjà libres");
				} else {
					hotel.afficherDisponibilite(type);

					noChambre = Hotel.lireNoChambre();

					if (hotel.chambreDisponible(type, noChambre)) {
						System.out.println("La chambre numéro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type] + " est déjà libre.");
					} else {
						hotel.libererChambre(type, noChambre);

						System.out.println("La chambre numéro "
								+ (noChambre + 1) + " de type "
								+ Hotel.TAB_TYPES[type]
								+ " est maintenant libre.");

						System.out.println(MESS_MERCI);
					}
				}

				// Les chambres de l'hôtel ont-elles été toutes libérées ?
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