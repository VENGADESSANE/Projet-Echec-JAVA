import java.util.*;

public class Echiquier {
	private String pieces_noires;
	private String pieces_blanches;
	public Piece[][] tableau;
	
	
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
	
	public static int conversion_lettre(char lettre) {
		if(lettre == 'A')
			return 0;
		else if(lettre == 'B')
			return 1;
		else if(lettre == 'C')
			return 2;
		else if(lettre == 'D')
			return 3;
		else if(lettre =='E')
			return 4;
		else if(lettre == 'F')
			return 5;
		else if(lettre == 'G')
			return 6;
		else if(lettre == 'H')
			return 7;
		else 
			return 404;
		
	}
	
	public static int conversion_chiffre(char numero) {
		int num = Character.getNumericValue(numero);
		if(num == 1) {return 7;}
		else if(num == 2) {return 6;}
		else if(num == 3) {return 5;}
		else if(num == 4) {return 4;}
		else if(num == 5) {return 3;}
		else if(num == 6) {return 2;}
		else if(num == 7) {return 1;}
		else if(num == 8) {return 0;}
		else {return 404;}
	}
	
	public Piece conversion(String coordonees) {
		char x = coordonees.charAt(0);
		char y = coordonees.charAt(1);
		return this.tableau[conversion_chiffre(y)][conversion_lettre(x)];
	}
	
	public int[] conversion1(String coordonees) {
		char x = coordonees.charAt(0);
		char y = coordonees.charAt(1);
		int y1 = conversion_chiffre(y);
		int x1 = conversion_lettre(x);
		int[] res = new int[2];
		res[0] = y1;
		res[1] = x1;
		return res;
	}
	
	
	public static void main(String args[]) {
		Echiquier e1 = new Echiquier();
		e1.affiche();
		System.out.println(e1.conversion1("B2"));
		
	}
}

