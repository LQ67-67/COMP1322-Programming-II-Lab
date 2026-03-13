abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract void work();

    void showDetails() {
        System.out.println("Name: " + name + " | Salary: $" + salary); // common method for all employees to show their details
    }
}

class Developer extends Employee {
    Developer(String n, double s) {
        super(n, s); // calls the constructor of Employee
    }

    void work() {
        System.out.println(name + " - Writes code :)");
    }
}
class Manager extends Employee {
    Manager(String n, double s) {
        super(n, s); // calls the constructor of Employee
    }

    void work() {
        System.out.println(name + " - Manages team");
    }
}

class Tester extends Employee {
    Tester(String n, double s) {
        super(n, s);
    }
    void work() {
        System.out.println(name + " - Tests software :)");
    }
}

public class Task2_DynamicDispatch {
    public static void main(String[] args) {
        Employee[] e = {
                new Developer("Skim", 67700),
                new Manager("Max", 90000),
                new Tester("Lando", 65000)
        };

        for (Employee emp : e) {
            emp.showDetails(); emp.work(); // call work() behaves differently based on Developer, Manager, Tester
        }
    }
}