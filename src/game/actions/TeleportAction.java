package game.actions;

import java.util.Map.Entry;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.computer.Teleportation;

/**
 * An action class that allows the actor to teleport to a location using a teleportation device.
 *
 * @author Created by: Er Jun Yet
 */
public class TeleportAction extends Action {
    /**
     * The String name of the teleportation device.
     */
    private String teleportDevice;

    /**
     * The String name of the location to teleport to.
     */
    private String teleportLocationName;

    /**
     * The location to teleport to.
     */
    private Location teleportLocation;

    /**
     * Constructor.
     * @param teleportation The teleportation device.
     * @param teleportLocation The location to teleport to.
     */
    public TeleportAction(Teleportation teleportation, Entry<String, Location> teleportLocation) {
        this.teleportDevice = teleportation.getTeleportDevice();
        this.teleportLocationName = teleportLocation.getKey();
        this.teleportLocation = teleportLocation.getValue();
    }

    /**
     * Executes the teleportation action.
     * @param actor The actor that is teleporting.
     * @param map The map that the actor is on.
     * @return A string that describes the teleportation action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        MoveActorAction teleport = new MoveActorAction(teleportLocation, "to " + teleportLocationName + " with " + teleportDevice);
        String teleported = teleport.execute(actor, map);
        return teleported;
    }

    /**
     * Returns a string that describes the teleportation action.
     * @param actor The actor that is teleporting.
     * @return A string that describes the teleportation action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleport to " + teleportLocationName + " with " + teleportDevice;
    }


}
