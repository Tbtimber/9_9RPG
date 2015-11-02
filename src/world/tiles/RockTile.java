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
 * RockTile is not solid (group can go through)
 * It will be able to generate any event (Fight will have specfic monster)
 * @author Matthieu
 * @see WorldTile
 * @see RPGEvent
 */

public class RockTile extends WorldTile {

    public RockTile() {
        super(false,'*');
    }

    @Override
    public RPGEvent getTileEvent(RPGGroup group) {
        int rand = (int)(Math.random()* RPGEvent.NBR_EVENT);
        switch (rand) {
            case 0:
                return new Fight(group);
            case 1:
                return new NoEvent(group);
            default:
                System.out.println("Error in WorldTile.getTileEvent()");
                return null;
        }
    }
}
