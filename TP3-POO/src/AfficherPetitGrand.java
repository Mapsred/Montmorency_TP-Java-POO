// Auteurs : François Mathieu et Soti
// Fichier : AfficherPetitGrand.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

/**
 * La classe AfficherPetitGrand permet d'afficher le jeu vidéo le moins
 * et le plus dispendieux.
 */

public class AfficherPetitGrand {

	/**
	 * Constructeur qui permet d'afficher le jeu vidéo le moins et le plus
	 * dispendieux.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public AfficherPetitGrand( TabJeuxVideo tabJeuxVideo ) {
		// Constantes.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à traiter.";
		final String MESS_MOINS = "\nJeu vidéo le moins dispendieux : ";
		final String MESS_PLUS = "\nJeu vidéo le plus dispendieux : ";

		
		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3. 
		 */
		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		}else {
			int indPetitPrix, indGrandPrix;
			double petitPrix, grandPrix;
			JeuVideo jeuVideoCourant;
			
			//On suppose que c'est le premier jeu qui a le plus petit
			//et le plus grand prix
			
			indPetitPrix = indGrandPrix = 0;
			petitPrix = grandPrix = tabJeuxVideo.obtenirJeuVideo(0).getPrix();
			
			//On compare les autres jeux videos
			
			for (int indJeu1 = 1; indJeu1 < tabJeuxVideo.taille(); ++indJeu1) {
				//Obtenir le jeu courant
				jeuVideoCourant = tabJeuxVideo.obtenirJeuVideo(indJeu1);
				
				if (jeuVideoCourant.getPrix() < petitPrix ) {
					petitPrix = jeuVideoCourant.getPrix();
					indPetitPrix = indJeu1;
				}else if (jeuVideoCourant.getPrix() > grandPrix){
					grandPrix = jeuVideoCourant.getPrix();
					indGrandPrix = indJeu1;
				}				
			}
			System.out.println(MESS_MOINS);
			tabJeuxVideo.obtenirJeuVideo(indPetitPrix).afficherJeuVideo();
			System.out.println(MESS_PLUS);
			tabJeuxVideo.obtenirJeuVideo(indGrandPrix).afficherJeuVideo();
			
		}
		

		
	}
}