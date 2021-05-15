public class Cavalier_noir extends Piece {

	public Cavalier_noir(Echiquier echiquier) {
		super("♞",1,echiquier);
	}
	
	//la méthode vérifie tout les déplacements possible de la pièce cavalier 
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

