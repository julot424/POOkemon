package Entites;

import java.util.ArrayList;

/**
 * Classe représentant un joueur dans le jeu.
 */
public class Joueur {
    // Attributs

    private String m_nom;
    private ArrayList<Pokemon> m_deck;

    /**
     * Constructeur par défaut de la classe Joueur.
     * Initialise le deck du joueur.
     */
    public Joueur() {
        this.m_deck = new ArrayList<>(); // Initialisation du deck
    }

    /**
     * Obtient le deck du joueur.
     * @return Le deck du joueur.
     */
    public ArrayList<Pokemon> getDeck() {
        return this.m_deck;
    }

    /**
     * Ajoute un Pokémon au deck du joueur.
     * @param pokemon Le Pokémon à ajouter.
     */
    public void ajouterPokemon(Pokemon pokemon)
    {
        this.m_deck.add(pokemon);
    }
}

