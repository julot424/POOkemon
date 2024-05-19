import Entites.Bot;
import Entites.Joueur;
import Utilitaires.Utils;
import java.util.Scanner;

public class Jeu {

    static Joueur user = new Joueur();
    static Joueur ia = new Bot();


    public static void main(String[] args) {
        System.out.println("Lancement du jeu ...");
        System.out.println("-------------------------------");


        if(Utils.getRandomFirstPlayer() == 0)
        {
            System.out.println("AI FIRST");
            jeuAIFirst();

        }
        else
        {
            System.out.println("USER FIRST");
            jeuUserFirst();
        }

        System.out.println("Taille pioche user : " + user.gettaillePioche());
        System.out.println("Taille main user : " + user.getTailleMain());

    }

    public static void jeuAIFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            ia.addPokemonToPioche();
            ia.remplirMain();
        }
        ia.setupTerrain();


        for(int i = 0; i < 21; i++)
        {
            user.addPokemonToPioche();
            user.remplirMain();
        }
        user.setupTerrain();

        startGame(ia, user);
    }

    public static void jeuUserFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            user.addPokemonToPioche();
            user.remplirMain();
        }
        user.setupTerrain();

        for(int i = 0; i < 21; i++)
        {
            ia.addPokemonToPioche();
            ia.remplirMain();
        }
        ia.setupTerrain();
    }

    public static void startGame(Joueur j1, Joueur j2)
    {
        //j1 = joue en 1er et j2 joue en 2ᵉ

    }

}