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

        System.out.println(p1.vie+" "+ p1.force+" "+p1.agilite+" "+p1.intelligence);
        System.out.println(p2.vie+" "+ p2.force+" "+p2.agilite+" "+p2.intelligence);
    }

 }



