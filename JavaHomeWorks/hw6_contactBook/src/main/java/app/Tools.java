package hw6_contactBook.src.main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static String readConsole(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void closeConsole(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
