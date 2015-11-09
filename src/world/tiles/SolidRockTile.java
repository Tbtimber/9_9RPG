/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.tiles;

import world.event.Fight;
import world.event.NoEvent;
import world.event.RPGEvent;
import world.group.RPGGroup;

/**
 * Represent the solid Rock tile. A group will not be able to go through it
 * and it will only generate a NoEvent RPGEvent
 * @author Matthieu
 * @see WorldTile
 * @see NoEvent
 */
public class SolidRockTile extends WorldTile {

    public SolidRockTile() {
        super(true,'\u2588');
    }
    public RPGEvent getTileEvent(RPGGroup group) {
        return new NoEvent(group);
    }
}
