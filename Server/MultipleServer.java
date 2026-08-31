package Server;

import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String employeeId = input.readLine();
            System.out.println(Thread.currentThread().getName()+ " Processing... "+ employeeId);
            output.println("Employee " + employeeId + " is Active");
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class MultipleServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");
        int index = 0;
        while (index<3) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            ClientHandler handler = new ClientHandler(socket);
            handler.start();
            index++;
        }
        server.close();
    }
}