import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import Exceptions.UserNotFoundException;

public class User {
    private String name = "name";
    private String password;
    private static ArrayList<User> users = new ArrayList<>();
    // private ClientManager cm;

    public User(String name, String password, ClientManager cm) {
        setName(name);
        setPassword(password);
        // setClientManager(cm);
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setPassword(String password) {
        this.password = password;
    }
    // private void setClientManager(ClientManager cm) {
    //     this.cm = cm;
    // }

    public static User findUser(String name, String password) throws UserNotFoundException {
        for (User user : users) {
            if (user.name.equals(name) && user.password.equals(password))
                return user;
        }
        throw new UserNotFoundException();
    }

    public static void addUser(User user) {
        users.add(user);
    }


    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 9090;
        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            do {
                String response = reader.readLine();
                if (!response.contains("printed"))
                    System.out.println("Server: " + response);
                if (response.contains("Echo: ")) {
                    writer.println("printed");
                } else {
                    message = consoleReader.readLine();
                    writer.println(message);
                }
            } while (!message.equals("bye"));
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
