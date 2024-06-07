package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

public class guerrier implements Pouvoir {

    private final String m_nom;
    private boolean m_utilise;

    public guerrier()
    {
        this.m_nom = "Férveur Guerrière";
        this.m_utilise = false;
    }



    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
         cible.setATK(10);
         System.out.println("L'attaque de " + cible.getNom() + " est désormais de " + cible.getAtk() + " !");
         this.m_utilise = true;

    }

    @Override
    public void afficheDescription() {
        System.out.println("Les attaques du Pokémon choisi infligeront 10 de dégâts supplémentaire");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }

    @Override
    public boolean estKamikaze() {
        return false;
    }

    @Override
    public boolean estBerserk() {
        return false;
    }

    @Override
    public boolean estSoinZone() {
        return false;
    }

    @Override
    public boolean estUtilise() {
        return this.m_utilise;
    }

    @Override
    public boolean enUtilisation() {
        return false;
    }

    @Override
    public void stopBerserk() {

    }

    @Override
    public boolean estEther() {
        return false;
    }

    @Override
    public boolean estGuerrier() {
        return true;
    }

    @Override
    public boolean estResistance() {
        return false;
    }

    @Override
    public boolean estPlomb() {
        return false;
    }
}
