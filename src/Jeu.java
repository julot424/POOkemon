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

        Affichage.afficherTailleDeck(ia);
        Affichage.afficherTailleDeck(user);
    }

    public static void jeuAIFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            ia.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        }

        for(int i = 0; i < 21; i++)
        {
            user.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        }
    }

    public static void jeuUserFirst()
    {
        for(int i = 0; i < 20; i++)
        {
            user.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        }

        for(int i = 0; i < 21; i++)
        {
            ia.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        }
    }
}