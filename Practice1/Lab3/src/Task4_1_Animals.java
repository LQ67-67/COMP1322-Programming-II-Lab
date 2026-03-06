import java.util.ArrayList;

// superclass (parent class)
class Animal {
    String name;

    // constructor for Animal
    Animal(String name) {
        this.name = name; // set the name
    }

    // default sound method
    void makeSound() {
        System.out.println(name + "Animal makes a sound"); // default message
    }
}

// subclass of animal (child class) dog
class Dog extends Animal {
    Dog(String name) { // constructor for dog
        super(name); // calls Animal's constructor to set the name
    }

    @Override // replacing the parent's makeSound() method
    void makeSound() {
        System.out.println(name + ": Bark!");
    }
}

// subclass of Animal cat
class Cat extends Animal {
    Cat(String name) { // constructor for cat
        super(name); // call parent constructor
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Meow!");
    }
}

public class Task4_1_Animals {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(); // holds Animal objects

        animals.add(new Dog("Ab"));
        animals.add(new Cat("Bob"));
        animals.add(new Dog("Buddy"));
        animals.add(new Cat("Charlie"));

        for (Animal a : animals) {
            a.makeSound(); // calls Dog or Cat version depending on actual type
        }
    }
}
