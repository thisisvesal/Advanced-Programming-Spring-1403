package Questions;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LongAnswer extends Question {
    public LongAnswer(String prompt) {
        super(prompt);
    }

    public LongAnswer() {
        super();
    }

    @Override
    public void designAnswerSheet() {
        answerSheet.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        answerSheet.setOpaque(false);

        JTextArea answerField = new JTextArea();
        answerField.setFont(new Font(getFont().getName(), Font.PLAIN, 20));
        answerField.setPreferredSize(new Dimension(890, 450));
        answerField.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(answerField);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        answerSheet.add(scroll);
        answerSheet.add(submitButton);
    }
}