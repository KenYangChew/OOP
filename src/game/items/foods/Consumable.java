package game.items.foods;
import edu.monash.fit2099.engine.actors.Actor;


/**
 * Represents a consumable item interface in the game.
 *
 * @author Created by: Gan Ruiqi
 */
public interface Consumable {

    /**
     * Returns the hit points provided by the consumable item.
     *
     * @return The hit points provided by the consumable item.
     */
    int getHitPoints();

    /**
     * Performs the consumption action by the specified actor.
     *
     * @param actor The actor consuming the item.
     * @return A string representation of the consumption action.
     */
    default String consume(Actor actor){
        return actor + " consumed " + this;
    }
}
