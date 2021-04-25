public class Roi_blanc extends Piece {

	public Roi_blanc() {
		super("♔",0);
	}
	
	//Mouvement une case devant 
	public boolean devant(Case depart, Case arrive) {
		if(depart.devant(arrive)) {
			if(arrive.getX()== depart.getX()-1)
				return true;
		}
		return false;
	}
	
	//Mouvement une case derrière
	public boolean derriere(Case depart, Case arrive) {
		if(depart.derriere(arrive)) {
			if(arrive.getX() == depart.getX()+1)
				return true;
		}
		return false;
	}
	
	//Mouvement une case à droite
	public boolean cote_droit(Case depart, Case arrive) {
		if(depart.cote_droit(arrive)) {
			if(arrive.getY() == depart.getY()-1)
				return true;
		}
		return false;
	}
	
	//Mouvement une case à gauche
	public boolean cote_gauche(Case depart, Case arrive) {
		if(depart.cote_gauche(arrive)) {
			if(arrive.getY() == depart.getY()+1)
				return true;
		}
		return false;
	}
	
	//Mouvement en haut à gauche
	public boolean gauche_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()-1 && arrive.getY() == depart.getY()-1)
			return true;
		else
			return false;
	}
	
	//Mouvement en bas à gauche
	public boolean gauche_bas(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()+1 && arrive.getY() == depart.getY()-1)
			return true;
		else
			return false;
	}
	
	//Mouvement en haut à droite
	public boolean droite_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()-1 && arrive.getY() == depart.getY()+1)
			return true;
		else 
			return false;
	}
	
	//Mouvement en bas à droite
	public boolean droite_bas(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()+1 && arrive.getY() == depart.getY()+1)
			return true;
		else 
			return false;
	}
	
	public boolean verif(Case depart, Case arrive) {
		
		if(this.cote_droit(depart, arrive))
			return true;
		
		if(this.cote_gauche(depart, arrive))
			return true;
		
		if(this.devant(depart, arrive))
			return true;
		
		if(this.derriere(depart, arrive))
			return true;
		
		if(this.droite_bas(depart, arrive))
			return true;
		
		if(this.droite_haut(depart, arrive))
			return true;
		
		if(this.gauche_bas(depart, arrive))
			return true;
		
		if(this.gauche_haut(depart, arrive))
			return true;
		
		else 
			return false;
	}
	
}

