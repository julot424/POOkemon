package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

import java.io.Serializable;

public class Berserk implements Pouvoir
{
    private final String m_nom;
    private boolean m_utilise;

    public Berserk()
    {
        this.m_nom = "Berserk";
        this.m_utilise = false;
    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
        if(!this.m_utilise)
        {
            cible.setATK(cible.getAtk());
            this.m_utilise = true;
        }

        else
        {
            System.out.println("Le pouvoir de ce Pokémon a deja été utilisé !");
        }
    }

    @Override
    public void afficheDescription() {
        System.out.println("Pour le tour en cours, le Pokémon choisi double son attaque");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }

    @Override
    public boolean estKamikaze() {
        return false;
    }

    public String getM_nom() {
        return this.m_nom;
    }
}
