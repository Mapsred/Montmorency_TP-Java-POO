/**
 * Auteurs : Fran�ois Mathieu et Soti
 * Fichier : PrincipalTp5.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Packages du syst�me.
import java.io.*;
import java.nio.file.*;
import java.util.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe PrincipalTp5 permet de g�rer un menu principal pour pour le TP5.
 * Programme de gestion des pr�ts de documents d'une biblioth�que. Cette classe
 * impl�mente l'interface OutilsConstantes.
 */

public class PrincipalTp5 implements OutilsConstantes {

	/**
	 * Le constructeur PrincipalTp5() permet de cr�er l'objet pour la
	 * biblioth�que et de pr�parer la gestion de la biblioth�que.
	 */

	public PrincipalTp5() {
		// Constantes.
		final String MESS_BIENVENUE = "\nBienvenue au programme de gestion de"
				+ " la biblioth�que Montmoblitech.";

		final String QUEST_FIC_BIBLIOTHEQUE = "\nEntrez le nom du "
				+ "fichier qui contient les donn�es de la biblioth�que : ";

		final String ERREUR_FIC_BIBLIOTHEQUE = "\nUne erreur est survenue "
				+ "avec le fichier de la biblioth�que.";

		System.out.println(MESS_BIENVENUE);

		/**
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP5.
		 * 
		 * Lorsque vous aurez termin� et test� la premi�re partie (pages 8 � 33
		 * de l'�nonc� du TP5), n'oubliez pas de faire et de tester la deuxi�me
		 * partie (pages 33 � 34 de l'�nonc� du TP5).
		 */
		Bibliotheque bibliotheque = new Bibliotheque();

		// Nom Physique du fichier
		String nomFichier;

		// Nom logique du fichier binaire en lecture
		ObjectInputStream ficLecture;

		nomFichier = OutilsFichier.lireNomFichier(QUEST_FIC_BIBLIOTHEQUE);

		ficLecture = preparerOuvertureFichier(nomFichier, bibliotheque);

		if (ficLecture == null) {
			System.out.println(ERREUR_FIC_BIBLIOTHEQUE);
		} else {
			bibliotheque = Bibliotheque.lireFicBin(ficLecture);
			OutilsFichier.fermerFicBinLecture(ficLecture, nomFichier);
			gererMenuPrincipal(bibliotheque);
			sauvegarderFichier(nomFichier, bibliotheque);
		}

		System.out.println(MESS_FIN_PROG);
	}

