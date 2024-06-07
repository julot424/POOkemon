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
}
