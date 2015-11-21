package world.event;

import world.group.rpgChar.RPGCharacter;

import java.util.Comparator;

/**
 * Sort the ArrayList of RPGCharacter by decreasing value of velocity in order to determinate fight order
 * Created by Matthieu on 09/11/2015.
 */
public class FightSorter implements Comparator<RPGCharacter>{

    @Override
    public int compare(RPGCharacter o1, RPGCharacter o2) {
        int vel1 = o1.getStats().getVelocity();
        int vel2 = o2.getStats().getVelocity();

        //Return 1 if o1 if faster than o2 and -1 if o2 is faster !
        return (vel1 > vel2) ? -1: (vel1 < vel2) ? 1 :0;
    }
}
