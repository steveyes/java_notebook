package base.network;

import java.io.*;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("tmp/test.jpg"));
        Socket socket = new Socket("localhost", 6666);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
            bos.flush();
        }
        socket.shutdownOutput();
        System.out.println("file sent");
        InputStream inputStream = socket.getInputStream();
        b = new byte[1024];
        len = inputStream.read(b);
        System.out.println(new String(b,0, len));

        bos.close();
        socket.close();
        bis.close();
        System.out.println("file uploaded");
    }
}
