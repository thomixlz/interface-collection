package exo_class;

public class App {
    public static void main(String[] args) {


        // Exercice 1
        CollectionPersonnes collectionPersonnes = new CollectionPersonnes();
        collectionPersonnes.ajouterPersonne(new Employe("John","Bool" , 180, 1));
        collectionPersonnes.ajouterPersonne(new Employe("Jane","Bool", 170, 23));
        collectionPersonnes.ajouterPersonne(new Employe("Joe","Bool", 190, 2));
        collectionPersonnes.ajouterPersonne(new Employe("Jenny","Bool", 175, 6));

        collectionPersonnes.trierParNom();
        collectionPersonnes.afficherListeTriee();

        collectionPersonnes.separerEmployesEtudiants();

        collectionPersonnes.afficherPlusPetiteTaille(); 
        
        // Exercice 2
        collectionPersonnes.trierParNomPrenom();
        collectionPersonnes.afficherListeTrieeParNomPrenom();

    
    }
}
