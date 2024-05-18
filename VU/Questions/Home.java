package Questions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Frames.*;

import Graphics.ButtonLayout;
import People.Person;

public class Home extends GeneralPage {
    // To be added from left to right
    public final JPanel classList = new JPanel();
    public final JPanel taskPanel = new JPanel();
    public final GridBagConstraints constraints = new GridBagConstraints();


    public Home(Person person) {
        super();
        classList.setBackground(MainFrame.themeColor);
        classList.setPreferredSize(new Dimension(470, 790));
        classList.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.LEADING));

        classList.add(new JLabel("CLASS LIST"));

        taskPanel.setBackground(MainFrame.themeColor);
        taskPanel.setPreferredSize(new Dimension(470, 790));

        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        this.add(classList);
        this.add(taskPanel);
        this.setBackground(Color.white);

        setUpPageFor(Person.getCurrentUser());
        HomePage.getInstance().add(this);
    }

    public void setUpPageFor(Person person) {
        setUpGeneralPanelFor(person);
        // sample checkbox:
        person.taskBoxes.add(new JCheckBox("Your task"));
        for (JCheckBox taskBox : person.taskBoxes) {
            taskBox.setFocusable(false);
            taskBox.setBackground(Color.white);
            taskBox.setOpaque(true);
            taskBox.setIcon(new ImageIcon("icons/checkboxes/unchecked.png"));
            taskBox.setSelectedIcon(new ImageIcon("icons/checkboxes/checked.png"));
            taskBox.setFont(new Font(getFont().getName(), Font.PLAIN, 20));
            taskPanel.add(taskBox);
        }
        for (JButton button : person.classList) {
            button.setBackground(Color.white);
            button.setFocusable(false);
            classList.add(button);
        }
    }
}