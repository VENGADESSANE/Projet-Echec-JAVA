
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
	
	public static void main(String args[]) {
		
	}
}
