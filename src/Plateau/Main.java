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

    public String afficheMain()
    {
        String resultat = "";

        for(int i = 0; i<this.m_main.size(); i++)
        {
            resultat += i+1 + ") " + this.m_main.get(i).getNom() + ", Type " + this.m_main.get(i).getType().toString() + ", Vie: " + this.m_main.get(i).getPV() + ", attaque: " + this.m_main.get(i).getAtk() + "\n";
        }
        return resultat;
    }

    public Pokemon delFromMain(int i)
    {
        return this.m_main.remove(i);
    }
}
