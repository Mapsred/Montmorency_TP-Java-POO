// Auteurs : François Mathieu et Soti
// Fichier : AfficherMoyenne.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AfficherMoyenne permet d'afficher la moyenne des prix de vente des
 * jeux vidéo.
 */

public class AfficherMoyenne {

	/**
	 * Constructeur qui permet d'afficher la moyenne des prix de vente des
	 * jeux vidéo.
	 * 
	 * L'objet qui contient le tableau des jeux vidéo est reçu en paramètre.
	 */

	public AfficherMoyenne( TabJeuxVideo tabJeuxVideo ) {
		// Constante.
		final String MESS_AUCUN = "\nIl n'y a aucun jeu vidéo à traiter.";

		
		/*
		 * TODO (À COMPLÉTER). Voir page 5 de l'énoncé du TP3. 
		 */
		if (tabJeuxVideo.estVide()) {
			System.out.println(MESS_AUCUN);
		}else {
			double totalPrix;
			double moyennePrix;
			
			//Calcul de la somme et de la moyenne des prix
			
			totalPrix = 0;
			
			for (int indJeu1 = 0; indJeu1 < tabJeuxVideo.taille(); ++indJeu1) {
				totalPrix +=
						tabJeuxVideo.obtenirJeuVideo(indJeu1).getPrix();
			}
			
			moyennePrix = totalPrix / tabJeuxVideo.taille();
			
			System.out.println("\nLa moyenne des prix est : "
					+ OutilsAffichage.formaterMonetaire(moyennePrix, 2));
		}

		
	}
}