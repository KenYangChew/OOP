package game.grounds.trees;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.trees.treefeatures.GrowthFeature;
import game.grounds.trees.treefeatures.TreeFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a Inheritree.
 *
 * @author Created by: Er Jun Yet
 * @author Modified by: Chew Ken Yang
 */
public abstract class Inheritree extends Ground {
    /**
     * The age of the Inheritree.
     */
    protected int age;

    /**
     * The list of tree features of the Inheritree.
     */
    protected List<TreeFeature> treeFeatures = new ArrayList<>();

    /**
     * Constructor of Inheritree.
     *
     * @param newInheritreeDisplay The representation of Inheritree type to display.
     * @param newAge The age of the Inheritree.
     */
    public Inheritree(char newInheritreeDisplay, int newAge) {
        super(newInheritreeDisplay);
        this.age = newAge;
        this.treeFeatures.add(new GrowthFeature(this));
    }

    /**
     * A method that returns the age of the Inheritree.
     *
     * @return The age of the Inheritree.
     */
    public int getAge(){
        return age;
    }

    /**
     * A method that grows the Inheritree.
     */
    public void grow(){
        age++;
    }

    /**
     * A checking method to check no actor is allowed climb on tree.
     * @param actor the Actor to check
     * @return A false value for any actor that attempt to climb on tree.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * A method that exhibits the tree features of the Inheritree.
     *
     * @param location The location of the Inheritree.
     */
    @Override
    public void tick(Location location) {
        for (TreeFeature treeFeature: treeFeatures){
            treeFeature.exhibitFeature(location);
        }
    }

}