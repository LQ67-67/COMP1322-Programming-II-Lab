import java.util.ArrayList; // ArrayList

public class Task1_2_PassByValue {
    static void tryToChangeNumber(int num) {
        num = 999; // change the copy, not the original
        System.out.println("Inside method, num = " + num);
    }

    static void addToList(ArrayList<Integer> list) {
        list.add(999); // adds 999 to the actual list
        System.out.println("Inside method, list = " + list);
    }

    public static void main(String[] args) {
        int myNumber = 5; // create an int number
        System.out.println("Before method call, my number is: " + myNumber);
        tryToChangeNumber(myNumber); // try to change it
        System.out.println("After method call, my number is: " + myNumber);

        System.out.println("---");

        // Pass by Reference example
        ArrayList<Integer> myList = new ArrayList<>(); // create a list
        // add numbers
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("Before method call, my list is: " + myList); // [1, 2, 3]
        addToList(myList); // add 999
        System.out.println("After method call, my list is: " + myList); // [1, 2, 3, 999]
    }
}
