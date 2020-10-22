package de.pxav.kelp.core.event.kelpevent.npc;

import de.pxav.kelp.core.npc.KelpNpc;
import org.bukkit.event.Event;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public abstract class NpcEvent extends Event {

  protected KelpNpc npc;

  public NpcEvent(KelpNpc npc) {
    this.npc = npc;
  }

  public final KelpNpc getNpc() {
    return this.npc;
  }

}
