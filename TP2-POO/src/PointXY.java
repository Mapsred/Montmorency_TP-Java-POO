// Auteurs : François Mathieu et Soti
// Fichier : PointXY.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 2)

// La classe PointXY contient les données et les méthodes pour un point dans
// un plan cartésien.

public class PointXY {

	// Champs d'instance de la classe PointXY.
	// On doit trouver seulement deux données privées (champs d'instance),
	// l'abscisse x (un double) et l'ordonnée y (un double).
	private double x;
	private double y;

	// Constructeur de la classe PointXY pour construire un point à l'origine.
	public PointXY() {

		// Exécuter l'autre constructeur avec les valeurs de base 0,0.
		// Voir la classe Temps (page 19) du document 1 pour vous aider.
		this(0, 0);

	}

	// Constructeur de la classe PointXY pour construire un point à une
	// position x et y sur le plan cartésien.
	public PointXY(double x, double y) {

		// Exécuter la méthode modifierPoint. Vous devez envoyer les bons
		// paramètres à la méthode.
		modifierPoint(x, y);

	}

	// Méthode accesseur qui retourne l'abscisse x.
	public double getX() {

		// Retourner l'abscisse x.
		return this.x;

	}

	// Méthode accesseur qui retourne l'ordonnée y.
	public double getY() {

		// Retourner l'ordonnée y.
		return this.y;
	}

	// Méthode mutateur qui modifie l'abscisse x par celle reçue en paramètre.
	public void setX(double x) {

		// Modifier l'abscisse x par celle reçue en paramètre.
		this.x = x;

	}

	// Méthode mutateur qui modifie l'ordonnée y par celle reçue en paramètre.
	public void setY(double y) {

		// Modifier l'ordonnée y par celle reçue en paramètre.
		this.y = y;

	}

	// Méthode publique qui modifie les coordonnées du point par celles
	// reçues en paramètres.
	public void modifierPoint(double nouveauX, double nouveauY) {

		// Exécuter les deux méthodes mutateurs appropriées pour modifier
		// les coordonnées x et y du point par les valeurs
		// reçues en paramètres.
		this.setX(nouveauX);
		this.setY(nouveauY);

	}

	// Méthode publique qui déplace le point en x (selon deplX) et
	// en y (selon deplY) sur le plan cartésien.
	public void deplacerPoint(double deplX, double deplY) {

		// Il suffit d'ajouter tout simplement les déplacements reçus en
		// paramètres aux coordonnées x et y.

		setX(deplX + getX());
		setY(deplY + getY());

	}

	// Méthode publique qui retourne true si le point est à l'origine (0,0) et
	// false dans le cas contraire.
	public boolean estOrigine() {

		// Le point est à l'origine si sa coordonnée x est à 0 et que sa
		// coordonnée y est à 0. Aucun message ne doit apparaître à l'écran.
		// L'énoncé return doit se trouver une seule fois, à la fin
		// de la méthode.
		if (getX() == 0 && getY() == 0) {
			return true;
		} else
			return false;

	}

	// Méthode publique qui calcule et retourne la distance du point
	// par rapport à l'origine.
	public double calculerDistance() {

		// On est en présence d'un triangle rectangle. On peut donc appliquer
		// le théorème de Pythagore pour calculer l'hypoténuse qui se trouve à
		// être la distance. Le carré de l'hypoténuse est égal à la somme des
		// carrés des deux autres côtés (h2 = x2 + y2),
		// donc h = racine carrée( x2 + y2 ).
		// Il existe une méthode dans la classe Math qui permet de calculer
		// l'hypoténuse. La distance du point par rapport à l'origine est
		// donc calculée selon la formule suivante : Math.hypot( x, y ).
		// Aucun message ne doit apparaître à l'écran.

		return Math.hypot(getX(), getY());

	}

	// Méthode publique qui affiche les renseignements du point.
	public void afficherPoint() {

		// Voir la page 5 de l'énoncé du TP1 pour le format d'affichage.
		// Le format d'affichage doit être respecté.
		// Utiliser la méthode estOrigine pour savoir si le point est à
		// l'origine. Utiliser la méthode calculerDistance pour le calcul de
		// la distance.
		// La distance est affichée seulement si le point n'est pas
		// à l'origine.

		System.out.println("\nCoordonnées du point : (" + getX() + ", "
				+ getY() + ")");
		System.out.println("Le point ne se trouve pas à l'origine.");

		if (calculerDistance() != 0) {
			System.out.println("Distance du point par rapport à l'origine : "
					+ calculerDistance());
		}

	}
}
