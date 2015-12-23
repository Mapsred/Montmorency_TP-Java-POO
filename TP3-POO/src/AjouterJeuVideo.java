// Auteurs : Fran�ois Mathieu et Soti
// Fichier : AjouterJeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterJeuVideo permet d'ajouter des jeux vid�o.
 */

public class AjouterJeuVideo {

	/**
	 * Constructeur qui permet d'ajouter un jeu vid�o tant que l'utilisateur le
	 * d�sire.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public AjouterJeuVideo( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String TITRE_AJOUTER = "\nAjouter un jeu vid�o.";
		final String MESS_PLEIN = "\nLe nombre maximum de jeux vid�o "
				+ "est atteint.";
		final String MESS_DEVENU_PLEIN = "\nAjout termin�. Le nombre maximum "
				+ "de jeux vid�o est atteint.";
		final String QUEST_AUTRE_AJOUT = "\nVoulez-vous ajouter " 
				+ "un autre jeu vid�o (O ou N) ? ";
		
		char rep = 'N';
		JeuVideo jeuVideo;
		int indTrouve;

		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3. 
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
					//Le jeuVideo est d�j� pr�sent
					System.out.println("\nLe jeu vid�o avec le num�ro "
					+ jeuVideo.getNoJeuVideo() + " est d�j� pr�sent");
				}else {
					//Le jeu vid�o n'est pas pr�sent
					
					//Lire les autres renseignements du jeu video et 
					//ajouter le jeu vid�o dans le tableau des jeux videos
					
					jeuVideo.lireAutresRenseignements();
					
					tabJeuxVideo.ajouter(jeuVideo);
					
					System.out.println("\nLe jeu avec le num�ro " 
					+ jeuVideo.getNoJeuVideo() + "a �t� ajout�.");
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