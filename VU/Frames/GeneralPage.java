package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import People.Person;

public class GeneralPage extends JPanel {
    public final JPanel generalPanel = new JPanel();
    // General panel components, from top to bottom:
    public final JPanel profilePanel = new JPanel();
    // a ClockPane, added locally
    public final DefaultListModel<String> announcementList = new DefaultListModel<>();
    public final JList<String> announcementPanel = new JList<>(announcementList);
    public final JLabel nameLabel = new JLabel("Default name");
    public final JLabel idLabel = new JLabel("ID: " + "Default id");

    public GeneralPage() {
        Font labelFont = nameLabel.getFont();
        nameLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        idLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

        profilePanel.add(nameLabel);
        profilePanel.add(idLabel);
        profilePanel.setPreferredSize(new Dimension(244, 200));
        profilePanel.setBackground(MainFrame.themeColor);
        generalPanel.add(profilePanel);

        generalPanel.add(new ClockPane());

        announcementPanel.setPreferredSize(new Dimension(244, 420));
        announcementPanel.setBackground(MainFrame.themeColor);
        announcementList.addElement("This is an announcement");
        generalPanel.add(announcementPanel);

        JButton homeButton = new JButton("Home");
        homeButton.setFocusable(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JButton)e.getSource()).getParent().getParent().setVisible(false);
                HomePage.getInstance().setVisible(true);
            }
        });
        homeButton.setPreferredSize(new Dimension(244, 70));
        generalPanel.add(homeButton);

        // Test line:
        generalPanel.setBackground(Color.red);
        // Set this to true to see the whole panel shape:
        generalPanel.setOpaque(false);
        generalPanel.setPreferredSize(new Dimension(244, 800));

        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.add(generalPanel);
        this.setBackground(Color.white);
    }

    public void setUpGeneralPanelFor(Person person) {
        nameLabel.setText(person.getFullName());
        idLabel.setText(person.getID());
    }
}
