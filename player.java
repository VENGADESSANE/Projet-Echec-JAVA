
public class player {
	private String couleur;
	private String prenom;
	
	
	public player(String prenom, String couleur) {
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
