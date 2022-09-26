package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static TicTacToe.MainClass.*;
import static TicTacToe.UtilClass.showGameResults;

public class GameClass {
    static BufferedReader reader;
    static int countOfOperations;

    void playerMove() throws IOException {
        System.out.print("Введите свой ход: ");
        int number = enterNextMove();

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

    int enterNextMove(){
        int number = 0;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            String move = reader.readLine();
            number = checkTheEnteredNumber(Integer.parseInt(move));
        } catch (IOException e){
            System.out.println("Ошибка ввода хода игроком");
            e.printStackTrace();
        }
        return number;
    }

    void checkIfCellIsEmpty(String[] massiv, int number) throws IOException {
        checkWinCondition();

        if ( !massiv[number].equals(".") ) {
            System.out.println("Поле уже занято ! Повторите ход...");
            showGameResults();
            playerMove();
        } else
            massiv[number] = "X";

        showGameResults();
        checkWinCondition();
//        computerMove();
    }

    void computerMove() throws IOException {
        checkWinCondition();
        System.out.println("Компьютер делает свой ход...");

        if (array[1][1].equals(".")) {
            array[1][1] = "O";
        }

        else if (array[0][0].equals(".") || array[0][2].equals(".") || array[2][0].equals(".") || array[2][2].equals(".")){
            System.out.println("1 else if");
            int random = new Random().nextInt(3);

            switch(random){
                case 0 : if ( !array[0][0].equals(".") )
                    computerMove();
                else {
                    array[0][0] = "O";
                    showGameResults();
                    playerMove();
                }
                case 1 : if ( !array[0][2].equals(".") )
                    computerMove();
                else {
                    array[0][2] = "O";
                    showGameResults();
                    playerMove();
                }
                case 2 :    if ( !array[2][0].equals(".") )
                    computerMove();
                else {
                    array[2][0] = "O";
                    showGameResults();
                    playerMove();
                }
                case 3 :    if ( !array[2][2].equals(".") )
                    computerMove();
                else {
                    array[2][2] = "O";
                    showGameResults();
                    playerMove();
                }
            }
        }

        else if (array[0][1].equals(".") || array[1][0].equals(".") || array[1][2].equals(".") || array[2][1].equals(".")){
            System.out.println("2 else if");
            int random = new Random().nextInt(3);

            switch(random){
                case 0 : if ( !array[0][1].equals(".") )
                    computerMove();
                else {
                    array[0][1] = "O";
                    showGameResults();
                    playerMove();
                }
                case 1 : if ( !array[1][0].equals(".") )
                    computerMove();
                else {
                    array[1][0] = "O";
                    showGameResults();
                    playerMove();
                }
                case 2 :    if ( !array[1][2].equals(".") )
                    computerMove();
                else {
                    array[1][2] = "O";
                    showGameResults();
                    playerMove();
                }
                case 3 :    if ( !array[2][1].equals(".") )
                    computerMove();
                else {
                    array[2][1] = "O";
                    showGameResults();
                    playerMove();
                }
            }
        }
        checkWinCondition();
    }

    void checkWinCondition() {
        if ( array[0][0].equals("X") && array[0][1].equals("X") && array[0][2].equals("X") )
            gameOver = true;

        else if (array[0][0].equals("O") && array[0][1].equals("O") && array[0][2].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[1][0].equals("X") && array[1][1].equals("X") && array[1][2].equals("X") )
            gameOver = true;

        else if ( array[1][0].equals("O") && array[1][1].equals("O") && array[1][2].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[2][0].equals("X") && array[2][1].equals("X") && array[2][2].equals("X") )
            gameOver = true;

        else if ( array[2][0].equals("O") && array[2][1].equals("O") && array[2][2].equals("O") ){
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[0][0].equals("X") && array[1][0].equals("X") && array[2][0].equals("X") )
            gameOver = true;

        else if ( array[0][0].equals("O") && array[1][0].equals("O") && array[2][0].equals("O")) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[0][1].equals("X") && array[1][1].equals("X") && array[2][1].equals("X") )
            gameOver = true;

        else if ( array[0][1].equals("O") && array[1][1].equals("O") && array[2][1].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[0][2].equals("X") && array[1][2].equals("X") && array[2][2].equals("X") )
            gameOver = true;

        else if ( array[0][2].equals("O") && array[1][2].equals("O") && array[2][2].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[0][0].equals("X") && array[1][1].equals("X") && array[2][2].equals("X") )
            gameOver = true;

        else if ( array[0][0].equals("O") && array[1][1].equals("O") && array[2][2].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

        else if ( array[2][0].equals("X") && array[1][1].equals("X") && array[0][2].equals("X") )
            gameOver = true;

        else if ( array[2][0].equals("O") && array[1][1].equals("O") && array[0][2].equals("O") ) {
            player1Wins = false;
            gameOver = true;
        }

//        if ( Arrays.stream(array).flatMap(Stream::of).noneMatch(elem -> elem.equals(".")) )
//            gameOver = true;
        endOfGame();
    }

    int checkTheEnteredNumber(int number) {
        if (number < 1 || number > 9) {
            System.out.println("Ход должен быть в диапазоне от 1 до 9");
            try{
                playerMove();
            } catch (IOException e){
                System.out.println("Ошибка в checkEnteredNumber");
                e.printStackTrace();
            }
        }
        return number;
    }

    void endOfGame() {
        if (gameOver == true) {
            if (player1Wins == true){
                System.out.println("Игра закончена, игрок " + PLAYER1 + " победил");
            } else{
                System.out.println("Игра закончена, игрок " + PLAYER2 + " победил");
            }
            System.exit(0);
        }
    }
}