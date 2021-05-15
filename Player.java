
public class Player {
	private String couleur;
	private String prenom;
	
	// Méthode qui définie la couleur des pièces du joueur et le nom qu'il s'est attriubuer 
	public Player(String prenom, String couleur) {
		this.setCouleur(couleur);
		this.setPrenom(prenom);
	}
	

	/* GETTERS & SETTERS */
	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/* FIN GETTERS & SETTERS */
}
