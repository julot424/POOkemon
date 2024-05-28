package Plateau;

import Entites.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Terrain
{
    private ArrayList<Pokemon> m_terrain;

    public Terrain()
    {
        this.m_terrain = new ArrayList<>();
    }

    /*public String afficheTerrain()
    {
        String resultat = "";

        for(int i = 0; i < this.m_terrain.size(); i++)
        {
            resultat += this.m_terrain.get(i).getNom() + ", PV " + this.m_terrain.get(i).getPV() + " ,";
        }

        return resultat.substring(0, resultat.length() - 2);
    }*/


    public  void afficheTerrain()
    {
        for(int i = 0; i < this.m_terrain.size(); i+=3)
        {
            printRow(this.m_terrain, i);
        }
    }

    public void printRow(ArrayList<Pokemon> pokemons, int startIndex)
    {
        int endIndex = Math.min(startIndex + 3, pokemons.size());
        List<Pokemon> rowPokemons = new ArrayList<>(pokemons.subList(startIndex, endIndex));

        // Top border
        for (Pokemon p : rowPokemons) {
            System.out.print("+----------------------+   ");
        }
        System.out.println();

        // Name
        for (Pokemon p : rowPokemons) {
            System.out.printf("| %-20s |   ", p.getNom());
        }
        System.out.println();

        // Attack
        for (Pokemon p : rowPokemons) {
            System.out.printf("| Attaque: %-11d |   ", p.getAtk());
        }
        System.out.println();

        // HP
        for (Pokemon p : rowPokemons) {
            System.out.printf("| Vie: %-15d |   ", p.getPV());
        }
        System.out.println();

        // Affinite
        for (Pokemon p : rowPokemons) {
            System.out.printf("| Affinite: %-10s |   ", p.getType());
        }
        System.out.println();

        // Bottom border
        for (Pokemon p : rowPokemons) {
            System.out.print("+----------------------+   ");
        }
        System.out.println();
    }


    public ArrayList<Pokemon> getTerrain()
    {
        return this.m_terrain;
    }

    public int getTailleTerrain()
    {
        return this.m_terrain.size();
    }

    public void delFromTerrain(Pokemon cible)
    {
        for(int i = 0; i < this.m_terrain.size(); i++)
        {
            if(this.m_terrain.get(i) == cible)
            {
                this.m_terrain.remove(i);
            }
        }
    }

    public void addToTerrain(Pokemon pokemon)
    {
        this.m_terrain.add(pokemon);
    }

    public Pokemon getPokemonFromTerrain(int i)
    {
        return this.m_terrain.get(i);
    }
}
