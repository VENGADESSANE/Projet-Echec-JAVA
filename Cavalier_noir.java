public class Cavalier_noir extends Piece {

	public Cavalier_noir(Echiquier echiquier) {
		super("♞",1,echiquier);
	}
	
	public boolean verif(Case depart, Case arrive) {
		if(depart.getY()+2 == arrive.getY() && depart.getX()+1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-2 == arrive.getY() && depart.getX()+1 == arrive.getX()) {
			return true;}
		else if(depart.getY()+2 == arrive.getY() && depart.getX()-1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-2 == arrive.getY() && depart.getX()-1 == arrive.getX()) {
			return true;}
		else if(depart.getY()-1 == arrive.getY() && depart.getX()+2 == arrive.getX()) {
			return true;}
		else if(depart.getY()-1 == arrive.getY() && depart.getX()-2 == arrive.getX()) {
			return true;}
		else if(depart.getY()+1 == arrive.getY() && depart.getX()+2 == arrive.getX()) {
			return true;}
		else if(depart.getY()+1 == arrive.getY() && depart.getX()-2 == arrive.getX()) {
			return true;}
		else
			return false;
		}
	public boolean verif_case_libre(Case depart, Case arrive) {
		return true;}
	
	public boolean verif_si_roi() {
	
		this.setMa_position(this.ma_position());
		
		int x = this.getMa_position().getX()+1;
		int y = this.getMa_position().getY()+2; 
		if (x<8 && y<8 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()+1;
		y = this.getMa_position().getY()-2; 
		if (x<8 && y>=0 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()+2; 	
		if (x>=0 && y<8 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()-1;
		y = this.getMa_position().getY()-2; 
		if (x>=0 && y>=0 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()-1; 
		if (x<8 && y>=0 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()-1;
		if (x>=0 && y>=0 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()+2;
		y = this.getMa_position().getY()+1;
		if (x<8 && y<8 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		x = this.getMa_position().getX()-2;
		y = this.getMa_position().getY()+1;
		if (x>=0 && y<8 && (this.echiquier.si_roi_blanc(x,y))) { return true; }
		return false; 
		}
}

