
public class Piece {
	private String nom;
	private int couleur;
	public Echiquier echiquier;
	private Case ma_position;
	private boolean premierCoup = true;
	private int compteurCoup =0;

	public Piece(String symbole, int nCouleur, Echiquier echiquier) {
		this.nom = symbole;
		this.couleur = nCouleur;
		this.echiquier = echiquier;

	}



	/* GETTERS & SETTERS */

	public String getNom() {
		return this.nom;
	}

	public void setNom(String symbole) {
		this.nom = symbole;
	}

	public int getCouleur() {
		return this.couleur;
	}

	public void setMa_position(Case position) {
		this.ma_position = position; }

	public Case getMa_position() {
		return this.ma_position; }

	/* FIN GETTERS & SETTERS */

	public String toString() {
		return this.nom;
	}

	//Vérification si la piéce ne sort pas de l'echiquier 
	public boolean verif_dans_echiquier(Case depart, Case arrive) {
		if ( arrive.getX() >= 0 && arrive.getX() <= 7 && arrive.getY() >= 0 && arrive.getY() <= 7) {return true;} 
		else {return false;}
	}

	//Verification si il a le droit de se positioner sur cette case
	public boolean verif(Case depart, Case arrive) { return false; }

	// Vérification si personne est sur le chemin
	public boolean verif_case_libre(Case depart, Case arrive) { return false; }

	//Méthode retournant la position de la piéce sur l'échiquier
	public Case ma_position() {
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (this.echiquier.tableau[a][b] == this) {
					return new Case(b,a);
				}
			}
		}
		return new Case(0,0);
	}

	//Vérification si le roi est présent sur une de ses possiblités de mouvements.
	public boolean verif_si_roi() {
		return false;}


	public boolean getPremierCoup() {
		return this.premierCoup;
	}

	public int getCompteurCoup() {
		return this.compteurCoup;
	}

	public boolean prise_en_passant(Case depart, Case arrive) {
		return false;
	}

	//Vérification si en effectuant un mouvement il peut sauver son roi
	public boolean verif_mat() {
		return true;
	}

	//Véridication si la piéce courante n'est pas roi
	public boolean non_roi() {
		return (this.getNom().equals("♚")==false && this.getNom().equals("♔")==false);
	}
}
