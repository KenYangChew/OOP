package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.devices.Narratable;
import java.util.ArrayList;
import java.util.List;
import game.items.devices.Monologue;

/**
 * A class that represents the action of listening to a Narratable object.
 * @author Created by: Ang Qiao Xin
 */
public class ListenAction extends Action {
    private final Narratable narratable;

    /**
     * Constructor for ListenAction.
     * @param narratable The Narratable object that the actor is listening to.
     */
    public ListenAction(Narratable narratable) {
        this.narratable = narratable;
    }

    /**
     * Method to execute the action of listening to the Narratable object.
     * @param actor The actor that is listening to the Narratable object.
     * @param map The map that the actor is on.
     * @return A string that represents the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Monologue> validMonologues = new ArrayList<>();
        for (Monologue monologue : narratable.getMonologues(actor)) {
            if (monologue.isValid(actor)) {
                validMonologues.add(monologue);
            }
        }
        if (!validMonologues.isEmpty()) {
            String message = narratable + ": " + validMonologues.get((int) (Math.random() * validMonologues.size())).getMessage();
            return message;
        }

        return "";
    }

    /**
     * Method to get the menu description of the action.
     * @param actor The actor that is listening to the Narratable object.
     * @return A string that represents the menu description of the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + narratable;
    }
}
