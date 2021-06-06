public class Dame_blanc extends Piece {

	public Dame_blanc(Echiquier echiquier) {
		super("♕", 0,echiquier);
	}

	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart,Case arrive) {
		if (depart.getY() == arrive.getY()) {return true;}
		else if (depart.getX() == arrive.getX()) {return true;}
		for (int i = 0; i <= 8; i++) {
			if (depart.getX()+i == arrive.getX() && depart.getY()+i == arrive.getY()) {return true;}
			if (depart.getX()-i == arrive.getX() && depart.getY()-i == arrive.getY()) {return true;}
			if (depart.getX()-i == arrive.getX() && depart.getY()+i == arrive.getY()) {return true;}
			if (depart.getX()+i == arrive.getX() && depart.getY()-i == arrive.getY()) {return true;}
		}
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
				return true;
			}
			// si le mouvement s'effectue vers la gauche
			if (arrive.getX() < depart.getX()) {
				for (int i = depart.getX()-1; i > arrive.getX(); i--) {
					if (this.echiquier.verif_case_vide(i, depart.getY()) == false) {return false;}
				}
				return true;
			}
		}
		// si le mouvement s'effectue en vertical
		if (depart.getY() != arrive.getY() && depart.getX() == arrive.getX()) {
			// si le mouvement s'effectue vers le haut
			if (arrive.getY() > depart.getY()) {
				for (int i = depart.getY()+1; i < arrive.getY(); i++) {
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
				}
				return true;
			}
			// si le mouvement s'effectue vers le bas
			if (arrive.getY() < depart.getY()) {
				for (int i = depart.getY()-1; i > arrive.getY(); i--) {
					System.out.println(this.echiquier.verif_case_vide(depart.getX(), i));
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
				}
				return true;

			}
		}


		//si le mouvement s'effectue en diagonale 
		if (depart.getY() != arrive.getY() && depart.getX() != arrive.getX()) {
			//si le mouvement s'effectue vers le haut a droite
			if (arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX()-1;
				int py = arrive.getY()-1;
				while (depart.getX() < px && depart.getY() < px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px - 1;
					py = py - 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le bas a gauche
			if (arrive.getX() < depart.getX() && arrive.getY() < depart.getY()) {
				int px = arrive.getX()+1;
				int py = arrive.getY()+1;
				while (depart.getX() > px && depart.getY() > px) {
					System.out.println("bobbboo");
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px + 1;
					py = py + 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le haut a gauche 
			if (arrive.getX() < depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX()+1;
				int py = arrive.getY()-1;	
				while (depart.getX() > px && depart.getY() < px) {
					if (this.echiquier.verif_case_vide(px, py) == false) {return false;}
					px = px + 1;
					py = py - 1;
				}
				return true;
			}
			//si le mouvement s'effectue vers le bas a droite
			if (arrive.getX() > depart.getX() && arrive.getY() < depart.getY()) {
				int px = arrive.getX()-1;
				int py = arrive.getY()+1;
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

	//Vérification si le roi est présent sur une de ses possiblités de mouvements.
	public boolean verif_si_roi() {

		this.setMa_position(this.ma_position());

		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY(); 
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x++;
		}

		x = this.getMa_position().getX()-1;
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			x--;
		}

		x = this.getMa_position().getX();
		y = this.getMa_position().getY()+1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			y++;
		}

		y = this.getMa_position().getY()-1;
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y) || this.echiquier.si_roi_noir(x,y))) {
			if (this.echiquier.si_roi_noir(x,y)) {return true;}
			y--;
		}

		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()+1; 
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


	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {

		this.setMa_position(this.ma_position());
		Piece p = null;
		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY(); 
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x++;
		}

		x = this.getMa_position().getX()-1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( x<8 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x--;
		}

		x = this.getMa_position().getX();
		y = this.getMa_position().getY()+1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			y++;
		}

		y = this.getMa_position().getY()-1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( y<8 && y>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			y--;
		}

		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()+1; 
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( x<8 && y<8 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x++;y++;
		}
		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()-1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( x<8 && y>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x++;y--;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()+1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( y<8 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x--;y++;
		}
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()-1;
		try {
			p = this.echiquier.tableau[y][x];
		}catch(Exception e) {

		}
		while ( y>=0 && x>=0 && (this.echiquier.verif_case_vide(x,y))) {
			this.echiquier.tableau[y][x] = this;
			if (this.echiquier.echec()==false) {
				this.echiquier.tableau[y][x] = p;
				return false;
			}
			this.echiquier.tableau[y][x] = p;
			x--;y--;
		}

		return true;
	}


}

