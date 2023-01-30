package exo_class;

public class App {
    public static void main(String[] args) {


        // Exercice 1
        CollectionPersonnes collectionPersonnes = new CollectionPersonnes();
        collectionPersonnes.ajouterPersonne(new Employe("John", 180));
        collectionPersonnes.ajouterPersonne(new Employe("Jane", 170));
        collectionPersonnes.ajouterPersonne(new Etudiant("Jack", 160));
        collectionPersonnes.ajouterPersonne(new Etudiant("Jill", 150));
        collectionPersonnes.ajouterPersonne(new Employe("Joe", 190));
        collectionPersonnes.ajouterPersonne(new Etudiant("Jenny", 175));

        collectionPersonnes.trierParNom();
        collectionPersonnes.afficherListeTriee();

        collectionPersonnes.separerEmployesEtudiants();

        collectionPersonnes.afficherPlusPetiteTaille();   
    
    }
}
