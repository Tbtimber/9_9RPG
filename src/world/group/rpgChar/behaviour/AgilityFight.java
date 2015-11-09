package world.group.rpgChar.behaviour;

import world.group.rpgChar.RPGCharacter;

/**
 * Created by Matthieu on 02/11/2015.
 */
public class AgilityFight implements FightStyle {
    private final static double DAMAGE_MULT = 2.5;
    private final static double DEFENSE_MULT = 1;
    @Override
    public void attack(RPGCharacter attacker, RPGCharacter defender) {
        double damageTemp = attacker.getStats().getAgility()*DAMAGE_MULT;
        damageTemp -= defender.getStats().getAgility()*DEFENSE_MULT;
        defender.receiveAttack((int)damageTemp);
    }

    @Override
    public void defend(RPGCharacter defender) {

    }
}
