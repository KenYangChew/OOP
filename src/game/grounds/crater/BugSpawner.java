package game.grounds.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.hostiles.AlienBug;

/**
 * A class that represents the AlienBug spawner.
 *
 * @author Created by: Er Jun Yet
 */
public class BugSpawner implements Spawner {
    /**
     * The fixed random chance of the BugSpawner.
     */
    private static final double SPAWNCHANCE = 0.1;

    /**
     * A method to spawn AlienBug hostile creature.
     * @param location Location to spawn the AlienBug.
     */
    @Override
    public void spawnHostiles(Location location) {
        if (Math.random() <= SPAWNCHANCE && !location.containsAnActor()) {
            location.addActor(new AlienBug());
        }
    }

}