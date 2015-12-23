// Auteurs : Fran�ois Mathieu et Soti
// Fichier : TabJeuxVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

/**
 * La classe TabJeuxVideo permet de faire la gestion d'un tableau d'objets de
 * type JeuVideo. Cette classe est compos�e d'un tableau d'objets de type
 * JeuVideo et du nombre de jeux vid�o dans le tableau.
 */

public class TabJeuxVideo {

	// Champs d'instance priv�s.

	private JeuVideo[] tabJeuxVideo; // Tableau d'objets de type JeuVideo.

	private int nbJeuxVideo; // Nombre de jeux vid�o dans le tableau.

	/**
	 * Le constructeur TabJeuxVideo() permet d'initialiser le tableau des jeux
	 * vid�o. Au d�but le tableau ne contient aucun jeu vid�o.
	 * 
	 * Le nombre maximum de jeux vid�o du tableau est re�u en param�tre.
	 */

	public TabJeuxVideo(int maxJeuxVideo) {

		/*
		 * TODO (� COMPL�TER). Inspirez-vous du constructeur de la classe
		 * TabEmployes qui se trouve � la page 11 du document 4.
		 */
		this.tabJeuxVideo = new JeuVideo[maxJeuxVideo];

	}

	/**
	 * La m�thode taille() permet de retourner le nombre de jeux vid�o dans le
	 * tableau.
	 */

	public int taille() {

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode taille() qui se
		 * trouve � la page 11 du document 4.
		 */
		return this.nbJeuxVideo;

	}

	/**
	 * La m�thode estVide() permet de retourner true si le tableau des jeux
	 * vid�o est vide et false dans le cas contraire.
	 */

	public boolean estVide() {

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode estVide() qui se
		 * trouve � la page 11 du document 4.
		 */
		return (this.taille() == 0);

	}

	/**
	 * La m�thode estPlein() permet de retourner true si le tableau des jeux
	 * vid�o est plein et false dans le cas contraire.
	 */

	public boolean estPlein() {

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode estPlein() qui se
		 * trouve � la page 11 du document 4.
		 */
		return (this.taille() == this.tabJeuxVideo.length);

	}

	/**
	 * La m�thode obtenirJeuVideo() permet de retourner le jeu vid�o qui est �
	 * un certain indice dans le tableau des jeux vid�o.
	 * 
	 * L'indice du jeu vid�o est re�u en param�tre.
	 * 
	 * Retourne null si l'indice ne fait pas partie des limites du tableau.
	 */

	public JeuVideo obtenirJeuVideo(int indice) {
		JeuVideo jeuVideo = null;

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode obtenirEmploye() qui
		 * se trouve � la page 12 du document 4.
		 */
		if (indice >= 0 && indice < this.taille()) {
			jeuVideo = this.tabJeuxVideo[indice];
		}

		return jeuVideo;
	}

	/**
	 * La m�thode ajouter() permet d'ajouter un jeu vid�o dans le tableau des
	 * jeux vid�o. L'ordre croissant des num�ros de jeux vid�o est conserv�.
	 * 
	 * Le jeu vid�o � ajouter est re�u en param�tre.
	 * 
	 * Retourne true si le jeu vid�o a �t� ajout� dans le tableau et false dans
	 * le cas contraire.
	 */

	public boolean ajouter(JeuVideo jeuVideo) {
		boolean insertionOk = false;

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode ajouter() qui se
		 * trouve � la page 12 du document 4.
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
	 * La m�thode supprimer() permet de supprimer un jeu vid�o dans le tableau
	 * des jeux vid�o.
	 * 
	 * Re�oit en param�tre l'indice dans le tableau du jeu vid�o � supprimer.
	 * 
	 * Retourne le jeu vid�o qui a �t� supprim� ou null s'il a �t� impossible de
	 * supprimer le jeu vid�o.
	 */

	public JeuVideo supprimer(int indice) {
		JeuVideo jeuVideoSup = null; // Le jeu vid�o qui sera supprim�.

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode supprimer() qui se
		 * trouve � la page 13 du document 4.
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
	 * La m�thode chercher() permet de chercher un jeu vid�o dans le tableau des
	 * jeux vid�o. Le tableau est en ordre croissant des num�ros de jeux vid�o.
	 * La recherche se fait sur le num�ro de jeu vid�o. On utilise l'algorithme
	 * de la recherche binaire (recherche dichotomique).
	 * 
	 * Le jeu vid�o � chercher est re�u en param�tre.
	 * 
	 * Retourne l'indice dans le tableau si le jeu vid�o est pr�sent ou la
	 * valeur -1 si le jeu vid�o n'est pas pr�sent.
	 */

	public int chercher(JeuVideo jeuVideo) {
		// Recherche binaire (recherche dichotomique).

		int indTrouve = -1; // Suppose inexistant.
		int indMin = 0;
		int indMax = this.taille() - 1;
		int indMilieu;
		boolean finRecherche = false;

		/*
		 * TODO (� COMPL�TER). Inspirez-vous de la m�thode chercher() qui se
		 * trouve � la page 14 du document 4.
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