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
    protected int vieDebut;//vie au debut de la partie du joueur



    public Personnage() {//constructeur par défaut
        numeroJoueur = 0;
        classe = 0;
        niveau = 0;
        vie = 0;
        force = 0;
        agilite = 0;
        intelligence = 0;
        vieDebut = 0;

    }

    public Personnage(int pnumeroJoueur) {//constructeur avec paramètres
        numeroJoueur = pnumeroJoueur;
        classe = 0;
        niveau = 0;
        vie = 0;
        force = 0;
        agilite = 0;
        intelligence = 0;
        vieDebut= 0;
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
    public final int getVieDebut(){return vieDebut;}//déclaration des points de vie du début en constante

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
    public void setVieDebut(final int pvieDebut){ vieDebut = pvieDebut;}

    String criDeGuerre(int getClasse) {//pour affichage du cri de guerre du personnage
        if (getClasse() == 1) return "Woarg je suis le Guerrier";
        if (getClasse() == 2) return "Ahaha je suis le Rôdeur";
        if (getClasse() == 3) return "Abracadra je suis le mage";
        return null;
    }

    public void creerPerso() {//création du personnage et de ses caractéristiques
        Scanner sc = new Scanner(System.in);//pour la récupération des données saisies par l'utilisateur

        do {//pour lancer la boucle du choix de classe
            System.out.println("Création du personnage du joueur "+ getNumeroJoueur() + "\nVeuillez saisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            setClasse(sc.nextInt());
            if (getClasse() != 1 && getClasse() != 2 && getClasse() != 3) {//vérification de la bonne saisie du type de classe
                System.out.println("Veuillez saisir 1, 2 ou 3.");
            }
        } while (getClasse() != 1 && getClasse() != 2 && getClasse() != 3);//fin boucle choix de classe

        do {//boucle du niveau
            System.out.println("Niveau du personnage ?");
            setNiveau(sc.nextInt());
            if (getNiveau() < 0 || getNiveau() > 100) {//vérification de la bonne saisie du niveau
                System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
            }
        } while (getNiveau() < 0 || getNiveau() > 100);//fin boucle choix du niveau
        do {//boucle de verification que la répartition des points de force + d'agilité + intelligence = niveau
            do {//boucle force
                System.out.println("Force du personnage ?");
                setForce(sc.nextInt());
                if (getForce() < 0 || getForce() > 100) {//vérification de la bonne saisie de la force
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getForce() < 0 || getForce() > 100);//fin boucle force
            do {//boucle agilité
                System.out.println("Agilité du personnage ?");
                setAgilite(sc.nextInt());
                if (getAgilite() < 0 || getAgilite() > 100) {//vérification de la bonne saisie agilité
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getAgilite() < 0 || getAgilite() > 100); //fin boucle agilité
            do {//boucle intelligence
                System.out.println("Intelligence du personnage ?");
                setIntelligence(sc.nextInt());
                if (getIntelligence() < 0 || getIntelligence() > 100) {//vérification de la bonne saisie intelligence
                    System.out.println("Veuillez saisir un nombre entre 0 et 100 !");
                }
            } while (getIntelligence() < 0 || getIntelligence() > 100);//fin boucle intelligence

            if ((getForce() + getAgilite() + getIntelligence()) != getNiveau()) {//vérification de la répartition des points
                System.out.println("La somme de la force, de l'agilité et de l'intelligence doit être égale au niveau.");
            }
        } while ((getForce() + getAgilite() + getIntelligence()) != getNiveau());// fin boucle vérification de la répartition des points
        setVie(getNiveau() * 5);//calcul de la vitalité du personnage
        setVieDebut(getVie());//mise en place de la vitalité initiale du personnage, utilisée par le mage dans le cadre de l'attaque spéciale "soin"
        System.out.println(criDeGuerre(getClasse()) + " Joueur "+ getNumeroJoueur()+" niveau " + getNiveau() + " je possède " + getVie() + " de vitalité, " + getForce() + " de force, " + getAgilite() + " d'agilité et " + getIntelligence() + " d'intelligence !");

    }
    String nomAttaque(int getClasse, int typeAttaque) {
        if (getClasse() == 1 && typeAttaque == 1) return "Coup d'Epée";
        if (getClasse() == 1 && typeAttaque == 2) return "Coup de rage";
        if (getClasse() == 2 && typeAttaque == 1) return "Tir à l'arc";
        if (getClasse() == 2 && typeAttaque == 2) return "Concentration";
        if (getClasse() == 3 && typeAttaque == 1) return "Boule de feu";
        if (getClasse() == 3 && typeAttaque == 2) return "Soin";
        return null;
    }

    public void attaque(Personnage defenseur) {//ajout de Personnage defenseur pour

        Scanner sc = new Scanner(System.in);
        int typeAttaque;//basique ou spéciale
        int degats = 0;//causés par attaque basique
        int degatsCoupDeRage;//causés par attaque spéciale guerrier
        int autodegats;//perte de points de vie de l'attaquant lors de l'attaque spéciale guerrier
        int concentration;//augmentation de l'agilité du rodeur lors de son attaque spéciale, soit niveau du personnage x 2
        int soin;//points de vie récupérés par le mage lors de son attaque spéciale, soit son intelligence x 2. La vie retrouvée ne peut être supérieure à la vie au début du jeu

        do {//lance choix de l'attaque
            System.out.println("\nJoueur " + getNumeroJoueur() + " (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
             typeAttaque = sc.nextInt();
            if (typeAttaque != 1 && typeAttaque != 2)//vérification de la saisie du type d'attaque
                System.out.println("Veuillez saisir 1 ou 2");

        }while (typeAttaque != 1 && typeAttaque !=2);//fin boucle choix de l'attaque

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
                System.out.println("Joueur " + getNumeroJoueur() + " utilise " + nomAttaque(getClasse(),typeAttaque)+ " et inflige " + degats + " dommages");
                defenseur.setVie(defenseur.getVie() - degats);
                System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degats + " points de vie");
            }
            else {
                if (getClasse() == 1) {
                    degatsCoupDeRage = getForce() * 2;
                    autodegats = getForce() / 2;
                    System.out.println("Joueur " + getNumeroJoueur() + " utilise " + nomAttaque(getClasse(),typeAttaque) + " et inflige " + degatsCoupDeRage + " dommages");
                    System.out.println("Joueur " + getNumeroJoueur() + " perd " + autodegats + " points de vie");
                    setVie(vie -= autodegats);
                    System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degatsCoupDeRage + " points de vie");
                    defenseur.setVie(defenseur.getVie() - degatsCoupDeRage);
                }
                if (getClasse() == 2) {
                    concentration = getNiveau() / 2;
                    System.out.println("Joueur " + getNumeroJoueur() + " utilise " + nomAttaque(getClasse(),typeAttaque) + " et gagne " + concentration + " en agilité");
                    setAgilite(agilite += concentration);
                }
                if (getClasse() == 3) {
                    soin = getIntelligence() * 2;
                    if((soin + getVie()) > getVieDebut()){
                        soin = getVieDebut()-getVie();
                        setVie(getVieDebut());
                        }
                    else setVie(vie += soin);
                    System.out.println("Joueur " + getNumeroJoueur() + " utilise " + nomAttaque(getClasse(),typeAttaque) + " et gagne " + soin + " points de vie");
                    }
            }
            }

    }


