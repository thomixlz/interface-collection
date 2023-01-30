package exo_class;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Manche {

	private Coup coupJoueur1;
	private Coup coupJoueur2;
	private Resultat resultat;
	private LocalDateTime debutManche;
	private LocalDateTime finManche;
	private Map<Coup,Coup> compareCoupMap = new HashMap<>();
	


	public Manche(Coup coupJoueur1, Coup coupJoueur2, LocalDateTime debutManche) {

		this.coupJoueur1 = coupJoueur1;
		this.coupJoueur2 = coupJoueur2;
		this.debutManche = debutManche;
		
		compareCoupMap.put(Coup.PIERRE, Coup.CISEAUX);
		compareCoupMap.put(Coup.FEUILLE, Coup.PIERRE);
		compareCoupMap.put(Coup.CISEAUX, Coup.FEUILLE);

		compareCoupMap.put(Coup.PUIS, Coup.PIERRE);
		compareCoupMap.put(Coup.PUIS, Coup.CISEAUX);
		compareCoupMap.put(Coup.FEUILLE, Coup.PUIS);

	}

/*
	public Resultat compareCoups() {
		if (coupJoueur1.equals(Coup.PIERRE) && coupJoueur2.equals(Coup.CISEAUX)) {
			resultat = Resultat.JOUEUR1_GAGNE;
		} else if (coupJoueur1.equals(Coup.FEUILLE) && coupJoueur2.equals(Coup.PIERRE)) {
			resultat = Resultat.JOUEUR1_GAGNE;
		} else if (coupJoueur1.equals(Coup.CISEAUX) && coupJoueur2.equals(Coup.FEUILLE)) {
			resultat = Resultat.JOUEUR1_GAGNE;
		} else if (coupJoueur2.equals(Coup.PIERRE) && coupJoueur1.equals(Coup.CISEAUX)) {
			resultat = Resultat.JOUEUR2_GAGNE;
		} else if (coupJoueur2.equals(Coup.FEUILLE) && coupJoueur1.equals(Coup.PIERRE)) {
			resultat = Resultat.JOUEUR2_GAGNE;
		} else if (coupJoueur2.equals(Coup.CISEAUX) && coupJoueur1.equals(Coup.FEUILLE)) {
			resultat = Resultat.JOUEUR2_GAGNE;
		} else {
			resultat = Resultat.EGALITE;

		}

		return resultat;
	}*/

	public Resultat compareCoups() {
		if(compareCoupMap.get(coupJoueur1).equals(coupJoueur2)) {
			resultat = Resultat.JOUEUR1_GAGNE; 
		}else if(compareCoupMap.get(coupJoueur2).equals(coupJoueur1)) {
			resultat = Resultat.JOUEUR2_GAGNE; 
		}else {
			resultat = Resultat.EGALITE;
		}
		
		return resultat;	
	}

	public static Coup coupAleatoire() {
		Random r = new Random();
		int randomInt = r.nextInt(3);
		if (randomInt == 0) {
			return Coup.PIERRE;
		} else if (randomInt == 1) {
			return Coup.FEUILLE;
		} else {
			return Coup.CISEAUX;
		}
	}

	public Coup getCoupJoueur1() {
		return coupJoueur1;
	}

	public void setCoupJoueur1(Coup coupJoueur1) {
		this.coupJoueur1 = coupJoueur1;
	}

	public Coup getCoupJoueur2() {
		return coupJoueur2;
	}

	public void setCoupJoueur2(Coup coupJoueur2) {
		this.coupJoueur2 = coupJoueur2;
	}


	public LocalDateTime getDebutManche() {
		return debutManche;
	}

	public void setDebutManche(LocalDateTime debutManche) {
		this.debutManche = debutManche;
	}

	public LocalDateTime getFinManche() {
		return finManche;
	}

	public void setFinManche(LocalDateTime finManche) {
		this.finManche = finManche;
	}

	public Resultat getResultat() {
		return resultat;
	}

	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
	}

	@Override
	public String toString() {
		return "Manche [coupJoueur1=" + coupJoueur1 + ", coupJoueur2=" + coupJoueur2 + ", resultat=" + resultat
				+ ", debutManche=" + debutManche + ", finManche=" + finManche + "]";
	}
	
	
	
}
