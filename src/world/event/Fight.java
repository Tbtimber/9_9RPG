/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.event;

import world.group.RPGGroup;

/**
 * Fight is a RPGEvent that will play a fight between the player group and an enemy group
 * it generates within the class.
 * @author Matthieu
 * @see RPGEvent
 * @see RPGGroup
 */
public class Fight extends RPGEvent {
    private RPGGroup enemies;
    public Fight(RPGGroup group) {
        super(group);
        this.enemies = this.generateOpponent();
    }
    @Override
    public void play() {
        System.out.println("Fight starts !");
    }

    /**
     * Function that will generate the enemie group for the fight
     */
    private RPGGroup generateOpponent() {
        return new RPGGroup();
    }
}
