/**
 * Auteurs : Fran�ois MATHIEU et Soti
 * Fichier : ChambreInternet.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ChambreInternet h�rite de la classe ChambreStandard.
 * 
 * La classe ChambreInternet contient les informations et les m�thodes
 * suppl�mentaires pour une chambre de l'h�tel qui a un acc�s � Internet.
 */

public class ChambreInternet extends ChambreStandard {

	// Constantes de la classe ChambreInternet.

	// Peut acc�der � Internet entre 0 et 744 heures (31 jours * 24 heures).
	public static final double MIN_HEURES = 0;
	public static final double MAX_HEURES = ChambreStandard.MAX_JOURS * 24;

	// L'acc�s Internet co�te 0.50 $ de l'heure.
	public static final double PRIX_INTERNET = 0.50;

	// Champ d'instance priv� de la classe ChambreInternet.

	private double nbHeures; // Nombre d'heures pour l'acc�s Internet.

	/**
	 * Constructeur de la classe ChambreInternet pour construire une chambre �
	 * acc�s Internet de base. Au d�but, aucun acc�s � Internet.
	 */

	public ChambreInternet() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		this.initialiserChambre();

	}

	/**
	 * Red�finition de la m�thode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		super.initialiserChambre();
		this.setNbHeures(0);

	}

	/**
	 * M�thode accesseur qui retourne le nombre d'heures d'acc�s � Internet.
	 * 
	 * @return Le nombre d'heures d'acc�s � Internet.
	 */

	public double getNbHeures() {
		return this.nbHeures;
	}

	/**
	 * M�thode mutateur qui modifie le nombre d'heures d'acc�s � Internet avec
	 * celui re�u en param�tre.
	 * 
	 * @param nbHeures
	 *            Le nombre d'heures d'acc�s � Internet.
	 */

	public void setNbHeures(double nbHeures) {
		if (this.nbHeures >= ChambreInternet.MIN_HEURES
				&& this.nbHeures <= ChambreInternet.MAX_HEURES) {

			this.nbHeures = nbHeures;
		}
	}

	/**
	 * Red�finition de la m�thode qui lit les informations de d�part pour la
	 * chambre (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {
		final String QUEST_NB_HEURES = "\nEntrez le nombre d'heures d'acc�s"
				+ " � Internet (entre " + ChambreInternet.MIN_HEURES + " et "
				+ ChambreInternet.MAX_HEURES + ") : ";

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		super.lireInfosDepart();

		double NbHeuresInternet = OutilsLecture.lireReelValide(QUEST_NB_HEURES,
				MIN_HEURES, MAX_HEURES);
		this.setNbHeures(NbHeuresInternet);

	}

	/**
	 * Red�finition de la m�thode qui calcule et retourne le prix total de la
	 * chambre.
	 */

	@Override
	public double calculerPrixTotal() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		return (this.getNbHeures() * PRIX_INTERNET) + super.calculerPrixTotal();

	}

	/**
	 * M�thode statique qui affiche les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		System.out.println("Prix pour l'acc�s � Internet : \t"
				+ OutilsAffichage.formaterMonetaire(PRIX_INTERNET, 2)
				+ " de l'heure");

	}
}