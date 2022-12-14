package TicTacToe;

import java.io.IOException;
import java.util.Arrays;

public class MainClass {
    static int[][] arrayDemo = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    static String[][] array = new String[][] { {".", ".", "."}, {".", ".", "."}, {".", ".", "."}};
    static boolean gameOver = false;
    static String whoWins = "none";

    static String PLAYER1 = "";
    static String PLAYER2 = "Computer";

    public static MainClass mainClass;
    public static GameClass gameClass;

    public static void main(String[] args) throws IOException {
        mainClass = new MainClass();
        gameClass = new GameClass();
        System.out.print("Пожайлуста, введите своё имя: ");
        UtilClass.enterName();
        System.out.println("Первому игроку, " + PLAYER1 + ", приготовиться!");

        System.out.println("Вы играете крестиками, сделайте свой ход на клетку от 1 до 9");
        Arrays.stream(arrayDemo).forEach(elem -> System.out.println(Arrays.toString(elem)));

        gameClass.playerMove();
    }
}