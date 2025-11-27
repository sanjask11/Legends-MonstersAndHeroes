package entities.heroes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
This class is responsible for creating and exposing all available heroes.
 */
public class HeroFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Hero> heroes = new ArrayList<>();

    public HeroFactory() {
        HeroLoader.loadAll(heroes);
    }

    public List<Hero> getAllHeroes() {
        return heroes;
    }
}

