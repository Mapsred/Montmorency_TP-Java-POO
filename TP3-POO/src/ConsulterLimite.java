// Auteurs : Fran�ois Mathieu et Soti
// Fichier : ConsulterLimite.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterLimite permet d'afficher tous les jeux vid�o qui ont un
 * prix de vente inf�rieur � PrincipalTp3.PRIX_LIMITE.
 */

public class ConsulterLimite {

	/**
	 * Constructeur qui permet d'afficher tous les jeux vid�o qui ont un prix de
	 * vente inf�rieur � PrincipalTp3.PRIX_LIMITE.
	 * 
	 * Une recherche s�quentielle de toutes les occurrences est effectu�e.
	 * 
	 * L'objet qui contient le tableau des jeux vid�o est re�u en param�tre.
	 */

	public ConsulterLimite( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vid�o � afficher.";
		final String TITRE = "\nListe de tous les jeux vid�o qui ont un prix "
			+ "de vente inf�rieur � "
			+ OutilsAffichage.formaterMonetaire( PrincipalTp3.PRIX_LIMITE, 2 ) 
			+ ".";
		final String QUEST_CONTINUER = "\nAppuyez sur Entr�e pour continuer.";


		/*
		 * TODO (� COMPL�TER). Voir page 5 de l'�nonc� du TP3. 
		 */
		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		}else {
			JeuVideo jeuVideoCourant;
			int compteurJeuVideo = 0;
			
			System.out.println(TITRE);
			
			//Recherche squentielle de toutes les occurences
			
			for (int indJeu1 = 0; indJeu1 < tabJeuxVideo.taille(); ++indJeu1) {
				
				//Obtenir le jeu vid�o courant
				jeuVideoCourant = tabJeuxVideo.obtenirJeuVideo(indJeu1);
				
				if (jeuVideoCourant.getPrix() < PrincipalTp3.PRIX_LIMITE) {
					
					//On a trouv� un jeu vid�o
					++compteurJeuVideo;
					
					jeuVideoCourant.afficherJeuVideo();
					
					OutilsLecture.lireEntree(QUEST_CONTINUER);
					
				}
			}
			System.out.println("\nIl y a " 
					+ compteurJeuVideo
					+ " jeu(x) dans la liste avec le "
					+ " prix inf�rieur ou �gal � "
					+ OutilsAffichage.formaterMonetaire(PrincipalTp3.PRIX_LIMITE, 2)
					+ ".");
		}

		
	}
}