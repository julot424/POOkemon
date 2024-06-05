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
    private final Pioche m_pioche;
    private final Main m_main;
    private final Defausse m_defausse;
    private final Terrain m_terrain;

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
            int i;
            int y = 0;
            for(i = this.getTailleMain(); i < 5; i++ )
            {
                piocher();
                y++;
            }
            System.out.println("Vous piochez " + y + " fois pour remplir votre main !");
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
        String chx;

        for(int i = 0; i < 3; i++)
        {
            chx ="Choisissez vos Pokemons de départ parmi : " + "\n\n" +this.m_main.afficheMain();

            System.out.println(chx);

            addToTerrainFromMain();
        }

        this.remplirMain();
    }

    private boolean estJusteMain(int nbr)
    {
        if(nbr <= 0  || nbr > this.m_main.getMain().size())
        {
            return false;
        }
        return true;
    }

    private boolean estJusteTerrain(int nbr)
    {
        if(nbr <= 0  || nbr > this.getTerrain().size())
        {
            return false;
        }
        return true;
    }

    public void addToTerrainFromMain()
    {
        int chx;
        chx = scnr.nextInt();

        while (!estJusteMain(chx))
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
            int i;
            for( i = this.getTailleMain(); i < 5 ; i++ )
            {
                piocher();
            }}
    }

    public void narration()
    {
        System.out.println("----------------------------------------------------------------A VOTRE TOUR DE JOUER-----------------------------------------------------------------");

    }



    public void attaquer(Joueur cible)
    {
        int indexAtk;

        for(int i = 0; i < this.getTerrain().size(); i++)
        {
            System.out.println("Avec quel Pokémon souhaitez-vous attaquer ?");
            this.m_terrain.afficheTerrain();
            indexAtk = scnr.nextInt();
            while(!estJusteTerrain(indexAtk))
            {
                System.out.println("Veuillez entrez un chiffre compris entre 1 et " + this.m_terrain.getTerrain().size() + " !");
                indexAtk = scnr.nextInt();
            }
            Pokemon attaquant = this.m_terrain.getPokemonFromTerrain(indexAtk-1);

            System.out.println("\nQuel Pokémon souhaitez-vous attaquer ?");
            cible.afficheTerrain();
            int indexTarget = scnr.nextInt();
            while (!cible.estJusteTerrain(indexTarget))
            {
                System.out.println("Veuillez entrez un chiffre compris entre 1 et " + cible.getTerrain().size() + " !");
                indexTarget = scnr.nextInt();
            }
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
            if((attaquant.getType() == Type.ETHER) || (cible.getTerrain().get(i).getType() == Type.PLOMB) || (attaquant.getType() == Type.EAU && cible.getTerrain().get(i).getType() == Type.FEU) || (attaquant.getType() == Type.AIR && cible.getTerrain().get(i).getType() == Type.TERRE) || (attaquant.getType() == Type.TERRE && cible.getTerrain().get(i).getType() == Type.EAU) || (attaquant.getType() == Type.FEU && cible.getTerrain().get(i).getType() == Type.AIR))
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
                if(!this.getMain().isEmpty())
                {
                    System.out.println("Choisissez un pokemon de votre main pour remplir votre terrain !\n");
                    System.out.println(this.m_main.afficheMain());
                    addToTerrainFromMain();
                }

                else
                {
                    break;
                }
            }
        }
    }

    public void jouerPouvoir(Joueur cible)
    {
        for(int i = 0; i < this.getTerrain().size(); i++)
        {
            if(this.m_terrain.getTerrain().get(i).getPouvoir() != null)
            {
                System.out.println("Souhaitez-vous utiliser le pouvoir de " + this.m_terrain.getTerrain().get(i).getNom() + " ? (y/n)\n Ou obtenir les informations de son pouvoir ? (h)");
                String rep = scnr.nextLine();
                while(!(rep.equals("y") || rep.equals("n")))
                {
                    if(rep.equals("h"))
                    {
                        this.m_terrain.getTerrain().get(i).getPouvoir().afficheDescription();
                        System.out.println("Entrez 'y' ou 'n' pour utiliser ou non le pouvoir de " + this.m_terrain.getTerrain().get(i).getNom());
                    }

                    else
                    {
                        System.out.println("Entrez 'y', 'n' ou 'h' !");
                        rep = scnr.nextLine();
                    }
                }

                if(rep.equals("y"))
                {
                    System.out.println("Votre terrain");
                    this.afficheTerrain();
                    System.out.println("Choisissez sur lequel de vos Pokémon appliquer le pouvoir \nPour choisir une Pokémon du terrain adverse, entrez '5'");
                    int chxPokemon = scnr.nextInt() -1;


                    while(!estJusteTerrain(chxPokemon) || chxPokemon != 4)
                    {
                        System.out.println("Choisissez un chiffre entre 1 et " + this.getTerrain().size() + "\n ou tapez '5' pour l'utiliser sur le terrain adverse");
                    }

                    if(estJusteTerrain(chxPokemon))
                    {
                        this.m_terrain.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.m_terrain.getTerrain().get(i), cible.getTerrain().get(chxPokemon));
                    }

                    else {
                        System.out.println("terrain adverse");
                        cible.afficheTerrain();

                        System.out.println("Choisissez le Pokémon adverse");
                        chxPokemon = scnr.nextInt();
                        while (!cible.estJusteTerrain(chxPokemon))
                        {
                            System.out.println("Choisissez un chiffre entre 1 et " + this.getTerrain().size());
                            chxPokemon = scnr.nextInt();
                        }

                        this.m_terrain.getTerrain().get(i).getPouvoir().AppliquerPouvoir(this.m_terrain.getTerrain().get(i), cible.getTerrain().get(chxPokemon));
                    }

                }


            }
        }


    }


    public void finJeu(Joueur cible)
    {
        if(this.getTerrain().isEmpty() && this.getMain().isEmpty() && this.getPioche().isEmpty())
        {
            int reste = cible.getTerrain().size() + cible.getMain().size() + cible.getPioche().size();
            System.out.println("----------GAME OVER !----------\nIl restait " + reste + " Pokémons dans le jeu adverse !");
        }
    }

    public void taillePioche()
    {
        System.out.println("Cartes restantes dans votre pioche : " + this.getPioche().size());
    }

    public void tailleDefausse()
    {
        System.out.println("Nombres de carte dans votre défausse : " + this.getDefausse().size());
    }

    public ArrayList<Pokemon> getDefausse()
    {
        return this.m_defausse.getDefausse();
    }

    public void tailleMain()
    {
        System.out.println("Nombre de cartes en main : " + this.getMain().size());
    }
}

