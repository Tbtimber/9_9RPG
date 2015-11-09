package world.group.rpgChar;

import world.group.rpgChar.behaviour.FightStyle;
import world.group.rpgChar.behaviour.StrengthFight;
import world.group.rpgChar.component.ComponentExceptions;
import world.group.rpgChar.component.ExpBar;
import world.group.rpgChar.component.LifeBar;
import world.group.rpgChar.component.RPGStats;

import java.util.ArrayList;

/**
 * Created by Matthieu on 30/10/2015.
 */
public abstract class RPGCharacter {
    protected RPGStats stats;
    protected LifeBar lifeBar;
    protected ExpBar expBar;
    protected boolean bIsAlive;
    protected FightStyle fightStyle;




    /**
     * Constructor of a level 1 with Strength fight
     * @param endurance endurance value
     * @param intel intel value
     * @param strength strength value
     * @param agility agility value
     * @param velocity velocity value
     */
    public RPGCharacter(int endurance, int intel, int strength, int agility, int velocity) {
        this.stats = new RPGStats(endurance, intel,strength,agility,velocity);
        this.lifeBar = new LifeBar((this.stats.getEndurence()+ (int)(this.stats.getStrength()*0.5))*LifeBar.ENDU_MULT );
        this.expBar = new ExpBar(1);
        this.bIsAlive = true;
        this.fightStyle = new StrengthFight();
    }
    /**
     *
     * Constructor of a level 1 with Strength fight
     * @param baseLvl baseLvl of the character created
     * @param endurance endurance value
     * @param intel intel value
     * @param strength strength value
     * @param agility agility value
     * @param velocity velocity value
     */
    public RPGCharacter(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        this.stats = new RPGStats(endurance, intel,strength,agility,velocity);
        this.lifeBar = new LifeBar(this.stats.getEndurence()*LifeBar.ENDU_MULT);
        this.expBar = new ExpBar(baseLvl);
        this.bIsAlive = true;
        this.fightStyle = new StrengthFight();
    }
    public abstract void makeFightChoice(ArrayList<RPGCharacter> group);


    public void attack(RPGCharacter defender) {
        this.fightStyle.attack(this,defender);
    }
    public void defend() {
        this.fightStyle.defend(this);
    }
    public void receiveAttack(int damageValue) {
        try {
            this.lifeBar.decrease(damageValue);
        } catch (ComponentExceptions e) {
            this.bIsAlive = false;
        }
    }
    public void receiveHeal(int healValue) {
        try {
            this.lifeBar.increase(healValue);
        } catch (ComponentExceptions e) {
            if (this.bIsAlive) {
                System.out.println("Player is already full life");
            } else {
                System.out.println("Player is dead");
            }
        }
    }

    public RPGStats getStats() {
        return stats;
    }

    public boolean isDead() {
        return !bIsAlive;
    }

    public void displayChar() {
        System.out.println(this.getClass().getSimpleName());
        this.lifeBar.display();
    }

}
