// Auteurs : Fran�ois Mathieu et Soti
// Fichier : JeuVideo.java
// Date    : 11 Mars 2015
// Cours   : 420-165-MO (TP3, Gestion Jeux Vid�o)

// Package du programmeur.
import outilsjava.*;

/**
 * La classe JeuVideo contient les informations et les m�thodes pour un jeu
 * vid�o.
 */

public class JeuVideo {

	// Constantes de la classe JeuVideo.
	public static final int NB_CAR_NO_JEU_VIDEO = 3;

	public static final int MIN_CAR_TITRE = 1;
	public static final int MAX_CAR_TITRE = 100;

	public static final double MIN_PRIX = 0.00;
	public static final double MAX_PRIX = 100.00;

	// Champs d'instance de la classe JeuVideo.
	// Un jeu video est compos� d'un num�ro, d'un titre et d'un prix.

	private String noJeuVideo;
	private String titre;
	private double prix;

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vid�o de base.
	 */

	public JeuVideo() {

		/*
		 * TODO (� COMPL�TER). Ex�cuter l'autre constructeur avec des valeurs de
		 * base : aucun num�ro de jeu vid�o (""), aucun titre ("") et un prix de
		 * 0. Inspirez-vous du premier constructeur de la classe Employe qui se
		 * trouve � la page 8 du document 4.
		 */
		this(" ", " ", 0);

	}

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vid�o de base
	 * connaissant son num�ro de jeu vid�o.
	 */

	public JeuVideo(String no) {

		/*
		 * TODO (� COMPL�TER). Ex�cuter l'autre constructeur avec les valeurs
		 * suivantes : le num�ro du jeu vid�o re�u en param�tre (no), aucun
		 * titre ("") et un prix de 0. Inspirez-vous du deuxi�me constructeur de
		 * la classe Employe qui se trouve � la page 8 du document 4.
		 */
		this(no, " ", 0);

	}

	/**
	 * Constructeur de la classe JeuVideo pour construire un jeu vid�o avec des
	 * valeurs (num�ro du jeu vid�o, titre et prix).
	 */

	public JeuVideo(String no, String titre, double prix) {

		/*
		 * TODO (� COMPL�TER). Ex�cuter les m�thodes mutateurs (setters) pour
		 * modifier le num�ro du jeu vid�o, le titre et le prix par les valeurs
		 * re�ues en param�tres. Inspirez-vous du troisi�me constructeur de la
		 * classe Employe qui se trouve � la page 8 du document 4.
		 */
		this.setNoJeuVideo(no);
		this.setTitre(titre);
		this.setPrix(prix);

	}

	/**
	 * M�thode accesseur qui retourne le num�ro du jeu vid�o.
	 */

	public String getNoJeuVideo() {

		/*
		 * TODO (� COMPL�TER). Retourner le num�ro du jeu vid�o.
		 */
		return this.noJeuVideo;

	}

	/**
	 * M�thode accesseur qui retourne le titre du jeu vid�o.
	 */

	public String getTitre() {

		/*
		 * TODO (� COMPL�TER). Retourner le titre du jeu vid�o.
		 */
		return this.titre;
	}

	/**
	 * M�thode accesseur qui retourne le prix du jeu vid�o.
	 */

	public double getPrix() {

		/*
		 * TODO (� COMPL�TER). Retourner le prix du jeu vid�o.
		 */
		return this.prix;

	}

	/**
	 * M�thode mutateur qui modifie le num�ro du jeu vid�o avec celui re�u en
	 * param�tre.
	 */

	public void setNoJeuVideo(String no) {

		/*
		 * TODO (� COMPL�TER). Modifier le num�ro du jeu vid�o par celui re�u en
		 * param�tre. La modification se fait seulement si le nombre de
		 * caract�res du num�ro re�u en param�tre est inf�rieur ou �gal � la
		 * constante NB_CAR_NO_JEU_VIDEO. Inspirez-vous de la m�thode
		 * setNoEmploye() qui se trouve � la page 9 du document 4.
		 */
		if (no.length() <= NB_CAR_NO_JEU_VIDEO) {
			this.noJeuVideo = no;
		}

	}

	/**
	 * M�thode mutateur qui modifie le titre du jeu vid�o avec celui re�u en
	 * param�tre.
	 */

	public void setTitre(String titre) {

		/*
		 * TODO (� COMPL�TER). Modifier le titre du jeu vid�o par celui re�u en
		 * param�tre. La modification se fait seulement si le nombre de
		 * caract�res du titre re�u en param�tre est inf�rieur ou �gal � la
		 * constante MAX_CAR_TITRE. Inspirez-vous de la m�thode setNom() qui se
		 * trouve � la page 9 du document 4.
		 */
		if (titre.length() <= MAX_CAR_TITRE) {
			this.titre = titre;
		}

	}

	/**
	 * M�thode mutateur qui modifie le prix du jeu vid�o avec celui re�u en
	 * param�tre.
	 */

