package Test;

import Activity.ToDo;
import Activity.Task;
import Activity.Habit;
import App.Application;

public class Test {    
    public static void main(String[] args) {        
    ToDo t1 = new ToDo();
    Task t2 = new Task();
    Habit t3 = new Habit();
    // t1.setColor("ABC123");
    // t2.setColor("ABC123");
    // t3.setFinishTime();
    System.out.println(t1.getInfo());
    System.out.println(t2.getInfo());
    Application app = new Application();
    app.addUser("test1", "password 1");
    app.addUser("test2", "password 2");
    System.out.println(app.getUserByName("test1").length);

    }
}
