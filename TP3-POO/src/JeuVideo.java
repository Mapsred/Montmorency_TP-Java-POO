// Auteurs : François Mathieu et Soti
// Fichier : JeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vidéo)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe JeuVideo contient les informations et les méthodes pour un jeu
 * vidéo.
 */

public class JeuVideo {

	// Constantes de la classe JeuVideo.
	public static final int NB_CAR_NO_JEU_VIDEO = 3;

	public static final int MIN_CAR_TITRE = 1;
	public static final int MAX_CAR_TITRE = 100;

	public static final double MIN_PRIX = 0.00;
	public static final double MAX_PRIX = 100.00;

	// Champs d'instance de la classe JeuVideo.
	// Un jeu video est composé d'un numéro, d'un titre et d'un prix.

	private String noJeuVideo;
	private String titre;
	private double prix;

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vidéo de base.
	 */

	public JeuVideo() {

		/*
		 * TODO (À COMPLÉTER). Exécuter l'autre constructeur avec des valeurs de
		 * base : aucun numéro de jeu vidéo (""), aucun titre ("") et un prix de
		 * 0. Inspirez-vous du premier constructeur de la classe Employe qui se
		 * trouve à la page 8 du document 4.
		 */
		this(" ", " ", 0);

	}

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vidéo de base
	 * connaissant son numéro de jeu vidéo.
	 */

	public JeuVideo(String no) {

		/*
		 * TODO (À COMPLÉTER). Exécuter l'autre constructeur avec les valeurs
		 * suivantes : le numéro du jeu vidéo reçu en paramètre (no), aucun
		 * titre ("") et un prix de 0. Inspirez-vous du deuxième constructeur de
		 * la classe Employe qui se trouve à la page 8 du document 4.
		 */
		this(no, " ", 0);

	}

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vidéo avec des
	 * valeurs (numéro du jeu vidéo, titre et prix).
	 */

	public JeuVideo(String no, String titre, double prix) {

		/*
		 * TODO (À COMPLÉTER). Exécuter les méthodes mutateurs (setters) pour
		 * modifier le numéro du jeu vidéo, le titre et le prix par les valeurs
		 * reçues en paramètres. Inspirez-vous du troisième constructeur de la
		 * classe Employe qui se trouve à la page 8 du document 4.
		 */
		this.setNoJeuVideo(no);
		this.setTitre(titre);
		this.setPrix(prix);

	}

	/**
	 * Méthode accesseur qui retourne le numéro du jeu vidéo.
	 */

	public String getNoJeuVideo() {

		/*
		 * TODO (À COMPLÉTER). Retourner le numéro du jeu vidéo.
		 */
		return this.noJeuVideo;

	}

	/**
	 * Méthode accesseur qui retourne le titre du jeu vidéo.
	 */

	public String getTitre() {

		/*
		 * TODO (À COMPLÉTER). Retourner le titre du jeu vidéo.
		 */
		return this.titre;
	}

	/**
	 * Méthode accesseur qui retourne le prix du jeu vidéo.
	 */

	public double getPrix() {

		/*
		 * TODO (À COMPLÉTER). Retourner le prix du jeu vidéo.
		 */
		return this.prix;

	}

	/**
	 * Méthode mutateur qui modifie le numéro du jeu vidéo avec celui reçu en
	 * paramètre.
	 */

	public void setNoJeuVideo(String no) {

		/*
		 * TODO (À COMPLÉTER). Modifier le numéro du jeu vidéo par celui reçu en
		 * paramètre. La modification se fait seulement si le nombre de
		 * caractères du numéro reçu en paramètre est inférieur ou égal à la
		 * constante NB_CAR_NO_JEU_VIDEO. Inspirez-vous de la méthode
		 * setNoEmploye() qui se trouve à la page 9 du document 4.
		 */
		if (no.length() <= NB_CAR_NO_JEU_VIDEO) {
			this.noJeuVideo = no;
		}

	}

	/**
	 * Méthode mutateur qui modifie le titre du jeu vidéo avec celui reçu en
	 * paramètre.
	 */

	public void setTitre(String titre) {

		/*
		 * TODO (À COMPLÉTER). Modifier le titre du jeu vidéo par celui reçu en
		 * paramètre. La modification se fait seulement si le nombre de
		 * caractères du titre reçu en paramètre est inférieur ou égal à la
		 * constante MAX_CAR_TITRE. Inspirez-vous de la méthode setNom() qui se
		 * trouve à la page 9 du document 4.
		 */
		if (titre.length() <= MAX_CAR_TITRE) {
			this.titre = titre;
		}

	}

	/**
	 * Méthode mutateur qui modifie le prix du jeu vidéo avec celui reçu en
	 * paramètre.
	 */

