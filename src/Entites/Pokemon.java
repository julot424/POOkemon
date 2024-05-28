package Entites;

public class Pokemon
{
    private final String m_nom;
    private int m_PV;
    private final int m_atk;
    private final Type m_type;

    public Pokemon(String nom, int PV, int atk, Type type)
    {
        this.m_nom = nom;
        this.m_atk = atk;
        this.m_PV = PV;
        this.m_type = type;
    }

    public boolean attaquer(Pokemon cible)
    {
        if((this.getType() == Type.EAU && cible.getType() == Type.FEU) || (this.getType() == Type.AIR && cible.getType() == Type.TERRE) || (this.getType() == Type.TERRE && cible.getType() == Type.EAU) || (this.getType() == Type.FEU && cible.getType() == Type.AIR))
        {
            cible.m_PV -= this.getAtk() + 10;
            System.out.println(this.getNom() + " est en avantage de type, il inflige à " + cible.getNom() + " " + (this.m_atk + 10) + " dégâts");

            return cible.m_PV <= 0;
        }

        else if((this.getType() == Type.FEU && cible.getType() == Type.EAU) || (this.getType() == Type.TERRE && cible.getType() == Type.AIR) || (this.getType() == Type.EAU && cible.getType() == Type.TERRE) || (this.getType() == Type.AIR && cible.getType() == Type.FEU))
        {
            cible.m_PV -= this.getAtk() -10;
            System.out.println(this.getNom() + " est en désavantage de type, il inflige à " + cible.getNom() + " " + (this.m_atk - 10) + " dégâts");

            return cible.m_PV <= 0;
        }

        cible.m_PV -= this.getAtk();
        System.out.println(this.getNom() + " attaque " + cible.getNom() + " et lui inflige " + this.m_atk + " dégâts");

        return cible.m_PV <= 0;
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
