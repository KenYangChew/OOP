package game.grounds.crater;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents the crater that spawns hostiles.
 *
 * @author Created by: Er Jun Yet
 */
public class Crater extends Ground {
    /**
     * A Spawner instance.
     */
    private Spawner spawner;

    /**
     * Constructor of Crater.
     */
    public Crater(Spawner newSpawner) {
        super('u');
        this.spawner = newSpawner;
    }

    /**
     * Crater experience the passage of time by spawning hostile occasionally.
     * @param location The location of the Ground to spawn hostile.
     */
    @Override
    public void tick(Location location) {
        spawner.spawnHostiles(location);
    }
}


