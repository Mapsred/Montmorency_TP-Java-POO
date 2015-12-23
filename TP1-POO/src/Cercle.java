// Auteurs : François Mathieu et Soti
// Fichier : Cercle.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 1)

// La classe Cercle contient les données et les méthodes pour un cercle.

public class Cercle {

	// Champ d'instance de la classe Cercle.
	// On doit trouver une seule donnée privée (champ d'instance),
	// le rayon du cercle (un double).

	private double rayon;

	// Constructeur de la classe Cercle pour construire un cercle
	// avec le rayon reçu en paramètre.
	public Cercle(double rayon) {

		// Exécuter la méthode mutateur appropriée pour modifier
		// le champ d'instance par la valeur reçue en paramètre.
		this.setRayon(rayon);

	}

	// Méthode accesseur qui retourne le rayon du cercle.
	public double getRayon() {

		// Retourner le rayon du cercle.

		return this.rayon;

	}

	// Méthode mutateur qui modifie le rayon du cercle avec celui
	// reçu en paramètre.
	public void setRayon(double rayon) {

		// Modifier le rayon du cercle par celui reçu en paramètre.
		this.rayon = rayon;

	}

	// Méthode publique qui calcule et retourne le diamètre du cercle.
	public double calculerDiametre() {

		// Calculer et retourner le diamètre du cercle selon la formule
		// suivante : 2 * rayon.
		double diametre = 2 * getRayon();
		return diametre;

	}

	// Méthode publique qui calcule et retourne la circonférence du cercle.
	public double calculerCirconference() {

		// Calculer et retourner la circonférence du cercle selon la formule
		// suivante : diamètre * PI. Utiliser la méthode calculerDiametre()
		// pour obtenir la valeur du diamètre. Utiliser Math.PI pour obtenir
		// la valeur de PI. Aucun message ne doit apparaître à l'écran.
		double circonference = calculerDiametre() * Math.PI;
		return circonference;

	}

	// Méthode publique qui calcule et retourne la surface du cercle.
	public double calculerSurface() {

		// Calculer et retourner la surface du cercle selon la formule
		// suivante : PI * rayon * rayon. Utiliser Math.PI pour obtenir
		// la valeur de PI. Aucun message ne doit apparaître à l'écran.
		double surface = Math.PI * getRayon() * getRayon();
		return surface;

	}

	// Méthode publique qui affiche les renseignements du cercle.
	public void afficherCercle() {

		// Voir la page 3 de l'énoncé du TP1 pour le format d'affichage.
		// Le format d'affichage doit être respecté.
		System.out.println("Renseignements du cercle\n");
		System.out.println("Rayon :\t\t" + getRayon());
		System.out.println("Diamètre :\t" + calculerDiametre());
		System.out.println("Circonférence :\t" + calculerCirconference());
		System.out.println("Surface :\t" + calculerSurface());

	}
}
