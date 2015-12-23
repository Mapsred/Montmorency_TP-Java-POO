// Auteurs : Fran�ois Mathieu et Soti
// Fichier : MainPartie1.java
// Date    : 11 f�vrier 2015
// Cours   : 420-165-MO (TP1, Partie 1, Cercle)

// La classe MainPartie1 contient la m�thode principale main()
// pour tester la classe Cercle.

public class MainPartie1 {

	// M�thode principale main().
	public static void main(String[] args) {
		Cercle cercle1, cercle2;

		System.out.println("\nTESTER new Cercle() pour les cercles 1 et 2.");

		cercle1 = new Cercle(10);
		cercle2 = new Cercle(30);

		System.out.println("\nTESTER afficherCercle() pour le cercle 1 "
				+ "(10.0, 20.0, 62.831, 314.159).");

		cercle1.afficherCercle();

		System.out.println("\nTESTER afficherCercle() pour le cercle 2 "
				+ "(30.0, 60.0, 188.495, 2827.433).");

		cercle2.afficherCercle();

		System.out.println("\nTESTER setRayon(15) pour le cercle 2.");

		cercle2.setRayon(15);

		System.out.println("\nTESTER getRayon() pour le cercle 2.");

		System.out.println("\nNouveau Rayon du cercle2 (15.0) : "
				+ cercle2.getRayon());

		System.out.println("\nTESTER calculerDiametre() pour le cercle 2.");

		System.out.println("\nNouveau Diam�tre du cercle2 (30.0) : "
				+ cercle2.calculerDiametre());

		System.out.println("\nTESTER calculerCirconference() "
				+ "pour le cercle 2.");

		System.out.println("\nNouvelle Circonf�rence du cercle2 (94.247) : "
				+ cercle2.calculerCirconference());

		System.out.println("\nTESTER calculerSurface() pour le cercle 2.");

		System.out.println("\nNouvelle Surface du cercle2 (706.858) : "
				+ cercle2.calculerSurface());
		System.out.println("\nNouvelles donn�es\n");
		Cercle cercle3;

		cercle3 = new Cercle(25);

		System.out.println("\nTESTER setRayon(30) pour le cercle 3.");

		cercle3.setRayon(30);
		System.out.println("\nTESTER afficherCercle() pour cercle 3"
				+ "30.0,60.0,188.495,1827.43\n");
		cercle1.afficherCercle();

		// Vous devez ajouter des instructions qui permettent
		// de cr�er un autre objet de la classe Cercle avec au moins deux
		// exemples d'utilisation des m�thodes publiques de la classe Cercle.

	}
}
