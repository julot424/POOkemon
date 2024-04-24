import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Utils {

    //ArrayList couleurs = new ArrayList<(Arrays.asList(Rouge, Bleu, Vert));
    private static ArrayList m_listePokemon = new ArrayList(Arrays.asList(
            "Bulbizarre", "Herbizarre", "Florizarre",
            "Salamèche", "Reptincel", "Dracaufeu",
            "Carapuce", "Carabaffe", "Tortank",
            "Chenipan", "Chrysacier", "Papilusion",
            "Aspicot", "Coconfort", "Dardargnan",
            "Roucool", "Roucoups", "Roucarnage",
            "Rattata", "Rattatac", "Piafabec",
            "Rapasdepic", "Abo", "Arbok",
            "Pikachu", "Raichu", "Sabelette",
            "Sablaireau", "Nidoran♀", "Nidorina",
            "Nidoqueen", "Nidoran♂", "Nidorino",
            "Nidoking", "Mélofée", "Mélodelfe",
            "Goupix", "Feunard", "Rondoudou",
            "Grodoudou", "Nosferapti", "Nosferalto",
            "Mystherbe", "Ortide", "Rafflesia",
            "Paras", "Parasect", "Mimitoss",
            "Aéromite", "Taupiqueur", "Triopikeur",
            "Miaouss", "Persian", "Psykokwak",
            "Akwakwak", "Férosinge", "Colossinge",
            "Caninos", "Arcanin", "Ptitard",
            "Têtarte", "Tartard", "Abra",
            "Kadabra", "Alakazam", "Machoc",
            "Machopeur", "Mackogneur", "Chétiflor",
            "Boustiflor", "Empiflor", "Tentacool",
            "Tentacruel", "Racaillou", "Gravalanch",
            "Grolem", "Ponyta", "Galopa",
            "Ramoloss", "Flagadoss", "Magnéti",
            "Magnéton", "Canarticho", "Doduo",
            "Dodrio", "Otaria", "Lamantine",
            "Tadmorv", "Grotadmorv", "Kokiyas",
            "Crustabri", "Fantominus", "Spectrum",
            "Ectoplasma", "Onix", "Soporifik",
            "Hypnomade", "Krabby", "Krabboss",
            "Voltorbe", "Électrode", "Noeunoeuf",
            "Noadkoko", "Osselait", "Ossatueur",
            "Kicklee", "Tygnon", "Excelangue",
            "Smogo", "Smogogo", "Rhinocorne",
            "Rhinoféros", "Leveinard", "Saquedeneu",
            "Kangourex", "Hypotrempe", "Hypocéan",
            "Poissirène", "Poissoroy", "Stari",
            "Staross", "M. Mime", "Insécateur",
            "Lippoutou", "Élektek", "Magmar",
            "Scarabrute", "Tauros", "Magicarpe",
            "Léviator", "Lokhlass", "Métamorph",
            "Évoli", "Aquali", "Voltali",
            "Pyroli", "Porygon", "Amonita",
            "Amonistar", "Kabuto", "Kabutops",
            "Ptéra", "Ronflex", "Artikodin",
            "Électhor", "Sulfura", "Minidraco",
            "Draco", "Dracolosse", "Mewtwo",
            "Mew"));

    private static final Random random = new Random();

    /**
     *
     * @return Un nombre aléatoire compris entre 100 et 200, multiple de 10.
     */
    public static int getRandomPV()
    {
        return (random.nextInt(11) + 10) * 10;
    }

    /**
     *
     * @return Un nombre aléatoire compris entre 10 et 40, et multiple de 10.
     */
    public static int getRandomATK()
    {
        return (random.nextInt(4) + 1) * 10;
    }


    /**
     *
     * @return Un Type generer aléatoirement depuis la class Type.java
     */
    public static Type getRandomType()
    {
        Type[] types = Type.values();
        int index = random.nextInt(types.length);
        return types[index];
    }

    /**
     *
     * @return Un string et le supprime, le String et generer aléatoirement.
     */
    public static String getRandomNom()
    {
        int i = random.nextInt(m_listePokemon.size());
        return m_listePokemon.remove(i).toString();
    }

    /**
     * Sert au debuggage
     * @return La taille du tableau des noms des pokemon.
     */
    public static int taille()
    {
        return m_listePokemon.size();
    }
}
