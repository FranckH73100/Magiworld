package Magiworld;

class Rodeur extends Personnage  {


    public Rodeur() {
        super();
    }

    @Override
    public void attaqueBasique(Personnage defenseur) {
        int degats = getAgilite();
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Tir à l'arc et inflige " + degats + " dommages");
        defenseur.setVie(defenseur.getVie() - degats);
        System.out.println("Joueur " + defenseur.getNumeroJoueur() + " perd " + degats + " points de vie");
    }

    @Override
    public String criDeGuerre() {
        return "AHAHA, je suis le rodeur";
    }

    @Override
    public void attaqueSpeciale(Personnage defenseur) {
        int concentration = getNiveau() / 2;
        System.out.println("Joueur " + getNumeroJoueur() + " utilise Concentration et gagne " + concentration + " en agilité");
        setAgilite(agilite += concentration);
    }
}
