package world.group.rpgChar;

import world.rpgObject.RPGObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Matthieu on 30/10/2015.
 */
public abstract class RPGGoodGuy extends RPGCharacter {

    public RPGGoodGuy(int endurance, int intel, int strength, int agility, int velocity) {
        super(endurance, intel, strength, agility, velocity);
    }

    public RPGGoodGuy(int baseLvl, int endurance, int intel, int strength, int agility, int velocity) {
        super(baseLvl, endurance, intel, strength, agility, velocity);
    }

    @Override
    public void makeFightChoice(ArrayList<RPGCharacter> group) {
        Scanner sc = new Scanner(System.in);
        boolean isChoiceGood = false;
        //int choice=0;
        //String choice = "";
        while (!isChoiceGood) {
            try {
                System.out.println("Choose an action:\n\tAttack : 1\n\tDefend : 2\n\tWait : 3");
                int choice=-1;
                if(sc.hasNextInt()) {
                    choice = sc.nextInt();
                }
                switch (choice) {
                    case 1:
                        isChoiceGood = true;
                        System.out.print("You choose to attack ");
                        this.attack(this.chooseChar(group));
                        break;
                    case 2:
                        isChoiceGood = true;
                        System.out.println("You choose to defend.");
                        this.defend();
                        break;
                    case 3:
                        isChoiceGood = true;
                        System.out.println("Waiting ...");
                        break;
                    default:
                        System.out.println("Wrong input...");
                        isChoiceGood = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input...");
                isChoiceGood = false;
                sc.next();
            }
        }
    }

    private RPGCharacter chooseChar(ArrayList<RPGCharacter> group) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("which character ? (enter ID of the character you want to attack)");
            for(int i=0;i<group.size();i++) {
                System.out.println("ID: "+ i);
                group.get(i).displayChar();
            }
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input !");
                choice = -1;
                sc.next();
            }
        } while (!(choice < group.size() && choice >= 0));
        return group.get(choice);
    }

    public void drinkPotion(RPGObject potion) {

    }
}
