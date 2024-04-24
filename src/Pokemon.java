import java.util.ArrayList;

/**
 * La classe Pokemon permet de créer un Pokémon dans le jeu.
 */
public class Pokemon {

  /**
   * La méthode principale du programme.
   */
  public static void main(String[] args) {
    System.out.println("Lancement du jeu ...");
    System.out.println("-------------------------------");

    Joueur joueur = new Joueur();//création d'un nouveau joueur

    // Ajout de trois Pokémon au deck du joueur
    for (int i = 0; i < 3; i++) {
      joueur.ajouterPokemon(new Pokemon(Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType()));
    }

    // Affichage du deck du joueur
    afficherDeckJoueur(joueur);
  }

  /**
   * Afficher le deck d'un joueur.
   * @param joueur Le joueur dont le deck doit être affiché.
   */
  public static void afficherDeckJoueur(Joueur joueur) {
    System.out.println("Deck du joueur:");
    System.out.println("<-------------------------------->");
    ArrayList<Pokemon> deckJoueur = joueur.getDeck();
    for (int i = 0; i < deckJoueur.size(); i++) {
      afficherDetailsPokemon("Pokémon " + (i + 1), deckJoueur.get(i));
    }
  }


  /**
   * Affiche les détails d'un Pokémon.
   * @param titre Le titre du Pokémon.
   * @param pokemon Le Pokémon dont les détails doivent être affichés.
   */
  public static void afficherDetailsPokemon(String titre, Pokemon pokemon) {
    System.out.println(titre);
    System.out.println("Pokémon: " + pokemon.m_nom);
    System.out.println("Point de vie: " + pokemon.m_PV);
    System.out.println("Attaque: " + pokemon.m_atk);
    System.out.println("Type: " + pokemon.m_type);
    System.out.println("-------------------------------");
  }


  // Attributs
  String m_nom;
  int m_PV;
  int m_atk;
  Type m_type;

  /**
   * Créer une instance de Pokemon.
   * @param nom Le nom du Pokémon.
   * @param PV Les points de vie du Pokémon.
   * @param atk L'attaque du Pokémon.
   * @param type Le type du Pokémon.
   */
  public Pokemon(String nom, int PV, int atk, Type type) {
    this.m_nom = nom;
    this.m_atk = atk;
    this.m_PV = PV;
    this.m_type = type;
  }
}
