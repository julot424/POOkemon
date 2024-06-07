package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;
import Entites.Type;

public class Plomb implements Pouvoir {
    private final String m_nom;
    private boolean m_utilise;

    public Plomb()
    {
        this.m_nom = "Affinité plomb";
        this.m_utilise = false;
    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
        if(!this.m_utilise)
        {
            cible.setType(Type.PLOMB);
            System.out.println(cible.getNom() + " est désormais de type " + cible.getType());
            this.m_utilise = true;
        }

        else
        {
            System.out.println("Le pouvoir a deja été utilisé !");
        }

    }

    @Override
    public void afficheDescription() {
        System.out.println("Change le type du Pokémon choisi, lui donnant un désavantage sur tout les autres types");
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
        return true;
    }
}