	/**
	 * La m�thode priv�e gererMenuPrincipal() permet de traiter le menu
	 * principal pour la gestion de la biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	private void gererMenuPrincipal(Bibliotheque bibliotheque) {
		// Constante pour les noms de mois.

		final String[] tabMois = { "Janvier", "F�vrier", "Mars", "Avril",
				"Mai", "Juin", "Juillet", "Ao�t", "Septembre", "Octobre",
				"Novembre", "D�cembre" };

		// Obtenir la date d'aujourd'hui.

		GregorianCalendar aujourdhui = new GregorianCalendar();

		int annee = aujourdhui.get(GregorianCalendar.YEAR);
		int mois = aujourdhui.get(GregorianCalendar.MONTH);
		int jour = aujourdhui.get(GregorianCalendar.DAY_OF_MONTH);

		// Constante pour le texte du menu principal.

		final String MENU_PRINCIPAL = "\nMenu principal pour la gestion de la"
				+ " biblioth�que Montmoblitech.\n" + "Date : " + jour + " "
				+ tabMois[mois] + " " + annee + "\n\n"
				+ "1. G�rer les documents\n" + "2. G�rer les abonn�s\n"
				+ "3. G�rer les pr�ts\n" + "4. Quitter le programme";

		// Constantes pour les choix du menu principal.

		final char GERER_DOCUMENTS = '1';
		final char GERER_ABONNES = '2';
		final char GERER_PRETS = '3';
		final char QUITTER = '4';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_PRINCIPAL,
					GERER_DOCUMENTS, QUITTER);

			switch (choix) {

			case GERER_DOCUMENTS:
				this.gererDocuments(bibliotheque);
				break;

			case GERER_ABONNES:
				this.gererAbonnes(bibliotheque);
				break;

			case GERER_PRETS:
				this.gererPrets(bibliotheque);
				break;
			}
		} while (choix != QUITTER);
	}

	/**
	 * La m�thode priv�e gererDocuments() permet de g�rer les documents de la
	 * biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	private void gererDocuments(Bibliotheque bibliotheque) {
		// Constante pour le texte du sous-menu pour g�rer les documents.

		final String MENU_DOCUMENTS = "\nSous-menu pour la gestion "
				+ "des documents\n\n" + "1. Ajouter un document\n"
				+ "2. Supprimer un document\n" + "3. Consulter un document\n"
				+ "4. Consulter tous les documents\n"
				+ "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour g�rer les documents.

		final char AJOUTER_DOCUMENT = '1';
		final char SUPPRIMER_DOCUMENT = '2';
		final char CONSULTER_DOCUMENT = '3';
		final char CONSULTER_TOUS_DOCUMENTS = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_DOCUMENTS,
					AJOUTER_DOCUMENT, QUITTER_SOUS_MENU);

			switch (choix) {

			case AJOUTER_DOCUMENT:
				new AjouterDocument(bibliotheque);
				break;

			case SUPPRIMER_DOCUMENT:
				new SupprimerDocument(bibliotheque);
				break;

			case CONSULTER_DOCUMENT:
				new ConsulterDocument(bibliotheque);
				break;

			case CONSULTER_TOUS_DOCUMENTS:
				new ConsulterTousDocuments(bibliotheque);
				break;

			case QUITTER_SOUS_MENU:
				System.out.println("\nFin du sous-menu pour la gestion "
						+ "des documents.");
				break;
			}
		} while (choix != QUITTER_SOUS_MENU);
	}

	/**
	 * La m�thode priv�e gererAbonnes() permet de g�rer les abonn�s de la
	 * biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	private void gererAbonnes(Bibliotheque bibliotheque) {
		// Constante pour le texte du sous-menu pour g�rer les abonn�s.

		final String MENU_ABONNES = "\nSous-menu pour la gestion"
				+ " des abonn�s\n\n" + "1. Ajouter un abonn�\n"
				+ "2. Supprimer un abonn�\n" + "3. Consulter un abonn�\n"
				+ "4. Consulter tous les abonn�s\n" + "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour g�rer les abonn�s.

		final char AJOUTER_ABONNE = '1';
		final char SUPPRIMER_ABONNE = '2';
		final char CONSULTER_ABONNE = '3';
		final char CONSULTER_TOUS_ABONNES = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_ABONNES,
					AJOUTER_ABONNE, QUITTER_SOUS_MENU);

			switch (choix) {

			case AJOUTER_ABONNE:
				new AjouterAbonne(bibliotheque);
				break;

			case SUPPRIMER_ABONNE:
				new SupprimerAbonne(bibliotheque);
				break;

			case CONSULTER_ABONNE:
				new ConsulterAbonne(bibliotheque);
				break;

			case CONSULTER_TOUS_ABONNES:
				new ConsulterTousAbonnes(bibliotheque);
				break;

			case QUITTER_SOUS_MENU:
				System.out.println("\nFin du sous-menu pour la gestion "
						+ "des abonn�s.");
				break;
			}
		} while (choix != QUITTER_SOUS_MENU);
	}

	/**
	 * La m�thode priv�e gererPrets() permet de g�rer les pr�ts de la
	 * biblioth�que.
	 * 
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	private void gererPrets(Bibliotheque bibliotheque) {
		// Constante pour le texte du sous-menu pour g�rer les pr�ts.

		final String MENU_PRETS = "\nSous-menu pour la gestion des pr�ts\n\n"
				+ "1. Emprunter un document\n" + "2. Retourner un document\n"
				+ "3. Consulter un pr�t\n" + "4. Consulter tous les pr�ts\n"
				+ "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour g�rer les pr�ts.

		final char EMPRUNTER = '1';
		final char RETOURNER = '2';
		final char CONSULTER_PRET = '3';
		final char CONSULTER_TOUS_PRETS = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_PRETS, EMPRUNTER,
					QUITTER_SOUS_MENU);

			switch (choix) {

			case EMPRUNTER:
				new EmprunterDocument(bibliotheque);
				break;

			case RETOURNER:
				new RetournerDocument(bibliotheque);
				break;

			case CONSULTER_PRET:
				new ConsulterPret(bibliotheque);
				break;

			case CONSULTER_TOUS_PRETS:
				new ConsulterTousPrets(bibliotheque);
				break;

			case QUITTER_SOUS_MENU:
				System.out.println("\nFin du sous-menu pour la gestion "
						+ "des pr�ts.");
				break;
			}
		} while (choix != QUITTER_SOUS_MENU);
	}

	/**
	 * La m�thode priv�e preparerOuvertureFichier() permet d'ouvrir le fichier
	 * de la biblioth�que en lecture. Si le fichier n'existe pas, on le cr�e
	 * sans aucune donn�e et on ouvre ce fichier par la suite en lecture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 * @return le nom logique du fichier si l'op�ration est un succ�s ou null
	 *         dans le cas contraire.
	 */

