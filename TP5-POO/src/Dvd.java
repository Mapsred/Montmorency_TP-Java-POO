/**
 * Auteur  : Soti
 * Fichier : Dvd.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Dvd hérite de la classe abstraite Document et contient les
 * données et les méthodes supplémentaires pour un DVD.
 * Cette classe implémente l'interface Serializable.
 */

public class Dvd extends Document implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un DVD.
	static final long serialVersionUID = 5;
	
	// Constantes de la classe Dvd.

	public static final int MIN_CAR_TYPE = 1;
	public static final int MAX_CAR_TYPE = 100;
	
	// Champ d'instance privé supplémentaire de la classe Dvd.
	
	private String typeDvd;
	
	/**
	 * Le constructeur Dvd() permet de construire un DVD de base.
	 * Aucun numéro de cote, aucun titre, aucun editeur et aucun type.
	 */
	
	public Dvd() {
		// Exécuter l'autre constructeur.
		this( "", "", "", "" );
	}
	
	/**
	 * Le constructeur Dvd() permet de construire un DVD connaissant son numéro
	 * de cote, son titre, son éditeur et son type. Au début le DVD est
	 * disponible.
	 * 
	 * @param cote
	 *            Le numéro de cote du DVD.
	 * @param titre
	 *            Le titre du DVD.
	 * @param editeur
	 *            L'éditeur du DVD.
	 * @param typeDvd
	 *            Le type du DVD.
	 */

	public Dvd( String cote, String titre, String editeur, String typeDvd ) {
		
		super( cote, titre, editeur );
		
		this.setTypeDvd( typeDvd );
	}

	/**
	 * La méthode accesseur getTypeDvd() permet de retourner le type du DVD.
	 * 
	 * @return Le type du DVD.
	 */

	public String getTypeDvd() {
		return this.typeDvd;
	}

	/**
	 * La méthode mutateur setTypeDvd() permet de modifier le type du DVD
	 * par celui reçu en paramètre.
	 * 
	 * @param type
	 *            Le type du DVD.
	 */

	public void setTypeDvd( String typeDvd ) {
		if ( typeDvd.length() <= Dvd.MAX_CAR_TYPE ) {

			this.typeDvd = typeDvd;
		}
	}

	/**
	 * La méthode publique lireTypeDvd() permet de lire le type du DVD et de
	 * modifier le champ du type du DVD.
	 */
	
	public void lireTypeDvd() {
		final String QUEST_TYPE = "\nEntrez le type du DVD (entre "
				+ Dvd.MIN_CAR_TYPE + " et " + Dvd.MAX_CAR_TYPE + " car.) : ";
		
		String typeDvd;
		
		typeDvd = OutilsLecture.lireChaineValide( QUEST_TYPE, 
					Dvd.MIN_CAR_TYPE, Dvd.MAX_CAR_TYPE );

		this.setTypeDvd( typeDvd );
	}

	/**
	 * Redéfinition de la méthode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du DVD, connaissant le numéro de cote du
	 * document.
	 */
	
	@Override
	public void lireAutresRenseignements() {
		super.lireAutresRenseignements();
		
		this.lireTypeDvd();
	}

	/**
	 * Redéfinition de la méthode afficher() qui permet d'afficher tous les
	 * renseignements du DVD.
	 */

	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println( "Type :\t\t\t" + this.getTypeDvd() );

		super.afficherDisponibilite();
	}

	/**
	 * Redéfinition de la méthode toString().
	 * 
	 * @return les informations du DVD sous forme de chaîne de
	 *         caractères.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getTypeDvd() + "]";

	   return infos;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirType() qui retourne le type
	 * de document représentant un DVD.
	 * 
	 * @return le caractère représentant un DVD : D.
	 */
	
	@Override
	public char obtenirType() {
		return Document.DVD;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de chaînes de caractères.
	 */
	
	@Override
	public String obtenirDescription() {
		return "DVD";
	}
}