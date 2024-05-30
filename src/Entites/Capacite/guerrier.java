package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

public class guerrier implements Pouvoir {

    private final String m_nom;

    public guerrier() {
        this.m_nom = "Férveur Guerrière";
    }

    @Override
    public void AppliquerPouvoir(Pokemon cible) {
        
    }
}
