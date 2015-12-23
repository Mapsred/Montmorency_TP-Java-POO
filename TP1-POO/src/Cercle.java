// Auteurs : Fran�ois Mathieu et Soti
// Fichier : Cercle.java
// Date    : 11 f�vrier 2015
// Cours   : 420-165-MO (TP1, Partie 1)

// La classe Cercle contient les donn�es et les m�thodes pour un cercle.

public class Cercle {

	// Champ d'instance de la classe Cercle.
	// On doit trouver une seule donn�e priv�e (champ d'instance),
	// le rayon du cercle (un double).

	private double rayon;

	// Constructeur de la classe Cercle pour construire un cercle
	// avec le rayon re�u en param�tre.
	public Cercle(double rayon) {

		// Ex�cuter la m�thode mutateur appropri�e pour modifier
		// le champ d'instance par la valeur re�ue en param�tre.
		this.setRayon(rayon);

	}

	// M�thode accesseur qui retourne le rayon du cercle.
	public double getRayon() {

		// Retourner le rayon du cercle.

		return this.rayon;

	}

	// M�thode mutateur qui modifie le rayon du cercle avec celui
	// re�u en param�tre.
	public void setRayon(double rayon) {

		// Modifier le rayon du cercle par celui re�u en param�tre.
		this.rayon = rayon;

	}

	// M�thode publique qui calcule et retourne le diam�tre du cercle.
	public double calculerDiametre() {

		// Calculer et retourner le diam�tre du cercle selon la formule
		// suivante : 2 * rayon.
		double diametre = 2 * getRayon();
		return diametre;

	}

	// M�thode publique qui calcule et retourne la circonf�rence du cercle.
	public double calculerCirconference() {

		// Calculer et retourner la circonf�rence du cercle selon la formule
		// suivante : diam�tre * PI. Utiliser la m�thode calculerDiametre()
		// pour obtenir la valeur du diam�tre. Utiliser Math.PI pour obtenir
		// la valeur de PI. Aucun message ne doit appara�tre � l'�cran.
		double circonference = calculerDiametre() * Math.PI;
		return circonference;

	}

	// M�thode publique qui calcule et retourne la surface du cercle.
	public double calculerSurface() {

		// Calculer et retourner la surface du cercle selon la formule
		// suivante : PI * rayon * rayon. Utiliser Math.PI pour obtenir
		// la valeur de PI. Aucun message ne doit appara�tre � l'�cran.
		double surface = Math.PI * getRayon() * getRayon();
		return surface;

	}

	// M�thode publique qui affiche les renseignements du cercle.
	public void afficherCercle() {

		// Voir la page 3 de l'�nonc� du TP1 pour le format d'affichage.
		// Le format d'affichage doit �tre respect�.
		System.out.println("Renseignements du cercle\n");
		System.out.println("Rayon :\t\t" + getRayon());
		System.out.println("Diam�tre :\t" + calculerDiametre());
		System.out.println("Circonf�rence :\t" + calculerCirconference());
		System.out.println("Surface :\t" + calculerSurface());

	}
}
