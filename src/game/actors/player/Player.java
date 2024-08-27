package game.actors.player;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.status.Status;

/**
 * Class representing the Player.
 *
 * @author Created by: Adrian Kristanto
 * @author Modified by: Er Jun Yet and Gan Ruiqi
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Display Player's HP and wallet balance status every round
     * @return Player's HP and wallet balance status
     */
    public String playerStatus(){
        String display = "";
        display += name + " HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH)+"\n";
        display += name + " Wallet: " + this.getBalance();
        return display;

    }

    /**
     * Creates and returns the intrinsic weapon for Player
     * @return a freshly-instantiated IntrinsicWeapon of punch
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }

    /**
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Player took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Player
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed by Player
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        display.println(playerStatus());
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }
}