	private ObjectInputStream preparerOuvertureFichier(String nomFichier,
			Bibliotheque bibliotheque) {

		ObjectInputStream ficLecture = null;

		/**
		 * TODO (� COMPL�TER). Voir page 33 de l'�nonc� du TP5.
		 * 
		 * Cette m�thode est utilis�e dans la deuxi�me partie (pages 33 � 34 de
		 * l'�nonc� du TP5).
		 */
		ObjectOutputStream ficEcriture = null;
		Path chemin = null;
		boolean peutContinuer = true;

		// Cr�ation du chemin

		try {
			chemin = Paths.get(nomFichier);
		} catch (InvalidPathException errNomFichier) {
			System.out.println("\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux.");
			peutContinuer = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre

		if (peutContinuer) {

			// Si le fichier n'existe pas, on le cr�e avec l'objet de base
			if (Files.notExists(chemin)) {
				ficEcriture = OutilsFichier.ouvrirFicBinEcriture(nomFichier);

				if (ficEcriture == null) {
					peutContinuer = false;
				} else {
					// Le fichier n'existe pas
					// Cr�ation de ce fichier avec l'objet de base

					bibliotheque.ecrireFicBin(ficEcriture);
					OutilsFichier.fermerFicBinEcriture(ficEcriture, nomFichier);
				}
			}
		}
		// Si on peut continuer, on ouvre le fichier en lecture

		if (peutContinuer) {
			ficLecture = OutilsFichier.ouvrirFicBinLecture(nomFichier);
		}

		return ficLecture;
	}

	/**
	 * La m�thode priv�e sauvegarderFichier() permet de sauvegarder l'objet qui
	 * g�re la biblioth�que re�u en param�tre dans le fichier re�u en param�tre.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @param bibliotheque
	 *            L'objet qui g�re la biblioth�que.
	 */

	private void sauvegarderFichier(String nomFichier, Bibliotheque bibliotheque) {

		/**
		 * TODO (� COMPL�TER). Voir page 33 de l'�nonc� du TP5.
		 * 
		 * Cette m�thode est utilis�e dans la deuxi�me partie (pages 33 � 34 de
		 * l'�nonc� du TP5).
		 */
		ObjectOutputStream ficEcriture = null;

		System.out.println("\nSauvegarde du fichier " + nomFichier + ".");

		ficEcriture = OutilsFichier.ouvrirFicBinEcriture(nomFichier);

		if (ficEcriture != null) {
			bibliotheque.ecrireFicBin(ficEcriture);

			OutilsFichier.fermerFicBinEcriture(ficEcriture, nomFichier);
		}

	}
}