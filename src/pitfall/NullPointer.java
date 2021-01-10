package pitfall;

public class NullPointer {
    public static void main(String[] args) {
        withoutNewStatement();
    }

    private static void withoutNewStatement() {
        int[] array = null;
        // 'null' assignment statement without 'new' statement followed by, will raise Exception: 'java.lang.NullPointerException'
        array = new int[3];
        System.out.println(array[0]);
    }
}
