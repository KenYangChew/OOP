package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.items.scraps.Purchasable;
import game.status.Status;

/**
 * A class that represents a Dragon Slayer Sword.
 *
 * @author Created by: Chew Ken Yang and Ang Qiao Xin
 * @author Modified by: Gan Ruiqi
 */
public class DragonSlayerSword extends WeaponItem implements Purchasable {
    /**
     * The price of the DragonSlayerSword.
     */
    private final int PRICE;

    /**
     * The fixed random chance of the DragonSlayerSword.
     */
    private static final double BUYCHANCE = 0.5;

    /**
     * Constructor for the DragonSlayerSword class.
     * Initializes the dragon slayer sword with its name, symbol, damage, and verb.
     * Sets its price and hit points.
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword" , 'x' ,50 , "slashes",75);
        this.PRICE = 100;
    }

    /**
     * Get the price of the dragon slayer sword.
     *
     * @return the price of the dragon slayer sword
     */
    @Override
    public int getBuyPrice(){
        return PRICE;
    }

    /**
     * Processes the payment for the dragon slayer sword.
     * There is a 50% chance that the payment process will fail.
     *
     * @return true if the payment process is successful, false otherwise
     */
    @Override
    public boolean buyProcess(){
        if (Math.random() <= BUYCHANCE){
            return false;
        }
        return true;
    }

    /**
     * Determines the actions that are allowable for an actor using the dragon slayer sword.
     * Allows the actor to attack other actors if they are hostile to the player.
     *
     * @param otherActor the actor being attacked
     * @param location   the location where the attack occurs
     * @return a list of allowable actions for the actor using the dragon slayer sword
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER))
            actions.add(new AttackAction(otherActor, String.format("(%d,%d)", location.x(), location.y()), this));
        return actions;
    }
}
