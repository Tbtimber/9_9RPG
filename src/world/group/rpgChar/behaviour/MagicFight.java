package world.group.rpgChar.behaviour;

import world.LogFile.SaveData;
import world.event.Fight;
import world.group.rpgChar.RPGCharacter;

/**
 * Created by Matthieu on 02/11/2015.
 */
public class MagicFight implements FightStyle {
    private final static double DAMAGE_MULT = 2.5;
    private final static double DEFENSE_MULT = 1;
    @Override
    public void attack(RPGCharacter attacker,RPGCharacter defender) {
        double damageTemp = attacker.getStats().getIntel()*DAMAGE_MULT;
        damageTemp -= defender.getStats().getIntel()*DEFENSE_MULT;
        defender.receiveAttack((int)damageTemp);
        SaveData.write(attacker.getClass().getSimpleName() + " dealt " + damageTemp + " damage to " + defender.getClass().getSimpleName(), true);

    }

    @Override
    public void defend(RPGCharacter defender) {
        SaveData.write(defender.getClass().getSimpleName() + " is defending !", true);
    }
}
