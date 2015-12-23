/**
 * Auteurs : François MATHIEU et Soti
 * Fichier : ChambreLuxe.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ChambreLuxe hérite de la classe ChambreInternet. La classe
 * ChambreLuxe contient les informations et les méthodes supplémentaires pour
 * une chambre de l'hôtel qui a un accès à Internet et à des consommations d'un
 * réfrigérateur-bar.
 */

public class ChambreLuxe extends ChambreInternet {

	// Constantes de la classe ChambreLuxe.

	// Peut consommer entre 0 et 124 consommations.
	public static final int MIN_CONSOMMATIONS = 0;
	public static final int MAX_CONSOMMATIONS = 124;

	// Une consommation coûte 9.99 $.
	public static final double PRIX_CONSOMMATION = 9.99;

	// Champ d'instance privé de la classe ChambreLuxe.

	private int nbConsommations; // Nombre de consommations prises.

	/**
	 * Constructeur de la classe ChambreLuxe pour construire une chambre de luxe
	 * de base. Au début, aucune consommation.
	 */

	public ChambreLuxe() {

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */
		this.initialiserChambre();

	}

	/**
	 * Redéfinition de la méthode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */
		super.initialiserChambre();
		this.setNbConsommations(0);

	}

	/**
	 * Méthode accesseur qui retourne le nombre de consommations prises.
	 * 
	 * @return Le nombre de consommations prises.
	 */

	public int getNbConsommations() {
		return this.nbConsommations;
	}

	/**
	 * Méthode mutateur qui modifie le nombre de consommations avec celui reçu
	 * en paramètre.
	 * 
	 * @param nbConsommations
	 *            Le nombre de consommations prises.
	 */

	public void setNbConsommations(int nbConsommations) {
		if (this.nbConsommations >= ChambreLuxe.MIN_CONSOMMATIONS
				&& this.nbConsommations <= ChambreLuxe.MAX_CONSOMMATIONS) {

			this.nbConsommations = nbConsommations;
		}
	}

	/**
	 * Redéfinition de la méthode qui lit les informations de départ pour la
	 * chambre (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {
		final String QUEST_NB_CONSOMMATIONS = "\nEntrez le nombre de"
				+ " consommations prises (entre "
				+ ChambreLuxe.MIN_CONSOMMATIONS + " et "
				+ ChambreLuxe.MAX_CONSOMMATIONS + ") : ";

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */
		super.lireInfosDepart();

		int nbBoissons = OutilsLecture.lireEntierValide(QUEST_NB_CONSOMMATIONS,
				MIN_CONSOMMATIONS, MAX_CONSOMMATIONS);
		this.setNbConsommations(nbBoissons);

	}

	/**
	 * Redéfinition de la méthode qui calcule et retourne le prix total de la
	 * chambre.
	 */

	@Override
	public double calculerPrixTotal() {

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */
		return (this.getNbConsommations() * PRIX_CONSOMMATION)
				+ super.calculerPrixTotal();

	}

	/**
	 * Méthode statique qui affiche les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP4.
		 */
		System.out.println("Prix pour une consommation :\t"
				+ OutilsAffichage.formaterMonetaire(PRIX_CONSOMMATION, 2));

	}
}