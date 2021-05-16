package base.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("tmp/hello.html"));
        bufferedOutputStream.write("<h1>hello, how you</h1>".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write("<p>this is simplest http server demo</p>".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.close();
        System.out.println("server running on : http://localhost:8080/");
        System.out.println("please visit: http://localhost:8080/tmp/hello.html");
        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String line = bufferedReader.readLine();
                        System.out.println("line: " + line);
                        String[] arr = line.split(" ");
                        String path = arr[1].substring(1);
                        System.out.println("path: " + path);
                        FileInputStream fileInputStream = new FileInputStream(path);
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("HTTP:/1.1 200 OK \r\n".getBytes(StandardCharsets.UTF_8));
                        outputStream.write("Content-Type:text/html\r\n".getBytes(StandardCharsets.UTF_8));
                        outputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
                        int len;
                        byte[] bytes = new byte[1024];
                        while ((len = fileInputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, len);
                        }
                        fileInputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
