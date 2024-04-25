public class AffichagePokemon {
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
