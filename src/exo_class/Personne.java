package exo_class;

public class Personne {
    private String nom;
    private String prenom;
    private int ancien;
    private int taille;
  
    public Personne(String nom, String prenom, int taille,int ancien) {
      this.nom = nom;
      this.prenom = prenom;
      this.taille = taille;
      this.ancien = ancien;
    }
  
    public String getNom() {
      return nom;
    }
  
    public int getTaille() {
      return taille;
    }

    public int getAncien() {
        return ancien;
      }
  

    public String getPrenom() {
      return prenom;
    }
  }
  