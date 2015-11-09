/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.event;

import world.RPGWorld;
import world.group.RPGGroup;
import world.group.rpgChar.Beast;
import world.group.rpgChar.Monster;
import world.group.rpgChar.RPGCharacter;
import world.group.rpgChar.Warrior;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Fight is a RPGEvent that will play a fight between the player group and an enemy group
 * it generates within the class.
 * @author Matthieu
 * @see RPGEvent
 * @see RPGGroup
 */
public class Fight extends RPGEvent {
    private RPGGroup enemies;
    private ArrayList<RPGCharacter> fullGroup = new ArrayList<RPGCharacter>();
    public Fight(RPGGroup group) {
        super(group);
        this.enemies = this.generateOpponent();
        for(int i=0; i< this.group.getGroup().size();i++) {
            this.fullGroup.add(this.group.getGroup().get(i));
        }
        for(int i=0;i<this.enemies.getGroup().size() ; i++) {
            this.fullGroup.add(this.enemies.getGroup().get(i));
        }
        this.findOrder();
    }
    @Override
    public void play() {
        int iter=0;
        System.out.println("Fight starts !");

        while ((!this.group.isGroupDead()) && (!this.enemies.isGroupDead())){
            System.out.println("---------------------Current Character----------------------");
            this.fullGroup.get(iter).displayChar();
            if(!this.fullGroup.get(iter).isDead()) {
                this.fullGroup.get(iter).makeFightChoice(this.fullGroup);
            }
            iter++;
            iter %= this.fullGroup.size();
        }
        if(this.group.isGroupDead()) {
            System.out.println("GAME OVER !");
        } else {
            System.out.println("End of the fight !");
        }

    }

    /**
     * Function that will generate the enemie group for the fight
     */
    private RPGGroup generateOpponent() {
        RPGGroup ennemies = new RPGGroup();
        if(RPGWorld.getMiddletile().getClass().getSimpleName() == new String("GrassTile")) {
            ennemies.add(new Beast());
            ennemies.add(new Beast());
            ennemies.add(new Beast());
            ennemies.add(new Beast());
        } else {
            ennemies.add(new Monster());
            ennemies.add(new Monster());
            ennemies.add(new Monster());
            ennemies.add(new Monster());
        }
        return ennemies;
    }

    private void findOrder() {
        Collections.sort(this.fullGroup, new FightSorter());
    }
}
