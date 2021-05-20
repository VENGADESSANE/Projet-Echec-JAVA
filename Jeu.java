import java.util.Scanner;
import java.util.Random;

public class Jeu { 

	private Echiquier echiquier;
	private Player joueur1;
	private Player joueur2;
	private int compteur;
	
	// Le constructeur de jeu 1VS1
public Jeu() {
	System.out.println("** Vous avez choisis le mode un contre un **");
	System.out.println("-- Entrer le nom du premier joueur --");
	Scanner a = new Scanner(System.in);
	String nom1 = a.nextLine();
	this.joueur1 = new Player(nom1, "blanc");
	
	System.out.println("-- Entrer le nom du deuxiéme joueur --");
	Scanner b = new Scanner(System.in);
	String nom2 = b.nextLine();
	this.joueur2 = new Player(nom2, "noir");
	
	System.out.println("** "+nom1 + " vous jouez les piéces blanches et "+ nom2 + " vous jouez les piéces noires **");
	
	this.echiquier = new Echiquier(this);
	} 
	
	// Le constructeur de jeu 1 VS ordinateur
public Jeu(int constante) {	
	this.echiquier = new Echiquier(this);
}
	
	// Lancement du jeu en mode 1VS1
public void jeu_en_cours() {
	this.compteur = 1;
	while ( this.compteur > 0 ) { 
		
		// Vérification si un dés joueurs est en echec du roi
		while (this.echiquier.echec()) {
			this.echiquier.affiche(); 
			String leNom = new String();
			if ( this.compteur%2 == 0 ) { leNom = this.joueur2.getNom(); }
			else { leNom = this.joueur1.getNom(); }
			System.out.println("** Attention " + leNom + " Votre roi est en échec !! **\n ** Vous pouvez jouez uniquement un coup pouvant sauver votre roi **");
			
			// C'est le tour des noires si le compteur de tour est pair (et inversement)
			if ( this.compteur%2 == 0 ) {
			System.out.println("* Au tour des noires *");
			}
			else { System.out.println("* Au tour des blancs *"); }
			
			//INPUT des coordonnés de la case a jouer
			System.out.println("** Indiquez les coordonnées de la case de la piéce que vous voulez jouez ? **");
			Scanner case1 = new Scanner(System.in);
			String coordonees_d = case1.nextLine();
			// Convertissement en INTEGER traitable par l'échiquier
			int[] tab_coordo1 = this.echiquier.conversion1(coordonees_d);
			//Vérification si la case choisis est dans l'échiquier
			if ( tab_coordo1[1] >= 0 && tab_coordo1[1] <= 7 && tab_coordo1[0] >= 0 && tab_coordo1[0] <= 7) {
				
				Case case_d = new Case( tab_coordo1[1], tab_coordo1[0] );
		
				//INPUT des coordonnés de la case de destination
				System.out.println("** Indiquez les coordonnées de la case sur la qu'elle vous voulez vous déplacer ? **");
				Scanner case2 = new Scanner(System.in);
				String coordonees_a = case2.nextLine();
				// Convertissement en INTEGER traitable par l'échiquier
				int[] tab_coordo2 = this.echiquier.conversion1(coordonees_a);
				//Vérification si la case choisis est dans l'échiquier
				if ( tab_coordo2[1] >= 0 && tab_coordo2[1] <= 7 && tab_coordo2[0] >= 0 && tab_coordo2[0] <= 7) {
					
					Case case_a = new Case( tab_coordo2[1], tab_coordo2[0] );
					Piece piece_d = this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ];
					
					//Vérification si le joueur joue bien ses pions
					if ((this.compteur%2 == 0 && piece_d.getCouleur() == 1) || (this.compteur%2 != 0 && piece_d.getCouleur() == 0)) {
					
						//Vérification mouvement
						if (piece_d.verif(case_d, case_a) == true && piece_d.verif_case_libre(case_d, case_a) == true && 
						this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1]].getCouleur() != this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ].getCouleur()  ) {
						
						Piece piece_a = this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ];
						
						//Mouvement
						this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = new Piece(" ",2,this.echiquier);
						this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_d;
						this.compteur = this.compteur + 1;
						
						//Si suite au mouvement un joueur se met en echec : on annule le coup
						if (this.echiquier.echec()) {
							this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = piece_d;
							this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_a;
							this.compteur = this.compteur - 1;
							this.echiquier.affiche();
						}
					}
					else { System.out.println("-- Mouvement impossible -- "); }
				}
				else { System.out.println("-- Vous pouvez jouer uniquement vos piéces --"); }
				
			}
			else { System.out.println("-- Veuillez choisir une case de l'echiquier --"); }
				
			}
			else { System.out.println("-- Veuillez jouer une piéce étant dans une case de l'echiquier --"); }
			
			}
		
		this.echiquier.affiche();
		
		//Si le joueur n'est pas en echec du roi
		// C'est le tour des noires si le compteur de tour est pair (et inversement)
		if ( this.compteur%2 == 0 ) {
			System.out.println("* Au tour des noires *");
		}
		else { System.out.println("* Au tour des blancs *"); }
		
		//INPUT des coordonnés de la case a jouer
		System.out.println("** Indiquez les coordonnées de la case de la piéce que vous voulez jouez ? **");
		Scanner case1 = new Scanner(System.in);
		String coordonees_d = case1.nextLine();
		// Convertissement en INTEGER traitable par l'échiquier
		int[] tab_coordo1 = this.echiquier.conversion1(coordonees_d);
		//Vérification si la case choisis est dans l'échiquier
		if ( tab_coordo1[1] >= 0 && tab_coordo1[1] <= 7 && tab_coordo1[0] >= 0 && tab_coordo1[0] <= 7) {
			Case case_d = new Case( tab_coordo1[1], tab_coordo1[0] );
		
			//INPUT des coordonnés de la case de destination
			System.out.println("** Indiquez les coordonnées de la case sur la qu'elle vous voulez vous déplacer ? **");
			Scanner case2 = new Scanner(System.in);
			String coordonees_a = case2.nextLine();
			// Convertissement en INTEGER traitable par l'échiquier
			int[] tab_coordo2 = this.echiquier.conversion1(coordonees_a);
			if ( tab_coordo2[1] >= 0 && tab_coordo2[1] <= 7 && tab_coordo2[0] >= 0 && tab_coordo2[0] <= 7) {
				
				Case case_a = new Case( tab_coordo2[1], tab_coordo2[0] );
				Piece piece_d = this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ];
				
				//Vérification si le joueur joue bien ses pions
				if ((this.compteur%2 == 0 && piece_d.getCouleur() == 1) || (this.compteur%2 != 0 && piece_d.getCouleur() == 0)) {
					
					//Vérification mouvement
					if ((piece_d.verif(case_d, case_a) == true) && (piece_d.verif_case_libre(case_d, case_a) == true) && 
					(this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1]].getCouleur() != this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ].getCouleur())) {
		
						Piece piece_a = this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ];
						
						//Mouvement
						this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = new Piece(" ",2,this.echiquier);
						this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_d;
						
						//Vérification promotion du pion
						if ((this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ].getNom() == "♙") || (this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ].getNom() == "♟")) {
							System.out.println("2");
							if ( (tab_coordo2[0] == 0) || (tab_coordo2[0] == 7) ) {
								this.echiquier.affiche(); 
								System.out.println("** Vous avez obtenu le droit de promouvoir votre pion ! ** \n ** En qu'elle piéce voulez vous promouvoir votre pion ? (exemple : dame) ** ");
								Scanner c = new Scanner(System.in);
								String nom_p = c.nextLine();
								if (promo_traduction(nom_p) != null) {
									System.out.println(nom_p);
									this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = promo_traduction(nom_p);
								}
								
								
							}
						}
						this.compteur = this.compteur + 1;
					}
					else { System.out.println("-- Mouvement impossible -- "); }
				}
				else { System.out.println("-- Vous pouvez jouer uniquement vos piéces --"); }
				
			}
			else { System.out.println("-- Veuillez choisir une case de l'echiquier --"); }
				
		}
		else { System.out.println("-- Veuillez jouer une piéce étant dans une case de l'echiquier --"); }
	} 
}

