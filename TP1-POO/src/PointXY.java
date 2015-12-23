// Auteurs : Fran�ois Mathieu et Soti
// Fichier : PointXY.java
// Date    : 11 f�vrier 2015
// Cours   : 420-165-MO (TP1, Partie 2)

// La classe PointXY contient les donn�es et les m�thodes pour un point dans
// un plan cart�sien.

public class PointXY {

	// Champs d'instance de la classe PointXY.
	// On doit trouver seulement deux donn�es priv�es (champs d'instance),
	// l'abscisse x (un double) et l'ordonn�e y (un double).
	private double x;
	private double y;

	// Constructeur de la classe PointXY pour construire un point � l'origine.
	public PointXY() {

		// Ex�cuter l'autre constructeur avec les valeurs de base 0,0.
		// Voir la classe Temps (page 19) du document 1 pour vous aider.
		this(0, 0);

	}

	// Constructeur de la classe PointXY pour construire un point � une
	// position x et y sur le plan cart�sien.
	public PointXY(double x, double y) {

		// Ex�cuter la m�thode modifierPoint. Vous devez envoyer les bons
		// param�tres � la m�thode.
		modifierPoint(x, y);

	}

	// M�thode accesseur qui retourne l'abscisse x.
	public double getX() {

		// Retourner l'abscisse x.
		return this.x;

	}

	// M�thode accesseur qui retourne l'ordonn�e y.
	public double getY() {

		// Retourner l'ordonn�e y.
		return this.y;
	}

	// M�thode mutateur qui modifie l'abscisse x par celle re�ue en param�tre.
	public void setX(double x) {

		// Modifier l'abscisse x par celle re�ue en param�tre.
		this.x = x;

	}

	// M�thode mutateur qui modifie l'ordonn�e y par celle re�ue en param�tre.
	public void setY(double y) {

		// Modifier l'ordonn�e y par celle re�ue en param�tre.
		this.y = y;

	}

	// M�thode publique qui modifie les coordonn�es du point par celles
	// re�ues en param�tres.
	public void modifierPoint(double nouveauX, double nouveauY) {

		// Ex�cuter les deux m�thodes mutateurs appropri�es pour modifier
		// les coordonn�es x et y du point par les valeurs
		// re�ues en param�tres.
		this.setX(nouveauX);
		this.setY(nouveauY);

	}

	// M�thode publique qui d�place le point en x (selon deplX) et
	// en y (selon deplY) sur le plan cart�sien.
	public void deplacerPoint(double deplX, double deplY) {

		// Il suffit d'ajouter tout simplement les d�placements re�us en
		// param�tres aux coordonn�es x et y.

		setX(deplX + getX());
		setY(deplY + getY());

	}

	// M�thode publique qui retourne true si le point est � l'origine (0,0) et
	// false dans le cas contraire.
	public boolean estOrigine() {

		// Le point est � l'origine si sa coordonn�e x est � 0 et que sa
		// coordonn�e y est � 0. Aucun message ne doit appara�tre � l'�cran.
		// L'�nonc� return doit se trouver une seule fois, � la fin
		// de la m�thode.
		if (getX() == 0 && getY() == 0) {
			return true;
		} else
			return false;

	}

	// M�thode publique qui calcule et retourne la distance du point
	// par rapport � l'origine.
	public double calculerDistance() {

		// On est en pr�sence d'un triangle rectangle. On peut donc appliquer
		// le th�or�me de Pythagore pour calculer l'hypot�nuse qui se trouve �
		// �tre la distance. Le carr� de l'hypot�nuse est �gal � la somme des
		// carr�s des deux autres c�t�s (h2 = x2 + y2),
		// donc h = racine carr�e( x2 + y2 ).
		// Il existe une m�thode dans la classe Math qui permet de calculer
		// l'hypot�nuse. La distance du point par rapport � l'origine est
		// donc calcul�e selon la formule suivante : Math.hypot( x, y ).
		// Aucun message ne doit appara�tre � l'�cran.

		return Math.hypot(getX(), getY());

	}

	// M�thode publique qui affiche les renseignements du point.
	public void afficherPoint() {

		// Voir la page 5 de l'�nonc� du TP1 pour le format d'affichage.
		// Le format d'affichage doit �tre respect�.
		// Utiliser la m�thode estOrigine pour savoir si le point est �
		// l'origine. Utiliser la m�thode calculerDistance pour le calcul de
		// la distance.
		// La distance est affich�e seulement si le point n'est pas
		// � l'origine.

		System.out.println("\nCoordonn�es du point : (" + getX() + ", "
				+ getY() + ")");
		System.out.println("Le point ne se trouve pas � l'origine.");

		if (calculerDistance() != 0) {
			System.out.println("Distance du point par rapport � l'origine : "
					+ calculerDistance());
		}

	}
}
