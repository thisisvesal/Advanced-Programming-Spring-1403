package Frames;

import People.Officials;
import People.Person;
import People.Professor;
import People.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPage extends JPanel {
    private static SignupPage instance;
    JTextField[] field = new JTextField[10];
    String[] menu = new String[] { "Name", "lastname", "Field of study", "EducationalID", "Phone number", "Email",
            "UserName", "Password", "Repeat the password" };
    boolean TheProfessor = false, TheStudent = false, TheOfficials = false;
    public static boolean signupSuccessful = false;

    private SignupPage() {
        this.setPreferredSize(new Dimension(1220, 800));
        this.setLayout(null);
        this.setBackground(MainFrame.themeColor);

        JPanel SignupPanel = new JPanel();
        SignupPanel.setLayout(null);
        SignupPanel.setBackground(MainFrame.themeColor);
        SignupPanel.setBounds(360, 50, 500, 700);
        this.add(SignupPanel);
        JLabel text = new JLabel();
        text.setText("Please enter the requested items ");
        text.setBounds(140, 30, 250, 30);
        SignupPanel.add(text);
        int y = 80;
        for (int i = 0; i < 9; i++) {
            field[i] = new JTextField();
            field[i].setPreferredSize(new Dimension(240, 40));
            field[i].setBounds(75, y, 350, 40);
            field[i].setFont(new Font("Consolas", Font.PLAIN, 15));
            field[i].setForeground(Color.BLACK);
            field[i].setBackground(Color.WHITE);
            field[i].setCaretColor(Color.BLACK);
            field[i].setText(menu[i]);
            SignupPanel.add(field[i]);
            y += 50;
        }

        JRadioButton Professor = new JRadioButton("Professor");
        Professor.setFont(new Font("Arial", Font.PLAIN, 15));
        Professor.setBounds(110, 560, 100, 20);

        JRadioButton Student = new JRadioButton("Student");
        Student.setFont(new Font("Arial", Font.PLAIN, 15));
        Student.setBounds(210, 560, 100, 20);

        JRadioButton Officials = new JRadioButton("Officials");
        Officials.setFont(new Font("Arial", Font.PLAIN, 15));
        Officials.setBounds(310, 560, 100, 20);

        ButtonGroup group = new ButtonGroup();
        group.add(Professor);
        group.add(Student);
        group.add(Officials);

        SignupPanel.add(Professor);
        SignupPanel.add(Student);
        SignupPanel.add(Officials);

        Professor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TheProfessor = true;
                TheStudent = false;
                TheOfficials = false;
            }
        });
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TheStudent = true;
                TheProfessor = false;
                TheOfficials = false;
            }
        });
        Officials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TheOfficials = true;
                TheStudent = false;
                TheProfessor = false;
            }
        });

        JButton submit = new JButton();
        submit.setText("Submit");
        submit.setBounds(210, 600, 80, 80);
        SignupPanel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field[7].getText().equals(field[8].getText())) {
                    JOptionPane.showOptionDialog(MainFrame.getMainFrame(), "Cheek your password!", "Warning",
                            JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
                } else if (!TheProfessor && !TheStudent && !TheOfficials) {
                    JOptionPane.showOptionDialog(MainFrame.getMainFrame(), "Enter your role!", "Warning",
                            JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");

                } else {
                    Person user;
                    if (TheProfessor)
                        user = new Professor(field[0].getText(), field[1].getText(), field[2].getText(), field[3].getText(),
                                field[4].getText(), field[5].getText(), field[6].getText(), field[7].getText());
                    else if (TheStudent)
                        user = new Student(field[0].getText(), field[1].getText(), field[2].getText(), field[3].getText(),
                                field[4].getText(), field[5].getText(), field[6].getText(), field[7].getText());
                    else
                        user = new Officials(field[0].getText(), field[1].getText(), field[2].getText(), field[3].getText(),
                                field[4].getText(), field[5].getText(), field[6].getText(), field[7].getText());
                    if (signupSuccessful) {
                        Person.addPerson(user);
                        JOptionPane.showOptionDialog(MainFrame.getMainFrame(), "You were signed up successfully", "Success",
                            JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
                        signupSuccessful = false;
                        SignupPage.getInstance().setVisible(false);
                        LoginPage.getInstance().setVisible(true);
                    }
                }
            }
        });

        this.setVisible(true);
    }

    public static SignupPage getInstance() {
        if (instance == null) {
            instance = new SignupPage();
        }
        return instance;
    }
}
