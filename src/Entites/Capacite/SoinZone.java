package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

public class SoinZone implements Pouvoir {

    private final String m_nom;

    public SoinZone()
    {
        this.m_nom = "Soin zone";
    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
        if(cible.getPV() + 10 < cible.getPvMax())
        {
            cible.setPV(10);
            System.out.println(cible.getNom() + " regagne 10PV !");
        }

        else {
            System.out.println(cible.getNom() + " a déja ses PV au max !");
        }

    }

    @Override
    public void afficheDescription() {
        System.out.println("Chaque Pokémon de  votre terrain regagne 10 PV");
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
        return true;
    }

    @Override
    public boolean estUtilise() {
        return false;
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
        return false;
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
