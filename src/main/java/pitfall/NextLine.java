package pitfall;

import java.util.Scanner;

public class NextLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("please input a number: ");
        int num = sc.nextInt();
        System.out.println("the num you input is: " + num);

        // When the user enters an integer followed by an 'newline character' ('\n') in your input created by hitting <Enter>,
        // the Scanner.nextInt method does not read the newline character and leaves the newline in the input,
        // but "Scanner.nextLine" does read the newline character so the '\n' will be captured by the next "Scanner.nextLine".
        // Workaround, either put a Scanner.nextLine call after each Scanner.nextInt or Scanner.next* to consume rest of that line including '\n'.
        sc.nextLine();

        System.out.print("please input a string: ");
        String string = sc.nextLine();
        System.out.println("the string you input is: " + string);
    }
}