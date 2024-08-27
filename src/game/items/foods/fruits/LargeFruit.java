package game.items.foods.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.items.scraps.Sellable;
import game.status.Status;

/**
 * A class that represents a large Fruit.
 * Edited by:
 * @author Er Jun Yet
 * Modified by:
 * @author Gan Ruiqi
 *
 */
public class LargeFruit extends Fruit implements Sellable {

    private final int price;

    /**
     * Constructor of LargeFruit.
     */
    public LargeFruit() {
        super("Big fruit", 'O', 2);
        this.price = 30;
    }

    /**
     * Returns a list of allowable actions for the owner of the LargeFruit.
     *
     * @param otherActor The actor owning the LargeFruit.
     * @param location the location of the other actor.
     * @return An ActionList containing the allowable actions, including SellAction.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.FRIEND_TO_PLAYER)) {
            actions.add(new SellAction(this, this.getSellPrice()));
        }
        return actions;
    }

    /**
     * Gets the sell price of the LargeFruit
     *
     * @return the price of the LargeFruit
     */
    @Override
    public int getSellPrice() {
        return price;
    }

    /**
     * Process of selling the LargeFruit
     * In this case, the sell process always succeeds.
     *
     * @param actor the actor who sells the item
     * @param map the current game map
     * @return true indicating the sell process is successful
     */
    @Override
    public boolean sellProcess(Actor actor, GameMap map) {
        return true;
    }
}

