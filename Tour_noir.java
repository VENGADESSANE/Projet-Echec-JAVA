public class Tour_noir extends Piece {

	public Tour_noir(Echiquier echiquier) {
		super("♜",1,echiquier);
	}

	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart,Case arrive) {
		if (depart.getY() == arrive.getY()) {return true;}
		if (depart.getX() == arrive.getX()) {return true;}
		return false;
	}

	// Vérification si personne est sur le chemin
	public boolean verif_case_libre(Case depart,Case arrive) {
		// si le mouvement s'effectue en horizontale 
		if (depart.getY() == arrive.getY() && depart.getX() != arrive.getX()) {
			// si le mouvement s'effectue vers la droite
			if (arrive.getX() > depart.getX()) {
				for (int i = depart.getX()+1; i < arrive.getX(); i++) {

					if (this.echiquier.verif_case_vide(i, depart.getY()) == false) {return false;}
				}
			}
			// si le mouvement s'effectue vers la gauche
			if (arrive.getX() < depart.getX()) {
				for (int i = depart.getX()-1; i > arrive.getX(); i--) {
					if (this.echiquier.verif_case_vide(i, depart.getY()) == false) {return false;}
				}
			}
		}
		// si le mouvement s'effectue en vertical
		if (depart.getY() != arrive.getY() && depart.getX() == arrive.getX()) {
			// si le mouvement s'effectue vers le haut
			if (arrive.getY() > depart.getY()) {
				for (int i = depart.getY()+1; i < arrive.getY(); i++) {
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
				}
			}
			// si le mouvement s'effectue vers le bas
			if (arrive.getY() < depart.getY()) {
				for (int i = depart.getY()-1; i > arrive.getY(); i--) {
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
				}
			}
		}
		return true;
	}

	//Vérification si le roi est présent sur une de ses possiblités de mouvements.
	public boolean verif_si_roi() {

		this.setMa_position(this.ma_position());

		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY(); 
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_blanc(x,y))) {
			if (this.echiquier.si_roi_blanc(x,y)) {return true;}
			x++;
		}

		x = this.getMa_position().getX()-1;
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_blanc(x,y))) {
			if (this.echiquier.si_roi_blanc(x,y)) {return true;}
			x--;
		}

		x = this.getMa_position().getX();
		y = this.getMa_position().getY()+1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_blanc(x,y))) {
			if (this.echiquier.si_roi_blanc(x,y)) {return true;}
			y++;
		}

		y = this.getMa_position().getY()-1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_blanc(x,y))) {
			if (this.echiquier.si_roi_blanc(x,y)) {return true;}
			y--;
		}

		return false;
	}

	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {

		this.setMa_position(this.ma_position());

		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY(); 
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
				return false;
			}
			this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
			x++;
		}

		x = this.getMa_position().getX()-1;
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
				return false;
			}
			this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
			x--;
		}

		x = this.getMa_position().getX();
		y = this.getMa_position().getY()+1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
				return false;
			}
			this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
			y++;
		}

		y = this.getMa_position().getY()-1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
				return false;
			}
			this.echiquier.tableau[y][x] = new Piece(" ",2,this.echiquier);
			y--;
		}

		return true;
	}



}
