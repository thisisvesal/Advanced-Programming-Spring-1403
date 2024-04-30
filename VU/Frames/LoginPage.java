package Frames;

import People.Person;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JPanel {
    private static LoginPage instance;
    public static boolean ForgetPass = false;

    private LoginPage() {
        this.setPreferredSize(new Dimension(1220, 800));
        this.setLayout(null);
        this.setBackground(MainFrame.themeColor);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setBounds(410, 210, 400, 380);

        PlaceholderTextField UserName = new PlaceholderTextField("");
        UserName.setPreferredSize(new Dimension(240, 40));
        UserName.setBounds(30, 40, 340, 40);
        UserName.setFont(new Font("Consolas", Font.PLAIN, 15));
        UserName.setForeground(Color.BLACK);
        UserName.setBackground(Color.WHITE);
        UserName.setCaretColor(Color.BLACK);
        UserName.setPlaceholder("Username");
        loginPanel.add(UserName);

        PlaceholderTextField Password = new PlaceholderTextField("");
        Password.setPreferredSize(new Dimension(240, 40));
        Password.setBounds(30, 100, 340, 40);
        Password.setFont(new Font("Consolas", Font.PLAIN, 15));
        Password.setForeground(Color.BLACK);
        Password.setBackground(Color.WHITE);
        Password.setCaretColor(Color.BLACK);
        Password.setPlaceholder("Password");
        loginPanel.add(Password);

        JLabel ForgetPassLabel = new JLabel();
        ForgetPassLabel.setText("Forget Password?");
        ForgetPassLabel.setBounds(30, 160, 200, 20);
        loginPanel.add(ForgetPassLabel);
        ForgetPassLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!ForgetPass) {
                    JOptionPane.showOptionDialog(LoginPage.getInstance(), "Enter educational ID correctly !", "Warning",
                            JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
                }
            }
        });

        JLabel loginLabel = new JLabel();
        loginLabel.setIcon(new ImageIcon("icons/login.png"));
        loginLabel.setBounds(150, 200, 100, 100);
        loginPanel.add(loginLabel);

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Password.setEditable(false);
                // UserName.setEditable(false);
                if (Person.personExists(UserName.getText(), Password.getText())) {
                    Person user = Person.findPerson(UserName.getText(), Password.getText());
                    Person.setCurrentUser(user);
                    
                    HomePage.getInstance().setUpHomePageFor(user);

                    LoginPage.getInstance().setVisible(false);
                    HomePage.getInstance().setVisible(true);
                }
            }
        });

        JLabel question = new JLabel();
        question.setText("Not a Member?");
        question.setBounds(120, 310, 100, 20);
        loginPanel.add(question);

        JLabel Signup = new JLabel();
        Signup.setForeground(Color.BLUE);
        Signup.setText("Signup");
        Signup.setBounds(240, 310, 100, 20);
        loginPanel.add(Signup);

        Signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                // LoginPage.getInstance().setVisible(false);
                // SignupPage.getInstance();
                // MainFrame.getMainFrame().layout.show(MainFrame.getMainFrame(), "signup");
                MainFrame.getMainFrame().loginPage.setVisible(false);
                MainFrame.getMainFrame().signupPage.setVisible(true);

            }
        });
        this.add(loginPanel);

    }

    public static LoginPage getInstance() {
        if (instance == null) {
            instance = new LoginPage();
        }
        return instance;
    }

}
