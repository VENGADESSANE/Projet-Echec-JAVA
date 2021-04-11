public class Pion_blanc extends Piece {
	private int compteur;
	
	public Pion_blanc() {
		super("♙");
	}
	
	public boolean verif(Case depart, Case arrive) {
		if (compteur == 1 && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {return true;}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {return true;}
		else {return false;}
	}
		
}
