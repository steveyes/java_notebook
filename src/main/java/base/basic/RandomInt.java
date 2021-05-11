package base.basic;

import java.util.Random;

public class RandomInt {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomInt(3, 9));
        }
    }


    public static int getRandomInt(int from, int to) {
        return (new Random()).nextInt(to + 1 - from) + from;
    }
}
