package Server;

import java.io.*;
import java.net.*;

class ClientHandler1 extends Thread {
    private Socket socket;
    private ServerSocket server;
    public ClientHandler1(Socket socket,ServerSocket server) {
        this.socket = socket;
        this.server = server;
    }
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String employeeId = input.readLine();
            String status = input.readLine();
            System.out.println(Thread.currentThread().getName()+ " Processing... "+ employeeId);
            output.println("Employee " + employeeId + " is "+status);
            if (status.equals("Leave")){server.close();}
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Task1Server {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");
        while (true) {
            try{Socket socket = server.accept();
            System.out.println("Client connected");
            ClientHandler1 handler = new ClientHandler1(socket,server);
            handler.start();
            } catch (Exception e){
                System.out.println("Server stopped.");
                break;
            }
        }
    }
}