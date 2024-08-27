package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.StealAction;

import java.util.List;
import java.util.Random;

/**
 * A class that figures out a StealAction that will steal an item from the ground.
 *
 * @author Created by: Er Jun Yet and Ang Qiao Xin
 */
public class StealBehaviour implements Behaviour {
    /**
     * AttackAction to be obtained from the AttackBehaviour.
     * @param actor the Actor exhibiting the AttackBehaviour
     * @param map the GameMap containing the Actor
     * @return The AttackAction that can be performed.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<Item> items = map.locationOf(actor).getItems();
        if (!items.isEmpty()) {
            Random random = new Random();
            Item randomItem = items.get(random.nextInt(items.size()));
            return new StealAction(randomItem);
        }
        return null;
    }
}