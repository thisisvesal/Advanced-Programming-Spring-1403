import Frames.*;
import People.Professor;
import People.Student;

public class Main {
    public static void main(String[] args) {
        // Sample user
        new Student("Jane", "Doe", "Donuts", "4021234567", "09000000000", "jane@doe.do", "h",
                "1");

        new Professor("ginna", "Doe", "Donuts", "402123",
                "09000000001", "ginna@doe.do", "hh",
                "11");

        // Initializing the mainframe
        MainFrame.getMainFrame();

    }
}