// Auteure : Soti
// Fichier : MainTp2.java
// Date    : 25 Février 2015
// Cours   : 420-165-MO (TP2, Courbes de demande)

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/*
 * La classe MainTp2 contient la méthode principale du TP2 qui permet de faire
 * la gestion des courbes de demande en microéconomie.
 */

public class MainTp2 {

	public static void main( String[] args ) {

		boolean peutContinuer = true;

		String nomFicTest;
		// On suppose une lecture des données du clavier.
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
			 * Une instance de la classe GererCourbesDemande permettra de faire
			 * la gestion des courbes de demande en microéconomie.
			 */

			new GererCourbesDemande();

		} else {
			System.out.println( "\nImpossible de tester le programme." );
		}
	}
}