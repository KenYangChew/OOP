package game.grounds.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.BuyAction;
import game.actions.TeleportAction;
import game.items.devices.AIDevice;
import game.items.devices.Theseus;
import game.items.scraps.Purchasable;
import game.items.weapons.DragonSlayerSword;
import game.items.foods.EnergyDrink;
import game.items.scraps.ToiletPaperRoll;


import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * A class that represents Terminal that allow player to purchase items .
 *
 * @author Created by: Chew Ken Yang and Ang Qiao Xin
 * @author Modified by: Er Jun Yet
 */
public class Terminal extends Ground implements Teleportation {
    /**
     * A list of purchasable items available at the terminal.
     */
    private List<Purchasable> purchasableItems;

    /**
     * A map of terminal stations that the actor can teleport to.
     */
    private TerminalControlCentre controlCentre;

    /**
     * Constructor for the Terminal.
     * Initializes the terminal with purchasable items and terminal stations all over the world.
     * @param controlCentre a terminal control centre that manages all teleports
     */
    public Terminal(TerminalControlCentre controlCentre) {
        super('=');
        this.controlCentre = controlCentre;
        this.purchasableItems = setUpPurchasableItems();
    }

    /**
     * Sets up the list of purchasable items available at the terminal.
     *
     * @return a list of purchasable items
     */
    public List<Purchasable> setUpPurchasableItems() {
        List<Purchasable> purchasableItems = new ArrayList<>();
        purchasableItems.add(new EnergyDrink());
        purchasableItems.add(new DragonSlayerSword());
        purchasableItems.add(new ToiletPaperRoll());
        purchasableItems.add(new Theseus());
        purchasableItems.add(new AIDevice());
        return purchasableItems;
    }

    /**
     * Returns a list of teleport locations that the actor can teleport to.
     *
     * @param currentLocation The current location of the actor.
     * @return A list of teleport locations that the actor can teleport to.
     */
    @Override
    public List<Entry<String, Location>> teleportLocation(Location currentLocation) {
        return controlCentre.teleportManagement(currentLocation);
    }

    /**
     * Returns the name of the teleportation device.
     *
     * @return The name of the teleportation device.
     */
    @Override
    public String getTeleportDevice() {
        return "Terminal";
    }

    /**
     * Determines the actions that are allowable for an actor at the terminal location.
     *
     * @param actor the actor performing the actions
     * @param location the location of the terminal
     * @param direction the direction of the actor relative to the terminal
     * @return a list of allowable actions for the actor at the terminal
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        List<Entry<String, Location>> teleportLocations = teleportLocation(location);
        for (Entry<String, Location> teleportLocation : teleportLocations){
            actions.add(new TeleportAction(this, teleportLocation));
        }

        for (Exit exit : location.getExits()){
            Location destination= exit.getDestination();
            if (destination.containsAnActor()) {
                for (Purchasable purchasableItem : purchasableItems){
                    actions.add(new BuyAction(purchasableItem, purchasableItem.getBuyPrice()));
                }
                return actions;
            }
        }
        return null;
    }

    /**
     * Determines whether an actor can enter the terminal location.
     *
     * @param actor the actor trying to enter
     * @return true if the actor can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}


