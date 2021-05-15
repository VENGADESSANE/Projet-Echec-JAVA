public class Fou_blanc extends Piece {

	public Fou_blanc(Echiquier echiquier) {
		super("♗",0,echiquier);
	}
	
	public boolean verif(Case depart, Case arrive) {
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
	
	// Vérification si personne est sur le chemin
	public boolean verif_case_libre(Case depart,Case arrive) {
		//si le mouvement s'effectue en diagonale 
		if (depart.getY() != arrive.getY() && depart.getX() != arrive.getX()) {
			//si le mouvement s'effectue vers le haut a droite
			if (arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while (depart.getX() < px && depart.getY() < px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px - 1;
					py = py - 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le bas a gauche
			if (arrive.getX() < depart.getX() && arrive.getY() < depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while (depart.getX() > px && depart.getY() > px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px + 1;
					py = py + 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le haut a gauche 
			if (arrive.getX() < depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();	
				while (depart.getX() > px && depart.getY() < px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px + 1;
					py = py - 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le bas a droite
			if (arrive.getX() > depart.getX() && arrive.getY() < depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while (depart.getX() < px && depart.getY() > px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px - 1;
					py = py + 1;
				}
				return true;
			}
			
		}

		return false;

	}
	
	public boolean verif_si_roi() { 
		
		this.setMa_position(this.ma_position());
		
		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY()+1; 
		while ( x<8 && y<8 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x++;y++;
		}
		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()-1;
		while ( x<8 && y>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x++;y--;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()+1;
		while ( y<8 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x--;y++;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()-1;
		while ( y>=0 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x--;y--;
		}
		return false;
	}
	
}

