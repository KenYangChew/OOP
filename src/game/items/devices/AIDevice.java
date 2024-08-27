package game.items.devices;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ListenAction;
import game.items.scraps.Purchasable;
import game.status.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents an AI device that can provide monologues to the player.
 * @author Created by: Ang Qiao Xin
 */
public class AIDevice extends Item implements Purchasable, Narratable{
    private static final int SUBSCRIPTION_FEE_INTERVAL = 5;
    private static final int SUBSCRIPTION_FEE = 1;
    private static final int MIN_ITEMS_FOR_MONOLOGUE = 10;
    private static final int MIN_BALANCE_FOR_MONOLOGUE = 50;
    private static final int LOW_HEALTH_THRESHOLD = 2;
    private final int PRICE;
    private int ticksSinceLastFee = 0;
    private boolean activeSubscription = true;

    private List<Monologue> monologues;

    /**
     * Constructor for AIDevice.
     */
    public AIDevice() {
        super("Astley, an AI device", 'z', true);
        this.PRICE = 50;
        this.monologues = initializeMonologues();
    }

    /**
     * Method to initialize the monologues that the AI device can provide.
     * @return A list of monologues.
     */
    private List<Monologue> initializeMonologues() {
        List<Monologue> initialMonologues = new ArrayList<>();
        initialMonologues.add(new Monologue("The factory will never gonna give you up, valuable intern!", Condition.NONE, 0));
        initialMonologues.add(new Monologue("We promise we never gonna let you down with a range of staff benefits.", Condition.NONE, 0));
        initialMonologues.add(new Monologue("We never gonna run around and desert you, dear intern!", Condition.NONE, 0));
        initialMonologues.add(new Monologue("We never gonna make you cry with unfair compensation.", Condition.MIN_ITEMS, MIN_ITEMS_FOR_MONOLOGUE));
        initialMonologues.add(new Monologue("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.", Condition.MIN_BALANCE, MIN_BALANCE_FOR_MONOLOGUE));
        initialMonologues.add(new Monologue("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.", Condition.LOW_HEALTH, LOW_HEALTH_THRESHOLD));
        return initialMonologues;
    }

    /**
     * Method to check if the subscription of the AI device is active.
     * @return True if the subscription is active, false otherwise.
     */
    public boolean isActiveSubscription() {
        return activeSubscription;
    }

    /**
     * Method to set the monologues that the AI device can provide.
     * @param newMonologues The new list of monologues.
     */
    public void setMonologues(List<Monologue> newMonologues) {
        this.monologues = new ArrayList<>(newMonologues);
    }

    /**
     * Method to update the subscription status of the AI device.
     * @param currentLocation The current location of the AI device.
     * @param actor The actor that is interacting with the AI device.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            ticksSinceLastFee++;
            if (ticksSinceLastFee % SUBSCRIPTION_FEE_INTERVAL == 0) {
                if (actor.getBalance() >= SUBSCRIPTION_FEE){
                    activeSubscription = true;
                    actor.deductBalance(SUBSCRIPTION_FEE);
                    System.out.println("Subscription payment received!");
                }
                else{
                    activeSubscription = false;
                    System.out.println("Subscription paused due to insufficient funds!");
                }
            }
        }
    }

    /**
     * Method to get the monologues that the AI device can provide.
     * @param actor The actor that is interacting with the AI device.
     * @return A list of monologues.
     */
    @Override
    public List<Monologue> getMonologues(Actor actor) {
        return new ArrayList<>(monologues);
    }

    /**
     * Method to get the price of the AI device.
     * @return The price of the AI device.
     */
    @Override
    public int getBuyPrice() {
        return PRICE;
    }

    /**
     * Method to process the payment for the AI device.
     * @return True if the payment is successful, false otherwise.
     */
    @Override
    public boolean buyProcess() {
        return true;
    }

    /**
     * Method to get the actions that the player can perform on the AI device.
     * @param owner The actor that is interacting with the AI device.
     * @return A list of actions that the player can perform on the AI device.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        if (isActiveSubscription()) {
            actions.add(new ListenAction(this));
        }
        return actions;
    }

}
