public class Cavalier_blanc extends Piece {
	private Echiquier echiquier;

	public Cavalier_blanc(Echiquier echiquier) {
		super("♘",0);
		this.echiquier = echiquier;
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
}
