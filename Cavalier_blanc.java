public class Cavalier_blanc extends Piece {

	public Cavalier_blanc(Echiquier echiquier) {
		super("♘",0,echiquier);
	}

	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart, Case arrive) {
		if(depart.getY()+2 == arrive.getY() && depart.getX()+1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-2 == arrive.getY() && depart.getX()+1 == arrive.getX()) {
			return true;}
		else if(depart.getY()+2 == arrive.getY() && depart.getX()-1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-2 == arrive.getY() && depart.getX()-1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-1 == arrive.getY() && depart.getX()+2 == arrive.getX()) {
			return true;}
		else if(depart.getY()-1 == arrive.getY() && depart.getX()-2 == arrive.getX()) {
			return true;}
		else if(depart.getY()+1 == arrive.getY() && depart.getX()+2 == arrive.getX()) {
			return true;}
		else if(depart.getY()+1 == arrive.getY() && depart.getX()-2 == arrive.getX()) {
			return true;}
		else
			return false;
	}

	//Vérification si personne est sur son chemain : ICI toujours vrai car le Cavalier saute les autres piéces.
	public boolean verif_case_libre(Case depart, Case arrive) {
		return true;}

	//Vérification si le roi est présent sur une de ses possiblités de mouvements.
	public boolean verif_si_roi() {

		this.setMa_position(this.ma_position());

		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY()+2; 
		if (x<8 && y<8 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()-2; 
		if (x<8 && y>=0 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()+2; 	
		if (x>=0 && y<8 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()-2; 
		if (x>=0 && y>=0 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()-1; 
		if (x<8 && y>=0 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()-1;
		if (x>=0 && y>=0 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()+1;
		if (x<8 && y<8 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()+1;
		if (x>=0 && y<8 && (this.echiquier.si_roi_noir(x,y))) { return true; }
		return false; 
	}

	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {

		this.setMa_position(this.ma_position());

		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY()+2; 
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()-2; 
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()+2; 
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()-2; 
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()-1;
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()-1;
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()+1;
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()+1;
		if (this.echiquier.coordo_valide(x, y)) {
			Piece p = this.echiquier.tableau[y][x];
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
		}
		return true; 
	}
}

