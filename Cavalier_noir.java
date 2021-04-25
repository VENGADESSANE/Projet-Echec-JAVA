public class Cavalier_noir extends Piece {

	public Cavalier_noir() {
		super("♞",1);
	}
	
	public boolean devant_droite(Case depart, Case arrive) {
			if(arrive.getX() == depart.getX()- 1 && arrive.getY() == depart.getY() - 2)
				return true;
			else 
				return false;
	}
	
	public boolean devant_gauche(Case depart, Case arrive) {
			if(arrive.getX() == depart.getX() + 1 && arrive.getY() == depart.getY() - 2)
				return true;
			else 
				return false;
	}
	
	public boolean droite_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX() - 2 && arrive.getY() == depart.getY() - 1)
			return true;
		else 
			return false;
	}
	
	public boolean droite_bas(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX() - 2 && arrive.getY() == depart.getY() + 1)
			return true;
		else 
			return false;
	}
	
	public boolean gauche_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX() + 2 && arrive.getY() == depart.getY() - 1)
			return true;
		else 
			return false;
	}
	
	public boolean gauche_bas(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX() + 2 && arrive.getY() == depart.getY() + 1)
			return true;
		else 
			return false;
	}
	
	public boolean derriere_droite(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()- 1 && arrive.getY() == depart.getY() + 2)
			return true;
		else 
			return false;
	}
	
	public boolean derriere_gauche(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()+ 1 && arrive.getY() == depart.getY() + 2)
			return true;
		else 
			return false;
	}
	
}

