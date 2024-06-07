package Entites;

import Entites.Capacite.Ether;
import Entites.Capacite.Plomb;
import Entites.Capacite.SoinTotal;

public class Pokemon
{
    private final String m_nom;
    private int m_PV;
    private int m_atk;
    private Type m_type;
    private int m_PvMax;
    private final Pouvoir m_pouvoir;

    public Pokemon(String nom, int PV, int atk, Type type, Pouvoir pouvoir)
    {
        this.m_nom = nom;
        this.m_atk = atk;
        this.m_PvMax = PV;
        this.m_PV = PV;
        this.m_type = type;
        this.m_pouvoir = pouvoir;
    }

    public boolean attaquer(Pokemon cible)
    {
        if((this.getType() == Type.ETHER) || (cible.getType() == Type.PLOMB) || (this.getType() == Type.EAU && cible.getType() == Type.FEU) || (this.getType() == Type.AIR && cible.getType() == Type.TERRE) || (this.getType() == Type.TERRE && cible.getType() == Type.EAU) || (this.getType() == Type.FEU && cible.getType() == Type.AIR))
        {
            cible.m_PV -= this.getAtk() + 10;
            System.out.println(this.getNom() + " est en avantage de type, il inflige à " + cible.getNom() + " " + (this.m_atk + 10) + " dégâts");

            return cible.m_PV <= 0;
        }

        else if((this.getType()==Type.PLOMB) || (cible.getType() == Type.ETHER) || (this.getType() == Type.FEU && cible.getType() == Type.EAU) || (this.getType() == Type.TERRE && cible.getType() == Type.AIR) || (this.getType() == Type.EAU && cible.getType() == Type.TERRE) || (this.getType() == Type.AIR && cible.getType() == Type.FEU))
        {
            cible.m_PV -= this.getAtk() -10;
            System.out.println(this.getNom() + " est en désavantage de type, il inflige à " + cible.getNom() + " " + (this.m_atk - 10) + " dégâts");

            return cible.m_PV <= 0;
        }

        cible.m_PV -= this.getAtk();
        System.out.println(this.getNom() + " attaque " + cible.getNom() + " et lui inflige " + this.m_atk + " dégâts");

        return cible.m_PV <= 0;
    }

    public void exploser()
    {
        this.m_PV -= 999;
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

    public void setType(Type type)
    {
        this.m_type = type;
    }

    public int getPvMax() { return this.m_PvMax; }

    public void setPV(int soin) { this.m_PV = soin; }

    public void setATK(int i)
    {
        this.m_atk += i;
    }

    public Pouvoir getPouvoir()
    {
        return this.m_pouvoir;
    }
}
