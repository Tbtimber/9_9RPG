package world.LogFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Matthieu on 09/11/2015.
 */
public class SaveData {
    private static String path = "data.txt";
    private static File file;
    private static FileWriter writer;


    public static void write(String phrase){

        try {
            file = new File(path);
            writer = new FileWriter(file,true);
            writer.write(phrase+"\n");

        } catch (IOException e) {
            System.out.println("It is not possible to create the file");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
