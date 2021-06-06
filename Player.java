
public class Player {
	private String couleur;
	private String nom;


	public Player(String nom, String couleur) {
		this.setCouleur(couleur);
		this.setNom(nom);
	}

	/* GETTERS & SETTERS */
	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String prenom) {
		this.nom = prenom;
	}
	/* FIN GETTERS & SETTERS */
}
