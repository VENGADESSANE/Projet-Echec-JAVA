public class Pion_blanc extends Piece {
	private Echiquier echiquier;
	private int compteur;
	
	public Pion_blanc(Echiquier echiquier) {
		super("♙");
		this.echiquier = echiquier;
	}
	
	public boolean verif(Case depart, Case arrive) {
		if (compteur == 1 && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {return true;}
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
		
}
