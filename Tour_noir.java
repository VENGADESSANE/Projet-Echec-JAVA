public class Tour_noir extends Piece {
	
	public Tour_noir() {
		super("♜");
	}
	
	public boolean verif(Case depart,Case arrive) {
		if (depart.getY() == arrive.getY()) {return true;}
		else if (depart.getX() == depart.getX()) {return true;}
		else {return false;}
	}
}
