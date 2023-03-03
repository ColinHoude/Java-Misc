import java.util.Scanner;

public class Main {
    static int [][] board = new int[3][3];
    static boolean gameOver = false;
    static public void initBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(j + 1 < board[i].length){
                    System.out.print(board[i][j] + "|");
                }
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void playGame(){
        while(!gameOver){
            playerTurn();
            printBoard();
        }
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
            turnStatus = setTurn(charRow, charCol);
        }
    }

    public static boolean setTurn(int row, int column){
        if(board[row][column] == 0){
            // player == 2
            // ai == 1
            board[row][column] = 2;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        initBoard();
        printBoard();
        playGame();
    }
}