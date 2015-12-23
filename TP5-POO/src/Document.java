/**
 * Auteur  : Soti
 * Fichier : Document.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe abstraite Document contient les données et les méthodes communes
 * pour un Document. Cette classe implémente les interfaces Comparable et
 * Serializable.
 */

public abstract class Document implements Comparable <Document>, Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un document.
	static final long serialVersionUID = 4;
	
	// Constantes de la classe Document.

	public static final int MIN_CAR_COTE    = 1;
	public static final int MAX_CAR_COTE    = 15;
	public static final int MIN_CAR_TITRE   = 1;
	public static final int MAX_CAR_TITRE   = 100;
	public static final int MIN_CAR_EDITEUR = 1;
	public static final int MAX_CAR_EDITEUR = 60;

	// Différents types de documents.

	public static final char TOUS       = 'T';
	public static final char LIVRE      = 'L';
	public static final char PERIODIQUE = 'P';
	public static final char DVD        = 'D';

	// Chaîne contenant les types de documents : "LPD".
	public static final String TYPES_BASE_DOCUMENT = 
			"" + LIVRE + PERIODIQUE	+ DVD;

	// Chaîne contenant les types de documents à consulter : "TLPD".
	public static final String TYPES_DOC_CONSULTER = 
			"" + TOUS + TYPES_BASE_DOCUMENT;

	// Questions pour lire un type de document.
	
	public static final String QUEST_TYPE_BASE = "\nEntrez le type du document"
			+ " (L pour Livre, P pour Périodique, D pour DVD) : ";

	
	public static final String QUEST_TYPE_CONSULTER = "\nEntrez le type des"
			+ " documents à consulter"
			+ " (T pour tous, L pour Livre, P pour Périodique, D pour DVD) : ";
	

	// Champs d'instance privés de la classe Document.
	
	private String cote;  // Sert de clé.
	private String titre;
	private String editeur;
	private boolean disponible;

	/**
	 * Le constructeur Document() permet de construire un document de base.
	 * Aucun numéro de cote, aucun titre, aucun editeur. 
	 */
	
	public Document() {
		// Exécuter l'autre constructeur.
		this( "", "", "" );
	}
	
	/**
	 * Le constructeur Document() permet de construire un document connaissant
	 * son numéro de cote, son titre, son éditeur. Au début le document est
	 * disponible.
	 * 
	 * @param cote
	 *            Le numéro de cote du document.
	 * @param titre
	 *            Le titre du document.
	 * @param editeur
	 *            L'éditeur du document.
	 */

	public Document( String cote, String titre, String editeur ) {
		this.setCote( cote );
		this.setTitre( titre );
		this.setEditeur( editeur );
		this.setDisponible( true );
	}

	/**
	 * La méthode accesseur getCote() permet de retourner le numéro de cote du
	 * document.
	 * 
	 * @return le numéro de cote du document.
	 */

	public String getCote() {
		return this.cote;
	}

	/**
	 * La méthode accesseur getTitre() permet de retourner le titre du document.
	 * 
	 * @return le titre du document.
	 */

	public String getTitre() {
		return this.titre;
	}

	/**
	 * La méthode accesseur getEditeur() permet de retourner l'éditeur du
	 * document.
	 * 
	 * @return l'éditeur du document.
	 */

	public String getEditeur() {
		return this.editeur;
	}

	/**
	 * La méthode accesseur isDisponible() permet de retourner la disponibilité
	 * du document.
	 * 
	 * @return true si le document est disponible ou false dans le cas contraire.
	 */

	public boolean isDisponible() {
		return this.disponible;
	}

	/**
	 * La méthode mutateur setCote() permet de modifier le numéro de cote
	 * du document par celui reçu en paramètre.
	 * 
	 * @param cote
	 *            Le numéro de cote du document.
	 */

	public void setCote( String cote ) {
		if ( cote.length() <= Document.MAX_CAR_COTE ) {
			
			this.cote = cote;
		}
	}

	/**
	 * La méthode mutateur setTitre() permet de modifier le titre du document
	 * par celui reçu en paramètre.
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
	 * La méthode mutateur setEditeur() permet de modifier l'éditeur du document
	 * par celui reçu en paramètre.
	 * 
	 * @param editeur
	 *            L'éditeur du document.
	 */

	public void setEditeur( String editeur ) {
		if ( editeur.length() <= Document.MAX_CAR_EDITEUR ) {
				
			this.editeur = editeur;
		}
	}

	/**
	 * La méthode mutateur setDisponible() permet de modifier la disponibilité
	 * du document.
	 * 
	 * @param disponible
	 *            Un booléen indiquant la disponiblité du document.
	 */

	public void setDisponible( boolean disponible ) {
		this.disponible = disponible;
	}

	/**
	 * La méthode publique lireCote() permet de lire le numéro de cote du
	 * document et de modifier le champ du numéro de cote du document.
	 */
	
	public void lireCote() {
		final String QUEST_COTE = "\nEntrez le numéro de cote du document" +
				" (entre "	+ Document.MIN_CAR_COTE	+ " et "
				+ Document.MAX_CAR_COTE	+ " car.) : ";
		
		String cote;
		
		cote = OutilsLecture.lireChaineValide( 
					QUEST_COTE,	Document.MIN_CAR_COTE, Document.MAX_CAR_COTE );

		this.setCote( cote );
	}
	
	/**
	 * La méthode publique lireTitre() permet de lire le titre du document
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
	 * La méthode publique lireEditeur() permet de lire l'éditeur du document
	 * et de modifier le champ de l'éditeur du document.
	 */
	
	public void lireEditeur() {
		final String QUEST_EDITEUR = "\nEntrez l'éditeur du "
				+ this.obtenirDescription() + " (entre "
				+ Document.MIN_CAR_EDITEUR + " et " + Document.MAX_CAR_EDITEUR
				+ " car.) : ";
		
		String editeur;
		
		editeur = OutilsLecture.lireChaineValide( QUEST_EDITEUR,
					Document.MIN_CAR_EDITEUR, Document.MAX_CAR_EDITEUR );

		this.setEditeur( editeur );
	}

	/**
	 * La méthode publique lireAutresRenseignements() permet de lire les autres
	 * renseignements du document connaissant le numéro de cote du document.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println("\nEntrez les autres renseignements du "
				+ this.obtenirDescription() + " dont le numéro de cote est "
				+ this.getCote());
		
		this.lireTitre();
		this.lireEditeur();
	}

	/**
	 * La méthode publique afficher() permet d'afficher les renseignements du
	 * document.
	 */

	public void afficher() {
		System.out.println( "\nRenseignements du " 
				+ this.obtenirDescription()	+ ".\n");
		System.out.println( "Numéro de cote :\t" + this.getCote() );
		System.out.println( "Titre :\t\t\t" + this.getTitre() );
		System.out.println( "Éditeur :\t\t" + this.getEditeur() );
	}

	/**
	 * La méthode publique afficherDisponibilite() permet d'afficher la
	 * disponibilité du document.
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
	 * La méthode publique statique creerDocument() permet de créer et de
	 * retourner un document de base temporaire.
	 * 
	 * @return un document de base temporaire.
	 */
	
	public static Document creerDocument() {
		// Un document de base temporaire est un Livre. 
		return new Livre();
	}

	/**
	 * La méthode publique statique creerDocument() permet de créer et de
	 * retourner un objet de base qui correspond au type de document reçu en
	 * paramètre.
	 * 
	 * @param type
	 *            Le type du document.
	 * 
	 * @return l'objet de base qui correspond au type de document.
	 */
	
	public static Document creerDocument( char type ) {
		Document document = null;
		
		// Créer le bon objet de base selon le type reçu en paramètre.

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
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return les informations du document sous forme de chaîne de caractères.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getCote() + "," +
	           this.getTitre() + "," + this.getEditeur() + "]";

	   return infos;
	}

	/**
	 * Redéfinition de la méthode equals() de la classe Object. L'objet courant
	 * est égal à l'objet reçu en paramètre lorsque les numéros de cote des
	 * documents sont égaux.
	 * 
	 * @param autreObjet
	 *            L'autre objet à comparer avec celui courant de type Object.
	 * 
	 * @return true si l'objet courant est égal à l'autre objet ou false dans le
	 *         cas contraire.
	 */

	@Override
	public boolean equals( Object autreObjet ) {
		boolean egalite = false;

		// Si les deux objets pointent sur la même zone mémoire.

		if ( this == autreObjet ) {
			egalite = true;
		} else if ( autreObjet != null ) {

			if ( autreObjet instanceof Document ) {

				// Convertir le type de l'autre objet en type Document.
				Document autre = (Document) autreObjet;

				// Les objets sont identiques si les numéros de cote des
				// documents sont identiques.

				if ( this.getCote().equalsIgnoreCase( autre.getCote() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}
	
	/**
	 * Implémentation de la méthode compareTo() de l'interface Comparable. Un
	 * objet de type Document est plus petit qu'un autre objet de type Document,
	 * lorsque la cote du premier objet est alphabétiquement plus petite que la
	 * cote du deuxième objet. On ne fait pas de différence entre les caractères
	 * minuscules et les caractères majuscules.
	 * 
	 * @param autreDocument
	 *            L'autre objet à comparer avec celui courant de type Document.
	 * 
	 * @return une valeur négative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est égal à l'autre objet.
	 */

	@Override
	public int compareTo( Document autreDocument ) {
		int valCompare;

		valCompare = this.getCote()
							.compareToIgnoreCase( autreDocument.getCote() );

		return valCompare;
	}

	/**
	 * La méthode abstraite obtenirType() retourne le type du
	 * document.
	 * 
	 * @return le caractère représentant le type du document : L, P ou D.
	 */
	
	public abstract char obtenirType();

	/**
	 * La méthode abstraite obtenirDescription() retourne la description du
	 * document.
	 * 
	 * @return la description du document sous forme de chaînes de caractères.
	 */
	
	public abstract String obtenirDescription();
}