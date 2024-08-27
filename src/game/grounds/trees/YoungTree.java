package game.grounds.trees;

import game.grounds.trees.treefeatures.MatureFeature;

/**
 * A class that represents a young Inheritree.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Chew Ken Yang
 */
public class YoungTree extends Inheritree {
    /**
     * The growth limit of the young tree.
     */
    private final int GROWTH_LIMIT;

    /**
     * Constructor of young Inheritree.
     */
    public YoungTree() {
        super('y', 9);
        this.GROWTH_LIMIT = 14;
        this.treeFeatures.add(new MatureFeature(this, new OldTree(), GROWTH_LIMIT));
    }


}