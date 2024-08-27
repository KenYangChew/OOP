package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.scraps.Sellable;
import game.status.Status;
import game.actions.AttackAction;

/**
 * A class that represents a metal pipe.
 *
 * @author Edited by: Er Jun Yet
 * @author Modified by: Gan Ruiqi
 */
public class MetalPipe extends WeaponItem implements Sellable {
    /**
     * The price of the MetalPipe.
     */
    private final int PRICE;

    /**
     * Constructor of MetalPipe.
     *
     */
    public MetalPipe() {
        super("Metal pipe", '!', 1, "hits", 20);
        this.PRICE = 35;
    }

    /**
     * Returns a list of allowable actions for the owner of the MetalPipe.
     *
     * @param otherActor The actor owning the MetalPipe.
     * @param location the location of the other actor.
     * @return An ActionList containing the allowable actions, including SellAction or AttackAction.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            actions.add(new AttackAction(otherActor, String.format("(%d,%d)", location.x(), location.y()), this));
        }
        if (otherActor.hasCapability(Status.FRIEND_TO_PLAYER)) {
            actions.add(new SellAction(this, this.getSellPrice()));
        }
        return actions;
    }

    /**
     * Gets the sell price of the MetalPipe
     *
     * @return the price of the MetalPipe
     */
    @Override
    public int getSellPrice() {
        return PRICE;
    }

    /**
     * Process of selling the MetalPipe
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
