package exo_class;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {

	private String pseudo1;
	private String pseudo2;
	private List<Manche> listeManches;
	private LocalDateTime debutPartie;
	private LocalDateTime finPartie;

	public Partie(String pseudo1, String pseudo2, LocalDateTime debutPartie) {
		this.pseudo1 = pseudo1;
		this.pseudo2 = pseudo2;
		this.debutPartie = debutPartie;
		this.listeManches = new ArrayList<>();
	}

	// - Une méthode qui compte le nombre de points du joueur passé en paramètre

	public int compterPoints(String pseudo) {
		int points = 0;
		for (Manche manche : listeManches) {
			if (manche.getResultat().equals(Resultat.JOUEUR1_GAGNE) && pseudo.equals(pseudo1)) {
				points++;
			} else if (manche.getResultat().equals(Resultat.JOUEUR2_GAGNE) && pseudo.equals(pseudo2)) {
				points++;
			}
		}
		return points;
	}

	// - Une méthode qui affiche les 2 joueurs, les manches réalisées et le résultat
	// total ainsi que la date et heure de début de partie et la durée totale de la
	// partie

	public void afficherResultats() {
		System.out.println("Joueur 1 : " + pseudo1);
		System.out.println("Joueur 2 : " + pseudo2);
		System.out.println("Date et heure de début de partie : " + debutPartie);
		Duration duration = Duration.between(debutPartie, finPartie);
		System.out.println("Durée totale de la partie : " + duration.getSeconds());
		System.out.println("Manches réalisées : " + listeManches.size());
		for (Manche manche : listeManches) {
			System.out.println(manche);
		}
		int pointJ1 = compterPoints(pseudo1);
		int pointJ2 = compterPoints(pseudo2);

		System.out.println("Résultat total : " + pointJ1 + " - " + pointJ2);
		System.out.println("Vainqueur : " + ((pointJ1 > pointJ2) ? pseudo1 : pseudo2));
	}

	// - Créer une méthode jouerManche qui récupère le coup du joueur 1 et le coup
	// du joueur 2 (si un seul joueur, elle génère un coup aléatoire)

	public void jouerManche(Coup coup1, Coup coup2) {
		Manche manche = new Manche(coup1, coup2, LocalDateTime.now());
		listeManches.add(manche);
		Resultat resultat = manche.compareCoups();
		String joueurVainqueur = "Egalité";
		if (resultat.equals(Resultat.JOUEUR1_GAGNE)) {
			joueurVainqueur = this.pseudo1;
		} else if (resultat.equals(Resultat.JOUEUR2_GAGNE)) {
			joueurVainqueur = this.pseudo2;
		}
		manche.setFinManche(LocalDateTime.now());
		System.out.println("Vaiqueur de la manche" + joueurVainqueur);
	}

	// - Une méthode creerPartie qui demande le nombre de joueur (1 ou 2) le pseudo
	// du joueur 1 puis du joueur 2 (si 2 joueurs)

	public static Partie creerPartie() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nombre de joueurs ? (1 ou 2)");
		String pseudo1 = "";
		String pseudo2 = "";

		int nbJoueurs = scanner.nextInt();
		if (nbJoueurs == 1) {
			System.out.println("Pseudo du joueur 1 : ");
			pseudo1 = scanner.next();
			pseudo2 = "Ordinateur";
		} else if (nbJoueurs == 2) {
			System.out.println("Pseudo du joueur 1 : ");
			pseudo1 = scanner.next();
			System.out.println("Pseudo du joueur 2 : ");
			pseudo2 = scanner.next();
		} else {
			System.out.println("Nombre de joueurs incorrect");
		}

		return new Partie(pseudo1, pseudo2, LocalDateTime.now());
	}

	// Créer une méthode jouer qui appelle la méthode jouer manche jusqu’à ce qu’un
	// joueur atteigne 3 points. Une fois les 3 points atteints, elle affiche les
	// résultats et termine la partie

	public void jouer() {
		while (compterPoints(pseudo1) < 3 && compterPoints(pseudo2) < 3) {
			Coup joueur1 = jouerCoup();
			Coup joueur2;
			if (pseudo2.equals("Ordinateur")) {
				joueur2 = Manche.coupAleatoire();
			} else {
				joueur2 = jouerCoup();
			}

			jouerManche(joueur1, joueur2);
		}
		finPartie = LocalDateTime.now();
		afficherResultats();
	}

	public Coup jouerCoup() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Jouer coup : Pierre:1, Feuille:2, ciseaux:3");
		int choix = scanner.nextInt();
		Coup coup;
		if (choix == 1) {
			coup = Coup.PIERRE;
		} else if (choix == 2) {
			coup = Coup.FEUILLE;
		} else {
			coup = Coup.CISEAUX;

		}

		return coup;

	}

}
