package game.exploration;

import core.Direction;
import core.GameState;
import core.PauseMenu;
import core.SaveManager;
import entities.heroes.Hero;
import entities.monsters.Monster;
import game.InventoryMenu;
import game.battle.Battle;
import world.World;
import world.party.Party;
import world.tiles.MarketTile;
import world.tiles.Tile;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
This class deals with
 * - Interpreting movement commands (W/A/S/D)
 * - Triggering UI updates
 * - Handles market, inventory, save/load, and pause interactions
 * - Detect battle conditions and start Battle when needed
*/

public class ExplorationController {

    private static final String DEFAULT_SAVE_FILE = "savegame.dat";

    private final Scanner in;
    private final ExplorationLogic logic;
    private final ExplorationUI ui;

    public ExplorationController(Scanner in,
                                 World world,
                                 Party party,
                                 entities.monsters.MonsterFactory monsterFactory,
                                 Random rng) {
        this.in = in;
        this.logic = new ExplorationLogic(world, party, monsterFactory, rng);
        this.ui = new ExplorationUI();
    }

    public void run() {
        while (true) {
            ui.printMainPrompt();
            String choice = in.nextLine().trim().toUpperCase();

            switch (choice) {
                case "W" -> move(Direction.UP);
                case "A" -> move(Direction.LEFT);
                case "S" -> move(Direction.DOWN);
                case "D" -> move(Direction.RIGHT);
                case "I" -> ui.printPartyInfo(logic.getParty().getHeroes());
                case "B" -> openBag();
                case "M" -> enterMarket();
                case "V" -> saveGame();
                case "L" -> loadGame();
                case "P" -> pauseGame();
                case "Q" -> { ui.printGoodbye(); return; }
                default -> ui.printInvalidInput();
            }
        }
    }

    private void move(Direction dir) {
        if (logic.move(dir)) {
            animate();
            ui.displayWorld(logic.getWorld());
            checkForBattle();
        }
    }

    private void animate() {
        ui.sleepShort();
        ui.clearScreen();
    }

    private void checkForBattle() {
        Tile t = logic.getCurrentTile();

        if (logic.isCommonTile(t) && logic.shouldTriggerBattle()) {
            ui.printMonstersAppear();
            List<Monster> mons = logic.generateMonstersForParty();
            new Battle(logic.getParty(), mons, in).run();
            ui.displayWorld(logic.getWorld());
        }
    }

    private void openBag() {
        new InventoryMenu(in, logic.getParty()).show();
    }

    private void enterMarket() {
        Tile t = logic.getCurrentTile();
        if (!logic.isMarketTile(t)) {
            ui.printNotOnMarketTile();
            return;
        }

        MarketTile mt = logic.asMarketTile(t);
        List<Hero> heroes = logic.getParty().getHeroes();

        ui.printChooseMarketHero(heroes);
        String s = in.nextLine().trim();

        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return;
            if (idx < 0 || idx >= heroes.size()) return;
            mt.getMarket().open(in, heroes.get(idx));
        } catch (Exception ignored) {}
    }

    private void pauseGame() {
        try {
            PauseMenu.show(in, this::saveGame);
        } catch (RuntimeException ex) {
            if ("QUIT_TO_MENU".equals(ex.getMessage())) return;
            throw ex;
        }
    }

    private void saveGame() {
        GameState state = new GameState(logic.getWorld(), logic.getParty());
        SaveManager.save(state, DEFAULT_SAVE_FILE);
    }

    private void loadGame() {
        GameState state = SaveManager.load(DEFAULT_SAVE_FILE);
        if (state == null) return;

        ui.printGameRestored();
        ui.displayWorld(state.getWorld());
    }
}
