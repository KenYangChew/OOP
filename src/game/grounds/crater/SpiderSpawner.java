package game.grounds.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.hostiles.HuntsmanSpider;

/**
 * A class that represents the HuntsmanSpider spawner.
 *
 * @author Created by: Er Jun Yet
 */
public class SpiderSpawner implements Spawner{
    /**
     * The fixed random chance of the SpiderSpawner.
     */
    private static final double SPAWNCHANCE = 0.05;

    /**
     * A method to spawn HuntsmanSpider.
     * @param location Location to spawn the HuntsmanSpider.
     */
    @Override
    public void spawnHostiles(Location location) {
        if (Math.random() <= SPAWNCHANCE && !location.containsAnActor()) {
            location.addActor(new HuntsmanSpider());
        }
    }
}


