package game.grounds.trees;

import game.grounds.trees.treefeatures.MatureFeature;

/**
 * A class that represents a sprout Inheritree.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Chew Ken Yang
 */
public class Sprout extends Inheritree {
    /**
     * The growth limit of the sprout.
     */
    private final int GROWTH_LIMIT;

    /**
     * Constructor of sprout Inheritree.
     */
    public Sprout() {
        super(',', 0);
        this.GROWTH_LIMIT = 3;
        this.treeFeatures.add(new MatureFeature(this, new Sapling(), GROWTH_LIMIT));
    }


}