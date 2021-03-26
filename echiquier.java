import java.util.*;

public class echiquier {
	ArrayList<piece> Piece = new ArrayList<piece>();
	private Case[][] tableau;
	
	
	public void init() {
		this.tableau = new Case[8][8];
		for( int i=0; i<8; i++) {
			
			for(int j=0; j<8; j++) {
				
				this.tableau[i][j] = new Case(i,j);
				
			}
		}
	}
	
	
	
	
	public String toString() {
		String s = "|";
		for( int i=0; i<8; i++) {
			
			for(int j=0; j<8; j++) {
				
				s +=this.tableau[i][j] + "  |     ";
				
			}
		}
		return s;
	}
	
	
	public echiquier() {
		this.init();
	}
	
	
	public static void main(String args[]) {
		
	}
}


