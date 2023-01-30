package exo_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class CollectionPersonnes {
  private List<Personne> personnes = new ArrayList<>();

  public void ajouterPersonne(Personne p) {
    personnes.add(p);
  }

  public void trierParNom() {
    Collections.sort(personnes, (p1, p2) -> p1.getNom().compareTo(p2.getNom()));
  }

  public void separerEmployesEtudiants() {
    List<Employe> employes = personnes.stream().filter(p -> p instanceof Employe)
        .map(p -> (Employe) p).collect(Collectors.toList());
    List<Etudiant> etudiants = personnes.stream().filter(p -> p instanceof Etudiant)
        .map(p -> (Etudiant) p).collect(Collectors.toList());

    System.out.println("Employes: ");
    employes.forEach(e -> System.out.println(e.getNom()));
    System.out.println("Etudiants: ");
    etudiants.forEach(e -> System.out.println(e.getNom()));
  }

  public void afficherPlusPetiteTaille() {
    Personne plusPetiteTaille = personnes.stream().min((p1, p2) -> p1.getTaille() - p2.getTaille()).orElse(null);
    System.out.println("Personne avec la plus petite taille: " + plusPetiteTaille.getNom());
  }

  public void afficherListeTriee() {
    System.out.println("Liste triée: ");
    personnes.forEach(p -> System.out.println(p.getNom()));
  }
  
  public void trierParNomPrenom() {
    Collections.sort(personnes, (p1, p2) -> {
      if (p1.getNom().equals(p2.getNom())) {
        return p1.getPrenom().compareTo(p2.getPrenom());
      } else {
        return p1.getNom().compareTo(p2.getNom());
      }
    });
  }

  public void afficherListeTrieeParNomPrenom() {
    System.out.println("Liste triée par nom et prénom: ");
    personnes.forEach(p -> System.out.println(p.getNom() + " " + p.getPrenom()));
  }

  public static void filterEmployerPlus3ans(){
    
  }




}