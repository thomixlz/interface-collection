package exo_class;

public class Personne {
    private String nom;
    private int taille;
  
    public Personne(String nom, int taille) {
      this.nom = nom;
      this.taille = taille;
    }
  
    public String getNom() {
      return nom;
    }
  
    public int getTaille() {
      return taille;
    }
  }
  