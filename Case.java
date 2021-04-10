public class Case {
	private int x;
	private int y;
	
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* GETTERS & SETTERS */
	public int getX() {
		return this.x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return this.y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	public boolean devant(Case arrive) {
		if(this.getX() == arrive.getX())
			return true;
		else
			return false;
	}

	public boolean derriere(Case arrive) {
		if(this.getX() == arrive.getX())
			return true;
		else
			return false;
	}

	public boolean cote_droit(Case arrive) {
		if(this.getY() == arrive.getY())
			return true;
		else
			return false;
	}

	public boolean cote_gauche(Case arrive) {
		if(this.getY() == arrive.getY())
			return true;
		else
			return false;
	}


	/* FIN GETTERS & SETTERS */
	

}
