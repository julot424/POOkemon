public class Pokemon
{
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

  public boolean attaquer(Pokemon cible)
  {
    cible.m_PV -= this.getAtk();
    return true;
  }

  public String getNom()
  {
    return this.m_nom;
  }
  public int getAtk()
  {
    return this.m_atk;
  }

  public int getPV()
  {
    return this.m_PV;
  }

  public Type getType()
  {
    return this.m_type;
  }



}
