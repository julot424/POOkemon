package Testes;

import Entites.Bot;
import Entites.Capacite.Ether;
import Entites.Capacite.Plomb;
import Entites.Joueur;
import Entites.Pokemon;
import Entites.Type;

public class PlombTest
{
    static Joueur j1 = new Joueur();
    static Bot j2 = new Bot();

    public static void main(String[] args)
    {
        j1.addToTerrain(new Pokemon("pokj1", 150, 20, Type.AIR,new Plomb()));
        j2.addToTerrain(new Pokemon("pokj2", 150, 20, Type.AIR,null));

        j1.attaquer(j2);
        j2.attaquer(j1);

        j1.jouerPouvoir(j2);

        j1.attaquer(j2);
        j2.attaquer(j1);
    }
}
