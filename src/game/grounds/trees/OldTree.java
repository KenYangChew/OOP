package game.grounds.trees;

import game.grounds.trees.treefeatures.FruitFeature;
import game.items.foods.fruits.LargeFruit;

/**
 * A class that represents a old Inheritree.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Chew Ken Yang
 */
public class OldTree extends Inheritree {
    /**
     * The fruit production of the old tree.
     */
    private final double FRUIT_PRODUCTION = 0.3;

    /**
     * Constructor of old Inheritree.
     */

    public OldTree() {
        super('T', 14);
        this.treeFeatures.add(new FruitFeature(new LargeFruit(), FRUIT_PRODUCTION));
    }


}