package Server;
import java.io.*;
import java.net.*;

public class TwoWayChatServer {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5000);
        System.out.println("=".repeat(30)+"\n\tHRMS CHAT CLIENT\n"+"=".repeat(30)+"\nServer started...\nWaiting for Employee...");
        Socket socket = server.accept();
        System.out.println("\nEmployee Connected Successfully.\n"+"=".repeat(30));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Thread receiveThread = new Thread(() -> {
            try{
                String message;
                while ((message = input.readLine()) != null)
                {
                    if (message.equalsIgnoreCase("exit")){
                        break;
                    }
                    System.out.println("\nEmployee : " + message);
                }
            }
            catch (IOException e){
                System.out.println("\nEmployee disconnected.");
            }
        });
        Thread sendThread = new Thread(() -> {
            try {
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String message;
                while (true) { 
                    message = keyboard.readLine();
                    if (message.equalsIgnoreCase("exit")) {
                        break;                        
                    }
                    System.out.print("HR     : "+message);
                    output.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error Sending Message.");
            }
        });
        receiveThread.start();
        sendThread.start();
        receiveThread.join();
        sendThread.join();
        socket.close();
        server.close();
        System.out.println("\n"+"=".repeat(30)+"\nHRMS Chat Server Closed.\n"+"=".repeat(30));
    }
}