package Entites;

import Plateau.Defausse;
import Plateau.Main;
import Plateau.Pioche;

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

    /**
     * Constructeur par défaut de la classe Joueur.
     * Initialise la pioche, la main et le terrain du joueur.
     */
    public Joueur() {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
    }


    /**
     * Ajoute un Pokémon a la pioche du joueur.
     * @param
     */
    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public void remplirMain()
    {
        if(this.getTailleMain() != 5)
        {
            for(int i = 0; i < 5 - this.getTailleMain(); i++ )
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

    public void tour()
    {

    }

}

