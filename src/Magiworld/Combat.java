package Magiworld;
import java.util.Scanner;

class Combat{


    public static void start(Personnage p1, Personnage p2) {
       //TODO boucle tant que point vie > 0 sinon joueur a perdu : do while;
        p1.attaque(p2);
        p2.attaque(p1);


    }

    }





