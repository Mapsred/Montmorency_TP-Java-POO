// Auteurs : François Mathieu et Soti
// Fichier : TabJeuxVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

/**
 * La classe TabJeuxVideo permet de faire la gestion d'un tableau d'objets de
 * type JeuVideo. Cette classe est composée d'un tableau d'objets de type
 * JeuVideo et du nombre de jeux vidéo dans le tableau.
 */

public class TabJeuxVideo {

	// Champs d'instance privés.

	private JeuVideo[] tabJeuxVideo; // Tableau d'objets de type JeuVideo.

	private int nbJeuxVideo; // Nombre de jeux vidéo dans le tableau.

	/**
	 * Le constructeur TabJeuxVideo() permet d'initialiser le tableau des jeux
	 * vidéo. Au début le tableau ne contient aucun jeu vidéo.
	 * 
	 * Le nombre maximum de jeux vidéo du tableau est reçu en paramètre.
	 */

	public TabJeuxVideo(int maxJeuxVideo) {

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous du constructeur de la classe
		 * TabEmployes qui se trouve à la page 11 du document 4.
		 */
		this.tabJeuxVideo = new JeuVideo[maxJeuxVideo];

	}

	/**
	 * La méthode taille() permet de retourner le nombre de jeux vidéo dans le
	 * tableau.
	 */

	public int taille() {

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode taille() qui se
		 * trouve à la page 11 du document 4.
		 */
		return this.nbJeuxVideo;

	}

	/**
	 * La méthode estVide() permet de retourner true si le tableau des jeux
	 * vidéo est vide et false dans le cas contraire.
	 */

	public boolean estVide() {

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode estVide() qui se
		 * trouve à la page 11 du document 4.
		 */
		return (this.taille() == 0);

	}

	/**
	 * La méthode estPlein() permet de retourner true si le tableau des jeux
	 * vidéo est plein et false dans le cas contraire.
	 */

	public boolean estPlein() {

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode estPlein() qui se
		 * trouve à la page 11 du document 4.
		 */
		return (this.taille() == this.tabJeuxVideo.length);

	}

	/**
	 * La méthode obtenirJeuVideo() permet de retourner le jeu vidéo qui est à
	 * un certain indice dans le tableau des jeux vidéo.
	 * 
	 * L'indice du jeu vidéo est reçu en paramètre.
	 * 
	 * Retourne null si l'indice ne fait pas partie des limites du tableau.
	 */

	public JeuVideo obtenirJeuVideo(int indice) {
		JeuVideo jeuVideo = null;

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode obtenirEmploye() qui
		 * se trouve à la page 12 du document 4.
		 */
		if (indice >= 0 && indice < this.taille()) {
			jeuVideo = this.tabJeuxVideo[indice];
		}

		return jeuVideo;
	}

	/**
	 * La méthode ajouter() permet d'ajouter un jeu vidéo dans le tableau des
	 * jeux vidéo. L'ordre croissant des numéros de jeux vidéo est conservé.
	 * 
	 * Le jeu vidéo à ajouter est reçu en paramètre.
	 * 
	 * Retourne true si le jeu vidéo a été ajouté dans le tableau et false dans
	 * le cas contraire.
	 */

	public boolean ajouter(JeuVideo jeuVideo) {
		boolean insertionOk = false;

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode ajouter() qui se
		 * trouve à la page 12 du document 4.
		 */
		if (!this.estPlein()) {

			int indice = this.taille() - 1;

			while (indice >= 0
					&& this.tabJeuxVideo[indice].getNoJeuVideo()
							.compareToIgnoreCase(jeuVideo.getNoJeuVideo()) > 0) {
				this.tabJeuxVideo[indice + 1] = this.tabJeuxVideo[indice];
				--indice;
			}

			this.tabJeuxVideo[indice + 1] = jeuVideo;
			++this.nbJeuxVideo;
			insertionOk = true;
		}

		return insertionOk;
	}

	/**
	 * La méthode supprimer() permet de supprimer un jeu vidéo dans le tableau
	 * des jeux vidéo.
	 * 
	 * Reçoit en paramètre l'indice dans le tableau du jeu vidéo à supprimer.
	 * 
	 * Retourne le jeu vidéo qui a été supprimé ou null s'il a été impossible de
	 * supprimer le jeu vidéo.
	 */

	public JeuVideo supprimer(int indice) {
		JeuVideo jeuVideoSup = null; // Le jeu vidéo qui sera supprimé.

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode supprimer() qui se
		 * trouve à la page 13 du document 4.
		 */
		if (!this.estVide()) {
			if (indice >= 0 && indice < this.taille()) {
				jeuVideoSup = this.tabJeuxVideo[indice];

				for (int ind = indice + 1; ind < this.taille(); ++ind) {
					this.tabJeuxVideo[ind - 1] = this.tabJeuxVideo[ind];
				}
				--this.nbJeuxVideo;
				this.tabJeuxVideo[this.nbJeuxVideo] = null;
			}
		}

		return jeuVideoSup;
	}

	/**
	 * La méthode chercher() permet de chercher un jeu vidéo dans le tableau des
	 * jeux vidéo. Le tableau est en ordre croissant des numéros de jeux vidéo.
	 * La recherche se fait sur le numéro de jeu vidéo. On utilise l'algorithme
	 * de la recherche binaire (recherche dichotomique).
	 * 
	 * Le jeu vidéo à chercher est reçu en paramètre.
	 * 
	 * Retourne l'indice dans le tableau si le jeu vidéo est présent ou la
	 * valeur -1 si le jeu vidéo n'est pas présent.
	 */

	public int chercher(JeuVideo jeuVideo) {
		// Recherche binaire (recherche dichotomique).

		int indTrouve = -1; // Suppose inexistant.
		int indMin = 0;
		int indMax = this.taille() - 1;
		int indMilieu;
		boolean finRecherche = false;

		/*
		 * TODO (À COMPLÉTER). Inspirez-vous de la méthode chercher() qui se
		 * trouve à la page 14 du document 4.
		 */
		while (indMin <= indMax && !finRecherche) {
			indMilieu = (indMin + indMax) / 2;

			if (jeuVideo.getNoJeuVideo().equalsIgnoreCase(
					this.tabJeuxVideo[indMilieu].getNoJeuVideo())) {
				indTrouve = indMilieu;
				finRecherche = true;

			} else if (jeuVideo.getNoJeuVideo().compareToIgnoreCase(
					this.tabJeuxVideo[indMilieu].getNoJeuVideo()) < 0) {
				indMax = indMilieu - 1;

			} else {
				indMin = indMilieu + 1;

			}

		}

		return indTrouve;
	}
}