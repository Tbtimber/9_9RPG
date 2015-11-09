package world.group.rpgChar;

import java.util.ArrayList;

/**
 * Non playable RPGCharacter
 * Created by Matthieu on 30/10/2015.
 */
public abstract class RPGEnemy extends  RPGCharacter {

    public RPGEnemy(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
    }

    public RPGEnemy(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
    }

    @Override
    public void makeFightChoice(ArrayList<RPGCharacter> group) {
        int iter = -1;
        boolean aimFound = false;
        while(iter < group.size() && !aimFound) {
            iter++;
            if((group.get(iter).getClass().getSimpleName() != "Monster") &&(group.get(iter).getClass().getSimpleName() != "Beast") && (group.get(iter).bIsAlive)) {
                aimFound = true;
            }
        }
        if(!aimFound) {
            return;
        } else {
            this.attack(group.get(iter));
        }
    }
}
