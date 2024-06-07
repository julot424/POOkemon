package Plateau;

import Entites.Pokemon;
import Utilitaires.Utils;
import java.util.ArrayList;
public class Pioche
{
    private final ArrayList<Pokemon> m_pioche;

    public Pioche()
    {
        this.m_pioche = new ArrayList<>();
    }

    public void initPioche()
    {
        this.m_pioche.add(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType(), Utils.getRandomPouvoir()));
    }

    public ArrayList<Pokemon> getPioche()
    {
        return this.m_pioche;
    }

    public Pokemon piocher()
    {
        if(!this.m_pioche.isEmpty())
        {
            return this.m_pioche.removeFirst();
        }
        return null;
    }
}
