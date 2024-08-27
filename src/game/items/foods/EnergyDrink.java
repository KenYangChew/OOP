package game.items.foods;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealAction;
import game.items.scraps.Purchasable;

/**
 * A class that represents an energy drink.
 *
 * @author Created by: Chew Ken Yang and Ang Qiao Xin
 */
public class EnergyDrink extends Item implements Consumable, Purchasable {
    /**
     * The price of the EnergyDrink.
     */
    private final int PRICE;

    /**
     * The hitpoints of the EnergyDrink.
     */
    private final int HITPOINTS;

    /**
     * The fixed random chance of the EnergyDrink.
     */
    private final static double BUYCHANCE = 0.2;

    /**
     * Constructor for the EnergyDrink class.
     * Initializes the energy drink with its name, symbol, and availability.
     * Sets its price and hit points.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
        this.PRICE = 10;
        this.HITPOINTS = 1;
    }


    /**
     * Get the hit points restored by consuming the energy drink.
     *
     * @return the hit points restored by the energy drink
     */
    @Override
    public int getHitPoints(){
        return HITPOINTS;
    }

    /**
     * Get the price of the energy drink.
     * There is a 20% chance that the price will be doubled.
     *
     * @return the price of the energy drink
     */
    @Override
    public int getBuyPrice(){
        if (Math.random() <= BUYCHANCE){
            return PRICE * 2;
        }
        return PRICE;
    }

    @Override
    public boolean buyProcess() {
        return true;
    }


    /**
     * Determines the actions that are allowable for the owner of the energy drink.
     * Allows the owner to consume the energy drink to restore hit points.
     *
     * @param owner the actor owning the energy drink
     * @return a list of allowable actions for the owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new HealAction(this));
        return actions;
    }
}

