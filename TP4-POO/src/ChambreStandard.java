/**
 * Auteurs : François MATHIEU et Soti
 * Fichier : ChambreStandard.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ChambreStandard contient les informations et les méthodes pour une
 * chambre de type standard de l'hôtel.
 */

public class ChambreStandard {

	// Constantes de la classe ChambreStandard.

	// Peut séjourner entre 1 et 31 jours.
	public static final int MIN_JOURS = 1;
	public static final int MAX_JOURS = 31;

	// 110.00 $ par jour, taxes et frais de services inclus.
	public static final double PRIX_BASE = 110.00;

	// Champs d'instance privés de la classe ChambreStandard.

	// Nombre de jours du séjour.
	private int nbJours;

	// true, la chambre est disponible et
	// false, la chambre n'est pas disponible.
	private boolean disponible;

	/**
	 * Constructeur de la classe ChambreStandard pour construire une chambre de
	 * type standard de base. Au début, aucune journée pour le séjour et la
	 * chambre est disponible.
	 */

	public ChambreStandard() {

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */
		initialiserChambre();

	}

	/**
	 * Méthode qui permet d'initialiser une chambre. Aucune journée pour le
	 * séjour et la chambre est disponible.
	 */

	public void initialiserChambre() {

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */
		this.nbJours = 0;
		this.disponible = true;

	}

	/**
	 * Méthode accesseur qui retourne le nombre de jours du séjour.
	 * 
	 * @return Le nombre de jours du séjour.
	 */

	public int getNbJours() {
		return this.nbJours;
	}

	/**
	 * Méthode accesseur qui retourne la disponiblité de la chambre. Remarque :
	 * le nom est isDisponible au lieu de getDisponible, car l'accesseur
	 * retourne un booléen.
	 * 
	 * @return La disponibilité de la chambre.
	 */

	public boolean isDisponible() {
		return this.disponible;
	}

	/**
	 * Méthode mutateur qui modifie le nombre de jours du séjour avec celui reçu
	 * en paramètre.
	 * 
	 * @param nbJours
	 *            Le nombre de jours du séjour.
	 */

	public void setNbJours(int nbJours) {
		if (this.nbJours >= 0 && this.nbJours <= ChambreStandard.MAX_JOURS) {
			this.nbJours = nbJours;
		}
	}

	/**
	 * Méthode mutateur qui modifie la disponibilité de la chambre avec celle
	 * reçue en paramètre.
	 * 
	 * @param disponible
	 *            La disponibilité de la chambre (true ou false).
	 */

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Méthode qui lit les informations de départ pour la chambre (lorsque le
	 * client quitte).
	 */

	public void lireInfosDepart() {
		final String QUEST_NB_JOURS = "\nEntrez le nombre de jours du séjour"
				+ " (entre " + ChambreStandard.MIN_JOURS + " et "
				+ ChambreStandard.MAX_JOURS + ") : ";

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */
		int nbJoursSejour = OutilsLecture.lireEntierValide(QUEST_NB_JOURS,
				MIN_JOURS, MAX_JOURS);

		this.setNbJours(nbJoursSejour);

	}

	/**
	 * Méthode qui calcule et retourne le prix total de la chambre.
	 * 
	 * @return Le prix total de la chambre.
	 */

	public double calculerPrixTotal() {

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */
		return this.getNbJours() * PRIX_BASE;

	}

	/**
	 * Méthode qui règle la chambre à la fin du séjour à l'hôtel. La méthode lit
	 * les informations nécessaires pour calculer la facture et réinitialise la
	 * chambre.
	 */

	public void reglerChambre() {

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */
		this.lireInfosDepart();

		System.out.println("Prix total pour la chambre : "
				+ OutilsAffichage.formaterMonetaire(calculerPrixTotal(), 2));

		this.initialiserChambre();

	}

	/**
	 * Méthode statique qui affiche les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP4.
		 */

		System.out.println("\nPrix pour la chambre :\t\t"
				+ OutilsAffichage.formaterMonetaire(PRIX_BASE, 2)
				+ " par jour (taxes et frais de services inclus)");

	}
}