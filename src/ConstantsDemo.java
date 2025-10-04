package src;

public class ConstantsDemo {
    static final double PI = 3.14159;

    public static void main(String[] args) {
        System.out.println("Value of PI: " + PI);
        // PI = 3.14;  // Uncomment to see what happens
    }
}

//observation 3:
//        1. compile time error , because PI declared a final .
//        2. means there is only one copy and belongs to the class not each object .