/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.group;

import world.group.rpgChar.RPGCharacter;

import java.util.ArrayList;

/**
 * Class that represent a group of RPGCharacter
 * Maximum size of the group is 4 RPGCharacter
 * @author Matthieu
 * @see world.group.rpgChar.RPGCharacter
 */
public class RPGGroup {
    public static int GROUP_SIZE_MAX = 5;
    ArrayList <RPGCharacter> group = new ArrayList<RPGCharacter>();

    public void add(RPGCharacter character) {
        this.group.add(character);
    }

    public ArrayList<RPGCharacter> getGroup() {
        return group;
    }

    public boolean isGroupDead() {
        boolean isDead = true;
        for (int i=0;i<this.group.size();i++) {
            if(!this.group.get(i).isDead()){
                isDead = false;
            }
        }
        return isDead;
    }

    public void displayGroup() {
        for(int i=0;i<this.group.size();i++) {
            this.group.get(i).displayChar();
        }
    }

    public void displayGroupStats() {
        for(int i=0;i<this.group.size();i++) {
            this.group.get(i).displayCharStats();
        }
    }
}
