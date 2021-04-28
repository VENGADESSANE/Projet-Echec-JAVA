public class Pion_blanc extends Piece {
	private boolean premierCoup;
	private boolean capteurEchec;

	public Pion_blanc(Echiquier echiquier) {
		super("♙",0,echiquier);
		this.premierCoup = true;
		this.capteurEchec = false;
	}
	
	public boolean verif(Case depart, Case arrive) {
		if (this.premierCoup == true && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()-2) {return true;}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()-1) {return true;}
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
	
	public boolean verif_case_libre(Case depart, Case arrive) {	
		if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()-2) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()-1) == false) {return false;}
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()-2) == false) {return false;}
		}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()-1) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()-1) == false) {return false;}
		}
		else if ((depart.getX()-1 == arrive.getX() && arrive.getY()-1 == depart.getY())
			|| (depart.getX()+1 == arrive.getX() && arrive.getY()-1 == depart.getY())
			|| (depart.getX()-1 == arrive.getX() && arrive.getY()+1 == depart.getY())
			|| (depart.getX()+1 == arrive.getX() && arrive.getY()+1 == depart.getY())) {
			if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY()) == false){
				this.premierCoup = false;
				return true;}
			else {return false;}
			}
		this.premierCoup = false;
		return true;
	}
	
	public boolean verif_si_roi() {
		this.setMa_position(this.ma_position());
		if (this.echiquier.si_roi_noir(this.getMa_position().getX()+1, this.getMa_position().getY()-1)) {
			return true;
		}
		else if (this.echiquier.si_roi_noir(this.getMa_position().getX()-1, this.getMa_position().getY()-1)) {
			return true;
		}
		else { return false; }
	}
	
}
