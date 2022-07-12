package tcpserver;

import fileutility.FileUtility;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        readAsByte();
        // readAsString();
    }

    public static void readAsString() throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Server is waiting for a new client...");
            Socket connection = serverSocket.accept();
            System.out.println("New client came into our server :)");
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String messageFromClient = bufferedReader.readLine();
            System.out.println("Message from client: " + messageFromClient);
        }
    }

    public static void readAsByte() throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Server is waiting for a new client...");
            Socket connection = serverSocket.accept();
            System.out.println("New client came into our server :)");

            DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(dataInputStream);
            FileUtility.writeBytes("C:/Users/Casper/Desktop/javaExample.jpg", arr);
        }
    }

    public static byte[] readMessage(DataInputStream data) throws Exception {
        int messageLength = data.readInt();
        byte[] message = new byte[messageLength];
        data.readFully(message);
        return message;
    }

}


