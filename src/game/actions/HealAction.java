package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.foods.Consumable;

/**
 * Class representing the HealAction by an Actor
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Gan Ruiqi
 */
public class HealAction extends Action {
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
    public HealAction(Consumable consumable) {
        this.consumable= consumable;
        this.hitPoints = consumable.getHitPoints();
    }


    /**
     * Perform the HealAction.
     *
     * @param actor The actor obtaining the healing.
     * @param map The map the actor is on.
     * @return a description of the healing is done.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item : actor.getItemInventory()) {
            if (item.equals(consumable)) {
                actor.heal(hitPoints);
                actor.removeItemFromInventory(item);
                return consumable.consume(actor) + " to heal " + hitPoints + " points.";
            }
        }
        return consumable.consume(actor) + " to heal " + hitPoints + " points.";
    }


    /**
     * Describe the HealAction that has performed.
     * @param actor The actor obtaining the healing.
     * @return the description of the healing is done to be displayed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}