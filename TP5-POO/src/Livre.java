/**
 * Auteur  : Soti
 * Fichier : Livre.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Livre hérite de la classe abstraite Document et contient les
 * données et les méthodes supplémentaires pour un livre.
 * Cette classe implémente l'interface Serializable.
 */

public class Livre extends Document implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un livre.
	static final long serialVersionUID = 6;
	
	// Constantes de la classe Livre.

	public static final int MIN_CAR_AUTEUR = 1;
	public static final int MAX_CAR_AUTEUR = 100;
	public static final int NB_CAR_ISBN    = 13;
	
	// Champs d'instance privés supplémentaires de la classe Livre.
	
	private String auteur;
	private String isbn; // International Standard Book Number.

	/**
	 * Le constructeur Livre() permet de construire un livre de base.
	 * Aucun numéro de cote, aucun titre, aucun editeur, aucun auteur et
	 * aucun isbn. 
	 */
	
	public Livre() {
		// Exécuter l'autre constructeur.
		this( "", "", "", "", "" );
	}
	
	/**
	 * Le constructeur Livre() permet de construire un livre connaissant son
	 * numéro de cote, son titre, son éditeur, son auteur et son isbn. Au début
	 * le livre est disponible.
	 * 
	 * @param cote
	 *            Le numéro de cote du livre.
	 * @param titre
	 *            Le titre du livre.
	 * @param editeur
	 *            L'éditeur du livre.
	 * @param auteur
	 *            L'auteur du livre.
	 * @param isbn
	 *            Le isbn du livre.
	 */

	public Livre( String cote, String titre, String editeur, String auteur,
				  String isbn ) {
		
		super( cote, titre, editeur );
		
		this.setAuteur( auteur );
		this.setIsbn( isbn );
	}

	/**
	 * La méthode accesseur getAuteur() permet de retourner l'auteur du livre.
	 * 
	 * @return l'auteur du livre.
	 */

	public String getAuteur() {
		return this.auteur;
	}

	/**
	 * La méthode accesseur getIsbn() permet de retourner l'isbn du livre.
	 * 
	 * @return l'isbn du livre.
	 */

	public String getIsbn() {
		return this.isbn;
	}

	/**
	 * La méthode mutateur setAuteur() permet de modifier l'auteur du livre
	 * par celui reçu en paramètre.
	 * 
	 * @param auteur
	 *            L'auteur du livre.
	 */

	public void setAuteur( String auteur ) {
		if ( auteur.length() <= Livre.MAX_CAR_AUTEUR ) {
		
			this.auteur = auteur;
		}
	}

	/**
	 * La méthode mutateur setIsbn() permet de modifier l'isbn du livre
	 * par celui reçu en paramètre.
	 * 
	 * @param isbn
	 *            L'isbn du livre.
	 */

	public void setIsbn( String isbn ) {
		if ( isbn.length() <= Livre.NB_CAR_ISBN ) {
			this.isbn = isbn;
		}
	}

	/**
	 * La méthode publique lireAuteur() permet de lire le ou les auteurs du
	 * livre et de modifier le champ de l'auteur du livre.
	 */
	
	public void lireAuteur() {
		final String QUEST_AUTEUR = "\nEntrez le ou les auteurs du livre" +
				" (entre " + Livre.MIN_CAR_AUTEUR + " et "
				+ Livre.MAX_CAR_AUTEUR	+ " car.) : ";
		
		String auteur;
		
		auteur = OutilsLecture.lireChaineValide( QUEST_AUTEUR, 
					Livre.MIN_CAR_AUTEUR, Livre.MAX_CAR_AUTEUR );

		this.setAuteur( auteur );
	}
	
	/**
	 * La méthode publique lireIsbn() permet de lire l'isbn du livre et de
	 * modifier le champ de l'isbn du livre.
	 */
	
	public void lireIsbn() {
		final String QUEST_ISBN = "\nEntrez le numéro ISBN du livre ("
				+ Livre.NB_CAR_ISBN + " car.) : ";
		
		String isbn;
		
		isbn = OutilsLecture.lireChaineExacte( QUEST_ISBN, Livre.NB_CAR_ISBN );

		this.setIsbn( isbn );
	}

	/**
	 * Redéfinition de la méthode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du livre, connaissant le numéro de cote du
	 * document.
	 */
	
	@Override
	public void lireAutresRenseignements() {
		super.lireAutresRenseignements();
		
		this.lireAuteur();
		this.lireIsbn();
	}

	/**
	 * Redéfinition de la méthode afficher() qui permet d'afficher tous les
	 * renseignements du livre.
	 */

	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println( "Auteur(s) :\t\t" + this.getAuteur() );
		System.out.println( "ISBN :\t\t\t" + this.getIsbn() );

		super.afficherDisponibilite();
	}

	/**
	 * Redéfinition de la méthode toString().
	 * 
	 * @return les informations du livre sous forme de chaîne de caractères.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getAuteur() + "," +
	           this.getIsbn() + "]";

	   return infos;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirType() qui retourne le type
	 * de document représentant un livre.
	 * 
	 * @return le caractère représentant un livre : L.
	 */
	
	@Override
	public char obtenirType() {
		return Document.LIVRE;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de chaînes de caractères.
	 */
	
	@Override
	public String obtenirDescription() {
		return "livre";
	}
}