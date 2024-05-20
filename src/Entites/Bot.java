package Entites;

import Plateau.Defausse;
import Plateau.Main;
import Plateau.Pioche;
import Plateau.Terrain;

public class Bot extends Joueur
{

    private Pioche m_pioche;
    private Main m_main;
    private Defausse m_defausse;
    private Terrain m_terrain;

    /**
     * Constructeur par défaut de la classe Bot.
     * Initialise la pioche, la main et le terrain du joueur.
     */

    public Bot() {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
        this.m_terrain = new Terrain(); //Initialisation du terrain
    }

    public void setupTerrain()
    {
        for(int i = 0; i < 3; i++)
        {
            addToTerrainFromMain();
        }
        this.remplirMain();
    }


    public void addToTerrainFromMain()
    {
        if(!this.m_main.getMain().isEmpty())
        {
            this.m_terrain.getTerrain().add(this.m_main.getMain().removeFirst());
        }
    }


    public void piocher()
    {
        this.m_main.ajouterPokemon(this.m_pioche.piocher());
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


    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public int getTailleMain()
    {
        return this.m_main.getMain().size();
    }

    public int gettaillePioche()
    {
        return this.m_pioche.getPioche().size();
    }
}
