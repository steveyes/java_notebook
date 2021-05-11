package base.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("server running ...");
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                try (
                        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                        FileOutputStream fos = new FileOutputStream("tmp/" + System.currentTimeMillis() + ".jpg");
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                ) {
                    byte[] b = new byte[1024 * 8];
                    int len;
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    System.out.println("back......");
                    OutputStream out = accept.getOutputStream();
                    out.write("uploading succeeded".getBytes());
                    out.close();

                    bos.close();
                    bis.close();
                    accept.close();
                    System.out.println("file saved");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
