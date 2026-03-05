class Person {

    String name; // stores the name
    int age; // stores the age

    Person(String name, int age) {
        this.name = name; // "this.name" means the class variable, "name" is what we passed in
        this.age = age;
    }

    // Printing person's info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Task1_1_Person {
    public static void main(String[] args) {
        Person person1 = new Person("Max", 20); // create the first Person object

        Person person2 = new Person("Lando", 25); // create the second one

        person1.displayInfo(); // call displayInfo() on each person to print their details
        System.out.println("---");
        person2.displayInfo();
    }
}
