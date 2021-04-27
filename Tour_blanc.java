public class Tour_blanc extends Piece {
	
	private Echiquier echiquier;
	
	public Tour_blanc(Echiquier echiquier) {
		super("♖",0);
		this.echiquier = echiquier;
	}
	
	public boolean verif(Case depart,Case arrive) {
		if (depart.getY() == arrive.getY()) {return true;}
		else if (depart.getX() == depart.getX()) {return true;}
		else {return false;}
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
}
