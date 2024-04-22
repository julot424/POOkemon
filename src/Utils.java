import java.util.Random;
public class Utils {
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
}
