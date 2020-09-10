package Magiworld;

import java.util.Scanner;

public class Magiworld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personnage p1 = new Personnage(1);
        Personnage p2 = new Personnage(2);

        p1.creerPerso();
        p2.creerPerso();

        Combat.start(p1,p2);


    }

 }



