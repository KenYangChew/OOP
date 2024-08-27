package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.status.Status;

/**
 * A class that represents a large bolt.
 *
 * @author Edited by: Er Jun Yet
 * @author Modified by: Gan Ruiqi
 */
public class LargeBolt extends Item implements Sellable {
    /**
     * The price of the LargeBolt.
     */
    private final int PRICE;

    /**
     * Constructor of LargeBolt.
     */
    public LargeBolt() {
        super("Large bolt", '+', true);
        this.PRICE = 25;
    }

    /**
     * Returns a list of allowable actions for the owner of the LargeBolt.
     *
     * @param otherActor The actor owning the LargeBolt.
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
     * Gets the sell price of the LargeBolt
     *
     * @return the price of the LargeBolt
     */
    @Override
    public int getSellPrice(){
        return PRICE;
    }

    /**
     * Process of selling the LargeBolt.
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
