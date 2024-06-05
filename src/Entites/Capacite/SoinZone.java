package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

public class SoinZone implements Pouvoir {

    private final String m_nom;

    public SoinZone()
    {
        this.m_nom = "Soin de zone";
    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible) {
        cible.setPV(10);
    }

    @Override
    public void afficheDescription() {
        System.out.println("Chaque Pokémon de  votre terrain regagne 10 PV");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }
}
