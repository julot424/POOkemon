package Entites.Capacite;
import Entites.Pokemon;
import Entites.Pouvoir;

public class Resistance implements Pouvoir
{
    private final String m_nom;
    private boolean m_utilise;

    public Resistance()
    {
        this.m_nom = "Resistance";
        this.m_utilise = false;
    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
        cible.setResistance(true);
        this.m_utilise = true;
    }

    @Override
    public void afficheDescription() {
        System.out.println("Les attaques subies par le Pokémon choisi seront diminuée de 10");
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
        return true;
    }

    @Override
    public boolean estPlomb() {
        return false;
    }
}
