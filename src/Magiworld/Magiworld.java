package Magiworld;


public class Magiworld {

    public static void main(String[] args) {

        Personnage p1 = Personnage.creerPerso(1);
        Personnage p2 = Personnage.creerPerso(2);

        do {
            Combat.start(p1, p2);//
        }
        while (p1.getVie() > 0 && p2.getVie() > 0);
        if (p1.getVie() <= 0 && p2.getVie() <= 0) System.out.println("Joueur 1 et 2 sont morts" + "\nMatch nul !");

        else if (p1.getVie() <= 0) System.out.println("Joueur 1 est mort" + "\nJoueur 1 a perdu");

        else if (p2.getVie() <= 0) System.out.println("Joueur 2 est mort" + "\nJoueur 2 a perdu");

    }

}




