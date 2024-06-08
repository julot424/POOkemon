package Entites;

import Plateau.Defausse;
import Plateau.Main;
import Plateau.Pioche;
import Plateau.Terrain;

import java.util.ArrayList;

public class Bot extends Joueur
{

    private final Pioche m_pioche;
    private final Main m_main;
    private final Defausse m_defausse;
    private final Terrain m_terrain;

    /**
     * Constructeur par défaut de la classe Bot.
     * Initialise la pioche, la main et le terrain du joueur.
     */

    public Bot() {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
        this.m_terrain = new Terrain(); //Initialisation du terrain
    }

    public void setupTerrain()
    {
        for(int i = 0; i < 3; i++)
        {
            addToTerrainFromMain();
        }
        this.remplirMain();
    }


    public void addToTerrainFromMain()
    {
        if(!this.m_main.getMain().isEmpty())
        {
            this.m_terrain.addToTerrain(this.m_main.delFromMain(0));
        }
    }


    public void piocher()
    {
        this.m_main.ajouterPokemon(this.m_pioche.piocher());
    }


    public void remplirMain()
    {
        if(this.getTailleMain() < 5)
        {
            for(int i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }
        }
    }


    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public int getTailleMain()
    {
        return this.m_main.getMain().size();
    }

    public void narration()
    {
        System.out.println("---------------------------------------------------------------AU TOUR DE L'ADVERSAIRE----------------------------------------------------------------");

    }

    public void attaquer(Joueur cible)
    {
        Pokemon target;

        for(int i = 0; i < this.m_terrain.getTailleTerrain(); i++)
        {
            target = cible.getTerrain().get(cible.getAvantage(this.m_terrain.getTerrain().get(i), cible));
            this.m_terrain.getTerrain().get(i).attaquer(target);

            cible.estMort(target);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void afficheTerrain()
    {
        this.m_terrain.afficheTerrain();
    }

    public ArrayList<Pokemon> getTerrain()
    {
        return this.m_terrain.getTerrain();
    }

    public void estMort(Pokemon cible)
    {
        if(cible.getPV() <= 0)
        {
            this.m_defausse.addToDefausse(cible);
            this.m_terrain.delFromTerrain(cible);
            System.out.println(cible.getNom() +  " est mort !\n");
        }

        else
        {
            System.out.println(cible.getNom() + " a désormais " + cible.getPV() + "PV !\n");
        }
    }

    public void selectNewPokemon()
    {
        if(this.getTerrain().size() < 3)
        {
            for(int i = this.m_terrain.getTerrain().size(); i < 3; i++)
            {
                addToTerrainFromMain();
            }


        }
    }

    public void finJeu(Joueur cible)
    {
        if(this.getMain().isEmpty() && this.getTerrain().isEmpty() && this.getPioche().isEmpty())
        {
            int reste = cible.getTerrain().size() + cible.getMain().size() + cible.getPioche().size();
            System.out.println("----------VOUS AVEZ GAGNER !----------\nIl restait " + reste + " Pokémons dans votre jeu !");
        }
    }

    public void taillePioche()
    {
        System.out.println("Cartes restantes dans la pioche de l'adversaire : " + this.getPioche().size());
    }

    public void tailleDefausse()
    {
        System.out.println("Nombre de pokémon dans la défausse de l'adversaire: " + this.getDefausse().size());
    }

    public ArrayList<Pokemon> getDefausse()
    {
        return this.m_defausse.getDefausse();
    }

    public ArrayList<Pokemon> getPioche()
    {
        return this.m_pioche.getPioche();
    }

    public void tailleMain()
    {
        System.out.println("Nombre de carte dans la main de l'adversaire : " + this.getMain().size());
    }

    public ArrayList<Pokemon> getMain()
    {
        return this.m_main.getMain();
    }

    public void jouerPouvoir(Joueur cible)
    {
        Pouvoir pouvoir;

        for(int i = 0; i < this.getTerrain().size(); i++)
        {
            pouvoir = this.getTerrain().get(i).getPouvoir();


            if(pouvoir != null)
            {
                if(pouvoir.estBerserk() || pouvoir.estEther() || pouvoir.estGuerrier())
                {
                    Pokemon strongest = this.getTerrain().get(i);
                    for(int y = 0; y < this.getTerrain().size(); y++)
                    {
                        if(strongest.getAtk() < this.getTerrain().get(y).getAtk())
                        {
                            strongest = this.getTerrain().get(y);
                        }
                    }
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), strongest);
                }

                else if(pouvoir.estKamikaze())
                {
                    Pokemon tankiest = cible.getTerrain().get(i);
                    for(int y = 0; y < cible.getTerrain().size(); y++)
                    {
                        if(tankiest.getPV() < cible.getTerrain().get(y).getPV())
                        {
                            tankiest = cible.getTerrain().get(y);
                        }
                    }
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), tankiest);
                    this.estMort(this.m_terrain.getTerrain().get(i));
                    cible.estMort(tankiest);
                }

                else if(pouvoir.estResistance())
                {
                    Pokemon tankiest = this.getTerrain().get(i);
                    for(int y = 0; y < this.getTerrain().size(); y++)
                    {
                        if(tankiest.getPV() < this.getTerrain().get(y).getPV())
                        {
                            tankiest = this.getTerrain().get(y);
                        }
                    }
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), tankiest);
                }

                else if(pouvoir.estPlomb())
                {
                    Pokemon strongest = cible.getTerrain().get(i);
                    for(int y = 0; y < cible.getTerrain().size(); y++)
                    {
                        if(strongest.getAtk() < cible.getTerrain().get(y).getAtk())
                        {
                            strongest = cible.getTerrain().get(y);
                        }
                    }
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), strongest);
                }

                else if (pouvoir.estSoinZone())
                {
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), this.getTerrain().get(i));
                }

                else
                {
                    Pokemon weakest = cible.getTerrain().get(i);
                    for(int y = 0; y < cible.getTerrain().size(); y++)
                    {
                        if(weakest.getPV() > cible.getTerrain().get(y).getAtk())
                        {
                            weakest = cible.getTerrain().get(y);
                        }
                    }
                    this.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.getTerrain().get(i), weakest);
                }
            }
        }
    }

    public void addToTerrain(Pokemon p)
    {
        this.m_terrain.addToTerrain(p);
    }

    public void stopBerserk()
    {
        for(int i = 0; i < this.getTerrain().size(); i++)
        {
            if(this.getTerrain().get(i).getPouvoir() != null)
            {
                if(this.getTerrain().get(i).getPouvoir().estBerserk())
                {
                    this.getTerrain().get(i).setATK(-(this.getTerrain().get(i).getAtk()/2));
                    System.out.println("L'effet Berserk du " + this.getTerrain().get(i).getNom() + " adverse s'est consumé !");
                }

            }
        }
    }
}