//Méthode permettant de traduire la volonté du joueur lors de la promotion du pion
public Piece promo_traduction(String nom_p) {
	
	if (nom_p.equals("dame")) {
		if (this.compteur%2 == 0) {
			return new Dame_noir(this.echiquier);
		}
		else {
			return new Dame_blanc(this.echiquier);
		}
	}
	if (nom_p.equals("cavalier")) {
		if (this.compteur%2 == 0) {
			return new Cavalier_noir(this.echiquier);
		}
		else {
			return new Cavalier_blanc(this.echiquier);
		}
	}
	if (nom_p.equals("tour")) {
		if (this.compteur%2 == 0) {
			return new Tour_noir(this.echiquier);
		}
		else {
			return new Tour_blanc(this.echiquier);
		}
	}
	if (nom_p.equals("fou")) {
		if (this.compteur%2 == 0) {
			return new Fou_noir(this.echiquier);
		}
		else {
			return new Fou_blanc(this.echiquier);
		}
	}
	return null;
	
}

//Mode de jeu contre l'ordinateur
public void jeu_contre_machine() {
	this.compteur = 1;
	
	System.out.println("** Vous avez lancez le mode pour jouer contre l'ordinateur ** \n ** Vous jouez les piéces blanches, Bon courage ! **");
	while ( this.compteur > 0 ) { 
		
	//Si le joueur est en echec du roi
	while (this.echiquier.echec()) {
			this.echiquier.affiche(); 

			System.out.println("** Attention votre roi est en échec !! **\n ** Vous pouvez jouez uniquement un coup pouvant sauver votre roi **");
			
			// C'est le tour des noires si le compteur de tour est pair (et inversement)
			if ( this.compteur%2 == 0 ) {
			System.out.println("* Au tour des noires *");
			}
			else { System.out.println("* C'est a votre tour *"); }
			
			if ( this.compteur%2 != 0 ) {
				System.out.println("** Indiquez les coordonnées de la case de la piéce que vous voulez jouez ? **");
				Scanner case1 = new Scanner(System.in);
				String coordonees_d = case1.nextLine();
				int[] tab_coordo1 = this.echiquier.conversion1(coordonees_d);
				if ( tab_coordo1[1] >= 0 && tab_coordo1[1] <= 7 && tab_coordo1[0] >= 0 && tab_coordo1[0] <= 7) {
					Case case_d = new Case( tab_coordo1[1], tab_coordo1[0] );
		
					System.out.println("** Indiquez les coordonnées de la case sur la qu'elle vous voulez vous déplacer ? **");
					Scanner case2 = new Scanner(System.in);
					String coordonees_a = case2.nextLine();
					int[] tab_coordo2 = this.echiquier.conversion1(coordonees_a);
					if ( tab_coordo2[1] >= 0 && tab_coordo2[1] <= 7 && tab_coordo2[0] >= 0 && tab_coordo2[0] <= 7) {
						Case case_a = new Case( tab_coordo2[1], tab_coordo2[0] );
		
						Piece piece_d = this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ];
						if (piece_d.getCouleur() == 0) {
					
							if (piece_d.verif(case_d, case_a) == true && piece_d.verif_case_libre(case_d, case_a) == true && 
							this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1]].getCouleur() != this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ].getCouleur()  ) {
							Piece piece_a = this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ];
							this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = new Piece(" ",2,this.echiquier);
							this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_d;
							this.compteur = this.compteur + 1;
						
							if (this.echiquier.echec()) {
								this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = piece_d;
								this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_a;
								this.compteur = this.compteur - 1;
								this.echiquier.affiche();
							}
						}
						else { System.out.println("-- Mouvement impossible -- "); }
					}
					else { System.out.println("-- Vous pouvez jouer uniquement vos piéces --"); }
				
				}
				else { System.out.println("-- Veuillez choisir une case de l'echiquier --"); }
				
				}
				
				else { System.out.println("-- Veuillez jouer une piéce étant dans une case de l'echiquier --"); }
			
				}
				}
				
			
		this.echiquier.affiche();
		
		//Si c'est le tour de la machine
		if ( this.compteur%2 == 0 ) {
			System.out.println("* Au tour des noires *");
			
			//déf de 4 valeurs aléatoires
			Random random = new Random();
				int a;
				a = random.nextInt(8);
				int b;
				b = random.nextInt(8);
				int c;
				c = random.nextInt(8);
				int d;
				d = random.nextInt(8);
				Case case_d = new Case(a,b);
				Case case_a = new Case(c,d);
				Piece piece_d = this.echiquier.tableau[b][a];
				Piece piece_a = this.echiquier.tableau[d][c];
			
			//redéf les valeurs tant que un coup est possible
			while (( this.coupPossible_ordi(piece_d, piece_a, case_d, case_a, a, b, c, d) == false) && this.echiquier.echec()==false){
				a = random.nextInt(8);
				b = random.nextInt(8);
				c = random.nextInt(8);
				d = random.nextInt(8);
				case_d = new Case(a,b);
				case_a = new Case(c,d);
				piece_d = this.echiquier.tableau[b][a];
				piece_a = this.echiquier.tableau[d][c];
			}
			//Une fois le coup possible réalisation du mouvement
			System.out.println("L'ordinateur a jouer "+ this.echiquier.tableau[b][a].getNom());
			this.echiquier.tableau[b][a] = new Piece(" ",2,this.echiquier);
			this.echiquier.tableau[d][c] = piece_d;
			this.compteur = this.compteur + 1;
			this.echiquier.affiche();
			
		}
		System.out.println("* C'est a votre tour *"); 
			
		System.out.println("** Indiquez les coordonnées de la case de la piéce que vous voulez jouez ? **");
		Scanner case1 = new Scanner(System.in);
		String coordonees_d = case1.nextLine();
		int[] tab_coordo1 = this.echiquier.conversion1(coordonees_d);
		if ( tab_coordo1[1] >= 0 && tab_coordo1[1] <= 7 && tab_coordo1[0] >= 0 && tab_coordo1[0] <= 7) {
			Case case_d = new Case( tab_coordo1[1], tab_coordo1[0] );
		
			System.out.println("** Indiquez les coordonnées de la case sur la qu'elle vous voulez vous déplacer ? **");
			Scanner case2 = new Scanner(System.in);
			String coordonees_a = case2.nextLine();
			int[] tab_coordo2 = this.echiquier.conversion1(coordonees_a);
			if ( tab_coordo2[1] >= 0 && tab_coordo2[1] <= 7 && tab_coordo2[0] >= 0 && tab_coordo2[0] <= 7) {
				Case case_a = new Case( tab_coordo2[1], tab_coordo2[0] );
		
				Piece piece_d = this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ];
				if (piece_d.getCouleur() == 0) {
			
					if (piece_d.verif(case_d, case_a) == true && piece_d.verif_case_libre(case_d, case_a) == true && 
					this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1]].getCouleur() != this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ].getCouleur()  ) {
						Piece piece_a = this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ];
						this.echiquier.tableau[ tab_coordo1[0] ][ tab_coordo1[1] ] = new Piece(" ",2,this.echiquier);
						this.echiquier.tableau[ tab_coordo2[0] ][ tab_coordo2[1] ] = piece_d;
						this.compteur = this.compteur + 1;
					}
					else { System.out.println("-- Mouvement impossible -- "); }
				}
				else { System.out.println("-- Vous pouvez jouer uniquement vos piéces --"); }
				
			}
			else { System.out.println("-- Veuillez choisir une case de l'echiquier --"); }
				
		}
		else { System.out.println("-- Veuillez jouer une piéce étant dans une case de l'echiquier --"); }
	} 
	}
	
