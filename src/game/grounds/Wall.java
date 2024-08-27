package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents a wall.
 *
 * @author Created by: Riordan D. Alfredo
 * @author Checked by: Er Jun Yet
 */
public class Wall extends Ground {
    /**
     * A constructor of wall.
     */
    public Wall() {
        super('#');
    }

    /**
     * A checking method to check no actor is allowed stand on wall.
     * @param actor the Actor to check
     * @return A false value for any actor that attempt to stand on wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
