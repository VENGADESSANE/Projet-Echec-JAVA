
public class Piece {
	private String nom;
	private int couleur;
	
	public Piece(String symbole, int nCouleur) {
		this.nom = symbole;
		this.couleur = nCouleur;

	}
	
	

	/* GETTERS & SETTERS */

	public String getNom() {
		return this.nom;
	}

	public void setNom(String symbole) {
		this.nom = symbole;
	}
	
	public int getCouleur() {
		return this.couleur;
	}

	/* FIN GETTERS & SETTERS */

	public String toString() {
		return this.nom;
	}
	
	//Vérification si la piéce ne sort pas de l'echiquier 
	public boolean verif_dans_echiquier(Case depart, Case arrive) {
		if ( arrive.getX() >= 0 && arrive.getX() <= 7 && arrive.getY() >= 0 && arrive.getY() <= 7) {return true;} 
		else {return false;}
	}
	
	public boolean verif(Case depart, Case arrive) { return false; }
	public boolean verif_case_libre(Case depart, Case arrive) { return false; }
	
	public static void main(String args[]) {
		
	}
}
