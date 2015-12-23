/**
 * Auteur  : Soti
 * Fichier : Periodique.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Periodique h�rite de la classe abstraite Document et contient les
 * donn�es et les m�thodes suppl�mentaires pour un p�riodique (revue ou journal
 * publi� p�riodiquement).
 * Cette classe impl�mente l'interface Serializable.
 */

public class Periodique extends Document implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un p�riodique.
	static final long serialVersionUID = 7;
	
	// Constantes de la classe Periodique.

	public static final int MIN_VOLUME  = 1;
	public static final int MAX_VOLUME  = 1000;
	public static final int MIN_NUMERO  = 1;
	public static final int MAX_NUMERO  = 366;
	public static final int NB_CAR_ISSN = 8;
	
	// Champs d'instance priv�s suppl�mentaires de la classe Periodique.
	
	private String issn;  // International Standard Serial Number.
	private int volume;   // Num�ro de volume et de num�ro du p�riodique.
	private int numero;
	
	/**
	 * Le constructeur Periodique() permet de construire un p�riodique de base.
	 * Aucun num�ro de cote, aucun titre, aucun editeur, aucun issn,
	 * aucun volume et aucun num�ro. 
	 */
	
	public Periodique() {
		// Appel de l'autre constructeur.
		this( "", "", "", "", 0, 0 );
	}
	
	/**
	 * Le constructeur Periodique() permet de construire un p�riodique
	 * connaissant son num�ro de cote, son titre, son �diteur, son issn, son
	 * volume et son num�ro. Au d�but le p�riodique est disponible.
	 * 
	 * @param cote
	 *            Le num�ro de cote du p�riodique.
	 * @param titre
	 *            Le titre du p�riodique.
	 * @param editeur
	 *            L'�diteur du p�riodique.
	 * @param issn
	 *            L'issn du p�riodique.
	 * @param vol
	 *            Le volume du p�riodique.
	 * @param no
	 *            Le num�ro du p�riodique.
	 */

	public Periodique( String cote, String titre, String editeur, String issn,
				       int vol, int no ) {
		
		super( cote, titre, editeur );
		
		this.setIssn( issn );
		this.setVolume( vol );
		this.setNumero( no );
	}

	/**
	 * La m�thode accesseur getIssn() permet de retourner l'issn du p�riodique.
	 * 
	 * @return l'issn du p�riodique.
	 */

	public String getIssn() {
		return this.issn;
	}

	/**
	 * La m�thode accesseur getVolume() permet de retourner le num�ro de volume
	 * du p�riodique.
	 * 
	 * @return le num�ro de volume du p�riodique.
	 */

	public int getVolume() {
		return this.volume;
	}

	/**
	 * La m�thode accesseur getNumero() permet de retourner le num�ro du
	 * p�riodique.
	 * 
	 * @return le num�ro du p�riodique.
	 */

	public int getNumero() {
		return this.numero;
	}

	/**
	 * La m�thode mutateur setIssn() permet de modifier l'issn du p�riodique
	 * par celui re�u en param�tre.
	 * 
	 * @param issn
	 *            L'issn du p�riodique.
	 */

	public void setIssn( String issn ) {
		if ( issn.length() <= Periodique.NB_CAR_ISSN ) {
			this.issn = issn;
		}
	}

	/**
	 * La m�thode mutateur setVolume() permet de modifier le num�ro de volume du
	 * p�riodique par celui re�u en param�tre.
	 * 
	 * @param vol
	 *            Le num�ro de volume du p�riodique.
	 */

	public void setVolume( int vol ) {
		if ( vol >= 0 && vol <= Periodique.MAX_VOLUME ) {
			this.volume = vol;
		}
	}

	/**
	 * La m�thode mutateur setNumero() permet de modifier le num�ro du
	 * p�riodique par celui re�u en param�tre.
	 * 
	 * @param no
	 *            Le num�ro du p�riodique.
	 */

	public void setNumero( int no ) {
		if ( no >= 0 && no <= Periodique.MAX_NUMERO ) {
			this.numero = no;
		}
	}

	/**
	 * La m�thode publique lireIssn() permet de lire l'issn du p�riodique et de
	 * modifier le champ de l'issn du p�riodique.
	 */
	
	public void lireIssn() {
		final String QUEST_ISSN = "\nEntrez le num�ro ISSN du p�riodique ("
				+ Periodique.NB_CAR_ISSN + " car.) : ";
		
		String issn;
		
		issn = OutilsLecture.lireChaineExacte(
					QUEST_ISSN, Periodique.NB_CAR_ISSN );

		this.setIssn( issn );
	}

	/**
	 * La m�thode publique lireVolume() permet de lire le num�ro de volume du
	 * p�riodique et de modifier le champ du num�ro de volume du p�riodique.
	 */
	
	public void lireVolume() {
		final String QUEST_VOLUME = "\nEntrez le num�ro de volume du" +
				" p�riodique (entre " + Periodique.MIN_VOLUME + " et "
				+ Periodique.MAX_VOLUME	+ ") : ";
		
		int vol;
		
		vol = OutilsLecture.lireEntierValide( QUEST_VOLUME, 
					Periodique.MIN_VOLUME, Periodique.MAX_VOLUME );

		this.setVolume( vol );
	}

	/**
	 * La m�thode publique lireNumero() permet de lire le num�ro du
	 * p�riodique et de modifier le champ du num�ro du p�riodique.
	 */
	
	public void lireNumero() {
		final String QUEST_NUMERO = "\nEntrez le num�ro du p�riodique (entre "
				+ Periodique.MIN_NUMERO + " et " + Periodique.MAX_NUMERO
				+ ") : ";
		
		int no;
		
		no = OutilsLecture.lireEntierValide( QUEST_NUMERO, 
				Periodique.MIN_NUMERO, Periodique.MAX_NUMERO );

		this.setNumero( no );
	}

	/**
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire
	 * les autres renseignements du p�riodique, connaissant le num�ro de cote du
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
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les
	 * renseignements du p�riodique.
	 */

	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println( "ISSN :\t\t\t" + this.getIssn() );
		System.out.println( "Volume :\t\t" + this.getVolume() );
		System.out.println( "Num�ro :\t\t" + this.getNumero() );

		super.afficherDisponibilite();
	}

	/**
	 * Red�finition de la m�thode toString().
	 * 
	 * @return les informations du p�riodique sous forme de cha�ne de
	 *         caract�res.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = super.toString() + "[" + this.getIssn() + "," +
	           this.getVolume() + "," + this.getNumero() + "]";

	   return infos;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne le type
	 * de document repr�sentant un p�riodique.
	 * 
	 * @return le caract�re repr�sentant un p�riodique : P.
	 */
	
	@Override
	public char obtenirType() {
		return Document.PERIODIQUE;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description du document.
	 * 
	 * @return La description du document sous forme de cha�nes de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "p�riodique";
	}
}