package game;

import entities.monsters.MonsterFactory;
import game.exploration.ExplorationController;
import core.Menu;
import world.World;
import world.party.Party;

import java.util.Random;
import java.util.Scanner;

public class ExplorationMenu implements Menu {

    private final Scanner in;
    private final World world;
    private final Party party;
    private final MonsterFactory factory;
    private final Random rng;

    public ExplorationMenu(Scanner in,
                           World world,
                           Party party,
                           MonsterFactory factory,
                           Random rng) {
        this.in = in;
        this.world = world;
        this.party = party;
        this.factory = factory;
        this.rng = rng;
    }

    @Override
    public void show() {
        new ExplorationController(in, world, party, factory, rng).run();
    }
}
