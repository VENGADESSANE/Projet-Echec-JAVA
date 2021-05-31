import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Echiquier {
	public Piece[][] tableau;


	public Echiquier() {
		//this.pieces = new String ("♙♖♘♗♕♔♟♜♞♝♛♚");

		// Création du tableau
		this.tableau = new Piece[8][8];

		// Placement des piéces noires sur l'echiquier
		tableau[0][0] = new Tour_noir(this);
		tableau[0][1] = new Cavalier_noir(this);
		tableau[0][2] = new Fou_noir(this);
		tableau[0][3] = new Dame_noir(this);
		tableau[0][4] = new Roi_noir(this);
		tableau[0][5] = new Fou_noir(this);
		tableau[0][6] = new Cavalier_noir(this);
		tableau[0][7] = new Tour_noir(this);
		for (int i = 0; i<8; i++) {
			tableau[1][i] = new Pion_noir(this);
		}

		// Placement des cases libres au millieu de l'échiquier
		for (int i = 2; i < 6; i++) {

			for (int y = 0; y < 8; y++) {
				//Les cases libres sont représenter par des pions n'ayant pas de nom afin de permettre
				//un bon affichage de l'échiquer a travers tout les platformes.
				tableau[i][y] = new Piece(" ",2,this);	
			}
		}

		// Placement des piéces blanches sur l'echiquier
		tableau[7][0] = new Tour_blanc(this);
		tableau[7][1] = new Cavalier_blanc(this);
		tableau[7][2] = new Fou_blanc(this);
		tableau[7][3] = new Dame_blanc(this);
		tableau[7][4] = new Roi_blanc(this);
		tableau[7][5] = new Fou_blanc(this);
		tableau[7][6] = new Cavalier_blanc(this);
		tableau[7][7] = new Tour_blanc(this);
		for (int i = 0; i<8; i++) {
			tableau[6][i] = new Pion_blanc(this);
		}
	}
	//Constructeur qui permet de crée un tableau a partir d'un fichier.
	public Echiquier(String adresse) {

		// Création du tableau
		this.tableau = new Piece[8][8];

		try {
			BufferedReader br = new BufferedReader(new FileReader(adresse));
			String ligne;

			ligne = br.readLine();
			for (int i = 0;i<8 && ligne != null;i++) {

				for (int j = 0;j<8 && ligne != null;j++) {

					if (ligne.equals("♙")) {
						this.tableau[i][j] = new Pion_blanc(this);
					}
					else if (ligne.equals("♖")) {
						this.tableau[i][j] = new Tour_blanc(this);
					}
					else if (ligne.equals("♘")) {
						this.tableau[i][j] = new Cavalier_blanc(this);
					}
					else if (ligne.equals("♗")) {
						this.tableau[i][j] = new Fou_blanc(this);
					}
					else if (ligne.equals("♕")) {
						this.tableau[i][j] = new Dame_blanc(this);
					}
					else if (ligne.equals("♔")) {
						this.tableau[i][j] = new Roi_blanc(this);
					}

					else if (ligne.equals("♟")) {
						this.tableau[i][j] = new Pion_noir(this); 
					}
					else if (ligne.equals("♞")) {
						this.tableau[i][j] = new Cavalier_noir(this);
					}
					else if (ligne.equals("♝")) {
						this.tableau[i][j] = new Fou_noir(this);
					}
					else if (ligne.equals("♛")) {
						this.tableau[i][j] = new Dame_noir(this);
					}
					else if (ligne.equals("♚")) {
						this.tableau[i][j] = new Roi_noir(this);
					}
					else if (ligne.equals("♜")) {
						this.tableau[i][j] = new Tour_noir(this);
					}

					else {
						this.tableau[i][j] = new Piece(" ",2,this);
					} 


					ligne = br.readLine();
				}
			}


			br.close();
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}

	public void Enregistrer() {

		try {
			FileWriter fw = new FileWriter("/home/subbu/eclipse-workspace/Jeu_echec/src/charger");
			for (int i = 0;i<8;i++) {

				for (int j = 0;j<8;j++) {
					fw.write(this.tableau[i][j] + "\n");	
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	//Méthode pérmettant l'affichage de l'échiquer
	public void affiche() {
		//System.out.println(this.tableau[4][2].getPremierCoup()+this.tableau[4][2].getNom());
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

	//Vérification si une case est vide
	public boolean verif_case_vide(int x, int y) {
		if (tableau[y][x].getNom() == " ") {return true;}
		else {return false;}
	}

	//Vérification si une case contient un roi
	public boolean si_roi_noir(int x, int y) {
		if ( x < 8 && x >= 0 && y < 8 && y >= 0) {
			if (tableau[y][x].getNom() == "♚") {;return true;}
			else return false;}
		else {return false;}
	}

	public boolean si_roi_blanc(int x, int y) {
		if ( x < 8 && x >= 0 && y < 8 && y >= 0) {
			if (tableau[y][x].getNom() == "♔") {;return true;}
			else return false;}
		else {return false;}
	}

	//Conversion des lettes INPUT en INTEGER traitable par les classes
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

	//Conversion des numero INPUT en INTEGER leur correspondant
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

	//Conversion des coordonnees INPUT vers des données traitable par les classes
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

	//Vérifcation si le roi est en echec
	public boolean echec() {
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (this.tableau[a][b].verif_si_roi()) {
					return true;}
			}
		}
		return false;}

	//Retourne nom de la piece en fonction de ses coordonnees.
	public String getNomPiece(int x, int y) {
		return this.tableau[y][x].getNom();
	}

	//Retourne la Piece en fonction de sa case.
	public Piece getPiece(Case cas) {
		return this.tableau[cas.getY()][cas.getX()];
	}


	/*public static void main(String args[]) {
		Echiquier e1 = new Echiquier();
		e1.affiche();
		e1.Enregistrer();

		Echiquier e2 = new Echiquier("/home/subbu/eclipse-workspace/Jeu_echec/src/charger");
		e2.affiche();
	}
	 */
}

