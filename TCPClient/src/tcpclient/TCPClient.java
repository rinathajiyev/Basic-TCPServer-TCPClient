package tcpclient;

import fileutility.FileUtility;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        writeASBytes();
        //writeAsString();
    }

    public static void writeAsString() throws Exception {
        Socket socket = new Socket("localhost", 6789);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.write("Welcome to our new TCP Server".getBytes(StandardCharsets.UTF_8));
        socket.close();
    }

    public static void writeASBytes() throws Exception {
        Socket socket = new Socket("localhost", 6789);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte[] bytes = FileUtility.readBytes("C:/Users/Casper/Desktop/Everything/me.jpeg");
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }
}
