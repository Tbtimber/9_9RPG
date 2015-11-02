package world.group.rpgChar;

/**
 * Created by Matthieu on 02/11/2015.
 */
public class Warrior extends RPGGoodGuy {

    public Warrior()  {
        super(10, 3, 15, 5, 10);
    }
    public Warrior(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
    }

    public Warrior(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
    }
}
