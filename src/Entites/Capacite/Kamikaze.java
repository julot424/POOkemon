package Entites.Capacite;
import Entites.Pokemon;
import Entites.Pouvoir;

public class Kamikaze implements Pouvoir {

    private final String m_nom;
    private boolean m_utilise;

    public Kamikaze()
    {
        this.m_nom = "Kamikaze";
        this.m_utilise = false;
    }

    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible) {

    }

    @Override
    public void afficheDescription() {
        System.out.println("Choisissez un Pokémon allié et un ennemi, les deux Pokémon seront alors éliminé");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }
}
