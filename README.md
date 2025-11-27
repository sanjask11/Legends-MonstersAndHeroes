# CS611 - Assignment IV
## Legends : Monsters & Heroes

------------------------------------------------------------ 

- **Name:** Sanjana
- **Email:** sanjask@bu.edu
- **Student ID:** U33564045

------------------------------------------------------------  

# Assignment Overview

## Folder Structure & File Description

### core/
| File                 | Description                                                        |
| -------------------- | ------------------------------------------------------------------ |
| **ConsoleIO.java**   | Utility for printing headings/subheadings and simple text prompts. |
| **Direction.java**   | Enum representing movement directions (W/A/S/D).                   |
| **GameState.java**   | Serializable container storing the World + Party for save/load.    |
| **Menu.java**        | Simple interface used by menu-style components.                    |
| **PauseMenu.java**   | Handles pause/resume/save/quit during gameplay.                    |
| **SaveManager.java** | Serializes and deserializes `GameState` objects to disk.           |


### entities/heroes/
| File                 | Description                                                                                 |
| -------------------- | ------------------------------------------------------------------------------------------- |
| **Hero.java**        | Abstract base class for all hero types with stats, leveling, equipment, and combat methods. |
| **HeroFactory.java** | Builds hero list using the loader.                                                          |
| **HeroLoader.java**  | Loads hero data from the provided files.                                                    |
| **Paladin.java**     | Paladin specialization favored stats: strength & dexterity.                                 |
| **Sorcerer.java**    | Sorcerer specialization favored stats: dexterity & agility.                                 |
| **Warrior.java**     | Warrior specialization favored stats: strength & agility.                                   |


### entities/monsters/
| File                    | Description                                                                   |
| ----------------------- | ----------------------------------------------------------------------------- |
| **Monster.java**        | Abstract monster base class with HP, damage, dodge, and spell reaction logic. |
| **MonsterFactory.java** | Generates enemy parties according to hero levels.                             |
| **MonsterLoader.java**  | Loads monster data from provided files.                                       |
| **Dragon.java**         | Monster subtype: dragon.                                                      |
| **Exoskeleton.java**    | Monster subtype: exoskeleton.                                                 |
| **Spirit.java**         | Monster subtype: spirit.                                                      |
| **CombatEntity.java**   | Shared interface for Hero + Monster (HP, dodge, damage).                      |


### game/battle/
| File                  | Description                                                     |
| --------------------- | --------------------------------------------------------------- |
| **Battle.java**       | Orchestrates the full battle loop using UI + logic.             |
| **BattleLogic.java**  | Computes attacks, spells, dodging, potions, regen, and rewards. |
| **BattleResult.java** | Represents win/loss/continue status.                            |
| **BattleUI.java**     | Handles all battle-related user input and on-screen printing.   |


### game/exploration/
| File                           | Description                                                   |
| ------------------------------ | ------------------------------------------------------------- |
| **ExplorationController.java** | Main controller for world movement, events, markets, battles. |
| **ExplorationLogic.java**      | Contains world-movement logic and random battle checks.       |
| **ExplorationUI.java**         | Displays world map, prompts, and feedback messages.           |


### game/inventory/
| File                         | Description                                                       |
| ---------------------------- | ----------------------------------------------------------------- |
| **InventoryController.java** | Full inventory flow: view items, equip, use potion.               |
| **InventoryLogic.java**      | Pure business logic for filtering & performing inventory actions. |
| **InventoryUI.java**         | All inventory menu prompts and printed output.                    |



### game/services/
| File                   | Description                                      |
| ---------------------- | ------------------------------------------------ |
| **PotionService.java** | Applies potion effects (HP/MP/attribute boosts). |


### game/setup/
| File                     | Description                                         |
| ------------------------ | --------------------------------------------------- |
| **SetupController.java** | Handles selecting heroes and world size.            |
| **SetupLogic.java**      | Validation logic for hero selection and world size. |
| **SetupUI.java**         | Displays hero list and prompts for selection.       |



