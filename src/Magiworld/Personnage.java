package Magiworld;

import java.util.Scanner;

public class Personnage {//variables
    protected int numeroJoueur;
    protected int classe;
    protected int niveau;
    protected int vie;
    protected int force;
    protected int agilite;
    protected int intelligence;

    public Personnage() {//constructeur par défaut
        numeroJoueur = 0;
        classe = 0;
        niveau = 0;
        vie = 0;
        force = 0;
        agilite = 0;
        intelligence = 0;
    }

    public Personnage(int pnumeroJoueur ) {//constructeur avec paramètres
        numeroJoueur = pnumeroJoueur;
        classe = 0;
        niveau = 0;
        vie = 0;
        force = 0;
        agilite = 0;
        intelligence = 0;
    }

    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public int getClasse(){ return classe;}
    public int getNiveau (){return niveau;}
    public int getVie(){return vie;}
    public int getForce(){return force;}
    public int getAgilite(){return agilite;}
    public int getIntelligence(){return intelligence;}

    public void setNumeroJoueur(int pnumeroJoueur) {
        numeroJoueur = pnumeroJoueur;
    }

    public void setClasse(int pclasse){
        classe = pclasse;
    }
    public void setNiveau(int pniveau) {
        niveau = pniveau;
    }
    public void setVie(int pvie){
        vie = pvie;
    }
    public void setForce(int pforce){
        force = pforce;
    }
    public void setAgilite(int pagilite){
        agilite = pagilite;
    }
    public void setIntelligence(int pintelligence){
        intelligence = pintelligence;
    }

    public void creerPerso() {
        Scanner sc = new Scanner(System.in);
        String presentation[]  = {"Woarg je suis le Guerrier","Ahaha je suis le Rôdeur","Abracadra je suis le mage"};
        do {
            //pour lancer la boucle du choix de classe
            System.out.println("Création du personnage du joueur "+ getNumeroJoueur() + "\nVeuillez saisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            setClasse(sc.nextInt());
            if (getClasse() != 1 && getClasse() != 2 && getClasse() != 3) {
                System.out.println("Veuillez saisir 1, 2 ou 3.");
            }
        } while (getClasse() != 1 && getClasse() != 2 && getClasse() != 3);
        //boucle des caractéristiques
        do {
            System.out.println("Niveau du personnage ?");
            setNiveau(sc.nextInt());
            if (getNiveau() < 0 || getNiveau() > 100) {
                System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
            }
        } while (getNiveau() < 0 || getNiveau() > 100);
        do {//verification que la sommme de force d'agilité et d'intelligence = niveau
            do {
                System.out.println("Force du personnage ?");
                setForce(sc.nextInt());
                if (getForce() < 0 || getForce() > 100) {
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getForce() < 0 || getForce() > 100);
            do {
                System.out.println("Agilité du personnage ?");
                setAgilite(sc.nextInt());
                if (getAgilite() < 0 || getAgilite() > 100) {
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getAgilite() < 0 || getAgilite() > 100);
            do {
                System.out.println("Intelligence du personnage ?");
                setIntelligence(sc.nextInt());
                if (getIntelligence() < 0 || getIntelligence() > 100) {
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getIntelligence() < 0 || getIntelligence() > 100);

            if ((getForce() + getAgilite() + getIntelligence()) != getNiveau()) {
                System.out.println("La somme de la force, de l'agilité et de l'intelligence doit être égale au niveau.");
            }
        } while ((getForce() + getAgilite() + getIntelligence()) != getNiveau());
        setVie(getNiveau() * 5);
        System.out.println(presentation[getClasse() - 1] + " Joueur "+ getNumeroJoueur()+" niveau " + getNiveau() + " je possède " + getVie() + " de vitalité, " + getForce() + " de force, " + getAgilite() + " d'agilité et " + getIntelligence() + " d'intelligence !");

    }
    public void attaque(Personnage defenseur) {
        String nomAttaque[][] = {{"Coup d'Epée", "Coup de rage"}, {"Tir à l'arc", "Concentration"}, {"Boule de Feu", "Soin"}};
        Scanner sc = new Scanner(System.in);
        int degats = 0;
        int degatsCoupDeRage = 0;
        int concentration = 0;
        int soin = 0;
        System.out.println("Joueur " + getNumeroJoueur() + " (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale");
        int typeAttaque = sc.nextInt();
        if (typeAttaque == 1) {
            if (getClasse() == 1) {
                degats = getForce();
            }
            if (getClasse() == 2) {
                degats = getAgilite();
            }
            if (getClasse() == 3) {
                degats = getIntelligence();
            }
        }
        else if(typeAttaque == 2){
            if (getClasse() == 1) {
                degats = getForce() * 2;
                degatsCoupDeRage = getForce() / 2;
            }
            if (getClasse() == 2) {
                concentration = getNiveau() / 2;
            }
            if (getClasse() == 3) {
                soin = getIntelligence() * 2;
            }
        }
        setVie(vie -= degatsCoupDeRage);
        setAgilite(agilite += concentration);
        setVie(vie += soin);
        defenseur.setVie(defenseur.getVie() - degats);
        System.out.println("Joueur " + getNumeroJoueur() + " utilise " + nomAttaque[getClasse() - 1][typeAttaque - 1] + " et inflige " + degats + " dommages");
        System.out.println("Joueur "+ defenseur.getNumeroJoueur()+" perd "+ degats+ " points de vie");
    }}
