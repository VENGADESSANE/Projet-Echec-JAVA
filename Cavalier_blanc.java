public class Cavalier_blanc extends Piece {

	public Cavalier_blanc() {
		super("♘",0);
	}
	
	public boolean verif(Case depart, Case arrive) {
		if(this.devant_droite(depart, arrive))
			return true; 
		else if(this.devant_gauche(depart, arrive)) {
			return true;
		}
		else if(this.droite_haut(depart, arrive)) {
			return true;
		}
		else if(this.droite_bas(depart, arrive)) {
			return true;
		}
		else if(this.gauche_haut(depart, arrive)) {
			return true;
		}
		else if(this.gauche_bas(depart, arrive)) {
			return true;
		}
		else if(this.derriere_droite(depart, arrive)) {
			return true;
		}
		else if(this.derriere_gauche(depart, arrive)) {
			return true;
		}
		else
			return false;
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

