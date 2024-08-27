package game.grounds.trees.treefeatures;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.foods.fruits.Fruit;

/**
 * A class that represents a FruitFeature of a tree.
 *
 * @author Created by: Er Jun Yet and Chew Ken Yang
 */
public class FruitFeature implements TreeFeature{
    /**
     * The fruit object to produce.
     */
    private final Fruit fruit;

    /**
     * The fruit production rate of the tree.
     */
    private final double FRUIT_PRODUCTION;

    /**
     * Constructor of FruitFeature.
     *
     * @param fruit The fruit object to produce.
     * @param fruitProductiion The fruit production rate of the tree.
     */
    public FruitFeature(Fruit fruit, double fruitProductiion) {
        this.fruit = fruit;
        this.FRUIT_PRODUCTION = fruitProductiion;
    }

    /**
     * A method that exhibits the fruit feature of the tree.
     *
     * @param location The location of the tree.
     */
    @Override
    public void exhibitFeature(Location location) {
        if (Math.random() <= FRUIT_PRODUCTION){
            for (Exit exit : location.getExits()) {
                Location destination = exit.getDestination();
                destination.addItem(fruit);
                break;
            }
        }
    }
}