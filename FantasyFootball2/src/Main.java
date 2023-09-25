import java.util.*;

// I dont need a hashmap
// 3 arrays ?
// if name is in array, add indexes

// NEED TO MAKE SURE ALL LISTS ARE THE SAME LENGTH -- top 200 picks

public class Main {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<String> List1 = new ArrayList<>();
    static ArrayList<String> List2 = new ArrayList<>();
    static ArrayList<ArrayList<String>> ListofLists = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> ListofIndex = new ArrayList<>();


    static ArrayList<Double> finalListIndex = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello Football Season!");

        int listCounter = 1;
        boolean derp = false;
        String temp;
        while(!derp){
            System.out.println("type 1 to add new list.. type anything else to calculate...");
            temp = scan.nextLine();
            if(!Objects.equals(temp, "1")){
                derp = true;
                break;
            }
            System.out.println("Enter List " + listCounter);
            enterName(new ArrayList<String>());
            listCounter++;
        }

        // now need to compare all lists to the first list
        compareLists();
//        for (int i = 0; i < ListofLists.size(); i++) {
//            System.out.println(ListofLists.get(i));
//        }
//        for (int i = 0; i <ListofIndex.size() ; i++) {
//            System.out.println(ListofIndex.get(i));
//        }

//        System.out.println("Calculating....");
//        compareLists();
        finalStepIthink();
        for (int i = 0; i < finalListIndex.size(); i++) {
            System.out.println(finalListIndex.get(i));
        }


    }

    public static void enterName(ArrayList<String> x){
        System.out.println("Enter in names...");
        boolean derp = false;
        String temp;
        while(!derp){
            temp = scan.nextLine();
            if(Objects.equals(temp, "done")){
                derp = true;
                break;
            }
            x.add(temp);
        }
        ListofLists.add(x);
    }

    public static void addNewList(){

    }



    public static void clearNames(ArrayList<String> x){
        System.out.println("Clearing names...");
        x.clear();
    }

    public static void addNewIndexArray(ArrayList<Integer> x, int listImChecking){
        int draft1Index;
            for (int j = 0; j < ListofLists.get(0).size(); j++) {
                draft1Index = -1;
                // I only need to see where the name is located in the other list
                if(ListofLists.get(listImChecking).contains(ListofLists.get(0).get(j))){
                    draft1Index = ListofLists.get(listImChecking).indexOf(ListofLists.get(0).get(j)) +1;
                }
                // fill the list
                x.add(draft1Index);
            }

            // add the list to the list of indexes
            ListofIndex.add(x);
    }

    public static void finalStepIthink(){
        double draft1Index;
        int numOfOccur;

        for (int i = 0; i < ListofIndex.get(0).size(); i++) {
            // this represents which draft order number were looking at
            // i is the row were looking at for all lists
            // j is the list were looking at
            draft1Index = 0;
            numOfOccur = 0;
            for (int j = 0; j < ListofIndex.size(); j++) {
                // this represents the list were looking at
                if(ListofIndex.get(j).get(i) != -1){
                    // this means it exists in the list
                    draft1Index += ListofIndex.get(j).get(i);
                    numOfOccur++;
                }
            }
            finalListIndex.add(draft1Index/numOfOccur);
        }
    }

    public static void compareLists(){
        System.out.println("CALCULATING...");
        // check if name exists in both lists
        // get index of both locations
        // add indexes together
        double draft1Index = 0;
        int numOfOccur = 1;
        for (int i = 0; i < ListofLists.size(); i++) {
            // compare all lists to the first list
            // i is the specific list
            // j is the name
            addNewIndexArray(new ArrayList<Integer>(), i);
//            for (int j = 0; j < ListofLists.get(0).size(); j++) {
//                // set draftIndex to where I am currently looking
//                draft1Index = j+1;
//                numOfOccur = 1;
//                if(ListofLists.get(i).contains(ListofLists.get(0).get(j))){
//                    draft1Index += ListofLists.get(i).indexOf(ListofLists.get(0).get(j)) +1;
//                    numOfOccur++;
//                }
//
//                // this adds to the end of the list and not averaging in the first instances
//                finalListIndex.add(draft1Index/numOfOccur);
//
//                // make new array for each list
//
//
//            }

        }

    }

}