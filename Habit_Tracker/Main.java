import UserPackage.*;
import TaskPackage.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Taking user input and creating a user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scan.next();
        System.out.print("Enter your password: ");
        String password = scan.next();

        System.out.print("Enter your full name: ");
        String first_name = scan.next();
        String last_name = scan.next();
        System.out.print("Enter your email: ");
        String email = scan.next();

        User user = new User(username, password, first_name, last_name, email);

        // Displaying the user info
        System.out.println("---User Created---");
        System.out.println("Welcome " + user.getFullName() + "!");
        printUserInfo(user);

        // Creating task for a specific user
        System.out.println("Would you like to create a task? (y/n)");
        char answer = scan.next().charAt(0);
        if (answer == 'y') {
            System.out.println("Creating task...");
            System.out.print("Enter your task's name: ");
            Task task1 = user.createTask(scan.next());
            task1.setStart_time(18.00);
            task1.setFinish_time(19.30);
            DecimalFormat df = new DecimalFormat("##.00");
            System.out.println(task1.getName() + " duration: " + df.format(task1.getDuration()));
        }

        // Changing username and password with setter methods
        System.out.println("Would you like to change your username and password? (y/n)");
        answer = scan.next().charAt(0);
        if (answer == 'y') {
            System.out.println("Changing username and password...");
            System.out.println("Enter new username: ");
            String username2 = scan.next();
            user.setUsername(username2);
            System.out.println("Enter new password: ");
            String password2 = scan.next();
            user.setPassword(password2);
            // Changing the getStreak()
            user.setStreak(2);
            printUserInfo(user);
        }

        System.out.println("Now you can find a task by its name,");
        System.out.println("Would you like to search? (y/n)");
        answer = scan.next().charAt(0);

        if (answer == 'y') {
            System.out.println("Please enter your task's name:");
            String name = scan.next();
            System.out.println(user.getTaskByName(name).getName());
        }

        System.out.println("Now you can find a task by its color,");
        System.out.println("Would you like to search? (y/n)");
        answer = scan.next().charAt(0);

        if (answer == 'y') {
            System.out.println("Please enter your task's color:");
            String color = scan.next();
            for (int i = 0; i < user.getTaskByColor(color).length; i++) {
                System.out.println(user.getTaskByColor(color)[i].getName());
            }
        }


        printUserInfo(user);

        // Closing the Scanner
        scan.close();
    }

    public static void printUserInfo(User user) {
        System.out.println("Username: " + user.getUsername() + "\nFull name: " + user.getFullName()
                + "\nPassword: " + user.getPassword() + "\nEmail: " + user.getEmail() + "\nYou have been using the app for "
                + user.getStreak() + " days.");
        user.printUserTasks();
    }
}
