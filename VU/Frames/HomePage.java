package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import People.Person;
import People.Professor;

public class HomePage extends JPanel {
    private static HomePage instance;
    // To be added from left to right:
    public final JPanel generalPanel = new JPanel();
    public final JPanel classList = new JPanel();
    public final JPanel taskPanel = new JPanel();
    // General panel components, from top to bottom:
    public final JPanel profilePanel = new JPanel();
    // a ClockPane, added locally
    public final DefaultListModel<String> announcementList = new DefaultListModel<>();
    public final JList<String> announcementPanel = new JList<>(announcementList);

    public final JLabel nameLabel = new JLabel("Default name");
    public final JLabel idLabel = new JLabel("ID: " + "Default id");

    private HomePage() {
        Font labelFont = nameLabel.getFont();
        nameLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        idLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

        profilePanel.add(nameLabel);
        profilePanel.add(idLabel);
        profilePanel.setPreferredSize(new Dimension(244, 200));
        profilePanel.setBackground(MainFrame.themeColor);
        generalPanel.add(profilePanel);

        generalPanel.add(new ClockPane());

        announcementPanel.setPreferredSize(new Dimension(244, 500));
        announcementPanel.setBackground(MainFrame.themeColor);
        announcementList.addElement("This is an announcement");
        generalPanel.add(announcementPanel);

        // Test line:
        generalPanel.setBackground(Color.red);
        // Set this to true to see the whole panel shape:
        generalPanel.setOpaque(false);
        generalPanel.setPreferredSize(new Dimension(244, 800));

        classList.setBackground(MainFrame.themeColor);
        classList.setPreferredSize(new Dimension(470, 790));
        classList.add(new JLabel("CLASS LIST"));
        
        taskPanel.setBackground(MainFrame.themeColor);
        taskPanel.setPreferredSize(new Dimension(470, 790));

        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.add(generalPanel);
        this.add(classList);
        this.add(taskPanel);
        this.setBackground(Color.white);
    }

    public void setUpHomePageFor(Person person) {
        nameLabel.setText(person.getFullName());
        idLabel.setText(person.getID());

        // sample checkbox:
        person.taskBoxes.add(new JCheckBox("Your task"));
        for (JCheckBox taskBox : person.taskBoxes) {
            taskBox.setFocusable(false);
            taskBox.setOpaque(false);
            taskBox.setFont(new Font(nameLabel.getFont().getName(), Font.PLAIN, 20));
            taskPanel.add(taskBox);
        }
        for (JButton button : person.classList) {
            classList.add(button);
            if (person instanceof Professor) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((Professor)person).editClassInfo();
                    }
                });
            }
        }
    }

    // Singleton class instamce getter:
    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }
}
