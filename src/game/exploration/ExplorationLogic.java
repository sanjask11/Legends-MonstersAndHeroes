package game.exploration;

import core.Direction;
import entities.heroes.Hero;
import entities.monsters.Monster;
import entities.monsters.MonsterFactory;
import world.World;
import world.party.Party;
import world.tiles.CommonTile;
import world.tiles.MarketTile;
import world.tiles.Tile;

import java.util.List;
import java.util.Random;


/*
This class deals with the
 * - delegating movement to the World
 * - checking if a tile is common/market basically what type of tile is the user on
 * - determining encounter chance and generate monsters
 * - Providing access to the Party and World state used during exploration
*/
public class ExplorationLogic {

    private final World world;
    private final Party party;
    private final MonsterFactory monsterFactory;
    private final Random rng;

    public ExplorationLogic(World world,
                            Party party,
                            MonsterFactory monsterFactory,
                            Random rng) {
        this.world = world;
        this.party = party;
        this.monsterFactory = monsterFactory;
        this.rng = rng;
    }


    public boolean move(Direction dir) {
        return world.moveParty(dir);
    }


    public Tile getCurrentTile() {
        return world.getCurrentTile();
    }

    public boolean isCommonTile(Tile t) {
        return t instanceof CommonTile;
    }

    public boolean isMarketTile(Tile t) {
        return t instanceof MarketTile;
    }

    public MarketTile asMarketTile(Tile t) {
        return (t instanceof MarketTile mt) ? mt : null;
    }


    public boolean shouldTriggerBattle() {
        return rng.nextDouble() < 0.3;
    }

    public List<Monster> generateMonstersForParty() {
        List<Hero> heroes = party.getHeroes();
        return monsterFactory.generateMonsters(heroes);
    }


    public Party getParty() {
        return party;
    }

    public World getWorld() {
        return world;
    }
}
