package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static TicTacToe.MainClass.*;
import static TicTacToe.UtilClass.showGameResults;

public class GameClass {
    static BufferedReader reader;

    void playerMove() {
        checkWinCondition();
        System.out.print("Введите свой ход: ");
        int number = enterNextMove();

        switch (number){
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

    int checkTheEnteredNumber(int number) {
        if (number < 1 || number > 9) {
            System.out.println("Ход должен быть в диапазоне от 1 до 9");
                enterNextMove();
            }
        return number;
    }

    void checkIfCellIsEmpty(String[] massiv, int number) {
        if ( !massiv[number].equals(".") ) {
            System.out.println("Поле уже занято ! Повторите ход...");
            showGameResults();
            playerMove();
        } else
            massiv[number] = "X";

        showGameResults();
        computerPriorityMove();
    }

    void computerPriorityMove() {
        checkWinCondition();
        System.out.println("Компьютер делает свой ход...");

        if (array[1][1].equals(".")) {
            array[1][1] = "O";
            showGameResults();
            playerMove();
        }

        int random = new Random().nextInt(3);

        if (array[0][0].equals(".") || array[0][2].equals(".") || array[2][0].equals(".") || array[2][2].equals(".")) {
            switch (random) {
                case 0:
                    if (!array[0][0].equals("."))
                        computerPriorityMove();
                    else {
                        array[0][0] = "O";
                        showGameResults();
                        playerMove();
                    }
                case 1:
                    if (!array[0][2].equals("."))
                        computerPriorityMove();
                    else {
                        array[0][2] = "O";
                        showGameResults();
                        playerMove();
                    }
                case 2:
                    if (!array[2][0].equals("."))
                        computerPriorityMove();
                    else {
                        array[2][0] = "O";
                        showGameResults();
                        playerMove();
                    }
                case 3:
                    if (!array[2][2].equals("."))
                        computerPriorityMove();
                    else {
                        array[2][2] = "O";
                        showGameResults();
                        playerMove();
                    }
            }
        } else {
            checkWinCondition();
            computerPriorityMove2();
        }
    }

    void computerPriorityMove2(){
        int random = new Random().nextInt(3);
        switch(random){
                case 0 : if ( !array[0][1].equals(".") )
                                computerPriorityMove2();
                         else {
                                array[0][1] = "O";
                                showGameResults();
                                playerMove();
                         }
                case 1 : if ( !array[1][0].equals(".") )
                                computerPriorityMove2();
                         else {
                                array[1][0] = "O";
                                showGameResults();
                                playerMove();
                         }
                case 2 : if ( !array[1][2].equals(".") )
                                computerPriorityMove2();
                         else {
                                array[1][2] = "O";
                                showGameResults();
                                playerMove();
                         }
                case 3 : if ( !array[2][1].equals(".") )
                                computerPriorityMove2();
                         else {
                                array[2][1] = "O";
                                showGameResults();
                                playerMove();
                         }
            }
        }

    void checkWinCondition() {
        for (int i = 0; i < 3; i++) {               // checking rows
            if(array[i][0].equals(array[i][1]) && array[i][1].equals(array[i][2]) && !array[i][2].equals(".")) {
                whoWins = array[i][0];
                gameOver = true;
            }
        }

        for (int i = 0; i < 3; i++) {               // checking columns
            if(array[0][i].equals(array[1][i]) && array[1][i].equals(array[2][i]) && !array[2][i].equals(".")) {
                whoWins = array[0][i];
                gameOver = true;
            }
        }

        if ( array[0][0].equals(array[1][1]) && array[1][1].equals(array[2][2]) && !array[2][2].equals(".") ) {
            whoWins = array[0][0];                  // checking diagonal 1
            gameOver = true;
        }

        else if ( array[2][0].equals(array[1][1]) && array[1][1].equals(array[0][2]) && !array[0][2].equals(".") ) {
            whoWins = array[2][0];                  // checking diagonal 2
            gameOver = true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ( !array[i][j].equals("."))
                    gameOver = true;
            }
        }

        endOfGame();
    }

    void endOfGame() {
        if (gameOver == true) {
            if (whoWins.equals("X")){
                System.out.println("Игра закончена, игрок " + PLAYER1 + " победил");
            } else if (whoWins.equals("O")){
                System.out.println("Игра закончена, игрок " + PLAYER2 + " победил");
            } else
                System.out.println("Игра закончена - ничья !");

            UtilClass.closeReadThread();
            System.exit(0);
        }
    }
}