package game.grounds.trees.treefeatures;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.trees.Inheritree;

/**
 * A class that represents a GrowthFeature of a tree.
 *
 * @author Created by: Er Jun Yet and Chew Ken Yang
 */
public class GrowthFeature implements TreeFeature{
    /**
     * The Inheritree object that represents the tree.
     */
    private Inheritree inheritree;

    /**
     * Constructor of GrowthFeature.
     *
     * @param inheritree The Inheritree object that represents the tree.
     */
    public GrowthFeature(Inheritree inheritree) {
        this.inheritree = inheritree;
    }

    /**
     * A method that exhibits the growth feature of the tree.
     *
     * @param location The location of the tree.
     */
    @Override
    public void exhibitFeature(Location location) {
        inheritree.grow();
    }

}