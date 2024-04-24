public class Pokemon
{
  public static void main(String[] args)
  {
    System.out.println("Lancement du jeu ...");
    System.out.println("-------------------------------");
    System.out.println("Premier Pokémon: ");
    System.out.println("Taille Liste : " +Utils.taille());
    System.out.println("Pokémon: " +Utils.getRandomNom());
    System.out.println("Point de vie: " +Utils.getRandomPV());
    System.out.println("Attaque: " +Utils.getRandomATK());
    System.out.println("Type: " +Utils.getRandomType());
    System.out.println("-------------------------------");
    System.out.println("Deuxième Pokémon");
    System.out.println("Taille Liste : " +Utils.taille());
    System.out.println("Pokémon: " +Utils.getRandomNom());
    System.out.println("Point de vie: " +Utils.getRandomPV());
    System.out.println("Attaque: " +Utils.getRandomATK());
    System.out.println("Type: " +Utils.getRandomType());

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
