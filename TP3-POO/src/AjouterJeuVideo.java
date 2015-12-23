// Auteurs : François Mathieu et Soti
// Fichier : AjouterJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterJeuVideo permet d'ajouter des jeux vidéo.
 */

public class AjouterJeuVideo {

	/**
	 * Constructeur qui permet d'ajouter un jeu vidéo tant que l'utilisateur le
	 * désire.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public AjouterJeuVideo( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String TITRE_AJOUTER = "\nAjouter un jeu vidéo.";
		final String MESS_PLEIN = "\nLe nombre maximum de jeux vidéo "
				+ "est atteint.";
		final String MESS_DEVENU_PLEIN = "\nAjout terminé. Le nombre maximum "
				+ "de jeux vidéo est atteint.";
		final String QUEST_AUTRE_AJOUT = "\nVoulez-vous ajouter " 
				+ "un autre jeu vidéo (O ou N) ? ";
		
		char rep = 'N';
		JeuVideo jeuVideo;
		int indTrouve;

		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3. 
		 */
		if (tabJeuxVideo.estPlein()) {
			System.out.println(MESS_PLEIN);
		}else {
			do {
				System.out.println(TITRE_AJOUTER);
				
				jeuVideo = new JeuVideo(); //Un objet JeuVideo de base
				
				jeuVideo.lireNoJeuVideo();
				
				indTrouve = tabJeuxVideo.chercher(jeuVideo);
				
				if (indTrouve != -1) {
					//Le jeuVideo est déjà présent
					System.out.println("\nLe jeu vidéo avec le numéro "
					+ jeuVideo.getNoJeuVideo() + " est déjà présent");
				}else {
					//Le jeu vidéo n'est pas présent
					
					//Lire les autres renseignements du jeu video et 
					//ajouter le jeu vidéo dans le tableau des jeux videos
					
					jeuVideo.lireAutresRenseignements();
					
					tabJeuxVideo.ajouter(jeuVideo);
					
					System.out.println("\nLe jeu avec le numéro " 
					+ jeuVideo.getNoJeuVideo() + "a été ajouté.");
				}
				
				if (tabJeuxVideo.estPlein() ) {
					System.out.println(MESS_DEVENU_PLEIN);
					rep = 'N'; //Ne pas ajouter un autre jeu video
				}else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_AJOUT);
				}
				
				
			}while (rep == 'O');
		}

		
	}
}