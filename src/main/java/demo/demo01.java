package demo;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class demo01 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("print01");
        ps.write(97);
        ps.println(97);
        ps.println(8.8);
        ps.println('a');
        ps.println("Hello World");
        ps.println(true);

        ps.close();
    }
}
