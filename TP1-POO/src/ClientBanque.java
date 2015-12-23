// Auteurs : Fran�ois Mathieu et Soti
// Fichier : ClientBanque.java
// Date    : 11 f�vrier 2015
// Cours   : 420-165-MO (TP1, Partie 3)

// La classe ClientBanque contient les donn�es et les m�thodes pour un
// client de la banque.

public class ClientBanque {

	// Champs d'instance de la classe ClientBanque.
	// On doit trouver seulement deux donn�es priv�es (champs d'instance),
	// le nom du client (un String) et le compte du client (un Compte).

	private String nom;
	private Compte compte;

	// TODO (� COMPL�TER).

	// Constructeur de la classe ClientBanque pour construire un client
	// de la banque avec des valeurs.
	public ClientBanque(String nom, String noCompte, double solde) {

		// Ex�cuter les m�thodes mutateurs appropri�es pour modifier
		// les champs d'instance par les valeurs re�ues en param�tres.
		// Voir la classe Personne (page 28) du document 1 pour vous aider.
		this.setNom(nom);
		this.setCompte(noCompte, solde);

		// TODO (� COMPL�TER).

	}

	// M�thode accesseur qui retourne le nom du client.
	public String getNom() {

		// Retourner le nom du client.
		return this.nom;
		// TODO (� COMPL�TER).

	}

	// M�thode accesseur qui retourne le compte du client.
	public Compte getCompte() {

		// Retourner le compte du client.
		return this.compte;
		// TODO (� COMPL�TER).

	}

	// M�thode mutateur qui modifie le nom du client par celui
	// re�u en param�tre.
	public void setNom(String nom) {

		// Modifier le nom du client par celui re�u en param�tre.
		this.nom = nom;
		// TODO (� COMPL�TER).

	}

	// M�thode mutateur qui cr�e un compte avec les informations
	// re�ues en param�tre.
	public void setCompte(String noCompte, double solde) {

		// Cr�er un compte avec les informations re�ues en param�tre.
		// Voir la m�thode setDateNaissance de la classe Personne (page 28) du
		// document 1 pour vous aider.
		this.compte = new Compte(noCompte, solde);
		// TODO (� COMPL�TER).

	}

	// M�thode publique qui affiche les renseignements du client.
	public void afficherClientBanque() {

		// Voir en bas de la page 8 de l'�nonc� du TP1 pour le format
		// d'affichage. Le format d'affichage doit �tre respect�.
		// Utiliser la m�thode afficherCompte du compte pour afficher
		// les renseignements du compte de banque.
		// Le nom du client doit �tre align� avec les valeurs du compte.
		// Voir la m�thode afficherPersonne de la classe Personne (page 28) du
		// document 1 pour vous aider.
		System.out.println("\nRenseignements du client de la banque");
		System.out.println("\nNom\t\t\t" + getNom() + "\n");

		this.getCompte().afficherCompte();
		// TODO (� COMPL�TER).

	}
}
