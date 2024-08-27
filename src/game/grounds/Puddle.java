package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.HealAction;
import game.items.foods.Consumable;

/**
 * Class representing a puddle ground
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Gan Ruiqi
 */
public class Puddle extends Ground implements Consumable {

    private int hitPoints;

    /**
     * Constructor
     */
    public Puddle() {
        super('~');
        this.hitPoints = 1;
    }

    /**
     * Returns a list of allowable actions for the specified actor at the given location and direction.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An ActionList containing the allowable actions, including HealAction if there is an actor at the location.
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.containsAnActor()) {
            actions.add(new HealAction(this));
            return actions;
        }
        return actions;
    }

    /**
     * Increases the maximum health attribute of the actor when consuming the puddle.
     *
     * @param actor The actor consuming the puddle.
     * @return A string representation of the consumption action.
     */
    @Override
    public String consume(Actor actor){
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE,getHitPoints());
        return actor + " drinks from " + this ;
    }

    /**
     * Getter for the hit points of the Puddle.
     *
     * @return The hit points of the Puddle.
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Returns a string representation of the puddle.
     *
     * @return A string representing the puddle object.
     */
    public String toString() {
        return "a random puddle of water";
    }
}
