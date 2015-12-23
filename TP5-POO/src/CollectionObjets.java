/**
 * Auteur  : Soti
 * Fichier : CollectionObjets.java
 * Cours   : 420-165-MO (TP5, Biblioth�que)
 * Date    : 6 mai 2015
 */

/**
 * L'interface CollectionObjets permet d'indiquer les op�rations de base pour la
 * gestion d'une collection d'objets. Cette interface ne pr�cise pas comment les
 * objets sont organis�s, mais d�finit le comportement d'une collection
 * d'objets.
 */

public interface CollectionObjets {
	
	/**
	 * La m�thode taille() permet de conna�tre le nombre d'objets de la
	 * collection.
	 * 
	 * @return le nombre d'objets de la collection.
	 */
	
	public abstract int taille();

	/**
	 * La m�thode estVide() permet de v�rifier si la collection est vide.
	 * 
	 * @return true si la collection est vide et false dans le cas contraire.
	 */
	
	public abstract boolean estVide();

	/**
	 * La m�thode estPlein() permet de v�rifier si la collection est pleine.
	 * 
	 * @return true si la collection est pleine et false dans le cas contraire.
	 */
	
	public abstract boolean estPlein();

	/**
	 * La m�thode chercher() permet de chercher un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet � chercher.
	 * 
	 * @return l'indice dans la collection, si l'objet est pr�sent ou 
	 *         la valeur -1, si l'objet n'est pas pr�sent.
	 */	
	
	public abstract int chercher( Object obj );
	
	/**
	 * La m�thode ajouter() permet d'ajouter un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet � ajouter.
	 * 
	 * @return true si l'objet a �t� ajout� et false dans le cas contraire.
	 */
	
	public abstract boolean ajouter( Object obj );

	/**
	 * La m�thode supprimer() permet de supprimer l'objet qui se trouve � une
	 * certaine position dans la collection.
	 * 
	 * @param indice
	 *            L'indice de l'objet � supprimer.
	 * 
	 * @return l'objet qui a �t� supprim� ou null s'il est impossible de
	 *         supprimer l'objet.
	 */
	
	public abstract Object supprimer( int indice );

	/**
	 * La m�thode supprimer() permet de supprimer un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet � supprimer.
	 * 
	 * @return l'objet qui a �t� supprim� ou null s'il est impossible de
	 *         supprimer l'objet.
	 */
	
	public abstract Object supprimer( Object obj );
}