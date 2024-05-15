package Utilitaires;

import java.util.ArrayList;
import Entites.Pokemon;
import Entites.Joueur;

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
        System.out.println("Pokémon: " + pokemon.getNom());
        System.out.println("Point de vie: " + pokemon.getPV());
        System.out.println("Attaque: " + pokemon.getAtk());
        System.out.println("Type: " + pokemon.getType());
        System.out.println("-------------------------------");
    }

    public static void afficherTailleDeck(Joueur joueur)
    {
        System.out.println(joueur.getDeck().size());
    }


}
