package Questions;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class MultipleChoice extends Question {
    public final ArrayList<JRadioButton> options = new ArrayList<>();
    private final ButtonGroup bg = new ButtonGroup();

    public MultipleChoice(String prompt, HomeWork homeWork) {
        super(prompt, homeWork);
    }
    public MultipleChoice(HomeWork homeWork) {
        super(homeWork);
    }
    public MultipleChoice(String prompt, Exam exam) {
        super(prompt, exam);
    }
    public MultipleChoice(Exam exam) {
        super(exam);
    }

    public void addOption(String option) {
        JRadioButton newOption = new JRadioButton(option);
        // newOption.setFocusable(false);
        newOption.setFont(new Font(newOption.getFont().getName(), Font.PLAIN, 20));
        newOption.setPreferredSize(new Dimension(60, 50));
        // newOption.setIcon(new ImageIcon("icons/checkboxes/unchecked.png"));
        // newOption.setSelectedIcon(new ImageIcon("icons/checkboxes/checked.png"));
        // newOption.setOpaque(false);


        bg.add(newOption);
        options.add(newOption);
        this.answerSheet.add(newOption);

    }

    @Override
    public void designAnswerSheet() {
        // this.answerSheet.setLayout(new Flow);
    }
}