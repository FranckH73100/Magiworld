package Magiworld;
import java.util.Scanner;

class Combat {


    public static void start(Personnage p1, Personnage p2) {
        if(p1.getVie() > 0 && p2.getVie() > 0 )p1.attaque(p2);
        if(p2.getVie() > 0 && p1.getVie() > 0 )p2.attaque(p1);
    }
}



