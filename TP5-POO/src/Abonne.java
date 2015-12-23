/**
 * Auteur  : Soti
 * Fichier : Abonne.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

//Package du programmeur.
import outilsjava.*;

/**
 * La classe Abonne contient les données et les méthodes pour un abonné.
 * Cette classe implémente les interfaces Comparable, OutilsConstantes et
 * Serializable.
 */

public class Abonne implements 
						Comparable <Abonne>, OutilsConstantes, Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un abonné.
	static final long serialVersionUID = 3;
	
	// Constantes de la classe Abonne.

	public static final int MAX_DOCUMENTS    = 5;
	public static final int NB_CAR_NO_ABONNE = 3;
	public static final int MIN_CAR_NOM      = 1;
	public static final int MAX_CAR_NOM      = 60;

	// Champs d'instance privés de la classe Abonne.
	
	private String noAbonne;    // Sert de clé.
	private String nom;
	private TabObjets tabDocsAb;  // Les documents empruntés par l'abonné.

	/**
	 * Le constructeur Abonne() permet de construire un abonné de base.
	 * Aucun numéro, aucun nom et aucun document emprunté. 
	 */
	
	public Abonne() {
		// Exécute l'autre constructeur.
		this( "", "" );
	}
	
	/**
	 * Le constructeur Abonne() permet de construire un abonné connaissant son
	 * numéro et son nom. Au début, aucun document emprunté. 
	 * 
	 * @param noAbonne
	 *            Le numéro de l'abonné.
	 * @param nom
	 *            Le nom de l'abonné.
	 */

	public Abonne( String noAbonne, String nom ) {
		this.setNoAbonne( noAbonne );
		this.setNom( nom );
		this.tabDocsAb = new TabObjets( MAX_DOCUMENTS );
	}

	/**
	 * La méthode accesseur getNoAbonne() permet de retourner le numéro de
	 * l'abonné.
	 * 
	 * @return le numéro de l'abonné.
	 */

	public String getNoAbonne() {
		return this.noAbonne;
	}

	/**
	 * La méthode accesseur getNom() permet de retourner le nom de l'abonné.
	 * 
	 * @return le nom de l'abonné.
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * La méthode accesseur getTabDocs() permet de retourner les documents
	 * empruntés par l'abonné.
	 * 
	 * @return les documents empruntés par l'abonné.
	 */

	public TabObjets getTabDocsAb() {
		return this.tabDocsAb;
	}

	/**
	 * La méthode mutateur setNoAbonne() permet de modifier le numéro de
	 * l'abonné par celui reçu en paramètre.
	 * 
	 * @param noAbonne
	 *            Le numéro de l'abonné.
	 */

	public void setNoAbonne( String noAbonne ) {
		if ( noAbonne.length() <= Abonne.NB_CAR_NO_ABONNE ) {
			this.noAbonne = noAbonne;
		}
	}

	/**
	 * La méthode mutateur setNom() permet de modifier le nom de l'abonné par
	 * celui reçu en paramètre.
	 * 
	 * @param nom
	 *            Le nom de l'abonné.
	 */

	public void setNom( String nom ) {
		if ( nom.length() <= Abonne.MAX_CAR_NOM ) {
			this.nom = nom;
		}
	}

	/**
	 * La méthode publique lireNoAbonne() permet de lire le numéro de l'abonné
	 * et de modifier le champ du numéro de l'abonné.
	 */
	
	public void lireNoAbonne() {
		final String QUEST_NO_ABONNE = "\nEntrez le numéro de l'abonné ("
				+ Abonne.NB_CAR_NO_ABONNE + " car.) : ";

		String noAbonne;

		noAbonne = OutilsLecture.lireChaineExacte(
									QUEST_NO_ABONNE, Abonne.NB_CAR_NO_ABONNE );

		this.setNoAbonne( noAbonne );
	}

	/**
	 * La méthode publique lireNom() permet de lire le nom de l'abonné
	 * et de modifier le champ du nom de l'abonné.
	 */
	
	public void lireNom() {
		final String QUEST_NOM = "\nEntrez le nom de l'abonné (entre "
				+ Abonne.MIN_CAR_NOM + " et " + Abonne.MAX_CAR_NOM
				+ " car.) : ";
		
		String nom;
		
		nom = OutilsLecture.lireChaineValide(
						QUEST_NOM, Abonne.MIN_CAR_NOM, Abonne.MAX_CAR_NOM );

		this.setNom( nom );
	}
	
	/**
	 * La méthode lireAutresRenseignements() permet de lire les autres
	 * renseignements de l'abonné connaissant le numéro de l'abonné.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements de"
				+ " l'abonné numéro " + this.getNoAbonne() );
		
		this.lireNom();
	}

	/**
	 * La méthode afficher() permet d'afficher tous les renseignements de
	 * l'abonné.
	 */
	
	public void afficher() {
		System.out.println( "\nRenseignements de l'abonné.\n" );
		System.out.println( "Numéro :\t" + this.getNoAbonne() );
		System.out.println( "Nom :\t\t" + this.getNom() );
		
		if ( tabDocsAb.estVide() ) {
			System.out.println( "\nL'abonné n'a emprunté aucun document." );
		} else {
			System.out.println(
					"\nListe des documents empruntés par l'abonné :" );
			
			Document document;
			
			for ( int i = 0; i < this.tabDocsAb.taille(); ++i ) {
				document = (Document) this.tabDocsAb.obtenirObjet( i );
				document.afficher();
				OutilsLecture.lireEntree( QUEST_CONTINUER );
			}
			
			System.out.println( "\nL'abonné a emprunté " +
					this.tabDocsAb.taille() + " document(s)." );
		}
	}

	/**
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return les informations de l'abonné sous forme de chaîne de caractères.
	 */
	
	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getNoAbonne() + "," +
	           this.getNom() + "," + this.getTabDocsAb() + "]";

	   return infos;
	}

	/**
	 * Redéfinition de la méthode equals() de la classe Object. L'objet courant
	 * est égal à l'objet reçu en paramètre lorsque les numéros d'abonné sont
	 * égaux.
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

			if ( autreObjet instanceof Abonne ) {

				// Convertir le type de l'autre objet en type Abonne.
				Abonne autre = (Abonne) autreObjet;

				// Les objets sont identiques si les numéros d'abonné
				// sont identiques.

				if ( this.getNoAbonne().equalsIgnoreCase(
													autre.getNoAbonne() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}

	/**
	 * Implémentation de la méthode compareTo() de l'interface Comparable. Un
	 * objet de type Abonne est plus petit qu'un autre objet de type Abonne,
	 * lorsque le noAbonne du premier objet est alphabétiquement plus petit que
	 * le noAbonne du deuxième objet. On ne fait pas de différence entre les
	 * caractères minuscules et les caractères majuscules.
	 * 
	 * @param autreAbonne
	 *            L'autre abonné à comparer avec celui courant de type Abonne.
	 * 
	 * @return une valeur négative si l'abonné courant est plus petit que
	 *         l'autre abonné, une valeur positive si l'abonné courant est plus
	 *         grand que l'autre abonné ou 0 si l'abonné courant est égal à
	 *         l'autre abonné.
	 */
	
	@Override
	public int compareTo( Abonne autreAbonne ) {
		int valCompare;

		valCompare = this.getNoAbonne().compareToIgnoreCase(
												autreAbonne.getNoAbonne() );

		return valCompare;
	}
}