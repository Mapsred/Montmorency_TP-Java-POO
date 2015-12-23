// Auteur  : Soti
// Fichier : MainTp3.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe MainTp3 contient la m�thode principale du TP3 qui permet de faire
 * la gestion de jeux vid�o.
 */

public class MainTp3 {

	public static void main( String[] args ) {
		boolean peutContinuer = true;

		String nomFicTest;
		// On suppose une lecture des donn�es du clavier.
		BufferedReader fic =
				new BufferedReader( new InputStreamReader( System.in ) );

		char type =
				OutilsLecture.lireCaractereDisparate( "\nEntrez le type "
						+ "de test du programme "
						+ "(C avec clavier, F avec Fichier) : ", "CF" );

		if ( type == OutilsLecture.LECTURE_FICHIER ) {

			nomFicTest =
					OutilsFichier.lireNomFichier( "\nEntrez le nom "
							+ "du fichier qui contient les jeux d'essai : " );

			fic = OutilsFichier.ouvrirFicTexteLecture( nomFicTest );

			if ( fic == null ) {
				peutContinuer = false;
			}
		}

		if ( peutContinuer ) {

			// Lire du clavier ou d'un fichier.
			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			/*
			 * Une instance de la classe PrincipalTp3 permettra de faire la
			 * gestion de jeux vid�o.
			 */

			new PrincipalTp3();

		} else {
			System.out.println( "\nImpossible de tester le programme." );
		}
	}
}