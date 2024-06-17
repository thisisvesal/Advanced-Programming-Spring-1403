package Frames;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.*;

import FileHandling.SaveLoadUtility;

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
    private JPanel[] pages = { HomePage.getInstance(), LoginPage.getInstance(), SignupPage.getInstance(),
            CoursePage.getInstance(), HomeWorkPage.getInstance(), QuestionPage.getInstance() };

    private MainFrame() {
        System.out.println("Making MainFrame");
        ImageIcon appIcon = new ImageIcon("src/icons/appIcon.png");
        this.setTitle("Virtual Education");
        this.setIconImage(appIcon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setSize(1220, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(layout);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                    MainFrame.this,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                System.out.println("Pop up an optionpage for exit confirmation");

                if (response == JOptionPane.YES_OPTION) {
                    try {
                        SaveLoadUtility.writePeople();
                    } catch (IOException ioe) {
                        System.out.println("\nFailed to write people\n");
                        System.out.println(ioe.getCause());
                    }
                    System.exit(0);
                }
            }

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    SaveLoadUtility.readPeople();
                } catch (Exception ioe) {
                    System.out.println("\nFailed to read people\n");
                    System.out.println(ioe.getCause());
                }
            }
        });

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

    public static JPanel deepCopyPanel(JPanel original) {
        JPanel copy = new JPanel();
        copyProperties(original, copy);
        copyComponents(original, copy);
        System.out.println("Copied a panel");
        return copy;
    }

    private static void copyProperties(JComponent original, JComponent copy) {
        copy.setPreferredSize(original.getPreferredSize());
        copy.setForeground(original.getForeground());
        copy.setBackground(original.getBackground());
        copy.setFont(original.getFont());
        copy.setOpaque(original.isOpaque());
        copy.setBorder(original.getBorder());
        copy.setLayout(original.getLayout());
    }

    private static void copyComponents(Container original, Container copy) {
        ButtonGroup bg = new ButtonGroup();
        for (Component component : original.getComponents()) {
            if (component instanceof JPanel) {
                JPanel originalPanel = (JPanel) component;
                JPanel copiedPanel = deepCopyPanel(originalPanel);
                copy.add(copiedPanel);
            } else if (component instanceof JLabel) {
                JLabel originalLabel = (JLabel) component;
                JLabel copiedLabel = new JLabel(originalLabel.getText());
                copyProperties(originalLabel, copiedLabel);
                copy.add(copiedLabel);
            } else if (component instanceof JRadioButton) {
                JRadioButton originalLabel = (JRadioButton) component;
                JRadioButton copiedRadio = new JRadioButton(originalLabel.getText());
                copyProperties(originalLabel, copiedRadio);
                bg.add(copiedRadio);
                copy.add(copiedRadio);
            } else if (component instanceof JScrollPane) {
                JTextArea textArea = new JTextArea(7, 13);
                textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, 20));
                textArea.setEditable(true);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                copy.add(scrollPane);
            }
        }
    }

}
