package game.grounds.crater;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents the spawner interface.
 *
 * @author Created by: Er Jun Yet
 */
public interface Spawner {

    /**
     * A method to spawn any hostile.
     * @param location Location to spawn the hostile.
     */
    void spawnHostiles(Location location);

}
