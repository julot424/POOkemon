import Entites.Bot;
import Entites.Joueur;
import Utilitaires.Utils;

import java.util.Scanner;

import static java.lang.Thread.*;


public class Jeu {



    static Joueur user = new Joueur();
    static Bot ia = new Bot();


    public static void main(String[] args) {

        System.out.println("Lancement du jeu ...");
        System.out.println("-------------------------------");
        System.out.println("PPPPPPPP     OOOOOOOO    KKK   KKK  EEEEEEEE   MMMM     MMMM   OOOOOOOO    NNNN     NNNN");
        System.out.println("PPPP  PPPP  OOOO  OOOO   KKK  KKK   EEEE       MMMMMM MMMMMM  OOOO  OOOO   NNNNNN   NNNN");
        System.out.println("PPPPPPPPP   OOOO  OOOO   KKKKKK     EEEEEEEE   MMMM MMM MMMM  OOOO  OOOO   NNNN NNN NNNN");
        System.out.println("PPPP        OOOO  OOOO   KKK  KKK   EEEE       MMMM     MMMM  OOOO  OOOO   NNNN   NNNNNN");
        System.out.println("PPPP         OOOOOOOO    KKK   KKK  EEEEEEEE   MMMM     MMMM   OOOOOOOO    NNNN    NNNNN\n");

        try {
            // Boucle pour ajouter des points avec un intervalle de 1 seconde
            for (int i = 0; i <= 3; i++) {
                // Afficher le texte avec les points ajoutés
                System.out.print("\r" + "CHARGEMENT");
                for (int j = 0; j < i; j++) {
                    System.out.print(".");
                }
                // Pause de 1 seconde
                Thread.sleep(1000);
            }

            // Afficher un message pour indiquer que le chargement est terminé
            System.out.println("\nChargement terminé !\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(Utils.getRandomFirstPlayer() == 0)
        {
            System.out.println("Etes vous prêt à jouer ? (y/n)\n");
            while(!estPret())
            {
                System.out.println("Entrez 'y' dès que vous le serez !\n");
            }

            System.out.println("Votre adversaire joue en 1er\n");
            jeuAIFirst();

        }
        else
        {
            System.out.println("Etes vous prêt à jouer ? (y/n) \n");
            while(!estPret())
            {
                System.out.println("Entrez 'y' dès que vous le serez ! \n");
            }


            System.out.println("Vous jouez en 1er\n");
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            jeuUserFirst();
        }


    }

    private static boolean estPret()
    {
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals("y"))
        {
            return true;
        }
        return false;
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


        startGame(user, ia);
    }




    public static void startGame(Joueur j1, Joueur j2)
    {
        //j1 = joue en 1er et j2 joue en 2ᵉ

    }

}