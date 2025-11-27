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


###entities/heroes/
| File                 | Description                                                                                 |
| -------------------- | ------------------------------------------------------------------------------------------- |
| **Hero.java**        | Abstract base class for all hero types with stats, leveling, equipment, and combat methods. |
| **HeroFactory.java** | Builds hero list using the loader.                                                          |
| **HeroLoader.java**  | Loads hero data from the provided files.                                                    |
| **Paladin.java**     | Paladin specialization (favored stats: strength & dexterity).                               |
| **Sorcerer.java**    | Sorcerer specialization (favored stats: dexterity & agility).                               |
| **Warrior.java**     | Warrior specialization (favored stats: strength & agility).                                 |


###entities/monsters/
| File                    | Description                                                                   |
| ----------------------- | ----------------------------------------------------------------------------- |
| **Monster.java**        | Abstract monster base class with HP, damage, dodge, and spell reaction logic. |
| **MonsterFactory.java** | Generates enemy parties according to hero levels.                             |
| **MonsterLoader.java**  | Loads monster data from provided files.                                       |
| **Dragon.java**         | Monster subtype: dragon.                                                      |
| **Exoskeleton.java**    | Monster subtype: exoskeleton.                                                 |
| **Spirit.java**         | Monster subtype: spirit.                                                      |
| **CombatEntity.java**   | Shared interface for Hero + Monster (HP, dodge, damage).                      |


###game/battle/
| File                  | Description                                                     |
| --------------------- | --------------------------------------------------------------- |
| **Battle.java**       | Orchestrates the full battle loop using UI + logic.             |
| **BattleLogic.java**  | Computes attacks, spells, dodging, potions, regen, and rewards. |
| **BattleResult.java** | Represents win/loss/continue status.                            |
| **BattleUI.java**     | Handles all battle-related user input and on-screen printing.   |


###game/exploration/
| File                           | Description                                                   |
| ------------------------------ | ------------------------------------------------------------- |
| **ExplorationController.java** | Main controller for world movement, events, markets, battles. |
| **ExplorationLogic.java**      | Contains world-movement logic and random battle checks.       |
| **ExplorationUI.java**         | Displays world map, prompts, and feedback messages.           |


###game/inventory/
| File                         | Description                                                       |
| ---------------------------- | ----------------------------------------------------------------- |
| **InventoryController.java** | Full inventory flow: view items, equip, use potion.               |
| **InventoryLogic.java**      | Pure business logic for filtering & performing inventory actions. |
| **InventoryUI.java**         | All inventory menu prompts and printed output.                    |



###game/services/
| File                   | Description                                      |
| ---------------------- | ------------------------------------------------ |
| **PotionService.java** | Applies potion effects (HP/MP/attribute boosts). |


###game/setup/
| File                     | Description                                         |
| ------------------------ | --------------------------------------------------- |
| **SetupController.java** | Handles selecting heroes and world size.            |
| **SetupLogic.java**      | Validation logic for hero selection and world size. |
| **SetupUI.java**         | Displays hero list and prompts for selection.       |



###game/
| File                     | Description                                                     |
| ------------------------ | --------------------------------------------------------------- |
| **ExplorationMenu.java** | Legacy thin wrapper (now replaced by ExplorationController).    |
| **Game.java**            | Entry point that creates world, party, and launches game flow.  |
| **InventoryMenu.java**   | Legacy wrapper for inventory (replaced by InventoryController). |
| **SetupMenu.java**       | Legacy wrapper for hero/world selection.                        |



###items/
| File               | Description                                              |
| ------------------ | -------------------------------------------------------- |
| **Item.java**      | Parent class for all inventory items.                    |
| **Weapon.java**    | Weapon items with damage and required levels.            |
| **Armor.java**     | Armor items with damage reduction.                       |
| **Potion.java**    | Potion items with multi-stat effects.                    |
| **Spell.java**     | Spell items with damage and spell-type-specific effects. |
| **SpellType.java** | Enum defining FIRE/ICE/LIGHTNING.                        |



###market/
| File                      | Description                                                     |
| ------------------------- | --------------------------------------------------------------- |
| **Market.java**           | Market container storing buyable weapons/armors/potions/spells. |
| **MarketController.java** | Controls the buy/sell flow.                                     |
| **MarketLoader.java**     | Loads all market items from data files.                         |
| **MarketLogic.java**      | Price, validation, and transaction logic.                       |
| **MarketUI.java**         | All printed menus for market actions.                           |


###world/
| File           | Description                                                           |
| -------------- | --------------------------------------------------------------------- |
| **World.java** | Builds the map grid, tracks party position, provides tile navigation. |


###world/party
| File           | Description                                           |
| -------------- | ----------------------------------------------------- |
| **Party.java** | Stores hero list and party position on the world map. |


###world/tiles
| File                      | Description                                      |
| ------------------------- | ------------------------------------------------ |
| **Tile.java**             | Abstract base tile (accessible vs inaccessible). |
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
