package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.foods.Consumable;

/**
 * Class representing the HurtAction by an Actor
 *
 * @author Created by: Gan Ruiqi
 */
public class HurtAction extends Action {
    /**
     * A consumable item.
     */
    private Consumable consumable;

    /**
     * Hitpoint provided by the consumable item.
     */
    private int hitPoints;

    /**
     * Constructor.
     *
     * @param consumable The fruit that puts on the healing power.
     */
    public HurtAction(Consumable consumable) {
        this.consumable= consumable;
        this.hitPoints = consumable.getHitPoints();
    }

    /**
     * Perform the HurtAction.
     *
     * @param actor The actor obtaining the hurting.
     * @param map The map the actor is on.
     * @return a description of the hurting is done.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.hurt(hitPoints);
        actor.removeItemFromInventory((Item) consumable);
        return consumable.consume(actor) + " that has expired. " + actor + " feels sick.";
        }

    /**
     * Describe the HurtAction that has performed.
     * @param actor The actor obtaining the healing.
     * @return the description of the hurting is done to be displayed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}


