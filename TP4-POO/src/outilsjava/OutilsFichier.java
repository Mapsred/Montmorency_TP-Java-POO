/**
 * Auteure : Soti
 * Fichier : OutilsFichier.java
 * Package : outilsjava
 * Date    : Hiver 2015
 * Cours   : Programmation avec Java
 */

// La classe OutilsFichier fait partie du package outilsjava.

package outilsjava;

// Packages du système.
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * Classe qui contient certaines méthodes utilitaires pour les fichiers. Cette
 * classe fait partie du package outilsjava.
 */

public class OutilsFichier {

	private static final int MAX_CAR_FICHIER = 250;

	/**
	 * On définit le constructeur private pour empêcher la création d'instances
	 * de la classe OutilsFichier.
	 */
	
	private OutilsFichier() {}

	/**
	 * La méthode publique lireNomFichier() permet d'afficher une question et de
	 * lire une chaîne de caractères représentant un nom physique de fichier.
	 * 
	 * @param question
	 *            La question à afficher.
	 * @return La chaîne de caractères représentant un nom physique de fichier.
	 */

	public static String lireNomFichier( String question ) {
		String nomFic;

		nomFic = OutilsLecture.lireChaineValide( question, 1, MAX_CAR_FICHIER );

		return nomFic;
	}

	/**
	 * La méthode publique ouvrirFicTexteLecture() permet d'ouvrir un fichier
	 * texte en mode lecture bufferisée.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succès et null
	 *         dans le cas contraire.
	 */

	public static BufferedReader ouvrirFicTexteLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedReader ficLecture = null;

		// Création du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

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
				System.out.println( "\nErreur, impossible de vérifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}

	/**
	 * La méthode publique ouvrirFicTexteEcriture() permet d'ouvrir un fichier
	 * texte en mode écriture bufferisée.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succès et null
	 *         dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Création du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en écriture.
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
					// Permis en écriture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en écriture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en écriture.
						// Demande une confirmation avant de l'écraser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =
								OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "écraser ce fichier ( O ou N ) ? " );

						valide = ( conf == 'O' ); // true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de vérifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis écriture, conf. écraser.
			// Ouverture du fichier texte en mode écriture.

			try {
				ficEcriture =
						Files.newBufferedWriter( chemin,
								Charset.defaultCharset() );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode écriture texte." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La méthode publique ouvrirFicTexteEcritureAjout() permet d'ouvrir un
	 * fichier texte en mode ajout de texte à la fin du fichier. Le fichier est
	 * créé, s'il n'existe pas.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succès et null
	 *         dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcritureAjout( 
														String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Création du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en écriture.
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
					// Permis en écriture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en écriture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en écriture.
						// On peut l'ouvrir en écriture pour ajouter à la fin.
						valide = true;
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de vérifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis écriture.
			// Ouverture du fichier texte en mode écriture (ajouter à la fin).

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
						+ " en mode écriture texte (ajouter à la fin)." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La méthode publique fermerFicTexteLecture() permet de fermer un fichier
	 * texte en mode lecture bufferisée.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succès et false dans le
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
	 * La méthode publique fermerFicTexteEcriture() permet de fermer un fichier
	 * texte en mode écriture bufferisée.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succès et false dans le
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
	 * La méthode publique ouvrirFicBinLecture() permet d'ouvrir un fichier
	 * sérialisé (binaire) en mode lecture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succès et null
	 *         dans le cas contraire.
	 */

	public static ObjectInputStream ouvrirFicBinLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectInputStream ficLecture = null;

		// Création du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

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
				System.out.println( "\nErreur, impossible de vérifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}


	/**
	 * La méthode publique ouvrirFicBinEcriture() permet d'ouvrir un fichier
	 * sérialisé (binaire) en mode écriture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return Le nom logique du fichier si l'ouverture est un succès et null
	 *         dans le cas contraire.
	 */

	public static ObjectOutputStream ouvrirFicBinEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectOutputStream ficEcriture = null;

		// Création du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caractères illégaux." );
			valide = false;
		}

		// Si la création du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// Vérifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en écriture.
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
					// Permis en écriture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en écriture." );
						valide = false;
					} else {
						// Fichier existe, est ordinaire et permis en écriture.
						// Demande une confirmation avant de l'écraser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =
								OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "écraser ce fichier ( O ou N ) ? " );

						valide = ( conf == 'O' ); // true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de vérifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Fichier n'existe pas.
			// Ou fichier existe, ordinaire, permis écriture, conf. écraser.
			// Ouverture du fichier texte en mode écriture.

			try {
				ficEcriture =
						new ObjectOutputStream( new FileOutputStream(
								nomFichier ) );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode écriture binaire." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La méthode publique fermerFicBinLecture() permet de fermer un fichier
	 * sérialisé (binaire) en mode lecture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succès et false dans le
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
	 * La méthode publique fermerFicBinEcriture() permet de fermer un fichier
	 * sérialisé (binaire) en mode écriture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succès et false dans le
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