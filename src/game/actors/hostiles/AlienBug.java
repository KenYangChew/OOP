package game.actors.hostiles;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.FollowBehaviour;
import game.behaviours.StealBehaviour;
import game.status.Status;

import java.util.Random;

/**
 * Class representing an AlienBug character.
 *
 * @author Created by: Er Jun Yet
 */
public class AlienBug extends Hostile{
    /**
     * A constant of hitpoints.
     */
    private static final int HIT_POINTS = 2;

    /**
     * Constructor for AlienBug and adds StealBehaviour to the behaviours of AlienBug.
     *
     */
    public AlienBug() {
        super(getName(), 'a', HIT_POINTS);
        this.behaviours.put(0, new StealBehaviour());
    }

    /**
     * Generates a random name for AlienBug.
     *
     * @return a random name for AlienBug
     */
    private static String getName() {
        Random random = new Random();
        int codeNumber = random.nextInt(1000);
        return "Feature-" + String.format("%03d", codeNumber);
    }

    /**
     * At each turn, AlienBug character selects a valid action to perform.
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
        if (behaviours.get(1) == null){
            for (Exit exit : location.getExits()) {
                if (exit.getDestination().containsAnActor()) {
                    if (exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        this.behaviours.put(1, new FollowBehaviour(exit.getDestination().getActor()));
                        this.behaviours.remove(999);
                    }
                }
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

}
