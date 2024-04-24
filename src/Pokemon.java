/**
 * La classe Pokemon permet de représenter un Pokémon dans le jeu.
 */
public class Pokemon {

  /**
   * La méthode principale du programme.
   */
  public static void main(String[] args) {
    System.out.println("Lancement du jeu ...");
    System.out.println("-------------------------------");

    // Afficher les détails du premier Pokémon
    afficherDetailsPokemon("PREMIER POKEMON", Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType());

    // Afficher les détails du deuxième Pokémon
    afficherDetailsPokemon("DEUXIEME POKEMON", Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType());

    // Afficher les détails du troisième Pokémon
    afficherDetailsPokemon("TROISIEME POKEMON", Utils.getRandomNom(), Utils.getRandomPV(), Utils.getRandomATK(), Utils.getRandomType());
  }


  /**
   * Afficher les détails d'un Pokémon.
   * @param titre Le titre du Pokémon.
   * @param nom Le nom du Pokémon.
   * @param pv Les points de vie du Pokémon.
   * @param atk L'attaque du Pokémon.
   * @param type Le type du Pokémon.
   */
  public static void afficherDetailsPokemon(String titre, String nom, int pv, int atk, Type type) {
    System.out.println(titre);
    System.out.println("Pokémon: " + nom);
    System.out.println("Point de vie: " + pv);
    System.out.println("Attaque: " + atk);
    System.out.println("Type: " + type);
    System.out.println("-------------------------------");
  }

  // Définition de la classe Pokemon
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
