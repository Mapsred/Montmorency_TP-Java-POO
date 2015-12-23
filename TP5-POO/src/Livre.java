/**
 * Auteur  : Soti
 * Fichier : Livre.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Livre h�rite de la classe abstraite Document et contient les
 * donn�es et les m�thodes suppl�mentaires pour un livre.
 * Cette classe impl�mente l'interface Serializable.
 */

public class Livre extends Document implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un livre.
	static final long serialVersionUID = 6;
	
	// Constantes de la classe Livre.

	public static final int MIN_CAR_AUTEUR = 1;
	public static final int MAX_CAR_AUTEUR = 100;
	public static final int NB_CAR_ISBN    = 13;
	
	// Champs d'instance priv�s suppl�mentaires de la classe Livre.
	
	private String auteur;
	private String isbn; // International Standard Book Number.

	/**
	 * Le constructeur Livre() permet de construire un livre de base.
	 * Aucun num�ro de cote, aucun titre, aucun editeur, aucun auteur et
	 * aucun isbn. 
	 */
	
	public Livre() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "", "", "" );
	}
	
	/**
	 * Le constructeur Livre() permet de construire un livre connaissant son
	 * num�ro de cote, son titre, son �diteur, son auteur et son isbn. Au d�but
	 * le livre est disponible.
	 * 
	 * @param cote
	 *            Le num�ro de cote du livre.
	 * @param titre
	 *            Le titre du livre.
	 * @param editeur
	 *            L'�diteur du livre.
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
	 * La m�thode accesseur getAuteur() permet de retourner l'auteur du livre.
	 * 
	 * @return l'auteur du livre.
	 */

	public String getAuteur() {
		return this.auteur;
	}

	/**
	 * La m�thode accesseur getIsbn() permet de retourner l'isbn du livre.
	 * 
	 * @return l'isbn du livre.
	 */

	public String getIsbn() {
		return this.isbn;
	}

	/**
	 * La m�thode mutateur setAuteur() permet de modifier l'auteur du livre
	 * par celui re�u en param�tre.
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
	 * La m�thode mutateur setIsbn() permet de modifier l'isbn du livre
	 * par celui re�u en param�tre.
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
	 * La m�thode publique lireAuteur() permet de lire le ou les auteurs du
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
	 * La m�thode publique lireIsbn() permet de lire l'isbn du livre et de
	 * modifier le champ de l'isbn du livre.
	 */
	
	public void lireIsbn() {
		final String QUEST_ISBN = "\nEntrez le num�ro ISBN du livre ("
				+ Livre.NB_CAR_ISBN + " car.) : ";
		
		String isbn;
		
		isbn = OutilsLecture.lireChaineExacte( QUEST_ISBN, Livre.NB_CAR_ISBN );

		this.setIsbn( isbn );
	}

	/**
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du livre, connaissant le num�ro de cote du
	 * document.
	 */
	
	@Override
	public void lireAutresRenseignements() {
		super.lireAutresRenseignements();
		
		this.lireAuteur();
		this.lireIsbn();
	}

	/**
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les
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
	 * Red�finition de la m�thode toString().
	 * 
	 * @return les informations du livre sous forme de cha�ne de caract�res.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getAuteur() + "," +
	           this.getIsbn() + "]";

	   return infos;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne le type
	 * de document repr�sentant un livre.
	 * 
	 * @return le caract�re repr�sentant un livre : L.
	 */
	
	@Override
	public char obtenirType() {
		return Document.LIVRE;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de cha�nes de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "livre";
	}
}