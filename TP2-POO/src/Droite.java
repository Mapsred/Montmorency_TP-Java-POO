// Auteurs : François Mathieu et Soti
// Fichier : Droite.java
// Date    : 25 Février 2015
// Cours   : 420-165-MO (TP2, Courbes de demande)

// Package du programmeur.
import outilsjava.*;

/*
 * La classe Droite contient certaines méthodes utilitaires (static) pour une
 * droite dans un plan cartésien qui passe d'un point à un autre. Une droite est
 * une fonction qui peut être écrite sous la forme y = mx + b, où m est la pente
 * et b l'ordonnée à l'origine.
 */

public class Droite {

	/*
	 * Méthode statique qui permet de calculer et de retourner la pente (m)
	 * d'une droite. La méthode reçoit deux points de la droite en paramètres.
	 */

	public static double calculerPente(PointXY point1, PointXY point2) {
		double m = 0;

		// TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP2.
		if (point1.getX() != point2.getX()) {
			m = (point2.getY() - point1.getY())
					/ (point2.getX() - point1.getX());
		}
		return m;
	}

	/*
	 * Méthode statique qui permet de calculer et de retourner l'ordonnée à
	 * l'origine (b). La méthode reçoit un point de la droite et la pente (m) en
	 * paramètres.
	 */

	public static double calculerOrdonneeOrigine(PointXY point, double pente) {

		double b;
		// TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP2. À vérifier ?

		b = point.getY() - (pente * point.getX());

		return b;
	}

	/*
	 * Méthode statique qui permet d'afficher l'équation de la droite y = mx +
	 * b. La méthode reçoit la pente (m) et l'ordonnée à l'origine (b) en
	 * paramètres.
	 */

	public static void afficherEquation(double pente, double ordonneeOrigine) {

		// TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP2.
		System.out.println(" y = " + OutilsAffichage.formaterNb(pente, 2)
				+ "x + " + OutilsAffichage.formaterNb(ordonneeOrigine, 2));
	}

	/*
	 * Méthode statique qui permet de calculer et de retourner la valeur de y
	 * dans l'équation y = mx + b. La méthode reçoit les valeurs de x, de la
	 * pente (m) et de l'ordonnée à l'origine (b) en paramètres.
	 */

	public static double obtenirYSachantX(double x, double pente,
			double ordonneeOrigine) {
		double y;
		// TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP2.

		y = pente * x + ordonneeOrigine;

		return y;
	}

	/*
	 * Méthode statique qui permet de calculer et de retourner la valeur de x
	 * dans l'équation y = mx + b. La méthode reçoit les valeurs de y, de la
	 * pente (m) et de l'ordonnée à l'origine (b) en paramètres.
	 */

	public static double obtenirXSachantY(double y, double pente,
			double ordonneeOrigine) {
		double x;
		// TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP2.
		x = (y - ordonneeOrigine) / pente;

		return x;
	}
}