package world.LogFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * LOGFIle system for the game
 * Created by Matthieu on 09/11/2015.
 */
public class SaveData {
    private static final String LOG_PATH = "data.txt";
    private static FileWriter writer;
    private static File file;

    /**
     * Clean the data.txt file for new game log
     */
    public static void init() {
        try {
            file = new File(LOG_PATH);
            writer = new FileWriter(file);
            writer.write(new String("Start of LOGFILE :" + System.getProperty("line.separator")));
        } catch (IOException e) {
            System.out.println("LOG_FILE Error in init.");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Write a new string at the end of file with or without a line return after.
     * @param phrase String to be written in the file
     * @param lineBreak wether or not a line break is made after writing the string in the file
     */
    public static void write(String phrase, boolean lineBreak){
        try {
            file = new File(LOG_PATH);
            writer = new FileWriter(file,true);
            if(lineBreak) {
                writer.write(phrase + System.getProperty("line.separator"));
            } else {
                writer.write(phrase);
            }
        } catch (IOException e) {
            System.out.println("LOG_FILE error in write.");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
