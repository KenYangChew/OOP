package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.scraps.PotOfGold;

/**
 * Class representing the CollectAction by an Actor
 *
 * @author Created by: Gan Ruiqi
 */
public class CollectAction extends Action {
    /**
     * A pot of gold to collect.
     */
    private PotOfGold potOfGold;

    /**
     * Amount of gold to collect.
     */
    private int gold;

    /**
     * Constructor.
     *
     * @param potOfGold The PotOfGold item from which gold is collected.
     * @param gold      The amount of gold collected.
     */
    public CollectAction(PotOfGold potOfGold,int gold) {
        this.potOfGold= potOfGold;
        this.gold = gold;
    }

    /**
     * Executes the CollectAction by adding gold to the actor's balance and removing the PotOfGold item from their inventory.
     *
     * @param actor The actor performing the action.
     * @param map   The game map where the actor is located.
     * @return A string describing the outcome of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addBalance(gold);
        actor.removeItemFromInventory(potOfGold);
        return actor + " takes "+ gold + " golds out from " + potOfGold;
    }

    /**
     * Returns a description of the CollectAction to be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string representing the menu description of the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " takes gold out from " + potOfGold;
    }
}
