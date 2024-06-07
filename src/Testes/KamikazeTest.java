package Testes;

import Entites.*;
import Entites.Capacite.Kamikaze;

public class KamikazeTest {
    static Joueur j1 = new Joueur();
    static Bot j2 = new Bot();

        public static void main(String[] args)
    {
        j1.addToTerrain(new Pokemon("pokj1", 150, 20, Type.AIR,new Kamikaze()));
        j2.addToTerrain(new Pokemon("pokj2", 150, 20, Type.AIR,null));

        j1.jouerPouvoir(j2);
    }
}
