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
        // Sample user
        Person jane = new Student("Jane", "Doe", "Donuts", "4021234567", "09000000000", "jane@doe.do", "h",
                "1");

        Person ginna = new Professor("ginna", "Doe", "Donuts", "402123",
                "09000000001", "ginna@doe.do", "hh",
                "11");

        // Initializing the mainframe
        MainFrame mainFrame = MainFrame.getMainFrame();
      /*  Course math = new Course();
        HomeWork h = new HomeWork(math);
        Question q = new LongAnswer("How u doin?", h);

        h.addQuestion(q);

        JButton mathButton = new JButton("Math");
        mathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.homePage.setVisible(false);
                mainFrame.coursePage.setVisible(true);
            }
        });*/

      //  jane.classList.add(mathButton);
       // ginna.classList.add(mathButton);

    }
}