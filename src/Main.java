public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du jeu ...");
        System.out.println("-------------------------------");

        Joueur joueur = new Joueur();

        // Ajout de trois Pokémon au deck du joueur
        for (int i = 0; i < 3; i++) {
            joueur.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
        }

        // Affichage du deck du joueur
        Affichages.afficherDeckJoueur(joueur);
    }
}