import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Frames.*;
import People.Person;
import People.Professor;
import People.Student;
import Questions.*;

public class Main {
  public static void main(String[] args) {
    JButton mathButton = new JButton("Math");
    mathButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Question q = new LongAnswer("How u doin?");
        // ((MultipleChoice)q).addOption("Fine");
        // ((MultipleChoice)q).addOption("Not fine");
        QuestionPage.getInstance().addQuestion(q);
        MainFrame.getMainFrame().add(QuestionPage.getInstance());
        HomePage.getInstance().setVisible(false);
        QuestionPage.getInstance().setVisible(true);
        q.setVisible(true);
      }
    });
    // Sample user
    Person jane = new Student("Jane", "Doe", "Donuts", "4021234567", "09000000000", "jane@doe.do", "janedoe",
        "janedoe1");
    jane.classList.add(mathButton);
    Person.addPerson(jane);
    Person ginna = new Professor("ginna", "Doe", "Donuts", "402123", "09000000001", "ginna@doe.do", "ginnadoe",
        "ginnadoe1");
    ginna.classList.add(mathButton);
    Person.addPerson(ginna);

    // Initializing the mainframe
    MainFrame.getMainFrame();

  }
}
