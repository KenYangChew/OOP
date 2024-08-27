package game.items.devices;

/**
 * An enum class that represents the conditions that a Monologue object can have.
 * @author Created by: Ang Qiao Xin
 */
public enum Condition {
    /**
     * Condition where the monologue is always valid.
     */
    NONE,
    /**
     * Condition where the monologue is valid if the actor has more items than the threshold.
     */
    MIN_ITEMS,
    /**
     * Condition where the monologue is valid if the actor has more balance than the threshold.
     */
    MIN_BALANCE,
    /**
     * Condition where the monologue is valid if the actor has less health than the threshold.
     */
    LOW_HEALTH
}