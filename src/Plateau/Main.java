package Plateau;

import Entites.Pokemon;

import java.util.ArrayList;

public class Main
{
    private final ArrayList<Pokemon> m_main;

    public Main()
    {
        this.m_main = new ArrayList<>();
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
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<this.m_main.size(); i++)
        {
            result.append(i + 1).append(") ").append(this.m_main.get(i).getNom()).append(", Type ").append(this.m_main.get(i).getType().toString()).append(", Vie: ").append(this.m_main.get(i).getPV()).append(", attaque: ").append(this.m_main.get(i).getAtk()).append("\n");
        }
        return result.toString();
    }

    public Pokemon delFromMain(int i)
    {
        return this.m_main.remove(i);
    }
}
