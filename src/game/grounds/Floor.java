package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.status.Status;

/**
 * A class that represents the floor inside a building.
 *
 * @author Created by: Riordan D. Alfredo
 * @author Modified by: Er Jun Yet
 */
public class Floor extends Ground {
    /*
     * Constructor of floor.
     */
    public Floor() {
        super('_');
    }

    /**
     * A checking method to check no hostile allowed to enter the floor.
     * @param actor the Actor to check
     * @return Check actor if is a hostile to player, not allowed to enter.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Status.DANGER_TO_PLAYER);
    }
}
