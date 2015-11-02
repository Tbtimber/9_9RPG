package world.group.rpgChar;

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
}
