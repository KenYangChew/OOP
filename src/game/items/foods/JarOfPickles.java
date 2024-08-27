package game.items.foods;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.HealAction;
import game.actions.HurtAction;
import game.actions.SellAction;
import game.items.scraps.Sellable;
import game.status.Status;


/**
 * A class that represents the jar of pickles.
 *
 * @author Created by: Gan Ruiqi
 */
public class JarOfPickles extends Item implements Consumable, Sellable {
    /**
     * The hitpoint of the JarOfPickles.
     */
    private final int HITPOINT;

    /**
     * The price of the JarOfPickles.
     */
    private final int PRICE;

    /**
     * The fixed random chance of the JarOfPickles.
     */
    private static final double EXPIRECHANCE = 0.5;

    /**
     * The fixed random chance of the JarOfPickles.
     */
    private static final double SELLCHANCE = 0.5;

    /**
     * Constructor.
     */
    public JarOfPickles() {
        super("Jar Of Pickles", 'n', true);
        this.HITPOINT = 1;
        this.PRICE = 25;
    }

    /**
     * Returns a list of allowable actions for the owner of the JarOfPickles.
     *
     * @param otherActor The actor owning the JarOfPickles.
     * @param location the location of the other actor
     * @return An ActionList containing the allowable actions, including HealAction or HurtAction or SellAction.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (Math.random() <= EXPIRECHANCE) {
            actions.add(new HurtAction(this));
        }
        else  {
            actions.add(new HealAction(this));
        }
        if (otherActor.hasCapability(Status.FRIEND_TO_PLAYER)) {
            actions.add(new SellAction(this, this.getSellPrice()));
        }
        return actions;

    }

    /**
     * Getter for the hit points of the JarOfPickles.
     *
     * @return The hit points of the JarOfPickles.
     */
    @Override
    public int getHitPoints() {
        return HITPOINT;
    }

    /**
     * Gets the sell price of the JarOfPickles
     * In this case, there will be a 25% chance that JarOfPickles is 50 golds
     *
     * @return the price of the JarOfPickles
     */
    @Override
    public int getSellPrice() {
        if (Math.random() <= SELLCHANCE) {
            return PRICE * 2;
        }
        return PRICE;
    }

    /**
     * Process of selling the JarOfPickles
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