### game/
| File                     | Description                                                     |
| ------------------------ | --------------------------------------------------------------- |
| **ExplorationMenu.java** | Legacy thin wrapper (now replaced by ExplorationController).    |
| **Game.java**            | Entry point that creates world, party, and launches game flow.  |
| **InventoryMenu.java**   | Legacy wrapper for inventory (replaced by InventoryController). |
| **SetupMenu.java**       | Legacy wrapper for hero/world selection.                        |



### items/
| File               | Description                                              |
| ------------------ | -------------------------------------------------------- |
| **Item.java**      | Parent class for all inventory items.                    |
| **Weapon.java**    | Weapon items with damage and required levels.            |
| **Armor.java**     | Armor items with damage reduction.                       |
| **Potion.java**    | Potion items with multi-stat effects.                    |
| **Spell.java**     | Spell items with damage and spell-type-specific effects. |
| **SpellType.java** | Enum defining FIRE/ICE/LIGHTNING.                        |



### market/
| File                      | Description                                                     |
| ------------------------- | --------------------------------------------------------------- |
| **Market.java**           | Market container storing buyable weapons/armors/potions/spells. |
| **MarketController.java** | Controls the buy/sell flow.                                     |
| **MarketLoader.java**     | Loads all market items from data files.                         |
| **MarketLogic.java**      | Price, validation, and transaction logic.                       |
| **MarketUI.java**         | All printed menus for market actions.                           |


### world/
| File           | Description                                                           |
| -------------- | --------------------------------------------------------------------- |
| **World.java** | Builds the map grid, tracks party position, provides tile navigation. |


### world/party
| File           | Description                                           |
| -------------- | ----------------------------------------------------- |
| **Party.java** | Stores hero list and party position on the world map. |


### world/tiles
| File                      | Description                                      |
| ------------------------- | ------------------------------------------------ |
| **Tile.java**             | Abstract base tile                               |
| **CommonTile.java**       | Normal traversable tile (may trigger battles).   |
| **InaccessibleTile.java** | Tile that cannot be entered.                     |
| **MarketTile.java**       | Tile containing a Market instance.               |


## How to Compile & Run the assignment
- Clone the repository
  - **`git clone https://github.com/sanjask11/Legends-MonstersAndHeroes`**  
- Compile the code in Java version 8
  - **`cd Legends-MonstersAndHeroes/src`**   
  - **`javac -source 1.8 -target 1.8 *.java`**
- Run the java file
  - **`java Main`**

