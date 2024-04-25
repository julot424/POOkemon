/**
 * La classe Pokemon représente un Pokémon avec un nom, des points de vie (PV),
 * une attaque (atk) et un type.
 */
public class Pokemon {
  String m_nom;
  int m_PV;
  int m_atk;
  Type m_type;

  /**
   * Constructeur de la classe Pokemon.
   * @param nom Le nom du Pokémon.
   * @param PV Les points de vie du Pokémon.
   * @param atk La valeur de l'attaque du Pokémon.
   * @param type Le type du Pokémon.
   */
  public Pokemon(String nom, int PV, int atk, Type type) {
    this.m_nom = nom;
    this.m_atk = atk;
    this.m_PV = PV;
    this.m_type = type;
  }

  /**
   * Méthode pour que le Pokémon attaque un autre Pokémon.
   * @param cible Le Pokémon cible de l'attaque.
   * @return Retourne true si l'attaque réussit.
   */
  public boolean attaquer(Pokemon cible) {
    cible.m_PV -= this.getAtk();
    return true;
  }

  /**
   * Méthode pour obtenir le nom du Pokémon.
   * @return Le nom du Pokémon.
   */
  public String getNom() {
    return this.m_nom;
  }

  /**
   * Méthode pour obtenir la valeur de l'attaque du Pokémon.
   * @return La valeur de l'attaque du Pokémon.
   */
  public int getAtk() {
    return this.m_atk;
  }

  /**
   * Méthode pour obtenir les points de vie du Pokémon.
   * @return Les points de vie du Pokémon.
   */
  public int getPV() {
    return this.m_PV;
  }

  /**
   * Méthode pour obtenir le type du Pokémon.
   * @return Le type du Pokémon.
   */
  public Type getType() {
    return this.m_type;
  }
}
