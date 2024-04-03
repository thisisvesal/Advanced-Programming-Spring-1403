package UserPackage;

import TaskPackage.*;
import UtilityPackage.*;
import java.util.Scanner;

public class User {
    Scanner scan = new Scanner(System.in);
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private int streak;
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void setUsername(String username) {
        this.username = username;
    }

    // If a valid password is given, it will be set and the method returns true
    // otherwise the password won't change and false is returned
    public boolean setPassword(String Password) {
        if (Utils.isPasswordValid(Password)) {
            this.password = Password;
        } else {
            System.out.println("Invalid Password! At least one letter and one number should be used in it");
            System.out.print("Please enter your password again : ");
            String password = scan.next();
            setPassword(password);
        }
        return true;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public User(String username, String password, String first_name, String last_name, String email) {
        setUsername(username);
        setPassword(password);
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmailIfValid(email);
    }

    public String getFullName() {
        return first_name.concat(last_name);
    }

    public boolean isTaskRepetetive(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (taskName.compareTo(tasks[i].getName()) == 0) {
                return true;
            }
        }
        return false;
    }

    public Task createTask(String taskName) {
        if (isTaskRepetetive(taskName)) {
            return tasks[taskCount - 1];
        }
        System.out.println("Would you like to choose a color for your new task? (y/n)");
        char answerOfcolor = scan.next().charAt(0);
        if (answerOfcolor == 'y') {
            int sw = 1;
            String ChooseColor = "65F23A";
            while (sw == 1) {
                System.out.print("Enter the desired color in hexadecimal format : ");
                ChooseColor = scan.next();
                if (Task.isColorValid(ChooseColor) == true)
                    sw = 0;
                else {
                    System.out.println(
                            "invalid color! Numbers have to be in the range of 0 to 9 and Letters have to be in the range of A to F !!");
                }
            }
            tasks[taskCount] = new Task(taskName, ChooseColor, this);

        } else {
            tasks[taskCount] = new Task(taskName, this);
        }
        taskCount++;
        return tasks[taskCount - 1];
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void printUserTasks() {
        if (this.taskCount > 0) {
            System.out.println("Tasks:");
            for (int i = 0; i < this.taskCount; i++) {
                System.out.println(this.tasks[i].getName() + " - color: " + this.tasks[i].color);
            }
        } else
            System.out.println(this.first_name + " doesn't have any tasks yet!");
    }

    public Task getTaskByName(String name) {
        boolean found = false;
        for (int i = 0; i < taskCount ; i++) {
            if (tasks[i].getName().compareTo(name) == 0) {
                found = true;
                return tasks[i];
            }
        }

        if (!found) {
            System.out.println("The task doesn't exist!");
        }
        return null;
    }

    public Task[] getTaskByColor(String Color) {
        boolean found = false;
        int count = 0;
        Task[] ans = new Task[100];
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].color.compareTo(Color) == 0) {
                found = true;
                ans[count] = tasks[i];
                count++;
            }
        }
        if (found) {
            return ans;
        } else {
            System.out.println("The task doesn't exist!");
            return null;
        }
        
    }

    public void setFirst_name(String first_name) {
        String newStr = "";
        if (Utils.isLowerCase(first_name.charAt(0))) {
            newStr = "" + (char) (first_name.charAt(0) - 32);
        }
        for (int i = 1; i < first_name.length(); i++) {
            if (Utils.isLowerCase(first_name.charAt(i))) {
                newStr += first_name.charAt(i);
            } else if (Utils.isUpperCase(first_name.charAt(i))) {
                newStr += (char) (first_name.charAt(i) + 32);
            }
        }
        this.first_name = newStr;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        String newStr = "";
        if (Utils.isLowerCase(last_name.charAt(0))) {
            newStr = "" + (char) (last_name.charAt(0) - 32);
        }
        for (int i = 1; i < last_name.length(); i++) {
            if (Utils.isLowerCase(last_name.charAt(i))) {
                newStr += last_name.charAt(i);
            } else if (Utils.isUpperCase(last_name.charAt(i))) {
                newStr += (char) (last_name.charAt(i) + 32);
            }
        }
        this.last_name = newStr;
    }

    public String getLast_name() {
        return last_name;
    }

    public boolean setEmailIfValid(String email) {
        if (Utils.isEmailValid(email)) {
            this.email = email;
            return true;
        }
        System.out.println("Invalid email!!");
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getStreak() {
        return streak;
    }

}
