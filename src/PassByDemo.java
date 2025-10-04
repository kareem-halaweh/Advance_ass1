package src;

class Box {
    int value;
    Box(int v) { value = v; }
}

public class PassByDemo {

    static void changePrimitive(int x) {
        x = 100;
    }

    static void changeObject(Box b) {
        b.value = 100;
    }

    public static void main(String[] args) {
        int num = 50;
        Box box = new Box(50);

        changePrimitive(num);
        changeObject(box);

        System.out.println("num = " + num);       // Expect unchanged
        System.out.println("box.value = " + box.value); // Expect changed
    }
}

//observation 1:
//        1. num didn't change because java pass by value .
//        2. its change because its an object and we did change the object box value , because it did pointed to it address so we had the able to change the value .
