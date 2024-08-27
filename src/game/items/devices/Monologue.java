package game.items.devices;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;

/**
 * A class that represents a monologue that can be spoken and check for validity based on a condition.
 * @author Created by: Ang Qiao Xin
 */
public class Monologue {

    private final String message;
    private final Condition condition;
    private final int threshold;

    /**
     * Constructor for Monologue.
     * @param message The message of the monologue.
     * @param condition The condition of the monologue.
     * @param threshold The threshold of the monologue.
     */
    public Monologue(String message, Condition condition, int threshold) {
        this.message = message;
        this.condition = condition;
        this.threshold = threshold;
    }

    /**
     * Method to get the message of the monologue.
     * @return The message of the monologue.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Method to check if the monologue is valid based on the condition.
     * @param actor The actor that is listening to the monologue.
     * @return True if the monologue is valid, false otherwise.
     */
    public boolean isValid(Actor actor) {
        switch (condition) {
            case MIN_ITEMS:
                return actor.getItemInventory().size() > threshold;
            case MIN_BALANCE:
                return actor.getBalance() > threshold;
            case LOW_HEALTH:
                return actor.getAttribute(BaseActorAttributes.HEALTH) < threshold;
            case NONE:
            default:
                return true;
        }
    }
}