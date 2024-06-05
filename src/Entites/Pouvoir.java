package Entites;

public interface Pouvoir
{
    public void AppliquerPouvoir(Pokemon attaquant,Pokemon cible);
    public void afficheDescription();
    public String getNom();
}
