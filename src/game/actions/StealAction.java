package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that figures out a StealAction that will steal an item from the ground.
 *
 * @author Created by: Er Jun Yet and Ang Qiao Xin
 */
public class StealAction extends Action {
    /**
     * Item to be stolen.
     */
    private Item stoleItem;

    /**
     * Constructor of StealAction to set the item to be stolen.
     *
     * @param newStoleItem the Item to be stolen
     */
    public StealAction(Item newStoleItem) {
        this.stoleItem = newStoleItem;
    }

    /**
     * Steal the item from the ground.
     *
     * @param actor the Actor to steal the item
     * @param map the GameMap containing the Actor
     * @return a String that describes the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        PickUpAction steal = new PickUpAction(stoleItem);
        return steal.execute(actor, map);
    }

    /**
     * Returns a String that describes the action of stealing.
     *
     * @param actor the Actor to steal the item
     * @return a String that describes the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " stole " + stoleItem + " from the ground.";
    }

}
