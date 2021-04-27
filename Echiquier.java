import java.util.*;

public class Echiquier {
	private String pieces_noires;
	private String pieces_blanches;
	public Piece[][] tableau;
	public Jeu jeu;
	
	
	public Echiquier(Jeu jeu) {
		this.jeu = jeu;
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
				tableau[i][y] = new Piece(" ",2);	
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
		System.out.println(new String ("_|_________________"));
		for( int i=0; i<8; i++) {
			String s = new String();
			if (i == 0) {  s = "8| ";}
			else if (i == 1) {  s = "7| ";}
			else if (i == 2) {  s = "6| ";}
			else if (i == 3) {  s = "5| ";}
			else if (i == 4) {  s = "4| ";}
			else if (i == 5) {  s = "3| ";}
			else if (i == 6) {  s = "2| ";}
			else {s = "1| ";}
			
			for(int j=0; j<8; j++) {
				
				s = s + this.tableau[i][j] + "|";
			}
			System.out.println(s);		
		}
		System.out.println(new String ("_|________________|"));
		System.out.println(new String (" | A|B|C|D|E|F|G|H|"));	
		
	}
	
	public boolean verif_case_vide(int x, int y) {
		if (tableau[y][x].getNom() == " ") {return true;}
		else {return false;}
	}
	
	public static int conversion_lettre(char lettre) {
		if(lettre == 'A' || lettre == 'a')
			return 0;
		else if(lettre == 'B' || lettre == 'b')
			return 1;
		else if(lettre == 'C' || lettre == 'c')
			return 2;
		else if(lettre == 'D' || lettre == 'd')
			return 3;
		else if(lettre =='E' || lettre == 'e')
			return 4;
		else if(lettre == 'F' || lettre == 'f')
			return 5;
		else if(lettre == 'G' || lettre == 'g')
			return 6;
		else if(lettre == 'H' || lettre == 'h')
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
	
	public Piece conversion(Case cas) {
		int x = cas.getX();
		int y = cas.getY();
		return this.tableau[y][x];
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
			
	}
}