	public void setPrix(double prix) {

		/*
		 * TODO (À COMPLÉTER). Modifier le prix du jeu vidéo par celui reçu en
		 * paramètre. La modification se fait seulement si le prix reçu en
		 * paramètre est supérieur ou égal à la constante MIN_PRIX et inférieur
		 * ou égal à la constante MAX_PRIX. Inspirez-vous de la méthode
		 * setSalaire() qui se trouve à la page 9 du document 4.
		 */
		if (prix >= MIN_PRIX || prix <= MAX_PRIX) {
			this.prix = prix;
		}

	}

	/**
	 * Méthode publique qui lit un numéro de jeu vidéo et modifie le champ du
	 * numéro du jeu vidéo.
	 */

	public void lireNoJeuVideo() {
		final String QUEST_NO_JEU_VIDEO = "\nEntrez le numéro du jeu vidéo ("
				+ JeuVideo.NB_CAR_NO_JEU_VIDEO + " car.) : ";

		/*
		 * TODO (À COMPLÉTER). Lire un numéro de jeu vidéo et modifier le numéro
		 * du jeu vidéo par celui qui a été lu. Inspirez-vous de la méthode
		 * lireNoEmploye() qui se trouve en bas de la page 9 du document 4. Vous
		 * devez utiliser les constantes appropriées.
		 */
		String no1;

		no1 = OutilsLecture.lireChaineExacte(QUEST_NO_JEU_VIDEO,
				JeuVideo.NB_CAR_NO_JEU_VIDEO);

		this.setNoJeuVideo(no1);

	}

	/**
	 * Méthode publique qui lit un titre de jeu vidéo et modifie le champ du
	 * titre du jeu vidéo.
	 */

	public void lireTitre() {
		final String QUEST_TITRE = "\nEntrez le titre du jeu vidéo " + "(max. "
				+ JeuVideo.MAX_CAR_TITRE + " car.) : ";

		/*
		 * TODO (À COMPLÉTER). Lire un titre de jeu vidéo et modifier le titre
		 * du jeu vidéo par celui qui a été lu. Inspirez-vous de la méthode
		 * lireNom() qui se trouve en haut de la page 10 du document 4. Vous
		 * devez utiliser les constantes appropriées.
		 */
		String titre1;

		titre1 = OutilsLecture.lireChaineValide(QUEST_TITRE, MIN_CAR_TITRE,
				MAX_CAR_TITRE);
		
		this.setTitre(titre1);
	}

	/**
	 * Méthode publique qui lit un prix de jeu vidéo et modifie le champ du prix
	 * du jeu vidéo.
	 */

	public void lirePrix() {
		final String QUEST_PRIX = "\nEntrez le prix du jeu vidéo (max. "
				+ OutilsAffichage.formaterMonetaire(JeuVideo.MAX_PRIX, 2)
				+ ") : ";

		/*
		 * TODO (À COMPLÉTER). Lire un prix de jeu vidéo et modifier le prix du
		 * jeu vidéo par celui qui a été lu. Inspirez-vous de la méthode
		 * lireSalaire() qui se trouve à la page 10 du document 4. Vous devez
		 * utiliser les constantes appropriées.
		 */
		double prix1;
		
		prix1 = OutilsLecture.lireReelValide(QUEST_PRIX, MIN_PRIX, MAX_PRIX);
		
		this.setPrix(prix1);

	}

	/**
	 * Méthode publique qui lit les autres renseignements du jeu vidéo
	 * connaissant son numéro de jeu vidéo.
	 */

	public void lireAutresRenseignements() {
		System.out.println("\nEntrez les autres renseignements du jeu vidéo "
				+ "numéro " + this.getNoJeuVideo() + "\n");

		/*
		 * TODO (À COMPLÉTER). Exécuter les méthodes appropriées pour lire le
		 * titre et le prix du jeu vidéo. Inspirez-vous de la méthode
		 * lireAutresRenseignements() qui se trouve à la page 10 du document 4.
		 */
		this.lireTitre();
		this.lirePrix();

	}

	/**
	 * Méthode publique qui affiche les renseignements du jeu vidéo.
	 */

	public void afficherJeuVideo() {

		/*
		 * TODO (À COMPLÉTER). Vous devez afficher les renseignements du jeu
		 * vidéo selon le format indiqué en haut de la page 3 de l'énoncé du
		 * TP3. Les valeurs ne sont que des exemples. Vous devez utiliser des \t
		 * pour l'alignement des valeurs et la méthode
		 * OutilsAffichage.formaterMonetaire() pour l'affichage du prix.
		 * Inspirez-vous de la méthode afficherEmploye() qui se trouve en bas de
		 * la page 10 du document 4.
		 */
		System.out.println("Renseignement du jeu vidéo.\n");
		
		System.out.println("Numéro du jeu vidéo :\t" + this.getNoJeuVideo());
		System.out.println("Titre du jeu vidéo :\t" + this.getTitre());
		System.out.println("Prix du jeu vidéo :\t" + this.getPrix());

	}
}