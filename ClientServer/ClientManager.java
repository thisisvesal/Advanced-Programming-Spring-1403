import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Exceptions.UserNotFoundException;

public class ClientManager implements Runnable {
    User user;
    Socket clientHolder;
    Server serverHolder;
    InputStream fromClientStream;
    OutputStream toClientStream;

    DataInputStream reader;
    PrintWriter writer;

    public ClientManager(Server server, Socket client) {
        serverHolder = server;
        clientHolder = client;
    }

    // NOTE: sysout prints to server, writer prints to client

    @SuppressWarnings("deprecation")
    public void run() {
        try {
            // input stream (stream from client)
            fromClientStream = clientHolder.getInputStream();
            toClientStream = clientHolder.getOutputStream();

            reader = new DataInputStream(fromClientStream);
            writer = new PrintWriter(toClientStream, true);

            // send message to client
            writer.println("Enter name: ");
            System.out.println("Asking the new client to enter their name");
            String name = reader.readLine();
            writer.println("Enter password:");
            System.out.println("Asking the new client to enter their password");
            String password = reader.readLine();
            try {
                user = User.findUser(name, password);
                // writer.println("Welcome back, " + name);
            } catch (UserNotFoundException e) {
                User.addUser(new User(name, password, this));
                // writer.println("Welcome, " + name);
            }

            String message = "";
            do {
                if (message.isEmpty() || !message.equals("printed")) {
                    System.out.println("Asking " + name + " to enter a message");
                    writer.println("Enter message: ");
                }
                message = reader.readLine();
                if (!message.contains("printed")) {
                    System.out.println(name + " said: " + message);
                }
                writer.println("Echo: " + message);

            } while (!message.equals("bye"));
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}