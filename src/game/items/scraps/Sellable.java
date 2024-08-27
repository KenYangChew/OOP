package game.items.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface that represents a sellable item
 *
 * @author Created by: Gan Ruiqi
 */
public interface Sellable {
    /**
     * Gets the selling price of the item.
     *
     * @return the selling price of the item
     */
    int getSellPrice();

    /**
     * Processes the selling process for the item.
     *
     * @return true if the selling process is successful, false otherwise
     */
    boolean sellProcess(Actor actor, GameMap map);

}
