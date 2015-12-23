// Auteurs : François Mathieu et Soti
// Fichier : MainPartie2.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 2, PointXY)

// La classe MainPartie2 contient la méthode principale main()
// pour tester la classe PointXY.

public class MainPartie2 {

	// Méthode principale main().
	public static void main(String[] args) {
		PointXY point1, point2;

		System.out.println("\nTESTER new PointXY() pour le point 1.");

		point1 = new PointXY();

		System.out.println("\nTESTER new PointXY(5,10) pour le point 2.");

		point2 = new PointXY(5, 10);

		System.out.println("\nTESTER afficherPoint() pour le point 1 "
				+ "( ( 0.0, 0.0 ), origine ).");

		point1.afficherPoint();

		System.out.println("\nTESTER afficherPoint() pour le point 2 "
				+ "( ( 5.0, 10.0 ), pas à l'origine, 11.180 ).");

		point2.afficherPoint();

		System.out.println("\nTESTER estOrigine() pour le point 1 (0,0) "
				+ "( true ).");

		System.out
				.println("\nestOrigine() de point 1 : " + point1.estOrigine());

		System.out.println("\nTESTER estOrigine() pour le point 2 (5,10) "
				+ "( false ).");

		System.out
				.println("\nestOrigine() de point 2 : " + point2.estOrigine());

		System.out.println("\nTESTER setX(0) pour le point 2 (0,10) ");

		point2.setX(0);

		System.out.println("\nTESTER estOrigine() pour le point 2 (0,10) "
				+ "( false ).");

		System.out
				.println("\nestOrigine() de point 2 : " + point2.estOrigine());

		System.out.println("\nTESTER setY(0) pour le point 2 (0,0) ");

		point2.setY(0);

		System.out.println("\nTESTER estOrigine() pour le point 2 (0,0) "
				+ "( true ).");

		System.out
				.println("\nestOrigine() de point 2 : " + point2.estOrigine());

		System.out.println("\nTESTER getX() et getY() pour "
				+ "le point 2 (0,0) ");

		System.out.println("\n(x, y) du point 2 : (" + point2.getX() + ", "
				+ point2.getY() + ")");

		System.out.println("\nTESTER modifierPoint(2,0) pour le point 1 ");

		point1.modifierPoint(2, 0);

		System.out.println("\n(x, y) du point 1 : (" + point1.getX() + ", "
				+ point1.getY() + ")");

		System.out.println("\nTESTER estOrigine() pour le point 1 (2,0) "
				+ "( false ).");

		System.out
				.println("\nestOrigine() de point 1 : " + point1.estOrigine());

		System.out.println("\nTESTER deplacerPoint(5,3) pour "
				+ "le point 1 (7,3) ");

		point1.deplacerPoint(5, 3);

		System.out.println("\n(x, y) du point 1 : (" + point1.getX() + ", "
				+ point1.getY() + ")");

		System.out.println("\nTESTER deplacerPoint(-1,-5) pour "
				+ "le point 1 (6,-2) ");

		point1.deplacerPoint(-1, -5);

		System.out.println("\n(x, y) du point 1 : (" + point1.getX() + ", "
				+ point1.getY() + ")");

		System.out.println("\nTESTER calculerDistance() "
				+ "pour le point 1 (6,-2) : (6.324).");

		System.out.println("\nDistance du point 1 : "
				+ point1.calculerDistance());

		System.out.println("\nTESTER afficherPoint() du point 1 "
				+ "( (6,-2), pas origine, 6.324 ).");

		point1.afficherPoint();

		System.out.println("\nTESTER afficherPoint() du point 2 "
				+ "( (0,0), origine ).");

		point2.afficherPoint();

		// separation

		PointXY point3, point4;

		System.out.println("\nTESTER new PointXY() pour le point 3.");

		point3 = new PointXY();

		System.out.println("\nTESTER new PointXY(10,15) pour le point 4.");

		point4 = new PointXY(10, 15);

		System.out.println("\nTESTER afficherPoint() pour le point 3 "
				+ "( ( 0.0, 0.0 ), origine ).");

		point3.afficherPoint();

		System.out.println("\nTESTER afficherPoint() pour le point 4 "
				+ "( ( 5.0, 10.0 ), pas à l'origine, 11.180 ).");

		point4.afficherPoint();

		// Vous devez ajouter des instructions qui permettent
		// de créer un autre objet de la classe PointXY avec au moins deux
		// exemples d'utilisation des méthodes publiques de la classe PointXY.

	}
}
