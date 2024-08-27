package game.actors.hostiles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.status.Status;

/**
 * A class that represents the SuspiciousAstronaut hostile creature.
 *
 * @author Created by: Er Jun Yet and Ang Qiao Xin
 */
public class SuspiciousAstronaut extends Hostile {
    /**
     * A field of LONG_MAX
     */
    private static int LONG_MAX;

    /**
     * A constant of hitpoints.
     */
    private static final int HIT_POINTS = 99;

    /**
     * Constructor of SuspiciousAstronaut to create a new instance of SuspiciousAstronaut.
     * Add AttackBehaviour to the behaviours of SuspiciousAstronaut.
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", '\u0D9E', HIT_POINTS);
        this.behaviours.put(0, new AttackBehaviour());
        this.addCapability(Status.DANGER_TO_PLAYER);
    }

    /**
     * At each turn, SuspiciousAstronaut selects a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Hostile
     * @param lastAction The Action this Hostile took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Hostile
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location location = map.locationOf(this);
        for (Exit exit : location.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                if (exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    LONG_MAX = exit.getDestination().getActor().getAttributeMaximum(BaseActorAttributes.HEALTH);
                }
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Creates and returns the intrinsic weapon for HuntsmanSpider.
     * @return a freshly-instantiated IntrinsicWeapon of long legs.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(LONG_MAX, "kills", 100);
    }
}