package Plateau;

import Entites.Pokemon;

import javax.swing.*;
import java.util.ArrayList;

public class Defausse
{
    private ArrayList<Pokemon> m_defausse;

    public Defausse()
    {
        this.m_defausse = new ArrayList<>();
    }

    public void addToDefausse(Pokemon pokemon)
    {
        this.m_defausse.add(pokemon);
    }
}
