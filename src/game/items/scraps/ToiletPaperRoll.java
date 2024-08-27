package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.status.Status;

/**
 * A class that represents a Toilet Paper Roll.
 *
 * @author Created by: Chew Ken Yang and Ang Qiao Xin
 * @author Modified by: Gan Ruiqi
 */
public class ToiletPaperRoll extends Item implements Purchasable,Sellable {
    /**
     * The price of the ToiletPaperRoll.
     */
    private final int PRICE;

    /**
     * The fixed random chance of the ToiletPaperRoll.
     */
    private static final double DIECHANCE = 0.5;

    /**
     * The fixed random chance of the ToiletPaperRoll.
     */
    private static final double BUYCHANCE = 0.75;

    /**
     * Constructor for the ToiletPaperRoll class.
     * Initializes the toilet paper roll with its name, symbol, and availability.
     * Sets its price.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
        this.PRICE = 5;
    }

    /**
     * Returns a list of allowable actions for the owner of the ToiletPaperRoll.
     *
     * @param otherActor The actor owning the ToiletPaperRoll.
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
     * Get the price of the toilet paper roll.
     * There is a 75% chance that the price will be discounted by 4 gold.
     *
     * @return the price of the toilet paper roll
     */
    @Override
    public int getBuyPrice(){
        if (Math.random() <= BUYCHANCE){
            return (PRICE - 4);
        }
        return PRICE;
    }

    /**
     * Processes the payment for the ToiletPaperRoll
     *
     * @return true if the payment process is successful, false otherwise
     */
    @Override
    public boolean buyProcess() {
        return true;
    }

    /**
     * Gets the sell price of the ToiletPaperRoll
     *
     * @return the price of the ToiletPaperRoll
     */
    @Override
    public int getSellPrice(){
        return (PRICE-4);
    }

    /**
     * Process of selling the ToiletPaperRoll
     * In this case, there is 50% chance the actor will die while trying to sell the ToiletPaperRoll
     *
     * @param actor the actor who sells the item
     * @param map the current game map
     * @return true indicating the sell process is successful
     */
    @Override
    public boolean sellProcess(Actor actor, GameMap map){
        if (Math.random() <= DIECHANCE) {
            actor.unconscious(actor, map);
            return false;
        }
        return true;
    }




}
