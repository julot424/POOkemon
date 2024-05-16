import Utilitaires.Affichage;
import jdk.jshell.execution.Util;
import Entites.Joueur;
import Entites.Pokemon;
import Utilitaires.Utils;

public class Jeu {

    static Joueur user = new Joueur();
    static Joueur ia = new Joueur();


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
        System.out.println("Taille pioche user : " + ia.gettaillePioche());
        System.out.println("Taille main user : " + ia.getTailleMain());



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
            ia.remplirMain();
        }

        for(int i = 0; i < 21; i++)
        {
            ia.addPokemonToPioche();
            user.remplirMain();
        }
    }

}