public class Fou_noir extends Piece {

	public Fou_noir() {
		super("♝");
	}
	
	public boolean diagonale_verif(Case depart, Case arrive) {
		for(int i = 0; i<=8; i++) {
			if(depart.getX()+i == arrive.getX() && depart.getY()+i == arrive.getY())
				return true;
			if(depart.getX()-i == arrive.getX() && depart.getY()-i == arrive.getY())
				return true;
			if(depart.getX()-i == arrive.getX() && depart.getY()+i == arrive.getY())
				return true;
			if(depart.getX()+i == arrive.getX() && depart.getY()-i == arrive.getY())
				return true;
		}
		return false;
	}
	
}

