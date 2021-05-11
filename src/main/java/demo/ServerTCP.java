package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动，等待连接 ...");
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = inputStream.read(b);
        String data = new String(b, 0, len);
        System.out.println(data);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我很好，谢谢".getBytes());

        outputStream.close();
        inputStream.close();
        server.close();
    }
}
