package game.grounds.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.hostiles.SuspiciousAstronaut;

/**
 * A class that represents the SuspiciousAstronaut spawner.
 *
 * @author Created by: Er Jun Yet
 */
public class AstronautSpawner implements Spawner{
    /**
     * The fixed random chance of the AstronautSpawner.
     */
    private static final double SPAWNCHANCE = 0.05;

    /**
     * A method to spawn SuspiciousAstronaut and add it to the map.
     * @param location Location to spawn the SuspiciousAstronaut.
     */
    @Override
    public void spawnHostiles(Location location) {
        if (Math.random() <= SPAWNCHANCE && !location.containsAnActor()) {
            location.addActor(new SuspiciousAstronaut());
        }
    }
}

