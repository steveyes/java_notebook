package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端发送数据");
        Socket client = new Socket("localhost", 6666);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("你好么？ tcp，我来了".getBytes());


        InputStream inputStream = client.getInputStream();
        byte[] b = new byte[1024];
        int len = inputStream.read(b);
        String data = new String(b, 0, len);
        System.out.println(data);

        outputStream.close();
        inputStream.close();
        client.close();

    }
}
