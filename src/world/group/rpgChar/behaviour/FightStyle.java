package world.group.rpgChar.behaviour;

import world.group.rpgChar.RPGCharacter;

/**
 * Interface for the different fighting style
 * Created by Matthieu on 02/11/2015.
 */
public interface FightStyle {
    public void attack(RPGCharacter attacker,RPGCharacter defender);
    public void defend(RPGCharacter defender);
}
