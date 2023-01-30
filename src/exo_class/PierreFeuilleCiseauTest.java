package exo_class;

import java.util.Scanner;

public class PierreFeuilleCiseauTest {
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);

		Boolean rejouer = true;
		while(rejouer) {
			Partie partie =Partie.creerPartie();
			partie.jouer();	
			
			System.out.println("Tapez 1 pour rejouer ou 0 pour quitter");
			rejouer = scanner.nextInt()==1;
			
		}
		
		
	}

}
