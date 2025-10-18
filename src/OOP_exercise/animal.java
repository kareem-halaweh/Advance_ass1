package src.OOP_exercise;

public abstract class animal {
    int age;
    String name;

    public animal(int age, String name) {
        this.age = age;
    }



    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " usper  is eating...");
    }

}
