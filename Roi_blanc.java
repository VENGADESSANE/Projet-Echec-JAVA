public class Roi_blanc extends Piece {
	private boolean premierCoup;

	public Roi_blanc(Echiquier echiquier) {
		super("♔",0,echiquier);
		this.premierCoup = true;

	}

	//Mouvement une case devant 
	public boolean devant(Case depart, Case arrive) {
		if(depart.getX() == arrive.getX() && depart.getY()-1 == arrive.getY()) {
			return true;
		}
		return false;
	}

	//Mouvement une case derrière
	public boolean derriere(Case depart, Case arrive) {
		if(depart.getX() == arrive.getX() && depart.getY()+1 == arrive.getY()) {
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
		
		if (this.petite_roque(depart, arrive)) 
			return true;
		if (this.grande_roque(depart, arrive))
			return true;
		if(this.cote_droit(depart, arrive))
			return true;

		if(this.cote_gauche(depart, arrive))
			return true;

		if(this.devant(depart, arrive) == true)
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

	public boolean petite_roque(Case depart, Case arrive) {
		if ((arrive.getX()==6) && (arrive.getY()==7)) {
			if ((this.echiquier.tableau[7][6].getNom() == " ") && (this.echiquier.tableau[7][5].getNom() == " ")) {
				if ((depart.getX() == 4) && (depart.getY() == 7) && (this.premierCoup)) {
					if ((this.echiquier.tableau[7][7].getNom() == "♖") && (this.echiquier.tableau[7][7].getPremierCoup())) {
						this.echiquier.tableau[7][5] = this.echiquier.tableau[7][7];
						this.echiquier.tableau[7][7] = new Piece(" ",2,this.echiquier);
						return true;

					}

				}
			}
		}
		return false;
	}
	
	public boolean grande_roque(Case depart, Case arrive) {
		if ((arrive.getX()==2) && (arrive.getY()==7)) {
			if ((this.echiquier.tableau[7][1].getNom() == " ") && (this.echiquier.tableau[7][2].getNom() == " ") && (this.echiquier.tableau[7][3].getNom() == " ") ) {
				if ((depart.getX() == 4) && (depart.getY() == 7) && (this.premierCoup)) {
					if ((this.echiquier.tableau[7][0].getNom() == "♖") && (this.echiquier.tableau[7][0].getPremierCoup())) {
						this.echiquier.tableau[7][3] = this.echiquier.tableau[7][0];
						this.echiquier.tableau[7][0] = new Piece(" ",2,this.echiquier);
						return true;

					}

				}
			}
		}
		return false;
	}


}

