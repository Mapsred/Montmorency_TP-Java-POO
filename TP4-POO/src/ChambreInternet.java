/**
 * Auteurs : François MATHIEU et Soti
 * Fichier : ChambreInternet.java
 * Cours   : 420-165-MO (TP4, Hôtel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ChambreInternet hérite de la classe ChambreStandard.
 * 
 * La classe ChambreInternet contient les informations et les méthodes
 * supplémentaires pour une chambre de l'hôtel qui a un accès à Internet.
 */

public class ChambreInternet extends ChambreStandard {

	// Constantes de la classe ChambreInternet.

	// Peut accéder à Internet entre 0 et 744 heures (31 jours * 24 heures).
	public static final double MIN_HEURES = 0;
	public static final double MAX_HEURES = ChambreStandard.MAX_JOURS * 24;

	// L'accès Internet coûte 0.50 $ de l'heure.
	public static final double PRIX_INTERNET = 0.50;

	// Champ d'instance privé de la classe ChambreInternet.

	private double nbHeures; // Nombre d'heures pour l'accès Internet.

	/**
	 * Constructeur de la classe ChambreInternet pour construire une chambre à
	 * accès Internet de base. Au début, aucun accès à Internet.
	 */

	public ChambreInternet() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		this.initialiserChambre();

	}

	/**
	 * Redéfinition de la méthode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		super.initialiserChambre();
		this.setNbHeures(0);

	}

	/**
	 * Méthode accesseur qui retourne le nombre d'heures d'accès à Internet.
	 * 
	 * @return Le nombre d'heures d'accès à Internet.
	 */

	public double getNbHeures() {
		return this.nbHeures;
	}

	/**
	 * Méthode mutateur qui modifie le nombre d'heures d'accès à Internet avec
	 * celui reçu en paramètre.
	 * 
	 * @param nbHeures
	 *            Le nombre d'heures d'accès à Internet.
	 */

	public void setNbHeures(double nbHeures) {
		if (this.nbHeures >= ChambreInternet.MIN_HEURES
				&& this.nbHeures <= ChambreInternet.MAX_HEURES) {

			this.nbHeures = nbHeures;
		}
	}

	/**
	 * Redéfinition de la méthode qui lit les informations de départ pour la
	 * chambre (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {
		final String QUEST_NB_HEURES = "\nEntrez le nombre d'heures d'accès"
				+ " à Internet (entre " + ChambreInternet.MIN_HEURES + " et "
				+ ChambreInternet.MAX_HEURES + ") : ";

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		super.lireInfosDepart();

		double NbHeuresInternet = OutilsLecture.lireReelValide(QUEST_NB_HEURES,
				MIN_HEURES, MAX_HEURES);
		this.setNbHeures(NbHeuresInternet);

	}

	/**
	 * Redéfinition de la méthode qui calcule et retourne le prix total de la
	 * chambre.
	 */

	@Override
	public double calculerPrixTotal() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		return (this.getNbHeures() * PRIX_INTERNET) + super.calculerPrixTotal();

	}

	/**
	 * Méthode statique qui affiche les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP4.
		 */
		System.out.println("Prix pour l'accès à Internet : \t"
				+ OutilsAffichage.formaterMonetaire(PRIX_INTERNET, 2)
				+ " de l'heure");

	}
}