//Ensemble de vérification permettant tout les vérification pour rendre un coup possible
public boolean coupPossible_ordi(Piece piece_d, Piece piece_a, Case case_d, Case case_a, int a, int b, int c, int d) {
	
	if (piece_d.getCouleur() == 1) {
		if (piece_d.verif(case_d, case_a) == true) {
			if (piece_d.verif_case_libre(case_d, case_a) == true) {
				if (this.echiquier.tableau[b][a].getCouleur() != this.echiquier.tableau[d][c].getCouleur()) {
					return true;
				}
			}
		}
	}
	return false;
}
			
				
				


	


	

public static void main(String[] args) {
	
	//Donner la possiblité au joueur de choisir son mode de jeu
	System.out.println("** Qu'elle mode de jeu voulez vous jouez ? **\n  -- Si vous voulez jouer 1 vs 1 entrer '1vs1' --\n  -- Si vous voulez jouer contre l'ordinateur entrer 'pc' --");
	Scanner c = new Scanner(System.in);
	String mode = c.nextLine();
	if (mode.equals("1vs1")) {
		Jeu jeu = new Jeu();
		jeu.jeu_en_cours();
	}
	else if (mode.equals("pc")) {
		Jeu jeu = new Jeu(0);
		jeu.jeu_contre_machine();
	}
	else { System.out.println("** Veuiller entrer une valeur entre '1vs1' ou 'pc' **");
	
			//Boucle pour forcer le joueur a choisir un mode de jeu
			while (!mode.equals("1vs1") || !mode.equals("pc")) {
				c = new Scanner(System.in);
				mode = c.nextLine();
				if (mode.equals("1vs1")) {
					Jeu jeu = new Jeu();
					jeu.jeu_en_cours();
				}
				else if (mode.equals("pc")) {
					Jeu jeu = new Jeu(0);
					jeu.jeu_contre_machine();}
			}
	}
	
}
}

