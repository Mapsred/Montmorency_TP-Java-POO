// Auteurs : François Mathieu et Soti
// Fichier : GererCourbesDemande.java
// Date    : 25 Février 2015
// Cours   : 420-165-MO (TP2, Courbes de demande)

// Package du programmeur.
import outilsjava.*;

/*
 * La classe GererCourbesDemande permet de faire une gestion des courbes de
 * demande en microéconomie. C'est un exemple d'application d'une droite. La
 * demande est la quantité d'un certain produit demandée par les consommateurs
 * ou acheteurs pour un prix quelconque. La demande tend à augmenter quand le
 * prix baisse.
 */

public class GererCourbesDemande {

	// Constantes de la classe.
	public static final double PRIX_MIN = 0;
	public static final double PRIX_MAX = 1000000;
	public static final double QTE_MIN = 0;
	public static final double QTE_MAX = 100000000;

	/*
	 * Constructeur qui permet de faire la gestion des courbes de demande en
	 * microéconomie.
	 */

	public GererCourbesDemande() {
		// Constantes du constructeur.

		final String TITRE = "\nGestion d'une courbe de demande.";

		final String QUEST_ETUDE = "\nEntrez les informations suivantes suite"
				+ " à votre étude.";

		final String QUEST_PRIX1 = "\nEntrez le premier prix du produit : ";

		final String QUEST_QTE1 = "\nEntrez la quantité demandée pour "
				+ "le premier prix : ";

		final String QUEST_PRIX2 = "\nEntrez le deuxième prix du produit : ";

		final String QUEST_QTE2 = "\nEntrez la quantité demandée pour "
				+ "le deuxième prix : ";

		final String MESS_PRIX_EGAUX = "\nErreur, les deux prix ne peuvent "
				+ "pas être égaux.";

		final String MESS_PAS_COURBE = "\nLes informations entrées ne"
				+ " produisent pas une courbe de demande.";

		final String QUEST_AUTRE_COURBE = "\nVoulez-vous faire une "
				+ "autre courbe de demande (O/N) ? ";

		final String MESS_FIN = "\nFin du programme.";

		// TODO (À COMPLÉTER). Voir page 6 de l'énoncé du TP2.
		char recommencer;
		do {
			System.out.println(TITRE);
			System.out.println(QUEST_ETUDE);

			double premierPrix;
			premierPrix = OutilsLecture.lireReelValide(QUEST_PRIX1, PRIX_MIN,
					PRIX_MAX);

			double premiereQte;
			premiereQte = OutilsLecture.lireReelValide(QUEST_QTE1, QTE_MIN,
					QTE_MAX);

			double deuxiemePrix;
			deuxiemePrix = OutilsLecture.lireReelValide(QUEST_PRIX2, PRIX_MIN,
					PRIX_MAX);

			double deuxiemeQte;
			deuxiemeQte = OutilsLecture.lireReelValide(QUEST_QTE2, QTE_MIN,
					QTE_MAX);

			if (premierPrix == deuxiemePrix) {
				System.out.println(MESS_PRIX_EGAUX);
			} else {
				PointXY premierPoint;
				premierPoint = new PointXY(premierPrix, premiereQte);

				PointXY deuxiemePoint;
				deuxiemePoint = new PointXY(deuxiemePrix, deuxiemeQte);

				double pente;
				pente = Droite.calculerPente(premierPoint, deuxiemePoint);

				if (pente < 0) {
					traiterEquation(premierPoint, pente);
				} else {
					System.out.println(MESS_PAS_COURBE);
				}
			}
			// char recommencer;
			recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_COURBE);

		} while (recommencer == 'O');

