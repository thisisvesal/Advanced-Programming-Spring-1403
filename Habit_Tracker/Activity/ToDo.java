package Activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import User.User;

public class ToDo {
    public String name;
    protected Double startTime;
    protected String color;
    protected User user;

    public void setStartTime(Double startTime) {
        if (startTime < 0) {
            System.out.println("Invalid start time");
            return;
        }
        this.startTime = startTime;
    }

    public Double getStartTime() {
        return startTime;
    }

    public String getInfo() {
        return name + "'s start time:" + startTime + "\nColor: " + color;
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

    protected void setColor(String color) {
        if (isColorValid(color)) {
            this.color = color;
        }
    }

    public String getColor() {
        return color;
    }

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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}