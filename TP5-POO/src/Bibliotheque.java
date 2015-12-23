/**
 * Auteur  : Soti
 * Fichier : Bibliotheque.java
 * Cours   : 420-165-MO (TP5, Bibliothèque)
 * Date    : 6 mai 2015
 */

// Package du système.
import java.io.*;

/**
 * La classe Bibliotheque contient les données et les méthodes pour une
 * bibliothèque.
 * Cette classe implémente l'interface Serializable.
 */

public class Bibliotheque implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'une bibliothèque.
	static final long serialVersionUID = 2;
	
	// Constantes de la classe Bibliotheque.
	
	public static final int MAX_DOCUMENTS = 10000;
	public static final int MAX_ABONNES   = 10000;
	
	// Champs d'instances privés de la classe Bibliotheque.
	// Dans une bibliothèque, il y a des documents, des abonnés et des prêts.
	
	private TabObjets tabDocuments;
	private TabObjets tabAbonnes;
	private TabObjets tabPrets;
	
	/**
	 * Le constructeur Bibliotheque() permet de construire l'objet de la
	 * bibliothèque. Il initialise les objets qui gère tous les documents, tous
	 * les abonnés et tous les prêts.
	 */
	
	public Bibliotheque() {
		this.tabDocuments = new TabObjets( Bibliotheque.MAX_DOCUMENTS );
		this.tabAbonnes = new TabObjets( Bibliotheque.MAX_ABONNES );
		this.tabPrets = new TabObjets( Bibliotheque.MAX_DOCUMENTS );
	}

	/**
	 * La méthode accesseur getTabDocuments() permet de retourner l'objet qui
	 * gère tous les documents.
	 * 
	 * @return l'objet qui gère tous les documents.
	 */
	
	public TabObjets getTabDocuments() {
		return this.tabDocuments;
	}
	
	/**
	 * La méthode accesseur getTabAbonnes() permet de retourner l'objet qui
	 * gère tous les abonnés.
	 * 
	 * @return l'objet qui gère tous les abonnés.
	 */

	public TabObjets getTabAbonnes() {
		return this.tabAbonnes;
	}

	/**
	 * La méthode accesseur getTabPrets() permet de retourner l'objet qui
	 * gère tous les prêts.
	 * 
	 * @return l'objet qui gère tous les prêts.
	 */

	public TabObjets getTabPrets() {
		return this.tabPrets;
	}
	
	/**
	 * La méthode publique statique lireFicBin() permet de lire un objet de type
	 * Bibliotheque du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire déjà ouvert en mode lecture.
	 * 
	 * @return un objet de type Bibliotheque ou null si fin de fichier.
	 */
	
	public static Bibliotheque lireFicBin( ObjectInputStream ficLecture ) {

		Bibliotheque bibliotheque;

		try {
			bibliotheque = (Bibliotheque) ficLecture.readObject();
		}

		catch ( EOFException errEOF ) {
			bibliotheque = null;
		}

		catch ( ClassNotFoundException errClasse ) {
			System.out.println( "\nErreur, impossible de lire un objet "
					+ "de type Bibliotheque du fichier binaire." );
			bibliotheque = null;
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'entrée-sortie avec le fichier "
					+ "binaire." );
			bibliotheque = null;
		}

		return bibliotheque;
	}

	/**
	 * La méthode ecrireFicBin() permet d'écrire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire déjà ouvert en mode écriture.
	 */
	
	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		// this fait référence à l'objet courant de type Bibliotheque.

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'écriture d'un objet Bibliotheque "
					+ "dans le fichier binaire." );
		}
	}
}