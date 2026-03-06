import java.util.ArrayList;
import java.util.Iterator;

public class Task3_2_StudentList {

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>(); // create an ArrayList to store student names

        // add student names to the list
        students.add("Max");
        students.add("Lando");
        students.add("Charlies");
        students.add("Lewis");

        System.out.println("Student Names:");

        Iterator<String> iterator = students.iterator(); // get the iterator one by one to go through the list

        // checks if there is another item left in the list
        while (iterator.hasNext()) {
            String name = iterator.next(); // next() gives us the next item
            System.out.println(name);
        }
    }
}
