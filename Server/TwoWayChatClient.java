package Server;
import java.io.*;
import java.net.*;

public class TwoWayChatClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",5000);
        System.out.println("=".repeat(30)+"\n\tHRMS CHAT CLIENT\n"+"=".repeat(30)+"\nConnected to HRMS Chat Server.\n"+"=".repeat(30));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Thread receivedThread = new Thread(() -> {
            try {
                String message;
                while ((message = input.readLine())!=null){
                    if (message.equalsIgnoreCase("exit")){
                        break;
                    }
                    System.out.println("HR    : "+message);
                }
            } catch (IOException e) {
                System.out.println("\nServer Disconnected.");
            }
        });
        Thread sendThread = new Thread(() -> {
            try {
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String message;
                while (true) { 
                    message = keyboard.readLine();
                    if (message.equalsIgnoreCase("exit")){
                        break;
                    }
                    System.out.println("Employee : "+message);
                    output.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error sending message.");
            }
        });
        receivedThread.start();
        sendThread.start();
        receivedThread.join();
        sendThread.join();
        socket.close();
        System.out.println("\n"+"=".repeat(30)+"\nHRMS Chat Client Closed.\n"+"=".repeat(30));
    }
}