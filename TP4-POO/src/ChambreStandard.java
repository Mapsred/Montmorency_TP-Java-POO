/**
 * Auteurs : Fran�ois MATHIEU et Soti
 * Fichier : ChambreStandard.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ChambreStandard contient les informations et les m�thodes pour une
 * chambre de type standard de l'h�tel.
 */

public class ChambreStandard {

	// Constantes de la classe ChambreStandard.

	// Peut s�journer entre 1 et 31 jours.
	public static final int MIN_JOURS = 1;
	public static final int MAX_JOURS = 31;

	// 110.00 $ par jour, taxes et frais de services inclus.
	public static final double PRIX_BASE = 110.00;

	// Champs d'instance priv�s de la classe ChambreStandard.

	// Nombre de jours du s�jour.
	private int nbJours;

	// true, la chambre est disponible et
	// false, la chambre n'est pas disponible.
	private boolean disponible;

	/**
	 * Constructeur de la classe ChambreStandard pour construire une chambre de
	 * type standard de base. Au d�but, aucune journ�e pour le s�jour et la
	 * chambre est disponible.
	 */

	public ChambreStandard() {

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */
		initialiserChambre();

	}

	/**
	 * M�thode qui permet d'initialiser une chambre. Aucune journ�e pour le
	 * s�jour et la chambre est disponible.
	 */

	public void initialiserChambre() {

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */
		this.nbJours = 0;
		this.disponible = true;

	}

	/**
	 * M�thode accesseur qui retourne le nombre de jours du s�jour.
	 * 
	 * @return Le nombre de jours du s�jour.
	 */

	public int getNbJours() {
		return this.nbJours;
	}

	/**
	 * M�thode accesseur qui retourne la disponiblit� de la chambre. Remarque :
	 * le nom est isDisponible au lieu de getDisponible, car l'accesseur
	 * retourne un bool�en.
	 * 
	 * @return La disponibilit� de la chambre.
	 */

	public boolean isDisponible() {
		return this.disponible;
	}

	/**
	 * M�thode mutateur qui modifie le nombre de jours du s�jour avec celui re�u
	 * en param�tre.
	 * 
	 * @param nbJours
	 *            Le nombre de jours du s�jour.
	 */

	public void setNbJours(int nbJours) {
		if (this.nbJours >= 0 && this.nbJours <= ChambreStandard.MAX_JOURS) {
			this.nbJours = nbJours;
		}
	}

	/**
	 * M�thode mutateur qui modifie la disponibilit� de la chambre avec celle
	 * re�ue en param�tre.
	 * 
	 * @param disponible
	 *            La disponibilit� de la chambre (true ou false).
	 */

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * M�thode qui lit les informations de d�part pour la chambre (lorsque le
	 * client quitte).
	 */

	public void lireInfosDepart() {
		final String QUEST_NB_JOURS = "\nEntrez le nombre de jours du s�jour"
				+ " (entre " + ChambreStandard.MIN_JOURS + " et "
				+ ChambreStandard.MAX_JOURS + ") : ";

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */
		int nbJoursSejour = OutilsLecture.lireEntierValide(QUEST_NB_JOURS,
				MIN_JOURS, MAX_JOURS);

		this.setNbJours(nbJoursSejour);

	}

	/**
	 * M�thode qui calcule et retourne le prix total de la chambre.
	 * 
	 * @return Le prix total de la chambre.
	 */

	public double calculerPrixTotal() {

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */
		return this.getNbJours() * PRIX_BASE;

	}

	/**
	 * M�thode qui r�gle la chambre � la fin du s�jour � l'h�tel. La m�thode lit
	 * les informations n�cessaires pour calculer la facture et r�initialise la
	 * chambre.
	 */

	public void reglerChambre() {

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */
		this.lireInfosDepart();

		System.out.println("Prix total pour la chambre : "
				+ OutilsAffichage.formaterMonetaire(calculerPrixTotal(), 2));

		this.initialiserChambre();

	}

	/**
	 * M�thode statique qui affiche les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (� COMPL�TER). Voir page 6 de l'�nonc� du TP4.
		 */

		System.out.println("\nPrix pour la chambre :\t\t"
				+ OutilsAffichage.formaterMonetaire(PRIX_BASE, 2)
				+ " par jour (taxes et frais de services inclus)");

	}
}