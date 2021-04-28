
public class Piece {
	private String nom;
	private int couleur;
	public Echiquier echiquier;
	private Case ma_position;
	
	public Piece(String symbole, int nCouleur, Echiquier echiquier) {
		this.nom = symbole;
		this.couleur = nCouleur;
		this.echiquier = echiquier;

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
	
	public void setMa_position(Case position) {
		this.ma_position = position; }
	
	public Case getMa_position() {
		return this.ma_position; }

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
	
	public Case ma_position() {
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (this.echiquier.tableau[a][b] == this) {
					return new Case(b,a);
				}
			}
		}
		return new Case(0,0);
	}
	
	public boolean verif_si_roi() {
		return false;}
	
	public static void main(String args[]) {
		
	}
}
