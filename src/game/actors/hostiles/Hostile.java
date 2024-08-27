package game.actors.hostiles;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.status.Status;
import game.actions.AttackAction;
import game.behaviours.WanderBehaviour;


import java.util.TreeMap;

/**
 * Class representing a general Hostile character.
 *
 * @author Created by: Er Jun Yet
 */
public abstract class Hostile extends Actor{

    /**
     * TreeMap to store the behaviours of the Hostile character.
     */
    protected TreeMap<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Status of the Hostile character.
     */
    protected Status myStatus = Status.HOSTILE_TO_PLAYER;

    /**
     * The constructor of the Hostile class which creates a new instance of Hostile.
     * Add WanderBehaviour to the behaviours of Hostile.
     */
    public Hostile(String newHostile, char newHostileDisplay, int newHitPoints) {
        super(newHostile, newHostileDisplay, newHitPoints);
        this.behaviours.put(999, new WanderBehaviour());
        this.addCapability(myStatus);

    }

    /**
     * At each turn, Hostile character selects a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Hostile
     * @param lastAction The Action this Hostile took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Hostile
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The Hostile can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return action of attack that can be done.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}
