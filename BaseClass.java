package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class BaseClass {
    static int[][] arrayMock = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    private static String PLAYER1 = "Rust";
    static String PLAYER2 = "Computer";

    public static BaseClass baseClass;
    public static GameClass gameClass;

    public static void main(String[] args) throws IOException {
        baseClass = new BaseClass();
        gameClass = new GameClass();
        System.out.print("Пожайлуста, введите своё имя: ");
        UtilClass.enterName();
        System.out.println("Первому игроку " + UtilClass.PLAYER1 + " приготовиться!");

        System.out.println("Вы играете крестиками, сделайте свой ход на клетку от 1 до 9");
        Arrays.stream(arrayMock).forEach(elem -> System.out.println(Arrays.toString(elem)));

        System.out.print("Введите свой ход: ");
        gameClass.playerMove();
    }
}