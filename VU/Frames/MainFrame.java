package Frames;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private static MainFrame mainFrame;
    public static final Color themeColor = new Color(22, 192, 226);
    public final HomePage homePage = HomePage.getInstance();
    public final LoginPage loginPage = LoginPage.getInstance();
    public final SignupPage signupPage = SignupPage.getInstance();
    public final CardLayout layout = new CardLayout();
    public final CoursePage coursePage = CoursePage.getInstance();
    public final HomeWorkPage homeWorkPage = HomeWorkPage.getInstance();
    public final QuestionPage questionPage = QuestionPage.getInstance();
    public final ExamPage examPage = ExamPage.getInstance();
    private JPanel[] pages = {HomePage.getInstance(), LoginPage.getInstance(), SignupPage.getInstance(), CoursePage.getInstance(), HomeWorkPage.getInstance(), QuestionPage.getInstance()};

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

        for (JPanel page : pages) {
            this.add(page);
            page.setVisible(false);
        }

        loginPage.setVisible(true);

        this.setVisible(true);
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }
}