	public void setPrix(double prix) {

		/*
		 * TODO (� COMPL�TER). Modifier le prix du jeu vid�o par celui re�u en
		 * param�tre. La modification se fait seulement si le prix re�u en
		 * param�tre est sup�rieur ou �gal � la constante MIN_PRIX et inf�rieur
		 * ou �gal � la constante MAX_PRIX. Inspirez-vous de la m�thode
		 * setSalaire() qui se trouve � la page 9 du document 4.
		 */
		if (prix >= MIN_PRIX || prix <= MAX_PRIX) {
			this.prix = prix;
		}

	}

	/**
	 * M�thode publique qui lit un num�ro de jeu vid�o et modifie le champ du
	 * num�ro du jeu vid�o.
	 */

	public void lireNoJeuVideo() {
		final String QUEST_NO_JEU_VIDEO = "\nEntrez le num�ro du jeu vid�o ("
				+ JeuVideo.NB_CAR_NO_JEU_VIDEO + " car.) : ";

		/*
		 * TODO (� COMPL�TER). Lire un num�ro de jeu vid�o et modifier le num�ro
		 * du jeu vid�o par celui qui a �t� lu. Inspirez-vous de la m�thode
		 * lireNoEmploye() qui se trouve en bas de la page 9 du document 4. Vous
		 * devez utiliser les constantes appropri�es.
		 */
		String no1;

		no1 = OutilsLecture.lireChaineExacte(QUEST_NO_JEU_VIDEO,
				JeuVideo.NB_CAR_NO_JEU_VIDEO);

		this.setNoJeuVideo(no1);

	}

	/**
	 * M�thode publique qui lit un titre de jeu vid�o et modifie le champ du
	 * titre du jeu vid�o.
	 */

	public void lireTitre() {
		final String QUEST_TITRE = "\nEntrez le titre du jeu vid�o " + "(max. "
				+ JeuVideo.MAX_CAR_TITRE + " car.) : ";

		/*
		 * TODO (� COMPL�TER). Lire un titre de jeu vid�o et modifier le titre
		 * du jeu vid�o par celui qui a �t� lu. Inspirez-vous de la m�thode
		 * lireNom() qui se trouve en haut de la page 10 du document 4. Vous
		 * devez utiliser les constantes appropri�es.
		 */
		String titre1;

		titre1 = OutilsLecture.lireChaineValide(QUEST_TITRE, MIN_CAR_TITRE,
				MAX_CAR_TITRE);
		
		this.setTitre(titre1);
	}

	/**
	 * M�thode publique qui lit un prix de jeu vid�o et modifie le champ du prix
	 * du jeu vid�o.
	 */

	public void lirePrix() {
		final String QUEST_PRIX = "\nEntrez le prix du jeu vid�o (max. "
				+ OutilsAffichage.formaterMonetaire(JeuVideo.MAX_PRIX, 2)
				+ ") : ";

		/*
		 * TODO (� COMPL�TER). Lire un prix de jeu vid�o et modifier le prix du
		 * jeu vid�o par celui qui a �t� lu. Inspirez-vous de la m�thode
		 * lireSalaire() qui se trouve � la page 10 du document 4. Vous devez
		 * utiliser les constantes appropri�es.
		 */
		double prix1;
		
		prix1 = OutilsLecture.lireReelValide(QUEST_PRIX, MIN_PRIX, MAX_PRIX);
		
		this.setPrix(prix1);

	}

	/**
	 * M�thode publique qui lit les autres renseignements du jeu vid�o
	 * connaissant son num�ro de jeu vid�o.
	 */

	public void lireAutresRenseignements() {
		System.out.println("\nEntrez les autres renseignements du jeu vid�o "
				+ "num�ro " + this.getNoJeuVideo() + "\n");

		/*
		 * TODO (� COMPL�TER). Ex�cuter les m�thodes appropri�es pour lire le
		 * titre et le prix du jeu vid�o. Inspirez-vous de la m�thode
		 * lireAutresRenseignements() qui se trouve � la page 10 du document 4.
		 */
		this.lireTitre();
		this.lirePrix();

	}

	/**
	 * M�thode publique qui affiche les renseignements du jeu vid�o.
	 */

	public void afficherJeuVideo() {

		/*
		 * TODO (� COMPL�TER). Vous devez afficher les renseignements du jeu
		 * vid�o selon le format indiqu� en haut de la page 3 de l'�nonc� du
		 * TP3. Les valeurs ne sont que des exemples. Vous devez utiliser des \t
		 * pour l'alignement des valeurs et la m�thode
		 * OutilsAffichage.formaterMonetaire() pour l'affichage du prix.
		 * Inspirez-vous de la m�thode afficherEmploye() qui se trouve en bas de
		 * la page 10 du document 4.
		 */
		System.out.println("Renseignement du jeu vid�o.\n");
		
		System.out.println("Num�ro du jeu vid�o :\t" + this.getNoJeuVideo());
		System.out.println("Titre du jeu vid�o :\t" + this.getTitre());
		System.out.println("Prix du jeu vid�o :\t" + this.getPrix());

	}
}