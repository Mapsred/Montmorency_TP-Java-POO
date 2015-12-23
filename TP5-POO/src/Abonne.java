/**
 * Auteur  : Soti
 * Fichier : Abonne.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

//Package du programmeur.
import outilsjava.*;

/**
 * La classe Abonne contient les donn�es et les m�thodes pour un abonn�.
 * Cette classe impl�mente les interfaces Comparable, OutilsConstantes et
 * Serializable.
 */

public class Abonne implements 
						Comparable <Abonne>, OutilsConstantes, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un abonn�.
	static final long serialVersionUID = 3;
	
	// Constantes de la classe Abonne.

	public static final int MAX_DOCUMENTS    = 5;
	public static final int NB_CAR_NO_ABONNE = 3;
	public static final int MIN_CAR_NOM      = 1;
	public static final int MAX_CAR_NOM      = 60;

	// Champs d'instance priv�s de la classe Abonne.
	
	private String noAbonne;    // Sert de cl�.
	private String nom;
	private TabObjets tabDocsAb;  // Les documents emprunt�s par l'abonn�.

	/**
	 * Le constructeur Abonne() permet de construire un abonn� de base.
	 * Aucun num�ro, aucun nom et aucun document emprunt�. 
	 */
	
	public Abonne() {
		// Ex�cute l'autre constructeur.
		this( "", "" );
	}
	
	/**
	 * Le constructeur Abonne() permet de construire un abonn� connaissant son
	 * num�ro et son nom. Au d�but, aucun document emprunt�. 
	 * 
	 * @param noAbonne
	 *            Le num�ro de l'abonn�.
	 * @param nom
	 *            Le nom de l'abonn�.
	 */

	public Abonne( String noAbonne, String nom ) {
		this.setNoAbonne( noAbonne );
		this.setNom( nom );
		this.tabDocsAb = new TabObjets( MAX_DOCUMENTS );
	}

	/**
	 * La m�thode accesseur getNoAbonne() permet de retourner le num�ro de
	 * l'abonn�.
	 * 
	 * @return le num�ro de l'abonn�.
	 */

	public String getNoAbonne() {
		return this.noAbonne;
	}

	/**
	 * La m�thode accesseur getNom() permet de retourner le nom de l'abonn�.
	 * 
	 * @return le nom de l'abonn�.
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * La m�thode accesseur getTabDocs() permet de retourner les documents
	 * emprunt�s par l'abonn�.
	 * 
	 * @return les documents emprunt�s par l'abonn�.
	 */

	public TabObjets getTabDocsAb() {
		return this.tabDocsAb;
	}

	/**
	 * La m�thode mutateur setNoAbonne() permet de modifier le num�ro de
	 * l'abonn� par celui re�u en param�tre.
	 * 
	 * @param noAbonne
	 *            Le num�ro de l'abonn�.
	 */

	public void setNoAbonne( String noAbonne ) {
		if ( noAbonne.length() <= Abonne.NB_CAR_NO_ABONNE ) {
			this.noAbonne = noAbonne;
		}
	}

	/**
	 * La m�thode mutateur setNom() permet de modifier le nom de l'abonn� par
	 * celui re�u en param�tre.
	 * 
	 * @param nom
	 *            Le nom de l'abonn�.
	 */

	public void setNom( String nom ) {
		if ( nom.length() <= Abonne.MAX_CAR_NOM ) {
			this.nom = nom;
		}
	}

	/**
	 * La m�thode publique lireNoAbonne() permet de lire le num�ro de l'abonn�
	 * et de modifier le champ du num�ro de l'abonn�.
	 */
	
	public void lireNoAbonne() {
		final String QUEST_NO_ABONNE = "\nEntrez le num�ro de l'abonn� ("
				+ Abonne.NB_CAR_NO_ABONNE + " car.) : ";

		String noAbonne;

		noAbonne = OutilsLecture.lireChaineExacte(
									QUEST_NO_ABONNE, Abonne.NB_CAR_NO_ABONNE );

		this.setNoAbonne( noAbonne );
	}

	/**
	 * La m�thode publique lireNom() permet de lire le nom de l'abonn�
	 * et de modifier le champ du nom de l'abonn�.
	 */
	
	public void lireNom() {
		final String QUEST_NOM = "\nEntrez le nom de l'abonn� (entre "
				+ Abonne.MIN_CAR_NOM + " et " + Abonne.MAX_CAR_NOM
				+ " car.) : ";
		
		String nom;
		
		nom = OutilsLecture.lireChaineValide(
						QUEST_NOM, Abonne.MIN_CAR_NOM, Abonne.MAX_CAR_NOM );

		this.setNom( nom );
	}
	
	/**
	 * La m�thode lireAutresRenseignements() permet de lire les autres
	 * renseignements de l'abonn� connaissant le num�ro de l'abonn�.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements de"
				+ " l'abonn� num�ro " + this.getNoAbonne() );
		
		this.lireNom();
	}

	/**
	 * La m�thode afficher() permet d'afficher tous les renseignements de
	 * l'abonn�.
	 */
	
	public void afficher() {
		System.out.println( "\nRenseignements de l'abonn�.\n" );
		System.out.println( "Num�ro :\t" + this.getNoAbonne() );
		System.out.println( "Nom :\t\t" + this.getNom() );
		
		if ( tabDocsAb.estVide() ) {
			System.out.println( "\nL'abonn� n'a emprunt� aucun document." );
		} else {
			System.out.println(
					"\nListe des documents emprunt�s par l'abonn� :" );
			
			Document document;
			
			for ( int i = 0; i < this.tabDocsAb.taille(); ++i ) {
				document = (Document) this.tabDocsAb.obtenirObjet( i );
				document.afficher();
				OutilsLecture.lireEntree( QUEST_CONTINUER );
			}
			
			System.out.println( "\nL'abonn� a emprunt� " +
					this.tabDocsAb.taille() + " document(s)." );
		}
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return les informations de l'abonn� sous forme de cha�ne de caract�res.
	 */
	
	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getNoAbonne() + "," +
	           this.getNom() + "," + this.getTabDocsAb() + "]";

	   return infos;
	}

	/**
	 * Red�finition de la m�thode equals() de la classe Object. L'objet courant
	 * est �gal � l'objet re�u en param�tre lorsque les num�ros d'abonn� sont
	 * �gaux.
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

			if ( autreObjet instanceof Abonne ) {

				// Convertir le type de l'autre objet en type Abonne.
				Abonne autre = (Abonne) autreObjet;

				// Les objets sont identiques si les num�ros d'abonn�
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
	 * Impl�mentation de la m�thode compareTo() de l'interface Comparable. Un
	 * objet de type Abonne est plus petit qu'un autre objet de type Abonne,
	 * lorsque le noAbonne du premier objet est alphab�tiquement plus petit que
	 * le noAbonne du deuxi�me objet. On ne fait pas de diff�rence entre les
	 * caract�res minuscules et les caract�res majuscules.
	 * 
	 * @param autreAbonne
	 *            L'autre abonn� � comparer avec celui courant de type Abonne.
	 * 
	 * @return une valeur n�gative si l'abonn� courant est plus petit que
	 *         l'autre abonn�, une valeur positive si l'abonn� courant est plus
	 *         grand que l'autre abonn� ou 0 si l'abonn� courant est �gal �
	 *         l'autre abonn�.
	 */
	
	@Override
	public int compareTo( Abonne autreAbonne ) {
		int valCompare;

		valCompare = this.getNoAbonne().compareToIgnoreCase(
												autreAbonne.getNoAbonne() );

		return valCompare;
	}
}