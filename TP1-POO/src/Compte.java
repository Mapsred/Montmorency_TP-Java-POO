// Auteurs : François Mathieu et Soti
// Fichier : Compte.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 3)

// La classe Compte contient les données et les méthodes pour un
// compte de banque.

public class Compte {

	// Champs d'instance de la classe Compte.
	// On doit trouver seulement deux données privées (champs d'instance),
	// le numéro du compte (un String) et le solde du compte (un double).

	private String noCompte;
	private double solde;

	// TODO (À COMPLÉTER).

	// Constructeur de la classe Compte pour construire un compte de banque
	// avec des valeurs.
	public Compte(String noCompte, double solde) {

		// Exécuter la méthode modifierCompte. Vous devez envoyer les bons
		// paramètres à la méthode.

		modifierCompte(noCompte, solde);
		// TODO (À COMPLÉTER).

	}

	// Méthode accesseur qui retourne le numéro du compte de banque.
	public String getNoCompte() {

		// Retourner le numéro du compte de banque.
		// TODO (À COMPLÉTER).
		return this.noCompte;

	}

	// Méthode accesseur qui retourne le solde du compte de banque.
	public double getSolde() {

		// Retourner le solde du compte de banque.
		// TODO (À COMPLÉTER).
		return this.solde;

	}

	// Méthode mutateur qui modifie le numéro du compte de banque par
	// celui reçu en paramètre.
	public void setNoCompte(String noCompte) {

		// Modifier le numéro du compte de banque par celui reçu en paramètre.
		this.noCompte = noCompte;
		// TODO (À COMPLÉTER).

	}

	// Méthode mutateur qui modifie le solde du compte de banque par
	// celui reçu en paramètre.
	public void setSolde(double solde) {

		// Modifier le solde du compte de banque par celui reçu en paramètre.
		// On doit modifier le solde seulement si le solde reçu en paramètre
		// est supérieur ou égal à 0.
		// Aucun message ne doit apparaître à l'écran.

		if (solde >= 0) {
			this.solde = solde;
		}
		// TODO (À COMPLÉTER).

	}

	// Méthode publique qui permet de déposer de l'argent dans le compte
	// de banque.
	public void deposerArgent(double montant) {

		// Le montant à déposer est reçu en paramètre. On doit ajouter le
		// montant au solde, seulement si le montant reçu en paramètre est
		// supérieur à 0. Aucun message ne doit apparaître à l'écran.

		// TODO (À COMPLÉTER).
		if (montant >= 0) {
			setSolde(montant + getSolde());
		}

	}

	// Méthode publique qui permet de retirer de l'argent du compte de banque.
	public void retirerArgent(double montant) {

		// Le montant à retirer est reçu en paramètre. On doit retirer le
		// montant au solde, seulement si le montant reçu en paramètre est
		// supérieur à 0 et inférieur ou égal au solde actuel.
		// Aucun message ne doit apparaître à l'écran.

		if (montant >= 0 && montant <= getSolde()) {
			setSolde(getSolde() - montant);
		}
		// TODO (À COMPLÉTER).

	}

	// Méthode publique qui modifie les informations du compte de banque par
	// celles reçues en paramètres.
	public void modifierCompte(String noCompte, double solde) {

		// Exécuter les deux méthodes mutateurs appropriées pour faire
		// les modifications.
		this.setSolde(solde);
		this.setNoCompte(noCompte);
		// TODO (À COMPLÉTER).

	}

	// Méthode publique qui affiche les renseignements du compte de banque.
	public void afficherCompte() {

		// Voir en haut de la page 8 de l'énoncé du TP1 pour le format
		// d'affichage. Le format d'affichage doit être respecté.

		System.out.println("Renseignement du compte de banque ");
		System.out.println("\nNuméro du compte :\t" + getNoCompte());
		System.out.println("Solde :\t\t\t" + getSolde());
		// TODO (À COMPLÉTER).

	}
}
