/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg9_9rpg;
import world.LogFile.SaveData;
import world.RPGWorld;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Matthieu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int turn = 0;
        RPGWorld world = new RPGWorld();
        SaveData.init();
        boolean isGameOver = false;
        Scanner sc = new Scanner(System.in);
        while(!isGameOver) {
            turn++;
            world.displayWorld();
            System.out.println("What do you want to do ?\n\t 1: Move\n\t 2: Display team status\n\t 3: Stop Playing");
            int choice=0;
            try  {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input ...");
                sc.next();
            }
            SaveData.write("Turn " + turn + " : ", false);
            switch (choice) {
                case 1:
                    world.chooseNextDisplacement();

                    break;
                case 2:
                    world.getGroup().displayGroupStats();
                    SaveData.write("Displayed team status.", true);
                    break;
                case 3:
                    isGameOver = true;
                    SaveData.write("Ended the game.", true);
                    break;
                default:
                    break;
            }
            if(world.getGroup().isGroupDead()) {
                isGameOver = true;
                System.out.println("You are dead !");
                SaveData.write("Group is dead ! Game Over", true);
            }
        }
        System.out.println("End of the game .... ");
        SaveData.write("End of this party ...", false);
    }
    
}
