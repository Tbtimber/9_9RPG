package world.group.rpgChar;

import world.group.rpgChar.behaviour.MagicFight;

/**
 * Created by Matthieu on 02/11/2015.
 */
public class Mage extends RPGGoodGuy {
    public Mage() {
        super(10, 15, 2, 8, 10);
        this.fightStyle = new MagicFight();
    }

    public Mage(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
        this.fightStyle = new MagicFight();
    }

    public Mage(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
        this.fightStyle = new MagicFight();
    }
}
