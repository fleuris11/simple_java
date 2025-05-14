public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        System.out.println("Addition : " + add(4, 6));
        System.out.println("Soustraction : " + subtract(10, 4));
    }
}