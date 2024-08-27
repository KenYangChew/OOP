package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.CollectAction;
import game.actions.SellAction;
import game.status.Status;

/**
 * A class that represents the pot of gold that has gold inside.
 *
 * @author Created by: Gan Ruiqi
 */
public class PotOfGold extends Item implements Sellable {
    /**
     * The price of the PotOfGold.
     */
    private final int PRICE;

    /**
     * The fixed random chance of the PotOfGold.
     */
    private static final double SELLCHANCE = 0.25 ;

    /**
     * Constructor.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
        this.PRICE = 500;
    }

    /**
     * Returns a list of allowable actions for the owner of the PotOfGold.
     *
     * @param otherActor The actor owning the PotOfGold.
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
     * Gets the sell price of the PotOfGold
     * In this case, 25% of the time it will be sold for 0 gold
     *
     * @return the price of the PotOfGold
     */
    @Override
    public int getSellPrice() {
        if (Math.random() <= SELLCHANCE) {
            return 0;
        }
        return PRICE;
    }

    /**
     * Process of selling the PotOfGold
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