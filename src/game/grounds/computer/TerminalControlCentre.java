package game.grounds.computer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A TerminalControlCentre class that manages the teleportation system of each terminal.
 * @author Created by: Er Jun Yet
 */
public class TerminalControlCentre {
    /**
     * A map of terminal stations for actor to teleport.
     */
    private Map<String, Location> terminalSystem;

    /**
     * Constructor.
     */
    public TerminalControlCentre() {
        this.terminalSystem = new HashMap<>();
    }

    /**
     * Updates the terminal system with the new terminal setup.
     * @param terminalName The name of the terminal.
     * @param terminalLocation The location of the teleport platform of the terminal.
     */
    public void updateTerminalSystem(String terminalName, Location terminalLocation) {
        terminalSystem.put(terminalName, terminalLocation);
    }

    /**
     * Checks if the teleport is valid when the teleport is from the current terminal to the other terminal.
     * @param currentTerminal The current terminal location.
     * @param otherTerminal The other terminal location.
     * @return true if the teleport is valid, false otherwise.
     */
    private boolean isValidTeleport(Location currentTerminal, Location otherTerminal) {
        return (otherTerminal.map() != currentTerminal.map() && !otherTerminal.containsAnActor());
    }

    /**
     * Returns a list of teleport terminals that the actor can teleport to.
     * @param currentTerminal The current terminal location.
     * @return A list of teleport terminals that the actor can teleport to.
     */
    public List<Entry<String, Location>> teleportManagement(Location currentTerminal) {
        List<Entry<String, Location>> teleportTerminals = new ArrayList<>();
        for (Entry<String, Location> terminal : terminalSystem.entrySet()) {
            Location otherTerminal = terminal.getValue();
            if (isValidTeleport(currentTerminal, otherTerminal)) {
                Entry<String, Location> validTeleport = Map.entry(terminal.getKey(), otherTerminal);
                teleportTerminals.add(validTeleport);
            }
        }
        return teleportTerminals;
    }

}
