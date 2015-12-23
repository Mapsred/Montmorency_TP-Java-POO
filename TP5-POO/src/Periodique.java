/**
 * Auteur  : Soti
 * Fichier : Periodique.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Periodique hérite de la classe abstraite Document et contient les
 * données et les méthodes supplémentaires pour un périodique (revue ou journal
 * publié périodiquement).
 * Cette classe implémente l'interface Serializable.
 */

public class Periodique extends Document implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un périodique.
	static final long serialVersionUID = 7;
	
	// Constantes de la classe Periodique.

	public static final int MIN_VOLUME  = 1;
	public static final int MAX_VOLUME  = 1000;
	public static final int MIN_NUMERO  = 1;
	public static final int MAX_NUMERO  = 366;
	public static final int NB_CAR_ISSN = 8;
	
	// Champs d'instance privés supplémentaires de la classe Periodique.
	
	private String issn;  // International Standard Serial Number.
	private int volume;   // Numéro de volume et de numéro du périodique.
	private int numero;
	
	/**
	 * Le constructeur Periodique() permet de construire un périodique de base.
	 * Aucun numéro de cote, aucun titre, aucun editeur, aucun issn,
	 * aucun volume et aucun numéro. 
	 */
	
	public Periodique() {
		// Appel de l'autre constructeur.
		this( "", "", "", "", 0, 0 );
	}
	
	/**
	 * Le constructeur Periodique() permet de construire un périodique
	 * connaissant son numéro de cote, son titre, son éditeur, son issn, son
	 * volume et son numéro. Au début le périodique est disponible.
	 * 
	 * @param cote
	 *            Le numéro de cote du périodique.
	 * @param titre
	 *            Le titre du périodique.
	 * @param editeur
	 *            L'éditeur du périodique.
	 * @param issn
	 *            L'issn du périodique.
	 * @param vol
	 *            Le volume du périodique.
	 * @param no
	 *            Le numéro du périodique.
	 */

	public Periodique( String cote, String titre, String editeur, String issn,
				       int vol, int no ) {
		
		super( cote, titre, editeur );
		
		this.setIssn( issn );
		this.setVolume( vol );
		this.setNumero( no );
	}

	/**
	 * La méthode accesseur getIssn() permet de retourner l'issn du périodique.
	 * 
	 * @return l'issn du périodique.
	 */

	public String getIssn() {
		return this.issn;
	}

	/**
	 * La méthode accesseur getVolume() permet de retourner le numéro de volume
	 * du périodique.
	 * 
	 * @return le numéro de volume du périodique.
	 */

	public int getVolume() {
		return this.volume;
	}

	/**
	 * La méthode accesseur getNumero() permet de retourner le numéro du
	 * périodique.
	 * 
	 * @return le numéro du périodique.
	 */

	public int getNumero() {
		return this.numero;
	}

	/**
	 * La méthode mutateur setIssn() permet de modifier l'issn du périodique
	 * par celui reçu en paramètre.
	 * 
	 * @param issn
	 *            L'issn du périodique.
	 */

	public void setIssn( String issn ) {
		if ( issn.length() <= Periodique.NB_CAR_ISSN ) {
			this.issn = issn;
		}
	}

	/**
	 * La méthode mutateur setVolume() permet de modifier le numéro de volume du
	 * périodique par celui reçu en paramètre.
	 * 
	 * @param vol
	 *            Le numéro de volume du périodique.
	 */

	public void setVolume( int vol ) {
		if ( vol >= 0 && vol <= Periodique.MAX_VOLUME ) {
			this.volume = vol;
		}
	}

	/**
	 * La méthode mutateur setNumero() permet de modifier le numéro du
	 * périodique par celui reçu en paramètre.
	 * 
	 * @param no
	 *            Le numéro du périodique.
	 */

	public void setNumero( int no ) {
		if ( no >= 0 && no <= Periodique.MAX_NUMERO ) {
			this.numero = no;
		}
	}

	/**
	 * La méthode publique lireIssn() permet de lire l'issn du périodique et de
	 * modifier le champ de l'issn du périodique.
	 */
	
	public void lireIssn() {
		final String QUEST_ISSN = "\nEntrez le numéro ISSN du périodique ("
				+ Periodique.NB_CAR_ISSN + " car.) : ";
		
		String issn;
		
		issn = OutilsLecture.lireChaineExacte(
					QUEST_ISSN, Periodique.NB_CAR_ISSN );

		this.setIssn( issn );
	}

	/**
	 * La méthode publique lireVolume() permet de lire le numéro de volume du
	 * périodique et de modifier le champ du numéro de volume du périodique.
	 */
	
	public void lireVolume() {
		final String QUEST_VOLUME = "\nEntrez le numéro de volume du" +
				" périodique (entre " + Periodique.MIN_VOLUME + " et "
				+ Periodique.MAX_VOLUME	+ ") : ";
		
		int vol;
		
		vol = OutilsLecture.lireEntierValide( QUEST_VOLUME, 
					Periodique.MIN_VOLUME, Periodique.MAX_VOLUME );

		this.setVolume( vol );
	}

	/**
	 * La méthode publique lireNumero() permet de lire le numéro du
	 * périodique et de modifier le champ du numéro du périodique.
	 */
	
	public void lireNumero() {
		final String QUEST_NUMERO = "\nEntrez le numéro du périodique (entre "
				+ Periodique.MIN_NUMERO + " et " + Periodique.MAX_NUMERO
				+ ") : ";
		
		int no;
		
		no = OutilsLecture.lireEntierValide( QUEST_NUMERO, 
				Periodique.MIN_NUMERO, Periodique.MAX_NUMERO );

		this.setNumero( no );
	}

	/**
	 * Redéfinition de la méthode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du périodique, connaissant le numéro de cote du
	 * document.
	 */

	@Override
	public void lireAutresRenseignements() {
		super.lireAutresRenseignements();
		
		this.lireIssn();
		this.lireVolume();
		this.lireNumero();
	}

	/**
	 * Redéfinition de la méthode afficher() qui permet d'afficher tous les
	 * renseignements du périodique.
	 */

	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println( "ISSN :\t\t\t" + this.getIssn() );
		System.out.println( "Volume :\t\t" + this.getVolume() );
		System.out.println( "Numéro :\t\t" + this.getNumero() );

		super.afficherDisponibilite();
	}

	/**
	 * Redéfinition de la méthode toString().
	 * 
	 * @return les informations du périodique sous forme de chaîne de
	 *         caractères.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getIssn() + "," +
	           this.getVolume() + "," + this.getNumero() + "]";

	   return infos;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirType() qui retourne le type
	 * de document représentant un périodique.
	 * 
	 * @return le caractère représentant un périodique : P.
	 */
	
	@Override
	public char obtenirType() {
		return Document.PERIODIQUE;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de chaînes de caractères.
	 */
	
	@Override
	public String obtenirDescription() {
		return "périodique";
	}
}