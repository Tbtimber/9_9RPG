package world.event;

import world.LogFile.SaveData;
import world.group.RPGGroup;

/**
 * NoEvent is the neutral event (nothing happens in it)
 * @author Matthieu
 * @see RPGEvent
 */

public class NoEvent extends RPGEvent {



    public NoEvent(RPGGroup group) {
        super(group);
    }
    @Override
    public void play() {
        System.out.println("Nothing happens ...");
        SaveData.write("\tNothing happened in this tile !",true);
    }
}
