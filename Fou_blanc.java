public class Fou_blanc extends Piece {

	public Fou_blanc() {
		super("♗",0);
	}
	
	public boolean diagonale_verif(Case depart, Case arrive) {
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
	
	public boolean verif_case_libre(Case depart, Case arrive) {
		
		if(depart.getY() != arrive.getY() && depart.getX() != arrive.getX()) {
			
			//si le mouvement s'effectue vers en haur à droite
			if(arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while(depart.getX() < px && depart.getY() < px) {
					if(this.echiquier.verif_case_vide(px, py) == false) {
						return false;
						px -= 1;
						py -= 1;
					}
					return true;
				}
			}
			//si le mouvement s'effectue vers en bas à gauche
			if(arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while(depart.getX() < px && depart.getY() < px) {
					if(this.echiquier.verif_case_vide(px, py) == false) {
						return false;
						px += 1;
						py += 1;
					}
					return true;
				}
			}
			//si le mouvement s'effectue vers en haut à gauche
			if(arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while(depart.getX() < px && depart.getY() < px) {
					if(this.echiquier.verif_case_vide(px, py) == false) {
						return false;
						px += 1;
						py -= 1;
					}
					return true;
				}
			}
			//si le mouvement s'effectue vers en bas à droite
			if(arrive.getX() > depart.getX() && arrive.getY() > depart.getY()) {
				int px = arrive.getX();
				int py = arrive.getY();
				while(depart.getX() < px && depart.getY() < px) {
					if(this.echiquier.verif_case_vide(px, py) == false) {
						return false;
						px -= 1;
						py += 1;
					}
					return true;
				}
			}
		}
			
	}
	
}

