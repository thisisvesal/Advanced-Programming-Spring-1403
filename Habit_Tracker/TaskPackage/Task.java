package TaskPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import UserPackage.*;

public class Task {
    private String name;
    private double start_time;
    private double finish_time;
    public final String color;
    private User taskUser;

    public void setName(String name) {
        Pattern validPattern = Pattern.compile("^.{1,10}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validPattern.matcher(name);
        if (matcher.find()) {
            this.name = name;
        } else {
            System.out.println("Invalid task name!");
        }
    }

    public String getName() {
        return name;
    }

    public Task(String name, String color, User user) {
        // user.createTask(name);
        taskUser = user;
        this.color = color;
        setName(name);
    }

    public Task(String name, User user) {
        this(name, "65F23A", user);
    }

    public void setStart_time(double start_time) {
        this.start_time = start_time;
    }

    public double getStart_time() {
        return start_time;
    }

    public void setFinish_time(double finish_time) {
        this.finish_time = finish_time;
    }

    public double getFinish_time() {
        return finish_time;
    }

    public double getDuration() {
        return this.finish_time - this.start_time;
    }

    public static boolean isColorValid(String color) {
        for (int i = 0; i < color.length(); i++) {
            boolean valid = (color.charAt(i) >= '0' && color.charAt(i) <= '9')
                    || (color.charAt(i) >= 'A' && color.charAt(i) <= 'F');
            if (!valid) {
                return false;
            }
 
        }

        return true;
    }

    public void setTaskUser(User taskUser) {
        this.taskUser = taskUser;
    }

    public User getTaskUser() {
        return taskUser;
    }
}