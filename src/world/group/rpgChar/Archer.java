package world.group.rpgChar;

import world.group.rpgChar.behaviour.AgilityFight;

/**
 * Created by Matthieu on 02/11/2015.
 */
public class Archer extends RPGGoodGuy {
    public Archer() {
        super(10, 4, 7, 15, 10);
        this.fightStyle = new AgilityFight();
    }

    public Archer(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
        this.fightStyle = new AgilityFight();
    }

    public Archer(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
        this.fightStyle = new AgilityFight();
    }
}
