package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.scraps.Purchasable;

/**
 * This action represents that the actor can purchase things in the game.
 * This action deducts the price of the item from the actor's balance and adds
 * the purchased item to the actor's inventory.
 * Created by:
 * @author Chew Ken Yang and Ang Qiao Xin.
 * Modified by:
 * @author Gan Ruiqi
 */
public class BuyAction extends Action {
    /**
     * A purchasable item.
     */
    private final Purchasable PURCHASABLE;

    /**
     * A constant of price.
     */
    private final int PRICE;

    /**
     * @param purchasable the item to be purchased
     * @param price the price of the item
     */
    public BuyAction(Purchasable purchasable, int price) {
        this.PURCHASABLE = purchasable;
        this.PRICE = price;
    }
    /**
     * Executes the purchase action.
     * Deducts the price from the actor's balance and adds the purchased item
     * to the actor's inventory if the payment process is successful.
     *
     * @param actor the actor performing the action
     * @param map the game map where the action is being executed
     * @return the outcome of the purchase
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.getBalance() >= PRICE) {
            actor.deductBalance(PRICE);
            if (PURCHASABLE.buyProcess()) {
                actor.addItemToInventory((Item) PURCHASABLE);
                return actor + " purchases " + PURCHASABLE + " at the price of " + PRICE + " gold";
            } else {
                return actor + " purchases " + PURCHASABLE + " but it has disappear with " + PRICE + " gold";
            }
        }
        return actor + " needs "+ (PRICE-actor.getBalance()) + " gold more to purchases "+ PURCHASABLE;
    }

    /**
     * Describe the BuyAction that has performed.
     * @param actor The actor performing the purchase.
     * @return the description of the purchase is done to be displayed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + PURCHASABLE;
    }
}

