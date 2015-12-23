/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : Hotel.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Hotel contient les informations et les m�thodes pour un h�tel de
 * trois �tages. Sur le premier �tage, il y a 5 chambres standards. Sur le
 * deuxi�me �tage, il y a 5 chambres avec un acc�s � Internet et sur le
 * troisi�me �tage, il y a 5 chambres de luxe (acc�s � Internet et � des
 * consommations d'un r�frig�rateur-bar).
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

	// Champs d'instance priv�s de la classe Hotel.

	// L'h�tel est compos� d'un tableau � deux dimensions de ChambreStandard.
	// La premi�re dimension (les lignes) repr�sente les 3 types de chambres et
	// la deuxi�me dimension (les colonnes) repr�sente les 5 chambres de
	// chaque type.

	private ChambreStandard[][] tabChambres = new ChambreStandard[MAX_TYPES][MAX_CHAMBRES];

	// Tableau qui contient le nombre de chambres occup�es pour chaque type
	// de chambre.
	private int[] tabOccupees = new int[MAX_TYPES];

	/**
	 * Constructeur de la classe Hotel pour construire toutes les chambres de
	 * l'h�tel. Le premier �tage contient les chambres standards, le deuxi�me
	 * �tage contient les chambres � acc�s Internet et le troisi�me �tage
	 * contient les chambres de luxe. Au d�but, toutes les chambres sont
	 * disponibles.
	 */

	public Hotel() {

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4. Mettre �galement
		 * les commentaires.
		 */
		// Cr�er le bon type de chambre pour chaque chambre.
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
	 * M�thode priv�e qui ajoute 1 au nombre de chambres occup�es d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	private void augmenterTabOccupees(int type) {

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */
		// Le tableau this.tabOccupees contient le nombre de chambres occup�es
		// pour chaque type. Voir en bas de la page 5 de cet �nonc�.
		// Le type re�u en param�tre contient l�indice � traiter.

		if (tabOccupees[type] < MAX_CHAMBRES) {
			tabOccupees[type]++;
		}

	}

	/**
	 * M�thode priv�e qui enl�ve 1 au nombre de chambres occup�es d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	private void diminuerTabOccupees(int type) {

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */
		if (tabOccupees[type] > 0) {
			tabOccupees[type]++;
		}

	}

	/**
	 * M�thode qui indique si un num�ro de chambre d'un certain type est
	 * disponible.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 * @return true si la chambre est disponible et false dans le cas contraire.
	 */

	public boolean chambreDisponible(int type, int noChambre) {

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */
		// Le tableau this.tabChambres contient toutes les chambres. Voir � la
		// page 5
		// de cet �nonc�. Le type et le noChambre re�us en param�tres
		// contiennent les
		// indices d�une chambre en particulier � traiter. Vous avez donc acc�s
		// aux
		// m�thodes publiques pour cette chambre en particulier.
		boolean dispo;

		if (this.tabChambres[type][noChambre].isDisponible()) {
			dispo = true;
		} else {
			dispo = false;
		}
		return dispo;

	}

	/**
	 * M�thode qui r�serve un num�ro de chambre d'un certain type. Il s'agit de
	 * modifier le champ disponible de la chambre en question pour la valeur
	 * false et de mettre � jour le nombre de chambres occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void reserverChambre(int type, int noChambre) {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */
		if (this.chambreDisponible(type, noChambre)) {
			this.tabChambres[type][noChambre].setDisponible(false);

			tabOccupees[type]++;
		}

	}

	/**
	 * M�thode qui lib�re un num�ro de chambre d'un certain type. Il s'agit de
	 * r�gler la chambre en question et de mettre � jour le nombre de chambres
	 * occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void libererChambre(int type, int noChambre) {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */
		if (!this.chambreDisponible(type, noChambre)) {
			this.tabChambres[type][noChambre].reglerChambre();

			tabOccupees[type]--;
		}

	}

	/**
	 * M�thode qui indique si toutes les chambres d'un certain type sont
	 * occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont occup�es et false dans
	 *         le cas contraire.
	 */

	public boolean typePlein(int type) {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */
		// Rappel. Le tableau this.tabOccupees contient le nombre de chambres
		// occup�es pour chaque type. Le type re�u en param�tre contient
		// l�indice �
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
	 * M�thode qui indique si toutes les chambres d'un certain type sont vides.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont vides et false dans le
	 *         cas contraire.
	 */

	public boolean typeVide(int type) {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
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
	 * M�thode qui indique si toutes les chambres de l'h�tel sont occup�es.
	 * 
	 * @return true si toutes les chambres de l'h�tel sont occup�es et false
	 *         dans le cas contraire.
	 */

	public boolean estPlein() {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
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
	 * M�thode qui indique si toutes les chambres de l'h�tel sont vides.
	 * 
	 * @return true si toutes les chambres de l'h�tel sont vides et false dans
	 *         le cas contraire.
	 */

	public boolean estVide() {

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
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
	 * M�thode qui affiche la disponibilit� d'une chambre en particulier.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void afficherDisponibilite(int type, int noChambre) {

		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */
		System.out.print("\nLa chambre num�ro " + (noChambre + 1) + " de type "
				+ Hotel.TAB_TYPES[type] + " est ");

		if (tabChambres[type][noChambre].isDisponible()) {
			System.out.print("disponible\n");
		} else {
			System.out.print("occup�e\n");
		}

	}

	/**
	 * M�thode qui affiche la disponibilit� de toutes les chambres d'un certain
	 * type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	public void afficherDisponibilite(int type) {

		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */
		String dispo;
		System.out.println("\nDisponibilit� des chambres de type "
				+ Hotel.TAB_TYPES[type] + " : \n");

		for (int noChambre = 0; noChambre < MAX_CHAMBRES; noChambre++) {
			if (chambreDisponible(type, noChambre)) {
				dispo = "Disponible";
			} else {
				dispo = "Occup�e";
			}
			System.out.print((noChambre + 1) + " : " + dispo + "  ");
		}
		System.out.println("");

	}

	/**
	 * M�thode qui affiche la disponibilit� de toutes les chambres de l'h�tel.
	 */

	public void afficherDisponibilite() {

		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */
		System.out
				.println("Disponibilit� de toutes les chambres de l'h�tel Montmotel");
		for (int type = 0; type < MAX_TYPES; type++) {
			this.afficherDisponibilite(type);
		}
	}

	/**
	 * M�thode statique qui affiche les tarifs de base de chaque type de
	 * chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
		 */
		ChambreStandard.afficherTarifsBase();
		ChambreInternet.afficherTarifsBase();
		ChambreLuxe.afficherTarifsBase();

	}

	/**
	 * M�thode statique qui lit un type de chambre et le retourne.
	 * 
	 * @return Une valeur entre 0 et MAX_TYPES - 1 pour faciliter l'acc�s au
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
	 * M�thode statique qui lit un num�ro de chambre et le retourne.
	 * 
	 * @return Une valeur entre 0 et MAX_CHAMBRES - 1 pour faciliter l'acc�s au
	 *         tableau.
	 */

	public static int lireNoChambre() {
		final String QUEST_NO_CHAMBRE = "\nEntrez le num�ro de la chambre"
				+ " (entre 1 et " + Hotel.MAX_CHAMBRES + ") : ";

		int noChambre = 1;

		noChambre = OutilsLecture.lireEntierValide(QUEST_NO_CHAMBRE, 1,
				Hotel.MAX_CHAMBRES);

		return (noChambre - 1);
	}
}