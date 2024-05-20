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

    private String m_nom;
    private Pioche m_pioche;
    private Main m_main;
    private Defausse m_defausse;
    private Terrain m_terrain;

    /**
     * Constructeur par défaut de la classe Joueur.
     * Initialise la pioche, la main et le terrain du joueur.
     */
    public Joueur() {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
        this.m_terrain = new Terrain(); //Initialisation du terrain
    }

    Scanner scnr = new Scanner(System.in);


    /**
     * Ajoute un Pokémon à la pioche du joueur.
     * @param
     */
    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public void remplirMain()
    {
        if(this.getTailleMain() < 5)
        {
            for(int i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }
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

    public int gettaillePioche()
    {
        return this.m_pioche.getPioche().size();
    }

    public ArrayList<Pokemon> getPioche()
    {
        return this.m_pioche.getPioche();
    }
    public ArrayList<Pokemon> getMain()
    {
        return this.m_main.getMain();
    }

    public void setupTerrain()
    {
        for(int i = 0; i < 3; i++ )
        {
            if(i == 0)
            {
                System.out.println("Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain());
                System.out.println("Votre 1er choix :");
            }

            else if(i == 1)
            {
                System.out.println("Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain());
                System.out.println("Votre 2nd choix :");
            }

            else if (i == 2)
            {
                System.out.println("Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain());
                System.out.println("Votre 3ème choix :");
            }

            addToTerrainFromMain();
        }

        System.out.println("Votre terrain est composer de : " + this.m_terrain.afficheTerrain());
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
}

