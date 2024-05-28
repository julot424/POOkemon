package Entites;

import Plateau.Defausse;
import Plateau.Main;
import Plateau.Pioche;
import Plateau.Terrain;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Classe représentant un joueur dans le jeu.
 */
public class Joueur {
    // Attributs
    private Pioche m_pioche;
    private Main m_main;
    private Defausse m_defausse;
    private Terrain m_terrain;

    /**
     * Constructeur par défaut de la classe Joueur.
     * Initialise la pioche, la main et le terrain du joueur.
     */
    public Joueur()
    {
        this.m_pioche = new Pioche(); // Initialisation de la pioche
        this.m_main = new Main(); // Initialisation de la main
        this.m_defausse = new Defausse(); //Initialisation de la défausse
        this.m_terrain = new Terrain(); //Initialisation du terrain
    }

    Scanner scnr = new Scanner(System.in);


    /**
     * Ajoute un Pokémon à la pioche du joueur.
     *
     */
    public void addPokemonToPioche()
    {
        this.m_pioche.initPioche();
    }

    public void remplirMain()
    {
        if(this.getTailleMain() < 5)
        {
            int i = 0;
            int y = 0;
            for(i = this.getTailleMain(); i < 5; i++ )
            {
                piocher();
                y++;
            }
            System.out.println("Vous piochez " + y + " fois pour remplir votre main !\n");
        }
    }

    public void piocher()
    {
        this.m_main.ajouterPokemon(this.m_pioche.piocher());
    }

    public int getTailleMain()
    {
        return this.m_main.getMain().size();
    }

    public ArrayList<Pokemon> getTerrain()
    {
        return this.m_terrain.getTerrain();
    }


    public void setupTerrain()
    {
        String chx = "";

        for(int i = 0; i < 3; i++)
        {
            chx ="Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain();

            System.out.println(chx);

            addToTerrainFromMain();
        }

        this.remplirMain();
    }

    private boolean estJuste(int nbr)
    {
        if(nbr <= 0  || nbr > this.m_main.getMain().size())
        {
            return false;
        }
        return true;
    }

    public void addToTerrainFromMain()
    {
        int chx = -1;
        chx = scnr.nextInt();

        while (!estJuste(chx))
        {
            System.out.println("Veuillez entrez un chiffre compris entre 1 et " + this.m_main.getMain().size() + " !");
            chx = scnr.nextInt();
        }

        this.m_terrain.addToTerrain(this.m_main.delFromMain(chx - 1));
    }

    public void setupMain()
    {
        if(this.getTailleMain() < 5)
        {
            int i = 0;
            for( i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }}
    }

    public void narration()
    {
        System.out.println("A votre tour de jouer !\n");
    }



    public void attaquer(Joueur cible)
    {
        System.out.println("----------------------------------------------------------------A VOTRE TOUR DE JOUER-----------------------------------------------------------------");

        for(int i = 0; i < this.getTerrain().size(); i++)
        {
            System.out.println("Avec quel Pokémon souhaitez-vous attaquer ?");
            this.m_terrain.afficheTerrain();
            Pokemon attaquant = this.m_terrain.getPokemonFromTerrain(scnr.nextInt()-1);

            System.out.println("\nQuel Pokémon souhaitez-vous attaquer ?");
            cible.afficheTerrain();
            int indexTarget = scnr.nextInt();
            Pokemon target = cible.getTerrain().get(indexTarget-1);

            attaquant.attaquer(target);
            cible.estMort(target);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void estMort(Pokemon cible)
    {
        if(cible.getPV() <= 0)
        {
            this.m_defausse.addToDefausse(cible);
            this.m_terrain.delFromTerrain(cible);
            System.out.println("Votre " + cible.getNom() +  " est mort !\n\n");
        }

        else
        {
            System.out.println("Votre " + cible.getNom() + " a désormais " + cible.getPV() + "PV !\n\n");
        }
    }

    protected int getAvantage(Pokemon attaquant, Joueur cible)
    {
        ArrayList<Boolean> listAvantage = new ArrayList<>();

        for(int i = 0; i < cible.getTerrain().size(); i++)
        {
            if((attaquant.getType() == Type.EAU && cible.getTerrain().get(i).getType() == Type.FEU) || (attaquant.getType() == Type.AIR && cible.getTerrain().get(i).getType() == Type.TERRE) || (attaquant.getType() == Type.TERRE && cible.getTerrain().get(i).getType() == Type.EAU) || (attaquant.getType() == Type.FEU && cible.getTerrain().get(i).getType() == Type.AIR))
            {
                listAvantage.add(true);
            }

            else
            {
                listAvantage.add(false);
            }
        }

        for(int i = 0; listAvantage.size() > i; i++ )
        {
            if(listAvantage.get(i))
            {
                return i;
            }
        }
        return 0;

    }

    public ArrayList<Pokemon> getPioche()
    {
        return this.m_pioche.getPioche();
    }

    public ArrayList<Pokemon> getMain()
    {
        return this.m_main.getMain();
    }

    public void afficheTerrain()
    {
        this.m_terrain.afficheTerrain();
    }

    public void selectNewPokemon()
    {
        if(this.getTerrain().size() < 3)
        {
            for(int i = this.m_terrain.getTerrain().size(); i < 3; i++)
            {
                System.out.println("Choisissez un pokemon de votre main pour remplir votre terrain !\n");
                System.out.println(this.m_main.afficheMain());
                addToTerrainFromMain();
            }


        }
    }


}

