// Auteurs : François Mathieu et Soti
// Fichier : ConsulterLimite.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterLimite permet d'afficher tous les jeux vidéo qui ont un
 * prix de vente inférieur à PrincipalTp3.PRIX_LIMITE.
 */

public class ConsulterLimite {

	/**
	 * Constructeur qui permet d'afficher tous les jeux vidéo qui ont un prix de
	 * vente inférieur à PrincipalTp3.PRIX_LIMITE.
	 * 
	 * Une recherche séquentielle de toutes les occurrences est effectuée.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public ConsulterLimite( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à afficher.";
		final String TITRE = "\nListe de tous les jeux vidéo qui ont un prix "
			+ "de vente inférieur à "
			+ OutilsAffichage.formaterMonetaire( PrincipalTp3.PRIX_LIMITE, 2 ) 
			+ ".";
		final String QUEST_CONTINUER = "\nAppuyez sur Entrée pour continuer.";


		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3. 
		 */
		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		}else {
			JeuVideo jeuVideoCourant;
			int compteurJeuVideo = 0;
			
			System.out.println(TITRE);
			
			//Recherche squentielle de toutes les occurences
			
			for (int indJeu1 = 0; indJeu1 < tabJeuxVideo.taille(); ++indJeu1) {
				
				//Obtenir le jeu vidéo courant
				jeuVideoCourant = tabJeuxVideo.obtenirJeuVideo(indJeu1);
				
				if (jeuVideoCourant.getPrix() < PrincipalTp3.PRIX_LIMITE) {
					
					//On a trouvé un jeu vidéo
					++compteurJeuVideo;
					
					jeuVideoCourant.afficherJeuVideo();
					
					OutilsLecture.lireEntree(QUEST_CONTINUER);
					
				}
			}
			System.out.println("\nIl y a " 
					+ compteurJeuVideo
					+ " jeu(x) dans la liste avec le "
					+ " prix inférieur ou égal à "
					+ OutilsAffichage.formaterMonetaire(PrincipalTp3.PRIX_LIMITE, 2)
					+ ".");
		}

		
	}
}