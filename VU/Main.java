import javax.swing.JButton;

import Frames.*;
import People.Person;
import People.Professor;
import People.Student;

public class Main {
  public static void main(String[] args) {
    // Sample user
    Person jane = new Student("Jane", "Doe", "Donuts", "4021234567", "09000000000", "jane@doe.do", "janedoe", "janedoe1");
    jane.classList.add(new JButton("Math"));
    Person.addPerson(jane);
    Person ginna = new Professor("ginna", "Doe", "Donuts", "402123", "09000000001", "ginna@doe.do", "ginnadoe", "ginnadoe1");
    ginna.classList.add(new JButton("Math"));
    Person.addPerson(ginna);
    
    // Initializing the mainframe
    MainFrame.getMainFrame();

  }
}
