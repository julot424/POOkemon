import java.util.ArrayList;

/**
 * Classe représentant un joueur dans le jeu.
 */
public class Joueur {
    //Attributs
    private String m_nom;
    private ArrayList<Pokemon> m_deck;
    public Joueur() {
        m_deck = new ArrayList<>(); // Initialisation du deck
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
    public void ajouterPokemon(Pokemon pokemon) {
        m_deck.add(pokemon);
    }
}
