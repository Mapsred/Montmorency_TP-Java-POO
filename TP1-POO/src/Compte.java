// Auteurs : Fran�ois Mathieu et Soti
// Fichier : Compte.java
// Date    : 11 f�vrier 2015
// Cours   : 420-165-MO (TP1, Partie 3)

// La classe Compte contient les donn�es et les m�thodes pour un
// compte de banque.

public class Compte {

	// Champs d'instance de la classe Compte.
	// On doit trouver seulement deux donn�es priv�es (champs d'instance),
	// le num�ro du compte (un String) et le solde du compte (un double).

	private String noCompte;
	private double solde;

	// TODO (� COMPL�TER).

	// Constructeur de la classe Compte pour construire un compte de banque
	// avec des valeurs.
	public Compte(String noCompte, double solde) {

		// Ex�cuter la m�thode modifierCompte. Vous devez envoyer les bons
		// param�tres � la m�thode.

		modifierCompte(noCompte, solde);
		// TODO (� COMPL�TER).

	}

	// M�thode accesseur qui retourne le num�ro du compte de banque.
	public String getNoCompte() {

		// Retourner le num�ro du compte de banque.
		// TODO (� COMPL�TER).
		return this.noCompte;

	}

	// M�thode accesseur qui retourne le solde du compte de banque.
	public double getSolde() {

		// Retourner le solde du compte de banque.
		// TODO (� COMPL�TER).
		return this.solde;

	}

	// M�thode mutateur qui modifie le num�ro du compte de banque par
	// celui re�u en param�tre.
	public void setNoCompte(String noCompte) {

		// Modifier le num�ro du compte de banque par celui re�u en param�tre.
		this.noCompte = noCompte;
		// TODO (� COMPL�TER).

	}

	// M�thode mutateur qui modifie le solde du compte de banque par
	// celui re�u en param�tre.
	public void setSolde(double solde) {

		// Modifier le solde du compte de banque par celui re�u en param�tre.
		// On doit modifier le solde seulement si le solde re�u en param�tre
		// est sup�rieur ou �gal � 0.
		// Aucun message ne doit appara�tre � l'�cran.

		if (solde >= 0) {
			this.solde = solde;
		}
		// TODO (� COMPL�TER).

	}

	// M�thode publique qui permet de d�poser de l'argent dans le compte
	// de banque.
	public void deposerArgent(double montant) {

		// Le montant � d�poser est re�u en param�tre. On doit ajouter le
		// montant au solde, seulement si le montant re�u en param�tre est
		// sup�rieur � 0. Aucun message ne doit appara�tre � l'�cran.

		// TODO (� COMPL�TER).
		if (montant >= 0) {
			setSolde(montant + getSolde());
		}

	}

	// M�thode publique qui permet de retirer de l'argent du compte de banque.
	public void retirerArgent(double montant) {

		// Le montant � retirer est re�u en param�tre. On doit retirer le
		// montant au solde, seulement si le montant re�u en param�tre est
		// sup�rieur � 0 et inf�rieur ou �gal au solde actuel.
		// Aucun message ne doit appara�tre � l'�cran.

		if (montant >= 0 && montant <= getSolde()) {
			setSolde(getSolde() - montant);
		}
		// TODO (� COMPL�TER).

	}

	// M�thode publique qui modifie les informations du compte de banque par
	// celles re�ues en param�tres.
	public void modifierCompte(String noCompte, double solde) {

		// Ex�cuter les deux m�thodes mutateurs appropri�es pour faire
		// les modifications.
		this.setSolde(solde);
		this.setNoCompte(noCompte);
		// TODO (� COMPL�TER).

	}

	// M�thode publique qui affiche les renseignements du compte de banque.
	public void afficherCompte() {

		// Voir en haut de la page 8 de l'�nonc� du TP1 pour le format
		// d'affichage. Le format d'affichage doit �tre respect�.

		System.out.println("Renseignement du compte de banque ");
		System.out.println("\nNum�ro du compte :\t" + getNoCompte());
		System.out.println("Solde :\t\t\t" + getSolde());
		// TODO (� COMPL�TER).

	}
}
