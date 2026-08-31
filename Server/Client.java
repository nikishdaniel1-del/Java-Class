package Server;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("emp001");
        String response = input.readLine();
        System.out.println("Server Response : "+response);
        socket.close();
    }
}