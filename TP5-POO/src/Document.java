/**
 * Auteur  : Soti
 * Fichier : Document.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe abstraite Document contient les donn�es et les m�thodes communes
 * pour un Document. Cette classe impl�mente les interfaces Comparable et
 * Serializable.
 */

public abstract class Document implements Comparable <Document>, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un document.
	static final long serialVersionUID = 4;
	
	// Constantes de la classe Document.

	public static final int MIN_CAR_COTE    = 1;
	public static final int MAX_CAR_COTE    = 15;
	public static final int MIN_CAR_TITRE   = 1;
	public static final int MAX_CAR_TITRE   = 100;
	public static final int MIN_CAR_EDITEUR = 1;
	public static final int MAX_CAR_EDITEUR = 60;

	// Diff�rents types de documents.

	public static final char TOUS       = 'T';
	public static final char LIVRE      = 'L';
	public static final char PERIODIQUE = 'P';
	public static final char DVD        = 'D';

	// Cha�ne contenant les types de documents : "LPD".
	public static final String TYPES_BASE_DOCUMENT = 
			"" + LIVRE + PERIODIQUE	+ DVD;

	// Cha�ne contenant les types de documents � consulter : "TLPD".
	public static final String TYPES_DOC_CONSULTER = 
			"" + TOUS + TYPES_BASE_DOCUMENT;

	// Questions pour lire un type de document.
	
	public static final String QUEST_TYPE_BASE = "\nEntrez le type du document"
			+ " (L pour Livre, P pour P�riodique, D pour DVD) : ";

	
	public static final String QUEST_TYPE_CONSULTER = "\nEntrez le type des"
			+ " documents � consulter"
			+ " (T pour tous, L pour Livre, P pour P�riodique, D pour DVD) : ";
	

	// Champs d'instance priv�s de la classe Document.
	
	private String cote;  // Sert de cl�.
	private String titre;
	private String editeur;
	private boolean disponible;

	/**
	 * Le constructeur Document() permet de construire un document de base.
	 * Aucun num�ro de cote, aucun titre, aucun editeur. 
	 */
	
	public Document() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "" );
	}
	
	/**
	 * Le constructeur Document() permet de construire un document connaissant
	 * son num�ro de cote, son titre, son �diteur. Au d�but le document est
	 * disponible.
	 * 
	 * @param cote
	 *            Le num�ro de cote du document.
	 * @param titre
	 *            Le titre du document.
	 * @param editeur
	 *            L'�diteur du document.
	 */

	public Document( String cote, String titre, String editeur ) {
		this.setCote( cote );
		this.setTitre( titre );
		this.setEditeur( editeur );
		this.setDisponible( true );
	}

	/**
	 * La m�thode accesseur getCote() permet de retourner le num�ro de cote du
	 * document.
	 * 
	 * @return le num�ro de cote du document.
	 */

	public String getCote() {
		return this.cote;
	}

	/**
	 * La m�thode accesseur getTitre() permet de retourner le titre du document.
	 * 
	 * @return le titre du document.
	 */

	public String getTitre() {
		return this.titre;
	}

	/**
	 * La m�thode accesseur getEditeur() permet de retourner l'�diteur du
	 * document.
	 * 
	 * @return l'�diteur du document.
	 */

	public String getEditeur() {
		return this.editeur;
	}

	/**
	 * La m�thode accesseur isDisponible() permet de retourner la disponibilit�
	 * du document.
	 * 
	 * @return true si le document est disponible ou false dans le cas contraire.
	 */

	public boolean isDisponible() {
		return this.disponible;
	}

	/**
	 * La m�thode mutateur setCote() permet de modifier le num�ro de cote
	 * du document par celui re�u en param�tre.
	 * 
	 * @param cote
	 *            Le num�ro de cote du document.
	 */

	public void setCote( String cote ) {
		if ( cote.length() <= Document.MAX_CAR_COTE ) {
			
			this.cote = cote;
		}
	}

	/**
	 * La m�thode mutateur setTitre() permet de modifier le titre du document
	 * par celui re�u en param�tre.
	 * 
	 * @param titre
	 *            Le titre du document.
	 */

	public void setTitre( String titre ) {
		if ( titre.length() <= Document.MAX_CAR_TITRE ) {
				
			this.titre = titre;
		}
	}

	/**
	 * La m�thode mutateur setEditeur() permet de modifier l'�diteur du document
	 * par celui re�u en param�tre.
	 * 
	 * @param editeur
	 *            L'�diteur du document.
	 */

	public void setEditeur( String editeur ) {
		if ( editeur.length() <= Document.MAX_CAR_EDITEUR ) {
				
			this.editeur = editeur;
		}
	}

	/**
	 * La m�thode mutateur setDisponible() permet de modifier la disponibilit�
	 * du document.
	 * 
	 * @param disponible
	 *            Un bool�en indiquant la disponiblit� du document.
	 */

	public void setDisponible( boolean disponible ) {
		this.disponible = disponible;
	}

	/**
	 * La m�thode publique lireCote() permet de lire le num�ro de cote du
	 * document et de modifier le champ du num�ro de cote du document.
	 */
	
	public void lireCote() {
		final String QUEST_COTE = "\nEntrez le num�ro de cote du document" +
				" (entre "	+ Document.MIN_CAR_COTE	+ " et "
				+ Document.MAX_CAR_COTE	+ " car.) : ";
		
		String cote;
		
		cote = OutilsLecture.lireChaineValide( 
					QUEST_COTE,	Document.MIN_CAR_COTE, Document.MAX_CAR_COTE );

		this.setCote( cote );
	}
	
	/**
	 * La m�thode publique lireTitre() permet de lire le titre du document
	 * et de modifier le champ du titre du document.
	 */
	
	public void lireTitre() {
		final String QUEST_TITRE = "\nEntrez le titre du "
				+ this.obtenirDescription() + " (entre "
				+ Document.MIN_CAR_TITRE + " et " + Document.MAX_CAR_TITRE
				+ " car.) : ";
		
		String titre;
		
		titre = OutilsLecture.lireChaineValide(	QUEST_TITRE,
							Document.MIN_CAR_TITRE, Document.MAX_CAR_TITRE );

		this.setTitre( titre );
	}

	/**
	 * La m�thode publique lireEditeur() permet de lire l'�diteur du document
	 * et de modifier le champ de l'�diteur du document.
	 */
	
	public void lireEditeur() {
		final String QUEST_EDITEUR = "\nEntrez l'�diteur du "
				+ this.obtenirDescription() + " (entre "
				+ Document.MIN_CAR_EDITEUR + " et " + Document.MAX_CAR_EDITEUR
				+ " car.) : ";
		
		String editeur;
		
		editeur = OutilsLecture.lireChaineValide( QUEST_EDITEUR,
					Document.MIN_CAR_EDITEUR, Document.MAX_CAR_EDITEUR );

		this.setEditeur( editeur );
	}

	/**
	 * La m�thode publique lireAutresRenseignements() permet de lire les autres
	 * renseignements du document connaissant le num�ro de cote du document.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println("\nEntrez les autres renseignements du "
				+ this.obtenirDescription() + " dont le num�ro de cote est "
				+ this.getCote());
		
		this.lireTitre();
		this.lireEditeur();
	}

	/**
	 * La m�thode publique afficher() permet d'afficher les renseignements du
	 * document.
	 */

	public void afficher() {
		System.out.println( "\nRenseignements du " 
				+ this.obtenirDescription()	+ ".\n");
		System.out.println( "Num�ro de cote :\t" + this.getCote() );
		System.out.println( "Titre :\t\t\t" + this.getTitre() );
		System.out.println( "�diteur :\t\t" + this.getEditeur() );
	}

	/**
	 * La m�thode publique afficherDisponibilite() permet d'afficher la
	 * disponibilit� du document.
	 */

	public void afficherDisponibilite() {
		System.out.print( "\nLe " + this.obtenirDescription() );

		if ( this.isDisponible() ) {
			System.out.println( " est disponible." );
		} else {
			System.out.println( " n'est pas disponible." );
		}
	}

	/**
	 * La m�thode publique statique creerDocument() permet de cr�er et de
	 * retourner un document de base temporaire.
	 * 
	 * @return un document de base temporaire.
	 */
	
	public static Document creerDocument() {
		// Un document de base temporaire est un Livre. 
		return new Livre();
	}

	/**
	 * La m�thode publique statique creerDocument() permet de cr�er et de
	 * retourner un objet de base qui correspond au type de document re�u en
	 * param�tre.
	 * 
	 * @param type
	 *            Le type du document.
	 * 
	 * @return l'objet de base qui correspond au type de document.
	 */
	
	public static Document creerDocument( char type ) {
		Document document = null;
		
		// Cr�er le bon objet de base selon le type re�u en param�tre.

		switch ( type ) {
		
		case Document.LIVRE:
			document = new Livre();
			break;

		case Document.PERIODIQUE:
			document = new Periodique();
			break;
			
		case Document.DVD:
			document = new Dvd();
			break;
		}
		
		return document;
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return les informations du document sous forme de cha�ne de caract�res.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getCote() + "," +
	           this.getTitre() + "," + this.getEditeur() + "]";

	   return infos;
	}

	/**
	 * Red�finition de la m�thode equals() de la classe Object. L'objet courant
	 * est �gal � l'objet re�u en param�tre lorsque les num�ros de cote des
	 * documents sont �gaux.
	 * 
	 * @param autreObjet
	 *            L'autre objet � comparer avec celui courant de type Object.
	 * 
	 * @return true si l'objet courant est �gal � l'autre objet ou false dans le
	 *         cas contraire.
	 */

	@Override
	public boolean equals( Object autreObjet ) {
		boolean egalite = false;

		// Si les deux objets pointent sur la m�me zone m�moire.

		if ( this == autreObjet ) {
			egalite = true;
		} else if ( autreObjet != null ) {

			if ( autreObjet instanceof Document ) {

				// Convertir le type de l'autre objet en type Document.
				Document autre = (Document) autreObjet;

				// Les objets sont identiques si les num�ros de cote des
				// documents sont identiques.

				if ( this.getCote().equalsIgnoreCase( autre.getCote() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}
	
	/**
	 * Impl�mentation de la m�thode compareTo() de l'interface Comparable. Un
	 * objet de type Document est plus petit qu'un autre objet de type Document,
	 * lorsque la cote du premier objet est alphab�tiquement plus petite que la
	 * cote du deuxi�me objet. On ne fait pas de diff�rence entre les caract�res
	 * minuscules et les caract�res majuscules.
	 * 
	 * @param autreDocument
	 *            L'autre objet � comparer avec celui courant de type Document.
	 * 
	 * @return une valeur n�gative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est �gal � l'autre objet.
	 */

	@Override
	public int compareTo( Document autreDocument ) {
		int valCompare;

		valCompare = this.getCote()
							.compareToIgnoreCase( autreDocument.getCote() );

		return valCompare;
	}

	/**
	 * La m�thode abstraite obtenirType() retourne le type du
	 * document.
	 * 
	 * @return le caract�re repr�sentant le type du document : L, P ou D.
	 */
	
	public abstract char obtenirType();

	/**
	 * La m�thode abstraite obtenirDescription() retourne la description du
	 * document.
	 * 
	 * @return la description du document sous forme de cha�nes de caract�res.
	 */
	
	public abstract String obtenirDescription();
}