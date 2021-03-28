package basic;


public class LambaInterface {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("time to eat");
            }
        });

        invokeCook(() -> {
            System.out.println("time to eat");
        });

        invokeCook(() -> System.out.println("time to eat"));
    }

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}

interface Cook {
    public abstract void makeFood();
}

