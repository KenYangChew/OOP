package game.items.devices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;
import game.grounds.computer.Teleportation;
import game.items.scraps.Purchasable;

/**
 * Theseus class that represents a Theseus teleportation device.
 * @author Created by: Er Jun Yet
 */
public class Theseus extends Item implements Purchasable, Teleportation{
    /**
     * The price of the Theseus teleportation device.
     */
    private final int PRICE;

    /**
     * Constructor.
     */
    public Theseus() {
        super("Theseus", '^', true);
        this.PRICE = 100;
    }

    /**
     * Returns a list of teleport locations that the actor can teleport to.
     * @param currentLocation The current location of the actor.
     * @return A list of teleport locations that the actor can teleport to.
     */
    @Override
    public List<Entry<String, Location>> teleportLocation(Location currentLocation) {
        List<Entry<String, Location>> teleportLocations = new ArrayList<>();

        while (teleportLocations.size() < 1){
            Random random = new Random();
            int randomX = random.nextInt(currentLocation.map().getXRange().max() + 1);
            int randomY = random.nextInt(currentLocation.map().getYRange().max() + 1);
            String newCoordinate = "(" + randomX + ", " + randomY + ")";

            Location newLocation = currentLocation.map().at(randomX, randomY);
            if (!newLocation.containsAnActor()){
                Entry<String, Location> teleportLocation = Map.entry(newCoordinate, newLocation);
                teleportLocations.add(teleportLocation);
            }
        }

        return teleportLocations;
    }

    /**
     * Returns the name of the teleportation device.
     * @return The name of the teleportation device.
     */
    @Override
    public String getTeleportDevice() {
        return this.toString();
    }

    /**
     * Returns the price of the teleportation device.
     * @return The price of the teleportation device.
     */
    @Override
    public int getBuyPrice() {
        return PRICE;
    }

    /**
     * Returns true if the payment process is successful.
     * @return True if the payment process is successful.
     */
    @Override
    public boolean buyProcess() {
        return true;
    }

    /**
     * Returns a list of allowable actions that the actor can perform with the teleportation device.
     * @param location The location of the actor.
     * @return A list of allowable actions that the actor can perform with the teleportation device.
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = new ActionList();

        List<Entry<String, Location>> teleportLocations = teleportLocation(location);
        for (Entry<String, Location> teleportLocation : teleportLocations){
            actions.add(new TeleportAction(this, teleportLocation));
        }

        return actions;
    }

}
