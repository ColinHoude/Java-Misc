import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to a numbers guessing game... I have selected a number 1-100");
        Random rand = new Random();
        int ans = rand.nextInt(1,101);
        startGuess(ans);
    }

    public static void startGuess(int ans){
        Scanner scan = new Scanner(System.in);
        System.out.println("what is your first guess?");
        int guess = scan.nextInt();
        while(guess != ans){
            if(guess < ans){
                System.out.println("too low... try again -- " + guess);
                guess = scan.nextInt();
            }
            else{
                System.out.println("too high... try again -- " + guess);
                guess = scan.nextInt();
            }
        }

        System.out.println("thats it dawg!! the answer was -- " + ans);
    }
}