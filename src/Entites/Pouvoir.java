package Entites;

public interface Pouvoir
{
    public void AppliquerPouvoir(Pokemon attaquant,Pokemon cible);
    public void afficheDescription();
    String getNom();
    boolean estKamikaze();
    boolean estBerserk();
    boolean estSoinZone();
    boolean estUtilise();
    boolean enUtilisation();
    void stopBerserk();

    boolean estEther();

    boolean estGuerrier();

    boolean estResistance();

    boolean estPlomb();
}
