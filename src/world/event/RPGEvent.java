/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.event;

import world.group.RPGGroup;

/**
 * RPGEvent is the abstract class of the different inGame Event that can be return by a WorldTile when a group go through
 * It takes the player group in its constructor
 * @author Matthieu
 * @see world.tiles.WorldTile
 * @see RPGGroup
 */
public abstract class RPGEvent {

    public static final int NBR_EVENT = 2;// Number of event types
    protected RPGGroup group;

    public RPGEvent(RPGGroup group) {
        this.group = group;
    }
    public abstract void play();
}
