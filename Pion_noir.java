public class Pion_noir extends Piece {
	private boolean premierCoup;
	private boolean capteurEchec;

	public Pion_noir(Echiquier echiquier) {
		super("♟",1,echiquier);
		this.echiquier = echiquier;
		this.premierCoup = true;
		this.capteurEchec = false;
	}
	
	public boolean verif(Case depart, Case arrive) {
		if (this.premierCoup == true && depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {return true;}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {return true;}
		else if ((depart.getX()-1 == arrive.getX() && arrive.getY()-1 == depart.getY())
			|| (depart.getX()+1 == arrive.getX() && arrive.getY()-1 == depart.getY())
			|| (depart.getX()-1 == arrive.getX() && arrive.getY()+1 == depart.getY())
			|| (depart.getX()+1 == arrive.getX() && arrive.getY()+1 == depart.getY())) {
			System.out.println("ok");
			if (this.echiquier.verif_case_vide(arrive.getX(), arrive.getY()) == false){
				return true;}
			else {return false;}
			}
		else {return false;}	
	}
	
	public boolean verif_case_libre(Case depart, Case arrive) {
		if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+2) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+2) == false) {return false;}
		}
		else if (depart.getX() == arrive.getX() && arrive.getY() == depart.getY()+1) {
			if (this.echiquier.verif_case_vide(arrive.getX(), depart.getY()+1) == false) {return false;}
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
}






