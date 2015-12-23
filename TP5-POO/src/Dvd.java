/**
 * Auteur  : Soti
 * Fichier : Dvd.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Dvd h�rite de la classe abstraite Document et contient les
 * donn�es et les m�thodes suppl�mentaires pour un DVD.
 * Cette classe impl�mente l'interface Serializable.
 */

public class Dvd extends Document implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un DVD.
	static final long serialVersionUID = 5;
	
	// Constantes de la classe Dvd.

	public static final int MIN_CAR_TYPE = 1;
	public static final int MAX_CAR_TYPE = 100;
	
	// Champ d'instance priv� suppl�mentaire de la classe Dvd.
	
	private String typeDvd;
	
	/**
	 * Le constructeur Dvd() permet de construire un DVD de base.
	 * Aucun num�ro de cote, aucun titre, aucun editeur et aucun type.
	 */
	
	public Dvd() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "", "" );
	}
	
	/**
	 * Le constructeur Dvd() permet de construire un DVD connaissant son num�ro
	 * de cote, son titre, son �diteur et son type. Au d�but le DVD est
	 * disponible.
	 * 
	 * @param cote
	 *            Le num�ro de cote du DVD.
	 * @param titre
	 *            Le titre du DVD.
	 * @param editeur
	 *            L'�diteur du DVD.
	 * @param typeDvd
	 *            Le type du DVD.
	 */

	public Dvd( String cote, String titre, String editeur, String typeDvd ) {
		
		super( cote, titre, editeur );
		
		this.setTypeDvd( typeDvd );
	}

	/**
	 * La m�thode accesseur getTypeDvd() permet de retourner le type du DVD.
	 * 
	 * @return Le type du DVD.
	 */

	public String getTypeDvd() {
		return this.typeDvd;
	}

	/**
	 * La m�thode mutateur setTypeDvd() permet de modifier le type du DVD
	 * par celui re�u en param�tre.
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
	 * La m�thode publique lireTypeDvd() permet de lire le type du DVD et de
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
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du DVD, connaissant le num�ro de cote du
	 * document.
	 */
	
	@Override
	public void lireAutresRenseignements() {
		super.lireAutresRenseignements();
		
		this.lireTypeDvd();
	}

	/**
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les
	 * renseignements du DVD.
	 */

	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println( "Type :\t\t\t" + this.getTypeDvd() );

		super.afficherDisponibilite();
	}

	/**
	 * Red�finition de la m�thode toString().
	 * 
	 * @return les informations du DVD sous forme de cha�ne de
	 *         caract�res.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getTypeDvd() + "]";

	   return infos;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne le type
	 * de document repr�sentant un DVD.
	 * 
	 * @return le caract�re repr�sentant un DVD : D.
	 */
	
	@Override
	public char obtenirType() {
		return Document.DVD;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de cha�nes de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "DVD";
	}
}