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
        attaquant.exploser();
        cible.exploser();
    }

    @Override
    public void afficheDescription() {
        System.out.println("Le Pokémon possédant le pouvoir et le Pokémon ennemi choisi seront élimés ");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }

    @Override
    public boolean estKamikaze() {
        return true;
    }
}
