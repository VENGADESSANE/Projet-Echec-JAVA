public class Roi_noir extends Piece {
	private boolean premierCoup;


	public Roi_noir(Echiquier echiquier) {
		super("♚",1,echiquier);
		this.premierCoup = true;

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

	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart, Case arrive) {

		if (this.petite_roque(depart, arrive)) 
			return true;
		if (this.grande_roque(depart, arrive))
			return true;
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

	//Vérification si personne est sur son chemain : ICI toujours vrai car le roi ne peut pas sauter(il se déplace que d'une case)
	public boolean verif_case_libre(Case depart, Case arrive) {return true;}


	//Petite Roque
	public boolean petite_roque(Case depart, Case arrive) {
		if ((arrive.getX()==6) && (arrive.getY()==0)) {
			if ((this.echiquier.tableau[0][6].getNom() == " ") && (this.echiquier.tableau[0][5].getNom() == " ")) {
				if ((depart.getX() == 4) && (depart.getY() == 0) && (this.premierCoup)) {
					if ((this.echiquier.tableau[0][7].getNom() == "♜") && (this.echiquier.tableau[0][0].getPremierCoup())) {
						this.echiquier.tableau[0][5] = this.echiquier.tableau[0][0];
						this.echiquier.tableau[0][7] = new Piece(" ",2,this.echiquier);
						return true;
					}
				}
			}
		}
		return false;
	}

	//Grande Roque
	public boolean grande_roque(Case depart, Case arrive) {
		if ((arrive.getX()==2) && (arrive.getY()==0)) {
			if ((this.echiquier.tableau[0][1].getNom() == " ") && (this.echiquier.tableau[0][2].getNom() == " ") && (this.echiquier.tableau[0][3].getNom() == " ") ) {
				if ((depart.getX() == 4) && (depart.getY() == 0) && (this.premierCoup)) {
					if ((this.echiquier.tableau[0][0].getNom() == "♜") && (this.echiquier.tableau[0][0].getPremierCoup())) {
						this.echiquier.tableau[0][3] = this.echiquier.tableau[0][0];
						this.echiquier.tableau[0][0] = new Piece(" ",2,this.echiquier);
						return true;
					}
				}
			}
		}
		return false;
	}


	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {
		this.setMa_position(this.ma_position());

		try {
			Piece p = 	this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()];
			this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()];
			this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()+1];
			this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()+1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()-1];
			this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()-1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()-1];
			this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()-1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()+1];
			this.echiquier.tableau[this.getMa_position().getY()-1][this.getMa_position().getX()+1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()+1];
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()+1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		try {
			Piece p = this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()-1];
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()-1] = this;
			if (this.echiquier.echec()==false) {
				this.setMa_position(this.ma_position());
				this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
				return false;
			}
			this.setMa_position(this.ma_position());
			this.echiquier.tableau[this.getMa_position().getY()][this.getMa_position().getX()] = p;
		}catch(Exception e){
			return false;
		}
		return true;
	}


}

