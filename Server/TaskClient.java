package Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner terminal = new Scanner(System.in);
        // System.out.print("Enter the Employee ID : ");
        output.println(terminal.next());
        System.out.println("Server Response : ");
        String response;
        while ((response = input.readLine()) != null) {
            System.out.println(response);
        }
        socket.close();
    }
}