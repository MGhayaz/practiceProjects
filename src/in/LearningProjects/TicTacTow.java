package in.LearningProjects;

import java.util.Scanner;

public class TicTacTow {
    public static void main(String[] args) {
        char [][] board= new char[3][3];
        for (int row = 0; row < board.length; row++ ){
            for (int column = 0; column < board[row].length; column++){
                board[row][column]  = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board, player);
            System.out.println("Player " + player + " enter: ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = HasWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " Won");
                } else {
                    player = (player == 'X') ? 'O' : 'X';

                }
            } else {
                System.out.println("filled already!");
            }
        }
        printBoard(board, player);
    }

    public static void printBoard(char [][] board , char player) {
        for (int row = 0; row < board.length; row++ ) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean HasWon(char [][] board , char player) {
            //row case
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        } // column case
        for (int column = 0; column < board[0].length; column++){
            if  (board [0] [column] == player && board [1] [column] == player && board [2] [column] == player){
            return true;
            }
        } //two diagonal case
        if(board [0] [0] == player && board [1] [1] == player && board [2] [2] == player) {
            return true;
        }
        if (board [0] [2] == player && board [1] [1] == player && board [2] [0] == player){
            return true;
        } //no won
        return false;
    }

}
