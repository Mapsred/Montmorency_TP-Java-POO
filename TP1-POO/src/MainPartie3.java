// Auteurs : François Mathieu et Soti
// Fichier : MainPartie3.java
// Date    : 11 février 2015
// Cours   : 420-165-MO (TP1, Partie 3, ClientBanque, Compte)

// La classe MainPartie3 contient la méthode principale main()
// pour tester les classes ClientBanque et Compte.

public class MainPartie3 {

	// Méthode principale main().
	public static void main(String[] args) {
		ClientBanque client1, client2;

		System.out.println("\nTESTER new ClientBanque() pour "
				+ "les clients 1 et 2.");

		client1 = new ClientBanque("Catherine", "00123", 2000);
		client2 = new ClientBanque("Vincent", "00456", 5000);

		System.out.println("\nTESTER afficherClientBanque() pour "
				+ "le client 1 (Catherine, 00123, 2000).");

		client1.afficherClientBanque();

		System.out.println("\nTESTER afficherClientBanque() pour "
				+ "le client 2 (Vincent, 00456, 5000).");

		client2.afficherClientBanque();

		System.out.println("\nTESTER setNom(\"Simon\") pour "
				+ "le client 2 et\nTESTER getNom() (Simon).");

		client2.setNom("Simon");
		System.out.println("\nNom du client2 : " + client2.getNom());

		System.out.println("\nTESTER setCompte(\"00789\", 10000) pour "
				+ "le client 1 et\nTESTER getCompte().getNoCompte() (00789) et"
				+ " getCompte().getSolde() (10000).");

		client1.setCompte("00789", 10000);
		System.out.println("\nNo compte du client1 : "
				+ client1.getCompte().getNoCompte());
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().setNoCompte(\"22222\") pour "
				+ "le client 2 et\nTESTER getCompte().setSolde(0) pour"
				+ " le client 2 et\nTESTER getCompte().afficherCompte() "
				+ "pour le client 2 (22222, 0).");

		client2.getCompte().setNoCompte("22222");
		client2.getCompte().setSolde(0);
		client2.getCompte().afficherCompte();

		System.out.println("\nTESTER getCompte().setSolde(-50) pour "
				+ "le client 1 (10000)");

		client1.getCompte().setSolde(-50);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER "
				+ "getCompte().modifierCompte(\"11111\", 3000) pour "
				+ "le client 1 et\nTESTER afficherClientBanque() "
				+ "(Catherine, 11111, 3000).");

		client1.getCompte().modifierCompte("11111", 3000);
		client1.afficherClientBanque();

		System.out.println("\nTESTER getCompte().deposerArgent(300) pour "
				+ "le client 1 (3300)");

		client1.getCompte().deposerArgent(300);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().deposerArgent(-300) pour "
				+ "le client 1 (3300)");

		client1.getCompte().deposerArgent(-300);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().retirerArgent(300) pour "
				+ "le client 1 (3000)");

		client1.getCompte().retirerArgent(300);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().retirerArgent(-300) pour "
				+ "le client 1 (3000)");

		client1.getCompte().retirerArgent(-300);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().retirerArgent(3500) pour "
				+ "le client 1 (3000)");

		client1.getCompte().retirerArgent(3500);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER getCompte().retirerArgent(3000) pour "
				+ "le client 1 (0)");

		client1.getCompte().retirerArgent(3000);
		System.out.println("\nSolde du client1 : "
				+ client1.getCompte().getSolde());

		System.out.println("\nTESTER afficherClientBanque() de client 1 "
				+ "(Catherine, 11111, 0.0).");

		client1.afficherClientBanque();

		System.out.println("\nTESTER afficherClientBanque() de client 2 "
				+ "(Simon, 22222, 0.0).");

		client2.afficherClientBanque();

		ClientBanque client3, client4;

		System.out.println("\nTESTER new ClientBanque() pour "
				+ "les clients 3 et 4.");

		client3 = new ClientBanque("Paul", "00450", 3000);
		client4 = new ClientBanque("Marie", "00458", 6000);

		System.out.println("\nTESTER afficherClientBanque() pour "
				+ "le client 3 (Paul, 00450, 3000).");

		client3.afficherClientBanque();

		System.out.println("\nTESTER afficherClientBanque() pour "
				+ "le client 4 (Marie, 00458, 6000).");

		client4.afficherClientBanque();

		// Vous devez ajouter des instructions qui permettent de créer
		// un autre objet de la classe ClientBanque avec au moins deux exemples
		// d'utilisation des méthodes publiques de la classe ClientBanque.
		// Vous devez également ajouter aux moins deux exemples d'utilisation
		// des méthodes publiques de la classe Compte à partir de
		// votre objet ClientBanque.

	}
}
