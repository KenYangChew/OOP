package game.status;

/**
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attack a Status.SLEEP to the player class
 *
 * @author Created by: Riordan D. Alfredo
 * @author Modified by: Er Jun Yet
 */
public enum Status {
    /**
     * Status of the Player that is enemy to all Hostile creatures (can attack Hostile).
     */
    HOSTILE_TO_ENEMY,

    /**
     * Status of the Hostile that is enemy to Player (disadvantage to Player).
     */
    HOSTILE_TO_PLAYER,

    /**
     * Status of the Hostile that is danger to Player (can attack Player).
     */
    DANGER_TO_PLAYER,

    FRIEND_TO_PLAYER

}
