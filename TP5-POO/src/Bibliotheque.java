/**
 * Auteur  : Soti
 * Fichier : Bibliotheque.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

// Package du syst�me.
import java.io.*;

/**
 * La classe Bibliotheque contient les donn�es et les m�thodes pour une
 * biblioth�que.
 * Cette classe impl�mente l'interface Serializable.
 */

public class Bibliotheque implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'une biblioth�que.
	static final long serialVersionUID = 2;
	
	// Constantes de la classe Bibliotheque.
	
	public static final int MAX_DOCUMENTS = 10000;
	public static final int MAX_ABONNES   = 10000;
	
	// Champs d'instances priv�s de la classe Bibliotheque.
	// Dans une biblioth�que, il y a des documents, des abonn�s et des pr�ts.
	
	private TabObjets tabDocuments;
	private TabObjets tabAbonnes;
	private TabObjets tabPrets;
	
	/**
	 * Le constructeur Bibliotheque() permet de construire l'objet de la
	 * biblioth�que. Il initialise les objets qui g�re tous les documents, tous
	 * les abonn�s et tous les pr�ts.
	 */
	
	public Bibliotheque() {
		this.tabDocuments = new TabObjets( Bibliotheque.MAX_DOCUMENTS );
		this.tabAbonnes = new TabObjets( Bibliotheque.MAX_ABONNES );
		this.tabPrets = new TabObjets( Bibliotheque.MAX_DOCUMENTS );
	}

	/**
	 * La m�thode accesseur getTabDocuments() permet de retourner l'objet qui
	 * g�re tous les documents.
	 * 
	 * @return l'objet qui g�re tous les documents.
	 */
	
	public TabObjets getTabDocuments() {
		return this.tabDocuments;
	}
	
	/**
	 * La m�thode accesseur getTabAbonnes() permet de retourner l'objet qui
	 * g�re tous les abonn�s.
	 * 
	 * @return l'objet qui g�re tous les abonn�s.
	 */

	public TabObjets getTabAbonnes() {
		return this.tabAbonnes;
	}

	/**
	 * La m�thode accesseur getTabPrets() permet de retourner l'objet qui
	 * g�re tous les pr�ts.
	 * 
	 * @return l'objet qui g�re tous les pr�ts.
	 */

	public TabObjets getTabPrets() {
		return this.tabPrets;
	}
	
	/**
	 * La m�thode publique statique lireFicBin() permet de lire un objet de type
	 * Bibliotheque du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire d�j� ouvert en mode lecture.
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
			System.out.println( "\nErreur d'entr�e-sortie avec le fichier "
					+ "binaire." );
			bibliotheque = null;
		}

		return bibliotheque;
	}

	/**
	 * La m�thode ecrireFicBin() permet d'�crire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire d�j� ouvert en mode �criture.
	 */
	
	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		// this fait r�f�rence � l'objet courant de type Bibliotheque.

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'�criture d'un objet Bibliotheque "
					+ "dans le fichier binaire." );
		}
	}
}