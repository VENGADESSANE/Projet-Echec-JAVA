public class Pion_noir extends Piece {
	private boolean premierCoup;
	private boolean capteurEchec;
	private int compteurCoup;

	public Pion_noir(Echiquier echiquier) {
		super("♟",1,echiquier);
		this.premierCoup = true;
		this.compteurCoup = 0;
		this.capteurEchec = false;
	}
	
	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart, Case arrive) {
		if (this.premierCoup == true && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {return true;}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {return true;}
		else if (this.prise_en_passant(depart, arrive)) {
			return true;
		}
		else if ((depart.getX()-1 == arrive.getX() && arrive.getY()-1 == depart.getY())
				|| (depart.getX()+1 == arrive.getX() && arrive.getY()-1 == depart.getY())
				|| (depart.getX()-1 == arrive.getX() && arrive.getY()+1 == depart.getY())
				|| (depart.getX()+1 == arrive.getX() && arrive.getY()+1 == depart.getY())) {

			if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY()) == false){
				return true;}
			else {return false;}
		}
		else {return false;}	
	}

	//Vérification si personne est sur son chemain
	public boolean verif_case_libre(Case depart, Case arrive) {	
		if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+2) == false) {return false;}
		}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
		}

		else if ((depart.getX()-1 >=0) && (depart.getX()-1 <8)) {
			if (this.echiquier.getNomPiece(depart.getX()-1 ,depart.getY()) == "♟") {
				if (this.prise_en_passant(depart, arrive)) {
					this.echiquier.tableau[depart.getY()][depart.getX()-1] = new Piece(" ",2,this.echiquier);
					return true;}
			}
		}

		else if ((depart.getX()+1 >=0) && (depart.getX()+1 <8)) {
			if (this.echiquier.getNomPiece(depart.getX()+1 ,depart.getY()) == "♟") {
				if (this.prise_en_passant(depart, arrive)) {
					this.echiquier.tableau[depart.getY()][depart.getX()+1] = new Piece(" ",2,this.echiquier);
					return true;}
			}
		}

		if ((depart.getX()-1 == arrive.getX() && arrive.getY()-1 == depart.getY())
				|| (depart.getX()+1 == arrive.getX() && arrive.getY()-1 == depart.getY())
				|| (depart.getX()-1 == arrive.getX() && arrive.getY()+1 == depart.getY())
				|| (depart.getX()+1 == arrive.getX() && arrive.getY()+1 == depart.getY())) {
			if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY()) == false){
				this.premierCoup = false;
				this.compteurCoup++;
				return true;}
			else {return false;}
		}
		this.premierCoup = false;
		System.out.println("premier coup :"+this.premierCoup);
		this.compteurCoup++;
		return true;
	}

	
	//Prise passant 
	public boolean prise_en_passant(Case depart, Case arrive) {
		//Si le pion adverse est a gauche
		if ((depart.getX()-1 >=0) && (depart.getX()-1 <8)) {
			if (this.echiquier.tableau[depart.getY()][depart.getX()-1].getPremierCoup() == false) {
				if (this.echiquier.tableau[depart.getY()][depart.getX()-1].getCompteurCoup() == 1) {
					if (arrive.getX() == depart.getX()-1 && arrive.getY() == depart.getY()+1) {
						if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY())) {
							return true;
						}
					}
				}
			}
		}
		//Si le pion adverse est a droite
		if ((depart.getX()+1 >=0) && (depart.getX()+1 <8)) {
			if (this.echiquier.tableau[depart.getY()][depart.getX()+1].getPremierCoup() == false) {
				if (this.echiquier.tableau[depart.getY()][depart.getX()+1].getCompteurCoup() == 1) {
					if ((arrive.getX() == depart.getX()+1) && (arrive.getY()== depart.getY()+1)) {	
						if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	//Vérification si le roi est présent sur une de ses possiblités de mouvements.
	public boolean verif_si_roi() {
		this.setMa_position(this.ma_position());
		if (this.echiquier.si_roi_blanc(this.getMa_position().getX()+1, this.getMa_position().getY()+1)) {
			return true;
		}
		else if (this.echiquier.si_roi_blanc(this.getMa_position().getX()-1, this.getMa_position().getY()+1)) {
			return true;
		}
		else { return false; }
	}
	
	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {
		this.setMa_position(this.ma_position());
		
		Piece p = this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()];
		this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()] = this;
		if (this.echiquier.echec()==false) {
			this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()] = p;
			return false;
		}
		this.echiquier.tableau[this.getMa_position().getY()+1][this.getMa_position().getX()] = p;
		
		return true;
	}
}






