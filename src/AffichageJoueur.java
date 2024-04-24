import java.util.ArrayList;

public class AffichageJoueur {
    /**
     * Affiche le deck d'un joueur.
     * @param joueur Le joueur dont le deck doit être affiché.
     */
    public static void afficherDeckJoueur(Joueur joueur) {
        System.out.println("Deck du joueur:");
        ArrayList<Pokemon> deckJoueur = joueur.getDeck();
        for (int i = 0; i < deckJoueur.size(); i++) {
            AffichagePokemon.afficherDetailsPokemon(deckJoueur.get(i));
        }
    }
}
