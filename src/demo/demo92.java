package demo;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class demo92 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("from console");
        PrintStream ps = new PrintStream("print02");
        System.setOut(ps);
        System.out.println("from dest of print stream");
        ps.close();
    }
}