## Sample Input & Output
```text
/Users/sanjanasanjeevkumar/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54518 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/sanjanasanjeevkumar/Desktop/uni/Postgrad/Sem 1/OOSPD/AssignmentHeroesMonsters/out/production/AssignmentHeroesMonsters Main
=== MONSTERS & HEROES ===

=== CHOOSE YOUR HEROES (1–3) ===
0: Gaerdal_Ironhand [Lvl 1, HP=100, MP=100, STR=700, DEX=600, AGI=500, Gold=1354] [Warrior]
1: Sehanine_Monnbow [Lvl 1, HP=100, MP=600, STR=700, DEX=500, AGI=800, Gold=2500] [Warrior]
2: Muamman_Duathall [Lvl 1, HP=100, MP=300, STR=900, DEX=750, AGI=500, Gold=2546] [Warrior]
3: Flandal_Steelskin [Lvl 1, HP=100, MP=200, STR=750, DEX=700, AGI=650, Gold=2500] [Warrior]
4: Undefeated_Yoj [Lvl 1, HP=100, MP=400, STR=800, DEX=700, AGI=400, Gold=2500] [Warrior]
5: Eunoia_Cyn [Lvl 1, HP=100, MP=400, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
6: Rillifane_Rallathil [Lvl 1, HP=100, MP=1300, STR=750, DEX=500, AGI=450, Gold=2500] [Sorcerer]
7: Segojan_Earthcaller [Lvl 1, HP=100, MP=900, STR=800, DEX=650, AGI=500, Gold=2500] [Sorcerer]
8: Reign_Havoc [Lvl 1, HP=100, MP=800, STR=800, DEX=800, AGI=800, Gold=2500] [Sorcerer]
9: Reverie_Ashels [Lvl 1, HP=100, MP=900, STR=800, DEX=400, AGI=700, Gold=2500] [Sorcerer]
10: Kalabar [Lvl 1, HP=100, MP=800, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
11: Skye_Soar [Lvl 1, HP=100, MP=1000, STR=700, DEX=500, AGI=400, Gold=2500] [Sorcerer]
12: Parzival [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=650, Gold=2500] [Paladin]
13: Sehanine_Moonbow [Lvl 1, HP=100, MP=300, STR=750, DEX=700, AGI=700, Gold=2500] [Paladin]
14: Skoraeus_Stonebones [Lvl 1, HP=100, MP=250, STR=650, DEX=350, AGI=600, Gold=2500] [Paladin]
15: Garl_Glittergold [Lvl 1, HP=100, MP=100, STR=600, DEX=400, AGI=500, Gold=2500] [Paladin]
16: Amaryllis_Astra [Lvl 1, HP=100, MP=500, STR=500, DEX=500, AGI=500, Gold=2500] [Paladin]
17: Caliber_Heist [Lvl 1, HP=100, MP=400, STR=400, DEX=400, AGI=400, Gold=2500] [Paladin]
Enter hero index (or -1 to finish): 0
Gaerdal_Ironhand added to party!
Enter hero index (or -1 to finish): 5
Eunoia_Cyn added to party!
Enter hero index (or -1 to finish): 10
Kalabar added to party!
Enter world size (default 8): 5

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ P │ │ M │ │ . │ │ M │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ X │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ . │ │ M │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Gaerdal_Ironhand  HP: 100  MP: 100  STR:700  DEX:600  AGI:500  LVL:1
Eunoia_Cyn  HP: 100  MP: 400  STR:700  DEX:600  AGI:800  LVL:1
Kalabar  HP: 100  MP: 800  STR:850  DEX:600  AGI:400  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ P │ │ . │ │ M │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ X │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ . │ │ M │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Gaerdal_Ironhand  HP: 100  MP: 100  STR:700  DEX:600  AGI:500  LVL:1
Eunoia_Cyn  HP: 100  MP: 400  STR:700  DEX:600  AGI:800  LVL:1
Kalabar  HP: 100  MP: 800  STR:850  DEX:600  AGI:400  LVL:1

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
m

Choose hero to enter market:
0: Gaerdal_Ironhand [Lvl 1, HP=100, MP=100, STR=700, DEX=600, AGI=500, Gold=1354] [Warrior]
1: Eunoia_Cyn [Lvl 1, HP=100, MP=400, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
2: Kalabar [Lvl 1, HP=100, MP=800, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Index (-1 to cancel): 0

=== MARKET ===
Hero: Gaerdal_Ironhand  Gold: 1354
1 Buy
2 Sell
0 Exit
1

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
1
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Bow [Weapon dmg=500, hands=2, lvl=2, cost=300]
2: Scythe [Weapon dmg=1100, hands=2, lvl=6, cost=1000]
3: Axe [Weapon dmg=850, hands=1, lvl=5, cost=550]
4: TSwords [Weapon dmg=1600, hands=2, lvl=8, cost=1400]
5: Dagger [Weapon dmg=250, hands=1, lvl=1, cost=200]
Choose (-1 cancel): 0
Purchased: Sword

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
1
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Bow [Weapon dmg=500, hands=2, lvl=2, cost=300]
2: Scythe [Weapon dmg=1100, hands=2, lvl=6, cost=1000]
3: Axe [Weapon dmg=850, hands=1, lvl=5, cost=550]
4: TSwords [Weapon dmg=1600, hands=2, lvl=8, cost=1400]
5: Dagger [Weapon dmg=250, hands=1, lvl=1, cost=200]
Choose (-1 cancel): 2
Level too low.

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
2
0: Platinum_Shield [Armor -200 dmg, lvl=1, cost=150]
1: Breastplate [Armor -600 dmg, lvl=3, cost=350]
2: Full_Body_Armor [Armor -1100 dmg, lvl=8, cost=1000]
3: Wizard_Shield [Armor -1500 dmg, lvl=10, cost=1200]
4: Guardian_Angel [Armor -1000 dmg, lvl=10, cost=1000]
Choose (-1 cancel): 0
Purchased: Platinum_Shield

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
3
0: Healing_Potion [Potion +100 Health, lvl=1, cost=250]
1: Strength_Potion [Potion +75 Strength, lvl=1, cost=200]
2: Magic_Potion [Potion +100 Mana, lvl=2, cost=350]
3: Luck_Elixir [Potion +65 Agility, lvl=4, cost=500]
4: Mermaid_Tears [Potion +100 Health/Mana/Strength/Agility, lvl=5, cost=850]
5: Ambrosia [Potion +150 All, lvl=8, cost=1000]
Choose (-1 cancel): 0
Purchased: Healing_Potion

What to buy?
1 Weapons
2 Armors
3 Potions
4 Spells
0 Back
0

=== MARKET ===
Hero: Gaerdal_Ironhand  Gold: 454
1 Buy
2 Sell
0 Exit
0
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
b

=== INVENTORY MENU ===
0: Gaerdal_Ironhand
1: Eunoia_Cyn
2: Kalabar
Choose hero (-1 to exit): 
0

=== Gaerdal_Ironhand INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
1

Items:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
1: Platinum_Shield [Armor -200 dmg, lvl=1, cost=150]
2: Healing_Potion [Potion +100 Health, lvl=1, cost=250]

=== Gaerdal_Ironhand INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
2

Weapons:
0: Sword [Weapon dmg=800, hands=1, lvl=1, cost=500]
Choose weapon (-1 to cancel): 0
Gaerdal_Ironhand equipped weapon Sword

=== Gaerdal_Ironhand INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
3

Armors:
0: Platinum_Shield [Armor -200 dmg, lvl=1, cost=150]
Choose armor (-1 to cancel): 0
Gaerdal_Ironhand equipped armor Platinum_Shield

=== Gaerdal_Ironhand INVENTORY ===
1. View Items
2. Equip Weapon
3. Equip Armor
4. Use Potion
0. Back
0

=== INVENTORY MENU ===
0: Gaerdal_Ironhand
1: Eunoia_Cyn
2: Kalabar
Choose hero (-1 to exit): 
-1
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
d

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ M │ │ P │ │ M │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ X │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ . │ │ M │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Gaerdal_Ironhand  HP: 100  MP: 100  STR:700  DEX:600  AGI:500  LVL:1
Eunoia_Cyn  HP: 100  MP: 400  STR:700  DEX:600  AGI:800  LVL:1
Kalabar  HP: 100  MP: 800  STR:850  DEX:600  AGI:400  LVL:1

Monsters appear!

=== BATTLE BEGINS ===

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=100, MP=100, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=100, MP=400, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=100, MP=800, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=900 | DMG=550 | DEF=600 | Dodge=35%]
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=900 | DMG=550 | DEF=600 | Dodge=35%]
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 0

--- Monsters' Turn ---
Rakkshasass attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=110, MP=110, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=110, MP=440, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=110, MP=880, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=900 | DMG=550 | DEF=600 | Dodge=35%]
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=900 | DMG=550 | DEF=600 | Dodge=35%]
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 0
Rakkshasass took 1020 damage (HP = 0)

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 95)
Igneel dealt 120 damage.

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=105, MP=121, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=120, MP=484, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=120, MP=968, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 90)
Melchiresas dealt 70 damage.
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=100, MP=133, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=130, MP=532, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=130, MP=1065, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=110, MP=146, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=140, MP=585, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=140, MP=1172, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 95)
Melchiresas dealt 70 damage.
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=105, MP=161, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=150, MP=644, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=150, MP=1289, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 90)
Melchiresas dealt 70 damage.
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=100, MP=177, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=160, MP=708, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=160, MP=1418, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 2

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 85)
Melchiresas dealt 70 damage.
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=95, MP=195, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=170, MP=779, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=170, MP=1560, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1

--- Monsters' Turn ---
Melchiresas attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 80)
Melchiresas dealt 70 damage.
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand took 15 damage (HP = 65)
Igneel dealt 120 damage.

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=75, MP=215, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=180, MP=857, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=180, MP=1716, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=700 | DMG=350 | DEF=150 | Dodge=75%]
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 1
Melchiresas took 1065 damage (HP = 0)

--- Monsters' Turn ---
Igneel attacks Gaerdal_Ironhand!
Gaerdal_Ironhand dodged!

=== STATUS ===
Heroes:
 - Gaerdal_Ironhand [Lvl 1, HP=85, MP=237, STR=700, DEX=600, AGI=500, Gold=454] [Warrior]
 - Eunoia_Cyn [Lvl 1, HP=190, MP=943, STR=700, DEX=600, AGI=800, Gold=2500] [Warrior]
 - Kalabar [Lvl 1, HP=190, MP=1888, STR=850, DEX=600, AGI=400, Gold=2500] [Sorcerer]
Monsters:
 - [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
 - [Spirit] Melchiresas [Lvl 7 | HP=0 | DMG=350 | DEF=150 | Dodge=75%] (DEAD)
 - [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]

--- Hero Turn: Gaerdal_Ironhand ---
A: Attack
S: Cast Spell
P: Use Potion
E: Equip Weapon/Armor
I: Info (heroes + monsters)
Q: Skip
a

Monsters:
0: [Spirit] Rakkshasass [Lvl 9 | HP=0 | DMG=550 | DEF=600 | Dodge=35%] (DEAD)
1: [Spirit] Melchiresas [Lvl 7 | HP=0 | DMG=350 | DEF=150 | Dodge=75%] (DEAD)
2: [Dragon] Igneel [Lvl 6 | HP=600 | DMG=600 | DEF=400 | Dodge=60%]
Choose target (-1 to cancel): 2
Igneel took 1040 damage (HP = 0)

=== HEROES WIN ===
Gaerdal_Ironhand leveled up! Now level 2
Eunoia_Cyn leveled up! Now level 2
Kalabar leveled up! Now level 2

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ M │ │ P │ │ M │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ X │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ . │ │ M │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Gaerdal_Ironhand  HP: 200  MP: 260  STR:771  DEX:630  AGI:551  LVL:2
Eunoia_Cyn  HP: 200  MP: 1037  STR:771  DEX:630  AGI:882  LVL:2
Kalabar  HP: 200  MP: 2076  STR:892  DEX:661  AGI:441  LVL:2

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
p

=== GAME PAUSED ===
1. Resume
2. Save Game
3. Quit to Main Menu
0. Exit Game Entirely
Choice: 2
Saving...
Game saved to savegame.dat
Choice: 1
Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
L
Game loaded from savegame.dat
Game state restored.

        WORLD MAP 

  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ M │ │ P │ │ M │ │ . │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ X │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ . │ │ . │ │ M │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ M │ │ X │ │ X │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 
  ╭───╮ ╭───╮ ╭───╮ ╭───╮ ╭───╮ 
  │ . │ │ M │ │ M │ │ . │ │ M │ 
  ╰───╯ ╰───╯ ╰───╯ ╰───╯ ╰───╯ 

=== LEGEND ===
P : Party (You)
X : Inaccessible
M : Market
. : Common Tile

=== PARTY STATUS ===
Gaerdal_Ironhand  HP: 200  MP: 260  STR:771  DEX:630  AGI:551  LVL:2
Eunoia_Cyn  HP: 200  MP: 1037  STR:771  DEX:630  AGI:882  LVL:2
Kalabar  HP: 200  MP: 2076  STR:892  DEX:661  AGI:441  LVL:2

Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:
q
Goodbye!

Process finished with exit code 0
```
