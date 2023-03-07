import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int [][] board = new int[3][3];
    static boolean gameOver = false;
    static public void initBoard(){
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
    }

    public static void printBoard(){
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(j + 1 < board[i].length){
                    System.out.print(board[i][j] + " | ");
                }
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void playGame() {
        while (!gameOver) {
            playerTurn();
            printBoard();
            checkWin();
            AiTurn(1);
            printBoard();
        }
        System.out.println("░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░██╗░░░██╗███████╗██████╗");
        System.out.println("██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗");
        System.out.println("██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝");
        System.out.println("██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗");
        System.out.println("╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║");
        System.out.println("░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝");
    }



    public static void playerTurn(){
        System.out.println("player pick turn... [row][column]");
        Scanner scan = new Scanner(System.in);
        String charChoice = scan.nextLine();
        int charRow = Integer.parseInt(String.valueOf(charChoice.charAt(0)));
        int charCol= Integer.parseInt(String.valueOf(charChoice.charAt(1)));
        boolean turnStatus = false;
        // some error checking
        while(charRow > board.length || charCol > board[0].length){
            System.out.println("Invalid input try again: ");
            charChoice = scan.nextLine();
            charRow = Integer.parseInt(String.valueOf(charChoice.charAt(0)));
            charCol= Integer.parseInt(String.valueOf(charChoice.charAt(1)));
        }

        while(!turnStatus){
            turnStatus = setTurn(charRow, charCol, 0);
        }
    }

    public static void AiTurn(int skillLevel){
        boolean turnStatus = false;
        // skillLevel 0 - never wins
        // skillLevel 1 - random
        // skillLevel 2 - always at least cats game
        if(skillLevel == 1){
            Random rand = new Random();
            while(!turnStatus){
                // pick a random tile to test
                int row = rand.nextInt(0,3);
                int col = rand.nextInt(0,3);
                turnStatus = setTurn(row, col, 1);
            }
        }

    }

    public static boolean setTurn(int row, int column, int playerType){
        if(playerType == 0){
            // this is an actual player
            if(board[row][column] == 0){
                // player == 2
                // ai == 1
                board[row][column] = 5;
                return true;
            }
        }
        else {
            // this is an Ai player
            if(board[row][column] == 0){
                // player == 2
                // ai == 1
                board[row][column] = 1;
                return true;
            }
        }
        return false;
    }

    public static void checkWin(){
        // this is probably not the best way to do this
        // originally thinking using recursion or even a DFS algorithm

        // first check rows
        int checkInt = 0;
        for (int i = 0; i < board.length;  i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkInt += board[i][j];
            }
            if(checkInt == 15 || checkInt == 3){
                // this means there is a win in that row
                printBoard();
                gameOver = true;
                return;
            }
            checkInt = 0;
        }

        // check column
        for (int i = 0; i < board.length;  i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkInt += board[j][i];
            }
            if(checkInt == 15 || checkInt == 3){
                // this means there is a win in that row
                printBoard();
                gameOver = true;
                return;
            }
            checkInt = 0;
        }

        // check diagonal
        for (int i = 0; i < board.length; i++) {
            checkInt += board[i][i];
        }
        if(checkInt == 15 || checkInt == 3){
            // this means there is a win in that row
            printBoard();
            gameOver = true;
            return;
        }
        checkInt = 0;

        // check anti- diagonal
        for (int i = 0; i < board.length; i++) {
            checkInt += board[i][(board[i].length-i)-1];
        }
        if(checkInt == 15 || checkInt == 3){
            // this means there is a win in that row
            printBoard();
            gameOver = true;
            return;
        }
        checkInt = 0;
    }

    public static void main(String[] args) {
        // test calls
        initBoard();
        printBoard();
        playGame();


    }
}