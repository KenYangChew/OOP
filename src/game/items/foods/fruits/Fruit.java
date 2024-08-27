package game.items.foods.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealAction;
import game.items.foods.Consumable;

/**
 * A class that represents a general Fruit.
 * Created by:
 * @author Er Jun Yet
 * Modified by:
 * @author Gan Ruiqi
 */
public abstract class Fruit extends Item implements Consumable {
    private String fruit;
    private int hitPoints;

    /**
     * Constructor of Fruit.
     * @param newFruit The name of this Fruit
     * @param newFruitDisplay The representation of Inheritree type to display.
     * @param newHitPoints The hitpoints that this Fruit posses.
     */
    public Fruit(String newFruit, char newFruitDisplay, int newHitPoints) {
        super(newFruit, newFruitDisplay, true);
        this.fruit = newFruit;
        this.hitPoints = newHitPoints;
    }

    /**
     * Return the current fruit.
     * @return The current fruit.
     */
    public String getFruit() {
        return fruit;
    }

    /**
     * Getter for the hit points of the Fruit.
     *
     * @return The hit points of the Fruit.
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * List of allowable actions that the fruit can perform to the current actor.
     *
     * @param owner the actor that owns the fruit.
     * @return The HealAction that the actor that perform.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new HealAction(this));
        return actions;
    }

}