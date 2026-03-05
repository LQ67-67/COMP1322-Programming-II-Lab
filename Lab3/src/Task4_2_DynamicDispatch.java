class Animal2 {
    String name;

    Animal2(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + ": Animal makes a sound");
    }

    // added to superclass
    void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }
}

class Dog2 extends Animal2 {
    Dog2(String name) {
        super(name); // call parent constructor
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Bark!");
    }
}

public class Task4_2_DynamicDispatch {

    public static void main(String[] args) {
        Animal2 a = new Dog2("Max"); // create a Dog2 object but reference it as an Animal2

        a.makeSound(); // calls Dog2
        a.sleep();     // calls Animal2's sleep() because Dog2 doesnt override it
    }
}
