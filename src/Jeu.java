import Entites.Bot;
import Entites.Joueur;
import Utilitaires.Utils;
import java.util.Scanner;


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

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

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
            user.setupMain();
        }
        user.setupTerrain();

        startGame(ia, user);
    }

    public static void jeuUserFirst()
    {

        for(int i = 0; i < 20; i++)
        {
            user.addPokemonToPioche();
            user.setupMain();
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
            int i = 1;
            //j1 = joue en 1er et j2 joue en 2ᵉ
            while((!j1.getTerrain().isEmpty() || !j1.getMain().isEmpty() || !j1.getPioche().isEmpty()) && (!j2.getTerrain().isEmpty() || !j2.getMain().isEmpty() || !j2.getPioche().isEmpty()))
            {
                System.out.println("------------------------------------------------------------------------TOUR " + i + "------------------------------------------------------------------------");
                j1.taillePioche();
                j1.tailleDefausse();
                j1.tailleMain();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                j2.taillePioche();
                j2.tailleDefausse();
                j2.tailleMain();

                j1.jouerPouvoir(j2);
                j2.jouerPouvoir(j1);

                j1.narration();
                j1.remplirMain();//On pioche une ou des cartes si la main n'est pas complète
                j1.selectNewPokemon(); //On remplie le terrain si un pokemon est mort
                j1.attaquer(j2);//phase d'attaque

                j2.narration();
                j2.remplirMain();
                j2.selectNewPokemon();
                j2.attaquer(j1);

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                i++;
            }
            j1.finJeu(j2);
            j2.finJeu(j1);
            System.out.println("FIN DU JEU");
    }


}