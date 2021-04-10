public class Tour_blanc extends Piece {
	
	public Tour_blanc() {
		super("♖");
	}
	
	public boolean verif(Case depart,Case arrive) {
		if (depart.getY() == arrive.getY()) {return true;}
		else if (depart.getX() == depart.getX()) {return true;}
		else {return false;}
	}
}
