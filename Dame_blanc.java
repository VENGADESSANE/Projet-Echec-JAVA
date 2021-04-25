public class Dame_blanc extends Piece {

	private Echiquier echiquier;

	public Dame_blanc(Echiquier echiquier) {
		super("♕", 0);
		this.echiquier = echiquier;
	}
	
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
					else {return true;}
				}
			}
			// si le mouvement s'effectue vers la gauche
			if (arrive.getX() < depart.getX()) {
				for (int i = depart.getX()-1; i >= arrive.getX(); i--) {
					if (this.echiquier.verif_case_vide(i, depart.getY()) == false) {return false;}
					else {return true;}
				}
			}
		}
		// si le mouvement s'effectue en vertical
		if (depart.getY() != arrive.getY() && depart.getX() == arrive.getX()) {
			// si le mouvement s'effectue vers le haut
			if (arrive.getY() > depart.getY()) {
				for (int i = depart.getY()+1; i < arrive.getY(); i++) {
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
					else {return true;}
				}
			}
			// si le mouvement s'effectue vers le bas
			if (arrive.getY() < depart.getY()) {
				for (int i = depart.getY()-1; i >= arrive.getY(); i--) {
					if (this.echiquier.verif_case_vide(depart.getX(), i) == false) {return false;}
					else {return true;}
				}
			}
		}
		
		
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
	
}
