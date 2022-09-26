package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import static TicTacToe.MainClass.array;
import static TicTacToe.MainClass.PLAYER1;

public class UtilClass {
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

    static int computerCalculateMove() {
        int random = new Random().nextInt(3);

        switch(random){
            case 0 : if ( !array[0][0].equals(".") )
                        computerCalculateMove();
                     else {
                        array[0][0] = "O";
                        break;
                     }

            case 1 : if ( !array[0][2].equals(".") )
                computerMove();
            case 2 : if ( !array[2][0].equals(".") )
                computerMove();
            case 3 : if ( !array[2][2].equals(".") )
                computerMove();
        }

    }

    static void showGameResults(){
        for(String[] arrayElem: array)
            System.out.println(Arrays.toString(arrayElem));
    }
}