package game.actors.hostiles;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.status.Status;

/**
 * Class representing the HuntsmanSpider hostile character.
 *
 * @author Created by: Er Jun Yet
 */
public class HuntsmanSpider extends Hostile {
    /**
     * Constructor.
     *
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(0, new AttackBehaviour());
        this.addCapability(Status.DANGER_TO_PLAYER);
    }

    /**
     * Creates and returns the intrinsic weapon for HuntsmanSpider.
     * @return a freshly-instantiated IntrinsicWeapon of long legs.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "long legs kick", 25);
    }


}
