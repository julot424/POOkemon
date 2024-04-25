import java.util.ArrayList;

public class Affichage {
    /**
     * Affiche le deck d'un joueur.
     * @param joueur Le joueur dont le deck doit être affiché.
     */
    public static void afficherDeckJoueur(Joueur joueur) {
        System.out.println("Deck du joueur:");
        ArrayList<Pokemon> deckJoueur = joueur.getDeck();
        for (int i = 0; i < deckJoueur.size(); i++) {
            afficherDetailsPokemon(deckJoueur.get(i));
        }
    }

    /**
     * Affiche les détails d'un Pokémon.
     * @param pokemon Le Pokémon dont les détails doivent être affichés.
     */
    public static void afficherDetailsPokemon(Pokemon pokemon) {
        System.out.println("Pokémon: " + pokemon.m_nom);
        System.out.println("Point de vie: " + pokemon.m_PV);
        System.out.println("Attaque: " + pokemon.m_atk);
        System.out.println("Type: " + pokemon.m_type);
        System.out.println("-------------------------------");
    }


}