package Utilitaires;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Entites.Capacite.*;
import Entites.Pouvoir;
import Entites.Type;
public class Utils {


    public static final ArrayList<String> listePokemon = new ArrayList<>(Arrays.asList(
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

    public static ArrayList<Pouvoir> listPouvoirs = new ArrayList<>(Arrays.asList(new Berserk(), new Ether(), new guerrier(), new Kamikaze(), new Plomb(), new SoinTotal(), new SoinZone(), new Resistance()));

    private static final Random random = new Random();

    public static Pouvoir getRandomPouvoir()
    {
        Pouvoir pouvoir = null;

        if (random.nextInt(41) < 8)
        {
            if(!listPouvoirs.isEmpty())
            {
                return listPouvoirs.remove(random.nextInt(listPouvoirs.size()));
            }
        }

        return pouvoir;
    }

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
        int index = random.nextInt(types.length-2);
        return types[index];
    }

    /**
     *
     * @return Un string et le supprime, le String et generer aléatoirement.
     */
    public static String getRandomNom()
    {
        int i = random.nextInt(listePokemon.size());
        return listePokemon.remove(i);
    }

    /**
     * Sert a determiner quel joueur jouera en premier
     * @return Un int entre 0 et 1
     */
    public static int getRandomFirstPlayer()
    {
        return random.nextInt(2);
    }

}
