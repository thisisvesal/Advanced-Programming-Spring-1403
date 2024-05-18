package Questions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Frames.MainFrame;
import People.Person;
import People.Student;

public abstract class Question extends JPanel {
    public final JTextField promptPane = new JTextField();
    public final JPanel answerSheet = new JPanel();
    JLabel prompt;

    public Question(String prompt, HomeWork homeWork) {
        if (Person.getCurrentUser() instanceof Student) {
            promptPane.setEnabled(false);
        }
        
        setPrompt(prompt);
        this.prompt.setFont(new Font("Tahoma", Font.PLAIN, 30));

        answerSheet.setBackground(Color.white);
        answerSheet.setPreferredSize(new Dimension(910, 520));
        designAnswerSheet();
    
        promptPane.setBackground(Color.white);
        promptPane.setPreferredSize(new Dimension(910, 170));
        promptPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20 , 10));
        promptPane.add(this.prompt);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        this.setPreferredSize(new Dimension(945, 780));
        this.setBackground(MainFrame.themeColor);
        this.add(promptPane);
        this.add(answerSheet);
    }

    public Question(HomeWork homeWork) {
        this("", homeWork);
    }

    public Question(String prompt, Exam exam) {
        setPrompt(prompt);
        this.prompt.setFont(new Font("Tahoma", Font.PLAIN, 30));

        answerSheet.setBackground(Color.white);
        answerSheet.setPreferredSize(new Dimension(910, 520));
        designAnswerSheet();
    
        promptPane.setBackground(Color.white);
        promptPane.setPreferredSize(new Dimension(910, 170));
        promptPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20 , 10));
        promptPane.add(this.prompt);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        this.setPreferredSize(new Dimension(945, 780));
        this.setBackground(MainFrame.themeColor);
        this.add(promptPane);
        this.add(answerSheet);
    }

    public Question(Exam exam) {
        this("", exam);
    }

    public abstract void designAnswerSheet();

    public void setPrompt(String prompt) {
        this.prompt = new JLabel(prompt);
    }
}