package Questions;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LongAnswer extends Question {

    public LongAnswer(String prompt, HomeWork homeWork) {
        super(prompt, homeWork);
    }
    public LongAnswer(HomeWork homeWork) {
        super(homeWork);
    }
    public LongAnswer(String prompt, Exam exam) {
        super(prompt, exam);
    }
    public LongAnswer(Exam exam) {
        super(exam);
    }

    @Override
    public void designAnswerSheet() {
        answerSheet.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        answerSheet.setOpaque(false);

        JTextArea textArea = new JTextArea(17, 49);
        textArea.setFont(new Font(getFont().getName(), Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        answerSheet.add(scrollPane);
        answerSheet.add(submitButton);
    }
}