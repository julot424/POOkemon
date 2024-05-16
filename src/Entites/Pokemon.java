package Entites;

public class Pokemon
{
    protected String m_nom;
    protected int m_PV;
    protected int m_atk;
    protected Type m_type;

    public Pokemon(String nom, int PV, int atk, Type type)
    {
        this.m_nom = nom;
        this.m_atk = atk;
        this.m_PV = PV;
        this.m_type = type;
    }

    public boolean attaquer(Pokemon cible)
    {
        if(this.getType() == Type.AIR)
        {
            if(cible.getType() == Type.TERRE)
            {
                cible.m_PV -= this.m_atk + 10;
            }
            else if(cible.getType() == Type.FEU)
            {
                cible.m_PV -= this.m_atk - 10;
            }
            else
            {
                cible.m_PV -= this.m_atk;
            }
        }

        if(this.getType() == Type.TERRE)
        {
            if(cible.getType() == Type.EAU)
            {
                cible.m_PV -= this.m_atk + 10;
            }
            else if(cible.getType() == Type.AIR)
            {
                cible.m_PV -= this.m_atk - 10;
            }
            else
            {
                cible.m_PV -= this.m_atk;
            }
        }

        if(this.getType() == Type.EAU)
        {
            if(cible.getType() == Type.FEU)
            {
                cible.m_PV -= this.m_atk + 10;
            }
            else if(cible.getType() == Type.TERRE)
            {
                cible.m_PV -= this.m_atk - 10;
            }
            else
            {
                cible.m_PV -= this.m_atk;
            }
        }

        if(this.getType() == Type.FEU)
        {
            if(cible.getType() == Type.AIR)
            {
                cible.m_PV -= this.m_atk + 10;
            }
            else if(cible.getType() == Type.EAU)
            {
                cible.m_PV -= this.m_atk - 10;
            }
            else
            {
                cible.m_PV -= this.m_atk;
            }
        }

        if(cible.getPV() <= 0)
        {
            return true;
        }
        return false;
    }

    private boolean estMort()
    {
        if (this.getPV() <= 0)
        {
            return true;
        }
        return false;
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
