import Entites.Bot;
import Entites.Joueur;
import Utilitaires.Utils;


public class Jeu {

    static Joueur user = new Joueur();
    static Bot ia = new Bot();


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

        System.out.println("\n\n Taille pioche user : " + user.gettaillePioche());
        System.out.println("Taille main user : " + user.getTailleMain());
        System.out.println("Taille pioche ia : " + ia.gettaillePioche());
        System.out.println("Taille main ia : " + ia.getTailleMain());

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
        ia.afficheTaillePiocheBot();

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

        ia.afficheTaillePiocheBot();

        startGame(user, ia);
    }




    public static void startGame(Joueur j1, Joueur j2)
    {
        //j1 = joue en 1er et j2 joue en 2ᵉ

    }

}