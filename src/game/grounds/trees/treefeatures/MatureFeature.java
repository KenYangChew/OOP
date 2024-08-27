package game.grounds.trees.treefeatures;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.trees.Inheritree;

/**
 * A class that represents a MatureFeature of a tree.
 *
 * @author Created by: Er Jun Yet and Chew Ken Yang
 */
public class MatureFeature implements TreeFeature{
    private Inheritree immatureTree;
    /**
     * The ImmatureTree object that represents the tree.
     */
    private Inheritree matureTree;

    /**
     * The growth limit of the tree.
     */
    private final int GROWTH_LIMIT;

    /**
     * Constructor of MatureFeature.
     *
     * @param immatureTree The ImmatureTree object that represents the tree.
     * @param growthLimit The growth limit of the tree.
     */
    public MatureFeature(Inheritree immatureTree, Inheritree matureTree, int growthLimit){
        this.immatureTree = immatureTree;
        this.matureTree = matureTree;
        this.GROWTH_LIMIT = growthLimit;

    }

    /**
     * A method that exhibits the mature feature of the tree.
     *
     * @param location The location of the tree.
     */
    @Override
    public void exhibitFeature(Location location) {
        if (immatureTree.getAge() >= GROWTH_LIMIT){
            location.setGround(matureTree);
        }
    }
}