/**
 * Auteur  : Soti
 * Fichier : MainTp4.java
 * Cours   : 420-165-MO (TP4, H�tel)
 * Date    : 15 avril 2015
 */

import java.io.*;

import outilsjava.*;

/**
 * La classe MainTp4 contient la m�thode principale du TP4 qui permet de faire
 * la gestion des chambres d'un h�tel.
 */

public class MainTp4 {

	public static void main(String[] args) {
		boolean peutContinuer = true;

		String nomFicTest;
		// On suppose une lecture des donn�es du clavier.
		BufferedReader fic = new BufferedReader(
				new InputStreamReader(System.in));

		char type = OutilsLecture.lireCaractereDisparate("\nEntrez le type "
				+ "de test du programme "
				+ "(C avec clavier, F avec Fichier) : ", "CF");

		if (type == OutilsLecture.LECTURE_FICHIER) {

			nomFicTest = OutilsFichier.lireNomFichier("\nEntrez le nom "
					+ "du fichier qui contient les jeux d'essai : ");

			fic = OutilsFichier.ouvrirFicTexteLecture(nomFicTest);

			if (fic == null) {
				peutContinuer = false;
			}
		}

		if (peutContinuer) {

			// Lire du clavier ou d'un fichier.
			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			/**
			 * Une instance de la classe PrincipalTp4 permet de faire la gestion
			 * des chambres d'un h�tel.
			 */

			new PrincipalTp4();

		} else {
			System.out.println("\nImpossible de tester le programme.");
		}
	}
}