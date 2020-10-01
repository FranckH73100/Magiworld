package Magiworld;

class Guerrier extends Personnage {



    public Guerrier() {
        super();

    }

    @Override
    public void attaqueBasique(Personnage defenseur) {
        int degats = getForce();
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Coup d'Epée et inflige " + degats + " dommages");
        defenseur.setVie(defenseur.getVie() - degats);
        System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degats + " points de vie");

    }

    @Override
    public String criDeGuerre() {
        return "Woarg, je suis le guerrier";
    }

    @Override
    public void attaqueSpeciale(Personnage defenseur) {
        int degatsCoupDeRage = getForce() * 2;
        int autodegats = getForce() / 2;
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Coup de Rage et inflige " + degatsCoupDeRage + " dommages");
        System.out.println("Joueur " + getNumeroJoueur() + " perd " + autodegats + " points de vie");
        setVie(vie -= autodegats);
        System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degatsCoupDeRage + " points de vie");
        defenseur.setVie(defenseur.getVie() - degatsCoupDeRage);
    }

}