		System.out.println(MESS_FIN);

	}

	/*
	 * Méthode privée qui permet de traiter l'équation de la courbe de demande.
	 * La méthode reçoit un point et la pente (m) en paramètres.
	 */

	private void traiterEquation(PointXY point, double pente) {
		// Constantes de la méthode.

		final String MESS_EQUATION = "\nLa courbe de demande est décrite par "
				+ "l'équation suivante : ";

		final String MESS_PRIX = "\nCela veut dire que chaque augmentation"
				+ " du prix de 1$ entraîne\n"
				+ "une diminution de la quantité demandée de ";

		// Texte du menu pour les simulations.
		final String MENU_SIMULATION = "\nMenu des simulations de quantités"
				+ " ou de prix\n\n"
				+ "1. Simuler une quantité demandée selon un prix\n"
				+ "2. Simuler un prix selon une quantité demandée\n"
				+ "3. Quitter le menu des simulations";

		// Choix du menu des simulations.
		final char SIMULER_QTE = '1';
		final char SIMULER_PRIX = '2';
		final char QUITTER = '3';

		// TODO (À COMPLÉTER). Voir page 7 de l'énoncé du TP2.
		double ordonneeOrigine;
		ordonneeOrigine = Droite.calculerOrdonneeOrigine(point, pente);
		System.out.print(MESS_EQUATION);

		Droite.afficherEquation(pente, ordonneeOrigine);

		System.out.print(MESS_PRIX);

		System.out.println(OutilsAffichage.formaterNb(Math.abs(pente), 2));

		char choix;
		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_SIMULATION,
					SIMULER_QTE, QUITTER);

			switch (choix) {
			case SIMULER_QTE:
				simulerQuantite(pente, ordonneeOrigine);
				break;
			case SIMULER_PRIX:
				simulerPrix(pente, ordonneeOrigine);
				break;
			case QUITTER:
				System.out.println("Vous avez choisi de quitter");
				;
				break;
			}

		} while (choix != QUITTER);
	}

	/*
	 * Méthode privée qui permet de faire des simulations pour obtenir une
	 * quantité demandée (y) selon un prix (x). La méthode reçoit la pente (m)
	 * et l'ordonnée à l'origine (b) en paramètres.
	 */

	private void simulerQuantite(double pente, double ordonneeOrigine) {
		// Constantes de la méthode.

		final String TITRE_SIM_QTE = "\nSimulation de quantité demandée "
				+ "selon un prix.";

		final String QUEST_PRIX_SIM = "\nEntrez le prix du produit pour la "
				+ "simulation : ";

		final String QUEST_AUTRE_SIM_QTE = "\nVoulez-vous faire une autre "
				+ "simulation de quantité demandée " + "selon un prix (O/N) ? ";

		// TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP2.
		char recommencer;
		do {
			System.out.println(TITRE_SIM_QTE);

			double prix;
			prix = OutilsLecture.lireReelValide(QUEST_PRIX_SIM, pente,
					ordonneeOrigine);
			double quantite;
			quantite = Droite.obtenirYSachantX(prix, pente, ordonneeOrigine);

			System.out.println("La quantité demandée lorsque le prix est de "
					+ OutilsAffichage.formaterMonetaire(prix, 2) + " est "
					+ OutilsAffichage.formaterNb(quantite, 2) + "\n");
			recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_SIM_QTE);

		} while (recommencer == 'O');

	}

	/*
	 * Méthode privée qui permet de faire des simulations pour obtenir un prix
	 * (x) selon une quantité demandée (y). La méthode reçoit la pente (m) et
	 * l'ordonnée à l'origine (b) en paramètres.
	 */

	private void simulerPrix(double pente, double ordonneeOrigine) {
		// Constantes de la méthode.

		final String TITRE_SIM_PRIX = "\nSimulation de prix selon une "
				+ "quantité demandée.";

		final String QUEST_QTE_SIM = "\nEntrez la quantité demandée du "
				+ "produit pour la simulation : ";

		final String QUEST_AUTRE_SIM_PRIX = "\nVoulez-vous faire une autre "
				+ "simulation de prix "
				+ "selon une quantité demandée (O/N) ? ";

		// TODO (À COMPLÉTER). Voir page 8 de l'énoncé du TP2.
		char recommencer;
		do {
			System.out.println(TITRE_SIM_PRIX);

			double quantite;
			quantite = OutilsLecture.lireReelValide(QUEST_QTE_SIM, pente,
					ordonneeOrigine);

			double prix;
			prix = Droite.obtenirXSachantY(quantite, pente, ordonneeOrigine);

			System.out
					.println("Le prix qu'il faut fixer pour que la quantité demandée soit de "
							+ OutilsAffichage.formaterNb(quantite, 2)
							+ " est "
							+ OutilsAffichage.formaterMonetaire(prix, 2) + "\n");

			recommencer = OutilsLecture.lireOuiNon(QUEST_AUTRE_SIM_PRIX);

		} while (recommencer == 'O');
	}
}