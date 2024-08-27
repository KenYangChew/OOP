package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.status.Status;
import game.actions.AttackAction;

/**
 * Class representing the AttackBehaviour by an Actor or NPC
 *
 * @author Created by: Er Jun Yet
 */
public class AttackBehaviour implements Behaviour {

    /**
     * AttackAction to be obtained from the AttackBehaviour.
     * @param actor the Actor exhibiting the AttackBehaviour
     * @param map the GameMap containing the Actor
     * @return The AttackAction that can be performed.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if ((destination.getActor() != null) && (destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY))) {
                return new AttackAction(destination.getActor(), exit.getName());
            }
        }
        return null;
    }
}
