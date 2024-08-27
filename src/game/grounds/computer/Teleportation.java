package game.grounds.computer;

import java.util.List;
import java.util.Map.Entry;

import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface that represents a teleportation device that can teleport an actor to a location on a map.
 *
 * @author Created by: Er Jun Yet
 */
public interface Teleportation {
    /**
     * Returns a list of teleport locations that the actor can teleport to.
     * @param currentLocation The current location of the actor.
     * @return A list of teleport locations that the actor can teleport to.
     */
    List<Entry<String, Location>> teleportLocation(Location currentLocation);

    /**
     * Returns the name of the teleportation device.
     * @return The name of the teleportation device.
     */
    String getTeleportDevice();

}
