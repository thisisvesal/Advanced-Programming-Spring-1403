import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ServerSocket mServer;
    ArrayList<Thread> threads = new ArrayList<Thread>();

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Server Created!");
            System.out.println("Waiting for clients to connect...");
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Connected to New Client!");
                Thread t = new Thread(new ClientManager(this, client));
                threads.add(t);
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Server();
    }

}
