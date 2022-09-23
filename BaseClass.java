package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaseClass {
    private static int[][] arrayMock = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static String[][] array = new String[3][3];
    private static String PLAYER1;
    private static String PLAYER2 = "Computer";

    public static void main(String[] args) {
        System.out.print("Пожайлуста, введите своё имя: ");
//        enterName();
        System.out.println("Первому игроку " + PLAYER1 + " приготовиться!");
        System.out.println("Вы играете крестиками, сделайте свой ход на клетку от 1 до 9");
        Arrays.stream(arrayMock).forEach(elem -> System.out.println(Arrays.toString(elem)));
        System.out.print("Введите свой ход: ");
        makeMove();
    }

    private static void enterName() {
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

    private static void makeMove() {
        int number = 0;

        try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in)))
        {
            String move = reader2.readLine();
            number = checkTheNumberOfMove(Integer.parseInt(move));
        } catch (IOException e){
            System.out.println("Ошибка ввода хода");
            e.printStackTrace();
        }

//        checkTheMove(number);

        switch(number){
            case 1 -> checkTheMove(array[0][0]);
//            {
//                if (array[0][0] == null)
//                                array[0][0] = "X";
//            }
//            case 2 -> array[0][1] = "X";
//            case 3 -> array[0][2] = "X";
//            case 4 -> array[1][0] = "X";
//            case 5 -> array[1][1] = "X";
//            case 6 -> array[1][2] = "X";
//            case 7 -> array[2][0] = "X";
//            case 8 -> array[2][1] = "X";
//            case 9 -> array[2][2] = "X";
        }
    }

    private static String checkTheMove(String value) {
        if (value != null) {
            System.out.println("Поле уже занято ! Повторите ход...");
            showGameResults();
            makeMove();
        }
        value = "X";
        return value;
    }

    private static int checkTheNumberOfMove(int number){
        if (number < 1 || number > 9) {
            System.out.println("Ход должен быть в диапазоне от 1 до 9");
            System.out.print("Введите свой ход: ");
            makeMove();
        }
        return number;
    }

    private static void showGameResults(){
        Arrays.stream(array).forEach(elem -> System.out.println(Arrays.toString(elem)));
    }
}