import java.util.ArrayList;

/**
 * Classe représentant un joueur dans le jeu.
 */
public class Joueur {
    //Attributs
    private String m_nom;

    private ArrayList<Pokemon> m_deck;

    /**
     * Obtient le deck du joueur.
     * @return Le deck du joueur.
     */
    public ArrayList<Pokemon> getDeck() {
        return this.m_deck;
    }
}
