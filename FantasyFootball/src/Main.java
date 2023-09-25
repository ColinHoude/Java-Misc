import java.util.*;

// I dont need a hashmap
// 3 arrays ?
    // if name is in array, add indexes

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> Name = new ArrayList<>();
    static ArrayList<Integer> Value = new ArrayList<>();


    // need 2 hashmaps to store key value of final list and key value of input list
    static HashMap<String, Integer> finalNames = new HashMap<String, Integer>();
    static HashMap<String, Integer> inputNames = new HashMap<String, Integer>();
    public static void main(String[] args) {
        System.out.println("Hello Football Season!");
        enterName();
        //enterValue();
        populatingHash(finalNames);
//        for (String name: finalNames.keySet()) {
//            String key = name.toString();
//            String value = finalNames.get(name).toString();
//            System.out.println(key + " " + value);
//        }
        System.out.println(Arrays.asList(finalNames));
    }

    public static void enterName(){
        System.out.println("Enter in names...");
        boolean derp = false;
        String temp;
        while(!derp){
            temp = scan.nextLine();
            if(Objects.equals(temp, "done")){
                derp = true;
                break;
            }
            Name.add(temp);
        }
    }


    public static void enterValue(){
        System.out.println("Enter in Values.... uwu");
        boolean derp = false;
        Integer temp;
        while(!derp){
            temp = Integer.valueOf(scan.nextLine());
            if(Objects.equals(temp, 0)){
                derp = true;
                break;
            }
            Value.add(temp);
        }
    }

    public static void clearNames(ArrayList<String> x){
        System.out.println("Clearing names...");
    }

    public static void clearValue(ArrayList<Integer> x){
        System.out.println("Clearing values...");

    }

    public static void populatingHash(HashMap<String, Integer> x){
        // get length of array of names
        Integer length = Name.size();
        for (int i = 0; i < length; i++) {
            x.put(Name.get(i), i);
        }
    }

}