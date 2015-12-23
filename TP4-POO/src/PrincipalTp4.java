/**
 * Auteurs : François Mathieu et Soti
 * Fichier : PrincipalTp4.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe PrincipalTp4 permet de faire la gestion des chambres d'un hôtel.
 */

public class PrincipalTp4 {

	/**
	 * Constructeur qui permet de faire la gestion des chambres d'un hôtel avec
	 * l'aide d'un menu.
	 */

	public PrincipalTp4() {
		// Constante pour le texte du menu principal.
		final String MENU_PRINCIPAL = "\nMenu principal pour la gestion"
				+ " des chambres de l'hôtel Montmotel\n\n"
				+ "1. Arrivée d'un client\n" + "2. Départ d'un client\n"
				+ "3. Afficher les tarifs de base\n"
				+ "4. Afficher la disponibilité de toutes les chambres\n"
				+ "5. Afficher la disponibilité de toutes les chambres"
				+ " standards\n"
				+ "6. Afficher la disponibilité de toutes les chambres"
				+ " qui ont un accès Internet\n"
				+ "7. Afficher la disponibilité de toutes les chambres"
				+ " de luxe (accès Internet et réfrigérateur-bar)\n"
				+ "8. Afficher la disponibilité d'une chambre en"
				+ " particulier\n" + "9. Quitter le programme";

		// Constantes pour les choix du menu.
		final char ARRIVEE = '1';
		final char DEPART = '2';
		final char TARIFS = '3';
		final char TOUTES_CHAMBRES = '4';
		final char STANDARDS = '5';
		final char INTERNET = '6';
		final char LUXE = '7';
		final char UNE_CHAMBRE = '8';
		final char QUITTER = '9';

		final String MESS_BIENVENUE = "\nBienvenue au programme de gestion"
				+ " des chambres de l'hôtel Montmotel.";

		final String MESS_FIN = "\nFin du programme.\n";

		char choix; // Choix du menu principal.

		System.out.println(MESS_BIENVENUE);

		/*
		 * TODO (À COMPLÉTER).
		 * 
		 * Créer un objet de la classe Hotel. Voir en haut de la page 4 de
		 * l'énoncé du TP4.
		 */
		Hotel hotel = new Hotel();

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_PRINCIPAL,
					ARRIVEE, QUITTER);

			switch (choix) {

			case ARRIVEE:
				/*
				 * TODO (À COMPLÉTER). Créer une instance de la classe Arrivee
				 * (Vous devez envoyer le bon paramètre au constructeur).
				 */
				new Arrivee(hotel);

				break;

			case DEPART:
				/*
				 * TODO (À COMPLÉTER). Créer une instance de la classe Depart
				 * (Vous devez envoyer le bon paramètre au constructeur).
				 */
				new Depart(hotel);

				break;

			case TARIFS:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode statique de la classe
				 * Hotel qui permet d'afficher les tarifs de base.
				 */
				Hotel.afficherTarifsBase();

				break;

			case TOUTES_CHAMBRES:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet
				 * hotel qui permet d'afficher la disponibilité de toutes les
				 * chambres de l'hôtel.
				 */
				hotel.afficherDisponibilite();

				break;

			case STANDARDS:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet
				 * hotel qui permet d'afficher la disponibilité des chambres de
				 * type Hotel.STANDARD.
				 */
				hotel.afficherDisponibilite(Hotel.STANDARD);

				break;

			case INTERNET:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet
				 * hotel qui permet d'afficher la disponibilité des chambres de
				 * type Hotel.INTERNET.
				 */
				hotel.afficherDisponibilite(Hotel.INTERNET);

				break;

			case LUXE:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode appropriée de l'objet
				 * hotel qui permet d'afficher la disponibilité des chambres de
				 * type Hotel.LUXE.
				 */

				hotel.afficherDisponibilite(Hotel.LUXE);

				break;

			case UNE_CHAMBRE:
				/*
				 * TODO (À COMPLÉTER). Exécuter la méthode privée de cette
				 * classe, afficherUneChambre(). Vous devez envoyer le bon
				 * paramètre à la méthode.
				 */
				this.afficherUneChambre(hotel);

				break;

			case QUITTER:
				System.out.println(MESS_FIN);
				break;
			}
		} while (choix != QUITTER);
	}

	/**
	 * La méthode privée afficherUneChambre() permet d'afficher la disponibilité
	 * d'une seule chambre en particulier.
	 * 
	 * @param hotel
	 *            Objet qui gère l'hôtel.
	 */

	private void afficherUneChambre(Hotel hotel) {
		// Constantes.
		final String TITRE_DISPO = "\nDisponibilité d'une chambre en"
				+ " particulier.";
		final String QUEST_AUTRE_DISPO = "\nVoulez-vous consulter "
				+ "la disponibilité d'une autre chambre (O ou N) ? ";

		char recommencer = 'N';
		int type, noChambre;

		do {
			System.out.println(TITRE_DISPO);

			/*
			 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
			 */
			type = Hotel.lireTypeChambre();

			noChambre = Hotel.lireNoChambre();

			hotel.afficherDisponibilite(type, noChambre);

			recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_DISPO);
		} while (recommencer == 'O');
	}
}