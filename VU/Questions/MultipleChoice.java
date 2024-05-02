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

    public MultipleChoice(String prompt) {
        super(prompt);
    }
    public MultipleChoice() {
        super();
    }
    public void addOption(String option) {
        JRadioButton newOption = new JRadioButton(option);
        newOption.setFocusable(false);
        newOption.setFont(new Font(newOption.getFont().getName(), Font.PLAIN, 20));
        newOption.setPreferredSize(new Dimension(870, 50));
        newOption.setIcon(new ImageIcon("icons/checkboxes/unchecked.png"));
        newOption.setSelectedIcon(new ImageIcon("icons/checkboxes/checked.png"));
        newOption.setOpaque(false);

        bg.add(newOption);
        options.add(newOption);
        this.answerSheet.add(newOption);
    }

    @Override
    public void designAnswerSheet() {
        // this.answerSheet.setLayout(new Flow);
    }
}
