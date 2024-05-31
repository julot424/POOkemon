package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

import java.io.Serializable;

public class Berserk implements Pouvoir
{
    private final String m_nom;

    public Berserk()
    {
        this.m_nom = "Berserk";
    }

    @Override
    public void AppliquerPouvoir(Pokemon cible) {

    }

    public String getM_nom() {
        return this.m_nom;
    }
}
