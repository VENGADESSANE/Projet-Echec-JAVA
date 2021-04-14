import java.util.*;

public class Echiquier {
	private String pieces_noires;
	private String pieces_blanches;
	private Piece[][] tableau;
	
	
	public Echiquier() {
		// Création des String qui contient les noms des piéces a la suite ( je sais pas pk j'ai fait ça xD on verra plus tard si besoin)
		this.pieces_blanches = new String ("♙♖♘♗♕♔");
		this.pieces_noires = new String ("♟♜♞♝♛♚");

		// Création du tableau
		this.tableau = new Piece[8][8];

		// Placement des piéces noires sur l'ecgiquier
		tableau[0][0] = new Tour_noir(this);
		tableau[0][1] = new Cavalier_noir();
		tableau[0][2] = new Fou_noir();
		tableau[0][3] = new Dame_noir(this);
		tableau[0][4] = new Roi_noir();
		tableau[0][5] = new Fou_noir();
		tableau[0][6] = new Cavalier_noir();
		tableau[0][7] = new Tour_noir(this);
		for (int i = 0; i<8; i++) {
			tableau[1][i] = new Pion_noir(this);
		}
		
		// Placement des cases libres au millieu de l'échiquier
		for (int i = 2; i < 6; i++) {
			
			for (int y = 0; y < 8; y++) {
				tableau[i][y] = new Piece(" ");	
			}
		}

		// Placement des piéces blanches sur l'ecgiquier
		tableau[7][0] = new Tour_blanc(this);
		tableau[7][1] = new Cavalier_blanc();
		tableau[7][2] = new Fou_blanc();
		tableau[7][3] = new Dame_blanc(this);
		tableau[7][4] = new Roi_blanc();
		tableau[7][5] = new Fou_blanc();
		tableau[7][6] = new Cavalier_blanc();
		tableau[7][7] = new Tour_blanc(this);
		for (int i = 0; i<8; i++) {
			tableau[6][i] = new Pion_blanc(this);
		}
	}
		
		
	
	public void affiche() {
		for( int i=0; i<8; i++) {
			String s = "|";
			
			for(int j=0; j<8; j++) {
				
				s = s + this.tableau[i][j] + "|";
			}
			System.out.println(s);			
		}
		
	}
	
	public boolean verif_case_vide(int x, int y) {
		if (tableau[y][x].getNom() == " ") {return true;}
		else {return false;}
	}
	
	
	
	public static void main(String args[]) {
		Echiquier e1 = new Echiquier();
		e1.affiche();
	}
}


