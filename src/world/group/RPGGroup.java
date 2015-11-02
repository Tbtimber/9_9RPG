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
}
