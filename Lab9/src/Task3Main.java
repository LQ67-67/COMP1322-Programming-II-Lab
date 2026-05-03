import java.io.*;
import java.util.*;

public class Task3Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many employee records would you like to simulate? (Enter a positive number): ");
        int count = scanner.nextInt(); // read the number from the user

        List<EmployeeBasic> basicList = new ArrayList<>();
        List<EmployeeAdvanced> advancedList = new ArrayList<>(); // hold two types of employees

        for (int i = 0; i < count; i++) {
            String name = GeneratorUtil.randomName();
            int id = GeneratorUtil.randomId();
            double salary = GeneratorUtil.randomSalary();
            String dept = GeneratorUtil.randomDepartment();
            String pass = GeneratorUtil.randomPassword(); // generate random data for this employee

            basicList.add(new EmployeeBasic(name, id, salary, dept, pass)); // add to basic list
            advancedList.add(new EmployeeAdvanced(name, id, salary, dept, pass)); // advanced list
        }

        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("basic_employees.ser"));
        oos1.writeObject(basicList); // write entire arrayList at once
        oos1.close();
        System.out.println("\nSaved basic_employees.ser");

        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("advanced_employees.dat"));
        for (EmployeeAdvanced emp : advancedList) {
            oos2.writeObject(emp);  // write each objects one by one
        }
        oos2.close();
        System.out.println("Saved advanced_employees.dat");

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("basic_employees.ser"));
        List<EmployeeBasic> loadedBasic = (List<EmployeeBasic>) ois1.readObject();  // read back the list
        ois1.close();

        System.out.println("\n=== EmployeeBasic (Serializable) ===");
        for (EmployeeBasic emp : loadedBasic) {
            System.out.println(emp);  // print each employee
        }

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("advanced_employees.dat"));
        List<EmployeeAdvanced> loadedAdvanced = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            loadedAdvanced.add((EmployeeAdvanced) ois2.readObject()); // read each object one by one
        }
        ois2.close();

        System.out.println("\n=== EmployeeAdvanced (Externalizable) ===");
        for (EmployeeAdvanced emp : loadedAdvanced) {
            System.out.println(emp);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("high_salary_employees.txt")); // writes text to a file efficiently

        int written = 0; // count how many records were written

        for (EmployeeBasic emp : loadedBasic) {
            if (emp.getSalary() > 5000) {
                writer.write("Name: " + emp.getName() + " | ID: " + emp.getId() + " | Dept: " + emp.getDepartment() + " | Type: Serializable");
                writer.newLine();
                written++;
            }
        }

        for (EmployeeAdvanced emp : loadedAdvanced) {
            if (emp.getSalary() > 5000) {
                writer.write("Name: " + emp.getName() + " | ID: " + emp.getId() + " | Dept: " + emp.getDepartment() + " | Type: Externalizable");
                writer.newLine();
                written++;
            }
        }
        writer.close();
        System.out.println("\nFiltered " + written + " high-salary employees -> high_salary_employees.txt");

        scanner.close();
    }
}