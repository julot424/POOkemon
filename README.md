# POOkemon 
## Le jeu

Il s'agit d'un jeu avec un joueur humain face à l'ordinateur, qui se joue **au tour par tour**. Le gagnant est celui qui parvient à **éliminer tous les Pokémons de son adversaire**.

### Composition du jeu

Chaque joueur a à sa disposition :

- un **terrain** pouvant accueillir 3 Pokémons,
- une **main** de 5 Pokémons maximum,
- une **pioche** de 20 ou 21 Pokémons (lire partie Mise en place du jeu),
- une **défausse** contenant les Pokémons éliminés.

### Mise en place du jeu

1. Le premier joueur à jouer est choisi aléatoirement.
1. Le premier joueur possède une **pioche de 20 Pokémons**, le second de **21 Pokémons**.
1. Chaque joueur **pioche 5 Pokémons**.
1. Le premier joueur **place 3 Pokémons** de sa main sur son terrain face visible puis le second joueur fait de même.
1. Le premier joueur commence à jouer.

### Déroulement d'un tour

À son tour, le joueur humain :

1. **Pioche** des Pokémons jusqu'à en avoir 5 en main ou que sa pioche soit vide.
1. **Place** un Pokémon de sa main face visible sur chaque emplacement vide sur son terrain.
1. **Peut attaquer** une fois avec chacun des Pokémons de son terrain, dans l'ordre de son choix.

À son tour, l'ordinateur :

1. **Pioche** des Pokémons jusqu'à en avoir 5 en main ou que sa pioche soit vide.
1. **Place** un Pokémon de sa main face visible sur chaque emplacement vide sur son terrain, **dans l'ordre de sa main**.
1. **Attaque** une fois avec chacun des Pokémons de son terrain **dans l'ordre de ses terrains**.

## Les Pokémons

Chaque Pokémon possède :

- un **nom**
- des **points de vie**
- une **force d'attaque**
- une **affinité avec un élément**.

### Les éléments

Il y a 4 éléments : la terre, l'eau, le feu et l'air. Chaque élément a un avantage sur un autre élément :

- la terre a l'avantage sur l'eau
- l'eau à l'avantage sur le feu
- le feu a l'avantage sur l'air
- l'air a l'avantage sur la terre.

### Attaque des Pokémons

- Lorsqu'un Pokémon attaque un autre Pokémon, il **diminue le nombre de points de vie** de son adversaire de la valeur de sa force d'attaque.
- Si, suite à une attaque, un Pokémon n'a **plus de points de vie**, il est placé dans la **défausse** de l'adversaire.
- Un **avantage d'affinité** augmente une attaque de 10.
- Un **désavantage d'affinité** diminue une attaque de 10.

### Stratégie d'attaque de l'ordinateur

Un Pokémon de l'ordinateur :

- attaque en priorité le Pokémon dont l'affinité lui donne l'avantage
- s'il n'y en a pas (ou s'il y en a plusieurs), il attaque le Pokémon qui possède le moins de points de vie (parmi ceux-ci).
- s'il y en a encore plusieurs, il attaque l'un de ces Pokémon au hasard.

### Génération des Pokémons

À chaque partie, les Pokémons de chaque pioche sont générées selon l'algorithme suivant :

- leur nom est tiré aléatoirement parmi une liste de noms fixe, mais deux Pokémons ne peuvent pas avoir le même nom,
- leur nombre de points de vie est un multiple de 10, compris entre 100 et 200 et déterminé aléatoirement,
- leur valeur d'attaque est un multiple de 10 compris entre 10 et 40 et déterminé aléatoirement,
- leur affinité est choisie aléatoirement.

## L'application

Elle :

- est réalisée en Java,
- propose une interface textuelle,
- permet de visualiser les Pokémons sur les terrains et ceux en main du joueur humain, mais pas celles de l'ordinateur,
- indique clairement quelles sont les actions possibles et les entrées clavier à effectuer pour les réaliser.
- affiche les actions effectuées par l'ordinateur lorsque c'est son tour

### Exemple d'affichage

```console
********************************************************************************
Tour 3:
                                    Joueur 2

********************************************************************************

                                    Joueur 1

pioche: 15 pokemons
defausse: 0 pokemons
  *--------------------*    *--------------------*    *--------------------*
  | Attaque: 20        |    | Attaque: 40        |    | Attaque: 20        |
  | Vie: 50/120        |    | Vie: 50/150        |    | Vie: 50/130        |
  | Affinite : Air     |    | Affinite : Air     |    | Affinite : Feu     |
  |     Herbizarre     |    |     Florizarre     |    |     Salamèche      |
  *--------------------*    *--------------------*    *--------------------*

----------------------------------------------------------------------------------------------------

  *--------------------*    *--------------------*    *--------------------*
  |     Dracaufeu      |    |     Bulbizarre     |    |      Pikachu       |
  | Affinite : Feu     |    | Affinite : Eau     |    | Affinite : Terre   |
  | Vie: 50/180        |    | Vie: 50/150        |    | Vie: 50/100        |
  | Attaque: 40        |    | Attaque: 30        |    | Attaque: 10        |
  *--------------------*    *--------------------*    *--------------------*

pioche: 12 pokemons
defausse: 0 pokemons

En main:
- Reptincel, Feu, Vie: 160, Attaque: 20
- Carapuce, Eau, Vie: 100, Attaque: 40
- Tortank, Eau, Vie: 200, Attaque: 20
- Papilusion, Air, Vie: 120, Attaque: 20
- Roucool, Air, Vie: 150, Attaque: 30

                                    Joueur 2

Quel pokemon souhaitez-vous jouer? (Dracaufeu/Bulbizarre/Pikachu):
```


### Fin du jeu

À la fin du jeu, un écran affiche "Vous avez perdu" ou "Vous avez gagné" et indique le nombre de Pokémons restants au gagnant.

