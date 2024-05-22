package Frames;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Questions.Question;

public class QuestionPage extends GeneralPage {
    private static QuestionPage instance;
    public final JPanel questionPanel = new JPanel();
    public JLabel examIcon = new JLabel();
    public Object[][] answers = new Object[60][];

    private QuestionPage() {
        super();
        questionPanel.setPreferredSize(new Dimension(950, 795));
        questionPanel.setOpaque(false);
        questionPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        questionPanel.setBackground(MainFrame.themeColor);
        this.add(questionPanel);
    }

    public void addQuestion(Question question) {
        questionPanel.add(question);
    }

    public static QuestionPage getInstance() {
        if (instance == null) {
            instance = new QuestionPage();
        }
        return instance;
    }
}