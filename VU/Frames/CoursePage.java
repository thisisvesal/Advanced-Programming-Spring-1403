package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clock.ClockPane;
import Questions.Course;

public class CoursePage extends JPanel {
    private static CoursePage instance;
    JPanel generalPanel, announcementPanel;
    public final JPanel coursePanel = new JPanel(new CardLayout());
    private Course currentVisibleCourse;

    private CoursePage() {
        super();
        this.setPreferredSize(new Dimension(1220, 800));
        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        generalPanel = new JPanel();
        generalPanel.add(new ClockPane());
        announcementPanel = new JPanel();
        announcementPanel.setPreferredSize(new Dimension(244, 640));
        announcementPanel.setBackground(MainFrame.themeColor);
        generalPanel.add(announcementPanel);

        JButton homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(244, 60));
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.white);
        generalPanel.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().coursePage.setVisible(false);
                MainFrame.getMainFrame().homePage.setVisible(true);
            }
        });
        generalPanel.setOpaque(false);
        generalPanel.setPreferredSize(new Dimension(244, 800));
        this.add(generalPanel);

        // this.setUpGeneralPanelFor(Person.getCurrentUser());
        coursePanel.setPreferredSize(new Dimension(950, 795));
        coursePanel.setOpaque(false);
        coursePanel.setLayout(new CardLayout());
        coursePanel.setBackground(MainFrame.themeColor);
        
        this.add(coursePanel);
    }

    public static CoursePage getInstance() {
        if (instance == null) {
            instance = new CoursePage();
        }
        return instance;
    }

    public void addCourse(Course course) {
        this.coursePanel.add(course);
    }

    public void setCurrentVisibleCourse(Course course) {
        if (currentVisibleCourse != null) {
            this.currentVisibleCourse.setVisible(false);
        }
        this.currentVisibleCourse = course;
        course.setVisible(true);
    }

    public Course getCurrentVisibleCourse() {
        return currentVisibleCourse;
    }

}
