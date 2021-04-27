public class Roi_noir extends Piece {
	private Echiquier echiquier;

	public Roi_noir(Echiquier echiquier) {
		super("♚",1);
		this.echiquier = echiquier;
	}
	
	//Mouvement une case devant 
	public boolean devant(Case depart, Case arrive) {
		if(depart.getX() == arrive.getX() && depart.getY()+1 == arrive.getY()) {
			return true;
		}
		return false;
	}
	
	//Mouvement une case derrière
	public boolean derriere(Case depart, Case arrive) {
		if(depart.getX() == arrive.getX() && depart.getY()-1 == arrive.getY()) {
			return true;
		}
		return false;
	}
	
	//Mouvement une case à droite
	public boolean cote_droit(Case depart, Case arrive) {
		if(depart.getX()+1 == arrive.getX() && depart.getY() == arrive.getY()) {
			return true;
		}
		return false;
	}
	
	//Mouvement une case à gauche
	public boolean cote_gauche(Case depart, Case arrive) {
		if(depart.getX()-1 == arrive.getX() && depart.getY() == arrive.getY()) {
			return true;
		}
		return false;
	}
	
	//Mouvement en bas à droite
	public boolean gauche_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()-1 && arrive.getY() == depart.getY()-1)
			return true;
		else
			return false;
	}
	
	//Mouvement en bas à gauche
	public boolean gauche_bas(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()-1 && arrive.getY() == depart.getY()+1)
			return true;
		else
			return false;
	}
	
	//Mouvement en haut à droite
	public boolean droite_haut(Case depart, Case arrive) {
		if(arrive.getX() == depart.getX()+1 && arrive.getY() == depart.getY()-1)
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
	
	//verifaction des mouvements possibles
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
	public boolean verif_case_libre(Case depart, Case arrive) {return true;}
	
}
