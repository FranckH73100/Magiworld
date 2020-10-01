package Magiworld;

class Mage extends Personnage {


    public Mage() {
        super();

    }

    @Override
    public void attaqueBasique(Personnage defenseur) {
        int degats = getIntelligence();
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Boule de Feu et inflige " + degats + " dommages");
        defenseur.setVie(defenseur.getVie() - degats);
        System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degats + " points de vie");

    }

    @Override
    public String criDeGuerre() {
        return "ABRACADRA, je suis le mage";
    }

    @Override
    public void attaqueSpeciale(Personnage defenseur) {
        int soin = getIntelligence() * 2;
        if ((soin + getVie()) > getVieDebut()) {
            soin = getVieDebut() - getVie();
            setVie(getVieDebut());
        } else setVie(vie += soin);
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Soin et gagne " + soin + " points de vie");
    }
}



