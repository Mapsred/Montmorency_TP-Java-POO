/**
 * Auteur  : Soti
 * Fichier : Pret.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

/**
 * La classe Pret contient les données et les méthodes pour un prêt de
 * document. Cette classe implémente les interfaces Comparable et Serializable.
 */

public class Pret implements Comparable <Pret>, Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un Prêt.
	static final long serialVersionUID = 8;
	
	// Champs d'instances privés de la classe Pret.
	
	// Le document de telle cote est prêté à l'abonné de tel numéro.
	private String cote;
	private String noAbonne;

	/**
	 * Le constructeur Pret() permet de construire un objet pour le prêt
	 * d'un document connaissant seulement le numéro de cote du document.
	 * 
	 * @param cote
	 *            Le numéro de cote du document.
	 */
	
	public Pret( String cote ) {
		// Exécuter l'autre constructeur.
		this( cote, "" );
	}

	/**
	 * Le constructeur Pret() permet de construire un objet pour le prêt
	 * d'un document, connaissant le numéro de cote du document et le numéro
	 * d'abonné qui a emprunté ce document.
	 * 
	 * @param cote
	 *            Le numéro de cote du document.
	 * @param noAbonne
	 *            Le numéro d'abonné qui a emprunté ce document.
	 */
	
	public Pret( String cote, String noAbonne ) {
		this.setCote( cote );
		this.setNoAbonne( noAbonne );
	}
	
	/**
	 * La méthode accesseur getCote() permet de retourner le numéro de cote du
	 * document qui a été prêté.
	 * 
	 * @return le numéro de cote du document prêté.
	 */

	public String getCote() {
		return this.cote;
	}
	
	/**
	 * La méthode accesseur getNoAbonne() permet de retourner le numéro de
	 * l'abonné qui a emprunté le document.
	 * 
	 * @return le numéro de l'abonné qui a emprunté le document.
	 */

	public String getNoAbonne() {
		return this.noAbonne;
	}

	/**
	 * La méthode mutateur setCote() permet de modifier le numéro de cote
	 * du document prêté par celui reçu en paramètre.
	 * 
	 * @param cote
	 *            Le numéro de cote du document prêté.
	 */

	public void setCote( String cote ) {
		if ( cote.length() <= Document.MAX_CAR_COTE ) {
					
			this.cote = cote;
		}
	}

	/**
	 * La méthode mutateur setNoAbonne() permet de modifier le numéro de
	 * l'abonné qui a emprunté le document par celui reçu en paramètre.
	 * 
	 * @param noAbonne
	 *            Le numéro de l'abonné qui a emprunté le document.
	 */

	public void setNoAbonne( String noAbonne ) {
		if ( noAbonne.length() <= Abonne.NB_CAR_NO_ABONNE ) {
			this.noAbonne = noAbonne;
		}
	}

	/**
	 * La méthode afficher() permet d'afficher les renseignements du prêt.
	 */

	public void afficher() {
		System.out.println( "\nLe document avec le numéro de cote " +
				this.getCote() + " est prêté à l'abonné numéro " +
				this.getNoAbonne() );
	}

	/**
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return les informations du prêt sous forme de chaîne de caractères.
	 */

	@Override
	public String toString() {
	   String infos;

	   infos = this.getClass().getName() + "[" + this.getCote() + "," +
	           this.getNoAbonne() + "]";

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

			if ( autreObjet instanceof Pret ) {

				// Convertir le type de l'autre objet en type Pret.
				Pret autre = (Pret) autreObjet;

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
	 * objet de type Pret est plus petit qu'un autre objet de type Pret,
	 * lorsque la cote du premier objet est alphabétiquement plus petite que
	 * la cote du deuxième objet. On ne fait pas de différence entre les
	 * caractères minuscules et les caractères majuscules.
	 * 
	 * @param autrePret
	 *            L'autre objet à comparer avec celui courant de type Pret.
	 *            
	 * @return une valeur négative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est égal à l'autre objet.
	 */

	@Override
	public int compareTo( Pret autrePret ) {
		int valCompare;

		valCompare = this.getCote().compareToIgnoreCase( autrePret.getCote() );

		return valCompare;
	}
}