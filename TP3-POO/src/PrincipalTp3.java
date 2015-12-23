// Auteurs : François Mathieu et Soti
// Fichier : PrincipalTp3.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe PrincipalTp3 permet de faire la gestion de jeux vidéo.
 */

public class PrincipalTp3 {

	// Constantes de la classe PrincipalTp3.
	public static final int MAX_JEUX_VIDEO = 5;
	public static final double PRIX_LIMITE = 30.00;

	/**
	 * Le constructeur permet de faire la gestion de jeux vidéo avec l'aide d'un
	 * menu.
	 */

	public PrincipalTp3() {
		// Constantes pour les messages.
		final String MESS_BIENVENUE = "\nBienvenue au programme de gestion de"
				+ " jeux vidéo.";
		final String MESS_FIN = "\nFin du programme.";

		// Constante pour le texte du menu principal.
		final String MENU_PRINCIPAL = "\nMenu principal pour la gestion "
				+ "de jeux vidéo\n\n" + "1. Consulter un jeu vidéo\n"
				+ "2. Ajouter un jeu vidéo\n" + "3. Supprimer un jeu vidéo\n"
				+ "4. Modifier un jeu vidéo\n"
				+ "5. Afficher tous les jeux vidéo\n"
				+ "6. Afficher tous les jeux vidéo qui ont un prix de vente "
				+ "inférieur à "
				+ OutilsAffichage.formaterMonetaire(PRIX_LIMITE, 2) + "\n"
				+ "7. Afficher le jeu vidéo le moins et le plus dispendieux\n"
				+ "8. Afficher la moyenne des prix de vente des jeux vidéo\n"
				+ "9. Quitter le programme";

		// Constantes pour les choix du menu principal.
		final char CONSULTER = '1';
		final char AJOUTER = '2';
		final char SUPPRIMER = '3';
		final char MODIFIER = '4';
		final char CONSULTER_TOUS = '5';
		final char CONSULTER_LIMITE = '6';
		final char PETIT_GRAND_PRIX = '7';
		final char MOYENNE_PRIX = '8';
		final char QUITTER = '9';

		/*
		 * TODO (À COMPLÉTER). Voir page 4 de l'énoncé du TP3. Vous devez
		 * utiliser les constantes aux endroits appropriés.
		 */

		System.out.println(MESS_BIENVENUE);
		// TODO ICI
		TabJeuxVideo tabJeuxVideo = new TabJeuxVideo(MAX_JEUX_VIDEO);

		char choix;
		do {
			choix = OutilsAffichage.afficherChoisirMenu(MENU_PRINCIPAL,
					CONSULTER, QUITTER);
			
			switch (choix) {
			case CONSULTER:
				new ConsulterJeuVideo(tabJeuxVideo);
			break;
			case AJOUTER:
				new AjouterJeuVideo(tabJeuxVideo);
			break;
			case SUPPRIMER:
				new SupprimerJeuVideo(tabJeuxVideo);
			break;
			case MODIFIER:
				new ModifierJeuVideo(tabJeuxVideo);
			break;
			case CONSULTER_TOUS:
				new ConsulterTousJeuxVideo(tabJeuxVideo);
			break;
			case CONSULTER_LIMITE:
				new ConsulterLimite(tabJeuxVideo);
			break;
			case PETIT_GRAND_PRIX:
				new AfficherPetitGrand(tabJeuxVideo);
			break;
			case MOYENNE_PRIX:
				new AfficherMoyenne(tabJeuxVideo);
			break;
			case QUITTER:
				System.out.println(MESS_FIN);
			}
		} while (choix != QUITTER);

	}
}