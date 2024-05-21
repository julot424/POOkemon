package Entites;

import Plateau.Defausse;
import Plateau.Main;
import Plateau.Pioche;
import Plateau.Terrain;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Classe représentant un joueur dans le jeu.
 */
public class Joueur {
    // Attributs
    private Pioche m_pioche;
    private Main m_main;
    private Defausse m_defausse;
    private Terrain m_terrain;

    /**
     * Constructeur par défaut de la classe Joueur.
     * Initialise la pioche, la main et le terrain du joueur.
     */
    public Joueur()
    {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
        this.m_terrain = new Terrain(); //Initialisation du terrain
    }

    Scanner scnr = new Scanner(System.in);


    /**
     * Ajoute un Pokémon à la pioche du joueur.
     *
     */
    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public void remplirMain()
    {
        if(this.getTailleMain() < 5)
        {
            int i = 0;
            for( i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }
            System.out.println("Vous piochez " + i + " fois pour remplir votre main !\n");
        }
    }

    public void piocher()
    {
        this.m_main.ajouterPokemon(this.m_pioche.piocher());
    }

    public int getTailleMain()
    {
        return this.m_main.getMain().size();
    }

    /*public ArrayList<Pokemon> getMain()
    {
        return this.m_main.getMain();
    }*/

    public ArrayList<Pokemon> getTerrain()
    {
        return this.m_terrain.getTerrain();
    }


    public void setupTerrain()
    {
        String chx = "";

        for(int i = 0; i < 3; i++ )
        {
            chx ="Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain();

            if(i == 0)
            {
                System.out.println(chx);
            }

            else if(i == 1)
            {
                System.out.println(chx);
            }

            else
            {
                System.out.println(chx);
            }

            addToTerrainFromMain();
        }

        System.out.println("Votre terrain est composer de : " + this.m_terrain.afficheTerrain() + "\n");
        this.remplirMain();
    }

    private boolean estJuste(int nbr)
    {
        if(nbr <= 0  || nbr > this.m_main.getMain().size())
        {
            return false;
        }
        return true;
    }

    public void addToTerrainFromMain()
    {
        int chx = -1;
        chx = scnr.nextInt();

        while (!estJuste(chx))
        {
            System.out.println("Veuillez entrez un chiffre compris entre 1 et " + this.m_main.getMain().size() + " !");
            chx = scnr.nextInt();
        }

        this.m_terrain.getTerrain().add(this.m_main.getMain().remove(chx - 1));
    }

    public void setupMain()
    {
        if(this.getTailleMain() < 5)
        {
            int i = 0;
            for( i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }}
    }

    public void naration()
    {
        System.out.println("A votre tour de jouer !\n");
    }



    public void attaquer(Joueur cible)
    {

    }

    protected int getAvantage(Pokemon attaquant, Joueur cible)
    {
        ArrayList<Boolean> listAvantage = new ArrayList<>();

        for(int i = 0; i < cible.getTerrain().size(); i++)
        {
            if((attaquant.getType() == Type.EAU && cible.getTerrain().get(i).getType() == Type.FEU) || (attaquant.getType() == Type.AIR && cible.getTerrain().get(i).getType() == Type.TERRE) || (attaquant.getType() == Type.TERRE && cible.getTerrain().get(i).getType() == Type.EAU) || (attaquant.getType() == Type.FEU && cible.getTerrain().get(i).getType() == Type.AIR))
            {
                listAvantage.add(true);
            }

            else
            {
                listAvantage.add(false);
            }
        }

        for(int i = 0; listAvantage.size() > i; i++ )
        {
            if(listAvantage.get(i))
            {
                return i;
            }
        }
        return 0;

    }
}

