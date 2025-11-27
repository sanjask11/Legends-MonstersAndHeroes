package core;

import world.World;
import world.party.Party;

import java.io.Serializable;

/*
This represents a complete snapshot of the running game. This exists purely as a data container when users save/load the game.
 */

public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

    private final World world;
    private final Party party;

    public GameState(World world, Party party) {
        this.world = world;
        this.party = party;
    }

    public World getWorld() {
        return world;
    }

    public Party getParty() {
        return party;
    }
}
