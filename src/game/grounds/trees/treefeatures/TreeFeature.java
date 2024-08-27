package game.grounds.trees.treefeatures;

import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface that represents a feature of a tree.
 *
 * @author Created by: Er Jun Yet and Chew Ken Yang
 */
public interface TreeFeature {

    /**
     * A method that exhibits the feature of the tree.
     * @param location The location of the tree.
     */

    void exhibitFeature(Location location);

}