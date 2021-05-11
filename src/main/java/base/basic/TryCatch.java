package base.basic;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatch {

    public static void main(String[] args) throws FileNotFoundException {
        tryCatchJdk9();
//        tryCatchJdk7V2();
//        tryCatchJdk7V1();
    }

    private static void tryCatchJdk9() throws FileNotFoundException {
        final FileInputStream fis = new FileInputStream("1.png");
        FileOutputStream fos = new FileOutputStream("2.png");

        try (fis; fos) {
            // create new variable[s] to store variables in the upper scope, and close resource[s] at the of its statement
            int len = 0;
            byte[] buff = new byte[1024];
            while (-1 != (len = fis.read(buff))) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void tryCatchJdk7V2() {
        try (
                // try-with-resource statement will close resource[s] at the end of its statement,
                // so there is no finally statement needed
                FileInputStream fis = new FileInputStream("1.png");
                FileOutputStream fos = new FileOutputStream("2.png");
        ) {
            int len = 0;
            byte[] buff = new byte[1024];
            while (-1 != (len = fis.read(buff))) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryCatchJdk7V1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("1.png");
            fos = new FileOutputStream("2.png");
            int len = 0;
            byte[] buff = new byte[1024];
            while (-1 != (len = fis.read(buff))) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
