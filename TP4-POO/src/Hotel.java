/**
 * Auteurs : François Mathieu et Soti
 * Fichier : Hotel.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Hotel contient les informations et les méthodes pour un hôtel de
 * trois étages. Sur le premier étage, il y a 5 chambres standards. Sur le
 * deuxième étage, il y a 5 chambres avec un accès à Internet et sur le
 * troisième étage, il y a 5 chambres de luxe (accès à Internet et à des
 * consommations d'un réfrigérateur-bar).
 */

public class Hotel {

	// Constantes de la classe Hotel.

	// Il y a 3 types de chambres et 5 chambres par type.
	public static final int MAX_TYPES = 3;
	public static final int MAX_CHAMBRES = 5;

	// Indices pour les types de chambres.
	public static final int STANDARD = 0;
	public static final int INTERNET = 1;
	public static final int LUXE = 2;

	// Tableau des noms des 3 types de chambres.
	public static final String[] TAB_TYPES = { "standard", "Internet",
			"de luxe" };

	// Champs d'instance privés de la classe Hotel.

	// L'hôtel est composé d'un tableau à deux dimensions de ChambreStandard.
	// La première dimension (les lignes) représente les 3 types de chambres et
	// la deuxième dimension (les colonnes) représente les 5 chambres de
	// chaque type.

	private ChambreStandard[][] tabChambres = new ChambreStandard[MAX_TYPES][MAX_CHAMBRES];

	// Tableau qui contient le nombre de chambres occupées pour chaque type
	// de chambre.
	private int[] tabOccupees = new int[MAX_TYPES];

	/**
	 * Constructeur de la classe Hotel pour construire toutes les chambres de
	 * l'hôtel. Le premier étage contient les chambres standards, le deuxième
	 * étage contient les chambres à accès Internet et le troisième étage
	 * contient les chambres de luxe. Au début, toutes les chambres sont
	 * disponibles.
	 */

	public Hotel() {

		/*
		 * TODO (À COMPLÉTER). Voir page 9 de l'énoncé du TP4. Mettre également
		 * les commentaires.
		 */
		// Créer le bon type de chambre pour chaque chambre.
		for (int noChambre = 0; noChambre < MAX_CHAMBRES; noChambre++) {
			this.tabChambres[STANDARD][noChambre] = new ChambreStandard();
			this.tabChambres[INTERNET][noChambre] = new ChambreInternet();
			this.tabChambres[LUXE][noChambre] = new ChambreLuxe();
		}

		for (int type = 0; type < MAX_TYPES; type++) {
			this.tabOccupees[type] = 0;
		}

	}

	/**
	 * Méthode privée qui ajoute 1 au nombre de chambres occupées d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	private void augmenterTabOccupees(int type) {

		/*
		 * TODO (À COMPLÉTER). Voir page 9 de l'énoncé du TP4.
		 */
		// Le tableau this.tabOccupees contient le nombre de chambres occupées
		// pour chaque type. Voir en bas de la page 5 de cet énoncé.
		// Le type reçu en paramètre contient l’indice à traiter.

