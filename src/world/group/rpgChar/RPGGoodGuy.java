package world.group.rpgChar;

/**
 * Created by Matthieu on 30/10/2015.
 */
public abstract class RPGGoodGuy extends RPGCharacter {

    public RPGGoodGuy(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
    }

    public RPGGoodGuy(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
    }
}
