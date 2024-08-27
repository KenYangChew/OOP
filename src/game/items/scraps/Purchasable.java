package game.items.scraps;

/**
 * An interface representing items that can be purchased in the game.
 * @author Created by: Ang Qiao Xin
 * @author Modified by: Gan Ruiqi
 */
public interface Purchasable {

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    int getBuyPrice();

    /**
     * Processes the payment for the item.
     *
     * @return true if the payment process is successful, false otherwise
     */
    boolean buyProcess();


}
