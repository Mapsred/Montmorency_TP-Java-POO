// Auteurs : Fran�ois Mathieu et Soti
// Fichier : Droite.java
// Date    : 25 F�vrier 2015
// Cours   : 420-165-MO (TP2, Courbes de demande)

// Package du programmeur.
import outilsjava.*;

/*
 * La classe Droite contient certaines m�thodes utilitaires (static) pour une
 * droite dans un plan cart�sien qui passe d'un point � un autre. Une droite est
 * une fonction qui peut �tre �crite sous la forme y = mx + b, o� m est la pente
 * et b l'ordonn�e � l'origine.
 */

public class Droite {

	/*
	 * M�thode statique qui permet de calculer et de retourner la pente (m)
	 * d'une droite. La m�thode re�oit deux points de la droite en param�tres.
	 */

	public static double calculerPente(PointXY point1, PointXY point2) {
		double m = 0;

		// TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP2.
		if (point1.getX() != point2.getX()) {
			m = (point2.getY() - point1.getY())
					/ (point2.getX() - point1.getX());
		}
		return m;
	}

	/*
	 * M�thode statique qui permet de calculer et de retourner l'ordonn�e �
	 * l'origine (b). La m�thode re�oit un point de la droite et la pente (m) en
	 * param�tres.
	 */

	public static double calculerOrdonneeOrigine(PointXY point, double pente) {

		double b;
		// TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP2. � v�rifier ?

		b = point.getY() - (pente * point.getX());

		return b;
	}

	/*
	 * M�thode statique qui permet d'afficher l'�quation de la droite y = mx +
	 * b. La m�thode re�oit la pente (m) et l'ordonn�e � l'origine (b) en
	 * param�tres.
	 */

	public static void afficherEquation(double pente, double ordonneeOrigine) {

		// TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP2.
		System.out.println(" y = " + OutilsAffichage.formaterNb(pente, 2)
				+ "x + " + OutilsAffichage.formaterNb(ordonneeOrigine, 2));
	}

	/*
	 * M�thode statique qui permet de calculer et de retourner la valeur de y
	 * dans l'�quation y = mx + b. La m�thode re�oit les valeurs de x, de la
	 * pente (m) et de l'ordonn�e � l'origine (b) en param�tres.
	 */

	public static double obtenirYSachantX(double x, double pente,
			double ordonneeOrigine) {
		double y;
		// TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP2.

		y = pente * x + ordonneeOrigine;

		return y;
	}

	/*
	 * M�thode statique qui permet de calculer et de retourner la valeur de x
	 * dans l'�quation y = mx + b. La m�thode re�oit les valeurs de y, de la
	 * pente (m) et de l'ordonn�e � l'origine (b) en param�tres.
	 */

	public static double obtenirXSachantY(double y, double pente,
			double ordonneeOrigine) {
		double x;
		// TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP2.
		x = (y - ordonneeOrigine) / pente;

		return x;
	}
}