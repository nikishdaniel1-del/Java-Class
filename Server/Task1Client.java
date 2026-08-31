package Server;

import java.io.*;
import java.net.*;

public class Task1Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("emp102");
        output.println("Available");
        System.out.println("Server Response:");
        System.out.println(input.readLine());
        socket.close();
    }
}