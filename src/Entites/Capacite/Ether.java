package Entites.Capacite;

import Entites.Pokemon;
import Entites.Pouvoir;
import Entites.Type;

public class Ether implements Pouvoir {

    private final String m_nom;
    private boolean m_utilise;


    public Ether()
    {
        this.m_nom = "Ether";
        this.m_utilise = false;
    }

    @Override
    public void AppliquerPouvoir(Pokemon attaquant, Pokemon cible) {
        if(!this.m_utilise)
        {
            cible.setType(Type.ETHER);
            System.out.println(cible.getNom() + " est désormais de type " + cible.getType());
            this.m_utilise = true;
        }

        else
        {
            System.out.println("Le pouvoir de ce Pokémon a deja été utilisé !");
        }
    }

    @Override
    public void afficheDescription() {
        System.out.println("Change le type du Pokémon choisi, lui donnant l'avantage sur tout les autres types");
    }

    @Override
    public String getNom() {
        return this.m_nom;
    }

    public String getM_nom() {
        return this.m_nom;
    }
}
