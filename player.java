
public class player {
	private String couleur;
	private String prenom;
	
	
	public player(String prenom, String couleur) {
		this.setCouleur(couleur);
		this.setPrenom(prenom);
	}
	
	public int conversion_lettre(char lettre) {
		if(lettre == 'A')
			return 0;
		else if(lettre == 'B')
			return 1;
		else if(lettre == 'C')
			return 2;
		else if(lettre == 'D')
			return 3;
		else if(lettre == 'E')
			return 4;
		else if(lettre == 'F')
			return 5;
		else if(lettre == 'G')
			return 6;
		else if(lettre == 'H')
			return 7;
		else 
			return 404;
		
	}
	
	public int conversion_chiffre(int numero) {
		if(numero == 1)
			return 1;
		else if(numero == 2)
			return 2;
		else if(numero == 3)
			return 3;
		else if(numero == 4)
			return 4;
		else if(numero == 5)
			return 5;
		else if(numero == 6)
			return 6;
		else if(numero == 7)
			return 7;
		else 
			return 404;
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
