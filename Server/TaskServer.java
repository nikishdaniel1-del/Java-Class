package Server;

import java.io.*;
import java.net.*;

public class TaskServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("HRMS Server started...");
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected.");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String employeeId = input.readLine();
        output.println("Employee ID : " + employeeId + "\nEmployee Name : Nikish Daniel\nDepartment : AI&DS\nStatus : Active");
        socket.close();
        server.close();
    }
}