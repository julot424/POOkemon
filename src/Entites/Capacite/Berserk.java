package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;

import java.io.Serializable;

public class Berserk implements Pouvoir
{
    private final String m_nom;
    private boolean m_utilise;
    private boolean m_enCours;

    public Berserk()
    {
        this.m_nom = "Berserk";
        this.m_utilise = false;

    }


    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible)
    {
        cible.setATK(cible.getAtk());
        this.m_utilise = true;
        this.m_enCours = true;
        System.out.println("L'attaque de " + cible.getNom() + " est doublé pour le tour en cours !");
    }

    public void stopBerserk()
    {
        this.m_utilise = false;
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

    @Override
    public boolean estBerserk() {
        return true;
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
        return this.m_enCours;
    }

    public String getM_nom() {
        return this.m_nom;
    }
}
