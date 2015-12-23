/**
 * Auteur  : Soti
 * Fichier : Pret.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

/**
 * La classe Pret contient les donn�es et les m�thodes pour un pr�t de
 * document. Cette classe impl�mente les interfaces Comparable et Serializable.
 */

public class Pret implements Comparable <Pret>, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un Pr�t.
	static final long serialVersionUID = 8;
	
	// Champs d'instances priv�s de la classe Pret.
	
	// Le document de telle cote est pr�t� � l'abonn� de tel num�ro.
	private String cote;
	private String noAbonne;

	/**
	 * Le constructeur Pret() permet de construire un objet pour le pr�t
	 * d'un document connaissant seulement le num�ro de cote du document.
	 * 
	 * @param cote
	 *            Le num�ro de cote du document.
	 */
	
	public Pret( String cote ) {
		// Ex�cuter l'autre constructeur.
		this( cote, "" );
	}

	/**
	 * Le constructeur Pret() permet de construire un objet pour le pr�t
	 * d'un document, connaissant le num�ro de cote du document et le num�ro
	 * d'abonn� qui a emprunt� ce document.
	 * 
	 * @param cote
	 *            Le num�ro de cote du document.
	 * @param noAbonne
	 *            Le num�ro d'abonn� qui a emprunt� ce document.
	 */
	
	public Pret( String cote, String noAbonne ) {
		this.setCote( cote );
		this.setNoAbonne( noAbonne );
	}
	
	/**
	 * La m�thode accesseur getCote() permet de retourner le num�ro de cote du
	 * document qui a �t� pr�t�.
	 * 
	 * @return le num�ro de cote du document pr�t�.
	 */

	public String getCote() {
		return this.cote;
	}
	
	/**
	 * La m�thode accesseur getNoAbonne() permet de retourner le num�ro de
	 * l'abonn� qui a emprunt� le document.
	 * 
	 * @return le num�ro de l'abonn� qui a emprunt� le document.
	 */

	public String getNoAbonne() {
		return this.noAbonne;
	}

	/**
	 * La m�thode mutateur setCote() permet de modifier le num�ro de cote
	 * du document pr�t� par celui re�u en param�tre.
	 * 
	 * @param cote
	 *            Le num�ro de cote du document pr�t�.
	 */

	public void setCote( String cote ) {
		if ( cote.length() <= Document.MAX_CAR_COTE ) {
					
			this.cote = cote;
		}
	}

	/**
	 * La m�thode mutateur setNoAbonne() permet de modifier le num�ro de
	 * l'abonn� qui a emprunt� le document par celui re�u en param�tre.
	 * 
	 * @param noAbonne
	 *            Le num�ro de l'abonn� qui a emprunt� le document.
	 */

	public void setNoAbonne( String noAbonne ) {
		if ( noAbonne.length() <= Abonne.NB_CAR_NO_ABONNE ) {
			this.noAbonne = noAbonne;
		}
	}

	/**
	 * La m�thode afficher() permet d'afficher les renseignements du pr�t.
	 */

	public void afficher() {
		System.out.println( "\nLe document avec le num�ro de cote " +
				this.getCote() + " est pr�t� � l'abonn� num�ro " +
				this.getNoAbonne() );
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return les informations du pr�t sous forme de cha�ne de caract�res.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getCote() + "," +
	           this.getNoAbonne() + "]";

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

			if ( autreObjet instanceof Pret ) {

				// Convertir le type de l'autre objet en type Pret.
				Pret autre = (Pret) autreObjet;

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
	 * objet de type Pret est plus petit qu'un autre objet de type Pret,
	 * lorsque la cote du premier objet est alphab�tiquement plus petite que
	 * la cote du deuxi�me objet. On ne fait pas de diff�rence entre les
	 * caract�res minuscules et les caract�res majuscules.
	 * 
	 * @param autrePret
	 *            L'autre objet � comparer avec celui courant de type Pret.
	 *            
	 * @return une valeur n�gative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est �gal � l'autre objet.
	 */

	@Override
	public int compareTo( Pret autrePret ) {
		int valCompare;

		valCompare = this.getCote().compareToIgnoreCase( autrePret.getCote() );

		return valCompare;
	}
}