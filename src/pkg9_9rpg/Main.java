/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg9_9rpg;
import world.RPGWorld;
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
        RPGWorld world = new RPGWorld();
        world.displayWorld();
        while(true) {
            world.chooseNextDisplacement();
            world.displayWorld();
        }
    }
    
}