		if (tabOccupees[type] < MAX_CHAMBRES) {
			tabOccupees[type]++;
		}

	}

	/**
	 * Méthode privée qui enlève 1 au nombre de chambres occupées d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	private void diminuerTabOccupees(int type) {

		/*
		 * TODO (À COMPLÉTER). Voir page 9 de l'énoncé du TP4.
		 */
		if (tabOccupees[type] > 0) {
			tabOccupees[type]++;
		}

	}

	/**
	 * Méthode qui indique si un numéro de chambre d'un certain type est
	 * disponible.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 * @return true si la chambre est disponible et false dans le cas contraire.
	 */

	public boolean chambreDisponible(int type, int noChambre) {

		/*
		 * TODO (À COMPLÉTER). Voir page 9 de l'énoncé du TP4.
		 */
		// Le tableau this.tabChambres contient toutes les chambres. Voir à la
		// page 5
		// de cet énoncé. Le type et le noChambre reçus en paramètres
		// contiennent les
		// indices d’une chambre en particulier à traiter. Vous avez donc accès
		// aux
		// méthodes publiques pour cette chambre en particulier.
		boolean dispo;

		if (this.tabChambres[type][noChambre].isDisponible()) {
			dispo = true;
		} else {
			dispo = false;
		}
		return dispo;

	}

	/**
	 * Méthode qui réserve un numéro de chambre d'un certain type. Il s'agit de
	 * modifier le champ disponible de la chambre en question pour la valeur
	 * false et de mettre à jour le nombre de chambres occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void reserverChambre(int type, int noChambre) {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */
		if (this.chambreDisponible(type, noChambre)) {
			this.tabChambres[type][noChambre].setDisponible(false);

			tabOccupees[type]++;
		}

	}

	/**
	 * Méthode qui libère un numéro de chambre d'un certain type. Il s'agit de
	 * régler la chambre en question et de mettre à jour le nombre de chambres
	 * occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void libererChambre(int type, int noChambre) {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */
		if (!this.chambreDisponible(type, noChambre)) {
			this.tabChambres[type][noChambre].reglerChambre();

			tabOccupees[type]--;
		}

	}

	/**
	 * Méthode qui indique si toutes les chambres d'un certain type sont
	 * occupées.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont occupées et false dans
	 *         le cas contraire.
	 */

	public boolean typePlein(int type) {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */
		// Rappel. Le tableau this.tabOccupees contient le nombre de chambres
		// occupées pour chaque type. Le type reçu en paramètre contient
		// l’indice à
		// traiter.
		boolean full;

		if (this.tabOccupees[type] == MAX_CHAMBRES) {
			full = true;
		} else {
			full = false;
		}
		return full;

	}

	/**
	 * Méthode qui indique si toutes les chambres d'un certain type sont vides.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont vides et false dans le
	 *         cas contraire.
	 */

	public boolean typeVide(int type) {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */
		boolean full;

		if (this.tabOccupees[type] == 0) {
			full = true;
		} else {
			full = false;
		}
		return full;

	}

	/**
	 * Méthode qui indique si toutes les chambres de l'hôtel sont occupées.
	 * 
	 * @return true si toutes les chambres de l'hôtel sont occupées et false
	 *         dans le cas contraire.
	 */

	public boolean estPlein() {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */
		boolean full;
		if (this.typePlein(STANDARD) && this.typePlein(INTERNET)
				&& this.typePlein(LUXE)) {
			full = true;
		} else {
			full = false;
		}
		return full;
	}

	/**
	 * Méthode qui indique si toutes les chambres de l'hôtel sont vides.
	 * 
	 * @return true si toutes les chambres de l'hôtel sont vides et false dans
	 *         le cas contraire.
	 */

	public boolean estVide() {

		/*
		 * TODO (À COMPLÉTER). Voir page 10 de l'énoncé du TP4.
		 */

		boolean full;
		if (this.typeVide(STANDARD) && this.typeVide(INTERNET)
				&& this.typeVide(LUXE)) {
			full = true;
		} else {
			full = false;
		}
		return full;

	}

	/**
	 * Méthode qui affiche la disponibilité d'une chambre en particulier.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le numéro de la chambre.
	 */

	public void afficherDisponibilite(int type, int noChambre) {

		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */
		System.out.print("\nLa chambre numéro " + (noChambre + 1) + " de type "
				+ Hotel.TAB_TYPES[type] + " est ");

		if (tabChambres[type][noChambre].isDisponible()) {
			System.out.print("disponible\n");
		} else {
			System.out.print("occupée\n");
		}

	}

	/**
	 * Méthode qui affiche la disponibilité de toutes les chambres d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	public void afficherDisponibilite(int type) {

		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */
		String dispo;
		System.out.println("\nDisponibilité des chambres de type "
				+ Hotel.TAB_TYPES[type] + " : \n");

		for (int noChambre = 0; noChambre < MAX_CHAMBRES; noChambre++) {
			if (chambreDisponible(type, noChambre)) {
				dispo = "Disponible";
			} else {
				dispo = "Occupée";
			}
			System.out.print((noChambre + 1) + " : " + dispo + "  ");
		}
		System.out.println("");

	}

	/**
	 * Méthode qui affiche la disponibilité de toutes les chambres de l'hôtel.
	 */

	public void afficherDisponibilite() {

		/*
		 * TODO (À COMPLÉTER). Voir page 11 de l'énoncé du TP4.
		 */
		System.out
				.println("Disponibilité de toutes les chambres de l'hôtel Montmotel");
		for (int type = 0; type < MAX_TYPES; type++) {
			this.afficherDisponibilite(type);
		}
	}

	/**
	 * Méthode statique qui affiche les tarifs de base de chaque type de
	 * chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP4.
		 */
		ChambreStandard.afficherTarifsBase();
		ChambreInternet.afficherTarifsBase();
		ChambreLuxe.afficherTarifsBase();

	}

	/**
	 * Méthode statique qui lit un type de chambre et le retourne.
	 * 
	 * @return Une valeur entre 0 et MAX_TYPES - 1 pour faciliter l'accès au
	 *         tableau.
	 */

	public static int lireTypeChambre() {
		final String QUEST_TYPE_CHAMBRE = "\nEntrez le type de la chambre"
				+ " ([S]tandard, [I]nternet ou [L]uxe) : ";

		final String TYPES_POSSIBLES = "SIL";

		int type = 0;
		char carType;

		carType = OutilsLecture.lireCaractereDisparate(QUEST_TYPE_CHAMBRE,
				TYPES_POSSIBLES);

		// Type contiendra 0 si S, 1 si I ou 2 si L.
		type = TYPES_POSSIBLES.indexOf(carType);

		return type;
	}

	/**
	 * Méthode statique qui lit un numéro de chambre et le retourne.
	 * 
	 * @return Une valeur entre 0 et MAX_CHAMBRES - 1 pour faciliter l'accès au
	 *         tableau.
	 */

	public static int lireNoChambre() {
		final String QUEST_NO_CHAMBRE = "\nEntrez le numéro de la chambre"
				+ " (entre 1 et " + Hotel.MAX_CHAMBRES + ") : ";

		int noChambre = 1;

		noChambre = OutilsLecture.lireEntierValide(QUEST_NO_CHAMBRE, 1,
				Hotel.MAX_CHAMBRES);

		return (noChambre - 1);
	}
}