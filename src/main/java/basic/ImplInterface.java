package basic;

public class ImplInterface {
    public static void main(String[] args) {
        invokeCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        invokeCalc(20, 30, (int a, int b) -> {
            return a + b;
        });

        invokeCalc(30, 40, (a, b) -> a + b);
    }

    public static void invokeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}


interface Calculator {
    public abstract int calc(int a, int b);
}