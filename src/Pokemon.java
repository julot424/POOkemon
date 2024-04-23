public class Pokemon
{
  public static void main(String[] args)
  {
    System.out.println("Lancement du jeu ...");
    System.out.println(Utils.taille());
    System.out.println(Utils.getRandomNom());
    System.out.println(Utils.getRandomPV());
    System.out.println(Utils.getRandomATK());
    System.out.println(Utils.getRandomType());
    System.out.println("-------------------------------");
    System.out.println(Utils.taille());
    System.out.println(Utils.getRandomNom());
    System.out.println(Utils.getRandomPV());
    System.out.println(Utils.getRandomATK());
    System.out.println(Utils.getRandomType());


  }

  String m_nom;
  int m_PV;
  int m_atk;
  Type m_type;

  public Pokemon(String nom, int PV, int atk, Type type)
  {
    this.m_nom = nom;
    this.m_atk = atk;
    this.m_PV = PV;
    this.m_type = type;
  }



}
