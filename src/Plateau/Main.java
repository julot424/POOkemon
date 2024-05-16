package Plateau;

import Entites.Pokemon;

import java.util.ArrayList;

public class Main
{
    private ArrayList<Pokemon> m_main;

    public Main()
    {
        this.m_main = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemonMain()
    {
        return  this.m_main;
    }

    public void ajouterPokemon(Pokemon pokemon)
    {
        if(pokemon != null)
        {
            this.m_main.add(pokemon);
        }
    }

    public ArrayList<Pokemon> getMain()
    {
        return this.m_main;
    }
}
