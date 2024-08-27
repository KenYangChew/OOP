package game.items.devices;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.List;

/**
 * An interface for items that can narrate a story.
 * @author Created by: Ang Qiao Xin
 */
public interface Narratable {
    List<Monologue> getMonologues(Actor actor);
}
