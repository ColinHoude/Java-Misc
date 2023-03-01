import javax.swing.*;
import java.util.*;

public class Worlde {
    String wordOfDay;

    public Worlde(){
        this.wordOfDay = "colin";
    }

    public static void main(String[] args) {
        Worlde word = new Worlde();
        playGame(word);
    }

    public static void playGame(Worlde w){
        Scanner scan = new Scanner(System.in);
        String playerWord = "";
        System.out.println("Please enter first guess...");
        playerWord = scan.nextLine();
        List<Integer> arr = new ArrayList<>();
        // I am going to use an array to represent if the letter is
            // in the word or in the correct location
            // 0 - not in the word
            // 1 - in the word but not right location
            // 2 - correct location
        for (int i = 0; i < w.wordOfDay.length(); i++) {
            arr.add(0);
        }

        while(!Objects.equals(playerWord, w.wordOfDay)){
            outputResults(playerWord, w, arr);
            playerWord = scan.nextLine();
            if(Objects.equals(playerWord, w.wordOfDay)){
                break;
            }
        }

        System.out.println("Congrats you won!");
    }

    public static void outputResults(String userWord, Worlde w, List<Integer> arr){
        // this wont be efficient but will work
        arr.replaceAll(ignored -> {
            // reset to 0 every time since theoretically new word
            return 0;
        });
        for (int i = 0; i < w.wordOfDay.length(); i++) {
            if(userWord.charAt(i) == w.wordOfDay.charAt(i)){
                // correct letter at correct location
                arr.set(i, 2);
            }
            else if (w.wordOfDay.contains(String.valueOf(userWord.charAt(i)))){
                // correct letter wrong location
                arr.set(i, 1);
            }
        }
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < userWord.length(); i++) {
            charList.add(userWord.charAt(i));
        }
        System.out.println(arr);
        System.out.println(charList);
    }
}