public class Pion_noir extends Piece {
	private Echiquier echiquier;

	public Pion_noir(Echiquier echiquier) {
		super("♟",1);
		this.echiquier = echiquier;
	}
	
	public boolean verif(Case depart, Case arrive) {
		if (this.premierCoup() == true && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {return true;}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {return true;}
		else {return false;}	
	}
	
	public boolean verif_case_libre(Case depart, Case arrive) {
		if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+2) == false) {return false;}
		}
		if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
		}
		return true;
	}
		

	public boolean premierCoup() {
		if ( this.echiquier.premierCoup() == true ) {return true;}
		else {return false;}
	}
	
}
