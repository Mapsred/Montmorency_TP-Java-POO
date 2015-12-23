/**
 * Auteure : Soti
 * Fichier : OutilsFichier.java
 * Package : outilsjava
 * Date    : Hiver 2015
 * Cours   : Programmation avec Java
 */

// La classe OutilsFichier fait partie du package outilsjava.

package outilsjava;

// Packages du syst�me.
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * Classe qui contient certaines m�thodes utilitaires pour les fichiers. Cette
 * classe fait partie du package outilsjava.
 */

public class OutilsFichier {

	private static final int MAX_CAR_FICHIER = 250;

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances
	 * de la classe OutilsFichier.
	 */
	
	private OutilsFichier() {}

	/**
	 * La m�thode publique lireNomFichier() permet d'afficher une question et de
	 * lire une cha�ne de caract�res repr�sentant un nom physique de fichier.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return La cha�ne de caract�res repr�sentant un nom physique de fichier.
	 */

	public static String lireNomFichier( String question ) {
		String nomFic;

		nomFic = OutilsLecture.lireChaineValide( question, 1, MAX_CAR_FICHIER );

		return nomFic;
	}

	/**
	 * La m�thode publique ouvrirFicTexteLecture() permet d'ouvrir un fichier
	 * texte en mode lecture bufferis�e.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succ�s et null
	 *         dans le cas contraire.
	 */

	public static BufferedReader ouvrirFicTexteLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedReader ficLecture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas.
				System.out.println( "\nErreur, le fichier " + cheminAbsolu
						+ " n'existe pas." );
				valide = false;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Permis en lecture ?

					if ( !Files.isReadable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en lecture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en lecture.
						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture =
									Files.newBufferedReader( chemin,
											Charset.defaultCharset() );
						}
						catch ( IOException errIO ) {
							System.out
									.println( "\nErreur, impossible d'ouvrir "
											+ "le fichier " + cheminAbsolu
											+ " en mode lecture texte." );
							valide = false;
						}
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}

	/**
	 * La m�thode publique ouvrirFicTexteEcriture() permet d'ouvrir un fichier
	 * texte en mode �criture bufferis�e.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succ�s et null
	 *         dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en �criture.
						// Demande une confirmation avant de l'�craser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =
								OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "�craser ce fichier ( O ou N ) ? " );

						valide = ( conf == 'O' ); // true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis �criture, conf. �craser.
			// Ouverture du fichier texte en mode �criture.

			try {
				ficEcriture =
						Files.newBufferedWriter( chemin,
								Charset.defaultCharset() );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture texte." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique ouvrirFicTexteEcritureAjout() permet d'ouvrir un
	 * fichier texte en mode ajout de texte � la fin du fichier. Le fichier est
	 * cr��, s'il n'existe pas.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succ�s et null
	 *         dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcritureAjout( 
														String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en �criture.
						// On peut l'ouvrir en �criture pour ajouter � la fin.
						valide = true;
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis �criture.
			// Ouverture du fichier texte en mode �criture (ajouter � la fin).

			try {
				ficEcriture =
						Files.newBufferedWriter( chemin,
								Charset.defaultCharset(),
								StandardOpenOption.CREATE,
								StandardOpenOption.APPEND );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture texte (ajouter � la fin)." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique fermerFicTexteLecture() permet de fermer un fichier
	 * texte en mode lecture bufferis�e.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s et false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicTexteLecture( BufferedReader nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique fermerFicTexteEcriture() permet de fermer un fichier
	 * texte en mode �criture bufferis�e.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s et false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicTexteEcriture( BufferedWriter nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique ouvrirFicBinLecture() permet d'ouvrir un fichier
	 * s�rialis� (binaire) en mode lecture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succ�s et null
	 *         dans le cas contraire.
	 */

	public static ObjectInputStream ouvrirFicBinLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectInputStream ficLecture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas.
				System.out.println( "\nErreur, le fichier " + cheminAbsolu
						+ " n'existe pas." );
				valide = false;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Permis en lecture ?

					if ( !Files.isReadable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en lecture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en lecture.
						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture =
									new ObjectInputStream( new FileInputStream(
											nomFichier ) );
						}
						catch ( IOException errIO ) {
							System.out
									.println( "\nErreur, impossible d'ouvrir "
											+ "le fichier " + cheminAbsolu
											+ " en mode lecture binaire." );
							valide = false;
						}
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}


	/**
	 * La m�thode publique ouvrirFicBinEcriture() permet d'ouvrir un fichier
	 * s�rialis� (binaire) en mode �criture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succ�s et null
	 *         dans le cas contraire.
	 */

	public static ObjectOutputStream ouvrirFicBinEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectOutputStream ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en �criture.
						// Demande une confirmation avant de l'�craser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =
								OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "�craser ce fichier ( O ou N ) ? " );

						valide = ( conf == 'O' ); // true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis �criture, conf. �craser.
			// Ouverture du fichier texte en mode �criture.

			try {
				ficEcriture =
						new ObjectOutputStream( new FileOutputStream(
								nomFichier ) );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture binaire." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique fermerFicBinLecture() permet de fermer un fichier
	 * s�rialis� (binaire) en mode lecture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s et false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicBinLecture( ObjectInputStream nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique fermerFicBinEcriture() permet de fermer un fichier
	 * s�rialis� (binaire) en mode �criture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s et false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicBinEcriture( ObjectOutputStream nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}
}