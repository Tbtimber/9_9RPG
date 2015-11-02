/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;
import java.util.ArrayList;
import java.util.Scanner;

import world.event.RPGEvent;
import world.group.RPGGroup;
import world.tiles.*;
/**
 * 
 * RPGWorld is the class containing the different Tiles and the group (player)
 * It will also be used to play the the game using event returned by the different tiles
 * 
 * @author Matthieu
 * @version %I%, %G%
 * 
 */
public class RPGWorld {
    private static final int WORLD_SIZE = 5; //Must be an odd number !
    private static final int MIDDLE_INDICE = 2; //Value of the middle for the ArrayList containing the WorldTiles ! Is dependant of WORLD_SIZE !
    private ArrayList<ArrayList<WorldTile>> tiles = new ArrayList<ArrayList<WorldTile>>();
    private RPGGroup group;

    /**
     * Constructor for the world:
     * Create a WORLD_SIZE x WORLD_SIZE array of WorldTile
     */
    public RPGWorld() {
        for (int i=0;i<WORLD_SIZE;i++) {
            ArrayList<WorldTile> tempTiles = new ArrayList<WorldTile>();
            for (int j=0;j<WORLD_SIZE;j++) {
                tempTiles.add(this.chooseNewTile());
            }
            this.tiles.add(tempTiles);
        }
        this.group = new RPGGroup();
    }
    /**
     * Function that let the user choose the next displacement (up/right/down/left)
     * and apply the changes to the world
     */
    public void chooseNextDisplacement() {
        int orientation;
        do {
            System.out.println("Where will you go next ? (I:up, L:right, K:down, J:left");
            Scanner sc = new Scanner(System.in);
            char c = sc.nextLine().charAt(0);
            switch (c) {
                case 'I':
                    orientation = 1;
                    break;
                case 'L':
                    orientation = 2;
                    break;
                case 'K':
                    orientation = 3;
                    break;
                case 'J':
                    orientation = 4;
                    break;
                default:
                    orientation = 0;
                    break;
            }
        } while (!this.checkNextDisplacement(orientation));
        this.makeNextDisplacement(orientation);
        this.playNextEvent();
    }

    /**
     * Verify that next move can be made
     * @param direction 1 is up, 2 is right, 3 is down, 4 is left
     * @return false if the next move isn't possible, true if it can
     */
    private boolean checkNextDisplacement(int direction) {
        switch (direction) {
            case 1:
                if (this.tiles.get(MIDDLE_INDICE - 1).get(MIDDLE_INDICE).getBIsSolid()) {
                    return false;
                }
                break;
            case 2:
                if (this.tiles.get(MIDDLE_INDICE).get(MIDDLE_INDICE + 1).getBIsSolid()) {
                    return false;
                }
                break;
            case 3:
                if (this.tiles.get(MIDDLE_INDICE + 1).get(MIDDLE_INDICE).getBIsSolid()) {
                    return false;
                }
                break;
            case 4:
                if (this.tiles.get(MIDDLE_INDICE).get(MIDDLE_INDICE - 1).getBIsSolid()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
    /**
     * Function that actually make the displacement andgenerate the new Tiles
     * @param orientation value of the orientation 1 is up, 2 is right, 3 is down, 4 is left
     */
    private void makeNextDisplacement(int orientation) {
        if (orientation != 1 && orientation != 2 && orientation != 3 && orientation != 4)
            return;
        switch (orientation) {
            case 1: //Up
                ArrayList<WorldTile> tmpTiles = new ArrayList<WorldTile>();
                for(int i=0;i<WORLD_SIZE;i++)  {
                    tmpTiles.add(this.chooseNewTile());
                }
                this.tiles.add(0, tmpTiles);
                this.tiles.remove(this.tiles.size()-1);
                break;
            case 2: //Right
                for(int i=0;i<WORLD_SIZE;i++) {
                    this.tiles.get(i).add(this.chooseNewTile());
                    this.tiles.get(i).remove(0);
                }
                break;
            case 3: //Down
                ArrayList<WorldTile> tmpTiles2 = new ArrayList<WorldTile>();
                for(int i=0;i<WORLD_SIZE;i++)  {
                    tmpTiles2.add(this.chooseNewTile());
                }
                this.tiles.add(tmpTiles2);
                this.tiles.remove(0);
                break;
            case 4: //Left
                for(int i=0;i<WORLD_SIZE;i++) {
                    this.tiles.get(i).add(0, this.chooseNewTile());
                    this.tiles.get(i).remove(this.tiles.get(i).size() -1);
                }
                break;
            default:
        }
    }
    /**
     * Display the current world 
     */
    public void displayWorld() {
        for(int i=0; i<WORLD_SIZE;i++) {
            for(int j=0;j<WORLD_SIZE;j++) {
                if(i==MIDDLE_INDICE && j==MIDDLE_INDICE) {
                    System.out.print("#");
                } else {
                    System.out.print(this.tiles.get(i).get(j).getDisplayChar());
                }
            }
            System.out.println("");
        }
    }
    
    /**
     * Choose a new type of tile for the RPGWorld
     * @return the new tile to ba added to the tiles attribute of the wolrd
     */
    private WorldTile chooseNewTile() {
        //TO DO
        int rand = (int)(Math.random()* WorldTile.NBR_OF_TILE_TYPE);
        switch (rand) {
            case 0:
                return new GrassTile();
            case 1:
                return new RockTile();
            case 2:
                return new SolidRockTile();
        }
        return new GrassTile();
    }

    private void playNextEvent() {
        RPGEvent event = this.tiles.get(MIDDLE_INDICE).get(MIDDLE_INDICE).getTileEvent(this.group);
        event.play();
    }
}
