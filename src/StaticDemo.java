package src;

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }

    static void printCount() {
        System.out.println("Count = " + count);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        Counter.printCount(); // Expected Count = 3
        System.out.println("Access via object: " + c1.count);
    }
}

//observation 2:
//        1. every time we create a new counter object its add 1 to the count .
//2. yes u can , is there a huge different i dont think so .
