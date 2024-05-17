import Entites.Bot;
import Entites.Joueur;
import Entites.User;
import Utilitaires.Utils;
import java.util.Scanner;

public class Jeu {

    static Joueur user = new User();
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
        System.out.println("Taille pioche IA : " + ia.gettaillePioche());
        System.out.println("Taille main IA : " + ia.getTailleMain());


        System.out.println(user.getPioche().get(0).getPV());
        ia.getPioche().get(0).attaquer(user.getPioche().get(0));
        System.out.println(user.getPioche().get(0).getPV());

    }

    public static void jeuAIFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            ia.addPokemonToPioche();
            ia.remplirMain();
        }

        for(int i = 0; i < 21; i++)
        {
            user.addPokemonToPioche();
            user.remplirMain();
        }
    }

    public static void jeuUserFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            user.addPokemonToPioche();
            user.remplirMain();
        }

        for(int i = 0; i < 21; i++)
        {
            ia.addPokemonToPioche();
            ia.remplirMain();
        }
    }

}