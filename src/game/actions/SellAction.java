package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.scraps.Sellable;

/**
 * This action represents that the actor can sell things in the game.
 * This action add the price of the item to the actor's balance and remove
 * the sold item from the actor's inventory.
 *
 * @author Created by: Gan Ruiqi
 */
public class SellAction extends Action {
    private final Sellable SELLABLE;
    private final int PRICE;

    /**
     * @param sellable the item to be sold
     * @param price the price of the item
     */
    public SellAction(Sellable sellable, int price) {
        this.SELLABLE = sellable;
        this.PRICE = price;
    }

    /**
     * Executes the sell action.
     * adds the balance of the actor
     * from the actor's inventory if the sell process is successful.
     *
     * @param actor the actor performing the action
     * @param map the game map where the action is being executed
     * @return the outcome of the purchase
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(SELLABLE.sellProcess(actor, map)) {
            actor.addBalance(PRICE);
            actor.removeItemFromInventory((Item) SELLABLE);
            return actor + " sells " + SELLABLE + " and earn " + PRICE + " golds";
        }
        return actor + " failed to sell " + SELLABLE;
    }

    /**
     * Describe the SellAction that has performed.
     * @param actor The actor performing the Selling.
     * @return the description of the selling is done to be displayed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + SELLABLE;
    }
}

