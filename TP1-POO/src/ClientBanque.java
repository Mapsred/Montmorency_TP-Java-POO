// Auteurs : François Mathieu et Soti
// Fichier : ClientBanque.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 3)

// La classe ClientBanque contient les données et les méthodes pour un
// client de la banque.

public class ClientBanque {

	// Champs d'instance de la classe ClientBanque.
	// On doit trouver seulement deux données privées (champs d'instance),
	// le nom du client (un String) et le compte du client (un Compte).

	private String nom;
	private Compte compte;

	// TODO (À COMPLÉTER).

	// Constructeur de la classe ClientBanque pour construire un client
	// de la banque avec des valeurs.
	public ClientBanque(String nom, String noCompte, double solde) {

		// Exécuter les méthodes mutateurs appropriées pour modifier
		// les champs d'instance par les valeurs reçues en paramètres.
		// Voir la classe Personne (page 28) du document 1 pour vous aider.
		this.setNom(nom);
		this.setCompte(noCompte, solde);

		// TODO (À COMPLÉTER).

	}

	// Méthode accesseur qui retourne le nom du client.
	public String getNom() {

		// Retourner le nom du client.
		return this.nom;
		// TODO (À COMPLÉTER).

	}

	// Méthode accesseur qui retourne le compte du client.
	public Compte getCompte() {

		// Retourner le compte du client.
		return this.compte;
		// TODO (À COMPLÉTER).

	}

	// Méthode mutateur qui modifie le nom du client par celui
	// reçu en paramètre.
	public void setNom(String nom) {

		// Modifier le nom du client par celui reçu en paramètre.
		this.nom = nom;
		// TODO (À COMPLÉTER).

	}

	// Méthode mutateur qui crée un compte avec les informations
	// reçues en paramètre.
	public void setCompte(String noCompte, double solde) {

		// Créer un compte avec les informations reçues en paramètre.
		// Voir la méthode setDateNaissance de la classe Personne (page 28) du
		// document 1 pour vous aider.
		this.compte = new Compte(noCompte, solde);
		// TODO (À COMPLÉTER).

	}

	// Méthode publique qui affiche les renseignements du client.
	public void afficherClientBanque() {

		// Voir en bas de la page 8 de l'énoncé du TP1 pour le format
		// d'affichage. Le format d'affichage doit être respecté.
		// Utiliser la méthode afficherCompte du compte pour afficher
		// les renseignements du compte de banque.
		// Le nom du client doit être aligné avec les valeurs du compte.
		// Voir la méthode afficherPersonne de la classe Personne (page 28) du
		// document 1 pour vous aider.
		System.out.println("\nRenseignements du client de la banque");
		System.out.println("\nNom\t\t\t" + getNom() + "\n");

		this.getCompte().afficherCompte();
		// TODO (À COMPLÉTER).

	}
}
