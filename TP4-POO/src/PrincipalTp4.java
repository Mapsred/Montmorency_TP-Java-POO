/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : PrincipalTp4.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe PrincipalTp4 permet de faire la gestion des chambres d'un h�tel.
 */

public class PrincipalTp4 {

	/**
	 * Constructeur qui permet de faire la gestion des chambres d'un h�tel avec
	 * l'aide d'un menu.
	 */

	public PrincipalTp4() {
		// Constante pour le texte du menu principal.
		final String MENU_PRINCIPAL = "\nMenu principal pour la gestion"
				+ " des chambres de l'h�tel Montmotel\n\n"
				+ "1. Arriv�e d'un client\n" + "2. D�part d'un client\n"
				+ "3. Afficher les tarifs de base\n"
				+ "4. Afficher la disponibilit� de toutes les chambres\n"
				+ "5. Afficher la disponibilit� de toutes les chambres"
				+ " standards\n"
				+ "6. Afficher la disponibilit� de toutes les chambres"
				+ " qui ont un acc�s Internet\n"
				+ "7. Afficher la disponibilit� de toutes les chambres"
				+ " de luxe (acc�s Internet et r�frig�rateur-bar)\n"
				+ "8. Afficher la disponibilit� d'une chambre en"
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
				+ " des chambres de l'h�tel Montmotel.";

		final String MESS_FIN = "\nFin du programme.\n";

		char choix; // Choix du menu principal.

		System.out.println(MESS_BIENVENUE);

		/*
		 * TODO (� COMPL�TER).
		 * 
		 * Cr�er un objet de la classe Hotel. Voir en haut de la page 4 de
		 * l'�nonc� du TP4.
		 */
		Hotel hotel = new Hotel();

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_PRINCIPAL,
					ARRIVEE, QUITTER);

			switch (choix) {

			case ARRIVEE:
				/*
				 * TODO (� COMPL�TER). Cr�er une instance de la classe Arrivee
				 * (Vous devez envoyer le bon param�tre au constructeur).
				 */
				new Arrivee(hotel);

				break;

			case DEPART:
				/*
				 * TODO (� COMPL�TER). Cr�er une instance de la classe Depart
				 * (Vous devez envoyer le bon param�tre au constructeur).
				 */
				new Depart(hotel);

				break;

			case TARIFS:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode statique de la classe
				 * Hotel qui permet d'afficher les tarifs de base.
				 */
				Hotel.afficherTarifsBase();

				break;

			case TOUTES_CHAMBRES:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet
				 * hotel qui permet d'afficher la disponibilit� de toutes les
				 * chambres de l'h�tel.
				 */
				hotel.afficherDisponibilite();

				break;

			case STANDARDS:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet
				 * hotel qui permet d'afficher la disponibilit� des chambres de
				 * type Hotel.STANDARD.
				 */
				hotel.afficherDisponibilite(Hotel.STANDARD);

				break;

			case INTERNET:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet
				 * hotel qui permet d'afficher la disponibilit� des chambres de
				 * type Hotel.INTERNET.
				 */
				hotel.afficherDisponibilite(Hotel.INTERNET);

				break;

			case LUXE:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet
				 * hotel qui permet d'afficher la disponibilit� des chambres de
				 * type Hotel.LUXE.
				 */

				hotel.afficherDisponibilite(Hotel.LUXE);

				break;

			case UNE_CHAMBRE:
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode priv�e de cette
				 * classe, afficherUneChambre(). Vous devez envoyer le bon
				 * param�tre � la m�thode.
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
	 * La m�thode priv�e afficherUneChambre() permet d'afficher la disponibilit�
	 * d'une seule chambre en particulier.
	 * 
	 * @param hotel
	 *            Objet qui g�re l'h�tel.
	 */

	private void afficherUneChambre(Hotel hotel) {
		// Constantes.
		final String TITRE_DISPO = "\nDisponibilit� d'une chambre en"
				+ " particulier.";
		final String QUEST_AUTRE_DISPO = "\nVoulez-vous consulter "
				+ "la disponibilit� d'une autre chambre (O ou N) ? ";

		char recommencer = 'N';
		int type, noChambre;

		do {
			System.out.println(TITRE_DISPO);

			/*
			 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
			 */
			type = Hotel.lireTypeChambre();

			noChambre = Hotel.lireNoChambre();

			hotel.afficherDisponibilite(type, noChambre);

			recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_DISPO);
		} while (recommencer == 'O');
	}
}