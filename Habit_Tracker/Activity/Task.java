package Activity;

import User.*;

public class Task extends ToDo {
    private double finishTime;

    public Task(String name, String color, User user) {
        this.user = user;
        this.color = color;
        setName(name);
    }

    public Task(String name, User user) {
        this(name, "65F23A", user);
    }

    public Task() {
        this("default", "65F23A", null);
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public double getFinishTime() {
        return finishTime;
    }

    public double getDuration() {
        return this.finishTime - this.startTime;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nfinish time is: " + finishTime;
    }

}