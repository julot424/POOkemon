public class Pokemon
{
  public static void main(String[] args)
  {
    System.out.println("Lancement du jeu ...");
    System.out.println(Utils.getRandomPV());
    System.out.println(Utils.getRandomATK());
  }

  String m_nom;
  int m_PV;
  int m_atk;

  public Pokemon(String nom, int PV, int atk /*ELement*/)
  {
    this.m_nom = nom;
    this.m_atk = atk;
    this.m_PV = PV;
  }



}
