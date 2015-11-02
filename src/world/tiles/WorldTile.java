
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.tiles;

import world.event.*;
import world.group.RPGGroup;

/**
 * It is the abstract class of a Tile. A tile is a square that may be solid or not (group can go through it)
 * It will also generate a RPGEvent in the case of a group going through
 * @author Matthieu
 * @see RPGEvent
 */


public abstract class WorldTile {
    public final static int NBR_OF_TILE_TYPE = 3;
    protected boolean bIsSolid;
    protected char displayChar;

    /**
     * Constructor of a Tile
     * @param bIsSolid is the Tile "crossable"
     * @param displayChar The character use to display the tile (graphics purpose)
     */
    public WorldTile(boolean bIsSolid, char displayChar) {
        this.bIsSolid = bIsSolid;
        this.displayChar = displayChar;
    }
    public char getDisplayChar() {
        return displayChar;
    }

    public boolean getBIsSolid() {
        return this.bIsSolid;
    }

    /**
     * Return a RPGEvent of the tiles (each tile may have different event thus the abstract method)
     * @param group group that will do the RPGEvent (usually the player group)
     * @return return the RPGEvent object created
     */
    public abstract RPGEvent getTileEvent(RPGGroup group);
}
