package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UtilClass {
    static String PLAYER1;

    static void enterName() {
        String name = "No name";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            name = reader.readLine();
        } catch (IOException tc){
            System.out.println("Ошибка ввода имени !");
            tc.printStackTrace();
        }
        PLAYER1 = name;
    }

    void showGameResults(){
        Arrays.stream(array).forEach(elem -> System.out.println(Arrays.toString(elem)));
    }
}