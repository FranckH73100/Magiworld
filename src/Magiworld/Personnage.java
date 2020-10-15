package Magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Personnage implements Attaque, CriDeGuerre {//variables
    public int numeroJoueur;
    public int niveau;
    public int vie;
    public int force;
    public int agilite;
    public int intelligence;
    public int vieDebut;//vie au debut de la partie du joueur


    public Personnage() {//constructeur par défaut
        numeroJoueur = 0;
        niveau = 0;
        vie = 0;
        force = -1;
        agilite = -1;
        intelligence = -1;
        vieDebut = 0;
    }

    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVieDebut() {
        return vieDebut;
    }//déclaration des points de vie du début en constante


    public void setNumeroJoueur(int pnumeroJoueur) {
        numeroJoueur = pnumeroJoueur;
    }

    public void setNiveau(int pniveau) {
        niveau = pniveau;
    }

    public void setVie(int pvie) {
        vie = pvie;
    }

    public void setForce(int pforce) {
        force = pforce;
    }

    public void setAgilite(int pagilite) {
        agilite = pagilite;
    }

    public void setIntelligence(int pintelligence) {
        intelligence = pintelligence;
    }

    public void setVieDebut(final int pvieDebut) {
        vieDebut = pvieDebut;
    }

    public String toString() {
        return "Veuillez saisir un nombre entier entre 0 et 100 !";
    }

    public static Personnage creerPerso(int numeroJoueur) {//création du personnage et de ses caractéristiques
        Personnage result;
        Scanner sc = new Scanner(System.in);//pour la récupération des données saisies par l'utilisateur
        boolean ok = false;
        int classe = 0;
        do {//pour lancer la boucle du choix de classe
            System.out.println("Création du personnage du joueur " + numeroJoueur + "\nVeuillez saisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            try {
                classe = sc.nextInt();
            } catch (InputMismatchException e) {
                classe = 0;
                sc.nextLine();
            }
            if (classe != 1 && classe != 2 && classe != 3) {//vérification de la bonne saisie du type de classe
                System.out.println("Veuillez saisir 1, 2 ou 3.");
            }
        } while (classe != 1 && classe != 2 && classe != 3);//fin boucle choix de classe
        switch (classe) {
            case 1:
                result = new Guerrier();
                break;
            case 2:
                result = new Rodeur();
                break;
            case 3:
                result = new Mage();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + classe);
        }
        result.setNumeroJoueur(numeroJoueur);
        //do {
        do {//boucle du niveau
            System.out.println("Niveau du personnage ? (entre 1 et 100)");
            try {
                result.setNiveau(sc.nextInt());
                ok = true;
            } catch (InputMismatchException e) {
                System.out.println(result.toString());
                ok = false;
                sc.nextLine();
            }
        } while (result.getNiveau() < 1 || result.getNiveau() > 100);//fin boucle choix du niveau

        //} while (!ok);
        do {//boucle de verification que la répartition des points de force + d'agilité + intelligence = niveau
            //do {
            do {
                System.out.println("Force du personnage ?(entre 0 et 100)");//boucle du niveau
                try {
                    result.setForce(sc.nextInt());
                    ok = true;
                } catch (InputMismatchException e) {
                    System.out.println(result.toString());
                    ok = false;
                    sc.nextLine();
                }
            } while (result.getForce() < 0 || result.getForce() > 100);//fin boucle choix du niveau
            //} while (!ok);
            do {
                do {
                    System.out.println("Agilité du personnage ?(entre 0 et 100)");//boucle du niveau
                    try {
                        result.setAgilite(sc.nextInt());
                        ok = true;
                    } catch (InputMismatchException e) {
                        System.out.println(result.toString());
                        ok = false;
                        sc.nextLine();
                    }
                } while (result.getAgilite() < 0 || result.getAgilite() > 100);//fin boucle choix du niveau
            } while (!ok);
            do {
                do {
                    System.out.println("Intelligence du personnage ?(entre 0 et 100)");//boucle du niveau
                    try {
                        result.setIntelligence(sc.nextInt());
                        ok = true;
                    } catch (InputMismatchException e) {
                        System.out.println(result.toString());
                        ok = false;
                        sc.nextLine();
                    }
                } while (result.getIntelligence() < 0 || result.getIntelligence() > 100);//fin boucle choix du niveau
            } while (!ok);
            if ((result.getForce() + result.getAgilite() + result.getIntelligence()) != result.getNiveau()) {//vérification de la répartition des points
                System.out.println("La somme de la force, de l'agilité et de l'intelligence doit être égale au niveau.");
            }
        } while ((result.getForce() + result.getAgilite() + result.getIntelligence()) != result.getNiveau());// fin boucle vérification de la répartition des points
        result.setVie(result.getNiveau() * 5);//calcul de la vitalité du personnage
        result.setVieDebut(result.getVie());//mise en place de la vitalité initiale du personnage, utilisée par le mage dans le cadre de l'attaque spéciale "soin"
        System.out.println(result.criDeGuerre() + " Joueur " + result.getNumeroJoueur() + " niveau " + result.getNiveau() + " je possède " + result.getVie() + " de vitalité, " + result.getForce() + " de force, " + result.getAgilite() + " d'agilité et " + result.getIntelligence() + " d'intelligence !");
        return result;
    }

    public void attaque(Personnage defenseur) {//ajout de Personnage defenseur
        Scanner sc = new Scanner(System.in);
        int typeAttaque = 0;//basique ou spéciale
        do {//lance choix de l'attaque
            System.out.println("\nJoueur " + getNumeroJoueur() + " (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
            try {
                typeAttaque = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("veuillez saisir 1 ou 2");
                sc.nextLine();
            }
        } while (typeAttaque != 1 && typeAttaque != 2);//fin boucle choix de l'attaque
        if (typeAttaque == 1) {
            this.attaqueBasique(defenseur);
        } else {
            this.attaqueSpeciale(defenseur);
        }
    }
}


