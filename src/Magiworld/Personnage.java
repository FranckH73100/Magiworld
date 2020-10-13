package Magiworld;

import java.util.Scanner;

public abstract class Personnage implements AttaqueBasique, AttaqueSpeciale, CreerPerso{//variables
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
        force = 0;
        agilite = 0;
        intelligence = 0;
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
        return "Veuillez saisir un nombre entre 0 et 100 !";
    }



    protected abstract String criDeGuerre();


    public void attaque(Personnage defenseur) {//ajout de Personnage defenseur
        Scanner sc = new Scanner(System.in);
        int typeAttaque;//basique ou spéciale

        do {//lance choix de l'attaque
            System.out.println("\nJoueur " + getNumeroJoueur() + " (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
            typeAttaque = sc.nextInt();
            if (typeAttaque != 1 && typeAttaque != 2)//vérification de la saisie du type d'attaque
                System.out.println("Veuillez saisir 1 ou 2");

        } while (typeAttaque != 1 && typeAttaque != 2);//fin boucle choix de l'attaque

        if (typeAttaque == 1) {
            this.attaqueBasique(defenseur);
        } else {
            this.attaqueSpeciale(defenseur);
        }
    }
}


