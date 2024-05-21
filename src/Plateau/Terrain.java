package Plateau;

import Entites.Pokemon;

import java.awt.*;
import java.util.ArrayList;

public class Terrain
{
    private ArrayList<Pokemon> m_terrain;

    public Terrain()
    {
        this.m_terrain = new ArrayList<>();
    }

    public String afficheTerrain()
    {
        String resultat = "";

        for(int i = 0; i < m_terrain.size(); i++)
        {
            resultat += m_terrain.get(i).getNom() + ", ";
        }

        return resultat.substring(0, resultat.length() - 2);
    }

    public ArrayList<Pokemon> getTerrain()
    {
        return this.m_terrain;
    }

    public int getTailleTerrain()
    {
        return this.m_terrain.size();
    }
}
