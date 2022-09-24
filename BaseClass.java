package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class BaseClass {
    private static int[][] arrayMock = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static String[][] array = new String[][] { {".", ".", "."}, {".", ".", "."}, {".", ".", "."}};
    private static String PLAYER1 = "Rust";
    private static String PLAYER2 = "Computer";
    static boolean gameOver = false;

    public static void main(String[] args) throws IOException {
        System.out.print("Пожайлуста, введите своё имя: ");
//        enterName();
        System.out.println("Первому игроку " + PLAYER1 + " приготовиться!");
        System.out.println("Вы играете крестиками, сделайте свой ход на клетку от 1 до 9");
        Arrays.stream(arrayMock).forEach(elem -> System.out.println(Arrays.toString(elem)));
        System.out.print("Введите свой ход: ");
        playerMove();
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

    private static void playerMove() throws IOException {
        int number = 0;

        try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in)))
        {
            String move = reader2.readLine();
            number = checkTheEnteredNumber(Integer.parseInt(move));
        } catch (IOException e){
            System.out.println("Ошибка ввода хода");
            e.printStackTrace();
        }

        switch(number){
            case 1 -> checkIfCellIsEmpty(array[0], 0);
            case 2 -> checkIfCellIsEmpty(array[0], 1);
            case 3 -> checkIfCellIsEmpty(array[0], 2);
            case 4 -> checkIfCellIsEmpty(array[1], 0);
            case 5 -> checkIfCellIsEmpty(array[1], 1);
            case 6 -> checkIfCellIsEmpty(array[1], 2);
            case 7 -> checkIfCellIsEmpty(array[2], 0);
            case 8 -> checkIfCellIsEmpty(array[2], 1);
            case 9 -> checkIfCellIsEmpty(array[2], 2);
        }
    }

    private static void checkIfCellIsEmpty(String[] massiv, int number) throws IOException {
        checkWinCondition();

        if ( !massiv[number].equals(".") ) {
            System.out.println("Поле уже занято ! Повторите ход...");
            showGameResults();
            playerMove();
        } else
            massiv[number] = "X";

        showGameResults();
        computerMove();
    }

    private static void computerMove() throws IOException {
//        checkWinCondition();

        System.out.println("Компьютер делает свой ход...");
        if (array[1][1].equals(".")) {
            array[1][1] = "O";
        }

        else if (array[0][0].equals(".") || array[0][2].equals(".") || array[2][0].equals(".") || array[2][2].equals(".")){
            int random = new Random().nextInt(3);
            switch(random){
                case 0 -> array[0][0] = "O";
                case 1 -> array[0][2] = "O";
                case 2 -> array[2][0] = "O";
                case 3 -> array[2][2] = "O";
            }
        }

        else if (array[0][1].equals(".") || array[1][0].equals(".") || array[1][2].equals(".") || array[2][1].equals(".")){
            int random = new Random().nextInt(3);
            switch(random){
                case 0 -> array[0][1] = "O";
                case 1 -> array[1][0] = "O";
                case 2 -> array[1][2] = "O";
                case 3 -> array[2][1] = "O";
            }
        }

        playerMove();
    }

    private static int checkTheEnteredNumber(int number) throws IOException {
        if (number < 1 || number > 9) {
            System.out.println("Ход должен быть в диапазоне от 1 до 9");
            System.out.print("Введите свой ход: ");
            playerMove();
        }
        return number;
    }

    private static void checkWinCondition() throws IOException {
        if (array[0][0].equals("X") & array[0][1].equals("X") & array[0][2].equals("X") )
                gameOver = true;
        else if (array[1][0].equals("X") & array[1][1].equals("X") & array[1][2].equals("X") )
            gameOver = true;
        else if (array[2][0].equals("X") & array[2][1].equals("X") & array[2][2].equals("X") )
            gameOver = true;
        else if (array[0][0].equals("X") & array[1][0].equals("X") & array[2][0].equals("X") )
            gameOver = true;
        else if (array[0][1].equals("X") & array[1][1].equals("X") & array[2][1].equals("X") )
            gameOver = true;
        else if (array[0][2].equals("X") & array[1][2].equals("X") & array[2][2].equals("X") )
            gameOver = true;
        else if (array[0][0].equals("X") & array[1][1].equals("X") & array[2][2].equals("X") )
            gameOver = true;
        else if (array[2][0].equals("X") & array[1][1].equals("X") & array[0][2].equals("X") )
            gameOver = true;

//        if ( Arrays.stream(array).flatMap(Stream::of).noneMatch(elem -> elem.equals(".")) )
//            gameOver = true;
        endOfGame();
    }

    private static void showGameResults(){
        Arrays.stream(array).forEach(elem -> System.out.println(Arrays.toString(elem)));
    }

    private static void endOfGame() throws IOException {
        if (gameOver == true){
            System.out.println("Игра закончена, игрок " + PLAYER1 + " победил");
        }
        computerMove();
    }
}