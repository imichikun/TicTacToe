package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import static TicTacToe.MainClass.*;

public class UtilClass {
    static BufferedReader nameReader;

    static void enterName() {
        String name = "No name";
        nameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            name = nameReader.readLine();
        } catch (IOException tc){
            System.out.println("Ошибка ввода имени !");
            tc.printStackTrace();
        }
        PLAYER1 = name;
    }

    static void showGameResults(){
        for(String[] arrayElem: array)
            System.out.println(Arrays.toString(arrayElem));
    }

    static void closeReadThread(){
        try {
            GameClass.reader.close();
            nameReader.close();
        } catch(IOException ioe){
            System.out.println("Ошибка при закрытии потока ввода данных игрока");
            ioe.printStackTrace();
        }
    }
}