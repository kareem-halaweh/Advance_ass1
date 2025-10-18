package src.OOP_exercise;

public class robotDog extends  animal
{
    int batteryLevel;


    public robotDog(int age, String name , int batteryLevel) {
        super(age, name);
        this.age = age;
        this.name = name;
        this.batteryLevel = batteryLevel;
        System.out.println("new robotdog ctrated " + this.name + " " + this.age + " " + this.batteryLevel);
    }


@Override
    public void makeSound() {
        System.out.println("Beep! Woof! (Robot Dog Sound)");
    }

@Override
    public void eat()
    {
        super.eat();
        System.out.println(name + " is eating...");
    }

    public void recharger()
    {
        System.out.println(name + " is recharging...");
    }
}
