/**
 * La classe Pokemon permet de créer un Pokémon dans le jeu.
 */
public class Pokemon {
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
