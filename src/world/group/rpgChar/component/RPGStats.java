package world.group.rpgChar.component;

/**
 * Contains the stats of a character
 * Created by Matthieu on 01/11/2015.
 */
public class RPGStats {
    private static final double VEL_MULT = 0.5;
    private int endurence;
    private int intel;
    private int strength;
    private int velocity;
    private int agility;

    public int getEndurence() {
        return endurence;
    }

    public int getIntel() {
        return intel;
    }

    public int getStrength() {
        return strength;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getAgility() {
        return agility;
    }

    public RPGStats(int endurence, int intel, int strength, int agility, int velocity) {
        this.endurence = endurence;
        this.intel = intel;
        this.strength = strength;
        this.agility = agility;
        this.velocity = velocity + (int)(this.agility*VEL_MULT);
    }
}
