package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.status.Status;

/**
 * A class that represents a metal sheet.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Gan Ruiqi
 */
public class MetalSheet extends Item implements Sellable {
    /**
     * The price of the MetalSheet.
     */
    private final int PRICE;

    /**
     * The fixed random chance of the MetelSheet.
     */
    private static final double SELLCHANCE = 0.6;

    /**
     * Constructor of MetalSheet.
     */
    public MetalSheet() {
        super("Metal sheet", '%', true);
        this.PRICE = 20;
    }

    /**
     * Returns a list of allowable actions for the owner of the MetalSheet.
     *
     * @param otherActor The actor owning the MetalSheet.
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
     * Gets the sell price of the MetalSheet
     * In this case, there is 60% of the time it will be sold for 10 golds
     *
     * @return the price of the MetalSheet
     */
    @Override
    public int getSellPrice() {
        if (Math.random() <= SELLCHANCE) {
            return (PRICE/2);
        }
        return PRICE;
    }

    /**
     * Process of selling the MetalSheet
     * In this case, the sell process always succeeds
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