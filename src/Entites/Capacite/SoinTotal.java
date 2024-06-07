package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

public class SoinTotal implements Pouvoir {
    private final String m_nom;
    private boolean m_utilise;

    public SoinTotal()
    {
        this.m_nom = "Soin Total";
        this.m_utilise = false;
    }

    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible) {
        cible.setPV(cible.getPvMax());
        this.m_utilise = true;
    }

    @Override
    public void afficheDescription() {
        System.out.println("Soigne entièrement le Pokémon choisi");
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
