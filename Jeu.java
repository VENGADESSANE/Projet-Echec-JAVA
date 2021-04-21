import java.util.Scanner;

public class Jeu {

	private Echiquier echiquier;
	private Player joueur1;
	private Player joueur2;
	
public Jeu() {
	System.out.println("Entrer le nom du premier joueur");
	Scanner a = new Scanner(System.in);
	String nom1 = a.nextLine();
	this.joueur1 = new Player(nom1, "blanc");
	
	System.out.println("Entrer le nom du deuxiéme joueur");
	Scanner b = new Scanner(System.in);
	String nom2 = b.nextLine();
	this.joueur2 = new Player(nom2, "noir");
	
	System.out.println(nom1 + " vous jouez les piéces blanches.");
	System.out.println("Et "+ nom2 + " vous jouez les piéces noires.");
	
	this.echiquier = new Echiquier();
	}
	
public void jeu_en_cours() {

	int i = 0;
	while ( i == 0 ) { 
		this.echiquier.affiche();
		System.out.println("Indiquez les coordonnées de la case de la piéce que vous voulez jouez ?");
		Scanner case1 = new Scanner(System.in);
		String coordonees_d = case1.nextLine();
		int[] tab_coordo1 = this.echiquier.conversion1(coordonees_d);
		Case case_d = new Case( tab_coordo1[1], tab_coordo1[0] );
		
		System.out.println("Indiquez les coordonnées de la case sur la qu'elle vous voulez vous déplacer ?");
		Scanner case2 = new Scanner(System.in);
		String coordonees_a = case2.nextLine();
		int[] tab_coordo2 = this.echiquier.conversion1(coordonees_a);
		Case case_a = new Case( tab_coordo2[1], tab_coordo2[0] );
		
		Piece piece_d = this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ];
		
		if (piece_d.verif(case_d, case_a) == true && piece_d.verif_case_libre(case_d, case_a) == true) {
			this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = new Piece(" ");
			this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_d;
			}
		else { System.out.println("impossible"); }
	}
			
		
		
		
		
		
		
		
}
	


	

public static void main(String[] args) {
	Jeu jeu = new Jeu();
	jeu.jeu_en_cours();
}
}

