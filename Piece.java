
public class Piece {
	private String nom;
	
	
	public Piece(String symbole) {
		this.nom = symbole;

	}
	
	

	/* GETTERS & SETTERS */

	public String getNom() {
		return this.nom;
	}

	public void setNom(String symbole) {
		this.nom = symbole;
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
	
	public static void main(String args[]) {
		
	}
}
