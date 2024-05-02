package Frames;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private static MainFrame mainFrame;
    public static final Color themeColor = new Color(22, 192, 226);
    public final HomePage homePage = HomePage.getInstance();
    public final LoginPage loginPage = LoginPage.getInstance();
    public final SignupPage signupPage = SignupPage.getInstance();
    public final CardLayout layout = new CardLayout();

    private MainFrame() {
        ImageIcon appIcon = new ImageIcon("icons/appIcon.png");
        this.setTitle("Virtual Education");
        this.setIconImage(appIcon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1220, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(layout);
        this.add(loginPage);
        this.add(signupPage);
        this.add(homePage);

        loginPage.setVisible(true);
        signupPage.setVisible(false);
        homePage.setVisible(false);

        this.setVisible(true);
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }
}
