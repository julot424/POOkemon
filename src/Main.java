import java.net.PortUnreachableException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du jeu ...");
        System.out.println("-------------------------------");

        Joueur joueur = new Joueur();

        // Ajout de trois Pokémon au deck du joueur
        /* for (int i = 0; i < 3; i++) {
            joueur.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        } */

        Pokemon leo = new Pokemon("leo", 200, 40, Type.AIR);
        Pokemon julot = new Pokemon("julot", 200, 10, Type.AIR);
        // Affichage du deck du joueur
        AffichagePokemon.afficherDetailsPokemon(leo);
        AffichagePokemon.afficherDetailsPokemon(julot);
        leo.attaquer(julot);
        AffichagePokemon.afficherDetailsPokemon(leo);
        AffichagePokemon.afficherDetailsPokemon(julot);



    }
}