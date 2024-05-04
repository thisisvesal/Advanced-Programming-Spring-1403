package Questions;

import Clock.ClockCountdown;
import Frames.HomeWorkPage;
import Frames.MainFrame;
import Frames.QuestionPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class HomeWork extends JPanel {
    public final ArrayList<Question> questions = new ArrayList<>();
    private JPanel homeWorkStatus, deadLine, scoreStatus, courseName;
    public JLabel homeWorkIcon, status, score, Name;
    public Object[][] answers = new Object[60][];

    public HomeWork(Course course) {
        this.setPreferredSize(new Dimension(940, 790));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(MainFrame.themeColor);
        this.setOpaque(true);

        this.homeWorkIcon = new JLabel();
        this.homeWorkIcon.setIcon(new ImageIcon("icons/homework.png"));
        this.homeWorkIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                MainFrame.getMainFrame().coursePage.setVisible(false);
                MainFrame.getMainFrame().homeWorkPage.setVisible(true);
            }
        });

        courseName = new JPanel();
        courseName.setBackground(new Color(235, 234, 171));
        courseName.setPreferredSize(new Dimension(940, 42));

        Name = new JLabel();
        Name.setText("CourseName");
        courseName.add(Name);
        this.add(courseName);

        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(600, 50));
        box.setOpaque(false);
        this.add(box);

        homeWorkStatus = new JPanel();
        homeWorkStatus.setPreferredSize(new Dimension(600, 50));
        homeWorkStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        status = new JLabel();
        status.setText("Status: Not loaded");
        homeWorkStatus.add(status);
        this.add(homeWorkStatus);

        scoreStatus = new JPanel();
        scoreStatus.setPreferredSize(new Dimension(600, 50));
        scoreStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        score = new JLabel();

        score.setText("Score: Not graded");
        scoreStatus.add(score);
        this.add(scoreStatus);

        deadLine = new JPanel();
        deadLine.setPreferredSize(new Dimension(600, 50));
        deadLine.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel time = new JLabel();
        time.setText("Remaining time : ");
        deadLine.add(time);

        deadLine.add(ClockCountdown.getInstance());
        this.add(deadLine);

        box = new JPanel();
        box.setPreferredSize(new Dimension(600, 60));
        box.setOpaque(false);
        this.add(box);

        for (Question question : questions) {
            QuestionPage.getInstance().addQuestion(question);
        }

        JButton viewQuestionsButton = new JButton("View questions");
        viewQuestionsButton.setFocusable(false);
        viewQuestionsButton.setBackground(Color.white);
        viewQuestionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeWorkPage.getInstance().setVisible(false);
                MainFrame.getMainFrame().add(QuestionPage.getInstance());
                QuestionPage.getInstance().setVisible(true);
            }
        });

        this.add(viewQuestionsButton, BorderLayout.CENTER);
        course.addHomeWork(this);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        QuestionPage.getInstance().addQuestion(question);
    }
}
