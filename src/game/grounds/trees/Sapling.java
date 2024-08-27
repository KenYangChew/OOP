package game.grounds.trees;

import game.grounds.trees.treefeatures.FruitFeature;
import game.grounds.trees.treefeatures.MatureFeature;
import game.items.foods.fruits.SmallFruit;

/**
 * A class that represents a sapling Inheritree.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Chew Ken Yang
 */
public class Sapling extends Inheritree{
    /**
     * The growth limit of the sapling.
     */
    private final int GROWTH_LIMIT;

    /**
     * The fruit production of the sapling.
     */
    private final double FRUIT_PRODUCTION = 0.3;

    /**
     * Constructor of sapling Inheritree.
     */
    public Sapling() {
        super('t', 3);
        this.GROWTH_LIMIT = 9;
        this.treeFeatures.add(new MatureFeature(this, new YoungTree(), GROWTH_LIMIT));
        this.treeFeatures.add(new FruitFeature(new SmallFruit(), FRUIT_PRODUCTION));
    }

}