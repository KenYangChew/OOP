package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellAction;
import game.items.foods.JarOfPickles;
import game.items.foods.fruits.LargeFruit;
import game.items.scraps.*;
import game.items.weapons.MetalPipe;
import game.status.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Humanoid Figure as an actor in the game.
 *
 * @author Created by: Gan Ruiqi
 */
public class HumanoidFigure extends Actor {
    /**
     * Constructor to initialize the Humanoid Figure with a name, display character, and list of sellable items.
     */
    public HumanoidFigure() {
        super("Humanoid Figure", 'H', 0);
        this.addCapability(Status.FRIEND_TO_PLAYER);
    }

    /**
     * Defines the action that the Humanoid Figure will perform on each turn, which is doing nothing.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}