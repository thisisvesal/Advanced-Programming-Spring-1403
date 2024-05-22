package Questions;

import Clock.ClockCountdown;
import Frames.ExamPage;
import Frames.MainFrame;
import Frames.QuestionPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class Exam extends JPanel {
    public final ArrayList<Question> questions = new ArrayList<>();
    private JPanel examStatus, deadLine, scoreStatus, courseName;
    public JLabel examIcon, status, score, Name;
    public Object[][] answers = new Object[60][];

    public Exam(Course course) {
        this.setPreferredSize(new Dimension(940, 790));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(MainFrame.themeColor);
        this.setOpaque(true);

        this.examIcon = new JLabel();
        this.examIcon.setIcon(new ImageIcon("src/icons/quiz.png"));
        this.examIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                MainFrame.getMainFrame().coursePage.setVisible(false);
                MainFrame.getMainFrame().homeWorkPage.setVisible(true);
                // MainFrame.getMainFrame().examPage.setVisible(true);
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

        examStatus = new JPanel();
        examStatus.setPreferredSize(new Dimension(600, 50));
        examStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        status = new JLabel();
        status.setText("Status: Not uploaded");
        examStatus.add(status);
        this.add(examStatus);

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
                ExamPage.getInstance().setVisible(false);
                MainFrame.getMainFrame().add(QuestionPage.getInstance());
                QuestionPage.getInstance().setVisible(true);
            }
        });

        this.add(viewQuestionsButton, BorderLayout.CENTER);
        course.addExam(this);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        QuestionPage.getInstance().addQuestion(question);
    }
}